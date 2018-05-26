package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.IShopcarDAO;
import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ShopcarDAOImpl extends AbstractDAO implements IShopcarDAO {

	@Override
	public boolean doCreate(Shopcar vo) throws SQLException {
		// TODO Auto-generated method stub
		return super.doCreate(vo, Shopcar.class);
	}

	@Override
	public boolean doEdit(Shopcar vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shopcar findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
	
	public boolean isExist(String eid,Long resid) throws SQLException {
		return super.getAllCountHandle("shopcar", " eid='"+eid+"' and resid="+resid)>0?true:false;
	}

	@Override
	public Shopcar findByMemberAndGoods(String eid, Long resid) throws SQLException {
		// TODO Auto-generated method stub
		return (Shopcar)super.findAll(Shopcar.class, " eid='"+eid+"' and resid="+resid);
	}
	@Override
	public boolean doEditAmount(String eid,Long resid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE shopcar SET amount=amount+1 where eid=? and resid=?";
		prepareStatement(sql);
		super.pstmt.setString(1, eid);
		super.pstmt.setLong(2, resid);
		return super.pstmt.executeUpdate() > 0;
	}
	@Override
	public List<Shopcar> findAllByEid(String eid) throws SQLException {
		// TODO Auto-generated method stub
		List<Shopcar>  all = new ArrayList<Shopcar>();
		String sql = "SELECT eid,resid,title,price,photo,amount FROM shopcar WHERE eid=?";
		prepareStatement(sql);
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery();
		while (rs.next()) {
			Shopcar car = new Shopcar();
			car.setEid(rs.getString(1));
			car.setResid(rs.getLong(2));
			car.setTitle(rs.getString(3));
			car.setPrice(rs.getDouble(4));
			car.setPhoto(rs.getString(5));
			car.setAmount(rs.getInt(6));
			all.add(car);
		}
		return all;
	}
	@Override
	public boolean doRemoveByMember(String eid, Set<Long> resid) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM shopcar WHERE eid =? and resid IN (");
		for (int x=0;x<resid.size();x++) {
			sql.append("?,");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		prepareStatement(sql.toString());
		super.pstmt.setString(1,eid);
		int foot=2;
		Iterator<Long> iter = resid.iterator();
		while (iter.hasNext()) {
			super.pstmt.setLong(foot++,iter.next());
		}
		return super.pstmt.executeUpdate() > 0;
	}
	@Override
	public boolean doEditAmount(String eid, Long resid, Integer amount) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE shopcar SET amount = ? WHERE eid=? AND resid = ?";
		prepareStatement(sql);
		super.pstmt.setInt(1, amount);
		super.pstmt.setString(2, eid);
		super.pstmt.setLong(3, resid);	
		return super.pstmt.executeUpdate() > 0;
	}
	@Override
	public boolean doRemoveByEid(String eid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROm shopcar WHERE eid=?";
		prepareStatement(sql);
		super.pstmt.setString(1, eid);
		return super.pstmt.executeUpdate() > 0;
	}
}
