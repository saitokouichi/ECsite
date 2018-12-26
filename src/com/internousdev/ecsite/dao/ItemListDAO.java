package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ArrayList<ItemInfoDTO> getItemInfo()throws SQLException{
		ArrayList<ItemInfoDTO> iteminfoDTO = new ArrayList<ItemInfoDTO>();
		String sql = "select * from item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setPuroductName(rs.getString("item_name"));
				dto.setNedan(rs.getString("item_price"));
				dto.setStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));

				iteminfoDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return iteminfoDTO;
	}

}
