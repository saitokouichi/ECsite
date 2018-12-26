package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dao.UserListNumberDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
	UserListDAO dao = new UserListDAO();
	UserListNumberDAO ndao = new UserListNumberDAO();
	private int num;

	public String execute()throws SQLException{
		userList = dao.getUserList();
		num = ndao.number();
		String result = SUCCESS;
		return result;
	}

	public ArrayList<UserInfoDTO> getUserList(){
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList){
		this.userList = userList;
	}

	public int getNum(){
		return num;
	}

	public void setNum(int num){
		this.num = num;
	}

}
