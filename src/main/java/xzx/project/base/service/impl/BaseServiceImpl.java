package xzx.project.base.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;


import org.springframework.beans.factory.annotation.Autowired;

import xzx.project.base.dao.BaseMapper;
import xzx.project.base.service.BaseService;
import xzx.project.dao.AccountMapper;
import xzx.project.dao.AccountRecordsMapper;
import xzx.project.dao.BuyOrderDetailMapper;
import xzx.project.dao.BuyOrderMapper;
import xzx.project.dao.GoodsMapper;
import xzx.project.dao.ReturnOrderDetailMapper;
import xzx.project.dao.ReturnOrderMapper;
import xzx.project.dao.StoreHouseMapper;
import xzx.project.dao.SupplierMapper;
import xzx.project.dao.SysParamMapper;
import xzx.project.entity.Page;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	protected SupplierMapper supplierMapper;
	
	@Autowired
	protected  AccountMapper accountMapper;
	
	@Autowired
	protected  GoodsMapper goodsMapper;
	
	@Autowired
	protected  StoreHouseMapper storeHouseMapper;
	
	@Autowired
	protected BuyOrderMapper buyOrderMapper;
	
	@Autowired
	protected ReturnOrderMapper returnOrderMapper;
	
	@Autowired
	protected  BuyOrderDetailMapper buyOrderDetailMapper;
	
	@Autowired
	protected  ReturnOrderDetailMapper returnOrderDetailMapper;
	
	@Autowired
	protected  AccountRecordsMapper accountRecordsMapper;
	
	@Autowired
	protected SysParamMapper sysParamMapper;
	
	protected BaseMapper<T> baseMapper;
	
	@PostConstruct//�ڹ��췽���󣬳���ǰִ��
	private void initBaseMapper() throws Exception{
		//��������߼�����Ҫ���з��������������ʹ�ù淶
				//this�ؼ���ָ����������ָ���ǵ��ô˷�����ʵ���ࣨ���ࣩ
				System.out.println("=======this :"+this);
				System.out.println("=======���������Ϣ��"+this.getClass().getSuperclass());
				System.out.println("=======����ͷ��͵���Ϣ��"+this.getClass().getGenericSuperclass());
				
				ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
				//��ȡ��һ��������class
				Class clazz = (Class)type.getActualTypeArguments()[0];
				System.out.println("=======class:"+clazz);
				//ת��Ϊ����������ص�Mapper�������������Supplier  supplierMapper
				String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
				System.out.println("=======localField:"+localField);
				//getDeclaredField:����ʹ���ڰ���˽�С�Ĭ�ϡ��ܱ����������ֶΣ����������̳е��ֶ�
				Field field=this.getClass().getSuperclass().getDeclaredField(localField);
				System.out.println("=======field:"+field);
				System.out.println("=======field��Ӧ�Ķ���:"+field.get(this));
				Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
				
				System.out.println("=======baseField:"+baseField);
				System.out.println("=======baseField��Ӧ�Ķ���:"+baseField.get(this));	
				//field.get(this)��ȡ��ǰthis��field�ֶε�ֵ�����磺Supplier�����У�baseMapper��ָ��Ķ���Ϊ��������SupplierMapper���������Ͷ����ѱ�springʵ������������		
				baseField.set(this, field.get(this));		
				System.out.println("========baseField��Ӧ�Ķ���:"+baseMapper);

	}	

	public int insert(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.insert(entity);
	}

	public T selectByPk(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.selectByPk(entity);
	}

	public int deleteByPk(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.deleteByPk(entity);
	}

	public int updateByPk(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.updateByPk(entity);
	}

	public List<T> selectUseDyc(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.selectUseDyc(entity);
	}

	public Page<T> selectPageUseDyc(Page<T> page) {
		page.setLists(baseMapper.selectPageListUseDyc(page));
		page.setTotal(baseMapper.selectPageCountUseDyc(page));
		return page;
	}

	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return baseMapper.deleteByPks(pks);
	}
	
}