import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 *
 * Author: Rob Nash
 */


class PolyDemo extends JFrame {


	public PolyDemo() {
		getContentPane().add( new PolyDemoPanel() );
		//just some windowing stuff that must happen for all Frames
		setSize( 500,500 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}


	public static void main( String args[] ) {
		PolyDemo myApp = new PolyDemo();
	}


	//this is our first "inner" or internal class 
	//the purpose of this class is solely to support the JFrame class above, and I don't want it reused in arbitrary contexts, so by nesting this class here
	//I can indicate the intent a bit more clearly that this class "goes with" the class above it
	//In general, each class is a separate entity that should be contained in a separate file
	public class PolyDemoPanel extends JPanel {
		Shape[] myShapes= new Shape[20];

		public PolyDemoPanel() {
			//Shape a = new Shape( getRandInt(), getRandInt());
			//Shape b = new Circle( getRandInt(), getRandInt(), getRandInt() );

			//a = new Square(getRandInt(), getRandInt(), getRandInt(), getRandInt() );

			//a = getRandShape();

			//( (Circle) b ).getRadius();


			/*********************************************************************************************************************
			 * Code for populating our myShapes changes minimally when new classes are introduced (only in getRandShape())
			 *********************************************************************************************************************/
			for( int i = 0; i < 20; i++ ) {
				myShapes[i] =  getRandShape();
			}
		}

		/*********************************************************************************************************************
		 * Code for drawing our shapes doesn't change at all! Since we intended to take advantage of polymorphism, we coded 
		 * this "in general" with respect to the superclass, and not specific to any subclass.
		 *********************************************************************************************************************/
		public void paint( Graphics g ) {
			super.paint(g);  //don't remove - required for GUI widgets to draw correctly
			/************************
			 * Late Binding Demo
			 ************************/
			for( int i = 0; i < myShapes.length; i++ ){
				//which draw method is invoked here? There are many forms of the method (polymorphic), so which is chosen?
				//Java has RTTI about every object, and it uses this info to choose the correct method to invoke!
				myShapes[i].draw( g );
			}
		}


		public int getRandInt() {
			return ( (int) ( Math.random() * 400 ) );
		}

		public Shape getRandShape() {
			Shape retVal = null;
			final int x = getRandInt();
			final int y = getRandInt();


			/********************************
			 * Polymorphic extensibility demo
			 *
			 *******************************/
			//new Cylinder( x,y, getRandInt(), getRandInt() );
			retVal = switch ((int) (Math.random() * 5)) {
				case 0 -> new Spray(x, y);//new Square( x, y, getRandInt(), getRandInt() );
				case 1 -> new Cube(x, y, getRandInt() / 2);
				case 2 -> new Spray(x, y);
				case 3 -> new Circle(x, y, getRandInt() / 2);
				case 4 -> new FractalFlake(x, y, 400, 7);
				default -> retVal;
			};

			return retVal;
		}
	}

}











