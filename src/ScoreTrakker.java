import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;


public class ScoreTrakker {
	private ArrayList<Student> students;
	
	private void loadDataFromFile() {
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
			System.out.println("File not Found");
		}
		Scanner in = new Scanner(reader);
		
		while (in.hasNext()){
			String line = in.next();	
			String[] temp = line.split(" ");
			String name = temp[0] + " " + temp[1];
			int score = Interger.valueOf(temp[2]);
			Student student = new Student(name, score)
			}
		
	}
	
	private void printInOrder() {
		
	}
	
	private void processFiles() {
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.loadDataFromFile();
	}
	
	
}
