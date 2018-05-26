package cn.mldn.eop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.eop.dao.IScheduleDAO;
import cn.mldn.eop.service.ISheduleService;
import cn.mldn.eop.vo.PlanSchedule;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Service;
@Service
public class SheduleServiceImpl implements ISheduleService {
	@Autowired
	private IScheduleDAO sheduleDAO;
	@Override
	public List<PlanSchedule> get(String eid) throws Exception {
		if (eid==null||"".equals(eid)) {
			return null;
		}
		return this.sheduleDAO.findPlanScheduleByEmp(eid);
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize,String eid
			) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (column.equals("")||column==null || "".equals(keyWord)||keyWord==null) {
			map.put("allSchdules", this.sheduleDAO.findSplit(currentPage, lineSize, eid));
			
		}else {
			map.put("allSchdules", this.sheduleDAO.findSplit(currentPage, lineSize, column, keyWord, eid));
		}
		return map;
	}
}
