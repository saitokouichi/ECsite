package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteConfirmAction extends ActionSupport{

	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
	UserListDAO dao = new UserListDAO();

	public String execute()throws SQLException{
		userList = dao.getUserList();
		String result = SUCCESS;
		return result;
	}

	public ArrayList<UserInfoDTO> getUserList(){
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList){
		this.userList = userList;
	}

}
