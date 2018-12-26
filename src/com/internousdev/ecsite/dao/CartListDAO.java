package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartListDAO {

	public ArrayList<MyPageDTO> getCartList(String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> mypageDTO = new ArrayList<MyPageDTO>();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select cart.id as id2,iit.id, iit.item_name, cart.total_price, cart.total_count, cart.pay, cart.insert_date from cart left join item_info_transaction iit on cart.item_transaction_id = iit.id where cart.user_master_id = ? order by insert_date";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId2(rs.getString("id2"));
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				mypageDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return mypageDTO;
	}

	public int getCartPrice(String user_master_id) throws SQLException{
		int cartPrice = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select sum(total_count * total_price) as cartPrice from cart where user_master_id=? group by user_master_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,user_master_id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				cartPrice = rs.getInt("cartPrice");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartPrice;
	}

}
