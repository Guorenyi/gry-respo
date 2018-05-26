package cn.mldn.eop.service;

import java.util.List;
import java.util.Map;

import cn.mldn.eop.vo.Empresource;
import cn.mldn.util.service.IBaseService;

public interface IEmpresourceService extends IBaseService<Empresource> {
	public boolean add(Empresource empres) throws Exception;
	public Map<String,Object> findSplit(Long currentPage, Integer lineSize,String eid) throws Exception;
	/**
	 * 查找所有提交状态的申请单列表
	 * @return 申请单列表
	 * @throws Exception
	 */
	public List<Empresource> findSubmitResourceApplyList() throws Exception;


}
