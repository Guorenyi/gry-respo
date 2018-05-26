package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;

@TableAnnotation(tableName="emp_resource",keyCol="eresid")
public class Empresource implements Serializable {
	@FieldAnnotation(isAutoIncrease="false",isKeyCol="true")
	private String eresid;
	private String eid;
	private String aeid;
	private String title;
	private Date subdate;
	private Integer amount;
	private Double money;
	private Integer status;
	private String renote;
	private Date auditdate;
	private String note;
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public Date getSubdate() {
		return subdate;
	}
	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRenote() {
		return renote;
	}
	public void setRenote(String renote) {
		this.renote = renote;
	}
	public Date getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}
	public String getEresid() {
		return eresid;
	}
	public void setEresid(String eresid) {
		this.eresid = eresid;
	}
	
}
