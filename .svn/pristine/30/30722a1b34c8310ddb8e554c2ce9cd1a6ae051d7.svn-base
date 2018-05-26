package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IDeptDAO;
import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Emp;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {
	@Override
	public boolean updateCurrnum(Integer num, String dname) throws SQLException {
		String sql = "update dept set currnum=currnum+" + num + " where dname=?" ;
		prepareStatement(sql); 
		pstmt.setString(1, dname);
		return pstmt.executeUpdate() > 0;
	}
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql = "insert into dept(dname,maxnum,note,eid) values(?,?,?,?)" ;
		prepareStatement(sql) ;
		pstmt.setString(1, vo.getDname());
		pstmt.setInt(2, vo.getMaxnum());
		pstmt.setString(3, vo.getNote());
		pstmt.setString(4, vo.getEid());
		return pstmt.executeUpdate() > 0 ;
//		return super.doCreate(vo, Dept.class) ;
	}

	@Override
	public boolean doEdit(Dept vo) throws SQLException {
		String sql = "update dept set dname=?,note=?,maxnum=? where did=?" ;
		System.out.println("sqlllllll" + vo);
		prepareStatement(sql) ;
		pstmt.setString(1, vo.getDname());
		pstmt.setString(2, vo.getNote());
		pstmt.setInt(3, vo.getMaxnum());
		pstmt.setLong(4, vo.getDid());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dept findById(Long id) throws SQLException {
		String sql = "select did,dname,eid,maxnum,currnum,note from dept where did=?" ;
		prepareStatement(sql) ;
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dept vo = new Dept() ;
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			vo.setNote(rs.getString(6));
			return vo ;
		}
		return null;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "select did,dname,eid,maxnum,currnum,note from dept" ;
		prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dept vo = new Dept() ;
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			vo.setNote(rs.getString(6));
			all.add(vo) ;
		}
		return all ;
//		return super.findAll(Dept.class);
	}

	@Override
	public List<Dept> findSplit(Long currentPage, Integer lineSize) throws SQLException {
//		return super.findSplit(currentPage, lineSize, Dept.class);
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "select did,dname,eid,maxnum,currnum,note from dept limit ?,?" ;
		prepareStatement(sql) ;
		super.pstmt.setLong(1, (currentPage - 1) * lineSize);
		super.pstmt.setInt(2, lineSize);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dept vo = new Dept() ;
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			vo.setNote(rs.getString(6));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public List<Dept> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
//		return super.findSplit(currentPage, lineSize, column, keyWord, Dept.class);
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "select did,dname,eid,maxnum,currnum,note from dept where " + column+ " like ? limit ?,?" ;
		pstmt = conn.prepareStatement(sql) ;
		pstmt.setString(1, "%"+keyWord+"%");
		super.pstmt.setLong(2, (currentPage - 1) * lineSize);
		super.pstmt.setInt(3, lineSize);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dept vo = new Dept() ;
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			vo.setNote(rs.getString(6));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public Long getAllCount() throws SQLException {
//		return super.getAllCountHandle("dept");
		String sql = "SELECT COUNT(*) FROM dept " ;
		this.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
//		return super.getAllCountSplitHandle("dept",column,keyWord);
		String sql = "SELECT COUNT(*) FROM dept WHERE " + column + " LIKE ?";
		this.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Dept findByDname(String dname) throws SQLException {
		String sql = "select did,dname,eid,maxnum,currnum,note from dept where dname=?" ;
		prepareStatement(sql) ;
		pstmt.setString(1, dname);
		ResultSet rs = pstmt.executeQuery() ;
		if(rs.next()) {
			Dept vo = new Dept() ;
			vo.setDid(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setEid(rs.getString(3));
			vo.setMaxnum(rs.getInt(4));
			vo.setCurrnum(rs.getInt(5));
			vo.setNote(rs.getString(6)) ;
			return vo ;
		}
		return null ;
	}
	@Override
	public List<Emp> findByLid() throws SQLException {
		List<Emp> all = new ArrayList<Emp>() ;
		String sql = "select eid,ename from emp where lid=2" ;
		prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Emp vo = new Emp() ;
			vo.setEid(rs.getString(1));
			vo.setEname(rs.getString(2));
			all.add(vo) ;
		}
		return all;
	}

}
