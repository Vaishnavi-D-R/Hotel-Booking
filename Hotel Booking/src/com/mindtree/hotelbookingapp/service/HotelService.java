package com.mindtree.hotelbookingapp.service;

import java.util.Set;

import com.mindtree.hotelbookingapp.entity.Hotel;
import com.mindtree.hotelbookingapp.entity.Room;
import com.mindtree.hotelbookingapp.exception.NoSuchCityException;

public interface HotelService {

	boolean insertRoomInDB(Room room);

	void getAllHotelsFromDB(String city) throws NoSuchCityException;

	boolean insertHotelInDB(Hotel hotel);

}
