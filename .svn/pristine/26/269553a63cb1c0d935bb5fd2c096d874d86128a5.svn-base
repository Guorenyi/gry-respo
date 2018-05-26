package cn.mldn.eop.vo;

import java.io.Serializable;

import cn.mldn.util.web.annotation.FieldAnnotation;
import cn.mldn.util.web.annotation.TableAnnotation;

@SuppressWarnings("serial")
@TableAnnotation(tableName="reimbursement_details",keyCol="rbdid")
public class ReimbursementDetails implements Serializable {
	@FieldAnnotation(isAutoIncrease="true",isKeyCol="true")
	private Long rbdid;
	private Long rbsid;
	private Double money;
	private String note;
	private String title ;
	
	@Override
	public String toString() {
		return "ReimbursementDetails [rbdid=" + rbdid + ", rbsid=" + rbsid + ", money=" + money + ", note=" + note
				+ ", title=" + title + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getRbdid() {
		return rbdid;
	}
	public void setRbdid(Long rbdid) {
		this.rbdid = rbdid;
	}
	public Long getRbsid() {
		return rbsid;
	}
	public void setRbsid(Long rbsid) {
		this.rbsid = rbsid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
