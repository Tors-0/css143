import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Comparable<Student> {
	private double gpa;
	private String name;
	
	public Student(String name, double gpa) {
		this.gpa = gpa;
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		double diff = this.gpa - o.gpa;
		return (int) (diff / Math.abs(diff));
	}
}
