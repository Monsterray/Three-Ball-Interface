

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;


public class ThreeBall{

	public String[][] playersScores;

	public ThreeBall(){
		loadPlayers();
		
		System.out.println("Three Ball scorer loaded");
	}

	public void loadPlayers(){ // Doesn't work started never finished
		File f = new File("./Highscores.TSM");
		
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] Couldn't find Highscores.TSM file!");
			System.out.println("[INFO] Trying to create Highscores.TSM!");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				System.out.println("[ERROR] Couldn't Create Highscores.TSM file!");
			}
			System.out.println("[INFO] Created Highscores.TSM!");
		}
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("#")) // If it finds a line that begins with a # it will skip that line, its like a comment
				continue;
			
			StringTokenizer normalTok = new StringTokenizer(line, "\t"); // Every tab it will take in the next variable
			playersScores = new String[normalTok.countTokens()][2];
			
			int count = 0; // Creates the int count
			while (normalTok.hasMoreTokens()) { // Separates the rest of the pairs
				playersScores[count][0] = normalTok.nextToken(); // Parses first one and puts it into the huge array
				count++; // Its the i for this while loop
			}
		}
		s.close();
	}
	
	public static void arrayPrint(String[] args){
		for(int i = 0; i <= args.length - 1; i++){
			System.out.println(args[i]);
		}
	}
	
	public static void main(String[] args){
		new ThreeBall();
	}
}