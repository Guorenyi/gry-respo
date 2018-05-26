package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class EmpCareer implements Serializable{
	private Long ecarid ;
	private String eid ;
	private String company ;
	private String position ;
	private Double salary ;
	private Date entry ;
	private Date quit ;
	private String reason ;
	private String note ;
	public Long getEcarid() {
		return ecarid;
	}
	public void setEcarid(Long ecarid) {
		this.ecarid = ecarid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getEntry() {
		return entry;
	}
	public void setEntry(Date entry) {
		this.entry = entry;
	}
	public Date getQuit() {
		return quit;
	}
	public void setQuit(Date quit) {
		this.quit = quit;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
