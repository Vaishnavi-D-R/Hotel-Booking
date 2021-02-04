package com.mindtree.hotelbookingapp.entity;

public class Room {
	private int roomNum;
	private String roomType;
	private double price;
	private int hotelId;
	
	public Room() {
		super();
	}
	
	public Room(int roomNum, String roomType, double price, int hotelId) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.price = price;
		this.hotelId=hotelId;
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	
}
