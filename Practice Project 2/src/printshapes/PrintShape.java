package printshapes;
import java.util.ArrayList;

import corejava.PracticeProject.Rectangle;
import corejava.PracticeProject.Shape;
import corejava.PracticeProject.Square;

public class PrintShape {

	public static void main(String[] args) {
		
		ArrayList<Shape> shapes=new ArrayList<Shape>();
		shapes.add(new Square(20));
		shapes.add(new Rectangle(20, 30));
		shapes.add(new Shape());

		try {
		for(Shape shape: shapes)
		{
			shape.displayArea();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("program executed Successfully");
		}
	}

}
