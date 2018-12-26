package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int stock;
	private String pay;
	private String puroductName;
	private int nedan;
	private String id;
	private String payment;
	private int i;
	private int count;
	private String od;
	private int last;
	private String Emessage;

	public String execute(){
		String result = SUCCESS;

		last = stock - count;

		if(last >= 0){
			session.put("total_price",count * nedan);
			result = SUCCESS;
		}else{
			Emessage = "在庫が足りません";
			result = ERROR;
		}
		return result;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getPuroductName(){
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

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOd() {
		return od;
	}

	public void setOd(String od) {
		this.od = od;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getEmessage() {
		return Emessage;
	}

	public void setEmessage(String emessage) {
		Emessage = emessage;
	}

}
