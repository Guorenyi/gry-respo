package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.dao.IScheduleDAO;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanSchedule;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ScheduleDAOImpl extends AbstractDAO implements IScheduleDAO  {

	@Override
	public List<PlanSchedule> findPlanScheduleByEmp(String eid) throws SQLException {
		String sql = " SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount " + 
				" FROM plan,plan_details " + 
				" WHERE plan.pid=plan_details.pid AND plan_details.eid=? AND plan.status=1 ";
//		super.pstmt =super.conn.prepareStatement(sql);
//		super.pstmt.setString(1, eid);
		prepareStatement(sql);
		pstmt.setString(1, eid);
		ResultSet rs = pstmt.executeQuery();
		List<PlanSchedule> all = new ArrayList<>();
		while (rs.next()) {
			PlanSchedule vo = new PlanSchedule();
			vo.setEid(rs.getString(1));
			vo.setPid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setItem(rs.getString(4));
			vo.setStarttime(rs.getDate(5));
			vo.setEndtime(rs.getDate(6));
			vo.setAmount(rs.getInt(7));
			all.add(vo);
			
		}
		return all;
	}
	
	
	@Override
	public List<PlanSchedule> findSplit(Long currentPage, Integer lineSize, String column, String keyWord, String eid)
			throws SQLException {
		//String sql = " SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount " + 
		//		" FROM plan,plan_details " + 
		//		" WHERE plan.pid=plan_details.pid AND plan_details.eid=? AND plan.status=1  AND"
		//		+ column +" like ? limit ?,? ";
		String sql  ="SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount " + 
				"	FROM plan,plan_details " + 
				"	WHERE plan.pid=plan_details.pid AND plan_details.eid=? AND plan.status=1 AND " + column + 
				"	like ? limit ?,? ";
		System.out.println(sql);
		prepareStatement(sql);
		pstmt.setString(1, eid);
		pstmt.setString(2, "%"+ keyWord+"%");
		pstmt.setLong(3, (currentPage - 1) * lineSize);
		pstmt.setLong(4, lineSize);
		ResultSet rs = pstmt.executeQuery();
		List<PlanSchedule> all = new ArrayList<>();
		while (rs.next()) {
			PlanSchedule vo = new PlanSchedule();
			vo.setEid(rs.getString(1));
			vo.setPid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setItem(rs.getString(4));
			vo.setStarttime(rs.getDate(5));
			vo.setEndtime(rs.getDate(6));
			vo.setAmount(rs.getInt(7));
			all.add(vo);
			
		}
		return all;
	}
	@Override
	public List<PlanSchedule> findSplit(long currentPage, int lineSize, String eid) throws Exception {
		String sql = " SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount " + 
				" FROM plan,plan_details " + 
				" WHERE plan.pid=plan_details.pid AND plan_details.eid=? AND plan.status=1 limit ?,?";

		prepareStatement(sql);
		pstmt.setString(1, eid);
		pstmt.setLong(2, (currentPage - 1) * lineSize);
		pstmt.setLong(3, lineSize);
		ResultSet rs = pstmt.executeQuery();
		List<PlanSchedule> all = new ArrayList<>();
		while (rs.next()) {
			PlanSchedule vo = new PlanSchedule();
			vo.setEid(rs.getString(1));
			vo.setPid(rs.getLong(2));
			vo.setTitle(rs.getString(3));
			vo.setItem(rs.getString(4));
			vo.setStarttime(rs.getDate(5));
			vo.setEndtime(rs.getDate(6));
			vo.setAmount(rs.getInt(7));
			all.add(vo);
			
		}
		return all;
	}
	
	
	/**
	 * 
	SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount 
	FROM plan,plan_details 
	WHERE plan.pid=plan_details.pid AND plan_details.eid='mldn-lisen' AND plan.status=1 
	AND title  like '%测试%' limit 0,1; 



	SELECT plan_details.eid,plan.pid,plan.title,plan.item,plan.starttime,plan.endtime,plan.amount  
	FROM plan,plan_details 
	WHERE plan.pid=plan_details.pid AND plan_details.eid='mldn-lisen' AND plan.status=1 limit 0,2;
	*/
}
