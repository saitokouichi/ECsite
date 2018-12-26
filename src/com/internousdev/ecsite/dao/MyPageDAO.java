package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> mypageDTO = new ArrayList<MyPageDTO>();
		String sql = "select iit.id, iit.item_name, ubit.total_price, ubit.total_count,ubit.pay, ubit.insert_date from user_buy_item_transaction ubit left join item_info_transaction iit on ubit.item_transaction_id = iit.id where ubit.user_master_id = ? order by insert_date";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
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


	public int buyItemHistoryDelete(String user_master_id) throws SQLException{
		String sql = "delete from user_buy_item_transaction where user_master_id = ?";

		PreparedStatement ps;
		int result = 0;
		try{
			ps = con.prepareStatement(sql);
//			ps.setString(1, item_transaction_id);
			ps.setString(1, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

	public ArrayList<MyPageDTO> getUserInfo(String login_id) throws SQLException{
		ArrayList<MyPageDTO> mypageDTO = new ArrayList<MyPageDTO>();
		String sql = "select * from login_user_transaction where login_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setLoginId(rs.getString("loginId"));
				dto.setLoginPass(rs.getString("loginPass"));
				dto.setUser(rs.getString("user"));
				mypageDTO.add(dto);
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			con.close();
		}
		return mypageDTO;
	}

}

