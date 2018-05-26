package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eop.vo.Resource;
import cn.mldn.eop.vo.SupplyPurchase;
import cn.mldn.util.dao.IDAO;

public interface ResourceDAO extends IDAO<String,Resource>{
	public List<Resource> findAll(String whereStr) throws SQLException ;
	public List<Resource> findAvibSplit(Long currentPage, Integer lineSize) throws SQLException ;
	public List<Resource> findAvibSplit(Long currentPage, Integer lineSize,String column, String keyWord ) throws SQLException ;
	public long getAllCountHandle(String whereStr) throws SQLException;

}
