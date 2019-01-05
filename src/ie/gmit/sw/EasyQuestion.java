package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EasyQuestion implements Question
{
	private String easyQuestionsFile = "resources/easyQuestions.txt";
	private String easyAnswersFile = "resources/easyAnswers.txt";
	
	@Override
	public ArrayList<String> generateQuestion() throws IOException
	{
		System.out.println("Generating easy question...");
		
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
