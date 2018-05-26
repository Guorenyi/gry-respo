package cn.mldn.eop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IEmpCareerDAO;
import cn.mldn.eop.service.IEmpCareerService;
import cn.mldn.eop.vo.EmpCareer;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class EmpCareerServiceImpl extends AbstractService implements IEmpCareerService{
	@Autowired
	private IEmpCareerDAO empCareerDAO ;
	@Override
	public <T> T getById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(EmpCareer vo) throws Exception {
		if(vo != null) {
			return this.empCareerDAO.doCreate(vo) ;
		}
		return false;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(EmpCareer vo) throws Exception {
		if(vo != null) {
			return this.empCareerDAO.doEdit(vo) ;
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
	public List<EmpCareer> findAllByCareerByEid(String eid) throws Exception {
		if(eid != null) {
			return this.empCareerDAO.findAllByCareerByEid(eid) ;
		}
		return null;
	}

	@Override
	public Map<String,Object> findAllByType() throws Exception {
		Map<String,Object> map = new HashMap<>() ;
		map.put("allPositions", this.empCareerDAO.findAllByType("position")) ;
		return map ;
	}

	@Override
	public EmpCareer findByEcarid(Long id) throws Exception {
		if(id != null) {
			return this.empCareerDAO.findById(id) ;
		}
		return null;
	}

	@Override
	public boolean deleteCareer(Set<Long> ids) throws Exception {
		if(ids == null || ids.size() == 0) {
			return false ;
		}
		return this.empCareerDAO.doRemove(ids);
	}

}
