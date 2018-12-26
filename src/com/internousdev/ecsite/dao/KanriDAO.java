package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.KanriDTO;
import com.internousdev.ecsite.util.DBConnector;

public class KanriDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	KanriDTO dto = new KanriDTO();

	public KanriDTO getKanrisya(String Kname,String Kpass) throws SQLException{

		String sql="select * from kanrisya where name=? and pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Kname);
			ps.setString(2, Kpass);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setKid(rs.getInt("id"));
				dto.setKname(rs.getString("name"));
				dto.setKpass(rs.getString("pass"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return dto;
	}

}