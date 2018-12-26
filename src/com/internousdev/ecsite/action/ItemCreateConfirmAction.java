package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String productName;
	private String nedan;
	private String stock;
	private Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(productName.equals(""))
			&& !(nedan.equals(""))
			&& !(stock.equals(""))){
			session.put("productName", productName);
			session.put("nedan", nedan);
			session.put("stock", stock);
		}else{
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getNedan(){
		return nedan;
	}

	public void setNedan(String nedan){
		this.nedan = nedan;
	}

	public String getStock(){
		return stock;
	}

	public void setStock(String stock){
		this.stock = stock;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
