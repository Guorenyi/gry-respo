package cn.mldn.eop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IDeptDAO;
import cn.mldn.eop.dao.IEmpDAO;
import cn.mldn.eop.dao.ILevelDAO;
import cn.mldn.eop.service.IEmpService;
import cn.mldn.eop.util.PermissionUtil;
import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Emp;
import cn.mldn.eop.vo.EmpLevel;
import cn.mldn.eop.vo.Level;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class EmpServiceImpl extends AbstractService implements IEmpService{
	@Autowired
	private IEmpDAO empDAO ;
	@Autowired
	private IDeptDAO deptDAO ;
	@Autowired
	private ILevelDAO levelDAO ;
	@Override
	public Emp getById(String id) throws Exception {
		if(id != null || "".equals(id)) {
			return this.empDAO.findById(id);
		}
		return null ;
	}

	@Override
	public boolean add(Emp vo) throws Exception {
		Level level = this.levelDAO.findById(vo.getLid()) ;
		Dept dept = this.deptDAO.findById(vo.getDid()) ;
		if(vo == null || vo.getSalary() > level.getHisal() || vo.getSalary() < level.getLosal()||dept.getCurrnum() == dept.getMaxnum()) {
			return false ;
		}
		if(this.empDAO.doCreate(vo)) {
			//把用户权限添加到缓存
			PermissionUtil.refreshUserPermission();
			return this.deptDAO.updateCurrnum(1, dept.getDname()) ;
		}
		return false ;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		if(ids == null || ids.size() == 0) {
			return false;
		}
		
		return this.empDAO.doRemove(ids) ;
	}

	@Override
	public boolean edit(Emp vo) throws Exception {
		Level level = this.levelDAO.findById(vo.getLid()) ;
		//新部门
		Dept newDept = this.deptDAO.findById(vo.getDid()) ;
//		System.out.println("*******newnew*****" + newDept);
		//未修改雇员
		Emp oldEmp = this.empDAO.findById(vo.getEid()) ;
		//未修改部门
		Dept oldDept = this.deptDAO.findById(oldEmp.getDid()) ;
//		System.out.println("*******oldold*****" + oldDept);
//		this.deptDAO.updateCurrnum(-1,oldDept.getDname()) ;
		
//		System.out.println("*******oldDept****" + oldDept.getDname());
//		System.out.println("*******new****" + newDept.getDname());
		if(vo == null || vo.getSalary() > level.getHisal() || vo.getSalary() < level.getLosal()) {
			return false ;
		}
		if(oldDept.getDname().equals(newDept.getDname())) {
			System.out.println("********hfdaklfjhalkjhdfahsdlj***********");
			return this.empDAO.doEdit(vo);
		}else {
			if(newDept.getCurrnum() == newDept.getMaxnum()) {
				return false ;
				//修改部门后要刷新用户权限
			}else {
				if(this.deptDAO.updateCurrnum(-1,oldDept.getDname()) && this.deptDAO.updateCurrnum(1, newDept.getDname())) {
					PermissionUtil.refreshUserPermission();
					return this.empDAO.doEdit(vo);
				}
			}
		}
		return false ;
	}

	@Override
	public long getAllCount() throws Exception {
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
		Map<String, Object> map = new HashMap<String, Object>();
		if (super.isSearch(column, keyWord)) { // 需要进行模糊查询
			map.put("allEmps", this.empDAO.findSplit(currentPage, lineSize, column, keyWord));
			map.put("allRecorders", this.empDAO.getAllCount(column, keyWord));
		} else {
			map.put("allEmps", this.empDAO.findSplit(currentPage, lineSize));
			map.put("allRecorders", this.empDAO.getAllCount());
		}
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allLevels", this.levelDAO.findAll()) ;
		return map;
	}

	@Override
	public Map<String, Object> addPre() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allLevels", this.levelDAO.findAll()) ;
		return map;
	}

	@Override
	public Map<String, Object> editPre(String eid) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allDepts", this.deptDAO.findAll()) ;
		map.put("allLevels", this.levelDAO.findAll()) ;
		map.put("emp", this.empDAO.findById(eid)) ;
		return map;
	}

	@Override
	public boolean findSalary(int lid, double salary) throws Exception {
		Level level = this.levelDAO.findById(lid) ;
		if(salary > level.getHisal() || salary < level.getLosal()) {
			return false ;
		}
		return true;
	}

	@Override
	public EmpLevel getEmpLevelDept(String eid) throws Exception {
		if(eid == null || "".equals(eid)) {
			return null ;
		}
		return this.empDAO.findDeptAndLevelByEid(eid) ;
	}

}
