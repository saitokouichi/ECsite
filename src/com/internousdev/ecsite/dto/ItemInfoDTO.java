package com.internousdev.ecsite.dto;

public class ItemInfoDTO {

	private String id;
	private String puroductName;
	private String nedan;
	private String stock;
	private String insert_date;
	private String update_date;

	public String getId(){
		return id;
	}
	public void setId(String  id){
		this.id = id;
	}
	public String getPuroductName() {
		return puroductName;
	}
	public void setPuroductName(String puroductName) {
		this.puroductName = puroductName;
	}
	public String getNedan() {
		return nedan;
	}
	public void setNedan(String nedan) {
		this.nedan = nedan;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}
