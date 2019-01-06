package ie.gmit.sw;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
/**
 * Generates easy questions and answers to ask the player
 * and implements Question
 * @see Question
 * @author Eddie Eldridge
 * @version 1.0
 */
public class EasyQuestion implements Question
{
	/**
	 * The relative file paths of the easy Questions and Answers
	 */
	private String easyQuestionsFile = "./resources/questions/easyQuestions.txt";
	private String easyAnswersFile = "./resources/questions/easyAnswers.txt";
	
	/**
	 * Reads in the questions from a text file and returns them as an ArrayList of strings
	 */
	@Override
	public ArrayList<String> generateQuestion() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(easyQuestionsFile));
		String currentLine;
		
		ArrayList<String> questionsFromFile = new ArrayList<String>();

		while ((currentLine = bufferedReader.readLine()) != null)
		{
			questionsFromFile.add(currentLine);
		}
		
		bufferedReader.close();
		
		return questionsFromFile;
	}
	
	/**
	 * Reads in the answers from a text file and returns them as an ArrayList of strings
	 */
	@Override
	public ArrayList<String> generateAnswers() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(easyAnswersFile));
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
