package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	MyPageDAO dao = new MyPageDAO();
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		else{
			String user_master_id = session.get("login_user_id").toString();
			myPageList = dao.getMyPageUserInfo(user_master_id);
		}

		String result = SUCCESS;
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
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
