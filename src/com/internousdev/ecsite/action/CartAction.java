package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dao.CartListDAO;
import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.ZaikoDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private String pay;
	private String puroductName;
	private int nedan;
	private String id;
	private String count;
	private String payment;
	private int last;
	private int stock;
	private String total_price;
	private int num;
	private Map<String,Object> session;
	public ArrayList<MyPageDTO> cartList = new ArrayList<MyPageDTO>();
	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();

	ItemListDAO itemListdao = new ItemListDAO();

	CartDAO dao = new CartDAO();
	CartListDAO cdao = new CartListDAO();
	ZaikoDAO zdao = new ZaikoDAO();

	public String execute()throws SQLException{

		int Count = Integer.parseInt(count);
		last = stock-Count;

		if(last >= 0){
			if(pay.equals("1")){
				payment = "現金払い";
			}else{
				payment = "クレジットカード";
			}
		}

		zdao.getStock(last, id);
		System.out.println(last);
		System.out.println(id);
		System.out.println(count);

		num = nedan * Count;
		total_price = String.valueOf(num);

		dao.cartInto(id,
					 session.get("login_user_id").toString(),
					 total_price,
					 count,
					 payment);

		String user_master_id = session.get("login_user_id").toString();
		cartList = cdao.getCartList(user_master_id);
		session.put("cartList", cartList);

		itemInfoList = itemListdao.getItemInfo();

		String result =SUCCESS;

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




	public String getTotal_price() {
		return total_price;
	}




	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}


	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}


	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}





}
