// modified by i3k.gtool.QQMetaGen at Sat May 06 17:01:18 CST 2017.

package i3k;

import java.util.List;
import java.util.ArrayList;
import ket.util.Stream;

public final class IDIP
{


	public static final int IDIP_HEADER_RESULT_EMPTY_PACKET_SUCCESS = 1;
	public static final int IDIP_HEADER_RESULT_SUCCESS = 0;
	public static final int IDIP_HEADER_RESULT_NETWORK_EXCEPTION = -1;
	public static final int IDIP_HEADER_RESULT_TIMEOUT = -2;
	public static final int IDIP_HEADER_RESULT_DB_EXCEPTION = -3;
	public static final int IDIP_HEADER_RESULT_API_EXCEPTION = -4;
	public static final int IDIP_HEADER_RESULT_SERVER_BUSY = -5;
	public static final int IDIP_HEADER_RESULT_OTHER_ERROR = -100;
	public static final int IDIP_HEADER_RESULT_USER_NOT_EXIST = -101;
	public static final int IDIP_HEADER_RESULT_ROLE_NOT_EXIST = -102;
	public static final int IDIP_HEADER_RESULT_ROLE_CONDITION_NOT_MATCH = -103;
	public static final int YYB_GIFT_CONDITION_TYPE_NONE = 0;
	public static final int YYB_GIFT_CONDITION_TYPE_LEVEL = 1;
	public static final int YYB_GIFT_CONDITION_TYPE_VIP_POINT = 2;

	// IDIP�������
	// ��ֹ�û���½����
	public static final int IDIP_DO_BAN_USR_REQ = 0x1001;
	// ��ֹ�û���½Ӧ��
	public static final int IDIP_DO_BAN_USR_RSP = 0x1002;
	// ����û���ֹ��½����
	public static final int IDIP_DO_UNBAN_USR_REQ = 0x1003;
	// ����û���ֹ��½Ӧ��
	public static final int IDIP_DO_UNBAN_USR_RSP = 0x1004;
	// ���û���������
	public static final int IDIP_DO_BAN_USR_CHAT_REQ = 0x1005;
	// ���û�����Ӧ��
	public static final int IDIP_DO_BAN_USR_CHAT_RSP = 0x1006;
	// ����û���������
	public static final int IDIP_DO_UNBAN_USR_CHAT_REQ = 0x1007;
	// ����û�����Ӧ��
	public static final int IDIP_DO_UNBAN_USR_CHAT_RSP = 0x1008;
	// ������������
	public static final int IDIP_DO_KICK_ONLINE_USR_REQ = 0x1009;
	// ��������Ӧ��
	public static final int IDIP_DO_KICK_ONLINE_USR_RSP = 0x100a;
	// ȫ���ʼ�����
	public static final int IDIP_DO_PUSH_MAIL_ALL_REQ = 0x100b;
	// ȫ���ʼ�Ӧ��
	public static final int IDIP_DO_PUSH_MAIL_ALL_RSP = 0x100c;
	// ��ָ������ҷ����ʼ�����
	public static final int IDIP_DO_PUSH_MAIL_USR_REQ = 0x100d;
	// ��ָ����ҷ����ʼ�Ӧ��
	public static final int IDIP_DO_PUSH_MAIL_USR_RSP = 0x100e;
	// ��ȡ���������50����Ϣ����
	public static final int IDIP_DO_GET_CHAT_RECORD_REQ = 0x100f;
	// ��ȡ���������50����ϢӦ��
	public static final int IDIP_DO_GET_CHAT_RECORD_RSP = 0x1010;
	// �������ƹ�������
	public static final int IDIP_DO_ADD_ROLL_NOTICE_REQ = 0x1011;
	// �������ƹ���Ӧ��
	public static final int IDIP_DO_ADD_ROLL_NOTICE_RSP = 0x1012;
	// ɾ������ƹ�������
	public static final int IDIP_DO_DELETE_ROLL_NOTICE_REQ = 0x1013;
	// ɾ������ƹ���Ӧ��
	public static final int IDIP_DO_DELETE_ROLL_NOTICE_RSP = 0x1014;
	// ��ѯ��ɫ��Ϣ����
	public static final int IDIP_DO_INQUIRY_ROLE_INFO_REQ = 0x1015;
	// ��ѯ��ɫ��ϢӦ��
	public static final int IDIP_DO_INQUIRY_ROLE_INFO_RSP = 0x1016;
	// ��ѯ���roleID����
	public static final int IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_REQ = 0x1017;
	// ��ѯ���RoleIDӦ��
	public static final int IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_RSP = 0x1018;
	// ��ȡ�������б�����
	public static final int IDIP_DO_QUERY_SERVER_INFO_REQ = 0x1019;
	// ��ȡ�������б�Ӧ��
	public static final int IDIP_DO_QUERY_SERVER_INFO_RSP = 0x101a;
	// ���ע���ʼ�����
	public static final int IDIP_DO_REGISTER_MAIL_REQ = 0x101b;
	// ���ע���ʼ�Ӧ��
	public static final int IDIP_DO_REGISTER_MAIL_RSP = 0x101c;
	// ɾ��ע���ʼ�����
	public static final int IDIP_DO_REGISTER_MAIL_DEL_REQ = 0x101d;
	// ɾ��ע���ʼ�Ӧ��
	public static final int IDIP_DO_REGISTER_MAIL_DEL_RSP = 0x101e;
	// �޸Ľ�ɫ�ȼ�����
	public static final int IDIP_DO_CHANGE_ROLE_LEVEL_REQ = 0x1020;
	// �޸Ľ�ɫ�ȼ�Ӧ��
	public static final int IDIP_DO_CHANGE_ROLE_LEVEL_RSP = 0x1021;
	// �޸Ľ�ɫVIP��������
	public static final int IDIP_DO_CHANGE_ROLE_VIP_POINT_REQ = 0x1022;
	// �޸Ľ�ɫVIP����Ӧ��
	public static final int IDIP_DO_CHANGE_ROLE_VIP_POINT_RSP = 0x1023;
	// ��ӽ�ɫ��ֵ����
	public static final int IDIP_DO_ADD_ROLE_GOD_PAY_REQ = 0x1024;
	// ��ӽ�ɫ��ֵӦ��
	public static final int IDIP_DO_ADD_ROLE_GOD_PAY_RSP = 0x1025;
	// ��ѯ�˻���ɫ����
	public static final int IDIP_DO_QUERY_ROLES_REQ = 0x1026;
	// ��ѯ�˻���ɫӦ��
	public static final int IDIP_DO_QUERY_ROLES_RSP = 0x1027;
	// Ӧ�ñ����ͽ�������
	public static final int IDIP_DO_SEND_ROLE_GIFT_REQ = 0x1028;
	// Ӧ�ñ����ͽ���Ӧ��
	public static final int IDIP_DO_SEND_ROLE_GIFT_RSP = 0x1029;
	// ���ӽ�ɫVIP��������
	public static final int IDIP_DO_ADD_ROLE_VIP_POINT_REQ = 0x1030;
	// ���ӽ�ɫVIP����Ӧ��
	public static final int IDIP_DO_ADD_ROLE_VIP_POINT_RSP = 0x1031;

	// ϵͳ��
	// ��װ����������ֵ, ���������ݰ��Ĵ�С��15K���£�ֻ�в�ѯ�ʼ��б�����������Ƚϴ���23K����
	public static final int IDIP_BODY_LENGTH = 24000;
	// SERVICENAME����󳤶�
	public static final int SERVICE_NAME_LENGTH = 16;
	// ���ܴ�����󳤶�
	public static final int AUTHENTICATE_LENGTH = 32;
	// ������
	public static final int ERROR_MSG_LENGTH = 100;
	// openid�ĳ���
	public static final int MAX_OPENID_LEN = 64;
	// ������Ϣ�������ֵ
	public static final int MAX_MESSAGES_LEN = 1000;
	// ���������󳤶�
	public static final int MAX_ROLE_NAME_LEN = 30;
	// ����������󳤶�
	public static final int MAX_CHANNEL_NAME_LEN = 30;
	// UID��󳤶�
	public static final int MAX_UID_LEN = 64;
	// ������Ϣ��󳤶�
	public static final int MAX_CHAT_MESSAGE_LEN = 200;
	// �ʼ�����ĳ���
	public static final int MAX_MAILTITLE_LEN = 30;
	// �ʼ����ݵĳ���
	public static final int MAX_MAILCONTENT_LEN = 900;
	// ����ƹ���������󳤶�
	public static final int MAX_MOVING_NOTICE_LEN = 200;
	// ������������󳤶�
	public static final int MAX_SERVER_NAME_LEN = 30;
	// ���ԭ��ĳ���
	public static final int MAX_REASON_LEN = 64;
	// �ʼ�������Ʒ�б�����鳤��
	public static final int MAX_ATTLIST_NUM = 4;
	// ���ȼ�
	public static final int MAX_LEVEL = 1000;
	// ��С�ȼ�
	public static final int MIN_LEVEL = 1;
	// ���VIP�ȼ�
	public static final int MAX_VIP_LEVEL = 100;
	// ��СVIP�ȼ�
	public static final int MIN_VIP_LEVEL = 0;
	// ����ɫ����
	public static final int MAX_ROLE_SIZE = 4;
	// �������ʶ����
	public static final int MAX_SEND_ACTION_LENGTH = 15;
	// ���OPENID����
	public static final int MAX_OPENID_LENGTH = 60;
	// �������ʶ����
	public static final int MAX_CHANNEL_LEN = 25;

	public static final int PACKET_HEADER_SIZE = 4 + 4 + 4 + SERVICE_NAME_LENGTH + 4 + 4 + AUTHENTICATE_LENGTH + 4 + ERROR_MSG_LENGTH;



	// IDIP��Ϣͷ
	public static class IdipHeader implements Stream.IStreamable
	{

		public IdipHeader() { }

		public IdipHeader(int PacketLen, int Cmdid, int Seqid, String ServiceName, 
		                  int SendTime, int Version, String Authenticate, int Result, 
		                  String RetErrMsg)
		{
			this.PacketLen = PacketLen;
			this.Cmdid = Cmdid;
			this.Seqid = Seqid;
			this.ServiceName = ServiceName;
			this.SendTime = SendTime;
			this.Version = Version;
			this.Authenticate = Authenticate;
			this.Result = Result;
			this.RetErrMsg = RetErrMsg;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			PacketLen = is.popInteger();
			Cmdid = is.popInteger();
			Seqid = is.popInteger();
			ServiceName = is.popString(SERVICE_NAME_LENGTH);
			SendTime = is.popInteger();
			Version = is.popInteger();
			Authenticate = is.popString(AUTHENTICATE_LENGTH);
			Result = is.popInteger();
			RetErrMsg = is.popString(ERROR_MSG_LENGTH);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(PacketLen);
			os.pushInteger(Cmdid);
			os.pushInteger(Seqid);
			os.pushString(ServiceName, SERVICE_NAME_LENGTH);
			os.pushInteger(SendTime);
			os.pushInteger(Version);
			os.pushString(Authenticate, AUTHENTICATE_LENGTH);
			os.pushInteger(Result);
			os.pushString(RetErrMsg, ERROR_MSG_LENGTH);
		}

		// ����
		public int PacketLen;
		// ����ID
		public int Cmdid;
		// ��ˮ��
		public int Seqid;
		// ������
		public String ServiceName = new String();
		// ����ʱ��YYYYMMDD��Ӧ������
		public int SendTime;
		// �汾��
		public int Version;
		// ���ܴ�
		public String Authenticate = new String();
		// ������,���������ͣ�0������ɹ�����Ҫ�⿪��������ϸ��Ϣ,1������ɹ��������巵��Ϊ�գ�����Ҫ������壨eg����ѯ�û���ɫ���û���ɫ�����ڵȣ���-1: ����ͨ���쳣,-2����ʱ,-3�����ݿ�����쳣,-4��API�����쳣,-5��������æ,-6����������,С��-100 ���û��Զ��������Ҫ��дszRetErrMsg
		public int Result;
		// ������Ϣ
		public String RetErrMsg = new String();
	}

	// IDIP���ݰ�
	public static class IdipDataPaket implements Stream.IStreamable
	{

		public IdipDataPaket() { }

		public IdipDataPaket(IdipHeader IdipHead, String IdipBody)
		{
			this.IdipHead = IdipHead;
			this.IdipBody = IdipBody;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			is.pop(IdipHead);
			IdipBody = is.popString(IDIP_BODY_LENGTH);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.push(IdipHead);
			os.pushString(IdipBody, IDIP_BODY_LENGTH);
		}

		// ��ͷ��Ϣ
		public IdipHeader IdipHead = new IdipHeader();
		// ������Ϣ
		public String IdipBody = new String();
	}

	// ��Ʒid + ��Ʒcount
	public static class CommonItems implements Stream.IStreamable
	{

		public CommonItems() { }

		public CommonItems(int id, int count)
		{
			this.id = id;
			this.count = count;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			id = is.popInteger();
			count = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(id);
			os.pushInteger(count);
		}

		// ��ƷID
		public int id;
		// ��Ʒ����
		public int count;
	}

	// ����������Ϣ����
	public static class Message implements Stream.IStreamable
	{

		public Message() { }

		public Message(int roleId, String roleName, int roleTime, String body)
		{
			this.roleId = roleId;
			this.roleName = roleName;
			this.roleTime = roleTime;
			this.body = body;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			roleId = is.popInteger();
			roleName = is.popString(MAX_ROLE_NAME_LEN);
			roleTime = is.popInteger();
			body = is.popString(MAX_CHAT_MESSAGE_LEN);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(roleId);
			os.pushString(roleName, MAX_ROLE_NAME_LEN);
			os.pushInteger(roleTime);
			os.pushString(body, MAX_CHAT_MESSAGE_LEN);
		}

		// ���roleID
		public int roleId;
		// �������
		public String roleName = new String();
		// ����ʱ��
		public int roleTime;
		// ������Ϣ����
		public String body = new String();
	}

	// �������б���Ϣ
	public static class ServerOverview implements Stream.IStreamable
	{

		public ServerOverview() { }

		public ServerOverview(int serverId, String serverName, int openTime, int onlineCount, 
		                      int roleTotalCreate)
		{
			this.serverId = serverId;
			this.serverName = serverName;
			this.openTime = openTime;
			this.onlineCount = onlineCount;
			this.roleTotalCreate = roleTotalCreate;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			serverId = is.popInteger();
			serverName = is.popString(MAX_SERVER_NAME_LEN);
			openTime = is.popInteger();
			onlineCount = is.popInteger();
			roleTotalCreate = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(serverId);
			os.pushString(serverName, MAX_SERVER_NAME_LEN);
			os.pushInteger(openTime);
			os.pushInteger(onlineCount);
			os.pushInteger(roleTotalCreate);
		}

		// ������ID
		public int serverId;
		// ����������
		public String serverName = new String();
		// ����������ʱ��
		public int openTime;
		// �����������
		public int onlineCount;
		// �����������
		public int roleTotalCreate;
	}

	// Ӧ�ñ���ɫ��Ϣ
	public static class YYBRoleInfo implements Stream.IStreamable
	{

		public YYBRoleInfo() { }

		public YYBRoleInfo(int roleId, String roleName)
		{
			this.roleId = roleId;
			this.roleName = roleName;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			roleId = is.popInteger();
			roleName = is.popString(MAX_ROLE_NAME_LEN);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(roleId);
			os.pushString(roleName, MAX_ROLE_NAME_LEN);
		}

		// ���roleID
		public int roleId;
		// �������
		public String roleName = new String();
	}

	// ��ֹ��½����
	public static class DoBanUsrReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_BAN_USR_REQ;

		public DoBanUsrReq() { }

		public DoBanUsrReq(int Partition, int RoleId, int LeftTime, String Reason)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.LeftTime = LeftTime;
			this.Reason = Reason;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			LeftTime = is.popInteger();
			Reason = is.popString(MAX_REASON_LEN);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(LeftTime);
			os.pushString(Reason, MAX_REASON_LEN);
		}

		// ������ID
		public int Partition;
		// ��ɫID������Ϊ�����;����
		public int RoleId;
		public int LeftTime;
		// ���ԭ��
		public String Reason = new String();
	}

	// ��ֹ��½Ӧ��
	public static class DoBanUsrRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_BAN_USR_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ����û���½����
	public static class DoUnBanUsrReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_UNBAN_USR_REQ;

		public DoUnBanUsrReq() { }

		public DoUnBanUsrReq(int Partition, int RoleId)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
		}

		// ������ID
		public int Partition;
		// ��ɫID������Ϊ�����;����
		public int RoleId;
	}

	// ����û���½Ӧ��
	public static class DoUnBanUsrRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_UNBAN_USR_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// �û���������
	public static class DoBanUsrChatReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_BAN_USR_CHAT_REQ;

		public DoBanUsrChatReq() { }

		public DoBanUsrChatReq(int Partition, int RoleId, int LeftTime, String Reason)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.LeftTime = LeftTime;
			this.Reason = Reason;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			LeftTime = is.popInteger();
			Reason = is.popString(MAX_REASON_LEN);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(LeftTime);
			os.pushString(Reason, MAX_REASON_LEN);
		}

		// ������ID
		public int Partition;
		// ��ɫID������Ϊ�����;����
		public int RoleId;
		public int LeftTime;
		// ����ԭ��
		public String Reason = new String();
	}

	// �û�����Ӧ��
	public static class DoBanUsrChatRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_BAN_USR_CHAT_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ����û���������
	public static class DoUnBanUsrChatReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_UNBAN_USR_CHAT_REQ;

		public DoUnBanUsrChatReq() { }

		public DoUnBanUsrChatReq(int Partition, int RoleId)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
		}

		// ������ID
		public int Partition;
		// ��ɫID������Ϊ�����;����
		public int RoleId;
	}

	// ����û�����Ӧ��
	public static class DoUnBanUsrChatRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_UNBAN_USR_CHAT_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ������������
	public static class DoKickOnlineUsrReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_KICK_ONLINE_USR_REQ;

		public DoKickOnlineUsrReq() { }

		public DoKickOnlineUsrReq(int Partition, int RoleId)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
		}

		// ������ID
		public int Partition;
		// ��ɫID������Ϊ�����;����
		public int RoleId;
	}

	// ��������Ӧ��
	public static class DoKickOnlineUsrRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_KICK_ONLINE_USR_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ȫ���ʼ�����
	public static class DoPushMailAllReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_PUSH_MAIL_ALL_REQ;

		public DoPushMailAllReq() { }

		public DoPushMailAllReq(int Partition, String Title, String Body, int LifeTime, 
		                        int LevelMin, int LevelMax, int VipMin, int VipMax, 
		                        int ChannelCount, List<String> ChannelReq, int AttListCount, List<CommonItems> Awards)
		{
			this.Partition = Partition;
			this.Title = Title;
			this.Body = Body;
			this.LifeTime = LifeTime;
			this.LevelMin = LevelMin;
			this.LevelMax = LevelMax;
			this.VipMin = VipMin;
			this.VipMax = VipMax;
			this.ChannelCount = ChannelCount;
			this.ChannelReq = ChannelReq;
			this.AttListCount = AttListCount;
			this.Awards = Awards;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			Title = is.popString(MAX_MAILTITLE_LEN);
			Body = is.popString(MAX_MAILCONTENT_LEN);
			LifeTime = is.popInteger();
			LevelMin = is.popInteger();
			LevelMax = is.popInteger();
			VipMin = is.popInteger();
			VipMax = is.popInteger();
			ChannelCount = is.popInteger();
			ChannelReq = is.popStringList();
			AttListCount = is.popInteger();
			Awards = is.popList(CommonItems.class, AttListCount);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(Title, MAX_MAILTITLE_LEN);
			os.pushString(Body, MAX_MAILCONTENT_LEN);
			os.pushInteger(LifeTime);
			os.pushInteger(LevelMin);
			os.pushInteger(LevelMax);
			os.pushInteger(VipMin);
			os.pushInteger(VipMax);
			os.pushInteger(ChannelCount);
			os.pushStringList(ChannelReq);
			os.pushInteger(AttListCount);
			os.pushList(Awards, AttListCount);
		}

		// ������ID
		public int Partition;
		// �ʼ�����
		public String Title = new String();
		// ����
		public String Body = new String();
		// �ʼ�����������
		public int LifeTime;
		// �ȼ�����
		public int LevelMin;
		// �ȼ�����
		public int LevelMax;
		// vip�ȼ�����
		public int VipMin;
		// vip�ȼ�����
		public int VipMax;
		// ����ȡ��������(0-25)
		public int ChannelCount;
		// ����ȡchannel�б���ʽ2001;1002
		public List<String> ChannelReq = new ArrayList<String>();
		// ������Ʒ�б���������(0-4)
		public int AttListCount;
		// �����б�,��ʽ3001_1;3002_10
		public List<CommonItems> Awards = new ArrayList<CommonItems>();
	}

	// ȫ���ʼ�Ӧ��
	public static class DoPushMailAllRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_PUSH_MAIL_ALL_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ����ҷ����ʼ�����
	public static class DoPushMailUsrReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_PUSH_MAIL_USR_REQ;

		public DoPushMailUsrReq() { }

		public DoPushMailUsrReq(int Partition, int RoleId, String Title, String Body, 
		                        int LifeTime, int AttListCount, List<CommonItems> Awards)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.Title = Title;
			this.Body = Body;
			this.LifeTime = LifeTime;
			this.AttListCount = AttListCount;
			this.Awards = Awards;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			Title = is.popString(MAX_MAILTITLE_LEN);
			Body = is.popString(MAX_MAILCONTENT_LEN);
			LifeTime = is.popInteger();
			AttListCount = is.popInteger();
			Awards = is.popList(CommonItems.class, AttListCount);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushString(Title, MAX_MAILTITLE_LEN);
			os.pushString(Body, MAX_MAILCONTENT_LEN);
			os.pushInteger(LifeTime);
			os.pushInteger(AttListCount);
			os.pushList(Awards, AttListCount);
		}

		// ������ID
		public int Partition;
		// �û�id
		public int RoleId;
		// �ʼ�����
		public String Title = new String();
		// ����
		public String Body = new String();
		// �ʼ���������
		public int LifeTime;
		// ������Ʒ�б���������(0-4)
		public int AttListCount;
		// �����б�,��ʽ3001_1;3002_10
		public List<CommonItems> Awards = new ArrayList<CommonItems>();
	}

	// ����ҷ����ʼ�Ӧ��
	public static class DoPushMailUsrRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_PUSH_MAIL_USR_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ��ȡ���������50��������Ϣ����
	public static class DoGetChatRecordReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_GET_CHAT_RECORD_REQ;

		public DoGetChatRecordReq() { }

		public DoGetChatRecordReq(int Partition)
		{
			this.Partition = Partition;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
		}

		// ������ID
		public int Partition;
	}

	// ��ȡ���������50��������ϢӦ��
	public static class DoGetChatRecordRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_GET_CHAT_RECORD_RSP;

		public DoGetChatRecordRsp() { }

		public DoGetChatRecordRsp(int AttListCount, List<Message> Messages)
		{
			this.AttListCount = AttListCount;
			this.Messages = Messages;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			AttListCount = is.popInteger();
			Messages = is.popList(Message.class, AttListCount);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(AttListCount);
			os.pushList(Messages, AttListCount);
		}

		// List����
		public int AttListCount;
		// ������Ϣ����
		public List<Message> Messages = new ArrayList<Message>();
	}

	// �������ƹ�������
	public static class DoAddRollNoticeReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLL_NOTICE_REQ;

		public DoAddRollNoticeReq() { }

		public DoAddRollNoticeReq(int Partition, String Body, int Cycle, int startTime, 
		                          int LeftTime)
		{
			this.Partition = Partition;
			this.Body = Body;
			this.Cycle = Cycle;
			this.startTime = startTime;
			this.LeftTime = LeftTime;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			Body = is.popString(MAX_MOVING_NOTICE_LEN);
			Cycle = is.popInteger();
			startTime = is.popInteger();
			LeftTime = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(Body, MAX_MOVING_NOTICE_LEN);
			os.pushInteger(Cycle);
			os.pushInteger(startTime);
			os.pushInteger(LeftTime);
		}

		// ������ID
		public int Partition;
		public String Body = new String();
		// ѭ�����-��
		public int Cycle;
		// ��ʼʱ��
		public int startTime;
		// ����ʱ�䣨�룩
		public int LeftTime;
	}

	// �������ƹ���Ӧ��
	public static class DoAddRollNoticeRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLL_NOTICE_RSP;

		public DoAddRollNoticeRsp() { }

		public DoAddRollNoticeRsp(int NoticeId)
		{
			this.NoticeId = NoticeId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			NoticeId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(NoticeId);
		}

		// ����ID
		public int NoticeId;
	}

	// ɾ������ƹ�������
	public static class DoDeleteRollNoticeReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_DELETE_ROLL_NOTICE_REQ;

		public DoDeleteRollNoticeReq() { }

		public DoDeleteRollNoticeReq(int Partition, int NoticeId)
		{
			this.Partition = Partition;
			this.NoticeId = NoticeId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			NoticeId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(NoticeId);
		}

		// ������ID
		public int Partition;
		// ����ID
		public int NoticeId;
	}

	// ɾ������ƹ���Ӧ��
	public static class DoDeleteRollNoticeRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_DELETE_ROLL_NOTICE_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ��ѯ��ɫ��Ϣ����
	public static class DoInquiryRoleInfoReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_INQUIRY_ROLE_INFO_REQ;

		public DoInquiryRoleInfoReq() { }

		public DoInquiryRoleInfoReq(int Partition, int RoleId)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
		}

		// ������ID
		public int Partition;
		// ���RoleID
		public int RoleId;
	}

	// ��ѯ��ɫ��ϢӦ��
	public static class DoInquiryRoleInfoRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_INQUIRY_ROLE_INFO_RSP;

		public DoInquiryRoleInfoRsp() { }

		public DoInquiryRoleInfoRsp(int RoleId, String RoleName, int ServerId, int Level, 
		                            int VipLevel, int PayNum, int CreateTime, String Channel, 
		                            String Uid, int IsOnline, int LastLoginTime, int Money, 
		                            int bindMoney, int Diamond, int bindDiamond, int BanStatus, 
		                            int DiamondFUseTotal, int DiamondRUseTotal, byte ClassType, byte TransfromLvl, 
		                            byte BWType, byte Gender)
		{
			this.RoleId = RoleId;
			this.RoleName = RoleName;
			this.ServerId = ServerId;
			this.Level = Level;
			this.VipLevel = VipLevel;
			this.PayNum = PayNum;
			this.CreateTime = CreateTime;
			this.Channel = Channel;
			this.Uid = Uid;
			this.IsOnline = IsOnline;
			this.LastLoginTime = LastLoginTime;
			this.Money = Money;
			this.bindMoney = bindMoney;
			this.Diamond = Diamond;
			this.bindDiamond = bindDiamond;
			this.BanStatus = BanStatus;
			this.DiamondFUseTotal = DiamondFUseTotal;
			this.DiamondRUseTotal = DiamondRUseTotal;
			this.ClassType = ClassType;
			this.TransfromLvl = TransfromLvl;
			this.BWType = BWType;
			this.Gender = Gender;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			RoleId = is.popInteger();
			RoleName = is.popString(MAX_ROLE_NAME_LEN);
			ServerId = is.popInteger();
			Level = is.popInteger();
			VipLevel = is.popInteger();
			PayNum = is.popInteger();
			CreateTime = is.popInteger();
			Channel = is.popString(MAX_CHANNEL_NAME_LEN);
			Uid = is.popString(MAX_UID_LEN);
			IsOnline = is.popInteger();
			LastLoginTime = is.popInteger();
			Money = is.popInteger();
			bindMoney = is.popInteger();
			Diamond = is.popInteger();
			bindDiamond = is.popInteger();
			BanStatus = is.popInteger();
			DiamondFUseTotal = is.popInteger();
			DiamondRUseTotal = is.popInteger();
			ClassType = is.popByte();
			TransfromLvl = is.popByte();
			BWType = is.popByte();
			Gender = is.popByte();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(RoleId);
			os.pushString(RoleName, MAX_ROLE_NAME_LEN);
			os.pushInteger(ServerId);
			os.pushInteger(Level);
			os.pushInteger(VipLevel);
			os.pushInteger(PayNum);
			os.pushInteger(CreateTime);
			os.pushString(Channel, MAX_CHANNEL_NAME_LEN);
			os.pushString(Uid, MAX_UID_LEN);
			os.pushInteger(IsOnline);
			os.pushInteger(LastLoginTime);
			os.pushInteger(Money);
			os.pushInteger(bindMoney);
			os.pushInteger(Diamond);
			os.pushInteger(bindDiamond);
			os.pushInteger(BanStatus);
			os.pushInteger(DiamondFUseTotal);
			os.pushInteger(DiamondRUseTotal);
			os.pushByte(ClassType);
			os.pushByte(TransfromLvl);
			os.pushByte(BWType);
			os.pushByte(Gender);
		}

		// ���RoleID
		public int RoleId;
		// �������
		public String RoleName = new String();
		// ������ID
		public int ServerId;
		// ��ҵȼ�
		public int Level;
		// ���Vip�ȼ�
		public int VipLevel;
		// �ܳ�ֵ���
		public int PayNum;
		// ��ɫ����ʱ��
		public int CreateTime;
		// ����
		public String Channel = new String();
		// ����
		public String Uid = new String();
		// �Ƿ�����
		public int IsOnline;
		// ����¼ʱ��
		public int LastLoginTime;
		// ��ɫ��ǰ�������
		public int Money;
		// ��ɫ��ǰ�󶨽������
		public int bindMoney;
		// ��ɫ��ǰ��ʯ����
		public int Diamond;
		// ��ɫ��ǰ����ʯ����
		public int bindDiamond;
		// �Ƿ񱻷��
		public int BanStatus;
		// ��ɫ�����ܷǰ�Ԫ������
		public int DiamondFUseTotal;
		// ��ɫ�����ܰ�Ԫ������
		public int DiamondRUseTotal;
		// ְҵ
		public byte ClassType;
		// תְ�ȼ�
		public byte TransfromLvl;
		// ��а
		public byte BWType;
		// �Ա�
		public byte Gender;
	}

	// ��ѯ���roleID����
	public static class DoInquiryRoleIdByNameReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_REQ;

		public DoInquiryRoleIdByNameReq() { }

		public DoInquiryRoleIdByNameReq(int Partition, String RoleName)
		{
			this.Partition = Partition;
			this.RoleName = RoleName;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleName = is.popString(MAX_ROLE_NAME_LEN);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(RoleName, MAX_ROLE_NAME_LEN);
		}

		// ������ID
		public int Partition;
		// �������
		public String RoleName = new String();
	}

	// ��ѯ���roleIDӦ��
	public static class DoInquiryRoleIdByNameRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_RSP;

		public DoInquiryRoleIdByNameRsp() { }

		public DoInquiryRoleIdByNameRsp(int RoleId)
		{
			this.RoleId = RoleId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			RoleId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(RoleId);
		}

		// ���roleID
		public int RoleId;
	}

	// ��ȡ�������б�����
	public static class DoQueryServerInfoReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_QUERY_SERVER_INFO_REQ;

		public DoQueryServerInfoReq() { }

		public DoQueryServerInfoReq(int Partition)
		{
			this.Partition = Partition;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
		}

		// ������ID
		public int Partition;
	}

	// ��ȡ�������б�Ӧ��
	public static class DoQueryServerInfoRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_QUERY_SERVER_INFO_RSP;

		public DoQueryServerInfoRsp() { }

		public DoQueryServerInfoRsp(int OpenTime, int OnlineCount, int RoleTotalCreate)
		{
			this.OpenTime = OpenTime;
			this.OnlineCount = OnlineCount;
			this.RoleTotalCreate = RoleTotalCreate;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			OpenTime = is.popInteger();
			OnlineCount = is.popInteger();
			RoleTotalCreate = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(OpenTime);
			os.pushInteger(OnlineCount);
			os.pushInteger(RoleTotalCreate);
		}

		// ����ʱ��
		public int OpenTime;
		// ��������
		public int OnlineCount;
		// ��������
		public int RoleTotalCreate;
	}

	// ���ע���ʼ�����
	public static class DoAddRegisterMailReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_REGISTER_MAIL_REQ;

		public DoAddRegisterMailReq() { }

		public DoAddRegisterMailReq(int Partition, String Title, String Body, int ChannelCount, 
		                            List<String> ChannelReq, int AttListCount, List<CommonItems> Awards)
		{
			this.Partition = Partition;
			this.Title = Title;
			this.Body = Body;
			this.ChannelCount = ChannelCount;
			this.ChannelReq = ChannelReq;
			this.AttListCount = AttListCount;
			this.Awards = Awards;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			Title = is.popString(MAX_MAILTITLE_LEN);
			Body = is.popString(MAX_MAILCONTENT_LEN);
			ChannelCount = is.popInteger();
			ChannelReq = is.popStringList();
			AttListCount = is.popInteger();
			Awards = is.popList(CommonItems.class, AttListCount);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(Title, MAX_MAILTITLE_LEN);
			os.pushString(Body, MAX_MAILCONTENT_LEN);
			os.pushInteger(ChannelCount);
			os.pushStringList(ChannelReq);
			os.pushInteger(AttListCount);
			os.pushList(Awards, AttListCount);
		}

		// ������ID
		public int Partition;
		// ����
		public String Title = new String();
		// ����
		public String Body = new String();
		// ����ȡ��������(0-25)
		public int ChannelCount;
		// ����ȡchannel�б���ʽ2001;1002
		public List<String> ChannelReq = new ArrayList<String>();
		// ������Ʒ�б���������(0-4)
		public int AttListCount;
		// �����б�,��ʽ3001_1;3002_10
		public List<CommonItems> Awards = new ArrayList<CommonItems>();
	}

	// ���ע���ʼ�Ӧ��
	public static class DoAddRegisterMailRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_REGISTER_MAIL_RSP;

		public DoAddRegisterMailRsp() { }

		public DoAddRegisterMailRsp(int RemailId)
		{
			this.RemailId = RemailId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			RemailId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(RemailId);
		}

		// �ʼ�ID
		public int RemailId;
	}

	// ɾ��ע���ʼ�����
	public static class DoDelRegisterMailReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_REGISTER_MAIL_DEL_REQ;

		public DoDelRegisterMailReq() { }

		public DoDelRegisterMailReq(int Partition, int RemailId)
		{
			this.Partition = Partition;
			this.RemailId = RemailId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RemailId = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RemailId);
		}

		// ������ID
		public int Partition;
		// �ʼ�ID
		public int RemailId;
	}

	// ɾ��ע���ʼ�Ӧ��
	public static class DoDelRegisterMailRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_REGISTER_MAIL_DEL_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// �޸Ľ�ɫ�ȼ�����
	public static class DoChangeRoleLevelReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_CHANGE_ROLE_LEVEL_REQ;

		public DoChangeRoleLevelReq() { }

		public DoChangeRoleLevelReq(int Partition, int RoleId, int Level)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.Level = Level;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			Level = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(Level);
		}

		// ������ID
		public int Partition;
		// ��ɫID
		public int RoleId;
		// �ȼ�
		public int Level;
	}

	// �޸Ľ�ɫ�ȼ�Ӧ��
	public static class DoChangeRoleLevelRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_CHANGE_ROLE_LEVEL_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// �޸Ľ�ɫVIP��������
	public static class DoChangeRoleVipPointReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_CHANGE_ROLE_VIP_POINT_REQ;

		public DoChangeRoleVipPointReq() { }

		public DoChangeRoleVipPointReq(int Partition, int RoleId, int Point)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.Point = Point;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			Point = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(Point);
		}

		// ������ID
		public int Partition;
		// ��ɫID
		public int RoleId;
		// ����vip��
		public int Point;
	}

	// �޸Ľ�ɫVIP����Ӧ��
	public static class DoChangeRoleVipPointRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_CHANGE_ROLE_VIP_POINT_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// �޸Ľ�ɫVIP��������
	public static class DoAddRoleVipPointReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLE_VIP_POINT_REQ;

		public DoAddRoleVipPointReq() { }

		public DoAddRoleVipPointReq(int Partition, int RoleId, int Point)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.Point = Point;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			Point = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(Point);
		}

		// ������ID
		public int Partition;
		// ��ɫID
		public int RoleId;
		// ����vip��
		public int Point;
	}

	// �޸Ľ�ɫVIP����Ӧ��
	public static class DoAddRoleVipPointRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLE_VIP_POINT_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ���ӽ�ɫ��ֵ����
	public static class DoAddRoleGodPayReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLE_GOD_PAY_REQ;

		public DoAddRoleGodPayReq() { }

		public DoAddRoleGodPayReq(int Partition, int RoleId, int PayLevel)
		{
			this.Partition = Partition;
			this.RoleId = RoleId;
			this.PayLevel = PayLevel;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			RoleId = is.popInteger();
			PayLevel = is.popInteger();
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushInteger(RoleId);
			os.pushInteger(PayLevel);
		}

		// ������ID
		public int Partition;
		// ��ɫID
		public int RoleId;
		// ����vip��
		public int PayLevel;
	}

	// ���ӽ�ɫ��ֵӦ��
	public static class DoAddRoleGodPayRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_ADD_ROLE_GOD_PAY_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	// ��ѯ�˻���ɫ����
	public static class DoQueryRolesReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_QUERY_ROLES_REQ;

		public DoQueryRolesReq() { }

		public DoQueryRolesReq(int Partition, String OpenId)
		{
			this.Partition = Partition;
			this.OpenId = OpenId;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			OpenId = is.popString(MAX_OPENID_LENGTH);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(OpenId, MAX_OPENID_LENGTH);
		}

		// ������ID
		public int Partition;
		// �˺�ID
		public String OpenId = new String();
	}

	// ��ѯ�˻���ɫӦ��
	public static class DoQueryRolesRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_QUERY_ROLES_RSP;

		public DoQueryRolesRsp() { }

		public DoQueryRolesRsp(int AttListCount, List<YYBRoleInfo> Roles)
		{
			this.AttListCount = AttListCount;
			this.Roles = Roles;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			AttListCount = is.popInteger();
			Roles = is.popList(YYBRoleInfo.class, AttListCount);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(AttListCount);
			os.pushList(Roles, AttListCount);
		}

		// List����
		public int AttListCount;
		// ������Ϣ����
		public List<YYBRoleInfo> Roles = new ArrayList<YYBRoleInfo>();
	}

	// Ӧ�ñ����ͽ�������
	public static class DoSendRoleGiftReq implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_SEND_ROLE_GIFT_REQ;

		public DoSendRoleGiftReq() { }

		public DoSendRoleGiftReq(int Partition, String OpenId, int RoleId, int ConditionType, 
		                         int ConditionValue, int AttListCount, List<CommonItems> Awards, String Action)
		{
			this.Partition = Partition;
			this.OpenId = OpenId;
			this.RoleId = RoleId;
			this.ConditionType = ConditionType;
			this.ConditionValue = ConditionValue;
			this.AttListCount = AttListCount;
			this.Awards = Awards;
			this.Action = Action;
		}

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
			Partition = is.popInteger();
			OpenId = is.popString(MAX_OPENID_LENGTH);
			RoleId = is.popInteger();
			ConditionType = is.popInteger();
			ConditionValue = is.popInteger();
			AttListCount = is.popInteger();
			Awards = is.popList(CommonItems.class, AttListCount);
			Action = is.popString(MAX_SEND_ACTION_LENGTH);
		}

		@Override
		public void encode(Stream.AOStream os)
		{
			os.pushInteger(Partition);
			os.pushString(OpenId, MAX_OPENID_LENGTH);
			os.pushInteger(RoleId);
			os.pushInteger(ConditionType);
			os.pushInteger(ConditionValue);
			os.pushInteger(AttListCount);
			os.pushList(Awards, AttListCount);
			os.pushString(Action, MAX_SEND_ACTION_LENGTH);
		}

		// ������ID
		public int Partition;
		// �˺�ID
		public String OpenId = new String();
		// ��ɫID
		public int RoleId;
		// ��������
		public int ConditionType;
		// ������ֵ
		public int ConditionValue;
		// �������������(0-4)
		public int AttListCount;
		// �����б�,��ʽ3001_1;3002_10
		public List<CommonItems> Awards = new ArrayList<CommonItems>();
		// ��ѯ����
		public String Action = new String();
	}

	// Ӧ�ñ����ͽ���Ӧ��
	public static class DoSendRoleGiftRsp implements Stream.IStreamable
	{

		public static final int idipID = IDIP_DO_SEND_ROLE_GIFT_RSP;

		@Override
		public void decode(Stream.AIStream is) throws Stream.EOFException, Stream.DecodeException
		{
		}

		@Override
		public void encode(Stream.AOStream os)
		{
		}

	}

	public static Stream.IStreamable decodePacket(int cmdID, byte[] bodyData)
	{
		Stream.BytesInputStream bais = new Stream.BytesInputStream(bodyData, 0, bodyData.length);
		Stream.AIStream is = new Stream.IStreamBE(bais);
		try
		{
			switch( cmdID )
			{
			case IDIP_DO_BAN_USR_REQ:
				{
					DoBanUsrReq obj = new DoBanUsrReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_BAN_USR_RSP:
				{
					DoBanUsrRsp obj = new DoBanUsrRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_UNBAN_USR_REQ:
				{
					DoUnBanUsrReq obj = new DoUnBanUsrReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_UNBAN_USR_RSP:
				{
					DoUnBanUsrRsp obj = new DoUnBanUsrRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_BAN_USR_CHAT_REQ:
				{
					DoBanUsrChatReq obj = new DoBanUsrChatReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_BAN_USR_CHAT_RSP:
				{
					DoBanUsrChatRsp obj = new DoBanUsrChatRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_UNBAN_USR_CHAT_REQ:
				{
					DoUnBanUsrChatReq obj = new DoUnBanUsrChatReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_UNBAN_USR_CHAT_RSP:
				{
					DoUnBanUsrChatRsp obj = new DoUnBanUsrChatRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_KICK_ONLINE_USR_REQ:
				{
					DoKickOnlineUsrReq obj = new DoKickOnlineUsrReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_KICK_ONLINE_USR_RSP:
				{
					DoKickOnlineUsrRsp obj = new DoKickOnlineUsrRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_PUSH_MAIL_ALL_REQ:
				{
					DoPushMailAllReq obj = new DoPushMailAllReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_PUSH_MAIL_ALL_RSP:
				{
					DoPushMailAllRsp obj = new DoPushMailAllRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_PUSH_MAIL_USR_REQ:
				{
					DoPushMailUsrReq obj = new DoPushMailUsrReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_PUSH_MAIL_USR_RSP:
				{
					DoPushMailUsrRsp obj = new DoPushMailUsrRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_GET_CHAT_RECORD_REQ:
				{
					DoGetChatRecordReq obj = new DoGetChatRecordReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_GET_CHAT_RECORD_RSP:
				{
					DoGetChatRecordRsp obj = new DoGetChatRecordRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLL_NOTICE_REQ:
				{
					DoAddRollNoticeReq obj = new DoAddRollNoticeReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLL_NOTICE_RSP:
				{
					DoAddRollNoticeRsp obj = new DoAddRollNoticeRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_DELETE_ROLL_NOTICE_REQ:
				{
					DoDeleteRollNoticeReq obj = new DoDeleteRollNoticeReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_DELETE_ROLL_NOTICE_RSP:
				{
					DoDeleteRollNoticeRsp obj = new DoDeleteRollNoticeRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_INQUIRY_ROLE_INFO_REQ:
				{
					DoInquiryRoleInfoReq obj = new DoInquiryRoleInfoReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_INQUIRY_ROLE_INFO_RSP:
				{
					DoInquiryRoleInfoRsp obj = new DoInquiryRoleInfoRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_REQ:
				{
					DoInquiryRoleIdByNameReq obj = new DoInquiryRoleIdByNameReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_INQUIRY_ROLE_ID_BY_NAME_RSP:
				{
					DoInquiryRoleIdByNameRsp obj = new DoInquiryRoleIdByNameRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_QUERY_SERVER_INFO_REQ:
				{
					DoQueryServerInfoReq obj = new DoQueryServerInfoReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_QUERY_SERVER_INFO_RSP:
				{
					DoQueryServerInfoRsp obj = new DoQueryServerInfoRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_REGISTER_MAIL_REQ:
				{
					DoAddRegisterMailReq obj = new DoAddRegisterMailReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_REGISTER_MAIL_RSP:
				{
					DoAddRegisterMailRsp obj = new DoAddRegisterMailRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_REGISTER_MAIL_DEL_REQ:
				{
					DoDelRegisterMailReq obj = new DoDelRegisterMailReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_REGISTER_MAIL_DEL_RSP:
				{
					DoDelRegisterMailRsp obj = new DoDelRegisterMailRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_CHANGE_ROLE_LEVEL_REQ:
				{
					DoChangeRoleLevelReq obj = new DoChangeRoleLevelReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_CHANGE_ROLE_LEVEL_RSP:
				{
					DoChangeRoleLevelRsp obj = new DoChangeRoleLevelRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_CHANGE_ROLE_VIP_POINT_REQ:
				{
					DoChangeRoleVipPointReq obj = new DoChangeRoleVipPointReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_CHANGE_ROLE_VIP_POINT_RSP:
				{
					DoChangeRoleVipPointRsp obj = new DoChangeRoleVipPointRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLE_VIP_POINT_REQ:
				{
					DoAddRoleVipPointReq obj = new DoAddRoleVipPointReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLE_VIP_POINT_RSP:
				{
					DoAddRoleVipPointRsp obj = new DoAddRoleVipPointRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLE_GOD_PAY_REQ:
				{
					DoAddRoleGodPayReq obj = new DoAddRoleGodPayReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_ADD_ROLE_GOD_PAY_RSP:
				{
					DoAddRoleGodPayRsp obj = new DoAddRoleGodPayRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_QUERY_ROLES_REQ:
				{
					DoQueryRolesReq obj = new DoQueryRolesReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_QUERY_ROLES_RSP:
				{
					DoQueryRolesRsp obj = new DoQueryRolesRsp();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_SEND_ROLE_GIFT_REQ:
				{
					DoSendRoleGiftReq obj = new DoSendRoleGiftReq();
					obj.decode(is);
					return obj;
				}
			case IDIP_DO_SEND_ROLE_GIFT_RSP:
				{
					DoSendRoleGiftRsp obj = new DoSendRoleGiftRsp();
					obj.decode(is);
					return obj;
				}
			default:
				break;
			}
		}
		catch(Exception ex)
		{
		}
		return null;
	}
}
