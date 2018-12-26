package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.ItemListNumberDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	private ArrayList<ItemInfoDTO> itemInfoList = new ArrayList<ItemInfoDTO>();
	ItemListDAO dao = new ItemListDAO();
	ItemListNumberDAO ndao = new ItemListNumberDAO();
	private int num;

	public String execute()throws SQLException{
		String result = "login";

		itemInfoList = dao.getItemInfo();
		session.put("itemInfoList", itemInfoList);
		num = ndao.number();

		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public Map<String,Object> getSession(){
		return this.session;
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
