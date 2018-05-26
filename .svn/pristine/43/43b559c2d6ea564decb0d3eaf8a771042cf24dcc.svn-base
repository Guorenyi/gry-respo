package cn.mldn.eop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eop.dao.ILevelDAO;
import cn.mldn.eop.vo.Level;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;

@Repository
public class LevelDAOImpl extends AbstractDAO<Level> implements ILevelDAO{

	@Override
	public boolean doCreate(Level vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Level vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Level findById(Integer id) throws SQLException {
		String sql = "select lid,title,losal,hisal from level where lid=?" ;
		prepareStatement(sql) ;
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Level vo = new Level() ;
			vo.setLid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setLosal(rs.getDouble(3));
			vo.setHisal(rs.getDouble(4));
			return vo ;
		}
		return null ;
	}

	@Override
	public List<Level> findAll() throws SQLException {
		List<Level> all = new ArrayList<Level>() ;
		String sql = "select lid,title,losal,hisal from level" ;
		prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Level vo = new Level() ;
			vo.setLid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setLosal(rs.getDouble(3));
			vo.setHisal(rs.getDouble(4));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Level> findSplit(Long currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Level> findSplit(Long currentPage, Integer lineSize, String column, String keyWord)
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
