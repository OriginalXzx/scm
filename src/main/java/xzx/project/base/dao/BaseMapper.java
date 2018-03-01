package xzx.project.base.dao;

import java.util.List;

import xzx.project.entity.Page;

public interface BaseMapper<T> {
	// ���ʵ�������Ϣ����
	int insert(T entity);

	// ���ݶ���������ѯ
	T selectByPk(T entity);

	// ���ݶ�������ɾ��
	int deleteByPk(T entity);

	// ���ݶ��������޸�
	int updateByPk(T entity);

	// ���ݶ���̬����SQL���
	List<T> selectUseDyc(T entity);
	
	//ͨ���ؼ��ַ�ҳ��ѯ�����б�
	public List<T> selectPageListUseDyc(Page<T> page);
			
	//ͨ���ؼ��ַ�ҳ��ѯ�������ܼ�¼��
	public Integer selectPageCountUseDyc(Page<T> page);
	
	//ͨ��id����ɾ������
	public int deleteByPks(String[] pks);

}
