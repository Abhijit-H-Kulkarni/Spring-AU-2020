package com.assignment.builder;

public class ShantiSagarHotelBuilder implements HotelBuilder {
	private Hotel hotel;

	@Override
	public void buildNumberOfFloors() {
		hotel.setNumberOfFloors("5");
	}

	@Override
	public void buildRoomType() {
		hotel.setRoomType("Third Class");
	}

	@Override
	public void buildNumberOfRoomsPerFloor() {
		hotel.setNumberOfRoomsPerFloor("5");
	}

	@Override
	public void buildParking() {
		hotel.setParkingType("Small");
	}

	@Override
	public Hotel getHotel() {
		return this.hotel;
	}
	

}
