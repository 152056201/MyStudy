package cn.mldb.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface IService<K,V> {
	/**
	 * ʵ�ֹ�Ա�������Ӳ��������β���Ҫ����IEmpDAO�ӿ�<br>
	 * <li>��Ҫ����IEmpDAO.findById()�������ж�����ID�������Ƿ����
	 * <li>���Ҫ���ӵ����ݱ�Ų����������IEmpDAO.doCreate()���������ز������
	 * @param vo ������Ҫ�������ݵ�VO����
	 * @return �����������ID���ڻ򱣴�ʧ���򷵻�false ����֮����true
	 * @throws Exception
	 */
	public boolean insert(V vo)throws Exception;
	/**
	 * ʵ�ֹ�Ա�����޸Ĳ���������IEmpDAO.doUpdate()�����������޸�����ȫ�����ݵ��޸�
	 * @param vo �����޸����ݵ�VOV����
	 * @return
	 * @throws Exception
	 */
	public boolean update(V vo)throws Exception;
	
	/**
	 * ��Աɾ��������ɾ�������Ա��Ϣ��������IEmpDAO.doRemove()����
	 * @param ids ������ɾ��ȫ�����ݵļ��ϣ�û���ظ�����
	 * @return 
	 * @throws Exception
	 */
	public boolean delete(Set<K> ids)throws Exception;
	/**
	 * ���ݹ�Ա��Ų��ҹ�Ա������Ϣ������IEempDAO.findById()
	 * @param ids Ҫ��ѯ�Ĺ�Ա���
	 * @return �����Ա��Ϣ��������VO����ʽ���ع�Ա��Ϣ����������� ����null	
	 * @throws Exception
	 */
	public V get(Integer ids)throws Exception;
	/**
	 * ��ѯȫ����Ա��Ϣ������IEmpDAO.findAll()
	 * @return ��ѯ�����list���� ���û�������򼯺ϳ���Ϊ0
	 * @throws Exception
	 */
	public List<V> list() throws Exception;
	/**
	 * ʵ������ģ����ѯ������ͳ�ƣ�����IEmpDAO��������<br>
	 * <li>��һ������IEmpDAO.findAllSplit()��������ѯ���������ݣ�����List<Emp>;
	 * <li>�ڶ�������IEmpDAO.getAllCount()��������ѯ����������������Integer��
	 * @param currentpage 
	 * @param linesize
	 * @param colum
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> list(int currentpage,int linesize,String colum,String keyword) throws Exception;

}
