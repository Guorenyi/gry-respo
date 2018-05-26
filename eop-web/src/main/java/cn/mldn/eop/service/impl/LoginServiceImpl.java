package cn.mldn.eop.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.dao.LoginDAO;
import cn.mldn.eop.dao.impl.LoginDAOImpl;
import cn.mldn.eop.service.LoginService;
import cn.mldn.eop.vo.UserPermission;
import cn.mldn.util.encrypt.EncryptUtil;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
	private LoginDAO loginDao;
    public LoginServiceImpl() {
    	this.loginDao = new LoginDAOImpl();
	}
	@Override
	public Map<String, List<UserPermission>> getUserPermission() throws Exception {
		return loginDao.getUserPermission();
	}
	public boolean updateUserLoginDate(String userId) throws Exception{
		return loginDao.updateUserLoginDate(userId);
	}
	public boolean updateUserPwd(String userId,String pwd) throws Exception{
		//加密密码
		return loginDao.updateUserPwd(userId,EncryptUtil.encrypt(pwd));
	}
}
