

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;


public class ThreeBall{

	public String[][] playersScores;

	public ThreeBall(){
		loadPlayers();
		
		System.out.println("Three Ball scorer loaded");
	}

	public void loadPlayers(){ //doesnt work started never finished
		try{
			File f = new File("./Highscores.TSM");
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (line.startsWith("#")) //if it finds a line that begins with a # it will skip that line, its like a comment
					continue;
				StringTokenizer normalTok = new StringTokenizer(line, "\t"); //every tab it will take in the next variable
				playersScores = new String[normalTok.countTokens()][2];
				playersScores[0][0] = normalTok.nextToken();
				int count = 1; //creates the int count
				while (normalTok.hasMoreTokens()) { //separates the rest of the pairs
					playersScores[count][0] = normalTok.nextToken(); //parses first one and puts it into the huge array
					count++; //its the i for this while loop
				}
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("debug: problem at loading clue Rewards");
		}
		
	}
	
	public static void arrayPrint(String[] args){
		for(int i = 0; i <= args.length - 1; i++){
			System.out.println(args[i]);
		}
	}
}