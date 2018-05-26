package cn.mldn.eop.vo;

import java.io.Serializable;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;

@TableAnnotation(tableName="emp_resource_details",keyCol="eredid")
public class ResourceDetails implements Serializable {
	@FieldAnnotation(isAutoIncrease="true",isKeyCol="true")
	private Long eredid;
	private Long eresid;
	private Long resid;
	private Integer amount;
	private String photo;
	private String title;
	private Double price;
	private Double money;
	public Long getEredid() {
		return eredid;
	}
	public void setEredid(Long eredid) {
		this.eredid = eredid;
	}
	public Long getEresid() {
		return eresid;
	}
	public void setEresid(Long eresid) {
		this.eresid = eresid;
	}
	public Long getResid() {
		return resid;
	}
	public void setResid(Long resid) {
		this.resid = resid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	

}
