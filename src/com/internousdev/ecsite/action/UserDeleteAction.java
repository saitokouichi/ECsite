package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dao.userDeleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteAction extends ActionSupport{
	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
	UserListDAO userListDAO = new UserListDAO();

	private String id;

	public String execute()throws SQLException{

		userDeleteDAO dao = new userDeleteDAO();
		dao.userDelete(id);

		userList = userListDAO.getUserList();

		String result = SUCCESS;
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<UserInfoDTO> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList) {
		this.userList = userList;
	}

}
