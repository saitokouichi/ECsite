package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dao.CartListDAO;
import com.internousdev.ecsite.dao.ItemAddDAO;
import com.internousdev.ecsite.dto.ItemAddDTO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartSelectDeleteAction extends ActionSupport implements SessionAware{

	private String id;
	private String id2;
	private String puroductName;
	private String totalPrice;
	private String totalCount;
	private String payment;
	private int total;
	private int stock;
	private Map<String,Object> session;
	public ArrayList<MyPageDTO> cartList = new ArrayList<MyPageDTO>();

	ItemAddDAO dao = new ItemAddDAO();
	ItemAddDTO dto = new ItemAddDTO();

	public String execute()throws SQLException{

		CartDAO cartDAO = new CartDAO();
		CartListDAO cartListDAO = new CartListDAO();


		cartDAO.cartSelectDelete(id2);
		String user_master_id = session.get("login_user_id").toString();
		cartList = cartListDAO.getCartList(user_master_id);
		session.put("cartList", cartList);

		String result = SUCCESS;
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getPuroductName() {
		return puroductName;
	}

	public void setPuroductName(String puroductName) {
		this.puroductName = puroductName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}




}
