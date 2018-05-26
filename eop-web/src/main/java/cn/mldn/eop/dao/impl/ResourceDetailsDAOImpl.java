package cn.mldn.eop.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IResourceDetailsDAO;
import cn.mldn.eop.vo.ResourceDetails;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ResourceDetailsDAOImpl extends AbstractDAO implements IResourceDetailsDAO {

	@Override
	public boolean doEdit(ResourceDetails vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResourceDetails findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	public boolean doCreate(ResourceDetails vo) throws SQLException {
		return super.doCreate(vo, ResourceDetails.class);
	}
	@Override
	public List<ResourceDetails> findByEresid(Long eresid) throws SQLException {
		// TODO Auto-generated method stub
		return super.findAll(ResourceDetails.class, "eresid=" + eresid);
	}
	
	@Override
	public boolean doRemoveById(Long eresid, Set<Long> resid) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM emp_resource_details WHERE eresid = ? AND resid IN (");
		for (Long id:resid) {
			sql.append("'").append(id).append("',");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		
		prepareStatement(sql.toString());
		super.pstmt.setLong(1, eresid);
		return super.pstmt.executeUpdate() > 0 ;
	}
	@Override
	public boolean doEditById(Long eresid, Long resid, Integer amount,Double money) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE emp_resource_details SET amount = ?,money = ? WHERE eresid = ? and resid = ?";
		prepareStatement(sql);
		super.pstmt.setInt(1, amount);
		super.pstmt.setDouble(2, money);
		super.pstmt.setLong(3, eresid);
		super.pstmt.setLong(4, resid);
		return super.pstmt.executeUpdate() > 0;
	}
}
