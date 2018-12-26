package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	DateUtil du = new DateUtil();

	String sql = "insert into user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id,pay, insert_date)values(?,?,?,?,?,?)";

	public void buyItemInfo(String item_transaction_id, String user_master_id,String total_price, String total_count, String pay) throws SQLException{
//		()内はBuyItemConfirmActionと同じ順番
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, du.getDate());
//			上のinsert文と同じ順番

			ps.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
