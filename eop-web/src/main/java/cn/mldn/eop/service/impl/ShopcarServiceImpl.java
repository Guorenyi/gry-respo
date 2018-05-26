package cn.mldn.eop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IShopcarDAO;
import cn.mldn.eop.dao.ResourceDAO;
import cn.mldn.eop.service.IShopcarService;
import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class ShopcarServiceImpl extends AbstractService implements IShopcarService {
	@Autowired
	private IShopcarDAO shopcarDAO;
	@Autowired
	private ResourceDAO resourceDAO;
	@Override
	public <T> T getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(Shopcar vo) throws Exception {
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
	public boolean add(Shopcar car) throws Exception {
		System.out.println("\n*****");
		boolean oldcar = this.shopcarDAO.isExist(car.getEid(), car.getResid());
		if (oldcar) {
			return this.shopcarDAO.doEditAmount(car.getEid(), car.getResid());
		} else {
			return this.shopcarDAO.doCreate(car);	
		}
		
	}
	
	@Override
	public Map<String, Object> list(String eid) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allShopcars", this.shopcarDAO.findAllByEid(eid));
		return map;
		
	}
	
	@Override
	public boolean delete(String eid, Set<Long> resid) throws Exception {
		// TODO Auto-generated method stub
		if (eid == null || resid.size() == 0) {
			return false;
		}
		return this.shopcarDAO.doRemoveByMember(eid, resid);
	}
	
	@Override
	public boolean editAmount(Shopcar car) throws Exception {
		// TODO Auto-generated method stub
		return this.shopcarDAO.doEditAmount(car.getEid(), car.getResid(), car.getAmount());
	}
}
