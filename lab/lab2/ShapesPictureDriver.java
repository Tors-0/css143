/**
 * Driver for CSS 143 Lab
 *
 * uncomment sections to test Square and Picture
 *
 * @author Rob Nash
 */


public class ShapesPictureDriver {


	//precondition: assumes {Square and Picture} all exist in the same working directory
	//postcondition: 2 Squares and 1 Picture are constructed and manipulated, then reclaimed once main exits
	public static void main(String[] args) {

		Square firstSquare = new Square();
		Square secondSquare = new Square(10,20);

		firstSquare.setX(3);
		firstSquare.setY(4);

		System.out.println( "Drawing the first square : " + firstSquare.toString());

		firstSquare.draw();

		secondSquare.setWidth(30);
		secondSquare.setHeight(30);

		System.out.println( "Drawing the next square with area : " + secondSquare.getArea());

		secondSquare.draw();
		Circle firstCircle = new Circle();
		Circle secondCircle = new Circle();



//		 Uncomment for Picture Tests
		//now, lets see the bigger picture
		ObjectList picture = new ObjectList();

		picture.add( firstSquare );
		picture.add( secondSquare );
		picture.add( firstCircle );
		picture.add( secondCircle );

		System.out.println( "Drawing a Picture using ObjectList with Circles and Squares:\n" );

		System.out.println(picture.toString());

	}

}
