package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.EmpCareer;
import cn.mldn.util.dao.IDAO;

public interface IEmpCareerDAO extends IDAO<Long,EmpCareer>{
	/**
	 * 根据雇员编号查询所有的职业经历
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public List<EmpCareer> findAllByCareerByEid(String eid) throws SQLException ;
	/**
	 * 根据数据字典类型查询所有的数据字典信息
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public List<Dictionary> findAllByType(String type) throws SQLException ;
}
