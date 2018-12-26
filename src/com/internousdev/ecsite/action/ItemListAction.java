package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.ItemListNumberDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();
	ItemListNumberDAO ndao = new ItemListNumberDAO();
	private int num;

	public String execute() throws SQLException{
		itemInfoList = dao.getItemInfo();
		String result = SUCCESS;
		return result;
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
