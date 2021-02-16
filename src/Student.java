
public class Student implements Comparable<Student> {
	private String name;
	private int score;

	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	
	public int compareTo(Student other) {
		return this.score > other.score ? 1 : this.score < other.score ? -1 : 0;
	}
	
	@Override
	public String toString() {
		//Not sure if this will work
		return (this.name + " " + this.score); 
	}
	
	
}
