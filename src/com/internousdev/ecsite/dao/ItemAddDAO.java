package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemAddDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemAddDAO {

	public ItemAddDTO getAdd(String id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ItemAddDTO dto = new ItemAddDTO();

		String sql = "select item_stock from item_info_transaction where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setItemStock(rs.getInt("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;
	}

	public void getStock(int total,String id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update item_info_transaction set item_stock = ? where id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, total);
			ps.setString(2,id);

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}



}
