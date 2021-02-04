package com.mindtree.hotelbookingapp.service.impl;

import java.util.Set;

import com.mindtree.hotelbookingapp.dao.HotelDao;
import com.mindtree.hotelbookingapp.dao.impl.HotelDaoImpl;
import com.mindtree.hotelbookingapp.entity.Hotel;
import com.mindtree.hotelbookingapp.entity.Room;
import com.mindtree.hotelbookingapp.exception.NoSuchCityException;
import com.mindtree.hotelbookingapp.service.HotelService;

public class HotelServiceImpl implements HotelService{
	static HotelDao dao=new HotelDaoImpl();
	@Override
	public boolean insertRoomInDB(Room room) {
		try {
			return dao.insertRoomInDB(room);
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		return false;
	}

	@Override
	public void getAllHotelsFromDB(String city) throws NoSuchCityException {
		try {
			dao.getAllHotelsDB(city);
		}
		catch(NoSuchCityException e) {
			//throw new NoSuchCityException();
			throw new NoSuchCityException("No such city",e);
		}
	}

	@Override
	public boolean insertHotelInDB(Hotel hotel) {
		try {
			return dao.insertHotelInDB(hotel);
		}
		catch(Exception e) {
			System.out.println("Something went wrong");
		}
		return false;
	}

}
