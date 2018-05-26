package cn.mldn.eop.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IEmpresourceDAO;
import cn.mldn.eop.dao.IResourceDetailsDAO;
import cn.mldn.eop.dao.IShopcarDAO;
import cn.mldn.eop.service.IResourceDetailsService;
import cn.mldn.eop.vo.ResourceDetails;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;

@Service
public class ResourceDetailsServiceImpl extends AbstractService implements IResourceDetailsService {
	@Autowired
	private IEmpresourceDAO empresourceDAO;
	@Autowired
	private IShopcarDAO shopcarDAO;
	@Autowired
	private IResourceDetailsDAO resourcedetailsDAO;
	@Override
	
	public <T> T getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(ResourceDetails vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(ResourceDetails vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getAllCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> findbyeresid(Long eresid) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		if (eresid != null || !"".equals(eresid)) {
//			map.put("empresource",this.empresourceDAO.findByEresid(eresid));
			map.put("empresource", this.empresourceDAO.findById(String.valueOf(eresid))) ;
			map.put("resourcedetails",this.resourcedetailsDAO.findByEresid(eresid));
		}
		return map;
	}
	@Override
	public boolean removebyid(Long eresid, Set<Long> resid) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if (eresid == null || resid.size() == 0) {
					return false;
				} 
			return  this.resourcedetailsDAO.doRemoveById(eresid,resid);
	}
	@Override
	public boolean editbyid(Long eresid, Long resid, Integer amount,Double money) throws Exception {
		// TODO Auto-generated method stub
		if (amount < 0) {
		 return false;	
		}
		return  this.resourcedetailsDAO.doEditById(eresid, resid, amount,money);
	}
	
	@Override
	public boolean editnumber(Long eresid, Integer amount, Double money) throws Exception {
		// TODO Auto-generated method stub
		if (amount == null || money == null) {
			return false;
		}
		
		return this.empresourceDAO.doEdit(eresid, amount, money);
		
	}
}
