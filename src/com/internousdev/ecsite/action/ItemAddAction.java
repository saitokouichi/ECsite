package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemAddAction extends ActionSupport{

	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();

	public String execute()throws SQLException{
		itemInfoList = dao.getItemInfo();
		String result = SUCCESS;

		return result;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}
	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}


}
