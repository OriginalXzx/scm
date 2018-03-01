package xzx.project.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzx.project.base.action.BaseAction;
import xzx.project.entity.Page;
import xzx.project.entity.Supplier;
import xzx.project.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction {
     @Resource
	private SupplierService supplierService;
     
   //ͨ���ؼ��ַ�ҳ��ѯ
 	@RequestMapping("/selectPageUseDyc")
 	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
 	public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
 		
 		page.setParamEntity(supplier);
 		System.out.println("----page:"+page);

 		Page p = supplierService.selectPageUseDyc(page);
 		System.out.println("map:"+p.getPageMap());
 		//supplier.setSupName("supName1");
 		/*Map<String, Object> map =new HashMap<String, Object>();
 		map.put("total",p.getTotalRecord());
 		map.put("rows",p.getList());*/
 		return p.getPageMap();
 	}
 	
 	//ͨ���ؼ��ַ�ҳ��ѯ
 	/*	@RequestMapping("/selectPage")
 		@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
 		public Object selectPage(Page<Supplier> page,HttpServletRequest request){
 			String pageIndex=request.getParameter("page");
 			String pageSize =  request.getParameter("rows");
 			String keyWord =  request.getParameter("keyWord");
 			System.out.println("---doAjax.page||rows||keyWord:"+pageIndex+","+pageSize+","+keyWord);

 			Page<Supplier> page = new Page<Supplier>();
 			page.setPageIndex(Integer.parseInt(pageIndex));
 			page.setPageSize(Integer.parseInt(pageSize));
 			page.setKeyWord(keyWord);
 			Page p = supplierService.selectPage(page);
 			System.out.println("----page:"+page);
 			//supplier.setSupName("supName1");
 			Map<String, Object> map =new HashMap<String, Object>();
 			map.put("total",page.getTotalRecord());
 			map.put("rows",page.getList());
 			return map;
 		}*/
 	/**
 	 * ɾ��
 	 * @param pks
 	 * @return
 	 */
 	@RequestMapping("/deleteByPks")
 	@ResponseBody
 	public Object deleteByPks(String[] pks){
 		System.out.println("---deleteByPks.pks:" + pks);
		int i = 0;
		try {
			i = supplierService.deleteByPks(pks);
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
 	public Object insert(Supplier supplier){
 		System.out.println(supplier);
 		int i = 0;
 		try {
			i = supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println("�ɹ�����"+i);
 		return i;
 	}
 	
 	/**
 	 * �޸Ĺ��ܵ�ʵ��
 	 */
 	@RequestMapping("/update")
 	@ResponseBody
 	public Object update(Supplier supplier){
 		System.out.println(supplier);
 		int i = 0;
 		try {
			i = supplierService.updateByPk(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println("�޸ĳɹ�����"+i);
 		return i;
 	}
 	
}










