package com.mindtree.hotelbookingapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


import com.mindtree.hotelbookingapp.Util.DBUtil;
import com.mindtree.hotelbookingapp.dao.HotelDao;
import com.mindtree.hotelbookingapp.entity.Hotel;
import com.mindtree.hotelbookingapp.entity.Room;
import com.mindtree.hotelbookingapp.exception.NoSuchCityException;

public class HotelDaoImpl implements HotelDao{
	static DBUtil dbUtil=new DBUtil();
	@Override
	public boolean insertRoomInDB(Room room) {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
			String insertQuery = "insert into room values(?,?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1,room.getRoomNum());
			ps.setString(2,room.getRoomType()); 
			ps.setDouble(3,room.getPrice());
			ps.setInt(4,room.getHotelId());

			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public void getAllHotelsDB(String city) throws NoSuchCityException{
		//Set<Hotel> hotels=new LinkedHashSet();
		String pCity=city;
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
		//	con = dbUtil.getMyConnection();
		//	String selectQuery = String.format("select * from hotel where city = ?");//"select * from hotel where city ;";
		//  String selectQuery = "select * from hotel inner join room on hotel.hotelId=room.hotelId;";// where city=?;"; 
		//	ps = con.prepareStatement(selectQuery);
			ps=dbUtil.getMyConnection().prepareStatement("select * from hotel inner join room on hotel.hotelId=room.hotelId where city=?");
			ps.setString(1,city);
			rs = ps.executeQuery();			
			while (rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+ rs.getInt(4)+"\t"+ rs.getString(5)+"\t"+rs.getDouble(6));
			}		
	/*		if(rs.next()==false) {
			try {
			throw new NoSuchCityException();
			}
			catch(NoSuchCityException exp) {
				System.out.println("Catch block entered");
				//System.out.println();
			}
			}
*/			}
			catch(SQLException e) {
				System.out.println("Something went wrong");
			}
			finally {
			dbUtil.closeResource(rs);
			dbUtil.closeResource(con);
		}	
		
	}

	@Override
	public boolean insertHotelInDB(Hotel hotel) {
		boolean isInserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbUtil.getMyConnection();
	
			String insertQuery = "insert into hotel values(?,?,?);";
			ps = con.prepareStatement(insertQuery);

			ps.setInt(1,hotel.getHotelId());
			ps.setString(2,hotel.getHotelName()); 
			ps.setString(3,hotel.getCity());
			

			ps.execute();
			isInserted = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeResource(ps);
			dbUtil.closeResource(con);
		}
		return isInserted;

	}

}
