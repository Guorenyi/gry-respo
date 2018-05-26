package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class EmpEducation implements Serializable{
	private Long eeduid ;
	private String eid ;
	private String school ;
	private String degree ;
	private String major ;
	private Date entrance ;
	private Date graduation ;
	private String note ;
	public Long getEeduid() {
		return eeduid;
	}
	public void setEeduid(Long eeduid) {
		this.eeduid = eeduid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getEntrance() {
		return entrance;
	}
	public void setEntrance(Date entrance) {
		this.entrance = entrance;
	}
	public Date getGraduation() {
		return graduation;
	}
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
