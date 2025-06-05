import java.io.Serializable;

public class Student implements Comparable<Student>, Cloneable, Serializable {
	private double gpa;
	private String name;

	public double getGPA() {
		return gpa;
	}

	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name, double gpa) {
		this.gpa = gpa;
		this.name = name;
	}

	public Student(Student other) {
		this.gpa = other.gpa;
		this.name = other.name;
	}

	@Override
	public int compareTo(Student o) {
		double diff = this.gpa - o.gpa;
		return (int) (diff / Math.abs(diff));
	}

	@Override
	public Object clone() {
		return new Student(this);
	}
}
