package fisheater;

import java.io.File;
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
	File file;
	int playerCount = 0;
	HighPlayer[] player = new HighPlayer[3];
	HighScores() {
		file = new File("src/fisheater/resources/score.txt");
		try {
			if (!file.createNewFile()) {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					String name = scan.nextLine();
					int score = Integer.valueOf(scan.nextLine());
					addHighScore(name, score);
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
	public boolean checkHighScore(int score) {
		if (player[2]==null || score>player[2].score)
			return true;
		else
			return false;
	}
	public void addHighScore(String name, int score) {
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
	}
	
	public static void main(String[] args) {
		HighScores h = new HighScores();
		h.addHighScore("sd", 16);
		for (int i=0; i<h.playerCount; i++)
			System.out.print(h.player[i].score + "\n");
		System.out.print(h.checkHighScore(0));
    }
}
