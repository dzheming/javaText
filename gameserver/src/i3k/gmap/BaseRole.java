package i3k.gmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import i3k.SBean;
import i3k.SBean.BuffCFGS;
import i3k.gmap.BaseRole.SpiritCluster.SpiritContainer;
import i3k.gmap.Behavior.MatchTable;
import i3k.gmap.Behavior.RoleState;
import i3k.gmap.TrigerAi;
import i3k.gmap.TrigerAiCluster;
import i3k.gs.GameData;
import i3k.util.GameRandom;
import i3k.util.GVector3;

public class BaseRole
{
	BaseRole(MapServer ms, boolean serverControl)
	{
		this.ms = ms;
		this.serverControl = serverControl;
		this.lastLogicTime = ms.getMapManager().getMapLogicTime();
		trigerAiMgr = new TrigerAiMgr();
		this.timerInterval = GameData.getInstance().getCommonCFG().engine.interval;
		this.dmgRole = new ClassRole(0, 0);
	}

	BaseRole fromDB(SBean.Location location)
	{
		this.curPosition.fromVector3(location.position);
		this.curRotation.fromVector3(location.rotation);
		return this;
	}

	public void setPropBase(PropBase propBase)
	{
		this.propBase = propBase;
	}
	
	public PropBase getPropBase()
	{
		return this.propBase;
	}

	public int getID()
	{
		return id;
	}

	public int getConfigID()
	{
		return Math.abs(this.configID);
	}

	public int getEntityType()
	{
		return entityType;
	}
	
	public int getEventLowHpDmgType()
	{
		return 0;
	}
	
	byte getBWType()
	{
		return this.owner == null ? 0 : this.owner.getBWType();
	}
	
	int getForceType()
	{
		return this.owner == null ? this.forceType : this.owner.forceType;
	}
	
	public int getSectId()
	{
		return this.owner == null ? -1 : this.owner.getSectID();
	}
	
	public int getMapType()
	{
		return this.curMap == null ? 0 : this.curMap.getMapType();
	}
	
	public int getMapID()
	{
		if (this.curMap != null)
			return this.curMap.mapID;

		return this.curMapID;
	}

	public int getMapInstanceID()
	{
		if (this.curMap != null)
			return this.curMap.mapInstanceID;

		return -1;
	}

	public boolean isInPrivateMap()
	{
		return this.curMap != null && this.curMap.isPrivateMap();
	}

	public boolean isInJusticeMap()
	{
		return this.curMap != null && this.curMap.getMapType() == GameData.MAP_TYPE_MAPCOPY_JUSTICE;
	}

	boolean isInWorld()
	{
		return this.curMap == null ? false : this.curMap.getMapType() == GameData.MAP_TYPE_MAP_WORLD;
	}

	boolean filterRole()
	{
		return this.curMap == null ? false : this.curMap.filterRole();
	}
	
	boolean isInSuperArenaMap()
	{
		return this.curMap != null && this.getMapType() == GameData.MAP_TYPE_MAPCOPY_SUPERARENA;
	}
	
	void onMilliSecondTask(long logicTime)
	{
		if (this.curMap.isTimeOut() || this.curMap.isMapAlreadyFinish || this.curMap.isInPrepared(logicTime))
			return;
		
		this.onCheckSkillDuration(logicTime);
		this.onCheckSkillEnd(logicTime);
		this.checkSkill(logicTime);
		this.checkTrigerAi();
		this.onAutoFight(logicTime);
		this.checkSpecialState(logicTime);
		this.onUpdateCurBuff(logicTime);
		this.processTrigSkillDamage(logicTime);
	}

	void onAutoFight(long logicTime)
	{
		onAutoFightImpl(logicTime);
	}
	
	void onAutoFightImpl(long logicTime)
	{
		this.checkFear(logicTime);
		if (this.curFear != null)
		{
			BaseRole entity = this.getForceTarget();
			if (entity != null)
			{
				float distance = this.curPosition.distance(entity.curPosition);
				if (distance > MapManager.FEAR_MAX_RADIUS)
					this.curFear.forceSetTargetPos(entity.curPosition);
			}

			if (this.addState(Behavior.EBMOVE))
				this.processMove(logicTime);
			return;
		}

		this.refreshCurUseSkills();
		if (this.curUseSkills.size() > 0)
			this.onAutoProcessDamage(logicTime);
		
		if(!this.checkState(Behavior.EBATTACK))
		{
			if (!this.isMoving())
				this.moveToNearest(logicTime);
			else
				this.onMoving(logicTime);
		}
	}
	
	void onMoving(long logicTime)
	{
		if(!this.checkState(Behavior.EBRETREAT))
		{
			BaseRole entity = this.getRoleInCheckRange();
			if (entity != null && !entity.isDead() && !entity.isInProtectTime())
			{
				float range = this.attackRange + this.getRadius() + entity.getRadius();
				float distance = entity.getCurPosition().distance(this.getCurPosition());
				if (distance < range) //������Χ��
				{
					this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
					this.attackNearest(entity, logicTime);
					return;
				}
			}
		}
	
		this.processMove(logicTime);
	}
	
	void processMove(long logicTime)
	{
		this.updateMoveTarget();
		SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
		if (this.curPosition.distance(this.moveTargetPos) <= 5)
			this.onStopMove(this.curPosition, timeTick, true);
		else
		{
			GVector3 moveDir = this.moveTargetPos.diffence2D(this.curPosition).normalize();
			if (!moveDir.equals(this.curRotation))
			{
				this.onMoveMent((int) this.getFightProp(EPROPID_SPEED), moveDir.toVector3F(), this.curPosition, moveTargetPos, timeTick);
				this.preMoveTime = logicTime;
			}
			else
				this.updateMovePosition(logicTime);
		}
	}
	
	void moveToNearest(long logicTime)
	{
		if(checkOutRange())
			return;
		
		BaseRole entity = this.getForceTarget();
		if (entity == null || !this.checkTargetValid(entity))
			entity = this.getRoleInCheckRange();

		if (entity != null && !entity.isDead() && !entity.isInProtectTime())
		{
			float range = this.attackRange + this.getRadius() + entity.getRadius();
			float distance = entity.getCurPosition().distance(this.getCurPosition());
			if((distance - range) <= 5)
			{
				if(!this.checkState(Behavior.EBDISATTACK))
					this.attackNearest(entity, logicTime);
			}
			else
			{
				if (this.addState(Behavior.EBMOVE))	  //��һ���ƶ�ֱ�ӹ㲥
				{
					this.removeState(Behavior.EBMOVE);
					this.moveTargetPos = entity.getCurPosition();
					this.moveTarget = entity;
					this.setCurRotation(this.moveTargetPos.diffence2D(this.getCurPosition()).normalize());
					
					this.startMove(ms.getMapManager().getMapLogicTime());
				}
			}
		}
	}
	
	void attackNearest(BaseRole role, long logicTime)
	{
		if (this.isMoving())
			this.onStopMove(this.getCurPosition(), ms.getMapManager().getTimeTickDeep(), true);

		if (this.checkState(Behavior.EBATTACK))
			return;

		int ownerID = 0;
		if (role.owner != null)
			ownerID = role.owner.getID();

		if (this.curSkillID == null)
		{
			this.nextSkill();
			return;
		}

		if (this.curSkillID <= 0 || !this.onUseSkill(this.curSkillID, this.getLogicPosition(), this.getCurRotation().toVector3F(), role.getID(), role.getEntityType(), ownerID, ms.getMapManager().getTimeTickDeep()))
			this.nextSkill();
	}
	
	boolean onUseSkill(int skillID, SBean.Vector3 pos, SBean.Vector3F rotation, int targetID, int targetType, int ownerID, SBean.TimeTick timeTick)
	{
		return false;
	}
	
	long getTimeByTimeTick(SBean.TimeTick timeTick)
	{
		return timeTick.tickLine * timerInterval + timeTick.outTick;
	}

	int getTimeInterval(SBean.TimeTick startTick)
	{
		return (int) (getTimeByTimeTick(ms.getMapManager().getTimeTick()) - getTimeByTimeTick(startTick));
	}

	int getTimeInterval(SBean.TimeTick startTick, SBean.TimeTick endTick)
	{
		return (int) (getTimeByTimeTick(endTick) - getTimeByTimeTick(startTick));
	}

	public int getCurHP()
	{
		return curHP;
	}

	public int setCurHP(int curHP)
	{
		if (this.isDead())
			return 0;

		if (curHP <= 0)
		{
			this.deadTrig();
			curHP = 0;
		}
		else if (curHP > this.maxHp)
		{
			curHP = this.maxHp;
		}

		if (this.curHP != curHP)
			this.curHP = curHP;

		return this.curHP;
	}
	
	public int getMaxHP()
	{
		return this.maxHp;
	}
	
	boolean deadTrig()
	{
		if(this.isInPrivateMap())
			return false;
		
		return this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_SDEAD, 0, 0);
	}

	void notifyBuffDamage(Set<Integer> rids, int attackerType, SBean.TimeTick timeTick)
	{

	}

	void notifySelfGetDamage(Set<Integer> rids, BaseRole attacker, int ownerID, SBean.DamageResult res, int skillID, int curDamageEventID, SBean.TimeTick timeTick)
	{

	}

	void notifySelfReduce(Set<Integer> rids, int reduce)
	{

	}

//	void notifySelfBeHead(Set<Integer> rids)
//	{
//
//	}

	void onDeadHandle(int attackerType, int attackerID)
	{
		this.breakSkill();
	}

	void onGetDamageHandler(BaseRole attacker, int damage)
	{

	}

	void setDamageLimit(SBean.DamageResult res)
	{
		
	}
	
	int fixUnDeadDamage(int damage)
	{
		RoleState state = this.curStates.get(Behavior.EBUNDEAD);
		if(state != null)
		{
			if(this.curHP - damage < state.value)
				damage = this.curHP > state.value ? this.curHP - state.value : 0;
		}
		
		return damage;
	}
	
	void onGetDamage(BaseRole attacker, SBean.DamageResult res, int skillType, int skillID, int curDamageEventID)
	{
		int ownerID = attacker.getID();
		int ownerType = attacker.getEntityType();
		if (attacker.owner != null)
		{
			ownerID = attacker.owner.getID();
			ownerType = attacker.owner.getEntityType();
		}
		this.onDamageEnterRole(attacker.owner);
		
		SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
		if(!this.filterRole())
		{
			Set<Integer> rids = this.getRoleIDsNearBy(null);
			if (res.reduce > 0)		//ȫ�����ղ��ᷢdamageЭ��
				this.notifySelfReduce(rids, res.reduce);

			if (res.damage > 0 || (res.dodge == 1 && res.deflect == 1) || res.remit == 1)
				this.notifySelfGetDamage(rids, attacker, ownerID, res, skillID, curDamageEventID, timeTick);
		}
		else
		{
			Set<Integer> owners = new HashSet<>();
			if(this.owner != null)
				owners.add(this.owner.id);
			
			if(attacker.owner != null)
				owners.add(attacker.owner.id);
			
			if(res.reduce > 0 && !owners.isEmpty())
				this.notifySelfReduce(owners, res.reduce);
			
			if (res.damage > 0 || (res.dodge == 1 && res.deflect == 1) || res.remit == 1)
			{
				if(!owners.isEmpty())
					this.notifySelfGetDamage(owners, attacker, ownerID, res, skillID, curDamageEventID, timeTick);
			}
			
			if(res.damage > 0)
			{
				Set<Integer> rids = this.getRoleIDsNearBy(this.owner);
				if(attacker.owner != null)
					rids.remove(attacker.owner.id);
				this.notifyUpdateHp(rids);
			}
		}
		
		if (skillType != GameData.eSE_Buff)
		{
			this.addFightSP(GameData.FIGHTSP_TRIG_ONDAMAGE);
			this.setAttacked(true);
			this.setSummonMonsterEnmity(attacker);
			this.lastAttacker = attacker;
			if(attacker.owner != null)
			{
				this.dmgRole.roleID = attacker.owner.getID();
				this.dmgRole.classType =  attacker.getClassType();
			}

			this.onGetDamageHandler(attacker, res.damage);
			this.curStates.remove(Behavior.EBSLEEP);
			this.updateFightTime();
			
			if(res.dodge != 1 || res.deflect != 1)
			{				
				if (!GameData.getInstance().getCommonCFG().skill.invalidSkillIDs.contains(skillID))
				{
					this.trigerAiMgr.postEvent(0, 1, res.crit == 1);
					this.dmgByTrig(0, res.crit);
					this.hpDmgByTrig(res.crit);
				}
			}
			else	//����
			{
				this.dodgeTrig();
			}
		}

		if (this.isDead())
			this.onDeadHandle(ownerType, ownerID);
	}

	//�ܵ��˺�ֱ�ӡ�����˺�����
	void dmgByTrig(int buffID, int crit)
	{
		this.trigerAiMgr.aiTrig(this, buffID > 0 ? GameData.TRIG_EVENT_DMGBYCOUNT_I : GameData.TRIG_EVENT_DMGBYCOUNT_D , buffID, 0);
	}

	void hpDmgByTrig(int crit)
	{
		int hp = (int) (this.curHP * 10000.0f / this.maxHp);
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_DMGBY_HP, hp, crit);
	}

	//���ܴ���
	void dodgeTrig()
	{
		this.trigerAiMgr.postDodgeEvent();
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_DODGE, 0, 0);
	}
	
	void onUseSkillTrig(int damageType, int useType)
	{
		this.trigerAiMgr.postSkillEvevt(damageType, useType);
		this.skillCountTrig();
	}
	
	//�Ƿ�N�μ��ܴ���
	void skillCountTrig()
	{
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_SKILLCOUNT, 0, 0);
	}
	
	void onMotivateWeaponCnt(int weaponID, int type)
	{
		this.trigerAiMgr.postWeaponEvent(weaponID, type);
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_WEAPON_MOTIVATE, 0, 0);
	}
	
	void onGetBuffDamageHandler(Buff buff, int value)
	{

	}

	void onGetBuffSP(int value)
	{
		this.setCurSP(this.getCurSP() + value);
	}

	void onGetBuffDamage(Buff buff, int value)
	{
		if (value < 0)
		{
			float damageBy = (float) (1.f - this.getFightPropF(BaseRole.EPROPID_DMGBY));
			value *= damageBy;
			value += this.reduction(-value);
		}
		else
		{
			value *= (1.0 + this.getFightPropF(BaseRole.EPROPID_BEHEALGAIN)); //�����Ƽӳ�
		}

		int curHp = this.getCurHP();
		this.setCurHP(this.getCurHP() + value);
		
		if(curHp != this.getCurHP())
		{
			if(!this.filterRole())
			{
				Set<Integer> rids = this.getRoleIDsNearBy(null);
				if (value != 0)
					this.notifyBuffDamage(rids, buff.attackerType, ms.getMapManager().getTimeTickDeep());
			}
			else
			{
				if (value != 0)
				{
					Set<Integer> rids = this.getRoleIDsNearBy(this.owner);
					Set<Integer> owners = new HashSet<>();
					if(this.owner != null)
						owners.add(this.owner.id);
					
					if(buff.attackOwnerID > 0)
					{
						if(this.curMap.getRole(buff.attackOwnerID) != null)
						{
							owners.add(buff.attackOwnerID);
							rids.remove(buff.attackOwnerID);
						}
					}
						
					if(!owners.isEmpty())
						this.notifyBuffDamage(owners, buff.attackerType, ms.getMapManager().getTimeTickDeep());
					
					this.notifyUpdateHp(rids);
				}
			}
		}

		BaseRole attacker = this.getEntity(buff.attackerType, buff.attackerID, buff.attackOwnerID);
		this.onGetBuffDamageHandler(buff, value);
		if (this.isDead())
		{
			if (buff.attackOwnerID > 0)
				this.onDeadHandle(GameData.ENTITY_TYPE_PLAYER, buff.attackOwnerID);
			else
				this.onDeadHandle(buff.attackerType, buff.attackerID);
		}
		else
		{
			if (attacker != null && value < 0)
			{
				this.updateFightTime();
				this.trigerAiMgr.postEvent(buff.id, 1, false);
				this.dmgByTrig(buff.id, 0);
				if(buff.attackerType == GameData.ENTITY_TYPE_PLAYER)
				{
					this.dmgRole.roleID = buff.attackerID;
					this.dmgRole.classType = buff.attackClassType;
				}
			}
		}
	}

	void onSelfEnterNearBy(Set<Integer> rids)
	{

	}
	
	void onSelfLeaveNearBy(Set<Integer> rids, int destory)
	{

	}

	void onSelfDead(Set<Integer> rids, int killerID)
	{

	}
	
	void notifyAddBuff(Set<Integer> rids, int buffID, int realmLvl, int remainTime, SBean.TimeTick timeTick)
	{

	}

	void notifyRemoveBuff(Set<Integer> rids, int buffID, SBean.TimeTick timeTick)
	{

	}

	void notifyDispelBuff(Set<Integer> rids, int buffID, SBean.TimeTick timeTick)
	{

	}

	void notifyUpdateHp(Set<Integer> rids)
	{

	}

	void clearSummonMonster(int attackerID)
	{
		for (Monster m : this.summonMonsters)
		{
			Set<Integer> rids = m.getRoleIDsNearBy(null);
			m.onSelfDead(rids, attackerID);

			m.clearSummonMonster(attackerID);
			m.curHP = 0;
			this.curMap.delMonsterToCache(m);
		}
		this.summonMonsters.clear();
	}

	void notifyUpdateMaxHp(Set<Integer> rids)
	{

	}

	void notifySelfShiftEnd(Set<Integer> rids, int skillID, GVector3 endpos, SBean.TimeTick timeTick)
	{

	}

	void notifySelfRemoveState(int sid, SBean.TimeTick timeTick)
	{

	}
	
	void notifySelfChangeRotation()
	{
		
	}
	
//	void notifySelfSuckBlood(Set<Integer> rids)
//	{
//
//	}

	void notifySelfRushStart(Set<Integer> rids, int skillID, SBean.Vector3 endPos, SBean.TimeTick timeTick)
	{

	}
	
	//�Ǽ��ܽ���CD������ʹ�ã�
	void onRandomResetSkill()
	{
		FightSkill fSkill = this.getRandomSkill(true);
		if (fSkill == null)
			return;

		fSkill.coolDownTime = (long) (ms.getMapManager().getMapLogicTime() + (fSkill.lvlFixCfg.cool * fSkill.coolDownPercent));
		this.notifyResetSkill(fSkill.id);
	}

	void notifyResetSkill(int skillID)
	{

	}

	void onQuickCoolSkill(FightSkill fSkill, int time)
	{
		if (time == -1)
			fSkill.coolDownTime = 0;
		else
			fSkill.coolDownTime -= time;

		this.notifyQuickCoolSkill(fSkill.id, time);
	}

	void notifyQuickCoolSkill(int skillID, int time)
	{

	}

	Set<Integer> getCurEquipSkills()
	{
		return new HashSet<>(this.curSkills);
	}
	
	FightSkill getRandomSkill(boolean canUse)
	{
		long now = ms.getMapManager().getMapLogicTime();
		List<FightSkill> randomSkills = new ArrayList<>();
		for(int skillID: getCurEquipSkills())
		{
			FightSkill fSkill = this.fightSkills.get(skillID);
			if(fSkill == null)
				continue;
			
			if (fSkill.skillGroup == Skill.eSG_Skill && (canUse ? fSkill.coolDownTime < now : fSkill.coolDownTime > now) && !fSkill.itemSkill)
				randomSkills.add(fSkill);
		}

		int count = randomSkills.size();
		if (count > 0)
		{
			int rnd = GameRandom.getRandom().nextInt(count);
			return randomSkills.get(rnd);
		}

		return null;
	}

	boolean changeMapGrid(MapGrid grid)
	{
		return false;
	}

	void changePosition(int curGridX, int curGridZ, int newGridX, int newGridZ, int destory)
	{
		Set<Integer> enterRids = this.curMap.getSelfEnterRoleIDsNearby(curGridX, curGridZ, newGridX, newGridZ, this.owner, this.owner != null);
		this.onSelfEnterNearBy(enterRids);
		Set<Integer> leaveRids = this.curMap.getSelfLeaveRoleIDsNearby(curGridX, curGridZ, newGridX, newGridZ, this.owner, this.owner != null);
		this.onSelfLeaveNearBy(leaveRids, destory);
	}

	boolean isPositionError(GVector3 v1, GVector3 v2)
	{
		return v1.distance(v2) > DISTANCEERROR;
	}

	boolean isMoving()
	{
		return this.moveSpeed > 0;
	}

	boolean isInCheckRange(float distance)
	{
		return this.maxTraceRange <= 0 || distance < this.maxTraceRange || (this.owner != null && this.curMap.isFightMap());
	}

	String getName()
	{
		return "";
	}

	byte getClassType()
	{
		return this.owner == null ? 0 : (byte)this.owner.configID;
	}
	
	//����
	void addEbataunt(Buff buff, SBean.TimeTick timeTick)
	{

	}

	void removeEbataunt()
	{
		this.forceTarget = null;
	}

	void addEbFear(long endTime)
	{
		if (this.curFear == null)
		{
			this.curFear = new Fear(this.curPosition, endTime);

			this.breakSkill();
			this.moveTargetPos.reset(this.curFear.targetPos);
			this.moveSpeed = this.getFightProp(EPROPID_SPEED);
			if(this.moveSpeed > 0)
				this.startMove(ms.getMapManager().getMapLogicTime());
		}

		this.curFear.endTime = endTime;
	}

	void removeEbFear(SBean.TimeTick timeTick)
	{
		if (this.isMoving())
			this.onStopMove(this.curPosition, timeTick, true);
	}

	void startMove(long logicTime)
	{

	}

	boolean checkOutRange()
	{
		if(this.curPosition.distance(this.getBirthPosition()) > this.maxTraceRange)
		{
			if(!this.checkState(Behavior.EBRETREAT) && this.addState(Behavior.EBMOVE))
			{
				this.removeState(Behavior.EBMOVE);
				this.addState(Behavior.EBRETREAT);
				GVector3 dir = this.curPosition.diffence2D(this.getBirthPosition()).normalize();
				int radius = (int) (this.maxTraceRange * GameRandom.getRandFloat(0.9f, 1.0f));
				this.moveTargetPos = this.getRandomTargetPos(this.getBirthPosition(), dir, radius, (float) (5.f / 180.f * Math.PI / 2.f));
				this.moveTarget = null;
				this.setCurRotation(this.moveTargetPos.diffence2D(this.getCurPosition()).normalize());
				this.moveSpeed = this.getFightProp(BaseRole.EPROPID_SPEED);
				this.startMove(ms.getMapManager().getMapLogicTime());
			}
			return true;
		}
		
		return false;
	}
	
	void onTrigChildSkill(int mainSkill, int skillID)
	{
		
	}
	
	void onSelfTrigSkill(Set<Integer> rids, int skillID)
	{

	}

	void trigSkillHandler(Skill skill)
	{

	}

	BaseRole getRoleInCheckRange()
	{
		return null;
	}

	boolean trigSkill(SBean.TrigBehaviorCFGS behaviorCfg, int skillLvl, int realmLvl)
	{
		return trigSkillImpl(behaviorCfg.param1, skillLvl, realmLvl);
	}
	
	boolean trigSkillImpl(int skillID, int skillLvl, int realmLvl)
	{
		SBean.SkillCFGS skillCfg = GameData.getInstance().getSkillCFG(skillID);
		if (skillCfg == null)
			return false;

		SBean.SkillLevelCFGS skillDataCfg = GameData.getSkillLevelCFG(skillCfg, skillLvl);
		if (skillDataCfg == null)
			return false;

		Skill skill = this.createNewSkill(skillCfg.baseData.common, skillCfg.baseData.fix, skillDataCfg.fix, skillLvl, realmLvl, Skill.eSG_TriSkill, ms.getMapManager().getMapLogicTime());
		if (skill == null)
			return false;

		BaseRole target = this.getRoleInCheckRange();
		this.trigSkillAddCache.add(skill);
		if (target != null)
		{
			int range = this.calcuAttackRange(skill.baseFixCfg.scope, skill.baseCommonCfg.fixDistance) + this.getRadius() + target.getRadius();
			if (target.curPosition.distance(this.curPosition) < range)
			{
				skill.target = target;

				if (target != this)
					this.setCurRotation(target.curPosition.diffence2D(this.getCurPosition()).normalize());
			}
		}

		if (skill.baseCommonCfg.hasShowID == 1)
		{
			Set<Integer> rids = this.getRoleIDsNearBy(null);
			this.onSelfTrigSkill(rids, skillID);
		}

		this.trigSkillHandler(skill);
		return true;
	}
	
	public void onShiftStart(int skillID, int targetID, int targerType, int ownerID, GVector3 endpos, SBean.TimeTick timeTick)
	{
		Skill skill = this.getCurInUseSkill(skillID, -1);
		if (skill == null)
			return;

		BaseRole target = this.getEntity(targerType, targetID, ownerID);
		if (target == null || target.isDead() || !this.curMap.checkBaseRoleCanAttack(this, target))
			return;

		this.onShiftStartHandler(skill, target, endpos, timeTick);
	}

	public boolean onShiftStartHandler(Skill skill, BaseRole target, GVector3 endpos, SBean.TimeTick timeTick)
	{
		if (skill.shiftInfo == null)
			return false;

		if (!target.addEBShift(skill, endpos))
			return false;

		skill.shiftInfo.shiftTarget.add(target);

		Set<Integer> rids = target.getRoleIDsNearBy(null);
		target.notifySelfShiftEnd(rids, skill.id, endpos, timeTick);
		return true;
	}

	boolean addEBShift(Skill skill, GVector3 endpos)
	{
		ShiftInfo shiftInfo = skill.shiftInfo;
		if (!this.isDead() && this.getCurMapGrid() != null)
		{
			int curGridX = this.getCurMapGrid().getGridX();
			int curGridZ = this.getCurMapGrid().getGridZ();
			int newGridX = this.curMap.calcGridCoordinateX((int) endpos.x);
			int newGridZ = this.curMap.calcGridCoordinateZ((int) endpos.z);
			MapGrid newGrid = this.curMap.getGrid(newGridX, newGridZ);
			if (newGrid == null)
				return false;

			int d = shiftInfo.distance;
			if (d < 0)
				d = -d;
			float distance = this.curPosition.distance(endpos);
			if (distance > d + 150)
				return false;
			
			if(!GameData.checkRandom(shiftInfo.odds))
				return false;

			if (!this.addState(Behavior.EBSHIFT))
				return false;

			long shiftEndTime = ms.getMapManager().getMapLogicTime() + (long) (shiftInfo.distance / shiftInfo.speed * 1000);
			this.specialState.put(Behavior.EBSHIFT, shiftEndTime);
			this.curShiftSkillID = skill.id;
			this.setCurPosition(endpos);
			boolean change = this.changeMapGrid(newGrid);
			if (change)
				this.changePosition(curGridX, curGridZ, newGridX, newGridZ, 0);

			return true;
		}
		return false;
	}

	//����ʱ��
	void onCheckSkillDuration(long logicTime)
	{
		if (this.attack == null)
			return;
			
		if (this.attack.skillEndTime > logicTime)
			return;
		
		this.curStates.remove(Behavior.EBATTACK);
		if (!this.checkState(Behavior.EBATTACK) && !this.checkState(Behavior.EBDISATTACK))
		{
			if (this.attack.rushInfo != null && !this.attack.rushInfo.rushStart && this.attack.valid)
				this.adjustPos();

			this.nextSkill();
		}
		
		if(this.attack != null)
			this.notifyFinishAttack(this.attack);
//		ms.getLogger().debug("skill " + this.attack.id + " remove state attack " + this.curUseSkills.size() + " at " + logicTime + " , " + GameTime.getTimeMillis() + 
//				" at tick[" + ms.getMapManager().getTimeTick().tickLine + " , " + ms.getMapManager().getTimeTick().outTick + "]");
		this.attack = null;
	}

	void onEndSkillHandle(Skill skill)
	{
//		if (skill.baseCommonCfg.canAttack == 0)
//			this.curStates.remove(Behavior.EBDISATTACK);
	}

	void notifyEndSkill(Skill skill)
	{
		if(!skill.childern.isEmpty())
		{
			for(Skill s: skill.childern)
				this.notifyEndSkill(s);
		}
	}
	
	void notifyFinishAttack(Skill skill)
	{
		
	}
	
	void notifyBreakSkill()
	{
		
	}
	
	void onCheckSkillEnd(long logicTime)
	{
		this.refreshCurUseSkills();
		if(this.curUseSkills.isEmpty())
			return;
		
		Iterator<Skill> it = this.curUseSkills.iterator();
		while (it.hasNext())
		{
			Skill skill = it.next();
			if (skill.flyInfo != null)
			{
				long skillStartTime = skill.skillEndTime - skill.skillDuration;
				if (logicTime > skillStartTime + skill.flyInfo.maxTime)
				{
					this.onEndSkillHandle(skill);
					it.remove();
				}
			}
		}
	}

	void checkSkill(long logicTime)
	{
		this.refreshCurUseSkills();
		if(this.curUseSkills.isEmpty() && this.attack == null)
			return;
		
		Set<Skill> inUseSkills = new HashSet<>(this.curUseSkills);
		this.refreshFollowSkills();
		inUseSkills.addAll(this.followSkills.values());
		if (this.attack != null)
			inUseSkills.add(this.attack);
		
		for (Skill skill : inUseSkills)
		{
			long skillStartTime = skill.skillEndTime - skill.skillDuration;
			int time = skill.baseCommonCfg.spell.time + skill.baseCommonCfg.charge.time;
			if (logicTime > skillStartTime + (long) time && skill.valid)
			{
				if (skill.flyInfo != null)
					this.checkFlySkill(logicTime, skill);

				if (skill.rushInfo != null)
					this.checkRushSkill(logicTime, skill);

				if (skill.shiftInfo != null)
					this.useSkillShift(skill);

				if (skill.auraInfo != null)
					this.checkAuraSkill(logicTime, skill);
				
				if(skill.summonInfo != null)
					this.checkSummonSkill(logicTime, skill);
					
			}

			this.checkChiledSkill(logicTime, skill);
		}
	}

	void checkChiledSkill(long logicTime, Skill skill)
	{
		if(skill.childern.isEmpty())
			return;
		
		Iterator<Skill> it = skill.childern.iterator();
		SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
		while (it.hasNext())
		{
			Skill childSkill = it.next();
			long skillStartTime = skill.skillEndTime - skill.skillDuration;
			int time = childSkill.baseCommonCfg.spell.time + childSkill.baseCommonCfg.charge.time;
			if (logicTime > skillStartTime + (long) time && skill.valid)
			{
				if (childSkill.flyInfo != null)
					this.checkFlySkill(logicTime, childSkill);

				if (childSkill.rushInfo != null)
					this.checkRushSkill(logicTime, childSkill);

				if (childSkill.shiftInfo != null)
					this.useSkillShift(childSkill);
			}

			this.checkChiledSkill(logicTime, childSkill);
			if (!childSkill.autoProcessDamage(this, logicTime, timeTick))
			{
				it.remove();
				this.notifyEndSkill(childSkill);
			}
		}
	}

	void checkFlySkill(long logicTime, Skill skill)
	{
		if (skill.target != null && !skill.target.isDead() && !skill.touchTarget && logicTime > skill.flyInfo.preFlyTime)
		{
			long skillStartTime = skill.skillEndTime - skill.skillDuration;

			if (logicTime > skillStartTime + skill.flyInfo.maxTime)
				return;
			{
				float distance = skill.flyInfo.speed * (logicTime - skill.flyInfo.preFlyTime) / 1000.0f;
				skill.flyInfo.preFlyTime = logicTime;
				GVector3 dir = skill.target.curPosition.diffence2D(skill.curPosition).normalize();
				skill.curPosition.selfSum(dir.scale(distance));
			}

			if (skill.curPosition.distance(skill.target.curPosition) <= MapManager.COLLISION_POSITION_OFFSET)
			{
				skill.touchTarget = true;
				for (SBean.SkillEventCFGS event : skill.lvlFixCfg.events)
				{
					int triTime = event.triTime;
					if (triTime > 0 && logicTime >= skillStartTime + triTime)
						skill.onProcessDamageHandler(this, skill.curDamageEventID, this.getCurRotation(), ms.getMapManager().getTimeTickDeep());
					skill.curDamageEventID++;
				}
			}
		}
	}

	void checkRushSkill(long logicTime, Skill skill)
	{
		this.updateRushPos(logicTime, skill);

		if(skill.rushInfo == null)
			return;
		
		if (!skill.rushInfo.rushStart)
		{
			this.onRushStartFromMap(skill);
			skill.rushInfo.rushStart = true;
			skill.rushInfo.preUpdateTime = logicTime;
		}

		if (skill.rushInfo.rushStart && logicTime > skill.rushInfo.rushEndTime)
			this.onRushEndFromMap(skill);
	}

	void updateRushPos(long logicTime, Skill skill)
	{
		if (skill.rushInfo == null || !skill.rushInfo.rushStart)
			return;

		float distance = skill.rushInfo.speed * (logicTime - skill.rushInfo.preUpdateTime) / 1000.f;
		GVector3 pos = this.curPosition.sum(skill.rushInfo.rushRotation.scale(distance));
		this.fixNewPosition(skill.rushInfo.rushRotation, pos, skill.rushInfo.rushEndPos);
		int newGridX = this.curMap.calcGridCoordinateX((int) pos.x);
		int newGridZ = this.curMap.calcGridCoordinateZ((int) pos.z);
		MapGrid newGrid = this.curMap.getGrid(newGridX, newGridZ);
		if (newGrid != null && this.getCurMapGrid() != null)
		{
			skill.rushInfo.preUpdateTime = logicTime;
			this.setCurPosition(pos);
//			ms.getLogger().info("update rush pos rotation " + this.curRotation + " rushRotation " + skill.rushInfo.rushRotation + " pos " + pos + " distance " + distance);
			if (this.curPosition.distance(skill.rushInfo.rushEndPos) < 5)
				this.onRushEndFromMap(skill);

			int curGridX = this.getCurMapGrid().getGridX();
			int curGridZ = this.getCurMapGrid().getGridZ();
			boolean change = this.changeMapGrid(newGrid);
			if (change)
				this.changePosition(curGridX, curGridZ, newGridX, newGridZ, 0);
		}
	}

	boolean checkAuraTargetValid(MapRole owner, BaseRole entity)
	{
		if(owner == null || entity.owner == null)
			return true;
		
		return owner.isNearByRoles(entity.owner.id) || owner.id == entity.owner.id;
	}
	
	void checkSummonSkill(long logicTime, Skill skill)
	{
		if(skill.summonInfo.type == GameData.SUMMON_TYPE_MONSTER)
		{
			SBean.MonsterCFGS mc = GameData.getInstance().getMonsterCFGS(skill.summonInfo.mid);
			if(mc == null)
				return;
			
			int count = this.getSummonMonsterCountByID(skill.summonInfo.mid);
			if(skill.summonInfo.maxCount > 0 && count >= skill.summonInfo.maxCount)
				return;
			
			int need = skill.summonInfo.maxCount - count;
			for (int i = 0; i < need; i++)
			{
				GVector3 newPos = this.createPosition(this.curPosition, skill.summonInfo.radius);
				Monster monster = this.curMap.createMonster(skill.summonInfo.mid, newPos, GVector3.randomRotation(), true, -1, -1);
				if(monster != null)
				{
					monster.caller = this;
					if (this.owner != null)
						monster.owner = this.owner;
					this.summonMonsters.add(monster);
				}
			}
		}
		else if(skill.summonInfo.type == GameData.SUMMON_TYPE_SKILL)
		{
//			skill.skillSpeed = skill.summonInfo.speed;
			this.fixSpecialParam(skill, GameData.SKILL_SPECIAL_SUMMON);
			this.createSkillEntity(skill.summonInfo, skill.level, skill.realmLvl, logicTime);
		}
		
		skill.summonInfo = null;
	}
	
	void checkAuraSkill(long logicTime, Skill skill)
	{
		if (logicTime > skill.auraInfo.endTime)
			return;

		float distance = 0;
		Iterator<BaseRole> it = skill.auraInfo.effectEntitys.iterator();
		while (it.hasNext())
		{
			BaseRole entity = it.next();
			distance = entity.curPosition.distance(this.curPosition);
			if (distance > skill.auraInfo.radius + AuraInfo.AURA_OFFSET)
			{
				entity.removeBuff(skill.auraInfo.buff);
				it.remove();
			}
		}

		List<BaseRole> entitys = new ArrayList<>();
		if (skill.auraInfo.type == GameData.AURA_TARGET_OWNER)
		{
			entitys = this.getRoleFriendEntityNearBy(this.owner);
			entitys.add(this.owner);

		}
		else if (skill.auraInfo.type == GameData.AURA_TARGET_ENEMY)
		{
			entitys = this.getEnemiesNearBy();
		}

		for (BaseRole entity : entitys)
		{
			if (skill.auraInfo.effectEntitys.contains(entity))
				continue;

			if(!checkAuraTargetValid(this.owner, entity))
				continue;
			
			distance = entity.curPosition.distance(this.curPosition);
			if (distance < skill.auraInfo.radius + AuraInfo.AURA_OFFSET)
			{
				entity.buffsAddCache.add(skill.auraInfo.buff);
				skill.auraInfo.effectEntitys.add(entity);
			}
		}
	}

	void onRushStartFromMap(Skill skill)
	{
		Set<Integer> rids = this.getRoleIDsNearBy(null);
		this.notifySelfRushStart(rids, skill.id, skill.rushInfo.rushEndPos.toVector3(), ms.getMapManager().getTimeTickDeep());
	}

	void onRushEndFromMap(Skill skill)
	{
		if (skill.rushInfo == null)
			return;

		this.setCurPosition(skill.rushInfo.rushEndPos);
		skill.rushInfo = null;
	}

	//����ʩչʱ����
	void useSkillShift(Skill skill)
	{
		if (skill.shiftInfo == null || skill.shiftInfo.type != GameData.SHIFT_TYPE_ONUSESKILL)
			return;

		SBean.TimeTick tickTime = ms.getMapManager().getTimeTickDeep();
		List<BaseRole> targets = this.getTargets(skill);
		for (BaseRole target : targets)
			this.onShiftStartHandler(skill, target, this.createShiftEndPos(target, skill.shiftInfo), tickTime);

		skill.shiftInfo = null;
	}

	//����˺�ʱ����
	void processDamageShift(Skill skill, BaseRole target)
	{
		if (skill.shiftInfo == null)
			return;

		if (skill.shiftInfo.type != GameData.SHIFT_TYPE_ONGETDAMAGEF && skill.shiftInfo.type != GameData.SHIFT_TYPE_ONGETDAMAGER)
			return;

		this.onShiftStartHandler(skill, target, this.createShiftEndPos(target, skill.shiftInfo), ms.getMapManager().getTimeTickDeep());
	}

	void checkSpecialState(long logicTime)
	{
		Iterator<Map.Entry<Integer, Long>> it = this.specialState.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<Integer, Long> e = it.next();
			int stateID = e.getKey();
			Long endTime = e.getValue();
			if (logicTime > endTime)
			{
				this.removeState(stateID);
				it.remove();
			}
		}
	}

	private GVector3 createShiftEndPos(BaseRole target, ShiftInfo shiftInfo)
	{
		float dist = target.curPosition.distance(this.curPosition);
		float dist1 = dist;
		float dist2 = Math.abs(shiftInfo.distance);
		dist1 = Math.min(dist1, dist2);
		float fix = Skill.SHIFT_DISTANCE_FIX1 + GameRandom.getRandom().nextInt(Skill.SHIFT_DISTANCE_FIX2);
		int forward = shiftInfo.distance > 0 ? 1 : -1;
		
		GVector3 dir = target.curPosition.diffence2D(this.curPosition).normalize();
		float distance = 0;
		switch (shiftInfo.type)
		{
		case GameData.SHIFT_TYPE_ONGETDAMAGEF:
			distance = shiftInfo.distance * forward;
			break;
		case GameData.SHIFT_TYPE_ONUSESKILL:
			dir.reset(this.curRotation);
			distance = ((dist2 - dist1) + fix) * forward;
			break;
		case GameData.SHIFT_TYPE_ONGETDAMAGER:
			if(dist > fix)
				distance = Math.min(dist + fix * forward, dist2) * forward;
			break;
		default:
			break;
		}
		
		return this.curMap.fixPos(target.curPosition.sum(dir.scale(distance)), target);
	}

	void setCurSP(int sp)
	{

	}

	void processDamageUseSkill(Skill skill, BaseRole target)
	{
		if (skill.dmgToSkillInfo == null)
			return;

		int skillID = skill.dmgToSkillInfo.skillID;
		int skillLvl = skill.dmgToSkillInfo.skillLvl;
		SBean.SkillCFGS sCfg = GameData.getInstance().getSkillCFG(skillID);
		if (sCfg == null)
			return;

		SBean.SkillLevelCFGS skillDataCfg = GameData.getSkillLevelCFG(sCfg, skillLvl);
		if (skillDataCfg == null)
			return;

		int realmLvl = this.getSkillRealmLevel(sCfg.baseData.common.relateSKill);
		Skill newSkill = this.createNewSkill(sCfg.baseData.common, sCfg.baseData.fix, skillDataCfg.fix, skillLvl, realmLvl, Skill.eSG_TriSkill, ms.getMapManager().getMapLogicTime());
		if (newSkill != null)
		{
			this.trigSkillAddCache.add(newSkill);
			if (skill.dmgToSkillInfo.positionType == GameData.POSITION_TYPE_TARGET)
				newSkill.attackPosition = new GVector3().reset(target.curPosition);
			else if (skill.dmgToSkillInfo.positionType == GameData.POSITION_TYPE_OWNER)
				newSkill.attackPosition = new GVector3().reset(this.curPosition);
			
			if (newSkill.baseCommonCfg.hasShowID == 1)
			{
				Set<Integer> rids = this.getRoleIDsNearBy(null);
				this.onSelfTrigSkill(rids, skillID);
			}
		}
	}

	void processTrigSkillDamage(long logicTime)
	{
		this.refreshTrigSkills();
		if(this.trigSkills.isEmpty())
			return;
		
		SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
		Iterator<Skill> it = this.trigSkills.iterator();
		while (it.hasNext())
		{
			Skill skill = it.next();
			if (!skill.autoProcessDamage(this, logicTime, timeTick))
			{
				it.remove();
				if (skill.baseCommonCfg.hasShowID == 1)
					this.notifyEndSkill(skill);
			}
		}
	}

	boolean isInProtectTime()
	{
		return this.checkState(Behavior.EBREVIVE);
	}
	
	//�Ƿ��޵�
	boolean isInvincible()
	{
		return this.checkState(Behavior.EBINVINCIBLE);
	}

	void clearAllSkillsCD()
	{
		for (FightSkill skill : this.fightSkills.values())
			skill.coolDownTime = 0;
	}

	void clearAllBuff()
	{
		//�����е�ͼ������buff�����������˵
		for (Buff b : this.buffs.values())
		{
			if (b.spiritEffectID == 0)
			{
				//ms.getRPCManager().dispelRoleBuff(this.getID(), b.id);
				this.removeBuff(b);
			}
		}
	}

	boolean checkHasRoleNearBy(int size, int distance)
	{
		if (this.curMap == null || this.curMapGrid == null)
			return false;

		int curGridX = this.curMapGrid.getGridX();
		int curGridZ = this.curMapGrid.getGridZ();

		return this.curMap.checkHasRoleNearBy(curGridX, curGridZ, this, size, distance);
	}
	
	void filterEnterDatail(Set<Integer> nearbyRoles, List<SBean.EnterDetail> enters)
	{
		if(!this.filterRole())
			return;
		
		Iterator<SBean.EnterDetail> it = enters.iterator();
		while(it.hasNext())
		{
			SBean.EnterDetail e = it.next();
			if(!nearbyRoles.contains(e.base.ownerID))
				it.remove();
		}
	}
	
	void filterEnterPet(Set<Integer> nearbyRoles, List<SBean.EnterPet> enters)
	{
		if(!this.filterRole())
			return;
		
		Iterator<SBean.EnterPet> it = enters.iterator();
		while(it.hasNext())
		{
			SBean.EnterPet e = it.next();
			if(!nearbyRoles.contains(e.base.ownerID))
				it.remove();
		}
	}
	
	void filterEnterSkillEntity(Set<Integer> nearbyRoles, List<SBean.EnterSkillEntity> enters)
	{
		if(!this.filterRole())
			return;
		
		Iterator<SBean.EnterSkillEntity> it = enters.iterator();
		while(it.hasNext())
		{
			SBean.EnterSkillEntity e = it.next();
			if(!nearbyRoles.contains(e.base.ownerID))
				it.remove();
		}
	}
	
	void onDamageEnterRole(MapRole attacker)
	{
		
	}
	
	void filterTarget(List<BaseRole> targets, Set<Integer> nearbyRoles)
	{
		if(!this.filterRole())
			return;
		
		Iterator<BaseRole> it = targets.iterator();
		while(it.hasNext())
		{
			BaseRole r = it.next();
			if(r.owner == null || r.getEntityType() == GameData.ENTITY_TYPE_ESCORTCAR)
				continue;
			
			if(r.owner != this.owner && !nearbyRoles.contains(r.owner.id) && (r.owner.mulRoleInfo.leader == 0 || !nearbyRoles.contains(r.owner.mulRoleInfo.leader)))
				it.remove();
		}
	}
	
	List<MapRole> getRoleNearBy(MapRole role)
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getRoleNearBy(curGridX, curGridZ, role, this.owner != null);
	}

	Set<Integer> getRoleIDsNearBy(MapRole role)
	{
		if(this.curMap == null)
			return new HashSet<>();
		
		if(this.isInPrivateMap())
			return this.curMap.getRoleIDsNearBy(0, 0, role, false);
		
		if(this.getCurMapGrid() == null)
			return new HashSet<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getRoleIDsNearBy(curGridX, curGridZ, role, this.owner != null);
	}
	
	List<BaseRole> getRoleFriendEntityNearBy(MapRole role)
	{
		if(this.isInPrivateMap() || this.curMap == null || role == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getRoleFriendEntityNearBy(curGridX, curGridZ, role);
	}

	List<BaseRole> getRoleFriendEntityNearBy(MapRole role, int distance)
	{
		if(this.isInPrivateMap() || this.curMap == null || role == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		if (distance > 0)
			return this.curMap.getRoleFriendEntityNearBy(curGridX, curGridZ, role, distance);
		else
			return this.curMap.getRoleFriendEntityNearBy(curGridX, curGridZ, role);

	}

	List<BaseRole> getEnemiesNearBy()
	{
		List<BaseRole> enemies = new ArrayList<>();
		this.getPlayerEnemiesNearBy().stream().filter(e -> this.curMap.checkBaseRoleCanAttack(this, e)).forEach(e -> enemies.add(e));
		this.getMonsterNearBy().stream().filter(m -> this.curMap.checkBaseRoleCanAttack(this, m)).forEach(m -> enemies.add(m));
//		enemies.addAll(this.getMonsterNearBy());
		return enemies;
	}

	List<Pet> getPetNearBy()
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getPetNearBy(curGridX, curGridZ);
	}

	List<Monster> getMonsterNearBy()
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getMonsterNearBy(curGridX, curGridZ);
	}

	List<Trap> getTrapNearBy()
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getTrapNearBy(curGridX, curGridZ);
	}

	List<Blur> getBlurNearBy()
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getBlurNearBy(curGridX, curGridZ);
	}
	
	List<BaseRole> getPlayerEnemiesNearBy()
	{
		if(this.isInPrivateMap() || this.curMap == null || this.getCurMapGrid() == null)
			return new ArrayList<>();
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		return this.curMap.getPlayerEnemiesNearBy(curGridX, curGridZ, this.owner);
	}
	
	BaseRole getPlayerEntity()
	{
		BaseRole entity = null;
		entity = this.getNearestMapRole(this.getRoleNearBy(this.owner));
		if (entity == null)
			entity = this.getNearestPet(this.getPetNearBy());

		if (entity == null)
			entity = this.getNearestBlur(this.getBlurNearBy());

		if (entity == null && this.owner != null)
			entity = this.getNearestMonster(this.getMonsterNearBy());

		return entity;
	}

	MapRole getNearestMapRole(List<MapRole> roles)
	{
		MapRole entity = null;
		float minDistance = GameData.MAX_NUMBER;
		float distance = 0;
		for (MapRole r : roles)
		{
			if (!r.isDead() && !r.isInProtectTime())
			{
				if (this.curMap.checkBaseRoleCanAttack(this, r))
				{
					distance = r.getCurPosition().distance(this.getCurPosition());
					if (distance < minDistance && this.isInCheckRange(distance))
					{
						minDistance = distance;
						entity = r;
					}
				}
			}
		}
		return entity;
	}

	Pet getNearestPet(List<Pet> pets)
	{
		Pet entity = null;
		float minDistance = GameData.MAX_NUMBER;
		float distance = 0;
		for (Pet p : pets)
		{
			if (!p.isDead() && !p.isInProtectTime())
			{
				if (this.curMap.checkBaseRoleCanAttack(this, p))
				{
					distance = p.getCurPosition().distance(this.getCurPosition());
					if (distance < minDistance && this.isInCheckRange(distance))
					{
						minDistance = distance;
						entity = p;
					}
				}
			}
		}
		return entity;
	}
	
	Blur getNearestBlur(List<Blur> blurs)
	{
		Blur entity = null;
		float minDistance = GameData.MAX_NUMBER;
		float distance = 0;
		for (Blur b : blurs)
		{
			if (!b.isDead() && !b.isInProtectTime() && this.curMap.checkBaseRoleCanAttack(this, b))
			{
				distance = b.getCurPosition().distance(this.getCurPosition());
				if (distance < minDistance && this.isInCheckRange(distance))
				{
					minDistance = distance;
					entity = b;
				}
			}
		}
		return entity;
	}
	
	BaseRole getNearestMonster(List<Monster> monsters)
	{
		Monster entity = null;
		float minDistance = GameData.MAX_NUMBER;
		float distance = 0;
		for (Monster m : monsters)
		{
			if (!m.isDead() && !m.isInProtectTime() && !m.isInvincible() && this.curMap.checkBaseRoleCanAttack(this, m))
			{
				distance = m.getCurPosition().distance(this.getCurPosition());
				if (distance < minDistance && this.isInCheckRange(distance))
				{
					minDistance = distance;
					entity = m;
				}
			}
		}
		return entity;
	}

	BaseRole getNearestTrap(List<Trap> traps)
	{
		Trap entity = null;
		float minDistance = GameData.MAX_NUMBER;
		float distance = 0;
		for (Trap t : traps)
		{
			if (!t.isDead())
			{
				distance = this.curPosition.distance(t.curPosition);
				if (distance < minDistance && this.isInCheckRange(distance))
				{
					minDistance = distance;
					entity = t;
				}
			}
		}
		return entity;
	}

	List<MapRole> getTeamMemberNearBy(MapRole role, float distance)
	{
		List<MapRole> memberNearBy = new ArrayList<>();
		boolean ignoreDistance = this.curMap.ignoreTeamMemberDistance();
		for (int roleID : role.getTeamMember())
		{
			if (roleID == role.id)
				continue;

			MapRole r = this.curMap.getRole(roleID);
			if (r != null && r.active && r != role && (ignoreDistance || r.getCurPosition().distance(role.getCurPosition()) <= distance))
				memberNearBy.add(r);
		}

		return memberNearBy;
	}

	List<MapRole> getTeamMemberSameMap(MapRole role)
	{
		List<MapRole> memberNearBy = new ArrayList<>();
		List<Integer> members = role.getTeamMember();

		for (int roleID : members)
		{
			if (roleID == role.id)
				continue;

			MapRole r = this.curMap.getRole(roleID);
			if (r != null && r != role)
				memberNearBy.add(r);
		}

		return memberNearBy;
	}

	public boolean updateMaxHp()
	{
		int newMaxHp = this.getFightProp(EPROPID_MAXHP);
		if (newMaxHp != this.maxHp)
		{
			this.maxHp = newMaxHp;
			return true;
		}
		return false;
	}

	public int getMaxSP()
	{
		return this.getFightProp(EPROPID_MAXSP);
	}

	void setRadius(int radius)
	{
		this.radius = radius;
	}

	int getRadius()
	{
		return this.radius;
	}

	public BaseMap getCurMap()
	{
		return curMap;
	}

	public void setCurMap(BaseMap curMap)
	{
		this.curMap = curMap;
	}

	public MapGrid getCurMapGrid()
	{
		return curMapGrid;
	}

	public void setCurMapGrid(MapGrid curMapGrid)
	{
		this.curMapGrid = curMapGrid;
	}

	public GVector3 getCurPosition()
	{
		return curPosition;
	}

	GVector3 getBirthPosition()
	{
		return this.caller == null ? this.birthPosition : this.caller.curPosition;
	}

	public void setCurPosition(GVector3 curPosition)
	{
		this.curPosition.reset(curPosition);
	}

	public GVector3 getCurRotation()
	{
		return curRotation;
	}

	public void setCurRotation(GVector3 curRotation)
	{
		if (curRotation.nearly2DZero())
			return;
		this.curRotation.reset(curRotation.normalize());
	}

	public float getRotationAngle()
	{
		return this.curRotation.projectXZAngleX();
	}

	public SBean.Vector3 getLogicPosition()
	{
		return this.curPosition.toVector3();
	}

	public GVector3 createPosition(int radius)
	{
		float angle = (float) (GameRandom.getRandom().nextFloat() * Math.PI * 2.0f);
		GVector3 pos = new GVector3((float) (radius * Math.cos(angle)), 0.0f, (float) (radius * Math.sin(angle)));
		pos = this.getCurPosition().sum(pos);

		return this.curMap.fixPos(pos, this);
	}
	
	public GVector3 createPosition(int radius, float angle)
	{
		GVector3 pos = new GVector3((float) (radius * Math.cos(angle)), 0.0f, (float) (radius * Math.sin(angle)));
		pos = this.getCurPosition().sum(pos);

		return this.curMap.fixPos(pos, this);
	}
	
	public GVector3 createPosition(GVector3 position, int radius)
	{
		float angle = (float) (GameRandom.getRandom().nextFloat() * Math.PI * 2.0f);
		GVector3 pos = new GVector3((float) (radius * Math.cos(angle)), 0.0f, (float) (radius * Math.sin(angle)));
		pos = position.sum(pos);

		return this.curMap.fixPos(pos, this);
	}

	GVector3 getRandomTargetPos(GVector3 pos, GVector3 dir, float radius, float rot)
	{
		float radian = dir.projectXZAngleX();
		//		float radian1 = GameRandom.getRandFloat(radian - rot, radian + rot);
		radian += GameRandom.getRandFloat(-rot, rot);
		radian += GameRandom.getRandFloat(-rot, rot);
		GVector3 tar = pos.sum(this.vec3FMul2(radian, radius, radius));
		return this.curMap.fixPos(tar, this);
	}

	void createSkillEntity(SummonInfo summon, int skillLvl, int skillRealmLvl, long createTime)
	{
		
	}
	
	Skill createNewSkill(SBean.SkillBaseCommonCFGS baseCommon, SBean.SkillBaseFixCFGS baseFix, SBean.SkillLevelFixCFGS lvlFixCfg, int skillLvl, int skillRealmLvl, int skillGroup, long createTime)
	{
		int skillID = baseCommon.id;
		SBean.SkillLevelFixCFGS lvlFix = lvlFixCfg.kdClone();
		Skill skill = new Skill(skillID, skillLvl, skillRealmLvl, skillGroup, createTime + baseFix.duration, this.curPosition, baseCommon, baseFix, lvlFix, this);
		//spiritfix
		this.fixBaseSkill(skill);
		this.fixSubDamage(skill);
		
		for (Integer specialID : baseCommon.specialIDs)
		{
			SBean.SkillSpecialCFGS special = GameData.getInstance().getSkillSpecialCFG(specialID);
			if (special == null)
				continue;

			switch (special.formulaID)
			{
			case GameData.SKILL_SPECIAL_GUIDE:
				skill.guideInfo = new GuideInfo(special.param1, special.param2, special.param3, special.param4, special.param5, special.param6 == 1);
				this.fixSpecialParam(skill, GameData.SKILL_SPECIAL_GUIDE);
				skill.damageCount = skill.guideInfo.damageCount;
				break;
			case GameData.SKILL_SPECIAL_FLY_SKILL:
				skill.flyInfo = new FlyInfo(special.param1, special.param2, special.param5, skill.skillEndTime - baseFix.duration + baseCommon.spell.time + baseCommon.charge.time);
				skill.attackPosition = new GVector3().reset(this.curPosition);
				break;
			case GameData.SKILL_SPECIAL_SUMMON:
				skill.summonInfo = new SummonInfo(special.param1, special.param2, special.param3, special.param4, special.param5, special.param7, special.param8);
				break;
			case GameData.SKILL_SPECIAL_SHIFT:
				skill.shiftInfo = new ShiftInfo(special.param1, special.param2, special.param4, special.param5);
				this.fixSpecialParam(skill, GameData.SKILL_SPECIAL_SHIFT);
				break;
			case GameData.SKILL_SPECIAL_STARGER:
				skill.triSkillTarget = special.param1;
				break;
			case GameData.SKILL_SPECIAL_PDAM_USESKILL:
				int slvl = special.param2 == -1 ? skill.level : special.param2;
				skill.dmgToSkillInfo = new DmgToSkillInfo(special.param1, slvl, special.param3);
				break;
			case GameData.SKILL_SPECIAL_FIX_DAMVALUE:
				skill.dmgFixInfo = new DmgFixInfo(special.param1, special.param2, special.param3, special.param4, special.param5, special.param6, special.param7);
				break;
			case GameData.SKILL_SPECIAL_RUSH:
				skill.rushInfo = new RushInfo(special.param1, special.param2, special.param4, 0, new GVector3(), new GVector3());
				this.fixSpecialParam(skill, GameData.SKILL_SPECIAL_RUSH);

				skill.rushInfo.rushEndPos = this.createRushEndPos(this.curPosition, skill.rushInfo.distance);
				skill.rushInfo.rushRotation = skill.rushInfo.rushEndPos.diffence2D(this.curPosition).normalize();
				float distance = this.curPosition.distance(skill.rushInfo.rushEndPos);
				skill.rushInfo.rushEndTime = (createTime + skill.baseCommonCfg.spell.time + skill.baseCommonCfg.charge.time + (long) (getArcLength(distance, special.param2) / special.param4 * 1000.0f) + 3 * timerInterval);
				skill.attackPosition = new GVector3().reset(this.curPosition);
				break;
			case GameData.SKILL_SPECIAL_AURA:
				SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(special.param5);
				if (buffCfg == null)
					break;

				float value = 0.f;
				int realmAdd = 0;
				int realmLvl = 0;
				if (buffCfg.valueType == GameData.VALUE_TYPE_FIXED)
					value = buffCfg.affectValue * (1 + realmAdd);
				else
					value = buffCfg.affectValue;

				skill.auraInfo = new AuraInfo(special.param1, special.param2, special.param3, createTime + (long) special.param4, 
						new Buff(-1, buffCfg.id, realmLvl, createTime, 1, (int) value, this.getEntityType(), this.id, this.owner == null ? 0 : this.owner.id, 
								this.getName(), this.getClassType(), 0, false, buffCfg.hasShowID == 1));
				this.fixSpecialParam(skill, GameData.SKILL_SPECIAL_AURA);
				skill.auraInfo.buff.endTime = skill.auraInfo.endTime;
				break;
			case GameData.SKILL_SPECIAL_DMGADDHP:
				skill.dmgAddHp = special.param1 / 10_000.f;
				break;
			case GameData.SKILL_SPECIAL_OMNISLASH:
				skill.slashInfo = new SlashInfo(special.param1, special.param2);
				skill.damageCount = skill.slashInfo.damageCount;
				break;
			case GameData.SKILL_SPECIAL_MAXHPDMG:
				skill.maxHpDMG = special.param1 / 10_000.f;
				break;
			case GameData.SKILL_SPECIAL_EXTRA_DROP:
				if (skill.dropInfo == null)
					skill.dropInfo = new ExtraDropInfo(special.param1, new ArrayList<>(), special.param3, special.param4, special.param5);
				if (special.param2 != 0)
					skill.dropInfo.monsterId.add(special.param2);
				break;
			default:
				break;
			}
		}

		for (int child : baseCommon.children)
		{
			SBean.SkillCFGS cSkillCfg = GameData.getInstance().getSkillCFG(child);
			if (cSkillCfg == null)
				continue;

			SBean.SkillLevelCFGS cSkillData = GameData.getSkillLevelCFG(cSkillCfg, skillLvl);
			if (cSkillData == null)
				continue;

			int realmLvl = this.getSkillRealmLevel(cSkillCfg.baseData.common.relateSKill);
			
			this.onTrigChildSkill(skillID, child);
			Skill childSkill = this.createNewSkill(cSkillCfg.baseData.common, cSkillCfg.baseData.fix, cSkillData.fix, skillLvl, realmLvl, Skill.eSG_TriSkill, createTime);
			skill.childern.add(childSkill);
		}

		return skill;
	}
	
	static float getArcLength(float distance, float high)
	{
		if(high == 0)
			return distance;
		
		float r = ((distance / 2.f) * (distance / 2.f) + (high * high)) / (2.f * high);
		float angle = (float) Math.asin((distance / 2.f) / r);
		return (2 * angle * r);
	}
	
	float getFixValue(int type, float oldValue, float value)
	{
		switch (type)
		{
		case GameData.FIX_VALUE_TYPE_PLUS:
			oldValue += value;
			break;
//		case GameData.FIX_VALUE_TYPE_MULT:
//			oldValue *= value;
//			break;
		case GameData.FIX_VALUE_TYPE_REPLACE:
			oldValue = value;
			break;
		default:
			break;
		}
		return oldValue;
	}

	SpiritCluster getNormalSpirit(int type)
	{
		return this.allSpirits.get(type);
	}
	
	SpiritCluster getHorseSpirit(int type)
	{
		return this.horseSkillSpirits.get(type);
	}
	
	void fixBaseSkill(Skill skill)
	{
		SpiritCluster scluster = this.getNormalSpirit(GameData.SPIRIT_EFFECT_FIXBASESKILL);
		if (scluster != null)
			this.fixBaseSkillImp(scluster, skill);
		
		SpiritCluster hcluster = this.getHorseSpirit(GameData.SPIRIT_EFFECT_FIXBASESKILL);
		if(hcluster != null)
			this.fixBaseSkillImp(hcluster, skill);
			
	}
	
	void fixBaseSkillImp(SpiritCluster cluster, Skill skill)
	{
		SpiritContainer container = cluster.containers.get(skill.id);
		if (container == null)
			return;

		for (SBean.SpiritEffectCFGS cfg : container.spiritEffects.values())
		{
			switch (cfg.param2)
			{
			case GameData.FIX_BASESKILL_DURATION:
				skill.skillDuration = (int) this.getFixValue(cfg.param3, skill.baseFixCfg.duration, cfg.param4);
				break;
			case GameData.FIX_BASESKILL_COOLDOWN:
				skill.lvlFixCfg.cool = (int) this.getFixValue(cfg.param3, skill.lvlFixCfg.cool, cfg.param4);
				break;
			default:
				break;
			}
		}
	}
	
	void fixSpecialParam(Skill skill, int specialType)
	{
		SpiritCluster scluster = this.getNormalSpirit(GameData.SPIRIT_EFFECT_FIXBASESKILL);
		if (scluster != null)
			this.fixSpecialParamImp(scluster, skill, specialType);
			
		SpiritCluster hcluster = this.getHorseSpirit(GameData.SPIRIT_EFFECT_FIXBASESKILL);
		if(hcluster != null)
			this.fixSpecialParamImp(hcluster, skill, specialType);
	}
	
	void fixSpecialParamImp(SpiritCluster cluster, Skill skill, int specialType)
	{
		SpiritContainer container = cluster.containers.get(skill.id);
		if (container == null)
			return;

		for (SBean.SpiritEffectCFGS cfg : container.spiritEffects.values())
		{
			switch (cfg.param2)
			{
			case GameData.FIX_BASESKILL_RUSHDISTANCE:
				if (skill.rushInfo != null && specialType == GameData.SKILL_SPECIAL_RUSH)
					skill.rushInfo.distance = (int) this.getFixValue(cfg.param3, skill.rushInfo.distance, cfg.param4);
				break;
			case GameData.FIX_BASESKILL_SHIFTODDS:
				if (skill.shiftInfo != null && specialType == GameData.SKILL_SPECIAL_SHIFT)
					skill.shiftInfo.odds = (int) this.getFixValue(cfg.param3, skill.shiftInfo.odds, cfg.param4);
				break;
			case GameData.FIX_BASESKILL_GUIDETIME:
				if (skill.guideInfo != null && specialType == GameData.SKILL_SPECIAL_GUIDE)
				{
					skill.guideInfo.duration = (int) this.getFixValue(cfg.param3, skill.guideInfo.duration, cfg.param4);
					if (skill.guideInfo.type == GameData.GUIDE_SKILL_BYTIME)
						skill.guideInfo.damageCount = (int) Math.ceil((float) skill.guideInfo.duration / (float) skill.guideInfo.interval);
				}
				break;
			case GameData.FIX_BASESKILL_AURAINFO:
				if (skill.auraInfo != null && specialType == GameData.SKILL_SPECIAL_AURA)
				{
					long now = ms.getMapManager().getMapLogicTime();
					int duration = (int) (skill.auraInfo.endTime - now);
					skill.auraInfo.endTime = now + (long) this.getFixValue(cfg.param3, duration, cfg.param4);
				}
				break;
			case GameData.FIX_BASESKILL_SKILLSPEED:
				if (specialType == GameData.SKILL_SPECIAL_SUMMON && skill.summonInfo != null)
					skill.summonInfo.speed = (int) this.getFixValue(cfg.param3, skill.summonInfo.speed, cfg.param4);
				break;
			default:
				break;
			}
		}
	}
	
	void fixSubDamage(Skill skill)
	{
		SpiritCluster scluster = this.getNormalSpirit(GameData.SPIRIT_EFFECT_FIXSUBDAMAGE);
		if (scluster != null)
			this.fixSubDamageImp(scluster, skill);

		SpiritCluster hcluster = this.getHorseSpirit(GameData.SPIRIT_EFFECT_FIXSUBDAMAGE);
		if(hcluster != null)
			this.fixSubDamageImp(hcluster, skill);
	}
	
	void fixSubDamageImp(SpiritCluster cluster, Skill skill)
	{
		SpiritContainer container = cluster.containers.get(skill.id);
		if (container == null)
			return;

		for (SBean.SpiritEffectCFGS cfg : container.spiritEffects.values())
		{
			int eventID = cfg.param2;
			SBean.SkillEventCFGS event = skill.lvlFixCfg.events.get(eventID);
			switch (cfg.param3)
			{
			case GameData.FIX_SUBDAMAGE_TRIGTIME:
				event.triTime = (int) this.getFixValue(cfg.param4, event.triTime, cfg.param5);
				break;
			case GameData.FIX_SUBDAMAGE_ODDS:
				event.damage.odds = (int) this.getFixValue(cfg.param4, event.damage.odds, cfg.param5);
				break;
			case GameData.FIX_SUBDAMAGE_MULT:
				event.damage.arg1 = this.getFixValue(cfg.param4, event.damage.arg1, cfg.param5/10000.f);
				break;
			case GameData.FIX_SUBDAMAGE_PLUS:
				event.damage.arg2 = this.getFixValue(cfg.param4, event.damage.arg2 , cfg.param5);
				break;
			case GameData.FIX_SUBDAMAGE_STATUS1:
			{
				if (event.status.size() > 0)
				{
					SBean.SubStatus status = event.status.get(0);
					status.odds = (int) this.getFixValue(cfg.param4, status.odds, cfg.param5);
				}
			}
				break;
			case GameData.FIX_SUBDAMAGE_STATUS2:
			{
				if (event.status.size() > 1)
				{
					SBean.SubStatus status = event.status.get(1);
					status.odds = (int) this.getFixValue(cfg.param4, status.odds, cfg.param5);
				}
			}
				break;
			default:
				break;
			}
		}
	}
	
	GVector3 createRushEndPos(GVector3 startPos, float distance)
	{
		//		float distance = special.param2;
		GVector3 endPos = startPos.sum(this.curRotation.scale(distance));
		this.curMap.fixPos(endPos, this);
		return endPos;
	}

	public Skill getCurInUseSkill(int skillID, int damageTick)
	{
		this.refreshCurUseSkills();
		for (Skill skill : this.curUseSkills)
		{
			if (skill.id == skillID && (skill.damageTick == damageTick || damageTick == -1))
				return skill;
		}

		if(this.attack != null && this.attack.id == skillID && (this.attack.damageTick == damageTick || damageTick == -1))
			return this.attack;
			
		this.refreshFollowSkills();
		for (Skill skill : this.followSkills.values())
		{
			if (skill.id == skillID)
				return skill;
		}
		return null;
	}

	public BaseRole getForceTarget()
	{
		if (this.forceTarget == null)
			return null;
		
		BaseRole entity = this.getEntity(this.forceTarget.entityType, this.forceTarget.entityID, this.forceTarget.ownerID);
		if(entity != null && entity.isDead())
			return null;
		
		return entity;
	}

	BaseRole getEntity(int entityType, int entityID, int ownerID)
	{
		BaseRole entity = null;
		switch (entityType)
		{
		case GameData.ENTITY_TYPE_PLAYER:
			entity = this.curMap.getRole(entityID);
			break;
		case GameData.ENTITY_TYPE_PET:
			PetCluster cluster = this.curMap.mapPetCluster.get(ownerID);
			if (cluster != null)
				entity = cluster.pets.get(entityID);
			break;
		case GameData.ENTITY_TYPE_BLUR:
			entity = this.curMap.getBlur(entityID);
			break;
		case GameData.ENTITY_TYPE_MONSTER:
			entity = this.curMap.getMonster(entityID);
			break;
		case GameData.ENTITY_TYPE_TRAP:
			entity = this.curMap.getTrap(entityID);
			break;
		case GameData.ENTITY_TYPE_MINERAL:
			entity = this.curMap.getMineral(entityID);
			break;
		case GameData.ENTITY_TYPE_MAPBUFF:
			entity = this.curMap.getMapBuff(entityID);
			break;
		case GameData.ENTITY_TYPE_ESCORTCAR:
			entity = this.curMap.getEscortCar(entityID);
			break;
		case GameData.ENTITY_TYPE_SKILL:
			entity = this.curMap.getSkillEntity(entityID);
			break;
		default:
			break;
		}

		return entity;
	}

	boolean checkTargetValid(BaseRole target)
	{
		return !(target.isDead() || target.isInProtectTime() || !target.active || target.curMap == null || (target.getMapID() != this.getMapID() && target.getMapInstanceID() != this.getMapInstanceID()));
	}

	boolean checkCanBeAttack(BaseRole attacker)
	{
		return true;
	}
	
	int getMonsterSpawnRole()
	{
		return 0;
	}
	
	boolean randMoveTarget()
	{
		return false;
	}
	
	void updateMoveTarget()
	{
		if (this.moveTarget != null)
		{
			if (!this.checkTargetValid(this.moveTarget))
				this.moveTarget = null;
			else
			{
				float d = this.moveTarget.curPosition.distance(this.moveTargetRealPos);
				if (d > MapManager.TARGET_POSITION_OFFSET)
				{
					float distance = this.moveTarget.curPosition.distance(this.curPosition);
					float range = this.attackRange + this.getRadius() + this.moveTarget.getRadius();
					GVector3 dir = this.curPosition.diffence2D(this.moveTarget.curPosition).normalize();
					this.moveTargetRealPos.reset(this.moveTarget.curPosition);
					if (!randMoveTarget())
						this.moveTargetPos.reset(this.moveTarget.curPosition);
					else if (distance - range < range / 4.f)
						this.moveTargetPos = this.moveTarget.curPosition.sum(dir.scale(range));
					else
						this.moveTargetPos = this.getRandomTargetPos(this.moveTarget.curPosition, dir, range, GameData.getInstance().getPathAngel(range));

					this.setCurRotation(this.moveTargetPos.diffence2D(this.getCurPosition()).normalize());
				}
			}
		}
	}

	void fixNewPosition(GVector3 dir, GVector3 newPos, GVector3 tarPos)
	{
		if (dir.x > 0)
		{
			if (newPos.x > tarPos.x)
				newPos.x = tarPos.x;
		}
		else
		{
			if (newPos.x < tarPos.x)
				newPos.x = tarPos.x;
		}

		if (dir.z > 0)
		{
			if (newPos.z > tarPos.z)
				newPos.z = tarPos.z;
		}
		else
		{
			if (newPos.z < tarPos.z)
				newPos.z = tarPos.z;
		}
	}
	
	boolean isDead()
	{
		return this.curHP <= 0 && !this.checkState(Behavior.EBUNDEAD) && !this.checkState(Behavior.EBGOTODEAD);
	}
	
	void updateBuffProps()
	{
		this.getPropBase().clearBuffProp();
		//buff
		for (Buff buff : this.buffs.values())
		{
			SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
			if (buffCfg.affectType == GameData.EBUFF_PROP && buffCfg.interval == -1)
			{
				if (buffCfg.valueType == GameData.VALUE_TYPE_PERCENT)
					this.getPropBase().addBuffPropPercentValue(buffCfg.affectID, buff.value);
				else
					this.getPropBase().addBuffPropFixValue(buffCfg.affectID, buff.value);
			}
		}
	}

	int getFightProp(int propID)
	{
		switch (propID)
		{
		case BaseRole.EPROPID_LVL:
			return this.level;
		case BaseRole.EPROPID_HP:
			return this.curHP;
		case BaseRole.EPROPID_SP:
			return this.getCurSP();
		case BaseRole.EPROPID_SPEED:
			int speed = this.getPropBase().getFinalProps(propID);
			return speed < 0 ? 0 : speed;
		default:
			return this.getPropBase().getFinalProps(propID);
		}
	}

	double getFightPropF(int propID)
	{
		return getFightProp(propID) / 10000.0;
	}

//	public static float getFloatValue(float val)
//	{
//		return Math.round(val * 10000) / 10000.f;
//	}

	List<BaseRole> getTargets(Skill skill)
	{
		return new ArrayList<>();
	}

	void addFightSP(int contion)
	{

	}

	void setBuffFightSP(int value)
	{
		
	}
	
	//�����˺�
	int reduction(int damage)
	{
		int rec = 0;
		RoleState state = this.curStates.get(Behavior.EBDAMAGEREDUCE);
		if (damage > 0 && state != null && state.value > 0)
		{
			if (damage >= state.value)
			{
				rec = state.value;
				state.value = 0;
				for (int buffID : state.buffIDs)
				{
					this.removeBuffByID(buffID);
					this.trigerAiMgr.postEvent(buffID, GameData.BUFF_CHANGETYPE_VALUECHANGE, state.value);
				}
				this.curStates.remove(Behavior.EBDAMAGEREDUCE);
			}
			else
			{
				rec = damage;
				state.value -= damage;
				//				this.trigerAiMgr.postEvent(state.buffID, GameData.BUFF_CHANGETYPE_VALUECHANGE, damage);
				//				this.buffChangeTrig(state.buffID, GameData.BUFF_CHANGETYPE_VALUECHANGE);
			}
		}

		return rec;
	}

	void updateFightTime()
	{

	}

	void processDamage(Skill skill, List<BaseRole> targets, SBean.SubDamageCFGS damage, List<SBean.SubStatus> status, SBean.TimeTick timeTick, ExtraDropInfo dropInfo)
	{
		int skillType = skill.baseFixCfg.type;
		boolean hasDamage = false;
//		int ownerID = this.owner == null ? 0 : this.owner.id;

		for (BaseRole target : targets)
		{
			if (!target.isDead() && !target.isInProtectTime())
			{
				SBean.DamageResult res = skill.getDamage(this, target, damage, status);
				if (this.serverControl)
					this.processDamageShift(skill, target);

				this.processTargetBuff(skill, target, res);
			
				if(res.remit == 1)
				{
					target.onGetDamage(this, res, skillType, skill.id, skill.curDamageEventID);
				}
				else if (res.dodge == 1 && res.deflect == 1)
				{
					if (damage.odds > 0)
						target.onGetDamage(this, res, skillType, skill.id, skill.curDamageEventID);

					this.missHandler();
				}
				else
				{
					if (damage.odds > 0)
					{
						switch (skillType)
						{
						case GameData.eSE_Damage:
							if (res.damage > target.curHP)
								res.damage = target.curHP;

							target.setCurHP(target.getCurHP() - res.damage);
							if (res.suckBlood > 0) 		//��Ѫ
							{
								this.setCurHP(this.getCurHP() + res.suckBlood);
							}
							
							if(skill.dmgAddHp > 0)		//�����˺��������Ѫ
							{
								int dmgAddHp = Math.max(1, (int)(res.damage * skill.dmgAddHp));
								this.setCurHP(this.getCurHP() + dmgAddHp);
								res.suckBlood += dmgAddHp;
							}
							
							if(res.armor != null)
							{
								target.onArmorDamage(res.armor);
								this.causeArmorDamage(res.armor);
							}
							hasDamage = true;
							break;
						case GameData.eSE_Buff:
							target.setCurHP(target.getCurHP() + res.damage);
							break;
						default:
							break;
						}

						this.processDamageHandler(skill, target, res);
						target.onGetDamage(this, res, skillType, skill.id, skill.curDamageEventID);
						skill.isAttackEffect = true;
					}
				}
				
				if(!this.hasAttack)
				{
					this.hasAttack = true;
					this.curMap.setRoleAttack(this.id);
				}
				
				if (this.owner != null)
					target.trySpecialDrop(this.owner, dropInfo);
			}
		}

		if (hasDamage)
		{
			this.updateFightTime();
			this.addFightSP(GameData.FIGHTSP_TRIG_PROCESSDAMAGE);
		}

//		Set<Integer> rids = this.getRoleIDsNearBy(null);
//		ms.getRPCManager().broadcastStrPacket(rids, new SBean.nearby_processdamage_end(this.id, this.getEntityType(), ownerID, skill.id, skill.curDamageEventID, timeTick));
	}
	
	public void trySpecialDrop(MapRole role, ExtraDropInfo dropInfo)
	{
		
	}

	void processTargetBuff(Skill skill, BaseRole target, SBean.DamageResult res)
	{	
		if (res.buffs != null)
		{
			for (int buffID : res.buffs)
			{
				SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buffID);
				if (buffCfg != null)
				{
					int affectID = buffCfg.affectID;
					if (buffCfg.affectType == GameData.EBUFF_STATUS && (affectID == Behavior.EBDISPELBUFF || affectID == Behavior.EBDISPELDBUFF))
					{
						if (buffCfg.owner == 0 && !target.isDead())
						{
							target.onDamageEnterRole(this.owner);
							target.dispelBuff(affectID == Behavior.EBDISPELBUFF ? GameData.BUFF_DAMAGETYPE_BUFF : GameData.BUFF_DAMAGETYPE_DBUFF, buffCfg.affectValue);
						}
						else if (!this.isDead())
							this.dispelBuff(affectID == Behavior.EBDISPELBUFF ? GameData.BUFF_DAMAGETYPE_BUFF : GameData.BUFF_DAMAGETYPE_DBUFF, buffCfg.affectValue);
					}
					else
					{
						Buff buff = this.createNewBuff(buffCfg, skill.id, skill.realmLvl, this, null);
						if (buff != null)
						{
							if (buffCfg.owner == 0 && !target.isDead())
							{
								target.onDamageEnterRole(this.owner);
								if (target.checkState(Behavior.EBREBOUNDDBUFF) && buffCfg.damageType == GameData.BUFF_DAMAGETYPE_DBUFF && buff.canRebound)
									this.addBuff(buff, this, null);
								else
									target.addBuff(buff, this, null);
								
							}
							else if (buffCfg.owner == 1 && !this.isDead()) //����buff
								this.addBuff(buff, this, null);
						}
					}
					skill.isAttackEffect = true;
				}
			}
		}
	}
	
	void processDamageHandler(Skill skill, BaseRole target, SBean.DamageResult res)
	{
		int skillType = skill.baseFixCfg.type;
		if (skillType == GameData.eSE_Damage)
		{
			this.processDamageUseSkill(skill, target);
			this.dmgToSPHandler(target);
		}

		if (!GameData.getInstance().getCommonCFG().skill.invalidSkillIDs.contains(skill.id))
		{
			this.trigerAiMgr.postEvent(skillType, res.crit == 1);
			this.dmgToTrig();
		}
	}

	//����˺�/����ʱ�м��ʴ���
	void dmgToTrig()
	{
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_DMGTOCOUNT_D, 0, 0);
	}

	void dmgToSPHandler(BaseRole target)
	{

	}

	void missHandler()
	{
		this.trigerAiMgr.postMissEvent();
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_ANY_MISS, 0, 0);
	}

	void nextSkill()
	{

	}

	void onAutoProcessDamage(long logicTime)
	{
		this.refreshCurUseSkills();
		if(this.curUseSkills.isEmpty())
			return;
		
		if(this.isDead())
			return;
		
		SBean.TimeTick timeTick =  ms.getMapManager().getTimeTickDeep();
		Iterator<Skill> it = this.curUseSkills.iterator();
		while (it.hasNext())
		{
			Skill skill = it.next();
			if(skill.rushInfo != null && skill.rushInfo.rushEndTime > logicTime)
				continue;
			
			if (!skill.autoProcessDamage(this, logicTime, timeTick))
			{
				it.remove();
				this.onEndSkillHandle(skill);
			}
		}

		if (!this.checkState(Behavior.EBATTACK) && !this.checkState(Behavior.EBDISATTACK))
			this.nextSkill();
	}

	void setAttackRange()
	{
		if (this.curSkillID == null)
		{
			this.nextSkill();
			return;
		}

		FightSkill fSkill = this.fightSkills.get(this.curSkillID);
		if (fSkill == null)
			return;
		SBean.SkillBaseCommonCFGS commonCfg = fSkill.baseDataCfg.common;
		SBean.SkillBaseFixCFGS fixCfg = fSkill.baseDataCfg.fix;
		if (this.curSkillID == Skill.DIY_SKILL_ID)
		{
			if (this.getDiySkillData() == null)
			{
				this.nextSkill();
				return;
			}
			commonCfg = this.getDiySkillData().baseCommonCfg;
			fixCfg = this.getDiySkillData().baseFixCfg;
		}

		this.attackRange = this.calcuAttackRange(fixCfg.scope, commonCfg.fixDistance);
	}
	
	int calcuAttackRange(SBean.Scope scope, int fixDistance)
	{
		int range = 0;
		switch (scope.type)
		{
		case Skill.eSScopT_Owner:
			break;
		case Skill.eSScopT_Single:
			range = scope.args.get(0);
			break;
		case Skill.eSScopT_CricleO:
			range = scope.args.get(0);
			break;
		case Skill.eSScopT_CricleT:
			range = scope.args.get(0) + scope.args.get(1);
			break;
		case Skill.eSScopT_SectorO:
			range = scope.args.get(0);
			break;
		case Skill.eSScopT_RectO:
			range = scope.args.get(0);
			break;
		case Skill.eSScopT_MulC:
			range = (int) ((scope.args.get(0) + scope.args.get(1)) * 0.5f);
			break;
		case Skill.eSScopT_EllipseO:
			range = scope.args.get(1);
			break;
		default:
			break;
		}

		range = Math.max(50, range - fixDistance);

		return range;
	}
	
//	boolean checkMapRoleCanAttack(MapRole attacker, MapRole target, SBean.CommonPKCFGS pkCfg)
//	{
//		if (attacker == null || target == null)
//			return true;
//
//		if (attacker == target)
//			return false;
//
//		if (!target.active)
//			return false;
//
//		if (attacker.isInProtectTime() || target.isInProtectTime())
//			return false;
//
//		if (attacker.isTeamMember(target))
//			return false;
//		
//		if(attacker.carRobber * target.carOwner != 0)
//			return true;
//		
//		if(attacker.carOwner * target.carRobber < 0)
//			return true;
//		
//		if (!this.curMap.isFightMap())
//		{
//			if (attacker.getPKMode() == GameData.ATTACK_MODE_PEACE)
//				return false;
//
//			if (attacker.getPKMode() == GameData.ATTACK_MODE_BW && target.getNameColor() != GameData.NAME_COLOR_RED)
//				return false;
//			
//			if(attacker.getPKMode() == GameData.ATTACK_MODE_SECT && attacker.isSectMember(target))
//				return false;
//				
//			if (attacker.level < pkCfg.needLvl || target.level < pkCfg.needLvl)
//				return false;
//		}
//
//		return true;
//	}

	boolean checkEntityFriend(MapRole attacker, BaseRole role)
	{
		return role.owner != null && (attacker == role.owner || attacker.isTeamMember(role.owner));

	}

	public GVector3 vec3FMul2(double rot, float d1, float d2)
	{
		double x = Math.cos(rot) * d1;
		double y = 0.0;
		double z = Math.sin(rot) * d2;
		return new GVector3((float) x, (float) y, (float) z);
	}

	GVector3 vec3FRotateByAngle(GVector3 p1, GVector3 p2, float angle)
	{
		//		p1.y = 0.0f;
		//		p2.y = 0.0f;
		//		return GameData.vector3FSum(p2, this.vec3FRotate(GameData.vector3FDiffence(p1, p2), this.vec3FFromAngle(angle)));
		return this.vec3FRotate(p1.diffence2D(p2), this.vec3FFromAngle(angle)).sum(p2);
	}

	GVector3 vec3FRotate(GVector3 p1, GVector3 p2)
	{
		return new GVector3(p1.x * p2.x - p1.z * p2.z, 0.0f, p1.x * p2.z + p1.z * p2.x);
	}

	GVector3 vec3FFromAngle(float angle)
	{
		return new GVector3((float) Math.cos(angle), 0.0f, (float) Math.sin(angle));
	}

	/////////////buff
	Buff addBuffByID(int buffID, BaseRole attacker, Buff host)
	{
		return addBuffByID(buffID, attacker, host, 0);
	}
	
	Buff addBuffByID(int buffID, BaseRole attacker, Buff host, int endTime)
	{
		SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buffID);
		if(buffCfg != null)
		{
			Buff buff = this.createNewBuff(buffCfg, 0, 0, attacker, host);
			if(endTime != 0)
				buff.endTime = endTime;
			this.addBuff(buff, attacker, host);
			return buff;
		}
		return null;
	}
	
	void addBuff(Buff buff, BaseRole attacker, Buff host)
	{
		BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
		if (buffCfg == null)
			return;

		if (buffCfg.damageType == GameData.BUFF_DAMAGETYPE_DBUFF && (this.checkState(Behavior.EBIMMUNEDBUFF) || this.checkState(Behavior.EBINVINCIBLE)))
			return;

		int attackerType = buff.attackerType;
		int attackerID = buff.attackerID;
		int attackOwnerID = buff.attackOwnerID;
		boolean add = false;
		Buff curBuff = this.buffs.get(buff.id);
		if (curBuff == null)
		{
			add = true;
			curBuff = buff;
		}
		else
		{
			if (curBuff.spiritEffectID > 0)
				return;

			int lays = buffCfg.overLays;
			if (lays > 1)
			{
				if (curBuff.overLays >= lays)
					return;

				add = true;
				curBuff.overLays++;
				switch (buffCfg.overLayType)
				{
				case BUFF_TYPE_ADDVALUE_KEEPTIME:
					curBuff.value = (int) (curBuff.value + buff.value);
					curBuff.attackerID = attackerID;
					curBuff.attackerType = attackerType;
					curBuff.attackOwnerID = attackOwnerID;
					break;
				case BUFF_TYPE_KEEPVALUE_ADDTIME:
					curBuff.endTime += buffCfg.loopTime;
					if (buffCfg.loopTime < 0)
						buffCfg.loopTime = -1;
					curBuff.attackerID = attackerID;
					curBuff.attackerType = attackerType;
					curBuff.attackOwnerID = attackOwnerID;
					break;
				case BUFF_TYPE_MAXVALUE_KEEPTIME:
					if (buff.value > curBuff.value)
					{
						curBuff.value = buff.value;
						curBuff.attackerID = attackerID;
						curBuff.attackerType = attackerType;
						curBuff.attackOwnerID = attackOwnerID;
					}
					break;
				case BUFF_TYPE_MAXVALUE_RESETTIME:
					if (buff.value > curBuff.value)
					{
						curBuff.value = buff.value;
					}
					if (buffCfg.loopTime < 0)
						curBuff.endTime = -1;
					else
						curBuff.endTime = curBuff.endTime + buffCfg.loopTime;

					curBuff.attackerID = attackerID;
					curBuff.attackerType = attackerType;
					curBuff.attackOwnerID = attackOwnerID;
					break;
				default:
					break;
				}
			}
		}

		if (add)
		{
			this.buffsAddCache.add(curBuff);
			//��buff
			for (int subBuffID : buffCfg.child)
			{
				SBean.BuffCFGS subBuffCfg = GameData.getInstance().getBuffCFG(subBuffID);
				if (subBuffCfg != null)
				{
					Buff subBuff = this.createNewBuff(subBuffCfg, 0, buff.realmLvl, attacker, curBuff);
					if (subBuff != null)
						this.addBuff(subBuff, attacker, curBuff);
				}
			}
		}
	}

	void removeBuff(Buff buff)
	{
		this.buffsRemoveCache.add(buff);
	}
	
	Buff removeBuffByID(int buffID)
	{
		Buff buff = this.buffs.get(buffID);
		if(buff != null)
			this.removeBuff(buff);
		
		return buff;
	}
	
	Buff createNewBuff(SBean.BuffCFGS buffCfg, int skillID, int realmLvl, BaseRole attacker, Buff host)
	{
		int attackerType = attacker.getEntityType();
		int attackerID = attacker.getID();
		int attackOwnerID = 0;
		if (attacker.owner != null)
			attackOwnerID = attacker.owner.getID();

		long now = ms.getMapManager().getMapLogicTime();
		int value = 0;
		float realmAdd = (float) (buffCfg.realmAdd * realmLvl);
		long loopTimeAddTime = attacker.getFightSP() * buffCfg.fightSpAddTime;
		if (buffCfg.valueType == GameData.VALUE_TYPE_FIXED)
			value = (int) (buffCfg.affectValue * (1.0f + realmAdd));
		else
			value = buffCfg.affectValue;

		Buff buff = new Buff(now + buffCfg.loopTime + loopTimeAddTime, buffCfg.id, realmLvl, now, 1, value, attackerType, attackerID, attackOwnerID, 
				attacker.getName(), attacker.getClassType(), host != null ? host.spiritEffectID : 0, host != null, buffCfg.hasShowID == 1);
		buff.canRebound = GameData.getInstance().checkStateCanRebound(buffCfg.affectID);

		if (buffCfg.loopTime < 0)
			buff.endTime = -1;

		if (skillID == Skill.DIY_SKILL_ID && attacker.getDIYSkill() != null)
		{
			for (SBean.DBDIYBUFF diyBuff : attacker.getDIYSkill().buffs)
			{
				if (diyBuff.status.buffID == buffCfg.id)
				{
					buff.value = diyBuff.affectValue; // realmAdd ?
					buff.endTime = now + (long) diyBuff.loopTime + loopTimeAddTime;
					if (diyBuff.loopTime < 0)
						buff.endTime = -1;

					buff.diySkill = skillID == Skill.DIY_SKILL_ID;
					break;
				}
			}
		}
		return buff;
	}

	void dispelBuff(int damageType, int count)
	{
		if(this.buffs.isEmpty())
			return;

		Iterator<Buff> it = this.buffs.values().iterator();
		int dCount = 0;
		Set<Integer> rids = this.getRoleIDsNearBy(null);
		SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
		while (it.hasNext())
		{
			Buff buff = it.next();
			if (buff.spiritEffectID != 0)
				continue;
			SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
			if (buffCfg != null)
			{
				if (buffCfg.damageType == damageType)
				{
					this.notifyDispelBuff(rids, buff.id, timeTick);
					buff.spiritEffectID = GameData.MAX_NUMBER;
					this.removeBuff(buff);
					dCount++;
				}
				if (count > 0 && dCount >= count)
					break;
			}
		}
	}

	void processBuff(Buff buff, boolean isAdd)
	{
		SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
		if (buffCfg == null)
			return;

		if (buffCfg.affectType == GameData.EBUFF_PROP)
		{
			if (buffCfg.interval > 0 && isAdd)
			{
				boolean fixed = buffCfg.valueType == GameData.VALUE_TYPE_FIXED;
				int value = fixed ? buff.value : (int) (this.getFightProp(buffCfg.affectID) * (buff.value / 10000.f));
				if (buffCfg.affectID == EPROPID_SP)
					this.onGetBuffSP(value);
				else
				{
					if(value < 0)
					{
						if(!fixed && this.getEntityType() == GameData.ENTITY_TYPE_MONSTER)
							value = value < -GameData.getInstance().getCommonCFG().skill.percentBuffMax ? -GameData.getInstance().getCommonCFG().skill.percentBuffMax : value;
						value = -this.fixUnDeadDamage(-value);
					}
					
					this.onGetBuffDamage(buff, value);
				}
			}
		}
		else if (buffCfg.affectType == GameData.EBUFF_STATUS)
		{
			if (isAdd)
				this.addState(buffCfg.affectID, buffCfg.id, buffCfg.affectValue, buff);
			else
			{
				this.removeState(buffCfg.affectID, buff.id);
				switch (buffCfg.affectID)
				{
				case Behavior.EBTAUNT:
					this.removeEbataunt();
					break;
				case Behavior.EBUNDEAD:
					if(this.isDead())
					{
						this.onDeadHandle(this.dmgRole.roleID, GameData.ENTITY_TYPE_PLAYER);
						this.dmgRole.clear();
					}
					break;
				default:
					break;
				}
			}
		}
	}

	void onProLongBuff(boolean buff, int value)
	{
		int type = buff ? GameData.BUFF_DAMAGETYPE_BUFF : GameData.BUFF_DAMAGETYPE_DBUFF;
		for (Buff b : this.buffs.values())
		{
			SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(b.id);
			if (buffCfg == null)
				continue;

			if (type == buffCfg.damageType && b.endTime > 0)
				b.endTime += value;
		}
	}

	void onUpdateCurBuff(long logicTime)
	{
		boolean update = false;
		if (this.buffsRemoveCache.size() > 0)
		{
			List<Buff> removeCache = new ArrayList<>(this.buffsRemoveCache);
			this.buffsRemoveCache.clear();
			removeCache.stream().filter(buff -> this.buffs.containsKey(buff.id)).forEach(buff ->
			{
				this.buffs.remove(buff.id);
				this.removeBuffHandler(buff);
			});
			update = true;
		}

		if (this.buffsAddCache.size() > 0)
		{
			List<Buff> addCache = new ArrayList<>(this.buffsAddCache);
			this.buffsAddCache.clear();
			addCache.stream().filter(buff -> !this.isDead() || buff.spiritEffectID != 0).forEach(buff ->
			{
				this.buffs.put(buff.id, buff);
				this.addBuffHandler(buff);
			});
			update = true;
		}

		Iterator<Buff> it = this.buffs.values().iterator();
		while (it.hasNext())
		{
			Buff buff = it.next();
			SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
			if (buffCfg != null)
			{
				if (buff.endTime > logicTime || buff.endTime == -1)
				{
					if (buffCfg.interval > 0 && logicTime >= buff.preTime + buffCfg.interval)
					{
						if (!this.isDead())
							this.processBuff(buff, true);
						buff.preTime = logicTime;
					}
				}
				else
				{
					it.remove();
					this.removeBuffHandler(buff);
					update = true;
				}
			}
		}
		
		if(update)
			this.updateBuffProps();
	}

	void addBuffHandler(Buff buff)
	{
		SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
		if (buffCfg == null)
			return;

		if (buffCfg.interval == -1)
			this.processBuff(buff, true);

		for (Integer trigID : buffCfg.triggers)
		{
			this.addTrigAi(trigID, buff);
		}

//		this.updateBuffProps();
		this.buffChangeTrig(buff.id, GameData.BUFF_CHANGETYPE_ADD);
		
		if(this.isInPrivateMap())
			return;
		
		Set<Integer> rids = new HashSet<>();
		if (buff.hasShowID)
		{
			if (buff.spiritEffectID <= 0)
				rids = this.getRoleIDsNearBy(null);
		}
		else if (this.owner != null && !this.owner.robot && buff.spiritEffectID <= 0) //�ķ���buff �ͻ����Լ���ӵ�
			rids.add(this.owner.id);
		
		long now = ms.getMapManager().getMapLogicTime();
		int remainTime = 0;
		if (buff.endTime > 0)
			remainTime = (int) Math.max(buff.endTime - now, 0);
		else
			remainTime = -1;

		if (buff.diySkill)
			this.notifyAddBuff(rids, buff.id, buff.value, remainTime, ms.getMapManager().getTimeTickDeep());
		else
			this.notifyAddBuff(rids, buff.id, buff.realmLvl, remainTime, ms.getMapManager().getTimeTickDeep());
	}

	void removeBuffHandler(Buff buff)
	{
		SBean.BuffCFGS buffCfg = GameData.getInstance().getBuffCFG(buff.id);
		if (buffCfg == null)
			return;

		this.buffChangeTrig(buff.id, GameData.BUFF_CHANGETYPE_REMOVE);
		this.processBuff(buff, false);
		for (Integer tid : buff.trigAis)
		{
			this.trigerAiMgr.removeTrigerAi(tid);
		}
//		this.updateBuffProps();
		if(this.isInPrivateMap())
			return;
		
		Set<Integer> rids = new HashSet<>();
		if (buff.spiritEffectID != GameData.MAX_NUMBER) //����ɢ��buff
		{
			if (buff.hasShowID)
			{
				if (buff.spiritEffectID <= 0)
					rids = this.getRoleIDsNearBy(null);
			}
			else if (this.owner != null && !this.owner.robot && buff.spiritEffectID <= 0) //�ķ���buff �ͻ����Լ��Ƴ���
				rids.add(this.owner.id);
		}
		
		this.notifyRemoveBuff(rids, buff.id, ms.getMapManager().getTimeTickDeep());
		for (int subBuffID : buffCfg.child)
		{
			Buff subBuff = this.buffs.get(subBuffID);
			if (subBuff != null && subBuff.canRemoveByParent)
				this.removeBuff(subBuff);
		}
	}

	/////////////state
	boolean addState(int stateID)
	{
		return this.addState(stateID, -1, 0, null);
	}
	
	boolean addState(int stateID, int buffID, int value, Buff buff)
	{
		boolean update = false;
		MatchTable t = Behavior.matchTbl.get(stateID);
		if(t == null)
			return false;
		
		final Map<Integer, Integer> matchMap = t.match;
		if (matchMap != null)
		{
			for(Set<Integer> pStates: Behavior.statePriority.values())
			{
				Iterator<RoleState> it = this.curStates.values().iterator();
				while (it.hasNext())
				{
					RoleState state = it.next();
					if (!pStates.contains(state.id) || matchMap.get(state.id) == null)
						continue;

					switch (matchMap.get(state.id))
					{
					case Behavior.ESTATECOEXIST: //����
						break;
					case Behavior.ESTATEMATCH: //���
						it.remove();
						break;
					case Behavior.ESTATEIMMUNE: //����
						return false;
					case Behavior.ESTATEUPDATE: //����
						update = true;
						break;
					default:
						break;
					}
				}
			}
		}

		RoleState state = this.curStates.get(stateID);
		if (state == null)
		{
			state = new RoleState(stateID);
			this.curStates.put(stateID, state);
		}
		state.set(buffID, value);
		if (update)
			this.onBehaviorUpdate(stateID, buff);
		else
			this.onBehavior(stateID, value, buff);

		return true;
	}

	void onBehavior(int stateID, int value, Buff buff)
	{
		if (buff == null)
			return;

		switch (stateID)
		{
		case Behavior.EBSTUN:
			if (this.isMoving())
				this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			this.breakSkill();
			break;
		case Behavior.EBSLEEP:
			if (this.isMoving())
				this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			this.breakSkill();
			break;
		case Behavior.EBROOT:
			if (this.isMoving())
				this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			this.breakSkill();
			break;
		case Behavior.EBSILENT:
			this.breakSkill();
			break;
		case Behavior.EBSCARECROW:
			this.breakSkill();
			break;
		case Behavior.EBSUBSTITUTE:
			this.breakSkill();
			break;
		case Behavior.EBCHARM:
			this.breakSkill();
			break;
		case Behavior.EBFREEZE:
			if (this.isMoving())
				this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			this.breakSkill();
			break;
		case Behavior.EBPETRIFACTION:
			if (this.isMoving())
				this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			this.breakSkill();
			break;
		case Behavior.EBTAUNT:
			this.addEbataunt(buff, ms.getMapManager().getTimeTickDeep());
			this.breakSkill();
			break;
		case Behavior.EBFEAR:
			this.addEbFear(buff.endTime);
			break;
		case Behavior.EBPROLONGBUFF:
			this.onProLongBuff(true, value);
			break;
		case Behavior.EBPROLONGDBUFF:
			this.onProLongBuff(false, value);
			break;
		case Behavior.EBRESETSKILL:
			this.onRandomResetSkill();
			break;
		case Behavior.EBQUICKCOOL:		//ʹ����CD�ļ��ܼӿ���ȴ
			FightSkill fSkill = this.getRandomSkill(false);
			if (fSkill != null)
				this.onQuickCoolSkill(fSkill, buff.value);
			break;
		case Behavior.EBUNDEAD:
//			this.setCurHP(this.curHP + buff.value);
			break;
		case Behavior.EBSETFIGHTSP:
			this.setBuffFightSP(buff.value);
			break;
		default:
			break;
		}
	}

	void onBehaviorUpdate(int stateID, Buff buff)
	{
		if (buff == null)
			return;

		switch (stateID)
		{
		case Behavior.EBRESETSKILL:
			this.onRandomResetSkill();
			break;
		case Behavior.EBQUICKCOOL:
			FightSkill fSkill = this.getRandomSkill(false);
			if (fSkill != null)
				this.onQuickCoolSkill(fSkill, buff.value);
			break;
		case Behavior.EBSETFIGHTSP:
			this.setBuffFightSP(buff.value);
			break;
		default:
			break;
		}
	}

	void removeState(int stateID)
	{
		this.curStates.remove(stateID);
		this.notifySelfRemoveState(stateID, ms.getMapManager().getTimeTickDeep());
	}

	void removeState(int stateID, int buffID)
	{
		RoleState state = this.curStates.get(stateID);
		if (state == null)
			return;

		state.buffIDs.remove(buffID);
		if (state.buffIDs.isEmpty())
			this.removeState(stateID);
	}

	boolean checkState(int stateID)
	{
		return this.curStates.containsKey(stateID);
	}

	boolean checkState(Set<Integer> states)
	{
		for (int stateID : states)
		{
			if (this.curStates.containsKey(stateID))
				return true;
		}
		return false;
	}

	boolean canUseSkill(FightSkill fightSkill)
	{
		long now = ms.getMapManager().getMapLogicTime();
		if (fightSkill.coolDownTime >= now + this.timerInterval)	//this.timerInterval ÿ֡��ʱ��
		{
			ms.getLogger().debug("entity " + this.id + " , type " + this.getEntityType() + " skill in cool can not use skill " + fightSkill.id + " cool " + fightSkill.coolDownTime + " now " + now);
			return false;
		}

		if (this.checkState(Behavior.EBDISATTACK))
		{
			ms.getLogger().debug("entity " + this.id + " , type " + this.getEntityType() + " in state disattack can not use skill " + fightSkill.id);
			return false;
		}

		if (this.checkState(Behavior.EBATTACK))
		{
			ms.getLogger().debug("entity " + this.id + " , " + this.getEntityType() + " in state attack can not use skill " + fightSkill.id);
			return false;
		}

		return !(this.checkState(Behavior.EBSILENT) && fightSkill.skillGroup == Skill.eSG_Skill) && this.addState(Behavior.EBATTACK);

	}

	void checkFear(long logicTime)
	{
		if (this.curFear != null)
		{
			if (logicTime > this.curFear.endTime)
			{
				this.curFear = null;
				this.removeEbFear(ms.getMapManager().getTimeTickDeep());
				return;
			}
			
			this.moveTargetPos = this.curFear.calcMovePos(this.curPosition);
			int speed = this.getFightProp(EPROPID_SPEED);
			if (this.moveSpeed == 0 && speed > 0)
			{
				this.moveSpeed = speed;
				this.setCurRotation(this.moveTargetPos.diffence2D(this.getCurPosition()).normalize());
				this.startMove(logicTime);
			}
		}
	}

	void breakSkill()
	{
		boolean notify = this.attack != null || !this.curUseSkills.isEmpty() || !this.curUseSkillAddCache.isEmpty() || !this.trigSkills.isEmpty() || !this.trigSkillAddCache.isEmpty() || !this.followSkills.isEmpty();
		this.attack = null;
		this.curUseSkillRemoveCache.addAll(this.curUseSkills);
		this.curUseSkillRemoveCache.addAll(this.curUseSkillAddCache);
		
		this.trigSkillRemoveCache.addAll(this.trigSkills);
		this.trigSkillRemoveCache.addAll(this.trigSkillAddCache);
		
		this.followSkillRemoveCache.addAll(this.followSkills.keySet());
		this.curStates.remove(Behavior.EBDISATTACK);
		this.curStates.remove(Behavior.EBATTACK);
		this.nextSkill();
		
		if(notify)
			this.notifyBreakSkill();
	}
	
	void refreshCurUseSkills()
	{
		if(!this.curUseSkillAddCache.isEmpty())
		{
			this.curUseSkills.addAll(this.curUseSkillAddCache);
			this.curUseSkillAddCache.clear();
		}
		
		if(!this.curUseSkillRemoveCache.isEmpty())
		{
			this.curUseSkills.removeAll(this.curUseSkillRemoveCache);
			this.curUseSkillRemoveCache.clear();
		}
	}
	
	void refreshFollowSkills()
	{
		if(this.followSkillRemoveCache.isEmpty())
			return;
		
		for(int mainSkillID: this.followSkillRemoveCache)
			this.followSkills.remove(mainSkillID);
		
		this.followSkillRemoveCache.clear();
	}
	
	void refreshTrigSkills()
	{
		if(!this.trigSkillAddCache.isEmpty())
		{
			this.trigSkills.addAll(this.trigSkillAddCache);
			this.trigSkillAddCache.clear();
		}
		
		if(!this.trigSkillRemoveCache.isEmpty())
		{
			this.trigSkills.removeAll(this.trigSkillRemoveCache);
			this.trigSkillRemoveCache.clear();
		}
	}
	
	////ai	
	void addTrigAi(int trigID, Buff buff)
	{
		createAi(trigID, 0, buff);
	}

	TrigerAi addTrigAi(int trigID, int spiritEffectID)
	{
		return createAi(trigID, spiritEffectID, null);
	}
	
	TrigerAi createAi(int trigID, int spiritEffectID, Buff buff)
	{
		SBean.AiTrigerCFGS aiTrigCfg = GameData.getInstance().getAiTrigerCFGS(trigID);
		if (aiTrigCfg == null)
			return null;
		
		SBean.TrigEventCFGS eventCfg = GameData.getInstance().getTrigEventCFGS(aiTrigCfg.eventID);
		SBean.TrigBehaviorCFGS behaviorCfg = GameData.getInstance().getTrigBehaviorCFGS(aiTrigCfg.behaviorID);
		if (eventCfg == null || behaviorCfg == null)
			return null;
		
		TrigerAi trigAi = null;
		switch (eventCfg.eventType)
		{
		case GameData.TRIG_EVENT_SDEAD:
			trigAi = new TrigerAi.SelfDeadTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_SKILLCOUNT:
			trigAi = new TrigerAi.SkillCountTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_DMGBYCOUNT_D:
		case GameData.TRIG_EVENT_DMGBYCOUNT_I:
			trigAi = new TrigerAi.OnDmgByTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_BUFFCHANGE:
			trigAi = new TrigerAi.BuffChangeTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_DODGE:
			trigAi = new TrigerAi.DodgeTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_DMGTOCOUNT_D:
			trigAi = new TrigerAi.OnDmgToTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_DMGBY_HP:
			trigAi = new TrigerAi.HPLowDmgByTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_ANY_MISS:
			trigAi = new TrigerAi.MissTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		case GameData.TRIG_EVENT_WEAPON_MOTIVATE:
			trigAi = new TrigerAi.WeaponMotivateTrigAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		default:
			trigAi = new TrigerAi(this.nextTrigAiID.incrementAndGet(), aiTrigCfg, spiritEffectID, buff).createNew(this.trigerAiMgr, eventCfg, behaviorCfg);
			break;
		}
		if (trigAi != null)
			this.addTrigAiHandler(trigAi, buff);

		return trigAi;
	}
	
	void addTrigAiHandler(TrigerAi trigAi, Buff buff)
	{

		TrigerAiCluster aiCluster = this.trigerAiMgr.trigerClusters.get(trigAi.eCfg.eventType);
		if (aiCluster == null)
		{
			aiCluster = new TrigerAiCluster();
			this.trigerAiMgr.trigerClusters.put(trigAi.eCfg.eventType, aiCluster);
		}

		aiCluster.ais.put(trigAi.id, trigAi);
		this.trigerAiMgr.allTrigerEventType.put(trigAi.id, trigAi.eCfg.eventType);
		this.fixTrigAiParam(trigAi);

		if (buff != null)
			buff.trigAis.add(trigAi.id);
	}

	void fixTrigAiParam(TrigerAi trigAi)
	{
		SpiritCluster scluster = this.getNormalSpirit(GameData.SPIRIT_EFFECT_FIXAI);
		if (scluster != null)
			this.fixTrigAiParamImp(scluster, trigAi);

		SpiritCluster hcluster = this.getHorseSpirit(GameData.SPIRIT_EFFECT_FIXAI);
		if(hcluster != null)
			this.fixTrigAiParamImp(hcluster, trigAi);
	}

	void fixTrigAiParamImp(SpiritCluster cluster, TrigerAi trigAi)
	{
		SpiritContainer container = cluster.containers.get(trigAi.aiTrigCfg.id);
		if (container == null)
			return;

		for (SBean.SpiritEffectCFGS cfg : container.spiritEffects.values())
		{
			if (cfg.param2 == GameData.FIX_TRIGAI_EVENT)
			{
				switch (cfg.param3)
				{
				case GameData.FIX_TRIGAI_PARAM1:
					trigAi.eCfg.param1 = (int) this.getFixValue(cfg.param4, trigAi.eCfg.param1, cfg.param5);
					break;
				case GameData.FIX_TRIGAI_PARAM2:
					trigAi.eCfg.param2 = (int) this.getFixValue(cfg.param4, trigAi.eCfg.param2, cfg.param5);
					break;
				default:
					break;
				}
			}
			else if (cfg.param2 == GameData.FIX_TRIGAI_BEHAVIOR)
			{
				switch (cfg.param3)
				{
				case GameData.FIX_TRIGAI_PARAM1:
					trigAi.bCfg.param1 = (int) this.getFixValue(cfg.param4, trigAi.bCfg.param1, cfg.param5);
					break;
				case GameData.FIX_TRIGAI_PARAM2:
					trigAi.bCfg.param2 = (int) this.getFixValue(cfg.param4, trigAi.bCfg.param2, cfg.param5);
					break;
				case GameData.FIX_TRIGAI_PARAM3:
					trigAi.bCfg.param3 = (int) this.getFixValue(cfg.param4, trigAi.bCfg.param3, cfg.param5);
					break;
				case GameData.FIX_TRIGAI_PARAM4:
					trigAi.bCfg.param4 = (int) this.getFixValue(cfg.param4, trigAi.bCfg.param4, cfg.param5);
					break;
				case GameData.FIX_TRIGAI_PARAM5:
					trigAi.bCfg.param5 = (int) this.getFixValue(cfg.param4, trigAi.bCfg.param5, cfg.param5);
					break;
				default:
					break;
				}
			}
		}
	}
	
	//
	void checkTrigerAi()
	{
		for (TrigerAiCluster cluster : this.trigerAiMgr.trigerClusters.values())
			cluster.ais.values().stream().filter(trigerAi -> trigerAi.check(this)).forEach(trigerAi -> this.trigBehavior(trigerAi.bCfg));
	}

	//BUFF ���/�Ƴ�/��ֵ�仯 ����
	void buffChangeTrig(int buffID, int type)
	{
		this.trigerAiMgr.postEvent(buffID, type, 0);
		this.trigerAiMgr.aiTrig(this, GameData.TRIG_EVENT_BUFFCHANGE, type, buffID);
	}

	void trigBehavior(SBean.TrigBehaviorCFGS behaviorCfg)
	{
		switch (behaviorCfg.behaviorType)
		{
		case GameData.TRIG_BEHAVIOR_USESKILL:
			this.behaviorSkill(behaviorCfg);
			break;
		case GameData.TRIG_BEHAVIOR_QUICKCOOL_SKILL:
			this.behaviorQuickCoolSkill(behaviorCfg);
			break;
		default:
			break;
		}
	}

	void behaviorSkill(SBean.TrigBehaviorCFGS behaviorCfg)
	{
		int skillID = behaviorCfg.param1;
		int skillLvl = behaviorCfg.param2;
		int realmLvl = 0;
		boolean canUse = true;
		SBean.SkillCFGS sCfg = GameData.getInstance().getSkillCFG(skillID);
		if (sCfg == null)
			return;

		if (behaviorCfg.param1 == 1)
		{
			canUse = false;
			for (int sid : this.getCurEquipSkills())
			{
				if (sid == skillID)
				{
					FightSkill fSkill = this.fightSkills.get(sid);
					if (fSkill.coolDownTime < ms.getMapManager().getMapLogicTime())
						canUse = true;
					break;
				}
			}
		}

		if (!canUse)
			return;

		if (skillLvl == -1)
			skillLvl = this.getSkillLvl(skillID);

		realmLvl = this.getSkillRealmLevel(sCfg.baseData.common.relateSKill);
		this.trigSkill(behaviorCfg, skillLvl, realmLvl);
	}

	void behaviorQuickCoolSkill(SBean.TrigBehaviorCFGS behaviorCfg)
	{
		int skillID = behaviorCfg.param1;
		int time = behaviorCfg.param2;
		FightSkill fSkill = this.fightSkills.get(skillID);
		if (fSkill == null)
			return;
		this.onQuickCoolSkill(fSkill, time);
	}

	int getSummonMonsterCountByID(int mid)
	{
		int count = 0;
		for (Monster m : this.summonMonsters)
		{
			if (m.configID == mid)
				++count;
		}

		return count;
	}

	void setSummonMonsterEnmity(BaseRole attacker)
	{
		for (Monster m : this.summonMonsters)
		{
			m.addEnemy(attacker);
			m.setAttacked(true);
		}
	}

	void addEnemy(BaseRole entity)
	{
		if (!this.enmityList.contains(entity))
			this.enmityList.add(entity);
	}

	boolean isAttacked()
	{
		return this.isAttacked;
	}

	void setAttacked(boolean isAttacked)
	{
		this.isAttacked = isAttacked;
	}

	int getCurSP()
	{
		return 0;
	}

	int getFightSP()
	{
		return 0;
	}

	int getSkillLvl(int skillID)
	{
		return 1;
	}

	int getSkillRealmLevel(int skillID)
	{
		return 0;
	}

	int getSpiritTotalLays()
	{
		return 0;
	}

	int getWeaponTotalLvls()
	{
		return 0;
	}

	SBean.DBDIYSkillData getDIYSkill()
	{
		return null;
	}

	SkillData getDiySkillData()
	{
		return null;
	}

	SBean.EnterBase getEnterBase()
	{
		return new SBean.EnterBase(this.id, this.configID, this.owner == null ? 0 : this.owner.id, new SBean.Location(this.getLogicPosition(), this.curRotation.toVector3F()), this.getBWType(), this.getSectId(), this.getForceType());
	}

	SBean.EnterDetail getEnterDetail()
	{
		return new SBean.EnterDetail(this.getEnterBase(), this.curHP, this.maxHp, this.isDead() ? 1 : 0);
	}
	
	//PVPְҵ�˺�����
	float getClassReduce(BaseRole attacker)
	{
		return 1.f;
	}
	
	boolean isRemit(BaseRole attacker, float damage)
	{
		if(damage <= this.getMaxHP() * GameData.getInstance().getCommonCFG().skill.stepTrigCondition)
			return false;
		
		boolean high = this.getFightProp(EPROPID_STEPS) > attacker.getFightProp(EPROPID_STEPS);
		return high ? GameData.checkRandom(GameData.getInstance().getCommonCFG().skill.stepTrigOdds) : false;
	}
	
	SBean.TimeTick createTimeTick(long startTime, long now)
	{
		if (startTime > now)
			startTime = now;

		//		int interval = GameData.getInstance().getCommonCFG().engine.interval;
		return new SBean.TimeTick((int) ((now - startTime) / timerInterval), (int) ((now - startTime) % timerInterval));
	}

	void onSelfUpdatePosition(Set<Integer> rids, SBean.Vector3 position, SBean.TimeTick timeTick)
	{

	}

	void onStopMove(GVector3 position, SBean.TimeTick timeTick, boolean broadcast)
	{

	}

	void onStopMoveImpl(GVector3 position, SBean.TimeTick timeTick, boolean broadcast)
	{
		
	}
	
	boolean onMoveMent(int speed, SBean.Vector3F rotation, GVector3 pos, GVector3 targetPos, SBean.TimeTick timeTick)
	{
		boolean moveState = this.checkState(Behavior.EBMOVE);
		if (!this.addState(Behavior.EBMOVE))
			return false;

		if (moveState)
			this.updateMovePositionImpl(ms.getMapManager().getMapLogicTime());
		else
			this.preMoveUpdateTick = timeTick;

		this.moveTargetPos = targetPos;
		this.moveSpeed = speed;
		this.setCurRotation(new GVector3(rotation));
		this.startMoveTick = ms.getMapManager().getTimeTickDeep();

		return true;
	}

	void adjustPos()
	{

	}

	void updateMovePosition(long logicTime)
	{
		if (this.moveSpeed == 0 || !this.checkState(Behavior.EBMOVE) || !this.active || this.isInPrivateMap())
			return;

		if (this.curPosition.distance(this.moveTargetPos) <= 5)
		{
			this.serverStopTime = logicTime;
			this.onStopMove(this.curPosition, ms.getMapManager().getTimeTickDeep(), false);		//����������Ŀ��㣨�Ȳ��㲥ֹͣ�ƶ�������¼serverStopTime��
			return;
		}

		this.updateMovePositionImpl(logicTime);
	}

	void updateMovePositionImpl(long logicTime)
	{
		int interval = this.getTimeInterval(this.startMoveTick);
		float distance = (interval / 1000.0f * this.moveSpeed);
		GVector3 newPos = this.curPosition.sum(this.curRotation.scale(distance));

		this.fixNewPosition(this.curRotation, newPos, this.moveTargetPos);
		if (this.setNewPosition(newPos))
		{
			SBean.TimeTick timeTick = ms.getMapManager().getTimeTickDeep();
			this.startMoveTick = timeTick;
			if (this.getTimeInterval(this.preMoveUpdateTick) >= MapManager.PROTOCOL_AUTOSEND_INTERVAL)
			{
				this.preMoveUpdateTick = timeTick;
				notifySelfMove();
			}
		}
	}
	
	void notifySelfMove()
	{
		
	}
	
	boolean setNewPosition(GVector3 newPos)
	{
		int newGridX = this.curMap.calcGridCoordinateX((int) newPos.x);
		int newGridZ = this.curMap.calcGridCoordinateZ((int) newPos.z);
		MapGrid newGrid = this.curMap.getGrid(newGridX, newGridZ);
		if (newGrid == null || this.getCurMapGrid() == null)
		{
			this.onStopMoveImpl(this.curPosition, ms.getMapManager().getTimeTickDeep(), true);
			return false;
		}
		
		int curGridX = this.getCurMapGrid().getGridX();
		int curGridZ = this.getCurMapGrid().getGridZ();
		this.setCurPosition(newPos);
		boolean change = this.changeMapGrid(newGrid);
		if (change)
			this.changePosition(curGridX, curGridZ, newGridX, newGridZ, 0);
		
		return true;
	}
	
	boolean trigArmorIgnoreDef()
	{
		return GameData.checkRandom(this.getFightProp(BaseRole.EPROPID_IGNDEF));
	}
	
	boolean trigArmorIgnoreCtr()
	{
		return GameData.checkRandom(this.getFightProp(BaseRole.EPROPID_IGNCTR));
	}
	
	boolean trigArmorIgnoreTou()
	{
		return GameData.checkRandom(this.getFightProp(BaseRole.EPROPID_IGNTOU));
	}
	
	//��Ŀ�����͵��ڼ��˺�ת��
	float getArmorTransRate()
	{
		return 0;
	}
	
	//��Ŀ�����͵��ڼ��˺�����
	float getArmorDmgDeep()
	{
		return 0;
	}
	
	int getCurArmor()
	{
		return 0;
	}
	
	int getArmorValue()
	{
		return this.armorMgr == null ? 0 : this.armorMgr.getArmorValue();
	}
	
	int getArmorValMax()
	{
		return this.maxArmorValue;
	}
	
	boolean setArmorVal(int value)
	{
		if(this.armorMgr == null)
			return false;
		
		return this.armorMgr.setArmorValue(value, this.maxArmorValue, this);
	}
	
	void setArmorWeak(int weak)
	{
		if(this.armorMgr == null)
			return;
		
		if(this.armorMgr.setWeakValue(weak))
			onSelfArmorWeekUpdate(this.armorMgr.getWeakValue());
	}
	
	public void onArmorDamage(SBean.ArmorDamage armorDamage)
	{
		if(this.armorMgr == null)
			return;
		
		if(armorDamage.damage != 0 || armorDamage.suck != 0 || armorDamage.destroy != 0)
			this.setArmorVal(this.armorMgr.getArmorValue() - (armorDamage.damage + armorDamage.suck + armorDamage.destroy));
		
		if(this.armorMgr.getArmorValue() > 0 && armorDamage.weak > 0)
			this.setArmorWeak(this.armorMgr.getWeakValue() + armorDamage.weak);
	}
	
	public void causeArmorDamage(SBean.ArmorDamage armorDamage)
	{
		if(this.armorMgr == null)
			return;
		
		if(this.armorMgr.getArmorValue() < this.maxArmorValue && armorDamage.suck > 0)
			this.setArmorVal(this.armorMgr.getArmorValue() + armorDamage.suck);
	}
	
	int getArmorFreezeState()
	{
		return (this.armorMgr != null && this.armorMgr.getFreezeState(ms.getMapManager().getMapLogicTime())) ? 1: 0;
	}
	
	int getArmorWeakState()
	{
		return (this.armorMgr != null && this.armorMgr.getWeakValue() > 0) ? 1 : 0; 
	}
	
	boolean trigArmorSuck()
	{
		return this.armorMgr != null && this.armorMgr.trigSuck(ms.getMapManager().getMapLogicTime());
	}
	
	boolean trigArmorDestroy()
	{
		return this.armorMgr != null && this.armorMgr.trigDestroy(ms.getMapManager().getMapLogicTime());
	}
	
	boolean trigArmorWeak()
	{
		return this.armorMgr != null && this.armorMgr.trigWeak(ms.getMapManager().getMapLogicTime());
	}
	
	void onCheckArmor(long logicTime)
	{
		this.tryRecoverArmor(logicTime);
		this.refreshArmorFreeze(logicTime);
	}
	
	private void tryRecoverArmor(long logicTime)
	{
		if(this.armorMgr.getArmorValue() < this.maxArmorValue || this.armorMgr.getWeakValue() > 0)
		{
			int revoverVal = this.getFightProp(BaseRole.EPROPID_ARMRC);
			if(revoverVal > 0 && this.armorMgr.checkRecover(logicTime))
			{
				int dt = revoverVal - this.armorMgr.getWeakValue();
				if(this.armorMgr.getWeakValue() > 0)
					this.setArmorWeak(-dt);
				
				if(dt > 0)
				{
					if(this.setArmorVal(this.getArmorValue() + dt))
						notifySelfArmorValUpdate();
				}
			}
		}
	}
	
	private void refreshArmorFreeze(long logicTime)
	{
		if(this.armorMgr.checkFreeze(logicTime))
			notifySelArmorFreezeUpdate(this.getArmorFreezeState());
	}
	
	void notifySelfArmorValUpdate()
	{
		//TODO
	}
	
	void notifySelArmorFreezeUpdate(int state)
	{
		//TODO
	}
	
	void onSelfArmorWeekUpdate(int state)
	{
		//TODO
	}
	
	String getArmorDamage(SBean.ArmorDamage ad)
	{
		return "armor: damage " + ad.damage + " suck " + ad.suck + " destory " + ad.destroy + " weak " + ad.weak + " curArmorVal " + this.getArmorValue() + " maxArmorVal " + this.getArmorValMax();
	}
	
	public class ArmorManager
	{
		private long recoverTime;
		private long freezeEndTime;
		private long suckCoolTime;
		private long destoryCoolTime;
		private long weakCoolTime;
		
		private int weakValue;
		private int armorValue;
		
		ArmorManager(int armorValue)
		{
			this.armorValue = armorValue;
		}
		
		int getArmorValue()
		{
			return armorValue;
		}
		
		boolean setArmorValue(int val, int maxVal, BaseRole self)
		{
			if(val < 0)
				val = 0;
			
			if(val > maxVal)
				val = maxVal;
			
			if(this.armorValue != val)
			{
				this.armorValue = val;
				long now = ms.getMapManager().getMapLogicTime();
				if(this.armorValue == 0 && now > this.freezeEndTime)
				{
					this.freezeEndTime = now + GameData.getInstance().getCommonCFG().armor.freezeTime + self.getFightProp(BaseRole.EPROPID_ARMFASTFZ);
					this.recoverTime = this.freezeEndTime + GameData.getInstance().getCommonCFG().armor.recoverInterval;
					self.notifySelArmorFreezeUpdate(1);
					
					if(this.weakValue > 0)
					{
						this.weakValue = 0;
						self.onSelfArmorWeekUpdate(0);
					}
				}
				return true;
			}
			
			return false;
		}
		
		boolean checkRecover(long logicTime)
		{
			if(logicTime > this.recoverTime)
			{
				this.recoverTime = logicTime + GameData.getInstance().getCommonCFG().armor.recoverInterval;
				return true;
			}
			return false;
		}
		
		boolean checkFreeze(long logicTime)
		{
			if(this.freezeEndTime == 0)
				return false;
			
			if(logicTime > this.freezeEndTime)
			{
				this.freezeEndTime = 0;
				return true;
			}
			
			return false;
		}
		
		boolean getFreezeState(long logicTime)
		{
			return logicTime < this.freezeEndTime;
		}
		
		int getWeakValue()
		{
			return weakValue;
		}
		
		boolean setWeakValue(int weak)
		{
			boolean change = (this.weakValue > 0 && weak <= 0) || (this.weakValue == 0 && weak > 0);
			this.weakValue = weak;
			if(this.weakValue < 0)
				this.weakValue = 0;
			
			return change;
		}
		
		boolean trigSuck(long now)
		{
			if(now > suckCoolTime)
			{
				suckCoolTime = now + GameData.getInstance().getCommonCFG().armor.suck.interval;
				return true;
			}
			return false;
		}
		
		boolean trigDestroy(long now)
		{
			if(now > destoryCoolTime)
			{
				destoryCoolTime = now + GameData.getInstance().getCommonCFG().armor.destroy.interval;
				return true;
			}
			return false;
		}
		
		boolean trigWeak(long now)
		{
			if(now > weakCoolTime)
			{
				weakCoolTime = now + GameData.getInstance().getCommonCFG().armor.weak.interval;
				return true;
			}
			return false;
		}
	}
	
	public static class Buff
	{
		Buff(long endTime, int id, int realmLvl, long preTime, int overLays, int value, int attackerType, int attackerID, int attackOwnerID, String attackName, byte attackClassType,
				int spiritEffectID, boolean canRemoveByParent, boolean hasShowID)
		{
			this.id = id;
			this.realmLvl = realmLvl;
			this.endTime = endTime;
			this.preTime = preTime;
			this.overLays = overLays;
			this.value = value;
			this.attackerType = attackerType;
			this.attackerID = attackerID;
			this.attackOwnerID = attackOwnerID;
			this.attackName = attackName;
			this.attackClassType = attackClassType;
			this.spiritEffectID = spiritEffectID;
			this.canRemoveByParent = canRemoveByParent;
			this.hasShowID = hasShowID;
		}

		public int id;
		public int realmLvl;
		public long endTime;
		public long preTime;
		public int overLays;
		public int value;
		public int attackerType;
		public int attackerID;
		public int attackOwnerID;
		public String attackName = "m";
		public byte attackClassType;
		public int spiritEffectID;
		public boolean canRemoveByParent;
		public boolean hasShowID;
		public boolean diySkill;
		public boolean canRebound = true;
		List<Integer> trigAis = new ArrayList<>();
	}

	public static class Fear
	{
		private static final int FEAR_DISTANCE_ERROE = 50;
		private static final int FEAR_DISTANCE_MOVE_MIN = 200;
		private static final int FEAR_DISTANCE_MOVE_MAX = 500;

		Fear(GVector3 startPos, long endTime)
		{
			this.targetPos = new GVector3().reset(startPos).selfSum(createMovePos());
			this.endTime = endTime;
		}

		GVector3 calcMovePos(GVector3 curPosition)
		{
			float distance = this.targetPos.distance(curPosition);
			if (distance < FEAR_DISTANCE_ERROE)
				this.targetPos.selfSum(createMovePos());

			return this.targetPos;
		}

		void forceSetTargetPos(GVector3 targetPostion)
		{
			this.targetPos.reset(targetPostion);
		}

		GVector3 createMovePos()
		{
			int rand = GameRandom.getRandom().nextInt(2);
			int x = GameRandom.getRandInt(FEAR_DISTANCE_MOVE_MIN, FEAR_DISTANCE_MOVE_MAX);
			int z = GameRandom.getRandInt(FEAR_DISTANCE_MOVE_MIN, FEAR_DISTANCE_MOVE_MAX);
			if (rand == 0)
				x = -x;

			rand = GameRandom.getRandom().nextInt(2);
			if (rand == 0)
				z = -z;

			return new GVector3(x, 0, z);
		}

		GVector3 targetPos;
		long endTime;
	}

	public static class EntityCluster
	{
		List<MapRole> roles;
		List<Pet> pets;
		List<Blur> blurs;
		List<SkillEntity> skillEntitys;
		List<Monster> monsters;
		List<Npc> npcs;
		List<MapBuff> mapBuffs;
		List<Mineral> minerals;
		List<Trap> traps;
		List<WayPoint> wayPoints;

		EntityCluster()
		{
			roles = new ArrayList<>();
			pets = new ArrayList<>();
			blurs = new ArrayList<>();
			skillEntitys = new ArrayList<>();
			monsters = new ArrayList<>();
			npcs = new ArrayList<>();
			mapBuffs = new ArrayList<>();
			minerals = new ArrayList<>();
			traps = new ArrayList<>();
			wayPoints = new ArrayList<>();
		}
	}

	public static class EnterInfo
	{
		Map<Integer, SBean.EnterDetail> roles;
		List<SBean.EnterPet> pets;
		List<SBean.EnterBase> traps;
		List<SBean.EnterDetail> blurs;
		List<SBean.EnterMonster> monsters;
		List<SBean.EnterSkillEntity> skillEntitys;
		List<SBean.EnterBase> npcs;
		List<SBean.EnterBase> mapBuffs;
		List<SBean.EnterMineral> minerals;
		List<SBean.EnterBase> wayPoints;
		List<SBean.EnterEscortCar> cars;
		List<SBean.EnterWeddingCar> wcars;

		EnterInfo()
		{
			roles = GameData.emptyMap();
			pets = GameData.emptyList();
			blurs = GameData.emptyList();
			skillEntitys = GameData.emptyList();
			monsters = GameData.emptyList();
			npcs = GameData.emptyList();
			mapBuffs = GameData.emptyList();
			minerals = GameData.emptyList();
			traps = GameData.emptyList();
			wayPoints = GameData.emptyList();
			cars = GameData.emptyList();
			wcars = GameData.emptyList();
		}
		
		EnterInfo createNew()
		{
			roles = new HashMap<>();
			pets = new ArrayList<>();
			blurs = new ArrayList<>();
			skillEntitys = new ArrayList<>();
			monsters = new ArrayList<>();
			npcs = new ArrayList<>();
			mapBuffs = new ArrayList<>();
			minerals = new ArrayList<>();
			traps = new ArrayList<>();
//			wayPoints = new ArrayList<>();
			cars = new ArrayList<>();
			wcars = new ArrayList<>();
			return this;
		}
	}

	public static class LeaveInfo
	{
		List<Integer> roles;
		List<SBean.PetBase> pets;
		List<Integer> traps;
		List<Integer> blurs;
		List<Integer> monsters;
		List<Integer> skillEntitys;
		List<Integer> npcs;
		List<Integer> mapBuffs;
		List<Integer> minerals;
		List<Integer> wayPoints;
		List<Integer> cars;
		List<Integer> wcars;
		
		LeaveInfo()
		{
			roles = new ArrayList<>();
			pets = new ArrayList<>();
			blurs = new ArrayList<>();
			skillEntitys = new ArrayList<>();
			monsters = new ArrayList<>();
			npcs = new ArrayList<>();
			mapBuffs = new ArrayList<>();
			minerals = new ArrayList<>();
			traps = new ArrayList<>();
			wayPoints = new ArrayList<>();
			cars = new ArrayList<>();
			wcars = new ArrayList<>();
		}
	}

	/////////////////////////////////////
	public class SkillData
	{
		int id;
		int level;
		SBean.SkillBaseCommonCFGS baseCommonCfg;
		SBean.SkillBaseFixCFGS baseFixCfg;
		SBean.SkillLevelFixCFGS lvlFixCfg;

		SkillData(int id, int level)
		{
			this.id = id;
			this.level = level;
		}

		SkillData createNew(SBean.SkillBaseCFGS baseData, SBean.SkillLevelFixCFGS lvlFixCfg)
		{
			this.baseCommonCfg = baseData.common;
			this.baseFixCfg = baseData.fix;
			this.lvlFixCfg = lvlFixCfg;
			return this;
		}
	}

	public static class FightSkill
	{
		FightSkill(int id, int level, long coolDownTime, int realmLvl, int skillGroup, float coolDownPercent, int useType)
		{
			this.id = id;
			this.level = level;
			this.coolDownTime = coolDownTime;
			this.realmLvl = realmLvl;
			this.skillGroup = skillGroup;
			this.setCoolDownPercent(coolDownPercent);
			this.useType = useType;
		}

		FightSkill copySkillData()
		{
			SBean.SkillCFGS sCfg = GameData.getInstance().getSkillCFG(id);
			if (sCfg == null)
				return null;
			
			if(this.level > sCfg.lvlDatas.size())
				this.level = sCfg.lvlDatas.size();
			
			SBean.SkillLevelCFGS sDataCfg = GameData.getSkillLevelCFG(sCfg, level);
			if (sDataCfg == null)
				return null;
			
			this.baseDataCfg = sCfg.baseData;
			this.lvlFixCfg = sDataCfg.fix;
			return this;
		}

		void setCoolDownPercent(float percent)
		{
			if(percent < 0)
				percent = 0;
			
			this.coolDownPercent = percent;
		}
		
		int skillGroup;
		int id;
		int level;
		int realmLvl;
		long coolDownTime;
		float coolDownPercent = 1.f;
		SBean.SkillBaseCFGS baseDataCfg;
		SBean.SkillLevelFixCFGS lvlFixCfg;
		boolean itemSkill;
		int useType;
	}

	public static class MapEntity
	{
		MapEntity(int entityType, int entityID, int ownerID)
		{
			this.entityType = entityType;
			this.entityID = entityID;
			this.ownerID = ownerID;
		}

		int entityType;
		int entityID;
		int ownerID;
	}

	//����
	public static class GuideInfo
	{
		int interval;
		int damageCount;
		int damageEventID;
		int type;
		int duration;
		boolean autoChangeRotation;

		GuideInfo(int interval, int damageCount, int damageEventID, int type, int duration, boolean autoChangeRotation)
		{
			this.interval = interval;
			this.damageCount = damageCount;
			this.damageEventID = damageEventID;
			this.type = type;
			this.duration = duration;
			this.autoChangeRotation = autoChangeRotation;
			
			if (type == GameData.GUIDE_SKILL_BYTIME)
				this.damageCount = (int) Math.ceil((float) duration / (float) interval);
		}
	}

	//���
	public static class RushInfo
	{
		int type;
		int distance;
		int speed;
		long rushEndTime;
		GVector3 rushEndPos;
		boolean rushStart;
		long preUpdateTime;
		GVector3 rushRotation;

		RushInfo(int type, int distance, int speed, long rushEndTime, GVector3 rushEndPos, GVector3 rushRotation)
		{
			this.type = type;
			this.distance = distance;
			this.speed = speed;
			this.rushEndTime = rushEndTime;
			this.rushEndPos = rushEndPos;
			this.rushRotation = rushRotation;
		}
	}

	//����
	public static class ShiftInfo
	{
		int type;
		int distance;
		int speed;
		int odds;
		List<BaseRole> shiftTarget;

		ShiftInfo(int type, int distance, int speed, int odds)
		{
			this.type = type;
			this.distance = distance;
			this.speed = speed;
			this.odds = odds;
			shiftTarget = new ArrayList<>();
		}
	}
	
	public static class SummonInfo
	{
		int type;
		int mid;		//type 1: ����ID, type 2:ģ��ID
		int skillID;	//type 2ʱ��Ч
		int maxCount;
		int radius;
		int speed;		//type 2ʱ��Ч
		int angle;
		
		SummonInfo(int type, int mid, int skillID, int maxCount, int radius, int speed, int angle)
		{
			this.type = type;
			this.mid = mid;
			this.skillID = skillID;
			this.maxCount = maxCount;
			this.radius = radius;
			this.speed = speed;
			this.angle = angle;
		}
	}
	
	//�˺��¼�ʱ��������
	public static class DmgToSkillInfo
	{
		int skillID;
		int skillLvl;
		int positionType;

		DmgToSkillInfo(int skillID, int skillLvl, int positionType)
		{
			this.skillID = skillID;
			this.skillLvl = skillLvl;
			this.positionType = positionType;
		}
	}

	//�޸��˺���ֵ
	public static class DmgFixInfo
	{
		int valueType;
		double value;
		int condition;
		int arg1;
		int arg2;
		int arg3;
		int arg4;

		DmgFixInfo(int valueType, int value, int condition, int arg1, int arg2, int arg3, int arg4)
		{
			this.valueType = valueType;
			if (valueType == GameData.VALUE_TYPE_FIXED)
				this.value = value;
			else if (valueType == GameData.VALUE_TYPE_PERCENT)
				this.value = (float) value / 10000.0f;

			this.condition = condition;
			this.arg1 = arg1;
			this.arg2 = arg2;
			this.arg3 = arg3;
			this.arg4 = arg4;
		}
	}

	//���м���
	public static class FlyInfo
	{
		int type;
		int speed;
		int maxTime;
		long preFlyTime;

		FlyInfo(int type, int speed, int maxTime, long preFlyTime)
		{
			this.type = type;
			this.speed = speed;
			this.maxTime = maxTime;
			this.preFlyTime = preFlyTime;
		}
	}

	//�⻷
	public static class AuraInfo
	{
		public static final int AURA_OFFSET = 30;

		int type;
		int radius;
		int targetType;
		long endTime;
		Buff buff;
		List<BaseRole> effectEntitys;

		AuraInfo(int type, int radius, int targetType, long endTime, Buff buff)
		{
			this.type = type;
			this.radius = radius;
			this.targetType = targetType;
			this.endTime = endTime;
			this.buff = buff;
			this.effectEntitys = new ArrayList<>();
		}
	}

	//�������
	public static class ExtraDropInfo
	{
		int monsterType;
		List<Integer> monsterId;
		int dropId;
		int dropTime;
		int teamShare;

		ExtraDropInfo(int monsterType, List<Integer> monsterId, int dropId, int dropTime, int teamShare)
		{
			this.monsterType = monsterType;
			this.monsterId = monsterId;
			this.dropId = dropId;
			this.dropTime = dropTime;
			this.teamShare = teamShare;
		}
	}

	//�޵�ն
	public static class SlashInfo
	{
		int interval;
		int damageCount;

		SlashInfo(int interval, int damageCount)
		{
			this.interval = interval;
			this.damageCount = damageCount;
		}
	}
	
	public static class SpiritCluster
	{
		//<skillID, SpiritContainer>
		//<specialID, >
		//<aid, >
		Map<Integer, SpiritContainer> containers;

		SpiritCluster()
		{
			this.containers = new HashMap<>();
		}

		public static class SpiritContainer
		{
			//<�ֶ�, SBean.SpiritEffectCFGS>
			Map<Integer, SBean.SpiritEffectCFGS> spiritEffects;

			SpiritContainer()
			{
				this.spiritEffects = new HashMap<>();
			}
		}
	}

	public class ClassRole
	{
		int roleID;
		int classType;
		
		ClassRole(int roleID, int classType)
		{
			this.roleID = roleID;
			this.classType = classType;
		}
		
		void clear()
		{
			this.roleID = 0;
			this.classType = 0;
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	public static final int DISTANCEERROR = 500; //�������
	// ����ID
	public static final int EPROPID_ENTITY = 0; //ͨ�����Կ�ʼid
	public static final int EPROPID_HERO = 1000; //Ӣ�����Կ�ʼid

	public static final int EPROPID_LVL		= EPROPID_ENTITY + 1; //�ȼ�
	public static final int EPROPID_SPEED	= EPROPID_ENTITY + 2; //�ƶ��ٶ�
	
	public static final int EPROPID_MAXHP	= EPROPID_HERO +  1; // �������ֵ
	public static final int EPROPID_ATKN	= EPROPID_HERO +  2; // ������
	public static final int EPROPID_DEFN	= EPROPID_HERO +  3; // ������
	public static final int EPROPID_ATR		= EPROPID_HERO +  4; // ����ֵ
	public static final int EPROPID_CTR		= EPROPID_HERO +  5; // ����ֵ
	public static final int EPROPID_ACRN	= EPROPID_HERO +  6; // ����
	public static final int EPROPID_TOU		= EPROPID_HERO +  7; // ����
	public static final int EPROPID_ATKA	= EPROPID_HERO +  8; // �����˺�
	public static final int EPROPID_DEFA	= EPROPID_HERO +  9; // ��������
	public static final int EPROPID_DEFLECT	= EPROPID_HERO + 10; // ƫб��
	public static final int EPROPID_ATKD	= EPROPID_HERO + 11; // ƫб�˺�
	public static final int EPROPID_ATKH	= EPROPID_HERO + 12; // ��ʥ�˺�
	public static final int EPROPID_ATKC	= EPROPID_HERO + 13; // �ķ��˺�(citta)
	public static final int EPROPID_DEFC	= EPROPID_HERO + 14; // �ķ�����
	public static final int EPROPID_ATKW	= EPROPID_HERO + 15; // ����˺�
	public static final int EPROPID_DEFW	= EPROPID_HERO + 16; // �������
	public static final int EPROPID_MASTERC	= EPROPID_HERO + 17; // �ķ���ͨ
	public static final int EPROPID_MASTERW	= EPROPID_HERO + 18; // �����ͨ
	public static final int EPROPID_HEALA	= EPROPID_HERO + 19; // ���Ʊ���
	public static final int EPROPID_SBD		= EPROPID_HERO + 20; // ��Ѫ
	public static final int EPROPID_SHELL	= EPROPID_HERO + 21; // ����
	public static final int EPROPID_DMGTOWM	= EPROPID_HERO + 22; // ��Ұ�޹��˺�����
	public static final int EPROPID_DMGTORM	= EPROPID_HERO + 23; // �Ե��˹��˺�����
	public static final int EPROPID_DMGTOKM	= EPROPID_HERO + 24; // �����߹��˺�����
	public static final int EPROPID_DMGTOAM	= EPROPID_HERO + 25; // �Դ̿͹��˺�����
	public static final int EPROPID_DMGTOMM	= EPROPID_HERO + 26; // ����ʦ���˺�����
	public static final int EPROPID_DMGBYWM	= EPROPID_HERO + 27; // ��Ұ�޹��˺�����
	public static final int EPROPID_DMGBYRM	= EPROPID_HERO + 28; // �Ե��˹��˺�����
	public static final int EPROPID_DMGBYKM	= EPROPID_HERO + 29; // �����߹��˺�����
	public static final int EPROPID_DMGBYAM	= EPROPID_HERO + 30; // �Դ̿͹��˺�����
	public static final int EPROPID_DMGBYMM	= EPROPID_HERO + 31; // ����ʦ���˺�����
	public static final int EPROPID_RES1	= EPROPID_HERO + 32; // ״̬����1
	public static final int EPROPID_RES2	= EPROPID_HERO + 33; // ״̬����2
	public static final int EPROPID_RES3	= EPROPID_HERO + 34; // ״̬����3
	public static final int EPROPID_DMGTOEM	= EPROPID_HERO + 35; // ��а�ȹ��˺�����
	public static final int EPROPID_DMGBYEM	= EPROPID_HERO + 36; // ��а�ȹ��˺�����
	public static final int EPROPID_HP		= EPROPID_HERO + 37; // ��ǰ��Ѫ
	public static final int EPROPID_ALTERRANGE	= EPROPID_HERO + 38; // Ԥ����Χ
	public static final int EPROPID_MAXSP	= EPROPID_HERO + 39; // �������
	public static final int EPROPID_SP		= EPROPID_HERO + 40; // ��ǰ����
	public static final int EPROPID_HEALGAIN	= EPROPID_HERO + 41; // ����Ч���ӳ�
	public static final int EPROPID_DEFSTTIKE	= EPROPID_HERO + 42; // ���ӷ���
	public static final int EPROPID_DMGTO	= EPROPID_HERO + 43; // �˺��ӳ�
	public static final int EPROPID_DMGBY	= EPROPID_HERO + 44; // �˺�����
	public static final int EPROPID_BEHEALGAIN	= EPROPID_HERO + 45; // ������Ч���ӳ�
	public static final int EPROPID_ATKIF		= EPROPID_HERO + 46; // ����
	public static final int EPROPID_STEPS		= EPROPID_HERO + 47; // ��
	
	//�ڼ��¼�����
	public static final int EPROPID_ARMMAXHP		= EPROPID_HERO + 48; // �ڼ�ֵ
	public static final int EPROPID_ARMDEF			= EPROPID_HERO + 49; // �ڼ׷���
	public static final int EPROPID_ARMTRF			= EPROPID_HERO + 50; // �ڼ�����
	public static final int EPROPID_ARMRC			= EPROPID_HERO + 51; // �ڼ׻ظ�
	public static final int EPROPID_ARMFASTFZ		= EPROPID_HERO + 52; // �ڼ׶���ָ�(���ٶ���ָ�ʱ��)
	public static final int EPROPID_ARMSUCK			= EPROPID_HERO + 53; // �ڼ�����
	public static final int EPROPID_ARMDESTROY		= EPROPID_HERO + 54; // �ڼ����
	public static final int EPROPID_ARMWEAK			= EPROPID_HERO + 55; // �ڼ�����
	public static final int EPROPID_NADEEP			= EPROPID_HERO + 56; // ��ͨ�����˺�����
	public static final int EPROPID_IGNDEF			= EPROPID_HERO + 57; // ���ӷ���
	public static final int EPROPID_IGNCTR			= EPROPID_HERO + 58; // ��������
	public static final int EPROPID_IGNTOU			= EPROPID_HERO + 59; // ��������
	public static final int EPROPID_FASTSKILL		= EPROPID_HERO + 60; // ����
	public static final int EPROPID_ARMCURHP		= EPROPID_HERO + 61; // ��ǰ�ڼ�ֵ
	
	//����Ǭ���¼�����
	public static final int EPROPID_DMGTO_BLADE	= EPROPID_HERO + 62; // �Ե�ϵ�˺��ӳ�
	public static final int EPROPID_DMGBY_BLADE	= EPROPID_HERO + 63; // �ܵ�ϵ�˺�����
	public static final int EPROPID_DMGTO_SWORD	= EPROPID_HERO + 64; // �Խ�ϵ�˺��ӳ�
	public static final int EPROPID_DMGBY_SWORD	= EPROPID_HERO + 65; // �ܽ�ϵ�˺�����
	public static final int EPROPID_DMGTO_SPEAR	= EPROPID_HERO + 66; // ��ǹϵ�˺��ӳ�
	public static final int EPROPID_DMGBY_SPEAR	= EPROPID_HERO + 67; // ��ǹϵ�˺�����
	public static final int EPROPID_DMGTO_ARROW	= EPROPID_HERO + 68; // �Թ�ϵ�˺��ӳ�
	public static final int EPROPID_DMGBY_ARROW	= EPROPID_HERO + 69; // �ܹ�ϵ�˺�����
	public static final int EPROPID_DMGTO_HEAL	= EPROPID_HERO + 70; // ��ҽϵ�˺��ӳ�
	public static final int EPROPID_DMGBY_HEAL	= EPROPID_HERO + 71; // ��ҽϵ�˺�����
	
	public static final int EPROPID_DMGTO_ENEMY	= EPROPID_HERO + 75; // �Եж�����˺�����
	public static final int EPROPID_DMGBY_ENEMY	= EPROPID_HERO + 76; // �ܵж�����˺�����
	
	///////////
	public static final int ECTRL_TYPE_AI = 0;			//ai ����
	public static final int ECTRL_TYPE_PLAYER = 1;		//��ҿ���
	
	//BUFF���ӷ�ʽ
	public static final int BUFF_TYPE_ADDVALUE_KEEPTIME		= 1;	//��ֵ���ӣ�ʱ�䱣��
	public static final int BUFF_TYPE_KEEPVALUE_ADDTIME		= 2;	//��ֵ�����ӣ�ʱ�����
	public static final int BUFF_TYPE_MAXVALUE_KEEPTIME		= 3;	//��ֵȡ���ֵ��ʱ�䱣��
	public static final int BUFF_TYPE_MAXVALUE_RESETTIME	= 4;	//��ֵȡ���ֵ��ʱ������
	
	//group type
	public static final int eGroupType_U = 0;	//��Ч
	public static final int eGroupType_O = 1;	//����
	public static final int eGroupType_E = 2;	//�з�
	public static final int eGroupType_N = 4;	//����
	
	///////////
	final int timerInterval;
	final MapServer ms;
	final boolean serverControl;
	Map<Integer, SpiritCluster> allSpirits = new HashMap<>(); //<type, SBean.SpiritEffectCFGS>
	Map<Integer, SpiritCluster> horseSkillSpirits = new HashMap<>(); //<type, SBean.SpiritEffectCFGS>
	int level;
	int speed;
	int id;
	int configID;
	int entityType;
	int ctrlType;
	int radius;
	long lastLogicTime;

	MapRole owner;
	BaseRole caller;
	List<Monster> summonMonsters = new ArrayList<>();
	int race; //��������

	int curHP;
	int maxHp;
	BaseMap curMap;
	int curMapID;
	MapGrid curMapGrid;
	GVector3 curPosition = new GVector3();
	GVector3 birthPosition = new GVector3();
	GVector3 curRotation = new GVector3();
	PropBase propBase;
	Map<Integer, RoleState> curStates = new TreeMap<>();
	List<Integer> curSkills = new ArrayList<>();
	TrigerAiMgr trigerAiMgr;
	Fear curFear; //�־�
	List<Integer> attackList = new ArrayList<>();
	Map<Integer, Long> specialState = new HashMap<>(); //<stateID, endTime>

	Map<Integer, Buff> buffs = new TreeMap<>();
	List<Buff> buffsAddCache = new ArrayList<>();
	List<Buff> buffsRemoveCache = new ArrayList<>();
	Map<Integer, FightSkill> fightSkills = new TreeMap<>();

	//move
	GVector3 moveTargetPos = new GVector3();
	GVector3 moveTargetRealPos = new GVector3();
	BaseRole moveTarget;
	int moveSpeed;
	long preMoveTime;
	int maxTraceRange;			//׷�����뾶
	SBean.TimeTick startMoveTick = new SBean.TimeTick();
	SBean.TimeTick preMoveUpdateTick = new SBean.TimeTick();
	long serverStopTime;

	Skill attack;
	List<Skill> curUseSkills = new ArrayList<>();
	List<Skill> curUseSkillRemoveCache = new ArrayList<>();
	List<Skill> curUseSkillAddCache = new ArrayList<>();

	List<Skill> trigSkills = new ArrayList<>();
	List<Skill> trigSkillAddCache = new ArrayList<>();
	List<Skill> trigSkillRemoveCache = new ArrayList<>();
	
	Map<Integer, Skill> followSkills = new HashMap<>();
	Set<Integer> followSkillRemoveCache = new HashSet<>();

	Integer curSkillID;
	long startAttackTime;
	int attackRange;
	boolean isAttacked;
	List<BaseRole> enmityList = new ArrayList<>();
	MapEntity forceTarget; //ǿ��Ŀ��
	int curShiftSkillID;
	BaseRole lastAttacker;
	boolean hasAttack;
	ClassRole dmgRole;

	boolean active = true;//����״̬
	private AtomicInteger nextTrigAiID = new AtomicInteger();
	int forceType;
	
	ArmorManager armorMgr;
	int maxArmorValue;
}
