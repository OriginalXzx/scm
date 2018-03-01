package xzx.project.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzx.project.base.action.BaseAction;
import xzx.project.entity.Page;
import xzx.project.entity.StoreHouse;
import xzx.project.entity.Supplier;
import xzx.project.service.StoreHouseService;

@Controller
@RequestMapping("/storeHouse")

public class StoreHouseAction extends BaseAction {
     
	@Resource
	private StoreHouseService storeHouseService;
	
	
	//ͨ���ؼ��ַ�ҳ��ѯ
 	@RequestMapping("/selectPageUseDyc")
 	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
 	public Object selectPageUseDyc(Page<StoreHouse> page,StoreHouse storeHouse){
 		
 		page.setParamEntity(storeHouse);
 		System.out.println("----page:"+page);

 		Page p = storeHouseService.selectPageUseDyc(page);
 		System.out.println("map:"+p.getPageMap());
 		//supplier.setSupName("supName1");
 		/*Map<String, Object> map =new HashMap<String, Object>();
 		map.put("total",p.getTotalRecord());
 		map.put("rows",p.getList());*/
 		return p.getPageMap();
 	}
 	
 	/**
 	 * ɾ������
 	 * @param pks
 	 * @return
 	 */
 	@RequestMapping("/deleteByPks")
 	@ResponseBody
 	public Object deleteByPks(String[] pks){
 		System.out.println("---deleteByPks.pks:" + pks);
		int i = 0;
		try {
			i = storeHouseService.deleteByPks(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return i;
 	}
 	
 	/**
 	 * �������ܵ�ʵ��
 	 */
 	@RequestMapping("/insert")
 	@ResponseBody
 	public Object insert(StoreHouse storeHouse){
 		System.out.println(storeHouse);
 		int i = 0;
 		try {
			i = storeHouseService.insert(storeHouse);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println("�ֿ���ӳɹ�����"+i);
 		return i;
 	}
 	/**
 	 * �޸Ĺ��ܵ�ʵ��
 	 */
 	@RequestMapping("/update")
 	@ResponseBody
 	public Object update(StoreHouse storeHouse){
 		System.out.println(storeHouse);
 		int i = 0;
 		try {
			i = storeHouseService.updateByPk(storeHouse);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println("�޸ĳɹ�����"+i);
 		return i;
 	}
}
