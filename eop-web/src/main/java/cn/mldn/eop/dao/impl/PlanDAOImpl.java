package cn.mldn.eop.dao.impl;

import java.awt.datatransfer.StringSelection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IPlanDAO;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class PlanDAOImpl extends AbstractDAO<Plan> implements IPlanDAO {
	
	@Override
	public Boolean doEditCount(Integer i,Long pid) throws SQLException {
		String sql = "update plan set amount=amount+ " + i + " where pid=?" ;
		prepareStatement(sql);
		super.pstmt.setLong(1, pid);
		int flag = super.pstmt.executeUpdate();
		return flag >0;
	}
	@Override
	public List<PlanDetails> findAllEmpByPlan(Long pid) throws SQLException {
		String sql = "select pid,eid from plan_details where pid=?";
		prepareStatement(sql);
		super.pstmt.setLong(1, pid);
		ResultSet rs = super.pstmt.executeQuery();
		List<PlanDetails> all = new ArrayList<>();
		while (rs.next()) {
			PlanDetails vo = new PlanDetails();
			vo.setPid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			all.add(vo);
		}
		return all;
	}
	
	
	@Override
	public EmpLevel getEmpLevelDept(String eid) throws SQLException {
		//String sql = "select e.eid,e.photo,e.ename,e.did, le.title,d.dname,e.phone,pd.pid from emp e,(select lid,title from level)le,dept d,plan_details pd where le.lid=e.lid and e.did=d.did and e.eid=? and pd.eid=e.eid";
		String sql = "select e.eid,e.photo,e.ename,e.did, le.title,d.dname,e.phone,pd.pid,e.hiredate,e.salary,e.note from emp e,(select lid,title from level)le,dept d,plan_details pd where le.lid=e.lid and e.did=d.did and e.eid=? and pd.eid=e.eid and e.status=0";
		prepareStatement(sql);
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			EmpLevel vo = new EmpLevel();
			vo.setEid(rs.getString(1));
			vo.setPhoto(rs.getString(2));
			vo.setEname(rs.getString(3));
			vo.setDid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setDname(rs.getString(6));
			vo.setPhone(rs.getString(7));
			vo.setPid(rs.getLong(8));
			vo.setHiredate(rs.getDate(9));
			vo.setSalary(rs.getDouble(10));
			vo.setNote(rs.getString(11));
			return vo;
		}
		
		return null;
	}
	
	@Override
	public List<EmpLevel> findAllEmpLevel() throws SQLException {
		String sql = "select e.eid,e.photo,e.ename,e.did, le.title,d.dname from emp e,(select lid,title from level)le,dept d where le.lid=e.lid and e.did=d.did";
		prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		List<EmpLevel> all = new ArrayList<>();
		while (rs.next()) {
			EmpLevel vo = new EmpLevel();
			vo.setEid(rs.getString(1));;
			vo.setPhoto(rs.getString(2));
			vo.setEname(rs.getString(3));
			vo.setDid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setDname(rs.getString(6));
			all.add(vo);
		}
		return all;
	}
	
	@Override
	public List<EmpLevel> findAllEmpAndLevelByDept(Long did) throws SQLException {
		//String sql = "select e.eid,e.photo,e.ename,e.did, le.title from emp e,(select lid,title from level)le where le.lid=e.lid and e.did=? ";
		String sql = "select e.eid,e.photo,e.ename,e.did, le.title,d.dname from emp e,(select lid,title from level)le,dept d where le.lid=e.lid and e.did=? and e.did=d.did";
		prepareStatement(sql);
		super.pstmt.setLong(1, did);
		ResultSet rs = super.pstmt.executeQuery();
		List<EmpLevel> all = new ArrayList<>();
		while (rs.next()) {
			EmpLevel vo = new EmpLevel();
			vo.setEid(rs.getString(1));;
			vo.setPhoto(rs.getString(2));
			vo.setEname(rs.getString(3));
			vo.setDid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setDname(rs.getString(6));
			all.add(vo);
		}
		return all;
	}
	@Override
	public List<EmpLevel> findAllEmpAndLevel() throws SQLException {
		//String sql = "select e.eid,e.photo,e.ename,e.did, le.title,pd.pid from emp e,(select lid,title from level)le,plan_details pd where le.lid=e.lid and e.eid=pd.eid";
		String sql = "select e.eid,e.photo,e.ename,e.did, le.title from emp e,(select lid,title from level)le where le.lid=e.lid and e.status=0";
		
		prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		List<EmpLevel> all = new ArrayList<>();
		while (rs.next()) {
			EmpLevel vo = new EmpLevel();
			vo.setEid(rs.getString(1));;
			vo.setPhoto(rs.getString(2));
			vo.setEname(rs.getString(3));
			vo.setDid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			
			all.add(vo);
		}
		return all;
	}
	@Override
	public List<Emp> findSplitByDept(Long did, Long currentPage, Integer lineSize) throws SQLException {
		String sql = "select eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid from emp " + 
				" where emp.did in (select did from dept where did=?) ";
		prepareStatement(sql);
		super.pstmt.setLong(1, did);
		ResultSet rs = super.pstmt.executeQuery();
		List<Emp> all = new ArrayList<>();
		while (rs.next()) {
			Emp vo = new Emp();
			vo.setEid(rs.getString(1));
			vo.setLid(rs.getInt(2));
			vo.setDid(rs.getLong(3));
			vo.setEname(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setPhone(rs.getString(6));
			vo.setPhoto(rs.getString(7));
			vo.setNote(rs.getString(8));
			vo.setHiredate(new java.util.Date(rs.getDate(9).getTime()));
			vo.setIneid(rs.getString(10));
			vo.setStatus(rs.getInt(11));
			all.add(vo);
		}
		return all;
	}
	@Override
	public Boolean doEditStatus(Long pid,Integer i) throws SQLException {
		String sql =" update plan set status=? where pid=?";
		prepareStatement(sql);
		super.pstmt.setInt(1, i);
		super.pstmt.setLong(2, pid);
		int flag = super.pstmt.executeUpdate();
		return flag>0;
	}
	
	@Override
	public List<Dictionary> findAllByPlan(String type) throws SQLException {
		String sql = "select dctid,type,title,value from dictionary where type=?";
		prepareStatement(sql);
		super.pstmt.setString(1, type);
		ResultSet rs = super.pstmt.executeQuery();
		List<Dictionary> all = new ArrayList<>();
		while (rs.next()) {
			Dictionary vo = new Dictionary();
			vo.setDctid(rs.getLong(1));
			vo.setType(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setValue(rs.getString(4));
			all.add(vo);
		}
		return all;
	}
	@Override
	public boolean doCreate(Plan vo) throws SQLException {
//		return super.doCreate(vo, Plan.class);
//	}
		String sql = "insert into plan(title,item,starttime,endtime,note,status,amount) values(?,?,?,?,?,?,?)";
		//System.out.println(sql);
		prepareStatement(sql);
		super.pstmt.setString(1, vo.getTitle());
		super.pstmt.setString(2, vo.getItem());
		super.pstmt.setDate(3, new java.sql.Date(vo.getStarttime().getTime()));
		super.pstmt.setDate(4, new java.sql.Date(vo.getEndtime().getTime()));
		super.pstmt.setString(5, vo.getNote());
		super.pstmt.setInt(6, vo.getStatus());
		super.pstmt.setInt(7, vo.getAmount());
		int i = super.pstmt.executeUpdate();
		return i>0;
	}

	@Override
	public boolean doEdit(Plan vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from plan where pid in( ");
		for (Long id : ids) {
			sql.append(id).append(",");
		}
		sql.delete(sql.length()-1, sql.length());
		sql.append(")");
		prepareStatement(sql.toString());
		int i = super.pstmt.executeUpdate();
		return i==ids.size();
	}

	@Override
	public Plan findById(Long id) throws SQLException {
		String sql = "select pid,title,item,starttime,endtime,note,status,amount from plan where pid=?";
		prepareStatement(sql);
		super.pstmt.setLong(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Plan vo = new Plan();
			vo.setPid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setItem(rs.getString(3));
			vo.setStarttime(rs.getDate(4));
			vo.setEndtime(rs.getDate(5));
			vo.setNote(rs.getString(6));
			vo.setStatus(rs.getInt(7));
			vo.setAmount(rs.getInt(8));
			return vo;
		}
		return null;
	}

	@Override
	public List<Plan> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plan> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		List<Plan> all = new ArrayList<Plan>();
		String sql = "select pid,title,item,starttime,endtime,note,status,amount from plan limit ?,?";
		prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage - 1) * lineSize);
		super.pstmt.setLong(2, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Plan vo = new Plan();
			vo.setPid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setItem(rs.getString(3));
			vo.setStarttime(rs.getDate(4));
			vo.setEndtime(rs.getDate(5));
			vo.setNote(rs.getString(6));
			vo.setStatus(rs.getInt(7));
			vo.setAmount(rs.getInt(8));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Plan> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		List<Plan> all = new ArrayList<Plan>();
		String sql = "select pid,title,item,starttime,endtime,note,status,amount " + 
				" from plan where "+ column + " like ?  limit ?,?";
		prepareStatement(sql);
		super.pstmt.setString(1, "%"+ keyWord+"%");
		super.pstmt.setLong(2, (currentPage - 1) * lineSize);
		super.pstmt.setLong(3, lineSize);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Plan vo = new Plan();
			vo.setPid(rs.getLong(1));
			vo.setTitle(rs.getString(2));
			vo.setItem(rs.getString(3));
			vo.setStarttime(rs.getDate(4));
			vo.setEndtime(rs.getDate(5));
			vo.setNote(rs.getString(6));
			vo.setStatus(rs.getInt(7));
			vo.setAmount(rs.getInt(8));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql = "select count(*) from plan" ;
		prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		String sql = "select count(*) from plan where "+ column +" like ?" ;
		prepareStatement(sql);
		super.pstmt.setString(1, "%"+keyWord +"%");
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

}
