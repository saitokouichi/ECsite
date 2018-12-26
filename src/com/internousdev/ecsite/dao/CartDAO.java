package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartDAO {

	DateUtil du = new DateUtil();

	String sql = "insert into cart(item_transaction_id, total_price, total_count, user_master_id,pay, insert_date)values(?,?,?,?,?,?)";

	public void cartInto(String item_transaction_id, String user_master_id,String total_price, String total_count, String pay) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into cart(item_transaction_id, total_price, total_count, user_master_id,pay, insert_date)values(?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, du.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public void cartDelete(String user_master_id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="delete from cart where user_master_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public void cartSelectDelete(String id2) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from cart where id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id2);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
