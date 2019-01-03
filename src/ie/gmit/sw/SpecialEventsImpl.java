package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class SpecialEventsImpl implements SpecialEventsInterface
{
	GameSetupInterface gameSetup = new GameSetupImpl();

	public void showHelp()
	{
		JOptionPane.showMessageDialog(null, "Use the arrow keys to move the player. \nMove Player: 'X' \nToggle View: 'Z'");
	}
	
	public Boolean generateQuestion() throws IOException
	{
		// Variables
	   String questionToAsk;
	   String playerAnswer;
	   String actualAnswer;
	   ArrayList<String> questionsFromFile = gameSetup.loadQuestionsFromFile();
	   ArrayList<String> answersFromFile = gameSetup.loadAnswersFromFile();
	   
	   // Seed a random number for selecting question/answer
	   int seed = (int)(Math.random() * 9 + 1);	   
	   
	   // Choose a random question from the list of questions
	   questionToAsk = questionsFromFile.get(seed);
	   actualAnswer = answersFromFile.get(seed);
	   
	   System.out.println("Question to Ask: " + questionToAsk);
	   System.out.println("Correct Answer: " +actualAnswer);
	   
	   // Prompt the player for their answer
	   playerAnswer = JOptionPane.showInputDialog(questionToAsk);
	   
	   
	   System.out.println("Player Answer: " +playerAnswer);

	   // Compare the answer given to the actual answer
	   if(playerAnswer == actualAnswer)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
	}
	
	public void generateFanfare()
	{
		JOptionPane.showMessageDialog(null, "YOU HAVE WON!");
	}	
}
