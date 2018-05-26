package cn.mldn.eop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IEmpresourceDAO;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class EmpresourceDAOImpl extends AbstractDAO implements IEmpresourceDAO {

	@Override
	public boolean doCreate(Empresource vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO emp_resource(eid,title,subdate,amount,money,status,note) VALUES(?,?,?,?,?,?,?)";
		prepareStatement(sql);
		super.pstmt.setString(1, vo.getEid());
		super.pstmt.setString(2, vo.getTitle());
		super.pstmt.setDate(3, new java.sql.Date(vo.getSubdate().getTime()));
		super.pstmt.setInt(4, vo.getAmount());
		super.pstmt.setDouble(5, vo.getMoney());
		super.pstmt.setInt(6, vo.getStatus());
		super.pstmt.setString(7, vo.getNote());
	    return super.pstmt.executeUpdate() > 0;	
	}
	public long doCreate(Empresource vo,boolean isReturnKeyId) throws SQLException {
		return super.doCreate(vo, Empresource.class, true);
	}
		

	@Override
	public boolean doEdit(Empresource vo) throws SQLException {
		return super.doEdit(vo, Empresource.class);
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empresource findById(String id) throws SQLException {
		return (Empresource) super.findById("eresid", id, Empresource.class);
	}

	@Override
	public List<Empresource> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresource> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Empresource> findSplit(Long currentPage, Integer lineSize,String eid) throws SQLException {
		// TODO Auto-generated method stub
		return super.findSplit(currentPage, lineSize, "eid='"+eid+"'", Empresource.class);
	}

	@Override
	public List<Empresource> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public long getAllCountHandle(String whereStr) throws SQLException {
		return super.getAllCountHandle("emp_resource", whereStr);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresource> findByEresid(Long eresid) throws SQLException {
		// TODO Auto-generated method stub
//		return super.findB(Empresource.class, "eresid=" + eresid);
		return null ;
	}
	@Override
	public boolean doEdit(Long eresid, Integer amount, Double money) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE FROM emp_resource SET amount = ?,money=? WHERE eresid=?";
		prepareStatement(sql);
		super.pstmt.setInt(1, amount);
		super.pstmt.setDouble(2, money);
		super.pstmt.setLong(3, eresid);
		return super.pstmt.executeUpdate() > 0;
	}
	public List<Empresource> findResourceApplyList(String whereStr) throws SQLException{
		return super.findAll(Empresource.class, whereStr);
	}
}