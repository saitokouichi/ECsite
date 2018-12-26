package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemAddDAO;
import com.internousdev.ecsite.dto.ItemAddDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAddCompleteAction extends ActionSupport{

	private int last;
	private String id;
	private int abc;
	private int total;
	private int stock;
	private String puroductName;

	ItemAddDAO dao = new ItemAddDAO();
	ItemAddDTO dto = new ItemAddDTO();

	public String execute()throws SQLException{
		total = stock + last;
		dao.getStock(total,id);

		String result = SUCCESS;
		return result;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAbc() {
		return abc;
	}

	public void setAbc(int abc) {
		this.abc = abc;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

}
