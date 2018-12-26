package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteConfirmAction extends ActionSupport{

	private ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();

	public String execute()throws SQLException{
		itemList = dao.getItemInfo();
		String result = SUCCESS;
		return result;
	}

	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList = itemList;
	}

}
