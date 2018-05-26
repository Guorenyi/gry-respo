package cn.mldn.eop.dao;

import java.util.List;

import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.util.dao.IDAO;

public interface IEmpEducationDAO extends IDAO<Long, EmpEducation>{
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
	public List<Dictionary> findByDicType(String type) throws Exception ;
}
