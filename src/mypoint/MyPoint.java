package mypoint;

public class MyPoint {

   // X & Y are called all 3 of these:
   //    1) instance fields
   //    2) member variables
   //    3) properties
   //
   // MyPoint objects HAVE these. "MyPoint HAS-A x and y."
   // These define an object's STATE.
   // Step 3: Make these private
   private int x;
   private int y;

   public double getDistanceToOrigin() {
      return Math.sqrt(x*x + y*y);
   }

   public int getY() {
      return y;
   }

   public int getX() {
      return x;
   }

   public void setY(int y) {
      this.y = y;
   }

   public void setX(int x) {
      this.x = x;
   }

   
   // Step 2: Create a pretty print in the MyPoint class
   // coordinates nicely: (x, y).
   // Use the String.format() method to generate the String.
   @Override
   public String toString() {
      return String.format("(%d, %d)", this.x, this.y);
   }
      
   // Step 4:
   // The MyPoint constructor is not here... yet.
   // This means that we have an implicit, DEFAULT constructor.
   // The default constructor has no parameters.
   // When we supply any constructor, the compiler will decide
   // to NOT provide the (implicit) default constructor.
   // So, we would then have to write a parameterless constuctor if we want it.

   public MyPoint(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public MyPoint() {}
   
   // Create an explicit default constructor. This will allow someone
   // to create an empty point with: MyPoint pt = new MyPoint();
   
   // CHALLENGE:
   // Create an overloaded constructor that takes a single argument
   // which is the distance to the origin. It will create a random point
   // that is that is very close to that far from the origin. (Since we have
   // integer coordinates, there will be some error.)
   
   // Step 5: 
   // TODO: Give each MyPoint a property that is the distance to
   // the origin. We don't want the user to set this property, only get it.
   // In fact, it won't even be an instance field at all. Instead, we will
   // ALWAYS calculate the value whenever the user wants it. 
   // We call this "Lazy Evaluation."
   // The user can get the value (of type double) with: getDistanceToOrigin().
   // Use the Pythagorean's Theorem to calculate the value.
   
   // An analogy: 
   // A student will have an instance field to store their high
   // score on Mario Bros. Their score is a property of the student.
   // A student will use lazy evaluation to calculate how far away they
   // are from their PlayStation. Their distance is a property of the student.



   
}