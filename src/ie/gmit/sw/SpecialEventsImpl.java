package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class SpecialEventsImpl implements SpecialEventsInterface
{
	GameSetupInterface gameSetup = new GameSetupImpl();
	Boolean isCorrect = false;
	Player player = Player.getInstance();
	ArrayList<String> questionsFromFile;
	ArrayList<String> answersFromFile;

	public void showHelp()
	{
		JOptionPane.showMessageDialog(null,
				"Use the arrow keys to move the player. \nMove Player: 'X' \nToggle View: 'Z'");
	}

	public SpecialEventsImpl()
	{
		SoundEffect.init();
		SoundEffect.volume = SoundEffect.Volume.LOW;
	}

	public String[] generateQuestion() throws IOException
	{
		// Variables
		String questionToAsk;
		String actualAnswer;
		System.out.println(player.getPlayerDifficulty());
		
		if (player.getPlayerDifficulty().equals("Easy"))
		{
			Question easyQuestion = new EasyQuestionDecorator(new EasyQuestion());

			questionsFromFile = easyQuestion.generateQuestion();
			answersFromFile = easyQuestion.generateAnswers();
		}
		else if (player.getPlayerDifficulty().equals("Medium"))
		{
			//Question mediumQuestion = new MediumQuestionDecorator(new MediumQuestion());

			//questionsFromFile = med.generateQuestion();
			//answersFromFile = easyQuestion.generateAnswers();
		}
		else if (player.getPlayerDifficulty().equals("Hard"))
		{
			//Question easyQuestion = new EasyQuestionDecorator(new EasyQuestion());

			//questionsFromFile = easyQuestion.generateQuestion();
			//answersFromFile = easyQuestion.generateAnswers();
		}

		String[] questionAnswerPair = { "", "" };

		// Seed a random number for selecting question/answer
		int seed = (int) (Math.random() * 9 + 1);

		// Choose a random question from the list of questions
		questionToAsk = questionsFromFile.get(seed);
		actualAnswer = answersFromFile.get(seed);

		// Add the question and answer to an array so we can return it
		questionAnswerPair[0] = questionToAsk;
		questionAnswerPair[1] = actualAnswer;

		return questionAnswerPair;
	}

	public void generateFanfare()
	{
		JOptionPane.showMessageDialog(null, "YOU HAVE WON!");
	}

	public void askQuestion()
	{
		String[] questionAnswerPair = { "", "" };
		String playerAnswer;

		try
		{
			questionAnswerPair = generateQuestion();
		} catch (IOException e)
		{
			System.out.println("Error here: ");
		}

		System.out.println("Correct Answer: " + questionAnswerPair[1]);

		// Prompt the player for their answer
		playerAnswer = JOptionPane.showInputDialog(questionAnswerPair[0]);

		if (playerAnswer.equals(questionAnswerPair[1]))
		{
			player.setQuestionsAnswered(player.getQuestionsAnswered() + 1);
			JOptionPane.showMessageDialog(null, "Correct Answers: " + player.getQuestionsAnswered());
			askAnotherQuestion();
		}
		else
		{
			SoundEffect.FAILURE.play();
			player.setQuestionsAnswered(0);
			JOptionPane.showMessageDialog(null, "Wrong answer, try again.");
			System.out.println("Correct Answer: " + questionAnswerPair[1]);
			System.out.println("Player Answer: " + playerAnswer);
		}

	}

	public void askAnotherQuestion()
	{
		if (player.getQuestionsAnswered() < 5)
		{
			askQuestion();
		}
		else if (player.getQuestionsAnswered() > 5)
		{
			SoundEffect.VICTORY.play();
			generateFanfare();
		}
	}
}
