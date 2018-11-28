package cn.mldb.dao;

import java.util.List;
import java.util.Set;


/**
 * ���幫���ӿ�
 * @author Mr.Y
 *
 * @param <K>��ʾҪ�������������ͣ����ӽӿ�ʵ��
 * @param <V>��ʾҪ������VO�ӿڣ����ӽӿ�ʵ��
 */
public interface IDAO<K,V> {
	/**
	 * ʵ���������Ӳ���
	 * @param vo �������������ӵ�VO����
	 * @return ����ɹ�����true, ʧ�ܱ���false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doCreate(V vo) throws Exception;
	/**
	 * ʵ�������޸Ĳ����������޸ĸ���ID����ȫ���ֶ������޸�
	 * @param vo Ҫ�޸����ݵ���Ϣ��һ���ṩ��ID��Ϣ
	 * @return �޸ĳɹ�����true, ʧ�ܱ���false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doUpdate(V vo) throws Exception;
	/**
	 * ִ�����ݵ�����ɾ��������Ҫɾ����������Set���ϵĵ���ʽ����
	 * @param ids ��������Ҫɾ�����ݵ�ID���������ظ�����
	 * @return ɾ���ɹ�����true��ɾ�������ݸ�����Ҫɾ�������ݸ�����ͬ��, ʧ�ܱ���false
	 * @throws Exception SQLִ���쳣
	 */
	public boolean doRemove(Set<K> ids) throws Exception;
	/**
	 * ���ݹ�Աidȥ��ѯ��Ա��Ϣ
	 * @param id Ҫ��ѯ�Ĺ�Ա���
	 * @return �����Ա��Ϣ��������VO����ʽ���ع�Ա��Ϣ����������� ����null
	 * @throws Exception SQLִ���쳣
	 */
	public V findById(K id) throws Exception;
	/**
	 * ��ѯָ�����ݱ��ȫ�����ݣ����Լ�����ʽ����
	 * @return ������������ݣ����������ݻ��װΪVO������list������ʽ���أ����û������list��������Ϊ0��size()==0������null
	 * @throws Exception SQLִ���쳣
	 */
	public List<V> findAll() throws Exception;
	/**
	 * ��ҳ��������ģ����ѯ����ѯ����Լ�����ʽ����
	 * @param currentpage ��ǰ���ڵ�ҳ
	 * @param linesize ÿҳ���ڵ�����
	 * @param colum ģ����ѯ��������
	 * @param keyword ģ����ѯ�Ĺؼ���
	 * @return ������������ݣ����������ݻ��װΪVO������list������ʽ���أ����û������list��������Ϊ0��size()==0������null
	 * @throws Exception SQLִ���쳣
	 */
	public List<V> findSplit(Integer currentpage,Integer linesize,String colum,String keyword) throws Exception;
	/**
	 * ����ģ����ѯ��������ͳ�ƣ�����û�м�¼����0
	 * @param colum ģ����ѯ��������
	 * @param keyword ģ����ѯ�Ĺؼ���
	 * @return ���ر��е������������û�з���0
	 * @throws Exception SQLִ���쳣
	 */
	public Integer getAllCount(String colum,String keyword) throws Exception;
}
