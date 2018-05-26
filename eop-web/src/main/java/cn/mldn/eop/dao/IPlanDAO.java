package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.dao.IDAO;;
public interface IPlanDAO extends IDAO<Long, Plan> {
	

	
	/**
	 * 更改任务的人数
	 * @return
	 * @throws SQLException
	 */
	public Boolean doEditCount(Integer i,Long pid)throws SQLException;
	
	/**
	 * 通过eid查询相关的emplevelDept的数据
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public EmpLevel getEmpLevelDept(String eid) throws SQLException;
	
	
	/**
	 * 查询所有的emplevel类数据
	 * @return
	 * @throws SQLException
	 */
	public List<EmpLevel> findAllEmpLevel()throws SQLException;
	/**
	 * 通过任务id获得全部的任务详情表的信息
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public List<PlanDetails> findAllEmpByPlan(Long pid)throws SQLException;
	
	/**
	 * 通过部门id取得所有的人员和等级数据和部门名称
	 * @param did
	 * @return
	 * @throws SQLException
	 */
	public List<EmpLevel> findAllEmpAndLevelByDept(Long did)throws SQLException;
	
	
	/**
	 * 查找所有的雇员和等级
	 * @return
	 * @throws SQLException
	 */
	public List<EmpLevel> findAllEmpAndLevel()throws SQLException;
	/**
	 * 根据type信息查询所有的任务类型数据
	 * @param type 
	 * @return 任务对应的类型数据
	 * @throws SQLException 
	 */
	public List<Dictionary> findAllByPlan(String type) throws SQLException ;
	
	/**
	 * 修改status状态数据
	 * @param i 为修改的status数据
	 * @param pid 为主键的值
	 * @return
	 * @throws SQLException
	 */
	public Boolean doEditStatus(Long pid,Integer i)throws SQLException;
	
	
	/**
	 * 通过部门id获取所有部门下的人员
	 * @param did
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> findSplitByDept(Long did,Long currentPage, Integer lineSize)throws SQLException;
	
	
}
