package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	DateUtil du = new DateUtil();

	String sql = "insert into item_info_transaction(item_name,item_price,item_stock,insert_date)values(?,?,?,?)";

	public void createItem(String productName, String nedan, String stock)throws SQLException{

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productName);
			ps.setString(2, nedan);
			ps.setString(3, stock);
			ps.setString(4, du.getDate());

			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}


}
