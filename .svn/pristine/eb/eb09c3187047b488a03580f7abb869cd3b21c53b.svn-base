package cn.mldn.eop.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IEmpresourceDAO;
import cn.mldn.eop.dao.IResourceDetailsDAO;
import cn.mldn.eop.dao.IShopcarDAO;
import cn.mldn.eop.service.IEmpresourceService;
import cn.mldn.eop.vo.Empresource;
import cn.mldn.eop.vo.ResourceDetails;
import cn.mldn.eop.vo.Shopcar;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class EmpresourceServiceImpl extends AbstractService implements IEmpresourceService {
	@Autowired
	private IEmpresourceDAO empresourceDAO;
	@Autowired
	private IShopcarDAO shopcarDAO;
	@Autowired
	private IResourceDetailsDAO resourcedetailsDAO;
	
	@Override
	public Empresource getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return empresourceDAO.findById(id);
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(Empresource vo) throws Exception {
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
	public boolean add(Empresource empres) throws Exception {
		// TODO Auto-generated method stub
		String title = "【" + new java.sql.Date(new Date().getTime()) + "-" + empres.getEid() + "】办公资源领取";
		if (empres.getEid() == null && empres.getTitle() == null && empres.getAmount() == null && empres.getAmount() == null) {
			return false;
		} else {
			empres.setSubdate(new java.sql.Date(new Date().getTime()));
			empres.setStatus(1);
			empres.setTitle(title);
			long newKeyId = empresourceDAO.doCreate(empres, true);
			List<Shopcar> shopcarlist = shopcarDAO.findAllByEid(empres.getEid());
			for(Shopcar car : shopcarlist) {
				ResourceDetails reds = new ResourceDetails();
				reds.setEresid(newKeyId);
				reds.setResid(car.getResid());
				reds.setAmount(car.getAmount());
				reds.setPhoto(car.getPhoto());
				reds.setTitle(car.getTitle());
				reds.setPrice(car.getPrice());
				reds.setMoney(car.getAmount() * car.getPrice());
				resourcedetailsDAO.doCreate(reds);	
			}
				return shopcarDAO.doRemoveByEid(empres.getEid());
				
		}
	}
	public Map<String,Object> findSplit(Long currentPage, Integer lineSize,String eid) throws Exception{
		List<Empresource> objectList = new ArrayList<Empresource>();
		objectList = empresourceDAO.findSplit(currentPage, lineSize,eid);
		long totalCount = empresourceDAO.getAllCountHandle("eid='"+eid+"'");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("objectList", objectList);
		map.put("totalCount", totalCount);
		return map;
	}
	public List<Empresource> findSubmitResourceApplyList() throws Exception{
		return empresourceDAO.findResourceApplyList("");
	}
}
