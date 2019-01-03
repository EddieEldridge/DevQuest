package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class GameSetupImpl implements GameSetupInterface
{
	// Instance variables
	Player player = new Player();
	private String showPlayerName;
	private String playerName;
	private String playerDifficulty;
	private String questionsFile = "resources/questions.txt";
	private String answersFile = "resources/answers.txt";
	private String[] difficultyChoices = { "Easy", "Medium", "Hard" };

	// Prompt the user for their name
	public String setupPlayerName()
	{
		playerName = JOptionPane.showInputDialog("Player Name");
		player.setPlayerName(playerName);
		showPlayerName = "Good luck " + player.getPlayerName() + " you'll need it!";
		JOptionPane.showMessageDialog(null, showPlayerName);
		return playerName;
	}

	// Prompt user for difficulty
	public String setupPlayerDifficulty()
	{
		playerDifficulty = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choose your difficulty!",
				JOptionPane.QUESTION_MESSAGE, null, difficultyChoices, // Array of choices
				difficultyChoices[1]); // Initial choice
		System.out.println(playerDifficulty);
		player.setPlayerDifficulty(playerDifficulty);
		return playerDifficulty;
	}

	public ArrayList<String> loadQuestionsFromFile() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(questionsFile));
		String currentLine;
		
		ArrayList<String> questionsFromFile = new ArrayList<String>();

		while ((currentLine = bufferedReader.readLine()) != null)
		{
			questionsFromFile.add(currentLine);
		}
		
		bufferedReader.close();
		
		return questionsFromFile;
	}
	
	public ArrayList<String> loadAnswersFromFile() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(answersFile));
		String currentLine;
		
		ArrayList<String> answersFromFile = new ArrayList<String>();

		while ((currentLine = bufferedReader.readLine()) != null)
		{
			answersFromFile.add(currentLine);
		}
		
		bufferedReader.close();
		
		return answersFromFile;
	}

}
