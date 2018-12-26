package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListNumberDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public int number()throws SQLException{

		String sql ="select count(*) from login_user_transaction";
		int num = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				num = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return num;
	}

}
