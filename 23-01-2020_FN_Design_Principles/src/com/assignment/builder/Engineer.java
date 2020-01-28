package com.assignment.builder;

public class Engineer {
	private HotelBuilder hotelBuilder;
	
	public Engineer(HotelBuilder hotelBuilder) {
		this.hotelBuilder = hotelBuilder;
	}
	public Hotel getHotel() {
		return this.hotelBuilder.getHotel();
	}
	
	public void ConstructHotel() {
		this.hotelBuilder.buildNumberOfFloors();
		this.hotelBuilder.buildNumberOfRoomsPerFloor();
		this.hotelBuilder.buildParking();
		this.hotelBuilder.buildRoomType();
	}
}
