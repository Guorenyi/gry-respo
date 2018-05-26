package cn.mldn.eop.vo;

import java.io.Serializable;
import java.util.Date;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;
@TableAnnotation(tableName="resource",keyCol="resid")
public class Resource implements Serializable{
	@FieldAnnotation(isAutoIncrease="true",isKeyCol="true")
	private Long resid;
	private Long spid;
	private String title;
	private Double price;
	private Date appdate;
	private Integer amount;
	private String photo;
	private Integer itemType;
	private Integer status;
	private String note;
	public Long getResid() {
		return resid;
	}
	public void setResid(Long resid) {
		this.resid = resid;
	}
	public Long getSpid() {
		return spid;
	}
	public void setSpid(Long spid) {
		this.spid = spid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
