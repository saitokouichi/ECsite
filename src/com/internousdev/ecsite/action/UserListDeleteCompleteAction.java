package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();
	private String message;

	public String execute()throws SQLException{
		int ret = dao.deleteUser();

		String result;

		if(ret>0){
			setMessage("ユーザーの削除に成功しました。");
			result = SUCCESS;
		}else{
			setMessage("ユーザーの削除に失敗しました。");
			result = SUCCESS;
		}
		return result;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

}
