package xzx.project.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 6621708557409749822L;

	private Integer page = 1;// ��ʾ��ǰҳ����datagrid����Ĳ�����һ�£����ڲ�ѯʱ��ֵ��Ĭ�ϵ�һҳ

	private Integer rows = 10;// ��ҳ����������datagrid����Ĳ�����һ�£����ڲ�ѯʱ��ֵ��Ĭ��10��

	private Integer start;// �ӵڼ�����ʼ����¼���±��0��ʼ����
	
	private T paramEntity;//���ѯ����ʱʹ��
	
	private String keyWord;//�����ؼ��ֲ�ѯ

	private Integer total;// ������

	private List<T> lists;// ҳ�����ݼ�
	//datagrid���Զ�����ҳ�������Բ��ö�����ҳ��,��������ҳ�����ݼ����������ﶨ��Map���д�ţ�����ҳ��ʱֱ�Ӹ�map����
	
	private Map<String, Object> pageMap = new HashMap<String, Object>() ;
	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return (page-1)*rows;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public T getParamEntity() {
		return paramEntity;
	}

	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		pageMap.put("total", total);
		this.total = total;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		pageMap.put("rows", lists);
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", start=" + start + ", paramEntity=" + paramEntity
				+ ", keyWord=" + keyWord + ", total=" + total + ", lists=" + lists + "]";
	}
	
}
