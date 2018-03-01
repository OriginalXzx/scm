package xzx.project.base.service;

import java.util.List;

import xzx.project.entity.Page;

public interface BaseService<T> {
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
	
	//ͨ����������ҳ��ѯ
	public Page<T> selectPageUseDyc(Page<T> page);
	
	//ͨ��id����ɾ������
	public int deleteByPks(String[] pks);
}
