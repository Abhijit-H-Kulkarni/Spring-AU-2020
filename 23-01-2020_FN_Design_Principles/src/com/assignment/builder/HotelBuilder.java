package com.assignment.builder;

public interface HotelBuilder {
	public void buildNumberOfFloors();
	public void buildRoomType();
	public void buildNumberOfRoomsPerFloor();
	public void buildParking();
	public Hotel getHotel();
}
