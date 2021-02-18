//Authors: Aaron Aranda and Lauren Loe
import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;    //Used only in part 1

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscores.txt", "nofile.txt" };

    private void loadDataFromFile(String file) throws FileNotFoundException {
        students = new ArrayList<Student>(10);		
        FileReader reader = new FileReader(file);
        Scanner in = new Scanner(reader);
    	while (in.hasNext()) {
            Student student = null;
       	    String name = in.nextLine();	
            String stringScore = in.nextLine();
            int score = 0;
            try {
                score = Integer.parseInt(stringScore);
                student = new Student(name, score);
                students.add(student);
            } catch (NumberFormatException n) {
                System.out.println("Incorrect format for " + name + 
                        " not at a valid score: " + stringScore);
            }      		
        }
    }

	private void printInOrder() {
        for (Student s : students) {
            if (s != null) {
            System.out.println(s.toString());
            } 
    	}
    }
	
	public void processFiles() {
        for (String f: files) {
            try {
                loadDataFromFile(f);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("Can't open file: " + f);
            }       
        }
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
