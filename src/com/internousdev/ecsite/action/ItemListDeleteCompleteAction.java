package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();
	private String message;

	public String execute ()throws SQLException{
		int res = dao.deleteItem();

		String result = ERROR;

		if(res > 0){
			setMessage("商品を全件削除しました。");
			result = SUCCESS;
		}else{
			setMessage("削除に失敗しました。");
			result = ERROR;
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
