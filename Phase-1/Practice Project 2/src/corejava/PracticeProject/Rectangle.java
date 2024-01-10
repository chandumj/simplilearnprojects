package corejava.PracticeProject;

public class Rectangle extends Shape {
	private int length;
	private int width;
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	private double calculateArea()
	{
		return length*width;
	}
	
	public void displayArea()
	{
		System.out.println( "The area of Rectangle is:" + calculateArea());
	}
}
