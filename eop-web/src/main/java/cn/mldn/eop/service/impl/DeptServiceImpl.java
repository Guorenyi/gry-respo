package cn.mldn.eop.service.impl ;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IDeptDAO;
import cn.mldn.eop.dao.IEmpDAO;
import cn.mldn.eop.service.IDeptService;
import cn.mldn.eop.vo.Dept;
import cn.mldn.eop.vo.Emp;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;

@Service
public class DeptServiceImpl extends AbstractService implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ; 	// 把所有可能使用到的DAO接口都要定义在属性里面 
	@Autowired
	private IEmpDAO empDAO ;
	@Override
	public boolean add(Dept dept) throws Exception {
		return this.deptDAO.doCreate(dept);
	}
	@Override
	public boolean delete(Set<String> id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean edit(Dept vo) throws Exception {
		Dept oldDept = this.deptDAO.findById(vo.getDid()) ;
//		System.out.println("*******");
		if(vo.getMaxnum() < 0 || vo.getMaxnum() < oldDept.getCurrnum()) {
			return false ;
		}
		if(oldDept.getDname().equals(vo.getDname())) {
			return this.deptDAO.doEdit(vo);
		}else {
			if(this.deptDAO.findByDname(vo.getDname()) == null) {
				return this.deptDAO.doEdit(vo);
			}
		}
		return false ;
	}
	@Override
	public long getAllCount() throws Exception {
		return this.deptDAO.getAllCount();
	}
	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("allDepts", this.deptDAO.findSplit(currentPage, lineSize)) ;
		return map;
	}
	@Override
	public Map<String, Object> findBySplit(long currentPage, int lineSize, String column, String keyWord)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (super.isSearch(column, keyWord)) { // 需要进行模糊查询
			map.put("allDepts", this.deptDAO.findSplit(currentPage, lineSize, column, keyWord));
			map.put("allRecorders", this.deptDAO.getAllCount(column, keyWord));
		} else {
			map.put("allDepts", this.deptDAO.findSplit(currentPage, lineSize));
			map.put("allRecorders", this.deptDAO.getAllCount());
		}
		map.put("allEmps",this.empDAO.findAll()) ;
		return map;
	}
	@Override
	public Dept findByDname(String dname) throws Exception {
		if(dname == null || "".equals(dname)) {
			return null ;
		}
		return this.deptDAO.findByDname(dname);
	}
	@Override
	public <T> T getById(String id) throws Exception {
		return null;
	}
	@Override
	public Long getAllCount(String column, String keyWord) throws Exception {
		return this.deptDAO.getAllCount(column, keyWord);
	}
	@Override
	public List<Emp> listAllLid() throws Exception {
		return this.deptDAO.findByLid();
	}

}
