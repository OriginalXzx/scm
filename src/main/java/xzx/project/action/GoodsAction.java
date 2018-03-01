package xzx.project.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzx.project.base.action.BaseAction;
import xzx.project.entity.Goods;
import xzx.project.entity.Page;
import xzx.project.entity.StoreHouse;
import xzx.project.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
    @Resource 
	private GoodsService goodsService;
    
    //ͨ���ؼ��ַ�ҳ��ѯ
   	@RequestMapping("/selectPageUseDyc")
   	@ResponseBody //�������json��ʽ����Ҫ���ע��
   	public Object selectPageUseDyc(Page<Goods> page,Goods goods){
   		
   		page.setParamEntity(goods);
   		System.out.println("----page:"+page);

   		Page p = goodsService.selectPageUseDyc(page);
   		System.out.println("map:"+p.getPageMap());
   		//supplier.setSupName("supName1");
   		/*Map<String, Object> map =new HashMap<String, Object>();
   		map.put("total",p.getTotalRecord());
   		map.put("rows",p.getList());*/
   		return p.getPageMap();
   	}
   	
   	@RequestMapping("/deleteByPks")
 	@ResponseBody
 	public Object deleteByPks(String[] pks){
 		System.out.println("---deleteByPks.pks:" + pks);
		int i = 0;
		try {
			i = goodsService.deleteByPks(pks);
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
   	public Object insert(Goods goods){
   		System.out.println(goods);
   		int i = 0;
		try {
			i = goodsService.insert(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ʒ��ӳɹ�����"+i);
		return i;
   	} 
   	/**
 	 * �޸Ĺ��ܵ�ʵ��
 	 */
 	@RequestMapping("/update")
 	@ResponseBody
 	public Object update(Goods goods){
 		System.out.println(goods);
 		int i = 0;
 		try {
			i = goodsService.updateByPk(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println("�޸ĳɹ�����"+i);
 		return i;
 	}
}
