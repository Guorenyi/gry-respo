package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IPlanDetailsDAO;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;

@Repository
public class PlanDetailsDAOImpl extends AbstractDAO<PlanDetails> implements IPlanDetailsDAO {
	
	
	
	
	@Override
	public Boolean doDelete(Long pid, String eid) throws SQLException {
		String sql = "delete from plan_details where pid=? and eid=?";
		prepareStatement(sql);
		super.pstmt.setLong(1, pid);
		super.pstmt.setString(2, eid);
		int i = super.pstmt.executeUpdate();
		return i>0;
	}
	
	@Override
	public PlanDetails findByEidAndPid(Long pid, String eid) throws SQLException {
		String sql = "select pid,eid from plan_details where pid=? and eid=?";
		prepareStatement(sql);
		super.pstmt.setLong(1, pid);
		super.pstmt.setString(2, eid);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			PlanDetails vo = new PlanDetails();
			vo.setPid(rs.getLong(1));
			vo.setEid(rs.getString(2));
			return vo;
		}
		return null;
	}
	@Override
	public boolean doCreate(PlanDetails vo) throws SQLException {
		String sql = "insert into plan_details(pid,eid) values(?,?)";
		prepareStatement(sql);
		super.pstmt.setLong(1, vo.getPid());
		super.pstmt.setString(2, vo.getEid());
		int i = super.pstmt.executeUpdate();
		return i>0;
		
	}

	@Override
	public boolean doEdit(PlanDetails vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from plan_details where pdid in( ");
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
	public PlanDetails findById(Long id) throws SQLException {
		
		return null;
	}

	@Override
	public List<PlanDetails> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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

}
