package cn.mldn.eop.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.vo.UserPermission;

public interface LoginDAO{
	public Map<String,List<UserPermission>> getUserPermission() throws SQLException;
	public boolean updateUserLoginDate(String userId) throws SQLException;
	public boolean updateUserPwd(String userId,String newPwd) throws SQLException;
}
