package cn.mldn.eop.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IDeptDAO;
import cn.mldn.eop.dao.IEmpDAO;
import cn.mldn.eop.dao.ILevelDAO;
import cn.mldn.eop.dao.IPlanDAO;
import cn.mldn.eop.service.IPlanService;
import cn.mldn.eop.vo.Dictionary;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Plan;
import cn.mldn.eop.vo.PlanDetails;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class PlanServiceImpl extends AbstractService implements IPlanService {
	@Autowired
	private IPlanDAO planDAO;
	
	@Autowired
	private IDeptDAO deptDAO;
	
	@Autowired
	private IEmpDAO empDAO;
	
	
	@Autowired
	private ILevelDAO levelDAO;
	/**
	 * 注：业务层数据修改方法要以add、 edit、delete 开头
	 */
	
	@Override
	public Plan getPlan(Long pid) throws SQLException {
		if (pid==null||"".equals(pid)) {
			return null;
		}
		return this.planDAO.findById(pid);
	}
	@Override
	public EmpLevel findEmpLevel(String eid) throws Exception {
		return this.planDAO.getEmpLevelDept(eid);
	}
	@Override
	public Map<String, Object> getDetailsDept(Long did) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		if (did==null) {
			map.put("allEmps", this.planDAO.findAllEmpAndLevel());
		}else {
			map.put("allEmps", this.planDAO.findAllEmpAndLevelByDept(did));
		}
		return map;
	}
	
	
	@Override
	public Map<String, Object> getAllEmpDept(Long did,long currentPage, int lineSize)
			throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("allDepts", this.deptDAO.findAll());
		if ("".equals(did) || did==null) {
			map.put("allEmps", this.empDAO.findSplit(currentPage, lineSize));
			
		}else {
			map.put("allEmps", this.planDAO.findSplitByDept(did, currentPage, lineSize));
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getDetails(Long pid) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("plan", this.planDAO.findById(pid));
		map.put("allDepts", this.deptDAO.findAll());
		//map.put("allEmps", this.empDAO.findAll());
		map.put("allEmpLevels", this.planDAO.findAllEmpAndLevel());
		List<PlanDetails> planDetails = this.planDAO.findAllEmpByPlan(pid);
		List<EmpLevel> allEmpLevelDept = new ArrayList<>();
		for (PlanDetails planDetail : planDetails) {
			allEmpLevelDept.add(this.planDAO.getEmpLevelDept(planDetail.getEid()));
		}
		map.put("allEmpLevelDept", allEmpLevelDept);
		return map;
	}
	@Override
	public boolean delete(Set<Long> ids)throws Exception{
		if (ids.size()==0) {
			return false;
		}
		for (Long id : ids) {
			if (this.planDAO.findById(id).getStatus()==0) {
				return this.planDAO.doRemove(ids);
			}
		}
		return false;
	}
	
	@Override
	public boolean editPublish(Long pid) throws Exception {
		if (pid==null||"".equals(pid)) {
			return false;
		}
		return this.planDAO.doEditStatus(pid, 1);
	}
	
	@Override
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (column.equals("")||column==null || "".equals(keyWord)||keyWord==null) {
			map.put("allPlans", this.planDAO.findSplit(currentPage, lineSize));
			map.put("allCount", this.planDAO.getAllCount());
		}else {
			map.put("allPlans", this.planDAO.findSplit(currentPage, lineSize, column, keyWord));
			map.put("allCount", this.planDAO.getAllCount(column, keyWord));
		}
		return map;
	}
	@Override
	public List<Dictionary> addPre() throws Exception {
		List<Dictionary> all = this.planDAO.findAllByPlan("plan");
		return all;
	}



	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Boolean add(Plan vo) throws Exception {
		if ("".equals(vo)||vo==null) {
			return false;
		}
		vo.setAmount(0);
		vo.setStatus(0);
		boolean flag = this.planDAO.doCreate(vo);
		return flag;
	}




	public boolean edit(Plan vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	public long getAllCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public Map<String, Object> findBySplit(long currentPage, int lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, Object> findBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
