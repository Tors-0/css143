
public class FractionContainer implements Comparable<FractionContainer>{

   private Fraction fraction;
   
   // The count of fractions we are holding/containing
   private int count;
   
   // This method is a gift from Mr. Stride to the student.
   // It is a static method that implements Comparator<> that can be used
   // to help FractionTracker sort in ascending order by the count.
   // Example usage: arr.sort(FractionContainer::compareAscendingByCount);
   public static int compareAscendingByCount(FractionContainer fc1, FractionContainer fc2) {
      // if our count is equal, then use the fraction value
      if (fc1.count == fc2.count) {
         return fc1.compareTo(fc2);
      }
      
      // just use the count
      return fc1.count - fc2.count;
   }
   
   @Override
   public int compareTo(FractionContainer o) {
      // TODO 
      return 0;
   }
 
}