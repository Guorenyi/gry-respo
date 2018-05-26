package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IEmpEducationDAO;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class EmpEducationDAOImpl extends AbstractDAO implements IEmpEducationDAO{

	@Override
	public boolean doCreate(EmpEducation vo) throws SQLException {
		String sql = "insert into emp_education(eid,school,degree,major,entrance,graduation,note) "
				+ " values(?,?,?,?,?,?,?)" ;
		prepareStatement(sql) ;
		pstmt.setString(1, vo.getEid());
		pstmt.setString(2, vo.getSchool());
		pstmt.setString(3, vo.getDegree());
		pstmt.setString(4, vo.getMajor());
		pstmt.setDate(5, new java.sql.Date(vo.getEntrance().getTime()));
		pstmt.setDate(6, new java.sql.Date(vo.getGraduation().getTime()));
		pstmt.setString(7, vo.getNote());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(EmpEducation vo) throws SQLException {
		String sql = "update emp_education set eid=?,school=?,degree=?,major=?,entrance=?,graduation=?,note=? where eeduid=?" ;
		prepareStatement(sql) ;
		pstmt.setString(1, vo.getEid());
		pstmt.setString(2, vo.getSchool());
		pstmt.setString(3, vo.getDegree());
		pstmt.setString(4, vo.getMajor());
		pstmt.setDate(5, new java.sql.Date(vo.getEntrance().getTime()));
		pstmt.setDate(6, new java.sql.Date(vo.getGraduation().getTime()));
		pstmt.setString(7, vo.getNote());
		pstmt.setLong(8, vo.getEeduid());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		return super.doRemoveHandleByLong("emp_education", "eeduid", ids);
	}

	@Override
	public EmpEducation findById(Long id) throws SQLException {
		String sql = "select eid,school,degree,major,entrance,graduation,note from emp_education where eeduid=?"  ;
		prepareStatement(sql) ;
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			EmpEducation vo = new EmpEducation() ;
			vo.setEid(rs.getString(1));
			vo.setSchool(rs.getString(2));
			vo.setDegree(rs.getString(3));
			vo.setMajor(rs.getString(4));
			vo.setEntrance(rs.getDate(5));
			vo.setGraduation(rs.getDate(6));
			vo.setNote(rs.getString(7));
			return vo ;
		}
		return null;
	}

	@Override
	public List<EmpEducation> findAll() throws SQLException {
		return null ;
	}

	@Override
	public List<EmpEducation> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpEducation> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public List<EmpEducation> findAllByEid(String eid) throws Exception {
		List<EmpEducation> all = new ArrayList<EmpEducation>() ;
		String sql = "select eid,school,degree,major,entrance,graduation,note,eeduid from emp_education where eid=?"  ;
		prepareStatement(sql) ;
		pstmt.setString(1, eid);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			EmpEducation vo = new EmpEducation() ;
			vo.setEid(rs.getString(1));
			vo.setSchool(rs.getString(2));
			vo.setDegree(rs.getString(3));
			vo.setMajor(rs.getString(4));
			vo.setEntrance(rs.getDate(5));
			vo.setGraduation(rs.getDate(6));
			vo.setNote(rs.getString(7));
			vo.setEeduid(rs.getLong(8));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Dictionary> findByDicType(String type) throws Exception {
		List<Dictionary> all = new ArrayList<Dictionary>() ;
		String sql = "select title,value from dictionary where type=?" ;
		prepareStatement(sql) ;
		pstmt.setString(1, type);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dictionary dic = new Dictionary() ;
			dic.setTitle(rs.getString(1));
			dic.setValue(rs.getString(2));
			all.add(dic) ;
		}
		return all;
	}

}
