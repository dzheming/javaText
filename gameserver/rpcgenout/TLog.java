// modified by i3k.gtool.QQMetaGen at Sat May 06 17:08:08 CST 2017.

package i3k;

import ket.util.Stream;

public final class TLog
{

	// gm�޸ĵ���
	public static final int AT_GM_MOD_ITEM = 1;
	// ��ֵ
	public static final int AT_PAY = 9;
	// ϵͳ����
	public static final int AT_SYS_REWARD = 48;
	// ȫ������
	public static final int AT_WORLD_REWARD = 49;
	// ����
	public static final int AT_LEVEL_UP = 50;
	// �̳ǹ���
	public static final int AT_BUY_MALL_GOODS = 71;
	// �����̵���Ʒ
	public static final int AT_BUY_SHOP_GOOGS = 72;
	// �ӻ���
	public static final int AT_STROE_BUY = 73;
	// ������װ
	public static final int AT_BUY_SUIT = 74;
	// ��Ʒ�Ź�
	public static final int AT_GROUPUY_GOODS = 75;
	// ��ʱ����
	public static final int AT_FLASHSALE_GOODS = 76;
	// ������
	public static final int AT_BUY_COIN = 101;
	// ��������
	public static final int AT_BUY_VIT = 102;
	// ʹ��ҩˮ
	public static final int AT_USE_POTION = 103;
	// �������˴�ת�̳齱����
	public static final int AT_BUY_LUCKY_WHEEL_DRAW_TIMES = 104;
	// ǩ��
	public static final int AT_CHECKIN_TAKE = 105;
	// �״γ�ֵ�콱
	public static final int AT_TAKE_FIRST_PAY_GIFT_REWARD = 106;
	// ��ȡ��ֵ����
	public static final int AT_TAKE_PAY_GIFT_REWARD = 107;
	// ��ȡ���ѽ���
	public static final int AT_TAKE_CONSUME_GIFT_REWARD = 108;
	// ��ȡ��������
	public static final int AT_TAKE_UPGRADE_GIFT_REWARD = 109;
	// �������
	public static final int AT_BUY_INVESTMENT_FUND = 110;
	// ��ȡ������
	public static final int AT_TAKE_INVESTMENT_FUND_REWARD = 111;
	// ����ɳ�����
	public static final int AT_BUY_GROWTH_FUND = 112;
	// ��ȡ�ɳ�����
	public static final int AT_TAKE_GROWTH_FUND_REWARD = 113;
	// �һ��
	public static final int AT_TAKE_EXCHANGE_GIFT_REWARD = 114;
	// ��¼����
	public static final int AT_TAKE_LOGIN_GIFT_REWARD = 115;
	// ������ͨ�����������
	public static final int AT_BUY_NORMAL_MAPCOPY_TIMES = 116;
	// ���������������
	public static final int AT_BUY_ACTIVITY_MAPCOPY_TIMES = 117;
	// ɨ������
	public static final int AT_SWEEP_PRIVATE_MAP = 118;
	// ��ȡvip����
	public static final int AT_TAKE_VIP_REWARD = 119;
	// ��չ����
	public static final int AT_EXPAND_BAG_CELLS = 120;
	// ���۱���װ��
	public static final int AT_SELL_BAG_EQUIP = 121;
	// ���۱�����Ʒ
	public static final int AT_SELL_BAG_ITEM = 122;
	// ���۱�����ʯ
	public static final int AT_SELL_BAG_GEM = 123;
	// ���۱����·���
	public static final int AT_SELL_BAG_BOOK = 124;
	// �������۱���װ��
	public static final int AT_BATCH_SELL_BAG_EQUIPS = 125;
	// �������۱�������
	public static final int AT_BATCH_SELL_BAG_ITEMS = 126;
	// �������۱�����ʯ
	public static final int AT_BATCH_SELL_BAG_GEMS = 127;
	// �������۱����ķ���
	public static final int AT_BATCH_SELL_BAG_BOOKS = 128;
	// ʹ�����
	public static final int AT_USE_ITEM_GIFT_BOX = 129;
	// ʹ�ý�Ұ�
	public static final int AT_USE_ITEM_COIN_BAG = 130;
	// ʹ�ñ�ʯ��
	public static final int AT_USE_ITEM_DIAMOND_BAG = 131;
	// ʹ�þ��鵤
	public static final int AT_USE_ITEM_EXP = 132;
	// ʹ��Ѫƿ
	public static final int AT_USE_ITEM_HP = 133;
	// ʹ��Ѫ�ص���
	public static final int AT_USE_ITEM_HP_POOL = 134;
	// ʹ��װ��������
	public static final int AT_USE_ITEM_EQUIP_ENERGY = 135;
	// ʹ�ñ�ʯ������
	public static final int AT_USE_ITEM_GEM_ENERGY = 136;
	// ʹ���ķ���
	public static final int AT_USE_ITEM_SPIRIT_INSPIRATION = 137;
	// ʹ������ƿ
	public static final int AT_USE_ITEM_AS_VIT = 138;
	// ʹ��ʱװ��
	public static final int AT_USE_ITEM_FASHION = 139;
	// ��װ��
	public static final int AT_UP_WEAR_EQUIP = 140;
	// ��װ��
	public static final int AT_DOWN_WEAR_EQUIP = 141;
	// װ��ǿ��
	public static final int AT_EQUIP_LEVEL_UP = 142;
	// װ������
	public static final int AT_EQUIP_STAR_UP = 143;
	// ����װ��
	public static final int AT_REPAIR_EQUIP = 144;
	// ������װ��
	public static final int AT_AUTO_UP_WEAR_EQUIP = 145;
	// ��ʯ����
	public static final int AT_GEM_LEVEL_UP = 146;
	// ��ʯ��Ƕ
	public static final int AT_GEM_INLAY = 147;
	// ��ʯ����Ƕ
	public static final int AT_GEM_UNLAY = 148;
	// ���ܵȼ�����
	public static final int AT_SKILL_LEVEL_UP = 149;
	// ����ǿ��
	public static final int AT_SKILL_ENHANCE = 150;
	// ѧϰ�ķ�
	public static final int AT_LEARN_SPIRIT = 151;
	// �ķ�����
	public static final int AT_SPIRIT_LEVEL_UP = 152;
	// �������
	public static final int AT_MAKE_WEAPON = 153;
	// �������
	public static final int AT_WEAPON_LEVEL_UP = 154;
	// �����������
	public static final int AT_WEAPON_BUY_LEVEL = 155;
	// ����Ӷ��
	public static final int AT_MAKE_PET = 156;
	// Ӷ��תְ
	public static final int AT_PET_TRANSFORM = 157;
	// Ӷ������
	public static final int AT_PET_LEVEL_UP = 158;
	// Ӷ����������
	public static final int AT_PET_BUY_LEVEL = 159;
	// Ӷ������
	public static final int AT_PET_STAR_UP = 160;
	// Ӷ������ͻ��
	public static final int AT_PET_BREAK_SKILL_LEVEL_UP = 161;
	// ��ȡÿ��������
	public static final int AT_TAKE_DAILY_TASK_REWARD = 162;
	// ��ȡ��ս������
	public static final int AT_TAKE_CHALLENGE_TASK_REWARD = 163;
	// ��ȡÿ�����߽���
	public static final int AT_TAKE_DAILY_ONLINE_GIFT = 164;
	// ���˴�ת�̳齱
	public static final int AT_LUCKY_WHEEL_ON_DRAW = 165;
	// ��ȡ����������
	public static final int AT_TAKE_MAIN_TASK_REWARD = 166;
	// ��ȡ���������
	public static final int AT_TAKE_WEAPON_TASK_REWARD = 167;
	// �����Դ��书����
	public static final int AT_DIY_SKILL_BUY_TIMES = 168;
	// ����ֽ�װ������
	public static final int AT_CLAN_SPLIT_SP_BUY = 169;
	// ����ս֮����Ǩ��
	public static final int AT_CLAN_MOVE_POSITION = 170;
	// ��ͼ���͵�NPC
	public static final int AT_TELEPORT_NPC = 171;
	// ��ͼ���͵�����
	public static final int AT_TELEPORT_MONSTER = 172;
	// ��ͼ���͵���
	public static final int AT_TELEPORT_MINERAL = 173;
	// �����������ȴ
	public static final int AT_ARENA_RESET_COOL = 174;
	// �������������
	public static final int AT_ARENA_BUY_TIMES = 175;
	// ��������ȡ���ֽ���
	public static final int AT_TAKE_ARENA_SCORE_REWARD = 176;
	// �������ͻ�
	public static final int AT_GIVE_FRIEND_FLOWER = 177;
	// ����װ��
	public static final int AT_PUT_ON_EQUIP = 178;
	// ���۵���
	public static final int AT_PUT_ON_NORMAL_ITEMS = 179;
	// ȡ�����۵���װ��
	public static final int AT_PUT_OFF_AUCTION_ITEMS = 180;
	// ������۵���װ��
	public static final int AT_BUY_AUCTION_ITEMS = 181;
	// ������۸���
	public static final int AT_EXPAND_AUCTION_CELLS = 182;
	// ˢ�²ر�ͼ��Ƭ
	public static final int AT_REFRESH_TREASURE_INFO = 183;
	// ����ر�ͼ��Ƭ
	public static final int AT_BUY_TREASURE_PIECES = 184;
	// ����Ѱ��
	public static final int AT_TREASURE_TOTAL_SEARCH = 185;
	// ����װ��
	public static final int AT_MEDAL_GROW = 186;
	// ѱ������
	public static final int AT_TAME_HORSE = 187;
	// ��������
	public static final int AT_UP_STAR_HORSE = 188;
	// ����ǿ��
	public static final int AT_ENHANCE_HORSE = 189;
	// ����û�
	public static final int AT_ACTIVATE_SHOW = 190;
	// ѧϰ���＼��
	public static final int AT_LEARN_HORSE_SKILL = 191;
	// ���Ź����ж���
	public static final int AT_CLAN_BUY_DO_POWER = 192;
	// ���Ĵ�����
	public static final int AT_USE_CHAT_ITEM = 193;
	// �����ڿ�
	public static final int AT_SYNC_END_MINE = 194;
	// ʰȡ����ͽ�����Ʒ������
	public static final int AT_ADD_DROP_TO_BAG = 195;
	// ��ȡɨ������ͽ�����Ʒ����
	public static final int AT_SWEEP_ADD_DROP_TO_BAG = 196;
	// ��ȡ�ʼ�����
	public static final int AT_TAKE_MAIL_ATTACHMENT = 197;
	// ��ȡȫ���ʼ�����
	public static final int AT_TAKE_ALL_MAIL_ATTACHMENT = 198;
	// ������ͨ����������
	public static final int AT_COMMON_MAPCOPY_ONSTART = 199;
	// ��ȡͨ�ظ������̽���
	public static final int AT_ON_SELECT_REWARD_CARD = 200;
	// ������ɸ���������
	public static final int AT_SECT_MAPCOYP_ONSTART = 201;
	// ���ɸ��������˺�����
	public static final int AT_SECT_MAPCOYP_ONEND = 202;
	// ����������������������
	public static final int AT_ARENA_MAPCOPY_ONEND = 203;
	// ԭ�ظ���
	public static final int AT_REVIVE_IN_SITU = 204;
	// תְ
	public static final int AT_TRANSFORM = 205;
	// �ڿ�
	public static final int AT_TRY_START_MINE = 206;
	// �����һ�����
	public static final int AT_TAKE_GIFT_PACKAGE_REWARD = 207;
	// �û�ˢ���̵�
	public static final int AT_USER_REFRESH_SHOP = 208;
	// ����ɾ����������
	public static final int AT_DEL_LOCKED_BAG_ITEMS = 209;
	// ����ˢ������
	public static final int AT_TRY_REFRESH_VIT = 210;
	// ����ˢ�·ֽ�����
	public static final int AT_TRY_REFRESH_SPLIT_SP = 211;
	// ʹ�ó齱����
	public static final int AT_USE_ITEM_CHEST_IMPL = 212;
	// ʹ���䷽����
	public static final int AT_USE_ITEM_AS_RECIPEREEL = 213;
	// �������
	public static final int AT_WEAPON_STAR_UP = 214;
	// �����°���
	public static final int AT_CREATE_NEW_SECT = 215;
	// ����Ĥ�ݰ��ɳ�Ա
	public static final int AT_TRY_WORSHIP_SECT_MEMBER = 216;
	// ���Կ���������ϯ
	public static final int AT_TRY_OPEN_SECT_BANQUET = 217;
	// ���ԲμӰ�����ϯ
	public static final int AT_TRY_JOIN_SECT_BANQUET = 218;
	// ��ɰ�������
	public static final int AT_SECT_TASK_FINISH_CB = 219;
	// �ύ�������
	public static final int AT_TEST_LOG_TASK = 220;
	// ˢ�°�������
	public static final int AT_SECT_TASK_RESET_CB = 221;
	// ��ȡ���ɹ���������
	public static final int AT_SECT_TASK_TAKE_SHARE_REWARDS = 222;
	// �޸İ�������
	public static final int AT_CHANGE_SECT_NAME_CB = 223;
	// ���Ͱ�����Ϣ
	public static final int AT_SECT_SEND_MAIL_CB = 224;
	// �Դ��书������λ
	public static final int AT_DIYSKILL_SLOT_UNLOCK = 225;
	// ��������
	public static final int AT_BUY_PRESTIGE = 226;
	// ��������
	public static final int AT_CLAN_CREATE = 227;
	// ���ż�����ͽ
	public static final int AT_CLAN_SHOUTU_SPEEDUP = 228;
	// ���ż��ٱ���
	public static final int AT_CLAN_BIWU_SPEEDUP = 229;
	// ���Ų�ʩ��ʼ
	public static final int AT_CLAN_BUSHI_START = 230;
	// �����쾭�齱��
	public static final int AT_OFFLINE_EXP = 231;
	// ���ž���������Ӣ��������
	public static final int AT_CLAN_RUSH_TOLLGATE_TO_EXP = 232;
	// ���ŵ���������Ӣ��������
	public static final int AT_CLAN_RUSH_TOLLGATE_TO_ITEM = 233;
	// ���ſ�����
	public static final int AT_CLAN_ORE_BUILD_UPLEVEL = 234;
	// ������ӿ�
	public static final int AT_ADD_CLAN_ORE = 235;
	// ���ſ������Ʒ
	public static final int AT_SYNC_ADD_ORE = 236;
	// ���Ŵ�����ʼ
	public static final int AT_CLAN_CHUANDAO_START = 237;
	// ����ռ�����
	public static final int AT_CLAN_ORE_OCCUPY_FINISH = 238;
	// ���Ŷ������
	public static final int AT_CLAN_SEARCH_ORE = 239;
	// ���ſ�����ս����
	public static final int AT_CLAN_ORE_HARRY_FIGHT_END = 240;
	// ����ս���
	public static final int AT_CLAN_BATTLE_KEEK = 241;
	// ���ŷֽ�
	public static final int AT_CLAN_SPLIT = 242;
	// ���丱������
	public static final int AT_ON_SUPER_ARENA_END = 243;
	// ���ô���ʱ��
	public static final int AT_RESET_TRANS_TIME = 244;
	// ������BOSS
	public static final int AT_CHECK_CAN_TRANS_TO_BOSS = 245;
	// ���պ������͵���������
	public static final int AT_RECEIVE_FRIEND_VIT = 246;
	// ���պ������͵���������
	public static final int AT_RECEIVE_FRIEND_VIT2 = 247;
	// �ر�ͼ��������
	public static final int AT_LOG_TREASURE_TASK = 248;
	// ��ȡ�ر�ͼNPC����
	public static final int AT_TAKE_TREASURE_NPC_REWARD = 249;
	// ��ȡ�ر�ͼ��ͼ����
	public static final int AT_TAKE_TREASURE_MAP_REWARD = 250;
	// GM�����Ʒ
	public static final int AT_GM_ADD_GAME_ITEM = 251;
	// ��ӡ���ߺϳ�
	public static final int AT_SEAL_NORMAL_MAKE = 252;
	// ��ӡԪ���ϳ�
	public static final int AT_SEAL_DIAMOND_MAKE = 253;
	// ��ӡ����
	public static final int AT_SEAL_UPGRADE = 254;
	// ��ӡϴ��
	public static final int AT_SEAL_ENHANCE = 255;
	// ��ȡ��������������
	public static final int AT_ADD_EXP_COIN = 256;
	// ʹ������ƿ
	public static final int AT_USE_ITEM_EXPCOIN_POOL = 257;
	// ��������������ƿ
	public static final int AT_EXTRACT_EXPCOIN = 258;
	// ��а������������
	public static final int AT_BWARENA_MAPCOPY_ONEND = 259;
	// ��а����ˢ�¶���
	public static final int AT_BWARENA_REFRESH_ENEMY = 260;
	// ��а������ȡ���ֽ���
	public static final int AT_BWARENA_TAKE_SCORE_REWARD = 261;
	// ��а�����������
	public static final int AT_BWARENA_BUY_TIMES = 262;
	// ������ߴ浽���
	public static final int AT_RARE_BOOK_PUSH = 263;
	// �����ȡ������
	public static final int AT_RARE_BOOK_POP = 264;
	// ��������
	public static final int AT_RARE_BOOK_UNLOCK = 265;
	// ��������
	public static final int AT_RARE_BOOK_UPLVL = 266;
	// ����
	public static final int AT_GRASP_IMPL = 267;
	// ����CD����
	public static final int AT_GRASP_RESET = 268;
	// ��������
	public static final int AT_CLAN_PRODUCE = 269;
	// ���ɳ�Ա��������
	public static final int AT_ROLE_MEMEBER_USE_VIE = 270;
	// �ӿ����������ȴ
	public static final int AT_ACCELERATE_UPGRADE_COOLING = 271;
	// ���װ��ɼ��ܵ���
	public static final int AT_ADD_SECT_AURA_EXP = 272;
	// ��ȡĤ�ݽ���
	public static final int AT_TAKE_WORSHIP_REWARD = 273;
	// ��ȡ���������
	public static final int AT_TAKE_PET_TASK_REWARD = 274;
	// ��ȡ�������
	public static final int AT_TAKE_BETA_ACTIVITY_REWARD = 275;
	// ʹ���¿�����
	public static final int AT_USE_ITEM_MONTHLYCARD = 276;
	// ʹ��VIP���鿨
	public static final int AT_USE_ITEM_VIPCARD = 277;
	// ��ȡ֧��������
	public static final int AT_TAKE_BRANCH_TASK_REWARD = 278;
	// ������������
	public static final int AT_CLIMB_TOWER_BUY_TIMES = 279;
	// ��������븱��
	public static final int AT_START_CLIMB_TOWER_COPY = 280;
	// ʹ�û�ȡ������������
	public static final int AT_USER_ITEM_TOWER_FAME = 281;
	// ��ȡ������������
	public static final int AT_TAKE_TOWER_FAME_REWARD = 282;
	// ˢ�°������������б�
	public static final int AT_REFRESH_SECT_DELIVER = 283;
	// ��������Ͷ��
	public static final int AT_SECT_DELIVER_PROTECT = 284;
	// ��ʼ��������
	public static final int AT_SECT_DELIVER_BEGIN = 285;
	// ��������ף������
	public static final int AT_SAVE_WISH_SECT_DELIVER = 286;
	// ��ȡ�ؾ�������
	public static final int AT_TAKE_SECRET_AREA_REWARD = 287;
	// ɨ����������
	public static final int AT_SWEEP_TOWER_MAP = 288;
	// ��ȡ�������ڽ���
	public static final int AT_FINISH_SECT_DELIVER = 289;
	// �����ϲ�
	public static final int AT_MERGE_BAG = 290;
	// ��ȡ���ڽ���
	public static final int AT_ROB_SUCCESS = 291;
	// ʹ��������ѫ����
	public static final int AT_USE_ITEM_FEAT_ADDER = 292;
	// ʹ�ü��ܵ���
	public static final int AT_USE_ITEM_SKILL = 293;
	// ʹ�ü��ܵ���ʧ��
	public static final int AT_USE_ITEM_SKILL_FAIL = 294;
	// ��ȡ�������潱��
	public static final int AT_REMAIN_ACTIVITY_REWARD = 295;
	// ʹ���ż�
	public static final int AT_USE_ITEM_LETTER = 296;
	// ��Ƭ�ϳ�
	public static final int AT_PIECE_COMPOSE = 297;
	// ��ɫ����
	public static final int AT_ROLE_RENAME = 298;
	// ��ȡ�������������
	public static final int AT_TAKE_PET_LIFE_TASK_REWARD = 299;
	// �������԰�
	public static final int AT_ADD_MESSAGE_BOARD = 300;
	// ��ȡÿ�ճ�ֵ����
	public static final int AT_TAKE_DAILY_PAY_GIFT_REWARD = 301;
	// ��ȡ�ճ̱���
	public static final int AT_TAKE_SCHEDULE_REWARD = 302;
	// �����ڼ�����
	public static final int AT_UNLOCK_ARMOR_TYPE = 303;
	// ʹ���ƶ�ֵ����
	public static final int AT_USE_ITEM_EVIL_VALUE = 304;
	// �ڼ�����
	public static final int AT_ARMOR_UPRANK = 305;
	// �ڼ�����
	public static final int AT_ARMOR_LEVEL_UP = 306;
	// ���Ĵ�����İ�
	public static final int AT_PUSH_RUNE_TO_RUNE_BAG = 307;
	// ����ȡ�ر���
	public static final int AT_POP_RUNE_TO_BAG = 308;
	// �ڼ������츳
	public static final int AT_ARMOR_RESET_TALENT = 309;
	// �ڼ׷���ҳ����
	public static final int AT_SOLT_GROUP_UNLOCK = 310;
	// ����ף��
	public static final int AT_RUNE_WISH = 311;
	// ����ֿ�
	public static final int AT_WAREHOUSE_SAVE = 312;
	// ȡ���ֿ�
	public static final int AT_WAREHOUSE_TAKE = 313;
	// ���
	public static final int AT_MARRIAGE = 314;
	// ���
	public static final int AT_DIVORCE = 315;
	// ���߶һ�
	public static final int AT_ITEM_EXCHANGE = 316;
	// ��鼼������
	public static final int AT_MARRIAGE_SKILL_LEVEL_UP = 317;
	// ��չ�ֿ�
	public static final int AT_EXBAND_WAREHOUSE = 318;
	// ���������ű�
	public static final int AT_OPEN_SECT_GROUP_MAP = 319;
	// ���＼������
	public static final int AT_UP_LEVEL_HORSE_SKILL = 320;
	// �����������
	public static final int AT_WEAPON_SKILL_LEVEL_UP = 321;
	// ����츳�㹺��
	public static final int AT_WEAPON_TALENT_POINT_BUY = 322;
	// ����츳������
	public static final int AT_WEAPON_TALENT_POINT_RESET = 323;
	// �����
	public static final int AT_SNATCH_RED_ENEVLOPE = 324;
	// ȼ���̻�
	public static final int AT_PLAY_FIREWORK = 325;
	// ��ȡ��Եϵ��������
	public static final int AT_TAKE_MRGSERIES_TASK_REWARD = 326;
	// ��ȡ��Ե��������
	public static final int AT_TAKE_MRGLOOP_TASK_REWARD = 327;
	// ��������
	public static final int AT_SEND_GIFT = 328;
	// ��������
	public static final int AT_GET_GIFT = 329;
	// ʹ������ǿ������
	public static final int AT_USE_ITEM_PROP_STRENGTH = 330;
	// ��������
	public static final int AT_FAME_UPGRADE = 331;
	// �����콱
	public static final int AT_FAME_TAKE_REWARD = 332;
	// ��Ӽ�������
	public static final int AT_PET_SKILL_LEVEL_UP = 333;
	// ����ؼ�����
	public static final int AT_WEAPON_USKILL_OPEN = 334;
	// װ������
	public static final int AT_EQUIP_REFINE = 335;
	// �������ķ�����
	public static final int AT_PET_SPIRIT_LVLUP = 336;
	// ����ķ�����
	public static final int AT_PET_SPIRIT_LEARN = 337;
	// ������������
	public static final int AT_BUY_OFFLINE_FUNC_POINT = 338;
	// �����ƺŲ�
	public static final int AT_TITLE_UNLOCKSLOT = 339;
	// ʹ�����������
	public static final int AT_USE_ITEM_OFFLINE_FUNC_POINT = 340;
	// cdkey��һ�����
	public static final int AT_TAKE_GIFT_CDKEY_REWARD = 341;
	// ����Ĳ��̵���Ʒ
	public static final int AT_BUY_GAMBLE_SHOP_GOOGS = 342;
	// ˢ�¶Ĳ��̵���Ʒ
	public static final int AT_USER_REFRESH_GAMBLE_SHOP = 343;
	// ��ȡ������ֵ����
	public static final int AT_TAKE_LAST_PAY_GIFT_REWARD = 344;
	// ʹ�óƺŵ���
	public static final int AT_USE_ITEM_TITLE = 345;
	// ��ȡ���ս����
	public static final int AT_TAKE_ACT_CHALLENGE_GIFT = 346;
	// �������ҿ��ٹ���
	public static final int AT_BUY_BASE_DUMMY_GOODS = 347;
	// ����Ǭ����
	public static final int AT_TRANSFER_POINT_BUY = 348;
	// ����Ǭ����
	public static final int AT_TRANSFER_POINT_RESET = 349;
	// ��������
	public static final int AT_ACTIVITY_LAST_QUICK_FINISH = 350;
	// ����ԤԼ
	public static final int AT_MARRIAGE_BESPEAK = 351;
	// ��ͼ���͵�̫������
	public static final int AT_TELEPORT_STELE = 352;
	// ��ù��ⷵ�ֽ���
	public static final int AT_TAKE_PBTCASHBACK = 353;
	// �����ħ����һ��
	public static final int AT_UP_DEMON_FLOOR = 354;
	// ���������ػ�
	public static final int AT_BUY_UPGRADE_PURCHASE = 355;
	// ��ħ��ÿ����뽱��
	public static final int AT_ENTER_DEMONHOLE_FLOOR = 356;
	// ��ת�̽���
	public static final int AT_PLAY_LUCKYROLL = 357;
	// �������ǽ���
	public static final int AT_SEND_LUCKLY_STAR = 358;
	// ԼսNPC����
	public static final int AT_FIGHT_NPC_REWARD = 359;
	// ��ȡ�ְ�����
	public static final int AT_TAKE_PACKET_REWARD = 360;
	// ���ӻ�Ծ��
	public static final int AT_ADD_ACTIVITY = 361;
	// ��������ϴ������
	public static final int AT_UNLOCK_HORSE_PROP = 362;
	// Ǭ��������
	public static final int AT_LVLUP_TRANSFER_POINT = 363;
	// ʹ�þ�������
	public static final int AT_USE_ITEM_USKILL = 364;
	// �������г���ʱ��
	public static final int AT_BUY_WIZARD_PET_TIME = 365;
	// ʹ��ͷ�񼤻����
	public static final int AT_USE_ITEM_HEAD = 366;
	// ʹ��NPC���͹���
	public static final int AT_NPC_TRANSFROM = 367;
	// ����װ������
	public static final int AT_MAKE_LEGEND_COST = 368;
	// ����װ�����Ա���
	public static final int AT_MAKE_LEGEND_SAVE = 369;
	// ����װ����������
	public static final int AT_MAKE_LEGEND_QUIT = 370;
	// ��ȡֱ���������
	public static final int AT_TAKE_DIRECT_PURCHASE_REWARD = 371;
	// ��ȡ��Ȩ������
	public static final int AT_TAKE_SPECIAL_CARD_REWARD = 372;
	// ���ϻ�������
	public static final int AT_PLAY_ONE_ARM_BANDIT = 373;
	// ������׽���
	public static final int AT_GET_RED_ENEVLOPE_EMPTY_GIFT = 374;
	// ��Ӹ�������
	public static final int AT_ON_NORMAL_MAP_END = 375;
	// ���߽���ͷ��
	public static final int AT_UNLOCK_ROLE_HEAD = 375;
	// NPC��
	public static final int AT_JOIN_NPC_PRAY = 376;
	// �����������㽱��
	public static final int AT_TD_MAP_FINISH_REWARD = 377;
	// ����˽�˲ֿ�
	public static final int AT_UNLOCK_PRIVATE_WAREHOUSE = 378;
	// ����¯��������
	public static final int AT_PRODUCE_FUSION = 379;

	// �¿�
	public static final int PAY_LEVEL_MONTHCARD = 0;
	// 6Ԫ��λ
	public static final int PAY_LEVEL_1 = 1;
	// 30Ԫ��λ
	public static final int PAY_LEVEL_2 = 2;
	// 68Ԫ��λ
	public static final int PAY_LEVEL_3 = 3;
	// 128Ԫ��λ
	public static final int PAY_LEVEL_4 = 4;
	// 258Ԫ��λ
	public static final int PAY_LEVEL_5 = 5;
	// 648Ԫ��λ
	public static final int PAY_LEVEL_6 = 6;
	// ��ֵ����
	public static final int PAY_LEVEL_RETURN = 100;
	// ϵͳ����
	public static final int PAY_LEVEL_PRESENT = 101;

	// ��ʼ����
	public static final int TASKEVENT_START = 0;
	// ��ȡ����
	public static final int TASKEVENT_TAKE = 1;
	// �������
	public static final int TASKEVENT_FINISH = 2;
	// ��������
	public static final int TASKEVENT_CANCLE = 3;

	// ����
	public static final int COPYEVENT_APPLY = -1;
	// ������ʼ
	public static final int COPYEVENT_START = 0;
	// ��������
	public static final int COPYEVENT_FINISH = 1;
	// ɨ������
	public static final int COPYEVENT_SWEEP = 2;

	// ������boss��
	public static final int BOSSEVENT_TRANSTO = 1;
	// ��boss����˺�
	public static final int BOSSEVENT_DAMAGE = 2;

	// ��������
	public static final int TASKTYPE_CARBON = 1;
	// ������������
	public static final int TASKTYPE_MAIN = 2;
	// �����������
	public static final int TASKTYPE_GODWEAPON = 3;
	// ֧������(����)
	public static final int TASKTYPE_BRANCH_PRODUCE = 4;
	// ֧������(����������)
	public static final int TASKTYPE_BRANCH_SECT = 5;
	// ֧������(����)
	public static final int TASKTYPE_BRANCH_PRODUCE2 = 6;
	// ֧������(�)
	public static final int TASKTYPE_BRANCH_ACTIVE = 7;
	// ֧������(����)
	public static final int TASKTYPE_BRANCH_TRAVEL = 8;
	// ֧������(����)
	public static final int TASKTYPE_BRANCH_UPSTAR = 9;
	// �ճ�����
	public static final int TASKTYPE_DAILYTRIAL = 10;
	// ÿ�ջ�Ծ������
	public static final int TASKTYPE_DAILYSCHEDULE = 11;
	// ħ������
	public static final int TASKTYPE_TRIAL_DEMON = 12;
	// �������
	public static final int TASKTYPE_TRIAL_FIVEMOST = 13;
	// ����ͼ
	public static final int TASKTYPE_TREASUREMAP = 14;
	// ����-�ھ�
	public static final int TASKTYPE_SECT_DELIVER = 15;
	// ����-����
	public static final int TASKTYPE_SECT_ROB = 16;
	// ����-������
	public static final int TASKTYPE_SECT_LINGXIAO = 17;
	// ������
	public static final int TASKTYPE_ARENA = 18;

	// ��������
	public static final int ROLE_STRENGTHEN = 1;
	// ��ɫתְ
	public static final int ROLE_CLASSCHANGE = 2;
	// ����ϴ��
	public static final int MOUNTS_XILIAN = 3;
	// ��������
	public static final int MOUNTS_STAR = 4;
	// ��������
	public static final int MOUNTS_RIDING = 5;
	// �������
	public static final int WEAPON_LEVELUP = 6;
	// �������
	public static final int WEAPON_STARUP = 7;
	// �������
	public static final int PET_LEVELUP = 8;
	// �������
	public static final int PET_STARUP = 9;
	// ��Ӻ���
	public static final int PET_HEXIU = 10;
	// װ��ǿ��
	public static final int EQUIP_STRENGTHEN = 11;
	// װ������
	public static final int EQUIP_STARUP = 12;
	// װ����Ƕ
	public static final int EQUIP_EMBED = 13;
	// װ������
	public static final int EQUIP_UPGRADE = 14;
	// װ��ϴ��
	public static final int EQUIP_XILIAN = 15;
	// �书����
	public static final int SKILL_LEVELUP = 16;
	// �书����
	public static final int SKILL_ENHANCE = 17;
	// �����ж�
	public static final int SPIRIT_LEVELUP = 18;
	// ��������
	public static final int UNIQUESKILL_LEVELUP = 19;
	// ��ʯ����
	public static final int GEM_LEVELUP = 20;
	// ��������
	public static final int RAREBOOK_PUSH = 21;
	// ��������
	public static final int GRASP_LEVELUP = 22;

	// װ������
	public static final int EQUIPSTRENGTH_LEVELUP = 0;
	// װ������
	public static final int EQUIPSTRENGTH_STARUP = 1;
	// װ����Ƕ
	public static final int EQUIPSTRENGTH_INLAY = 2;
	// ��ʯ����
	public static final int EQUIPSTRENGTH_GEMUP = 3;
	// װ������ 3��24�ź��¼�, ֮ǰû��
	public static final int EQUIPSTRENGTH_REFINE = 4;
	// ���ϻ��߸���װ��
	public static final int EQUIPSTRENGTH_EQUIP = 5;

	// ��������
	public static final int SKILL_LEVEL_UP = 1;
	// ��������
	public static final int SKILL_RANK_UP = 2;
	// ���ܽ���
	public static final int SKILL_UNLOCK = 3;
	// �������
	public static final int RAREBOOK_UNLOCK = 4;
	// ��������
	public static final int RAREBOOK_LEVEL_UP = 5;
	// �ķ�����
	public static final int SPIRIT_UNLOCK = 6;
	// �ķ�����
	public static final int SPIRIT_LEVEL_UP = 7;
	// ��������
	public static final int UNIQUESKILL_LEVEL_UP = 8;
	// ����װ��
	public static final int UNIQUESKILL_SET = 9;

	// ��ӽ���
	public static final int PET_UNLOCK = 1;
	// �������
	public static final int PET_LEVEL_UP = 2;
	// �������
	public static final int PET_STAR_UP = 3;
	// ��Ӻ���
	public static final int PET_COPRATICE = 4;
	// ���תְ
	public static final int PET_TRANSFORM = 5;

	// �������
	public static final int WEAPON_UNLOCK = 1;
	// �������
	public static final int WEAPON_LEVEL_UP = 2;
	// �������
	public static final int WEAPON_STAR_UP = 3;
	// ����츳����
	public static final int WEAPON_TALENT_UP = 4;
	// �����������
	public static final int WEAPON_SKILL_UP = 5;
	// ���װ��
	public static final int WEAPON_EQUIP = 6;

	// �ڼ׽���
	public static final int ARMOR_UNLOCK = 1;
	// �ڼ�����
	public static final int ARMOR_LEVEL_UP = 2;
	// �ڼ�����
	public static final int ARMOR_STAR_UP = 3;
	// �ڼ��츳����
	public static final int ARMOR_TALENT_UP = 4;
	// �ڼ׼�������
	public static final int ARMOR_SKILL_UP = 5;
	// �ڼ����װ��
	public static final int ARMOR_EQUIP = 6;

	// ���Ｄ��
	public static final int HORSE_UNLOCK = 1;
	// ����ϴ��
	public static final int HORSE_CLEAR = 2;
	// ��������
	public static final int HORSE_STAR_UP = 3;
	// ���＼��ѧϰ
	public static final int HORSE_SKILL_LEARN = 4;
	// ���＼������
	public static final int HORSE_SKILL_UP = 5;

	// �ӻ��̵�
	public static final int NPC_STORE = 0;
	// �����̳�
	public static final int SHOP_TYPE_SECT = 1;
	// �����̳�
	public static final int SHOP_TYPE_ARENA = 2;
	// �����̳�
	public static final int SHOP_TYPE_SUPERARENA = 3;
	// ���������̳�
	public static final int SHOP_TYPE_SECT_DELIVER = 4;
	// ���ɶĲ��̵�
	public static final int GAMBLE_SHOP_TYPE_JUSTICE = 11;
	// а�ɶĲ��̵�
	public static final int GAMBLE_SHOP_TYPE_EVIL = 12;

	// �ϼ�
	public static final int MARKET_TYPE_PUTON = 1;
	// ����
	public static final int MARKET_TYPE_BUY = 2;

	// ����
	public static final int PRODUCT_TYPE_CREATE = 1;
	// �ֽ�
	public static final int PRODUCT_TYPE_SPLITE = 2;

	// �Լ���������
	public static final int JOINSECT_CREATESECT = 1;
	// ������������
	public static final int JOINSECT_SENDAPPLICATION = 2;
	// ���������
	public static final int JOINSECT_BEACCEPTED = 3;

	// ��ʼ������
	public static final int ARENAEVENT_APPLY = -1;
	// ��ʼ������
	public static final int ARENAEVENT_START = 0;
	// ����������
	public static final int ARENAEVENT_FINISH = 1;

	// ��ʼ������
	public static final int SUPERARENA_2V2 = 0;
	// ����������
	public static final int SUPERARENA_4V4 = 1;

	// һ�㾺��
	public static final int NORMAL = 0;
	// ��а����
	public static final int BWARENA = 1;

	// ���ɴ���
	public static final int SECT_CREATE = 1;
	// ��������
	public static final int SECT_LEVEL_UP = 2;
	// ���ɸ���
	public static final int SECT_RENAME = 3;
	// �³�Ա�������
	public static final int ROLE_JOIN_SECT = 4;
	// ��Ա�뿪����
	public static final int ROLE_LEAVE_SECT = 5;
	// ��Ա���߳�����
	public static final int ROLE_LEAVE_SECT_BY_KICK = 6;
	// ���ɽ�ɢ
	public static final int SECT_DISMISS = 7;

	// ���ɸ��˱�
	public static final int SECT_MAP_PERSON = 1;
	// �����Ŷӱ�
	public static final int SECT_MAP_GROUP = 2;

	// ���ɻ��ʼ
	public static final int SECT_ACT_START = 1;
	// ���ɻʧ��
	public static final int SECT_ACT_FAIL = 2;
	// ���ɻ���
	public static final int SECT_ACT_FINISH = 3;

	// ����
	public static final int SECT_DELIVER = 1;
	// ����
	public static final int SECT_ROB = 2;

	// �����Դ��书
	public static final int SECT_DIY_SKILL_CREATE = 1;
	// �����Դ��书
	public static final int SECT_DIY_SKILL_SAVE = 2;
	// �����Դ��书
	public static final int SECT_DIY_SKILL_DISCARD = 3;
	// �����Դ��书
	public static final int SECT_DIY_SKILL_SHARE = 4;
	// �����Դ��书
	public static final int SECT_DIY_SKILL_BORROW = 5;

	// ���ͼ���
	public static final int INTERACTION_TYPE_SEND_VIT = 1;

	// ȫ����������
	public static final int CHAT_TYPE_ALLSERVER = -1;
	// ���纰��
	public static final int CHAT_TYPE_WORLD = 0;
	// ��������
	public static final int CHAT_TYPE_SECT = 1;
	// ��������
	public static final int CHAT_TYPE_TEAM = 2;
	// ˽��
	public static final int CHAT_TYPE_PRIVATE = 3;
	// ս��
	public static final int CHAT_TYPE_FIGHT = 4;

	// ���
	public static final int MARRIAGE_REQUEST = 0;
	// ��Ӧ���
	public static final int MARRIAGE_RESPONSE = 1;
	// �������
	public static final int MARRIAGE_WALK = 2;
	// ����
	public static final int MARRIAGE_BANQUET = 3;
	// ���
	public static final int MARRIAGE_DIVORCE = 4;

	// ��ʼ����֮�ĸ���
	public static final int EMERGENCY_JOIN_MAP = 0;
	// ��������֮�ĸ���
	public static final int EMERGENCY_FINISH_MAP = 1;

	// ��ʼ����֮�ĸ���
	public static final int JUSTICE_JOIN_MAP = 0;
	// ��������֮�ĸ���
	public static final int JUSTICE_FINISH_MAP = 1;

	// ��ʼ����֮�ĸ���
	public static final int STELE_JOIN_EVENT = 0;
	// ��������֮�ĸ���
	public static final int STELE_FINISH_EVENT = 1;

	// ��ʼ����֮�ĸ���
	public static final int FIGHTNPC_JOIN_EVENT = 0;
	// ��������֮�ĸ���
	public static final int FIGHTNPC_FINISH_EVENT = 1;



	// (��ѡ)��ɫ����
	public static class RoleCreate
	{

		public RoleCreate() { }

		public RoleCreate(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                  String vOpenId, String vChannel, String vUId, int iRoleId, 
		                  String vRoleName, int iRoleType, int iGenderType, int iVipLvl, 
		                  String vLoginIp, String vMacAddr, String vDeviceId, String vSystemSoftware, 
		                  String vSystemHardware, String vCpuHardware, int vNetwork)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.vRoleName = vRoleName;
			this.iRoleType = iRoleType;
			this.iGenderType = iGenderType;
			this.iVipLvl = iVipLvl;
			this.vLoginIp = vLoginIp;
			this.vMacAddr = vMacAddr;
			this.vDeviceId = vDeviceId;
			this.vSystemSoftware = vSystemSoftware;
			this.vSystemHardware = vSystemHardware;
			this.vCpuHardware = vCpuHardware;
			this.vNetwork = vNetwork;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleCreate");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(vRoleName);
			sb.append('|').append(iRoleType);
			sb.append('|').append(iGenderType);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(vLoginIp);
			sb.append('|').append(vMacAddr);
			sb.append('|').append(vDeviceId);
			sb.append('|').append(vSystemSoftware);
			sb.append('|').append(vSystemHardware);
			sb.append('|').append(vCpuHardware);
			sb.append('|').append(vNetwork);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)ͬһ����������һ��ʱ����Ψһ���¼����,ѭ��ʹ��
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫ����
		public String vRoleName;
		// (����)�ڲ���ɫְҵ
		public int iRoleType;
		// (����)�ڲ���ɫ�Ա�
		public int iGenderType;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��¼ip
		public String vLoginIp;
		// (����)mac��ַ
		public String vMacAddr;
		// (��ѡ)�豸Id
		public String vDeviceId;
		// (��ѡ)�ƶ��ն˲���ϵͳ�汾
		public String vSystemSoftware;
		// (����)�ƶ��ն˻���
		public String vSystemHardware;
		// (��ѡ)cpu����|Ƶ��|����
		public String vCpuHardware;
		// (��ѡ)WIFI/2G/3G/4G
		public int vNetwork;
	}

	// (����)��ɫ�ǳ�
	public static class RoleLoginout
	{

		public RoleLoginout() { }

		public RoleLoginout(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                    String vOpenId, String vChannel, String vUId, int iRoleId, 
		                    String dtCreateTime, String vRoleName, int iRoleType, int iTLvl, 
		                    int iBWType, int iLevel, int iVipLvl, int iRolePayPoint, 
		                    int iDiamondF, int iDiamondS, int iCoinF, int iCoinS, 
		                    int iSectId, int iSpouseId, int iFriendsNum, int iInOutType, 
		                    int iOnlineTime, String vClientVersion, String vLoginIP, String vMacAddr, 
		                    String vDeviceId, int vNetwork, String vSystemSoftware, String vSystemHardware, 
		                    String vCpuHardware)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.vRoleName = vRoleName;
			this.iRoleType = iRoleType;
			this.iTLvl = iTLvl;
			this.iBWType = iBWType;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iRolePayPoint = iRolePayPoint;
			this.iDiamondF = iDiamondF;
			this.iDiamondS = iDiamondS;
			this.iCoinF = iCoinF;
			this.iCoinS = iCoinS;
			this.iSectId = iSectId;
			this.iSpouseId = iSpouseId;
			this.iFriendsNum = iFriendsNum;
			this.iInOutType = iInOutType;
			this.iOnlineTime = iOnlineTime;
			this.vClientVersion = vClientVersion;
			this.vLoginIP = vLoginIP;
			this.vMacAddr = vMacAddr;
			this.vDeviceId = vDeviceId;
			this.vNetwork = vNetwork;
			this.vSystemSoftware = vSystemSoftware;
			this.vSystemHardware = vSystemHardware;
			this.vCpuHardware = vCpuHardware;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleLoginout");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(vRoleName);
			sb.append('|').append(iRoleType);
			sb.append('|').append(iTLvl);
			sb.append('|').append(iBWType);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iRolePayPoint);
			sb.append('|').append(iDiamondF);
			sb.append('|').append(iDiamondS);
			sb.append('|').append(iCoinF);
			sb.append('|').append(iCoinS);
			sb.append('|').append(iSectId);
			sb.append('|').append(iSpouseId);
			sb.append('|').append(iFriendsNum);
			sb.append('|').append(iInOutType);
			sb.append('|').append(iOnlineTime);
			sb.append('|').append(vClientVersion);
			sb.append('|').append(vLoginIP);
			sb.append('|').append(vMacAddr);
			sb.append('|').append(vDeviceId);
			sb.append('|').append(vNetwork);
			sb.append('|').append(vSystemSoftware);
			sb.append('|').append(vSystemHardware);
			sb.append('|').append(vCpuHardware);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)ͬһ����������һ��ʱ����Ψһ���¼����
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ڲ���ɫ����
		public String vRoleName;
		// (����)�ڲ���ɫְҵ
		public int iRoleType;
		// (����)��ɫתְ�ȼ�
		public int iTLvl;
		// (����)��ɫ��а��Ӫ
		public int iBWType;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��ɫ��ֵ����
		public int iRolePayPoint;
		// (����)��ɫ��ǰ�ǰ���ʯ����
		public int iDiamondF;
		// (����)��ɫ��ǰ����ʯ����
		public int iDiamondS;
		// (����)��ɫ��ǰ�ǰ󶨽������
		public int iCoinF;
		// (����)��ɫ��ǰ�󶨽������
		public int iCoinS;
		// (����)��������Id������0
		public int iSectId;
		// (����)��żID, ����0
		public int iSpouseId;
		// (����)��Һ�������
		public int iFriendsNum;
		// 0: logout , 1:new login 2: login reconnect 3:status change (level up etc...)
		public int iInOutType;
		// (����)���ε�¼����ʱ��(��)
		public int iOnlineTime;
		// (����)�ͻ��˰汾
		public String vClientVersion;
		// (����)��¼����
		public String vLoginIP;
		// (����)mac��ַ
		public String vMacAddr;
		// (��ѡ)�豸Id
		public String vDeviceId;
		// (��ѡ)WIFI/2G/3G/4G
		public int vNetwork;
		public String vSystemSoftware;
		public String vSystemHardware;
		public String vCpuHardware;
	}

	// (��ѡ)��ɫ��Ϸ�¼���ˮ��
	public static class RoleEventFlow
	{

		public RoleEventFlow() { }

		public RoleEventFlow(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                     String vOpenId, String vChannel, String vUId, int iRoleId, 
		                     int iLevel, int iVipLvl, int iEventId, String vConsumeItems, 
		                     String vProduceItems, int iArg1, int iArg2, int iArg3, 
		                     int iArg4, String vArg)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iEventId = iEventId;
			this.vConsumeItems = vConsumeItems;
			this.vProduceItems = vProduceItems;
			this.iArg1 = iArg1;
			this.iArg2 = iArg2;
			this.iArg3 = iArg3;
			this.iArg4 = iArg4;
			this.vArg = vArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleEventFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iEventId);
			sb.append('|').append(vConsumeItems);
			sb.append('|').append(vProduceItems);
			sb.append('|').append(iArg1);
			sb.append('|').append(iArg2);
			sb.append('|').append(iArg3);
			sb.append('|').append(iArg4);
			sb.append('|').append(vArg);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)���ڹ���һ�ζ�������������ͬ���͵ĵ���������־
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��Ϸ�¼�Id
		public int iEventId;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� ���ĺ��������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public String vConsumeItems;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� �������������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public String vProduceItems;
		// (��ѡ)��Ϸ�¼���������1,���ݾ���iEvnetId�Ĳ�ͬ�в�ͬ������,�����ս���¼��ڴ˺���Ϊս������
		public int iArg1;
		// (��ѡ)��Ϸ�¼���������2,���ݾ���iEvnetId�Ĳ�ͬ�в�ͬ������,�����ս���¼��ڴ˺���Ϊս�����
		public int iArg2;
		// (��ѡ)��Ϸ�¼���������3,���ݾ���iEvnetId�Ĳ�ͬ�в�ͬ������,�����ս���¼��ڴ˺���Ϊ�ؿ����
		public int iArg3;
		// (��ѡ)��Ϸ�¼���������4,���ݾ���iEvnetId�Ĳ�ͬ�в�ͬ������,�����ս���¼��ڴ˺���Ϊ�Ǽ�
		public int iArg4;
		// (��ѡ)��Ϸ�¼��ַ�����������
		public String vArg;
	}

	// (��ѡ)��ɫ(��)�ʽ�������ˮ��
	public static class RoleCurrencyChangeFlow_R
	{

		public RoleCurrencyChangeFlow_R() { }

		public RoleCurrencyChangeFlow_R(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                                String vOpenId, String vChannel, String vUId, int iRoleId, 
		                                int iLevel, int iVipLvl, int iEventId, int iItemId, 
		                                int iChangeCnt, int iFinalCnt)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iEventId = iEventId;
			this.iItemId = iItemId;
			this.iChangeCnt = iChangeCnt;
			this.iFinalCnt = iFinalCnt;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleCurrencyChangeFlow_R");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iEventId);
			sb.append('|').append(iItemId);
			sb.append('|').append(iChangeCnt);
			sb.append('|').append(iFinalCnt);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)���ڹ���һ�ζ�������������ͬ���͵ĵ���������־
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��Ϸ�¼�Id
		public int iEventId;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� ���ĺ��������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public int iItemId;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� �������������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public int iChangeCnt;
		// �䶯��ʣ���
		public int iFinalCnt;
	}

	// (��ѡ)��ɫ(�ǰ�)�ʽ�������ˮ��
	public static class RoleCurrencyChangeFlow_F
	{

		public RoleCurrencyChangeFlow_F() { }

		public RoleCurrencyChangeFlow_F(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                                String vOpenId, String vChannel, String vUId, int iRoleId, 
		                                int iLevel, int iVipLvl, int iEventId, int iItemId, 
		                                int iChangeCnt, int iFinalCnt)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iEventId = iEventId;
			this.iItemId = iItemId;
			this.iChangeCnt = iChangeCnt;
			this.iFinalCnt = iFinalCnt;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleCurrencyChangeFlow_F");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iEventId);
			sb.append('|').append(iItemId);
			sb.append('|').append(iChangeCnt);
			sb.append('|').append(iFinalCnt);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)���ڹ���һ�ζ�������������ͬ���͵ĵ���������־
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��Ϸ�¼�Id
		public int iEventId;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� ���ĺ��������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public int iItemId;
		// �漰�ı仯��ͨ����ƷId ��������Ŀ�� �������������Զ��ŷָ�����ͬ������Ʒ֮���Էֺŷָ�
		public int iChangeCnt;
		// �䶯��ʣ���
		public int iFinalCnt;
	}

	// (��ѡ)��ɫ��Ϸ���߱仯��ˮ��
	public static class RoleItemsFlow
	{

		public RoleItemsFlow() { }

		public RoleItemsFlow(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                     String vOpenId, String vChannel, String vUId, int iRoleId, 
		                     int iLevel, int iVipLvl, int iEventId, int iItemId, 
		                     int iChange, int iFinal)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iEventId = iEventId;
			this.iItemId = iItemId;
			this.iChange = iChange;
			this.iFinal = iFinal;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleItemsFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iEventId);
			sb.append('|').append(iItemId);
			sb.append('|').append(iChange);
			sb.append('|').append(iFinal);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)���ڹ���һ�ζ�������������ͬ���͵ĵ���������־
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��Ϸ�¼�Id
		public int iEventId;
		// �漰�ı仯��ͨ����ƷId
		public int iItemId;
		// �漰�ı仯��ͨ����Ʒ����
		public int iChange;
		// �漰�ı仯��ͨ����Ʒ��������
		public int iFinal;
	}

	// ��ҳ�ֵ��ˮ��
	public static class RolePayFlow
	{

		public RolePayFlow() { }

		public RolePayFlow(String dtEventTime, int iSequence, int iGameSvrId, String vGameAppId, 
		                   String vOpenId, String vChannel, String vUId, int iRoleId, 
		                   String dtCreateTime, int iLevel, int iVipLvlBefore, int iVipLvlFinal, 
		                   int iAddPayPoint, int iUserPayPointFinal, int iRolePayPointFinal, int iPayLvl, 
		                   int iPayLvlTimes, int iPayAmount, int iAddDiamondF, int iDiamondF, 
		                   String vSerial)
		{
			this.dtEventTime = dtEventTime;
			this.iSequence = iSequence;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvlBefore = iVipLvlBefore;
			this.iVipLvlFinal = iVipLvlFinal;
			this.iAddPayPoint = iAddPayPoint;
			this.iUserPayPointFinal = iUserPayPointFinal;
			this.iRolePayPointFinal = iRolePayPointFinal;
			this.iPayLvl = iPayLvl;
			this.iPayLvlTimes = iPayLvlTimes;
			this.iPayAmount = iPayAmount;
			this.iAddDiamondF = iAddDiamondF;
			this.iDiamondF = iDiamondF;
			this.vSerial = vSerial;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RolePayFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iSequence);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvlBefore);
			sb.append('|').append(iVipLvlFinal);
			sb.append('|').append(iAddPayPoint);
			sb.append('|').append(iUserPayPointFinal);
			sb.append('|').append(iRolePayPointFinal);
			sb.append('|').append(iPayLvl);
			sb.append('|').append(iPayLvlTimes);
			sb.append('|').append(iPayAmount);
			sb.append('|').append(iAddDiamondF);
			sb.append('|').append(iDiamondF);
			sb.append('|').append(vSerial);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (��ѡ)ͬһ����������һ��ʱ����Ψһ���¼����
		public int iSequence;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)��ǰ������ֵ�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)�û���ֵǰvip�ȼ�
		public int iVipLvlBefore;
		// (����)�û���ֵ��vip�ȼ�
		public int iVipLvlFinal;
		// (����)��ֵ��õ�vip����
		public int iAddPayPoint;
		// (����)��ֵ���˺ŵ���vip����
		public int iUserPayPointFinal;
		// (����)��ֵ���ɫ����vip����
		public int iRolePayPointFinal;
		// (����)��ֵ��λ PAYLEVELTYPE
		public int iPayLvl;
		// (����)��ֵ��λ ��ֵ����
		public int iPayLvlTimes;
		// (����)��ֵ���(��λ����)
		public int iPayAmount;
		// (����)��ȡ���ǰ���ʯ��
		public int iAddDiamondF;
		// (����)�û����յķǰ���ʯ����
		public int iDiamondF;
		// (����)��ֵ������
		public String vSerial;
	}

	// (����)������״̬��ˮ��ÿ����һ����־
	public static class GameSvrState
	{

		public GameSvrState() { }

		public GameSvrState(String dtEventTime, int iGameSvrId, String vGameAppId, int iOnlineCount, 
		                    String vGameIP)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.iOnlineCount = iOnlineCount;
			this.vGameIP = vGameIP;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("GameSvrState");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(iOnlineCount);
			sb.append('|').append(vGameIP);
			sb.append('\n');
			return sb.toString();
		}

		// (����) ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)���е���Ϸ���������
		public int iGameSvrId;
		// (����)���е���Ϸ���
		public String vGameAppId;
		// (����)���е���Ϸ�������ϵ�ǰ��������
		public int iOnlineCount;
		// (����)������IP
		public String vGameIP;
	}

	// idip������ˮ
	public static class IdIPCmdFlow
	{

		public IdIPCmdFlow() { }

		public IdIPCmdFlow(String dtEventTime, int iGameSvrId, int iRoleId, int iItemId, 
		                   int iItemCount, int iSource, int iCmd, String vSerial)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.iRoleId = iRoleId;
			this.iItemId = iItemId;
			this.iItemCount = iItemCount;
			this.iSource = iSource;
			this.iCmd = iCmd;
			this.vSerial = vSerial;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("IdIPCmdFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iItemId);
			sb.append('|').append(iItemCount);
			sb.append('|').append(iSource);
			sb.append('|').append(iCmd);
			sb.append('|').append(vSerial);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// �ڲ���ɫId
		public int iRoleId;
		// ����id
		public int iItemId;
		// ��������
		public int iItemCount;
		// ������
		public int iSource;
		// ������
		public int iCmd;
		// ��ˮ��
		public String vSerial;
	}

	// ��ɫ����������ˮ��
	public static class RoleMainTaskFlow
	{

		public RoleMainTaskFlow() { }

		public RoleMainTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                        String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLvl, int iTaskId, int iTaskState, 
		                        int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleMainTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��������Id
		public int iTaskId;
		// (����)�¼������������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ֧��������ˮ��
	public static class RoleBranchTaskFlow
	{

		public RoleBranchTaskFlow() { }

		public RoleBranchTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                          String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                          int iLevel, int iVipLvl, int iGroupId, int iTaskId, 
		                          int iTaskState, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iGroupId = iGroupId;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleBranchTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iGroupId);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)����Id
		public int iGroupId;
		// (����)����Id
		public int iTaskId;
		// (����)�¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ����������ˮ��
	public static class RoleSectTaskFlow
	{

		public RoleSectTaskFlow() { }

		public RoleSectTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                        String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLvl, int iSectId, int iTaskId, 
		                        int iTaskState, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iSectId = iSectId;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iSectId);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)����Id
		public int iSectId;
		// (����)����Id
		public int iTaskId;
		// (����)�¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ����������ˮ��
	public static class RoleSectDeliverTaskFlow
	{

		public RoleSectDeliverTaskFlow() { }

		public RoleSectDeliverTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                               String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                               int iLevel, int iVipLvl, int iSectId, int iTaskId, 
		                               int iTaskState, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iSectId = iSectId;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectDeliverTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iSectId);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)����Id
		public int iSectId;
		// (����)����Id
		public int iTaskId;
		// (����)�¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ������ˮ
	public static class RoleSectRobTaskFlow
	{

		public RoleSectRobTaskFlow() { }

		public RoleSectRobTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                           String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                           int iLevel, int iVipLvl, int iSectId, int iTaskId, 
		                           int iTaskState, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iSectId = iSectId;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectRobTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iSectId);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)����Id
		public int iSectId;
		// (����)����Id
		public int iTaskId;
		// (����)�¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ�ճ�������ˮ
	public static class RoleDailyTaskFlow
	{

		public RoleDailyTaskFlow() { }

		public RoleDailyTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                         String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                         int iLevel, int iVipLvl, int iTaskId, int iTaskState, 
		                         int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleDailyTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��¼����Ϸ���������
		public int iGameSvrId;
		// ��ϷAPpId
		public String vGameAppId;
		// �û�OpenId��
		public String vOpenId;
		// �û�channel��
		public String vChannel;
		// �û�UId��
		public String vUId;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// ��ɫvip�ȼ�
		public int iVipLvl;
		// ����Id
		public int iTaskId;
		// �¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// ���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ�ճ�������ˮ
	public static class RoleScheduleTaskFlow
	{

		public RoleScheduleTaskFlow() { }

		public RoleScheduleTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                            String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                            int iLevel, int iVipLvl, int iTaskId, int iTaskState, 
		                            int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleScheduleTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��¼����Ϸ���������
		public int iGameSvrId;
		// ��ϷAPpId
		public String vGameAppId;
		// �û�OpenId��
		public String vOpenId;
		// �û�channel��
		public String vChannel;
		// �û�UId��
		public String vUId;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// ��ɫvip�ȼ�
		public int iVipLvl;
		// ����Id
		public int iTaskId;
		// �¼��������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// ���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ����������ˮ��
	public static class RolePrivateNormalCopyFlow
	{

		public RolePrivateNormalCopyFlow() { }

		public RolePrivateNormalCopyFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                                 String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                                 int iLevel, int iVipLvl, int iMapId, int iEventType, 
		                                 int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iMapId = iMapId;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RolePrivateNormalCopyFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iMapId);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��¼����Ϸ���������
		public int iGameSvrId;
		// ��ϷAPpId
		public String vGameAppId;
		// �û�OpenId��
		public String vOpenId;
		// �û�channel��
		public String vChannel;
		// �û�UId��
		public String vUId;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// ��ɫvip�ȼ�
		public int iVipLvl;
		// ��������Id
		public int iMapId;
		// ���������¼����� (0:���� 1:ɨ��, 2:�뿪)
		public int iEventType;
		public int iArg;
	}

	// ��ɫ����������ˮ��
	public static class RolePublicNormalCopyFlow
	{

		public RolePublicNormalCopyFlow() { }

		public RolePublicNormalCopyFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                                String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                                int iLevel, int iVipLvl, int iMapId, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iMapId = iMapId;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RolePublicNormalCopyFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iMapId);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��¼����Ϸ���������
		public int iGameSvrId;
		// ��ϷAPpId
		public String vGameAppId;
		// �û�OpenId��
		public String vOpenId;
		// �û�channel��
		public String vChannel;
		// �û�UId��
		public String vUId;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// ��ɫvip�ȼ�
		public int iVipLvl;
		// ��������Id
		public int iMapId;
		// ���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// ��ɫ�������ˮ��
	public static class RoleActiveCopyFlow
	{

		public RoleActiveCopyFlow() { }

		public RoleActiveCopyFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                          String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                          int iLevel, int iVipLvl, int iMapId, int iEventType, 
		                          int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iMapId = iMapId;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleActiveCopyFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iMapId);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��������Id
		public int iMapId;
		// ��������(0:��ʼ�¸��� 1:ɨ������ 2:��ɸ���)
		public int iEventType;
		public int iArg;
	}

	// ��ɫ�������ˮ��
	public static class RoleChallengeTaskFlow
	{

		public RoleChallengeTaskFlow() { }

		public RoleChallengeTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                             String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                             int iLevel, int iVipLvl, int iTaskId, int iTaskState, 
		                             int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iTaskId = iTaskId;
			this.iTaskState = iTaskState;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleChallengeTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iTaskId);
			sb.append('|').append(iTaskState);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// (����)��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// (����)��ϷAPpId
		public String vGameAppId;
		// (����)�û�OpenId��
		public String vOpenId;
		// (����)�û�channel��
		public String vChannel;
		// (����)�û�UId��
		public String vUId;
		// (����)�ڲ���ɫId
		public int iRoleId;
		// (����)�ڲ���ɫId
		public String dtCreateTime;
		// (����)�ȼ�
		public int iLevel;
		// (����)��ɫvip�ȼ�
		public int iVipLvl;
		// (����)��������Id
		public int iTaskId;
		// (����)�¼������������״̬ (0:δ��ȡ1:��ȡ2:��ɵ�δ�콱)
		public int iTaskState;
		// (����)���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iEventType;
	}

	// bossս��¼
	public static class RoleBossTaskFlow
	{

		public RoleBossTaskFlow() { }

		public RoleBossTaskFlow(String dtEventTime, int iGameSvrId, String vGameAppId, String vOpenId, 
		                        String vChannel, String vUId, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLvl, int iBossId, int iTaskType, 
		                        int iKill, int iDamage)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameAppId = vGameAppId;
			this.vOpenId = vOpenId;
			this.vChannel = vChannel;
			this.vUId = vUId;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iBossId = iBossId;
			this.iTaskType = iTaskType;
			this.iKill = iKill;
			this.iDamage = iDamage;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleBossTaskFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameAppId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannel);
			sb.append('|').append(vUId);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iBossId);
			sb.append('|').append(iTaskType);
			sb.append('|').append(iKill);
			sb.append('|').append(iDamage);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��¼����Ϸ���������
		public int iGameSvrId;
		// ��ϷAPpId
		public String vGameAppId;
		// �û�OpenId��
		public String vOpenId;
		// �û�channel��
		public String vChannel;
		// �û�UId��
		public String vUId;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// ��ɫvip�ȼ�
		public int iVipLvl;
		// ��������Id
		public int iBossId;
		// ��¼���� (0:������boss�� 1:��boss����˺�)
		public int iTaskType;
		// ���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iKill;
		// ���������¼����� (0:��ʼ������1:��ȡ����2:�������3:ȡ������)
		public int iDamage;
	}

	// ����������¼
	public static class RoleGuideFlow
	{

		public RoleGuideFlow() { }

		public RoleGuideFlow(String dtEventTime, String vGameId, int iGameSvrId, String vOpenid, 
		                     String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                     int iLevel, int iVipLevel, int iGuideId)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.iGameSvrId = iGameSvrId;
			this.vOpenid = vOpenid;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iGuideId = iGuideId;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleGuideFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vOpenid);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iGuideId);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// �û�Openid��
		public String vOpenid;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ����id
		public int iGuideId;
	}

	// ����, �����¼
	public static class RoleEquipStrengthenFlow
	{

		public RoleEquipStrengthenFlow() { }

		public RoleEquipStrengthenFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenid, 
		                               String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                               int iVip, int iLevel, int iType, int iPosition, 
		                               int iSlot, int iTarLevel, int iSuccess)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenid = vOpenid;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iVip = iVip;
			this.iLevel = iLevel;
			this.iType = iType;
			this.iPosition = iPosition;
			this.iSlot = iSlot;
			this.iTarLevel = iTarLevel;
			this.iSuccess = iSuccess;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleEquipStrengthenFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenid);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iVip);
			sb.append('|').append(iLevel);
			sb.append('|').append(iType);
			sb.append('|').append(iPosition);
			sb.append('|').append(iSlot);
			sb.append('|').append(iTarLevel);
			sb.append('|').append(iSuccess);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// �û�Openid��
		public String vOpenid;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// �ڲ���ɫId
		public String dtCreateTime;
		// ip�ȼ�
		public int iVip;
		// ��ɫ�ȼ�
		public int iLevel;
		// ǿ������  0:����, 1:����
		public int iType;
		// װ����λ
		public int iPosition;
		// ��λ
		public int iSlot;
		// Ŀ��ȼ�
		public int iTarLevel;
		// �Ƿ�ɹ�, �����������Ч, 0:ʧ��, 1:�ɹ�
		public int iSuccess;
	}

	// ����, �����¼
	public static class RoleSkillDevelopFlow
	{

		public RoleSkillDevelopFlow() { }

		public RoleSkillDevelopFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                            String vChannelId, String vUid, int iRoleId, int iVip, 
		                            String dtCreateTime, int iSkillId, int iType, int iAfterLevel)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iVip = iVip;
			this.dtCreateTime = dtCreateTime;
			this.iSkillId = iSkillId;
			this.iType = iType;
			this.iAfterLevel = iAfterLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSkillDevelopFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iVip);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iSkillId);
			sb.append('|').append(iType);
			sb.append('|').append(iAfterLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// �û�OpenId
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// vip�ȼ�
		public int iVip;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ����ID
		public int iSkillId;
		// ��������
		public int iType;
		// ��ɺ���ֵ
		public int iAfterLevel;
	}

	// ����, �����¼
	public static class RolePetDevelopFlow
	{

		public RolePetDevelopFlow() { }

		public RolePetDevelopFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                          String vChannelId, String vUid, int iRoleId, int iVip, 
		                          String dtCreateTime, int iPetId, int iType, int iAfterLevel)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iVip = iVip;
			this.dtCreateTime = dtCreateTime;
			this.iPetId = iPetId;
			this.iType = iType;
			this.iAfterLevel = iAfterLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RolePetDevelopFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iVip);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iPetId);
			sb.append('|').append(iType);
			sb.append('|').append(iAfterLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// vip�ȼ�
		public int iVip;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ���ID
		public int iPetId;
		// ��������
		public int iType;
		// ��ɺ���ֵ
		public int iAfterLevel;
	}

	// ����, �����¼
	public static class RoleWeaponDevelopFlow
	{

		public RoleWeaponDevelopFlow() { }

		public RoleWeaponDevelopFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                             String vChannelId, String vUid, int iRoleId, int iVip, 
		                             String dtCreateTime, int iWeaponId, int iType, int iAfterLevel)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iVip = iVip;
			this.dtCreateTime = dtCreateTime;
			this.iWeaponId = iWeaponId;
			this.iType = iType;
			this.iAfterLevel = iAfterLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleWeaponDevelopFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iVip);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iWeaponId);
			sb.append('|').append(iType);
			sb.append('|').append(iAfterLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// vip�ȼ�
		public int iVip;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ���ID
		public int iWeaponId;
		// ��������
		public int iType;
		// ��ɺ���ֵ
		public int iAfterLevel;
	}

	// �ڼ�ǿ����ˮ
	public static class RoleArmorDevelopFlow
	{

		public RoleArmorDevelopFlow() { }

		public RoleArmorDevelopFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                            String vChannelId, String vUid, int iRoleId, int iVip, 
		                            String dtCreateTime, int iArmorId, int iType, int iAfterLevel)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iVip = iVip;
			this.dtCreateTime = dtCreateTime;
			this.iArmorId = iArmorId;
			this.iType = iType;
			this.iAfterLevel = iAfterLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleArmorDevelopFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iVip);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iArmorId);
			sb.append('|').append(iType);
			sb.append('|').append(iAfterLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// vip�ȼ�
		public int iVip;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ���ID
		public int iArmorId;
		// ��������
		public int iType;
		// ��ɺ���ֵ
		public int iAfterLevel;
	}

	// ����, �����¼
	public static class RoleHorseDevelopFlow
	{

		public RoleHorseDevelopFlow() { }

		public RoleHorseDevelopFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                            String vChannelId, String vUid, int iRoleId, int iVip, 
		                            String dtCreateTime, int iHorseId, int iType, int iSkillId, 
		                            int iAfterLevel)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iVip = iVip;
			this.dtCreateTime = dtCreateTime;
			this.iHorseId = iHorseId;
			this.iType = iType;
			this.iSkillId = iSkillId;
			this.iAfterLevel = iAfterLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleHorseDevelopFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iVip);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iHorseId);
			sb.append('|').append(iType);
			sb.append('|').append(iSkillId);
			sb.append('|').append(iAfterLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// vip�ȼ�
		public int iVip;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ���ID
		public int iHorseId;
		// ��������
		public int iType;
		// ��������ID�����Ǽ��ܲ���Ϊ0
		public int iSkillId;
		// ��ɺ���ֵ
		public int iAfterLevel;
	}

	// ����, �����¼
	public static class RoleBuyStoreFlow
	{

		public RoleBuyStoreFlow() { }

		public RoleBuyStoreFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                        String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLvl, int iStoreType, int iConsumeId, 
		                        int iConsumeCnt, int iProduceId, int iProduceCnt, int iProduceItemId, 
		                        int iProduceItemCnt)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iStoreType = iStoreType;
			this.iConsumeId = iConsumeId;
			this.iConsumeCnt = iConsumeCnt;
			this.iProduceId = iProduceId;
			this.iProduceCnt = iProduceCnt;
			this.iProduceItemId = iProduceItemId;
			this.iProduceItemCnt = iProduceItemCnt;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleBuyStoreFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iStoreType);
			sb.append('|').append(iConsumeId);
			sb.append('|').append(iConsumeCnt);
			sb.append('|').append(iProduceId);
			sb.append('|').append(iProduceCnt);
			sb.append('|').append(iProduceItemId);
			sb.append('|').append(iProduceItemCnt);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// vip�ȼ�
		public int iVipLvl;
		// �̵�����
		public int iStoreType;
		// ����ID
		public int iConsumeId;
		// ��������
		public int iConsumeCnt;
		// ��ƷID
		public int iProduceId;
		// ��Ʒ����
		public int iProduceCnt;
		// ������ƷID
		public int iProduceItemId;
		// ������Ʒ����
		public int iProduceItemCnt;
	}

	// �̳�����, �����¼
	public static class RoleBuyMallFlow
	{

		public RoleBuyMallFlow() { }

		public RoleBuyMallFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                       String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                       int iLevel, int iVipLvl, int iConsumeId, int iConsumeCnt, 
		                       int iProduceId, int iProduceCnt, int iProduceItemId, int iProduceItemCnt)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iConsumeId = iConsumeId;
			this.iConsumeCnt = iConsumeCnt;
			this.iProduceId = iProduceId;
			this.iProduceCnt = iProduceCnt;
			this.iProduceItemId = iProduceItemId;
			this.iProduceItemCnt = iProduceItemCnt;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleBuyMallFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iConsumeId);
			sb.append('|').append(iConsumeCnt);
			sb.append('|').append(iProduceId);
			sb.append('|').append(iProduceCnt);
			sb.append('|').append(iProduceItemId);
			sb.append('|').append(iProduceItemCnt);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// vip�ȼ�
		public int iVipLvl;
		// ����ID
		public int iConsumeId;
		// ��������
		public int iConsumeCnt;
		// ��ƷID
		public int iProduceId;
		// ��Ʒ����
		public int iProduceCnt;
		// ��Ʒ��Ӧ����ID
		public int iProduceItemId;
		// ��Ʒ��Ӧ��������
		public int iProduceItemCnt;
	}

	// ����, �����¼
	public static class RoleMarketStoreFlow
	{

		public RoleMarketStoreFlow() { }

		public RoleMarketStoreFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                           String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                           int iLevel, int iVipLvl, int iType, int iItem, 
		                           int iPrice, int iNum, int iStatus)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iType = iType;
			this.iItem = iItem;
			this.iPrice = iPrice;
			this.iNum = iNum;
			this.iStatus = iStatus;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleMarketStoreFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iType);
			sb.append('|').append(iItem);
			sb.append('|').append(iPrice);
			sb.append('|').append(iNum);
			sb.append('|').append(iStatus);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// vip�ȼ�
		public int iVipLvl;
		// �ϼ�/������Ʒ
		public int iType;
		// ��ƷId
		public int iItem;
		// �ϼ�/�ɽ� �۸�
		public int iPrice;
		// �ϼ�/�ɽ� ����
		public int iNum;
		// �Ƿ��׳ɹ�
		public int iStatus;
	}

	// ����, �����¼
	public static class RoleProduceFlow
	{

		public RoleProduceFlow() { }

		public RoleProduceFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                       String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                       int iLevel, int iVipLvl, int iProductLevel, int iProductType, 
		                       int iItemType, int iItemId, int iItemNum)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iProductLevel = iProductLevel;
			this.iProductType = iProductType;
			this.iItemType = iItemType;
			this.iItemId = iItemId;
			this.iItemNum = iItemNum;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleProduceFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iProductLevel);
			sb.append('|').append(iProductType);
			sb.append('|').append(iItemType);
			sb.append('|').append(iItemId);
			sb.append('|').append(iItemNum);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// vip�ȼ�
		public int iVipLvl;
		// �����ȼ�
		public int iProductLevel;
		// ��������
		public int iProductType;
		// ����,����,���,���,ҩƷ,����
		public int iItemType;
		// �������ĵ���Ʒ
		public int iItemId;
		// ������Ʒ����
		public int iItemNum;
	}

	public static class RoleJoinSectFlow
	{

		public RoleJoinSectFlow() { }

		public RoleJoinSectFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                        String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLvl, int iTargetSect, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLvl = iVipLvl;
			this.iTargetSect = iTargetSect;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleJoinSectFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLvl);
			sb.append('|').append(iTargetSect);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ȼ�
		public int iLevel;
		// vip�ȼ�
		public int iVipLvl;
		// Ŀ����
		public int iTargetSect;
		// �¼�����
		public int iEventType;
	}

	// ��������¼
	public static class ArenaRank
	{

		public ArenaRank() { }

		public ArenaRank(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                 String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                 int iLevel, int iVip, int iRank, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iRank = iRank;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("ArenaRank");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iRank);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// ����
		public int iRank;
		// ����������Ϣ
		public int iArg;
	}

	// ��������¼
	public static class ArenaFlow
	{

		public ArenaFlow() { }

		public ArenaFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                 String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                 int iLevel, int iVip, int iEventType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("ArenaFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// �¼�����  0��ʼ : 1 ����
		public int iEventType;
		// �Ƿ�ɹ� 0ʧ��  1 �ɹ�
		public int iArg;
	}

	// ��������¼
	public static class SuperArenaFlow
	{

		public SuperArenaFlow() { }

		public SuperArenaFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                      String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                      int iLevel, int iVip, int iType, int iEventType, 
		                      int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iType = iType;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("SuperArenaFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iType);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// ��������
		public int iType;
		// �¼�����  0��ʼ : 1 ����
		public int iEventType;
		// �Ƿ�ɹ� 0ʧ��   1 �ɹ�
		public int iArg;
	}

	// ����ս��¼
	public static class ForceWarFlow
	{

		public ForceWarFlow() { }

		public ForceWarFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                    String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                    int iLevel, int iVip, int iBW, int iEventType, 
		                    int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iBW = iBW;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("ForceWarFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iBW);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// ��а
		public int iBW;
		// �¼�����  0��ʼ : 1 ����
		public int iEventType;
		// �Ƿ�ɹ� 0ʧ��   1 �ɹ�  / ������� (����ʱ)0���� 1���
		public int iArg;
	}

	// ��аս��¼
	public static class BWArenaWarFlow
	{

		public BWArenaWarFlow() { }

		public BWArenaWarFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                      String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                      int iLevel, int iVip, int iBW, int iEventType, 
		                      int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iBW = iBW;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("BWArenaWarFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iBW);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// ��а
		public int iBW;
		// �¼�����  0��ʼ : 1 ����
		public int iEventType;
		// �Ƿ�ɹ� 0ʧ��   1 �ɹ�
		public int iArg;
	}

	// ����ս��¼
	public static class ClimbCopyFlow
	{

		public ClimbCopyFlow() { }

		public ClimbCopyFlow(String dtEventTime, int iGameSvrId, String vGameId, String vOpenId, 
		                     String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                     int iLevel, int iVip, int iGroupId, int iMapId, 
		                     int iEventType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVip = iVip;
			this.iGroupId = iGroupId;
			this.iMapId = iMapId;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("ClimbCopyFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVip);
			sb.append('|').append(iGroupId);
			sb.append('|').append(iMapId);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// �ڲ���ɫ�ȼ�
		public int iLevel;
		// ��ɫVip�ȼ�
		public int iVip;
		// ����
		public int iGroupId;
		public int iMapId;
		// �¼�����  0��ʼ : 1 ����
		public int iEventType;
		// �Ƿ�ɹ� 0ʧ��   1 �ɹ�
		public int iArg;
	}

	// �����¼���¼
	public static class SectEventFlow
	{

		public SectEventFlow() { }

		public SectEventFlow(String dtEventTime, int iGameSvrId, int iSectId, String vSectName, 
		                     int iMemberCnt, int iSectLevel, int iEventType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.iSectId = iSectId;
			this.vSectName = vSectName;
			this.iMemberCnt = iMemberCnt;
			this.iSectLevel = iSectLevel;
			this.iEventType = iEventType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("SectEventFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(iSectId);
			sb.append('|').append(vSectName);
			sb.append('|').append(iMemberCnt);
			sb.append('|').append(iSectLevel);
			sb.append('|').append(iEventType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ����Id
		public int iSectId;
		// ��������
		public String vSectName;
		// ��Ա��
		public int iMemberCnt;
		// ���ɵȼ�
		public int iSectLevel;
		// �����¼�����
		public int iEventType;
	}

	// ���ɸ�����¼
	public static class RoleSectMapJoinFlow
	{

		public RoleSectMapJoinFlow() { }

		public RoleSectMapJoinFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                           String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                           int iLevel, int iVipLevel, int iSectId, int iMapLevel, 
		                           int iMapId, int iMapType)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iSectId = iSectId;
			this.iMapLevel = iMapLevel;
			this.iMapId = iMapId;
			this.iMapType = iMapType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectMapJoinFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iSectId);
			sb.append('|').append(iMapLevel);
			sb.append('|').append(iMapId);
			sb.append('|').append(iMapType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ����Id
		public int iSectId;
		// ��ͼ�㼶
		public int iMapLevel;
		// ��ͼID
		public int iMapId;
		// ��ͼ����
		public int iMapType;
	}

	// ���ɸ�����¼
	public static class SectMapFlow
	{

		public SectMapFlow() { }

		public SectMapFlow(String dtEventTime, int iGameSvrId, int iSectId, String vSectName, 
		                   int iMemberCnt, int iSectLevel, int iMapLevel, int iMapId, 
		                   int iMapType, int iOperateType)
		{
			this.dtEventTime = dtEventTime;
			this.iGameSvrId = iGameSvrId;
			this.iSectId = iSectId;
			this.vSectName = vSectName;
			this.iMemberCnt = iMemberCnt;
			this.iSectLevel = iSectLevel;
			this.iMapLevel = iMapLevel;
			this.iMapId = iMapId;
			this.iMapType = iMapType;
			this.iOperateType = iOperateType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("SectMapFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(iSectId);
			sb.append('|').append(vSectName);
			sb.append('|').append(iMemberCnt);
			sb.append('|').append(iSectLevel);
			sb.append('|').append(iMapLevel);
			sb.append('|').append(iMapId);
			sb.append('|').append(iMapType);
			sb.append('|').append(iOperateType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ����Id
		public int iSectId;
		// ��������
		public String vSectName;
		// ��Ա��
		public int iMemberCnt;
		// ���ɵȼ�
		public int iSectLevel;
		// ��ͼ�㼶
		public int iMapLevel;
		// ��ͼID
		public int iMapId;
		// ��ͼ����
		public int iMapType;
		// ��������
		public int iOperateType;
	}

	// �������ڻ��¼
	public static class RoleSectDeliverFlow
	{

		public RoleSectDeliverFlow() { }

		public RoleSectDeliverFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                           String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                           int iLevel, int iVipLevel, int iDeliverType, int iOperateType, 
		                           int iOperateArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iDeliverType = iDeliverType;
			this.iOperateType = iOperateType;
			this.iOperateArg = iOperateArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectDeliverFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iDeliverType);
			sb.append('|').append(iOperateType);
			sb.append('|').append(iOperateArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ���ڻ����
		public int iDeliverType;
		// ��������
		public int iOperateType;
		// ������������ʼ����0��ʾδͶ����1��ʾͶ����
		public int iOperateArg;
	}

	// �������ڻ��¼
	public static class RoleSectDiySkillFlow
	{

		public RoleSectDiySkillFlow() { }

		public RoleSectDiySkillFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                            String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                            int iLevel, int iVipLevel, int iDiySkillType)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iDiySkillType = iDiySkillType;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSectDiySkillFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iDiySkillType);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ���ڻ����
		public int iDiySkillType;
	}

	// ���ѻ�����¼
	public static class RoleFriendInteractionFlow
	{

		public RoleFriendInteractionFlow() { }

		public RoleFriendInteractionFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                                 String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                                 int iLevel, int iVipLevel, int iInteractionType, int iInteractionArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iInteractionType = iInteractionType;
			this.iInteractionArg = iInteractionArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleFriendInteractionFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iInteractionType);
			sb.append('|').append(iInteractionArg);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ��������
		public int iInteractionType;
		// ��������
		public int iInteractionArg;
	}

	// ��ɫ��װ����¼
	public static class RoleDayEquipFlow
	{

		public RoleDayEquipFlow() { }

		public RoleDayEquipFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                        String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLevel, int iEquip1, int iEquip2, 
		                        int iEquip3, int iEquip4, int iEquip5, int iEquip6)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iEquip1 = iEquip1;
			this.iEquip2 = iEquip2;
			this.iEquip3 = iEquip3;
			this.iEquip4 = iEquip4;
			this.iEquip5 = iEquip5;
			this.iEquip6 = iEquip6;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleDayEquipFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iEquip1);
			sb.append('|').append(iEquip2);
			sb.append('|').append(iEquip3);
			sb.append('|').append(iEquip4);
			sb.append('|').append(iEquip5);
			sb.append('|').append(iEquip6);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// װ��1
		public int iEquip1;
		// װ��2
		public int iEquip2;
		// װ��3
		public int iEquip3;
		// װ��4
		public int iEquip4;
		// װ��5
		public int iEquip5;
		// װ��6
		public int iEquip6;
	}

	// ��ɫ�ձ������߼�¼
	public static class RoleDayBagItemFlow
	{

		public RoleDayBagItemFlow() { }

		public RoleDayBagItemFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                          String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                          int iLevel, int iVipLevel, int iItemId, int iItemNum)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iItemId = iItemId;
			this.iItemNum = iItemNum;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleDayBagItemFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iItemId);
			sb.append('|').append(iItemNum);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ����ID
		public int iItemId;
		// ��������
		public int iItemNum;
	}

	// ��ɫ��Ӽ�¼
	public static class RoleJoinTeamFlow
	{

		public RoleJoinTeamFlow() { }

		public RoleJoinTeamFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                        String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                        int iLevel, int iVipLevel)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleJoinTeamFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
	}

	// ��ɫ��װ����¼
	public static class RoleDayGemFlow
	{

		public RoleDayGemFlow() { }

		public RoleDayGemFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                      String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                      int iLevel, int iVipLevel, int iWearSolt, int iGem1, 
		                      int iGem2, int iGem3)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iWearSolt = iWearSolt;
			this.iGem1 = iGem1;
			this.iGem2 = iGem2;
			this.iGem3 = iGem3;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleDayGemFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iWearSolt);
			sb.append('|').append(iGem1);
			sb.append('|').append(iGem2);
			sb.append('|').append(iGem3);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ��λ
		public int iWearSolt;
		// ��ʯ1
		public int iGem1;
		// ��ʯ2
		public int iGem2;
		// ��ʯ3
		public int iGem3;
	}

	// ��ɫ�ձ������߼�¼
	public static class RoleDayBagGemFlow
	{

		public RoleDayBagGemFlow() { }

		public RoleDayBagGemFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                         String vChannelId, String vUid, int iRoleId, String dtCreateTime, 
		                         int iLevel, int iVipLevel, int iGemId, int iGemNum)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.dtCreateTime = dtCreateTime;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iGemId = iGemId;
			this.iGemNum = iGemNum;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleDayBagGemFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(dtCreateTime);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iGemId);
			sb.append('|').append(iGemNum);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ɫ����ʱ��
		public String dtCreateTime;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ����ID
		public int iGemId;
		// ��������
		public int iGemNum;
	}

	// ��ɫ���Լ�¼
	public static class RoleChatFlow
	{

		public RoleChatFlow() { }

		public RoleChatFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                    String vChannelId, String vUid, int iRoleId, int iLevel, 
		                    int iVipLevel, int iType, int iTarget, String vContent)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iType = iType;
			this.iTarget = iTarget;
			this.vContent = vContent;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleChatFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iType);
			sb.append('|').append(iTarget);
			sb.append('|').append(vContent);
			sb.append('\n');
			return sb.toString();
		}

		// ��Ϸ�¼���ʱ��, ��ʽ YYYY-MM-DD HH:MM:SS
		public String dtEventTime;
		// ��Ϸ�������
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		// (����)��¼����Ϸ���������
		public int iGameSvrId;
		// ��Ϸ��¼���������
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// ��������, 0�������� 1��������2��������3˽��
		public int iType;
		// ����Ŀ��
		public int iTarget;
		// ��������, 0�������� 1��������2��������3˽��
		public String vContent;
	}

	public static class RoleMarriageFlow
	{

		public RoleMarriageFlow() { }

		public RoleMarriageFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                        String vChannelId, String vUid, int iRoleId, int iLevel, 
		                        int iVipLevel, int iPartnerRoleId, int iPartnerLevel, int iPartnerVipLevel, 
		                        int iMarriageId, int iType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iPartnerRoleId = iPartnerRoleId;
			this.iPartnerLevel = iPartnerLevel;
			this.iPartnerVipLevel = iPartnerVipLevel;
			this.iMarriageId = iMarriageId;
			this.iType = iType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleMarriageFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iPartnerRoleId);
			sb.append('|').append(iPartnerLevel);
			sb.append('|').append(iPartnerVipLevel);
			sb.append('|').append(iMarriageId);
			sb.append('|').append(iType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// �ڲ���ɫId
		public int iPartnerRoleId;
		// ��ҵȼ�
		public int iPartnerLevel;
		// Vip�ȼ�
		public int iPartnerVipLevel;
		public int iMarriageId;
		public int iType;
		public int iArg;
	}

	public static class RoleTakePBTCashBackFlow
	{

		public RoleTakePBTCashBackFlow() { }

		public RoleTakePBTCashBackFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                               String vChannelId, String vUid, int iRoleId, int iLevel, 
		                               int iVipLevel, int iBid, int iBackScore, int iBackScoreLevel, 
		                               int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iBid = iBid;
			this.iBackScore = iBackScore;
			this.iBackScoreLevel = iBackScoreLevel;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleTakePBTCashBackFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iBid);
			sb.append('|').append(iBackScore);
			sb.append('|').append(iBackScoreLevel);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		public int iBid;
		public int iBackScore;
		public int iBackScoreLevel;
		public int iArg;
	}

	public static class RoleEmergencyActivityFlow
	{

		public RoleEmergencyActivityFlow() { }

		public RoleEmergencyActivityFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                                 String vChannelId, String vUid, int iRoleId, int iLevel, 
		                                 int iVipLevel, int iEventType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleEmergencyActivityFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// �¼�����
		public int iEventType;
		public int iArg;
	}

	public static class RoleJusticeActivityFlow
	{

		public RoleJusticeActivityFlow() { }

		public RoleJusticeActivityFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                               String vChannelId, String vUid, int iRoleId, int iLevel, 
		                               int iVipLevel, int iEventType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleJusticeActivityFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// �¼�����
		public int iEventType;
		public int iArg;
	}

	public static class RoleSteleActivityFlow
	{

		public RoleSteleActivityFlow() { }

		public RoleSteleActivityFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                             String vChannelId, String vUid, int iRoleId, int iLevel, 
		                             int iVipLevel, int iEventType, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iEventType = iEventType;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleSteleActivityFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iEventType);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// �¼�����
		public int iEventType;
		public int iArg;
	}

	public static class RoleFightNpcActivityFlow
	{

		public RoleFightNpcActivityFlow() { }

		public RoleFightNpcActivityFlow(String dtEventTime, String vGameId, String vOpenId, int iGameSvrId, 
		                                String vChannelId, String vUid, int iRoleId, int iLevel, 
		                                int iVipLevel, int iEventType, int iWin, int iArg)
		{
			this.dtEventTime = dtEventTime;
			this.vGameId = vGameId;
			this.vOpenId = vOpenId;
			this.iGameSvrId = iGameSvrId;
			this.vChannelId = vChannelId;
			this.vUid = vUid;
			this.iRoleId = iRoleId;
			this.iLevel = iLevel;
			this.iVipLevel = iVipLevel;
			this.iEventType = iEventType;
			this.iWin = iWin;
			this.iArg = iArg;
		}

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder("");
			sb.append("RoleFightNpcActivityFlow");
			sb.append('|').append(dtEventTime);
			sb.append('|').append(vGameId);
			sb.append('|').append(vOpenId);
			sb.append('|').append(iGameSvrId);
			sb.append('|').append(vChannelId);
			sb.append('|').append(vUid);
			sb.append('|').append(iRoleId);
			sb.append('|').append(iLevel);
			sb.append('|').append(iVipLevel);
			sb.append('|').append(iEventType);
			sb.append('|').append(iWin);
			sb.append('|').append(iArg);
			sb.append('\n');
			return sb.toString();
		}

		public String dtEventTime;
		public String vGameId;
		// (����)�û�UId��
		public String vOpenId;
		public int iGameSvrId;
		public String vChannelId;
		// �û�Uid��
		public String vUid;
		// �ڲ���ɫId
		public int iRoleId;
		// ��ҵȼ�
		public int iLevel;
		// Vip�ȼ�
		public int iVipLevel;
		// �¼�����
		public int iEventType;
		// �¼�����
		public int iWin;
		public int iArg;
	}

}
