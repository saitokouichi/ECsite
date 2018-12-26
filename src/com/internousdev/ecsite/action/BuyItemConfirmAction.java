package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dao.ZaikoDAO;
import com.opensymphony.xwork2.ActionSupport;


public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private String pay;
	private String puroductName;
	private int nedan;
	private String id;
	private String count;
	private String payment;
	private int last;


	private Map<String,Object> session;
	BuyItemCompleteDAO dao = new BuyItemCompleteDAO();
	ZaikoDAO zdao = new ZaikoDAO();

	public String execute() throws SQLException{
		zdao.getStock(last,id);
		dao.buyItemInfo(id,
					    session.get("login_user_id").toString(),
					    session.get("total_price").toString(),
					    count,
					    payment);

		String result = SUCCESS;
		return result;
	}

	public Map<String,Object> session(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getPuroductName() {
		return puroductName;
	}

	public void setPuroductName(String puroductName) {
		this.puroductName = puroductName;
	}

	public int getNedan() {
		return nedan;
	}

	public void setNedan(int nedan) {
		this.nedan = nedan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

}
