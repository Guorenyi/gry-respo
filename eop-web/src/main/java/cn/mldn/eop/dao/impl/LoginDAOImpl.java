package cn.mldn.eop.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.dao.LoginDAO;
import cn.mldn.eop.vo.UserPermission;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.util.web.annotation.Repository;
@Repository
public class LoginDAOImpl extends AbstractDAO implements LoginDAO {

	@Override
	public Map<String, List<UserPermission>> getUserPermission() throws SQLException {
		String sql = "select e.eid,d.did,d.dname,a.actid,a.title from emp e,dept d,dept_role dr,role r,action a where e.did =d.did and d.did=dr.did and dr.rid=r.rid and r.rid=a.rid  order by e.eid,d.dname,a.actid";
		super.prepareStatement(sql);
		ResultSet rs = super.pstmt.executeQuery();
		Map<String, List<UserPermission>> userPermMap = new HashMap<String, List<UserPermission>>();
		String eid = "";
		List<UserPermission> permList = null;
		while (rs.next()) {

			if ("".equals(eid)) {
				permList = new ArrayList();
				UserPermission userPermission = new UserPermission();
				userPermission.setEid(rs.getString("eid"));
				userPermission.setDid(rs.getString("did"));
				userPermission.setDname(rs.getString("dname"));
				userPermission.setActid(rs.getString("actid"));
				userPermission.setTitle(rs.getString("title"));
				permList.add(userPermission);
				eid = rs.getString("eid");
				userPermMap.put(eid, permList);
				continue;

			}
			// 如果用户ID发生变化，则新建List
			if (!eid.equalsIgnoreCase(rs.getString("eid"))) {
				permList = new ArrayList();
				UserPermission userPermission = new UserPermission();
				userPermission.setEid(rs.getString("eid"));
				userPermission.setDid(rs.getString("did"));
				userPermission.setDname(rs.getString("dname"));
				userPermission.setActid(rs.getString("actid"));
				userPermission.setTitle(rs.getString("title"));
				permList.add(userPermission);
				eid = rs.getString("eid");
				userPermMap.put(eid, permList);
				continue;
			}
			UserPermission userPermission = new UserPermission();
			userPermission.setEid(rs.getString("eid"));
			userPermission.setDid(rs.getString("did"));
			userPermission.setDname(rs.getString("dname"));
			userPermission.setActid(rs.getString("actid"));
			userPermission.setTitle(rs.getString("title"));
			permList.add(userPermission);

		}
		return userPermMap;
	}
	public boolean updateUserLoginDate(String userId) throws SQLException{
		String sql = "update emp a set a.lastlogdate=? where eid=?";
		prepareStatement(sql);
		super.pstmt.setTimestamp(1, new java.sql.Timestamp((new java.util.Date()).getTime()));
		super.pstmt.setString(2,userId);
		return super.pstmt.executeUpdate()>0?true:false;  
	//	return true;
		
	}
	public boolean updateUserPwd(String userId,String newPwd) throws SQLException{
		String sql ="update emp a set a.password =? where eid=?";
		prepareStatement(sql);
		super.pstmt.setString(1, newPwd);
		super.pstmt.setString(2,userId);
		return super.pstmt.executeUpdate()>0?true:false;
	}

}
