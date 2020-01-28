package com.assignment.builder;

public class Hotel implements HotelPlan {
	private String numberOfFloors;
	private String numberOfRoomsPerFloor;
	private String roomType;
	private String parkingType;
	@Override
	public void setNumberOfFloors(String numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	@Override
	public void setNumberOfRoomsPerFloor(String numberOfRoomsPerFloor) {
		this.numberOfRoomsPerFloor = numberOfRoomsPerFloor;
	}

	@Override
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

}
