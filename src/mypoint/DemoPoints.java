package mypoint;

import java.util.Arrays;

public class DemoPoints {

    public static void main(String[] args) {
        DemoPoints.runStep(6);
    }
    
    public static void runStep(int stepNumber) {

        MyPoint[] arr;
        // create and print an array of points
        if (stepNumber < 4) {
            arr = createTheLongWay();
        } else {
            arr = createWithShorthand();
        }
        System.out.println("An array filled with points looks like this:");
        System.out.println(Arrays.toString(arr));
        
        if (stepNumber == 5) {
            calculateDistanceToOrigin(arr);
        } else if (stepNumber > 5) {
            askForDistanceToOrigin(arr);
        }
    }

    // This creates an array of MyPoint objects using the longhand notation.
    public static MyPoint[] createTheLongWay() {

        // Create an array of MyPoint objects. It starts off empty!
        MyPoint[] myPoints = new MyPoint[3];

        // print the array of points to see that it's devoid of values. So sad.
        System.out.println("An empty array looks like this:");
        System.out.println(Arrays.toString(myPoints));

        // let's add MyPoint objects into the array
        for (int index = 0; index < myPoints.length; index++) {
            // create a MyPoint object by using MyPoint's Default Constructor
            MyPoint pt = new MyPoint();

            // set the point's fields with values
            // STEP 1:
            pt.setX((int) (Math.random() * 100));
            pt.setY((int) (Math.random() * 100));

            // add the point into the array
            // STEP 1:
            myPoints[index] = pt;
        }

        return myPoints;
    }

    // create an array of MyPoint objects the fast way!
    // This requires a MyPoint(x, y) constructor.
    public static MyPoint[] createWithShorthand() {
        MyPoint[] myPoints = { new MyPoint(1, 2), new MyPoint(3, 4), new MyPoint(5, 6) };


        // return myPoints when the above works
        return myPoints;
    }
    

    public static void calculateDistanceToOrigin(MyPoint[] points) {
        for (MyPoint pt : points) {
            
            double distance;
            // STEP 5A:  
            // ask the point for its distance to the origin
            // int x = pt.getX(); int y = pt.getY(); 
            // Then calculate the distance = ...
            int x = pt.getX();
            int y = pt.getY();
            distance = Math.sqrt(x*x + y*y); // pythagorean theorem
            
            System.out.printf("Pt %s is %.2f from the origin\n", pt, distance);
        }
    }

    public static void askForDistanceToOrigin(MyPoint[] points) {
        for (MyPoint pt : points) {
            // replace the value once the method getDistanceToOrigin is implemented
            double distance = pt.getDistanceToOrigin();
            // ask the point for its distance to the origin
            // STEP 5B:  distance = pt.getDistanceToOrigin();
            System.out.printf("Pt %s is %.2f from the origin\n", pt, distance);
        }
    }
}