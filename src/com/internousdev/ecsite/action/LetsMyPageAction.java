package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LetsMyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String deleteFlg;
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	MyPageDAO dao = new MyPageDAO();
	private String message;

	public String execute() throws SQLException{
		String result = "login";

		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			String user_master_id = session.get("login_user_id").toString();
			myPageList = dao.getMyPageUserInfo(user_master_id);
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());



			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
	}


	public ArrayList<MyPageDTO> myPageList(){
		return myPageList;
	}

	public void setMyPageList(ArrayList<MyPageDTO> myPageList){
		this.myPageList = myPageList;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

}
