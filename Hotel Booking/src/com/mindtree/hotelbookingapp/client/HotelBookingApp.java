package com.mindtree.hotelbookingapp.client;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.hotelbookingapp.entity.Hotel;
import com.mindtree.hotelbookingapp.entity.Room;
import com.mindtree.hotelbookingapp.exception.NoSuchCityException;
import com.mindtree.hotelbookingapp.service.HotelService;
import com.mindtree.hotelbookingapp.service.impl.HotelServiceImpl;

public class HotelBookingApp {
	static HotelService service=new HotelServiceImpl();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws NoSuchCityException {
		System.out.println("*******************WELCOME***********************");
		int choice=0;
		do {System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter your choice: ");
			displayMenu();
			choice=sc.nextInt();
			switch(choice) {
			case 1:// Insert hotel
					createHotel();
					break;
				
			case 2:// Delete employee
					createRoom();
					break;
					
			case 3:// Display hotel information in the given city
					try {
					getHotelInfo();
					}
					catch(NoSuchCityException e) {
						System.out.println(e.getLocalizedMessage());
					}
					break;
					
			case 4: System.exit(0);
					break;
					
			default:System.out.println("Invalid choice");
					break;
			}
		}while(choice!=4);
	}

	private static void getHotelInfo() throws NoSuchCityException {
		sc.nextLine();
		System.out.println("Enter your city ");
		String city=sc.nextLine();
		try {
		service.getAllHotelsFromDB(city);
		}
		catch(NoSuchCityException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static void createRoom() {
		boolean isRoomAssigned=false;
		//List<Room> list=new ArrayList();
		Room room=new Room();
		room=getCreatedRoom();
		try {
			isRoomAssigned=service.insertRoomInDB(room);
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		if(isRoomAssigned) {
			System.out.println("Successfully assigned room");
		}
		else {
			System.out.println("Cannot create room");
		}
	}

	private static Room getCreatedRoom() {
		System.out.println("Enter hotel id");
		int id=sc.nextInt();
		System.out.println("Enter room number");
		int num=sc.nextInt();
		System.out.println("Enter room type(luxury,semiluxury,deluxe)");
		sc.nextLine();
		String type=sc.nextLine();
		System.out.println("Enter room cost");
		double price=sc.nextDouble();
		Room room=new Room(num, type, price,id);
		return room;
	}

	private static void createHotel() {
		boolean isHotelCreated=false;
		//List<Room> list=new ArrayList();
		Hotel hotel=new Hotel();
		hotel=getCreatedHotel();
		try {
			isHotelCreated=service.insertHotelInDB(hotel);
		}
		catch(Exception e) {
			System.out.println("Somethind went wrong");
		}
		if(isHotelCreated) {
			System.out.println("Successfully assigned room");
		}
		else {
			System.out.println("Cannot create room");
		}
		
	}

	private static Hotel getCreatedHotel() {
		System.out.println("Enter hotel id: ");
		int id=sc.nextInt();
		System.out.println("Enter hotel name:");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter city");
		String city=sc.nextLine();
		Hotel hotel=new Hotel(id,name,city);
		return hotel;
	}

	private static void displayMenu() {
		System.out.println("1.Create Hotel (Add to database)");
		System.out.println("2.Create Room and Assign to hotel");
		System.out.println("3.Display all hotel information in the given city");
		System.out.println("4.Exit");
	}
	

	}

