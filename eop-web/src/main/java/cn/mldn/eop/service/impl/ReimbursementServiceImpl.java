package cn.mldn.eop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IReimbursementDAO;
import cn.mldn.eop.service.IReimbursementService;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class ReimbursementServiceImpl extends AbstractService implements IReimbursementService {
	@Autowired
	private IReimbursementDAO reimbursementDAO;
	@Override
	public List<Dictionary> addPre() throws Exception {
		List<Dictionary> all = this.reimbursementDAO.findAllByReimbursement("reimbursement");
		return all;
		
	}

	@Override
	public boolean add(Reimbursement vo) throws Exception {
		if ("".equals(vo)||vo==null) {
			return false;
			
		}
		return this.reimbursementDAO.doCreate(vo);
	}

	@Override
	public Reimbursement getById(String id) throws Exception {
		if(id == null || "".equals(id)) {
			return null ;
		}
		return reimbursementDAO.findById(Long.parseLong(id));
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		return false ;
	}

	@Override
	public boolean edit(Reimbursement vo) throws Exception {
		return this.reimbursementDAO.doEdit(vo);
	}

	@Override
	public long getAllCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize) throws Exception {
		return super.findBySplit(currentPage, lineSize, this.reimbursementDAO);
	}

	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (super.isSearch(column, keyWord)) { // 需要进行模糊查询
			map.put("allReims", this.reimbursementDAO.findSplit(currentPage, lineSize, column, keyWord));
			map.put("allRecorders", this.reimbursementDAO.getAllCount(column, keyWord));
		} else {
			map.put("allReims", this.reimbursementDAO.findSplit(currentPage, lineSize));
			map.put("allRecorders", this.reimbursementDAO.getAllCount());
		}
		return map;
	}

	@Override
	public boolean editStatusById(Long id,String eid) throws Exception {
		if(id == null || "".equals(id)) {
			return false ;
		}
		Reimbursement vo = new Reimbursement() ;
		vo.setRbsid(id);
		vo.setSubdate(new Date());
		vo.setEid(eid);
		if(this.reimbursementDAO.editSubDate(vo)) {
			return this.reimbursementDAO.editStatusById(id);
		}
		return false ;
	}

	@Override
	public boolean deleteR(Set<Long> ids) throws Exception {
		return this.reimbursementDAO.doRemove(ids);
	}

	@Override
	public Map<String, Object> findAllSplitByStatus(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (super.isSearch(column, keyWord)) { // 需要进行模糊查询
			map.put("allReims", this.reimbursementDAO.findSplitByStatus(currentPage, lineSize, column, keyWord));
			map.put("allRecorders", this.reimbursementDAO.getAllCountByStatus(column, keyWord));
		} else {
			map.put("allReims", this.reimbursementDAO.findSplitByStatus(currentPage, lineSize));
			map.put("allRecorders", this.reimbursementDAO.getAllCountByStatus());
		}
		return map;
	}
}
