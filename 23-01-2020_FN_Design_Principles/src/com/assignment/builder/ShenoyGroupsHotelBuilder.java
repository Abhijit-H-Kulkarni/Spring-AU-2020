package com.assignment.builder;

public class ShenoyGroupsHotelBuilder implements HotelBuilder {
	private Hotel hotel;

	@Override
	public void buildNumberOfFloors() {
		hotel.setNumberOfFloors("1000");
	}

	@Override
	public void buildRoomType() {
		hotel.setRoomType("Five Star");
	}

	@Override
	public void buildNumberOfRoomsPerFloor() {
		hotel.setNumberOfRoomsPerFloor("500");
	}

	@Override
	public void buildParking() {
		hotel.setParkingType("Very Large");
	}

	@Override
	public Hotel getHotel() {
		return this.hotel;
	}
	

}
