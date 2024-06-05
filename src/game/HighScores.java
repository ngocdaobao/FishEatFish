package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class HighScores {
	class HighPlayer {
		String name;
		int score;
		HighPlayer(String n, int s) {
			name = n;
			score = s;
		}
	}
	private File file;
	private int playerCount = 0;
	private HighPlayer[] player = new HighPlayer[3];
	HighScores() {
		file = new File("src/resources/score.txt");
		try {
			if (!file.createNewFile()) {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String name = scan.nextLine();
					if (scan.hasNextLine()) {
						int score = Integer.valueOf(scan.nextLine());
						addHighScore(name, score);
					}
			    }
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
        }
	}
	public String getName(int i) {
		if (player[i]!=null)
			return player[i].name;
		else
			return "";
	}
	public String getScore(int i) {
		if (player[i]!=null)
			return String.valueOf(player[i].score);
		else
			return "";
	}
	public boolean checkHighScore(int score) {
		if (player[2]==null || score>player[2].score)
			return true;
		else
			return false;
	}
	public void addHighScore(String name, int score) {
		if (checkHighScore(score)) {
			int rank = 0;
			for (; rank<playerCount; rank++) {
				if (player[rank].score < score)
					break;
			}
			for (int i=2; i>rank; i--) {
				player[i] = player[i-1];
			}
			player[rank] = new HighPlayer(name, score);
			if (playerCount < 3)
				playerCount++;
			saveToFile();
		}
	}
	public void saveToFile() {
		try {
			FileWriter writer = new FileWriter(file);
			String output="";
			for (int i=0; i<playerCount; i++)
				output += player[i].name + '\n' + player[i].score + '\n';
			writer.write(output);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
