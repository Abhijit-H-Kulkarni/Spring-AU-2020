package com.assignment.builder;

public class MainClass {
	public static void main(String[] args) {
	HotelBuilder shantiSagarHotelBuilder = new ShantiSagarHotelBuilder();
	Engineer engineer = new Engineer(shantiSagarHotelBuilder);
	engineer.ConstructHotel();
	System.out.println("Details of Hotel Constructed"+engineer.getHotel());
	}
}
