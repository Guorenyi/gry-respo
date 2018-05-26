package cn.mldn.eop.util;

import java.util.List;
import java.util.Map;

import cn.mldn.eop.service.LoginService;
import cn.mldn.eop.service.impl.LoginServiceImpl;
import cn.mldn.eop.vo.UserPermission;

public class PermissionUtil {
	private static Map<String, List<UserPermission>> permMap;
	private static String permStr = "";
	static {
		LoginService service = new LoginServiceImpl();
		try {
			permMap = service.getUserPermission();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 当增加用户或者修改用户权限时，重新刷新缓存权限
	 */
	public static void refreshUserPermission() {
		LoginService service = new LoginServiceImpl();
		try {
			permMap = service.getUserPermission();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  根据用户ID取得用户权限列表
	 * @param userId 用户ID
	 * @return 用户权限列表
	 */
	public static List<UserPermission> getUserPermission(String userId) {
		if (permMap != null) {
			return permMap.get(userId);
		} else {
			return null;
		}
	}

	/**
	 * 根据用户ID取得用户权限字符串
	 * @param userId 用户ID
	 * @return 权限字符串，以","隔开每个权限
	 */
	public static String getUserPermissionStr(String userId) {
		if (permMap != null) {
			List<UserPermission> permList = permMap.get(userId);
			if (permList != null) {
				StringBuffer sb = new StringBuffer();
				for (UserPermission userPermission : permList) {
					sb.append(userPermission.getActid()).append(",");
				}
				return sb.toString();
			} else {
				return "";
			}

		} else {
			return "";
		}
	}
}
