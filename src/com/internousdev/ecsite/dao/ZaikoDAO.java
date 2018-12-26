package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ZaikoDAO {

	public void getStock(int last,String id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update item_info_transaction set item_stock = ? where id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, last);
			ps.setString(2,id);

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}

}
