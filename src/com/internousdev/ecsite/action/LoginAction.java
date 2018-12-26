package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.ItemListNumberDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();
	ItemListNumberDAO ndao = new ItemListNumberDAO();
	private int num;
	private String loginUserId;
	private String loginPassword;

	private Map<String,Object> session;


	public String execute()throws SQLException{

		LoginDAO ldao = new LoginDAO();
		LoginDTO ldto = new LoginDTO();
		BuyItemDTO bdto = new BuyItemDTO();
		BuyItemDAO bdao = new BuyItemDAO();

		String result = ERROR;
		itemInfoList = dao.getItemInfo();
		num = ndao.number();
		ldto  = ldao.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", ldto);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			bdto = bdao.getBuyItemInfo();

			session.put("login_user_id",ldto.getLoginId());
			session.put("id", bdto.getId());
			session.put("buyItem_name", bdto.getItemName());
			session.put("buyItem_price", bdto.getItemPrice());
			session.put("user_name", ldto.getUserName());
			session.put("buyItem_stock",bdto.getStock());

			return result;
		}

		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList(){
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList){
		this.itemInfoList = itemInfoList;
	}

	public int getNum(){
		return num;
	}

	public void setNum(int num){
		this.num = num;
	}



}
