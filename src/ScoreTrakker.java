import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;


public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscores.txt", "nofile.txt" };

	private void loadDataFromFile() {
        students = new ArrayList<Student>(10);

        //File Handling
        for (String f: files) {
           FileReader reader = null;
           Scanner in = null;
           try {
	           reader = new FileReader(f);
		       in = new Scanner(reader);
		   } catch (FileNotFoundException e) {
	           System.out.println("Can't open file: " + f);
               continue;
           }
            
		
            //Data Collection
       
	    	while (in.hasNext()) {
                Student student;
        	    String name = in.nextLine();	
                String stringScore = in.nextLine();
                int score = 0;
                try {
                    score = Integer.parseInt(stringScore);
                } catch (NumberFormatException n) {
                    System.out.println("Incorrect format for " + name + 
                            " not at a valid score: " + stringScore);
                }      		
    		student = new Student(name, score);       
            students.add(student);
	    }
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
