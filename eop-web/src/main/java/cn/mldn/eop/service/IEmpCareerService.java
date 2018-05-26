package cn.mldn.eop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.vo.EmpCareer;
import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.util.service.IBaseService;

public interface IEmpCareerService extends IBaseService<EmpCareer>{
	/**
	 * 根据雇员编号查询所有的职业经历
	 * @param eid
	 * @return
	 * @throws Exception
	 */
	public List<EmpCareer> findAllByCareerByEid(String eid) throws Exception ;
	/**
	 * 根据数据字典类型查询所有的数据字典信息
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findAllByType() throws Exception ;
	/**
	 * 根据职业经历编号查询详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EmpCareer findByEcarid(Long id) throws Exception ;
	/**
	 * 删除职业经历信息
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCareer(Set<Long> ids) throws Exception ;
}
