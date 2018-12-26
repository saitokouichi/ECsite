package com.internousdev.ecsite.action;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartListDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware{

	private String id;
	private String total_price;
	private String puroductName;
	private Date insert_date;
	private String count;
	private String payment;
	private String ad;
	private int stock;
	private Map<String,Object> session;
	public ArrayList<MyPageDTO> cartList = new ArrayList<MyPageDTO>();

	CartListDAO cdao = new CartListDAO();

	public String execute()throws SQLException{

		String result = ERROR;

		if(!session.containsKey("login_user_id")){
			result = ERROR;
		}else{

			CartListDAO cartListDAO = new CartListDAO();
			String user_master_id = session.get("login_user_id").toString();
			cartList = cartListDAO.getCartList(user_master_id);
			session.put("cartList", cartList);
			int cartPrice = cdao.getCartPrice(user_master_id);
			session.put("cartPrice", cartPrice);

			result = SUCCESS;
		}

		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getPuroductName() {
		return puroductName;
	}

	public void setPuroductName(String puroductName) {
		this.puroductName = puroductName;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
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

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
