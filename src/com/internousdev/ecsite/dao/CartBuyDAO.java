package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartBuyDAO {

	DateUtil du = new DateUtil();

	public void cartbuy(String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id,pay, insert_date) select item_transaction_id, total_price, total_count, user_master_id,pay, insert_date from cart where user_master_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public void cartdelete(String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from cart where user_master_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

}
