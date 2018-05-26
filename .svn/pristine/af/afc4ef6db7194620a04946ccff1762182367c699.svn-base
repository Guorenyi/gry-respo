package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IEmpDAO;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;

@Repository
public class EmpDAOImpl extends AbstractDAO<Emp> implements IEmpDAO {

	@Override
	public boolean doCreate(Emp vo) throws SQLException {
		String sql = "insert into emp(eid,lid,did,ename,salary,phone,password,photo,note,hiredate,ineid,status) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		prepareStatement(sql);
		pstmt.setString(1, vo.getEid());
		pstmt.setInt(2, vo.getLid());
		pstmt.setLong(3, vo.getDid());
		pstmt.setString(4, vo.getEname());
		pstmt.setDouble(5, vo.getSalary());
		pstmt.setString(6, vo.getPhone());
		pstmt.setString(7, vo.getPassword());
		pstmt.setString(8, vo.getPhoto());
		pstmt.setString(9, vo.getNote());
		pstmt.setDate(10, new java.sql.Date(vo.getHiredate().getTime()));
		pstmt.setString(11, vo.getIneid());
		pstmt.setInt(12, vo.getStatus());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(Emp vo) throws SQLException {
		String sql = "update emp set lid=?,did=?,ename=?,salary=?,phone=?,password=?,photo=?,note=?,ineid=? where eid=? ";
		prepareStatement(sql);
		pstmt.setInt(1, vo.getLid());
		pstmt.setLong(2, vo.getDid());
		pstmt.setString(3, vo.getEname());
		pstmt.setDouble(4, vo.getSalary());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getPassword());
		pstmt.setString(7, vo.getPhoto());
		pstmt.setString(8, vo.getNote());
		pstmt.setString(9, vo.getIneid());
		pstmt.setString(10, vo.getEid());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		StringBuffer sql = new StringBuffer() ;
		sql.append("update emp set status=3 where eid in( ") ;
		for(String id : ids) {
			sql.append("'").append(id).append("',") ;
		}
		sql.delete(sql.length()-1, sql.length()).append(")") ;
		prepareStatement(sql.toString());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public Emp findById(String id) throws SQLException {
		String sql = "select eid,lid,did,ename,salary,phone,photo,note,hiredate,ineid,status,password,lastlogdate from emp where eid=? and status=0";
		prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
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
			vo.setHiredate(rs.getDate(9));
			vo.setIneid(rs.getString(10));
			vo.setStatus(rs.getInt(11));
			vo.setPassword(rs.getString(12));
			vo.setLastlogdate(rs.getTimestamp(13)); 
			return vo;
		}
		return null;
	}

	@Override
	public List<Emp> findAll() throws SQLException {
		List<Emp> all = new ArrayList<>();
		String sql = "select eid,lid,did,ename,salary,phone,photo,note,hiredate,ineid,status from emp where status=0 order by hiredate desc";
		prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
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
			vo.setHiredate(rs.getDate(9));
			vo.setIneid(rs.getString(10));
			vo.setStatus(rs.getInt(11));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Emp> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		String sql = "select eid,lid,did,ename,salary,phone,photo,note,hiredate,ineid,status from emp where status=0 order by hiredate desc limit ?,?";
		prepareStatement(sql);
		super.pstmt.setLong(1, (currentPage - 1) * lineSize);
		super.pstmt.setInt(2, lineSize);
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
			vo.setHiredate(rs.getDate(9));
			vo.setIneid(rs.getString(10));
			vo.setStatus(rs.getInt(11));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Emp> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		String sql = "select eid,lid,did,ename,salary,phone,photo,note,hiredate,ineid,status from emp where " + column
				+ " like ? and status=0 order by hiredate desc limit ?,?";
		prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		super.pstmt.setLong(2, (currentPage - 1) * lineSize);
		super.pstmt.setInt(3, lineSize);
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
			vo.setHiredate(rs.getDate(9));
			vo.setIneid(rs.getString(10));
			vo.setStatus(rs.getInt(11));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql = "select count(*) from  emp where status=0";
		prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		String sql = "select count(*) from emp  where " + column + " like ? and status=0";
		prepareStatement(sql);
		super.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			return rs.getLong(1);
		}
		return 0L;
	}

	@Override
	public EmpLevel findDeptAndLevelByEid(String eid) throws Exception {
		String sql = "select e.eid,e.photo,e.ename,e.did, le.title,d.dname,e.phone,e.hiredate,e.salary,e.note from emp e,(select lid,title from level)le,dept d where le.lid=e.lid and e.did=d.did and e.eid=?" ;
		prepareStatement(sql);
		pstmt.setString(1, eid);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			EmpLevel vo = new EmpLevel() ;
			vo.setEid(rs.getString(1));
			vo.setPhoto(rs.getString(2));
			vo.setEname(rs.getString(3));
			vo.setDid(rs.getLong(4));
			vo.setTitle(rs.getString(5));
			vo.setDname(rs.getString(6));
			vo.setPhone(rs.getString(7));
			vo.setHiredate(rs.getDate(8));
			vo.setSalary(rs.getDouble(9));
			vo.setNote(rs.getString(10));
			return vo ;
		}
		return null;
	}

}
