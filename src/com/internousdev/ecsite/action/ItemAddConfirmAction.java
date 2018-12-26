package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAddConfirmAction extends ActionSupport{

	private String id;
	private int last;
	private String puroductName;
	private int stock;
	private String errormessage;
	public int tol;

	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();

	public String execute() throws SQLException{
		itemInfoList = dao.getItemInfo();
		String result;

		if(last == 0){
			result = ERROR;
			errormessage = "正しく入力されていません";
		}else{
			result = SUCCESS;
		}

		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getPuroductName() {
		return puroductName;
	}

	public void setPuroductName(String puroductName) {
		this.puroductName = puroductName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public ArrayList<ItemInfoDTO> getItemInfoList() {
		return itemInfoList;
	}

	public void setItemInfoList(ArrayList<ItemInfoDTO> itemInfoList) {
		this.itemInfoList = itemInfoList;
	}

	public int getTol() {
		return tol;
	}

	public void setTol(int tol) {
		this.tol = tol;
	}

}
