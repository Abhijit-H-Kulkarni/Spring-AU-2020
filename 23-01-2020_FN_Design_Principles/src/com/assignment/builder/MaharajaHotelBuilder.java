package com.assignment.builder;

public class MaharajaHotelBuilder implements HotelBuilder {

	private Hotel hotel;

	@Override
	public void buildNumberOfFloors() {
		hotel.setNumberOfFloors("100");
	}

	@Override
	public void buildRoomType() {
		hotel.setRoomType("FirstClass");
	}

	@Override
	public void buildNumberOfRoomsPerFloor() {
		hotel.setNumberOfRoomsPerFloor("100");
	}

	@Override
	public void buildParking() {
		hotel.setParkingType("Large");
	}

	@Override
	public Hotel getHotel() {
		return this.hotel;
	}
	
}
