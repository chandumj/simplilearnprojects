package corejava.PracticeProject;

public class Square extends Shape{
	private int length;

	public Square(int length) {
		this.length = length;
	}
	private double calculateArea()
	{
		return length*length;
	}
	
	public void displayArea()
	{
		System.out.println( "The area of square is:" + calculateArea());
	}

}
