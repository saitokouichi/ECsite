package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public int deleteItem()throws SQLException{

		String sql ="delete from item_info_transaction";
		int result = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}

}
