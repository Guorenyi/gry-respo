package cn.mldn.eop.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PlanDetails implements Serializable {
	private Long pdid;
	private Long pid;
	private String eid;
	
	public PlanDetails() {
		super();
	}
	@Override
	public String toString() {
		return "PlanDetails [pdid=" + pdid + ", pid=" + pid + ", eid=" + eid + "]";
	}
	public Long getPdid() {
		return pdid;
	}
	public void setPdid(Long pdid) {
		this.pdid = pdid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
}
