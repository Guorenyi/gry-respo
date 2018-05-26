package cn.mldn.eop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.util.service.IBaseService;

public interface IEmpEducationService extends IBaseService<EmpEducation> {
	/**
	 * 根据雇员编号查询该雇员所有教育背景
	 * @param eid 雇员编号
	 * @return 
	 * @throws Exception
	 */
	public List<EmpEducation> findAllByEid(String eid) throws Exception ;
	/**
	 * 更具数据字典表中的指定类型查询详细信息
	 * @param type 类型
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findAllByDicType() throws Exception ;
	/**
	 * 根据教育背景编号查询详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EmpEducation findByEeduid(Long id) throws Exception ;
	/**
	 * 删除教育背景信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteEdu(Set<Long> ids) throws Exception ;
}
