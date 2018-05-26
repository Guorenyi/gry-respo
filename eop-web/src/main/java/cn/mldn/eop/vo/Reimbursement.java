package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;
@SuppressWarnings("serial")
@TableAnnotation(tableName="reimbursement",keyCol="rbsid")
public class Reimbursement implements Serializable {
	@FieldAnnotation(isAutoIncrease="true",isKeyCol="true")
	private Long rbsid;
	private String eid;
	private String aeid;
	private String title;
	private String item;
	private String note;
	private Double money;
	private Date credate;
	private Date subdate;
	private Integer status;
	private Date auditdate;
	private String anote;
	
	@Override
	public String toString() {
		return "Reimbursement [rbsid=" + rbsid + ", eid=" + eid + ", aeid=" + aeid + ", title=" + title + ", item="
				+ item + ", note=" + note + ", money=" + money + ", credate=" + credate + ", subdate=" + subdate
				+ ", status=" + status + ", auditdate=" + auditdate + ", anote=" + anote + "]";
	}
	public Long getRbsid() {
		return rbsid;
	}
	public void setRbsid(Long rbsid) {
		this.rbsid = rbsid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getAeid() {
		return aeid;
	}
	public void setAeid(String aeid) {
		this.aeid = aeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	public Date getSubdate() {
		return subdate;
	}
	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}
	public String getAnote() {
		return anote;
	}
	public void setAnote(String anote) {
		this.anote = anote;
	}
	
	
}	
