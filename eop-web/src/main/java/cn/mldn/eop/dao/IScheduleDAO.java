package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanSchedule;

public interface IScheduleDAO {
	/**
	 * 通过用户id获取相应 的任务数据
	 * @param eid
	 * @return
	 * @throws SQLException
	 */
	public List<PlanSchedule> findPlanScheduleByEmp(String eid)throws SQLException;
	
	/**
	 * 模糊查询当前用户下的数据
	 * @param currentPage
	 * @param lineSize
	 * @param column
	 * @param keyWord
	 * @return
	 * @throws SQLException
	 */
	public List<PlanSchedule> findSplit(Long currentPage, Integer lineSize, String column, String keyWord,String eid) throws SQLException ;
	
	/**
	 * 全部数据分页查询
	 * @param currentPage
	 * @param lineSize
	 * @param eid
	 * @return
	 * @throws Exception
	 */
	public List<PlanSchedule> findSplit(long currentPage, int lineSize,String eid)throws Exception;
}
