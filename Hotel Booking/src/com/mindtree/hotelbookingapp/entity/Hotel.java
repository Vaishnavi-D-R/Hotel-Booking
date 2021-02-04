package com.mindtree.hotelbookingapp.entity;

import java.util.List;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String city;
//	private List<Room> rooms;
	
	public Hotel() {
		super();
	}
	
	
	public Hotel(int hotelId, String hotelName, String city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}


	/*public Hotel(int hotelId, String hotelName, String city, List<Room> rooms) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		city = city;
		this.rooms = rooms;
	}*/
	
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
