package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IEmpCareerDAO;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.EmpCareer;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class EmpCareerDAOImpl extends AbstractDAO<EmpCareer> implements IEmpCareerDAO {

	@Override
	public boolean doCreate(EmpCareer vo) throws SQLException {
		String sql = "insert into emp_career(eid,company,position,salary,entry,quit,reason,note) values(?,?,?,?,?,?,?,?)" ;
		prepareStatement(sql);
		pstmt.setString(1, vo.getEid());
		pstmt.setString(2,vo.getCompany());
		pstmt.setString(3, vo.getPosition());
		pstmt.setDouble(4, vo.getSalary());
		pstmt.setDate(5, new java.sql.Date(vo.getEntry().getTime()));
		pstmt.setDate(6, new java.sql.Date(vo.getQuit().getTime()));
		pstmt.setString(7, vo.getReason());
		pstmt.setString(8, vo.getNote());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(EmpCareer vo) throws SQLException {
		String sql = "update emp_career set eid=?,company=?,position=?,salary=?,entry=?,quit=?,reason=?,note=? where ecarid=?" ;
		prepareStatement(sql);
		pstmt.setString(1, vo.getEid());
		pstmt.setString(2,vo.getCompany());
		pstmt.setString(3, vo.getPosition());
		pstmt.setDouble(4, vo.getSalary());
		pstmt.setDate(5, new java.sql.Date(vo.getEntry().getTime()));
		pstmt.setDate(6, new java.sql.Date(vo.getQuit().getTime()));
		pstmt.setString(7, vo.getReason());
		pstmt.setString(8, vo.getNote());
		pstmt.setLong(9, vo.getEcarid());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		return super.doRemoveHandleByLong("emp_career", "ecarid", ids);
	}

	@Override
	public EmpCareer findById(Long id) throws SQLException {
		String sql = "select eid,company,position,salary,entry,quit,reason,note,ecarid from emp_career where ecarid=?" ;
		prepareStatement(sql) ;
		pstmt.setLong(1,id);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			EmpCareer vo = new EmpCareer() ;
			vo.setEid(rs.getString(1));
			vo.setCompany(rs.getString(2));
			vo.setPosition(rs.getString(3));
			vo.setSalary(rs.getDouble(4));
			vo.setEntry(rs.getDate(5));
			vo.setQuit(rs.getDate(6));
			vo.setReason(rs.getString(7));
			vo.setNote(rs.getString(8));
			vo.setEcarid(rs.getLong(9));
			return vo ;
		}
		return null;
	}

	@Override
	public List<EmpCareer> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpCareer> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpCareer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpCareer> findAllByCareerByEid(String eid) throws SQLException {
		List<EmpCareer> all = new ArrayList<EmpCareer>() ;
		String sql = "select eid,company,position,salary,entry,quit,reason,note,ecarid from emp_career where eid=?" ;
		prepareStatement(sql) ;
		pstmt.setString(1, eid);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			EmpCareer vo = new EmpCareer() ;
			vo.setEid(rs.getString(1));
			vo.setCompany(rs.getString(2));
			vo.setPosition(rs.getString(3));
			vo.setSalary(rs.getDouble(4));
			vo.setEntry(rs.getDate(5));
			vo.setQuit(rs.getDate(6));
			vo.setReason(rs.getString(7));
			vo.setNote(rs.getString(8));
			vo.setEcarid(rs.getLong(9));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Dictionary> findAllByType(String type) throws SQLException {
		List<Dictionary> all = new ArrayList<Dictionary>() ;
		String sql = "select title,value from dictionary where type=?" ;
		prepareStatement(sql) ;
		pstmt.setString(1, type);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dictionary vo = new Dictionary() ;
			vo.setTitle(rs.getString(1));
			vo.setValue(rs.getString(2));
			all.add(vo) ;
		}
		return all;
	}

}
