package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Generates medium questions and answers to ask the player
 * and implements Question
 * @see Question
 * @author Eddie Eldridge
 * @version 1.0
 */
public class MediumQuestion implements Question
{
	/**
	 * The relative file paths of the medium Questions and Answers
	 */
	private String mediumQuestionsFile = "./resources/questions/medQuestions.txt";
	private String mediumAnswersFile = "./resources/questions/medAnswers.txt";
	
	/**
	 * Reads in the questions from a text file and returns them as an ArrayList of strings
	 */
	@Override
	public ArrayList<String> generateQuestion() throws IOException
	{
		System.out.println("Generating medium question...");

		BufferedReader bufferedReader = new BufferedReader(new FileReader(mediumQuestionsFile));
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
		BufferedReader bufferedReader = new BufferedReader(new FileReader(mediumAnswersFile));
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
