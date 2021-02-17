import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;


public class ScoreTrakker {
	private ArrayList<Student> students;
	
	private void loadDataFromFile() {
        //File Handling
		FileReader reader = null;
		String fileName = null;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selected = fileChooser.getSelectedFile();
			fileName = selected.getAbsolutePath();
		}
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fileName);
		}
		Scanner in = new Scanner(reader);
		
        //Data Collection
        students = new ArrayList<Student>(10);
		while (in.hasNext()) {
            Student student;
        	String name = in.nextLine();	
	    	String num = in.nextLine();
            int score = 0;
            try {
                score = Integer.parseInt(num);
            } catch (NumberFormatException n) {
                System.out.println("Incorrect format for " + name + 
                        " not at a valid score: " + score);
            }   		
    		student = new Student(name, score);       
            students.add(student);
	    }
    }
	
	private void printInOrder() {
        for (Student s: this.students) {
            if (s != null) {
            System.out.println(s.toString());
            } 
    	}
    }

	
	private void processFiles() {
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.loadDataFromFile();
        trakker.printInOrder();
	}
	
	
}
