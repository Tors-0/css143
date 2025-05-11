import java.util.ArrayList;
/*
 * Driver
 * Lab 
 * 
 * A simple driver to exercise the Employee hierarchy
 *
 * Trying to add a ColorWithAlpha to the Employee list creates an inconvertible types error
 * this could be fixed by changing the list to type Object instead of Employee
 *
 * The calculateWeeklyPay method is polymorphic, because every class has a different implementation
 *
 * you could have an array of the classnames, and use the .invoke method on a Method object to call the getRandomX() method for a random class
 *
 * Employee randomResult = Employee.getRandomEmployee();
 * double weeklyPay = randomResult.calculateWeeklyPay();
 */

public class EmployeeDriver {
	
	
	public static void main(String[] args) {
		Accountant emp1 = new Accountant( "Rick", 123456789);
		//this next employee makes a bit more than Rick
		Accountant emp2 = new Accountant( "Tim", 55555555,10000);
		//and lets make an hourly worker
		HourlyWorker emp3 = new HourlyWorker( "Jim", 11111111);
		//then a salaried worker
		SalariedWorker emp4 = new SalariedWorker( "Jane", 222222222, 5000);
		HourlyWorker emp5 = new HourlyWorker( "Joe", 11111111,20);
		
		//todo: Build some PermanentHire and Consultant objects here
		//and add them to the ArrayList below
		SalariedWorker emp6 = new PermanentHire("Horace", 238756248);
		ColorWithAlpha color = new ColorWithAlpha(255);
		Consultant emp7 = new Consultant("Jerry", 25425345);
		Consultant emp8 = new Consultant("Jeremy", 254253455);

		//and build a set of workers, all of which are employees
		ArrayList<Employee> myEmployees = new ArrayList<Employee>();
		
		myEmployees.add(emp1);
		myEmployees.add(emp2);
		myEmployees.add(emp3);
		myEmployees.add(emp4);
		myEmployees.add(emp5);
		myEmployees.add(emp6);
		myEmployees.add(emp7);
		myEmployees.add(emp8);
//		myEmployees.add(color);
		//todo: add a sixth and seventh employee to this list that you create
		
		
		//this code doesn't need to change, even if you add 10 new employee classes and 
		//add 102 new employees - this is an example of generic code that can be written 
		//when inheritance hierarchies are in use
		for( int i = 0; i < myEmployees.size(); i++) {
			Employee current = myEmployees.get(i);
			System.out.println( current.getName() + " makes " + current.calculateWeeklyPay() + " per week.");
		}
		
		
	}
}
