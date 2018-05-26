package cn.mldn.eop.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.ResourceDAO;
import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class ResourceDAOImpl extends AbstractDAO<Resource>  implements ResourceDAO{

	@Override
	public boolean doCreate(Resource vo) throws SQLException {
		return super.doCreate(vo, Resource.class);
	}

	@Override
	public boolean doEdit(Resource vo) throws SQLException {
		return super.doEdit(vo, Resource.class);
	}

	@Override
	public boolean doRemove(Set<String> ids) throws SQLException {
		return super.doRemove(ids, "resource", "resid");
	}

	@Override
	public Resource findById(String id) throws SQLException {
		return super.findById("resid", id, Resource.class);
	}

	@Override
	public List<Resource> findAll() throws SQLException {
		return super.findAll(Resource.class);
	}
	@Override
	public List<Resource> findAll(String whereStr) throws SQLException {
		return super.findAll(Resource.class,whereStr);
	}
	@Override
	public List<Resource> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage, lineSize, Resource.class);
	}

	@Override
	public List<Resource> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		return super.findSplit(currentPage, lineSize, column+ " like '%"+keyWord+"%'", Resource.class);
	}

	@Override
	public Long getAllCount() throws SQLException {
		return super.getAllCountHandle("resource");
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		return super.getAllCountSplitHandle("resource", column, keyWord);
	}
	@Override
	public long getAllCountHandle(String whereStr) throws SQLException {
		return super.getAllCountHandle("resource", whereStr);
	}
	
	
	@Override
	public List<Resource> findAvibSplit(Long currentPage, Integer lineSize) throws SQLException {
		return super.findSplit(currentPage, lineSize,"status=1", Resource.class);
	}
	
	@Override
	public List<Resource> findAvibSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
		return super.findSplit(currentPage, lineSize,column+ " like '%"+keyWord+"%'"+" and status=1", Resource.class);
	}
	

	
}
