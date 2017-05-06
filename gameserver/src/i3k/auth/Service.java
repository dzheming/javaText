
package i3k.auth;

import java.util.List;

public interface Service
{
	@SuppressWarnings("serial")
	public static class ServiceException extends Exception
	{
		public ServiceException(String msg)
		{
			super(msg);
		}
	}
	
	/**
	 * 
	 * @param host ������ַ
	 * @param port
	 */
	public void start(String host, int port);
	
	/**
	 * �˳�����
	 */
	public void destroy();
	
	/**
	 * ���ó�ֵ���
	 * @param gsid ��Ϸ������id 
	 * @param roleid ��ɫid
	 * @param paylvl ��ֵ�ȼ�
	 * @param orderid ������
	 */
	public int setPayResult(int gsid, String channel, String uid, int roleid, String goodsid, int payLevel, String orderid, String payext) throws ServiceException;
	
	
//	/**
//	 * ����ֵ���
//	 * @param gsid ����ֵ��Ϸ������ 
//	 * @param roleid ��ɫid
//	 * @param payLvl ����ֵ�ȼ�
//	 */
//	public int patchPay(int gsid, int roleid, byte payLvl) throws ServiceException;
//	
//	
//	/**
//	 * ��ѯ�����Ϣ
//	 * @param gsid ����ֵ��Ϸ������ 
//	 * @param openID �û�openID
//	 */
//	public List<i3k.SBean.RoleInfo> queryRoleInfo(int gsid, String openID) throws ServiceException;
//	
//
//	/**
//	 * ���Ž�ɫ����
//	 * @param gsid ����ֵ��Ϸ������ 
//	 * @param openID �û�openID
//	 */
//	public int updateRoleItem(int gsid, int roleid, short type, short id, int count, String order) throws ServiceException;
}
