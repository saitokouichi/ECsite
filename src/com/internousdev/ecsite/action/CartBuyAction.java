package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartBuyDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartBuyAction extends ActionSupport implements SessionAware{

	private String pay;
	private String puroductName;
	private int nedan;
	private String id;
	private String totalCount;
	private String payment;
	private int last;
	private int stock;
	private String totalPrice;
	private int num;
	private Map<String,Object> session;
	public ArrayList<MyPageDTO> cartList = new ArrayList<MyPageDTO>();

	CartBuyDAO dao = new CartBuyDAO();

	public String execute()throws SQLException{
		String user_master_id = session.get("login_user_id").toString();

		dao.cartbuy(user_master_id);
		dao.cartdelete(user_master_id);

		String result = SUCCESS;
		return result;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<MyPageDTO> cartList) {
		this.cartList = cartList;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

}
