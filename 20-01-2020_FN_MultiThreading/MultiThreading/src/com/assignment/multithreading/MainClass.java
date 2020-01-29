package com.assignment.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random; 

public class MainClass extends Thread {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		Map<String, Integer> market = new HashMap<>();
		Runnable run1 = () ->{
			String fruitChosen;
			while(true) {
			Random rand = new Random(); 
			fruitChosen = fruits.get(rand.nextInt(fruits.size()));
			try {
				synchronized (fruitChosen) {
					int currentNumberOfFruits = (int)market.get(fruitChosen);
					if(currentNumberOfFruits == 2) {
						fruitChosen.wait();
						System.out.println("Max limit reached for the chosen fruit. Wait for consumer to buy fruits.");
						Thread.sleep(1000);
					}
					else {
					currentNumberOfFruits += 1;
					System.out.println("Producer adding fruit : "+fruitChosen+" to the market.");
					market.put(fruitChosen, currentNumberOfFruits);
					}
					fruitChosen.notify();
					System.out.println("Market : "+market);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		};
		
		Runnable run2 = () ->{
			String fruitChosen;
			Random rand = new Random();
			int currentNumberOfFruits;
			while(true) { 
				fruitChosen = fruits.get(rand.nextInt(fruits.size()));
				try {
					synchronized (fruitChosen) {
						currentNumberOfFruits = (int)market.get(fruitChosen);
						if(currentNumberOfFruits <= 0) {
							fruitChosen.wait();
							System.out.println("Fruit "+fruitChosen+" not in the market. Wait until producer produces it.");
							Thread.sleep(1000);
						}
						else {
						System.out.println("Consumer buying fruit : "+fruitChosen+" from the market.");
						currentNumberOfFruits -= 1;
						market.put(fruitChosen, currentNumberOfFruits);
						}
						fruitChosen.notify();
						System.out.println("Market : "+market);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		fruits.add("A");
		fruits.add("B");
		fruits.add("C");
		fruits.add("D");
		
		market.put("A", 0);
		market.put("B", 0);
		market.put("C", 0);
		market.put("D", 0);
		
		Thread producer1 = new Thread(run1);
		Thread producer2 = new Thread(run1);
		
		Thread consumer1 = new Thread(run2);
		Thread consumer2 = new Thread(run2);
		
		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();
	}
}
