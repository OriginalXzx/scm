package xzx.project.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import xzx.project.base.service.impl.BaseServiceImpl;
import xzx.project.entity.AccountRecords;
import xzx.project.entity.BuyOrder;
import xzx.project.entity.BuyOrderDetail;
import xzx.project.service.BuyOrderService;
@Service("buyOrderService")
public class BuyOrderServiceImpl extends BaseServiceImpl<BuyOrder> implements BuyOrderService {

	public Integer insertBuyOrder(BuyOrder buyOrder) throws Exception {

		int i = 0;
		// ���ɲɹ�����,bo��ʾ�ɹ�ҵ��
		String boId = "bo" + UUID.randomUUID().toString().replace("-", "");
		System.out.println("boIduuid:" + boId);
		// ���òɹ�����
		buyOrder.setBoId(boId);
		// ���òɹ���ϸ��������ɹ��������ֵ
		for (BuyOrderDetail bod : buyOrder.getBuyOrderDetails()) {
			bod.setBodId(UUID.randomUUID().toString().replace("-", ""));
			bod.setBoId(boId);
		}
		i = buyOrderMapper.insert(buyOrder);
		buyOrderDetailMapper.insertList(buyOrder.getBuyOrderDetails());
		AccountRecords accountRecords = new AccountRecords();
		// ���ɲ����������¼������
		accountRecords.setArId(String.valueOf("ar" + UUID.randomUUID().toString().replace("-", "")));
		accountRecords.setArAttn(buyOrder.getBoAttn());
		accountRecords.setArArrears(buyOrder.getBoArrears());
		// bo��ʾ��Ʒ�ɹ��������ڲ������м����������
		accountRecords.setArBusType("bo");
		accountRecords.setArDate(buyOrder.getBoDate());
		// �Żݽ���Ӧ������ȥʵ������ټ�ȥǷ��
		accountRecords.setArDiscount(
				buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
		accountRecords.setArOperator(buyOrder.getBoOperator());
		// �ɹ�����
		accountRecords.setArOrderId(buyOrder.getBoId());
		accountRecords.setArPaid(buyOrder.getBoPaid());
		accountRecords.setArPayable(buyOrder.getBoPayable());
		accountRecords.setArRemark(buyOrder.getBoRemark());
		accountRecords.setSupId(buyOrder.getSupId());
		accountRecordsMapper.insert(accountRecords);

		return i;
	}

}
