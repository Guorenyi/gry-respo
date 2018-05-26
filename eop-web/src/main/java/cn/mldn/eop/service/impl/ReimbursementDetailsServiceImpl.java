package cn.mldn.eop.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IReimbursementDAO;
import cn.mldn.eop.dao.IReimbursementDetailsDAO;
import cn.mldn.eop.service.IReimbursementDetailsService;
import cn.mldn.eop.vo.Reimbursement;
import cn.mldn.eop.vo.ReimbursementDetails;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class ReimbursementDetailsServiceImpl extends AbstractService implements IReimbursementDetailsService {
	@Autowired
	private IReimbursementDetailsDAO reimbursementDetailsDAO;
	@Autowired
	private IReimbursementDAO reimbursementDAO;
	
	@Override
	public List<ReimbursementDetails> listByRbsid(Long id) throws Exception {
		if(id == null || "".equals(id)) {
			return null ;
		}
		return this.reimbursementDetailsDAO.findAllByRbsid(id);
	}
	@Override
	public ReimbursementDetails getById(String id) throws Exception {
		return this.reimbursementDetailsDAO.findById(Long.parseLong(id));
	}

	@Override
	public boolean add(ReimbursementDetails vo) throws Exception {
		if(this.reimbursementDetailsDAO.doCreate(vo)) {
			Reimbursement re = this.reimbursementDAO.findById(vo.getRbsid()) ;
			return this.reimbursementDetailsDAO.editMoney(vo.getRbsid(), vo.getMoney()+re.getMoney()) ;
		}
		return false ;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		return false;
	}

	@Override
	public boolean edit(ReimbursementDetails vo) throws Exception {
		Reimbursement re = this.reimbursementDAO.findById(vo.getRbsid()) ;
		ReimbursementDetails de = this.reimbursementDetailsDAO.findById(vo.getRbdid()) ;
		double money = re.getMoney() - de.getMoney() ;
		if(this.reimbursementDetailsDAO.doEdit(vo)) {
			money = money + vo.getMoney() ;
			return this.reimbursementDetailsDAO.editMoney(vo.getRbsid(), money) ;
		}
		return false ;
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
	public boolean deleteR(Set<Long> ids,long rbsid) throws Exception {
		Iterator<Long> iter = ids.iterator() ;
		while(iter.hasNext()) {
			long idd = iter.next() ;
//			if(this.reimbursementDetailsDAO.doRemoveSingle(idd)) {
//				Reimbursement re = this.reimbursementDAO.findById(rbsid) ;
//				System.out.println("*******re.money***" + re.getMoney());
//				ReimbursementDetails vo = this.reimbursementDetailsDAO.findById(iter.next()) ;
//				System.out.println("*********vo.money****" + vo.getMoney());
//				this.reimbursementDetailsDAO.editMoney(vo.getRbdid(),re.getMoney()-vo.getMoney()) ;
				ReimbursementDetails vo = this.reimbursementDetailsDAO.findById(idd) ;
				Reimbursement re = this.reimbursementDAO.findById(rbsid) ;
				this.reimbursementDetailsDAO.editMoney(vo.getRbsid(),(re.getMoney()-vo.getMoney())) ;
				this.reimbursementDetailsDAO.doRemoveSingle(idd) ;
//			}
		}
		return true ;
	}


}
