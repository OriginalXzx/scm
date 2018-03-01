package xzx.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xzx.project.base.service.impl.BaseServiceImpl;
import xzx.project.entity.SysParam;
import xzx.project.service.SysParamService;



@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService {

	public Map<String, Object> selectList() {
		List<SysParam> sysParams = sysParamMapper.selectList("");
		//ϵͳ����map�����ڴ�������ֶ������Ϣ
		Map<String,Object> sysParamMap = new HashMap<String,Object>();
		//���ڴ�������ֶΣ���ֵ
		Map<String,Object> fieldMap = null;
		for(SysParam sysParam:sysParams){
			if("1".equals(sysParam.getSysParamType())){
				//��Ҫִ��sql����ѯ������
				String sql = sysParam.getSysParamValue();
				System.out.println(sql);
				List<SysParam> otherList = sysParamMapper.selectOthreTable(sql);
				fieldMap = new HashMap<String,Object>();
				//�����������ݴ��뵽�ֶ�Map��
				for (SysParam other : otherList) {
					fieldMap.put(other.getSysParamValue(), other.getSysParamText());
				}
				sysParamMap.put(sysParam.getSysParamValue(), fieldMap);
			}else{
				//�Ӵ��ϵͳ������map��ȡ�ֶε�map
				if(sysParamMap.get(sysParam.getSysParamField())==null){
					fieldMap = new HashMap<String, Object>();
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
					sysParamMap.put(sysParam.getSysParamField(), fieldMap);				
				}else{
					fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());					
				}
			}
		}
		
		return sysParamMap;
	}

}
