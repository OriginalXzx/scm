package xzx.project.dao;


import java.util.List;

import xzx.project.base.dao.BaseMapper;
import xzx.project.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {
    
	//�������
	public Integer insertList(List<BuyOrderDetail> buyOrderDetails);
}