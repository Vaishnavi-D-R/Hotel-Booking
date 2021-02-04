package com.mindtree.hotelbookingapp.dao;

import java.util.Set;

import com.mindtree.hotelbookingapp.entity.Hotel;
import com.mindtree.hotelbookingapp.entity.Room;
import com.mindtree.hotelbookingapp.exception.NoSuchCityException;

public interface HotelDao {

	boolean insertRoomInDB(Room room);

	void getAllHotelsDB(String city) throws NoSuchCityException;

	boolean insertHotelInDB(Hotel hotel);

}
