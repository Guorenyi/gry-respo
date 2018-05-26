package cn.mldn.eop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.eop.dao.IEmpEducationDAO;
import cn.mldn.eop.service.IEmpEducationService;
import cn.mldn.eop.vo.EmpEducation;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class EmpEducationServiceImpl extends AbstractService implements IEmpEducationService {
	@Autowired
	private IEmpEducationDAO empEducationDAO ;
	@Override
	public <T> T getById(String id) throws Exception {
		return null;
	}

	@Override
	public boolean add(EmpEducation vo) throws Exception {
		if(vo != null) {
			return this.empEducationDAO.doCreate(vo) ;
		}
		return false;
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		return false ;
	}

	@Override
	public boolean edit(EmpEducation vo) throws Exception {
		if(vo != null) {
			return this.empEducationDAO.doEdit(vo) ;
		}
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
	public List<EmpEducation> findAllByEid(String eid) throws Exception {
		if(eid != null) {
			return this.empEducationDAO.findAllByEid(eid) ;
		}
		return null;
	}

	@Override
	public Map<String,Object> findAllByDicType() throws Exception {
		Map<String,Object> map = new HashMap<>() ;
		map.put("allDegrees", this.empEducationDAO.findByDicType("degree")) ;
		return map ;
	}

	@Override
	public EmpEducation findByEeduid(Long id) throws Exception {
		if(id != null) {
			return this.empEducationDAO.findById(id) ;
		}
		return null;
	}

	@Override
	public boolean deleteEdu(Set<Long> ids) throws Exception {
		if(ids == null || ids.size() == 0) {
			return false ;
		}
		return this.empEducationDAO.doRemove(ids);
	}

}
