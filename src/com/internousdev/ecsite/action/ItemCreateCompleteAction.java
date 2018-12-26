package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;


	public String execute() throws SQLException{
		ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();
		dao.createItem(session.get("productName").toString(),
				session.get("nedan").toString(),
				session.get("stock").toString());

		String result = SUCCESS;
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}


}
