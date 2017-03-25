

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;


public class ThreeBall{

	// Need to change this to a HashMap<String><ArrayList<Integer>>
	public String[][] playersScores;
	public static String scoreFileLocation = "./Highscores.TSM";

	public ThreeBall(){
		loadPlayers();
		
		System.out.println("Three Ball scorer loaded");
		
//		arrayPrint(playersScores);
	}

	public void loadPlayers(){
		File f = new File(scoreFileLocation);
		int lines = countLines(f);
		
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] Couldn't find " + f.getName() + "!");
			createNewScoreFile(f);
		}
		
		int i = 0;
		playersScores = new String[lines][4]; // playersScores[Name][Best Score][Wins][Loses]
		
		while (s.hasNextLine()) {
			String line = s.nextLine();
			if (line.startsWith("#")) // If it finds a line that begins with a # it will skip that line, its like a comment
				continue;
			// Need to make it so that if they put too many tabs/whitespace in it will be of
			StringTokenizer normalTok = new StringTokenizer(line, "\t"); // Every tab it will take in the next variable
		
			for (int j = 0; normalTok.hasMoreTokens(); j++) { // Adds the data on each line to the 3D array
				playersScores[i][j] = normalTok.nextToken(); // Parses next token and puts it into the array
			}
			i++;
		}
		s.close();
	}
	
	public void arrayPrint(String[][] args){
		for(int i = 0; i <= args.length - 1; i++){
			for(int j = 0; j <= args[i].length - 1; j++){
				System.out.print(args[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public int countLines(File file){
		File f = new File("./Highscores.TSM");
		Scanner s = null;
		int amountLines = 0;
		
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] Couldn't find " + file.getName() + "!");
		}
		while (s.hasNextLine()) {
			if (s.nextLine().startsWith("#")) // If it finds a line that begins with a # it will skip that line, its like a comment
				continue;
			amountLines++;
		}
		s.close();
		
		return amountLines;
	}
	
	public boolean createNewScoreFile(File file){
		System.out.println("[INFO] Trying to create " + file.getName() + "!");
		Writer writer;	// This writes data to the file
		try {
			file.createNewFile();
			FileOutputStream is = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			writer = new BufferedWriter(osw);
			
			writer.write("#Name\tBest\tScore\tWins\tLoses"); // Comment denoting how files should look
			writer.close();
			
			System.out.println("[INFO] Created " + file.getName() + "!");
			return true;
		} catch (IOException ioe) {
			System.out.println("[ERROR] Couldn't Create " + file.getName() + "!");
			return false;
		}		
	}
	
	public static void main(String[] args){
		new ThreeBall();
	}
}