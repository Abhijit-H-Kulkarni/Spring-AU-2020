package models;

public class Point {
	int x,y;
	public Point(){
		
	}
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void Display() {
		System.out.println("X : "+this.x+" Y : "+this.y);
	}
}
