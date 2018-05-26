package cn.mldn.eop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.vo.UserPermission;

public interface LoginService {
	/**
	 * 系统初始化时，取得所有的用户权限，并存入cache中，以便每次访问时从内存中取权限数据
	 * @return 所有的用户权限
	 * @throws Exception
	 */
	public Map<String, List<UserPermission>> getUserPermission() throws Exception;
	/**
	 * 更新用户的最新登陆时间
	 * @param userId 用户ID
	 * @return true:更新成功
	 *         false:更新失败
	 * @throws Exception
	 */
	public boolean updateUserLoginDate(String userId) throws Exception;
	
	/**
	 * 更新用户密码
	 * @param userId 用户ID
	 * @param pwd 用户新密码
	 * @return true:更新成功
	 *         false:更新失败
	 * @throws Exception
	 */
	public boolean updateUserPwd(String userId,String pwd) throws Exception;

}
