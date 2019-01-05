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
			Question mediumQuestion = new MediumQuestionDecorator(new MediumQuestion());

			questionsFromFile = mediumQuestion.generateQuestion();
			answersFromFile = mediumQuestion.generateAnswers();
		}
		else if (player.getPlayerDifficulty().equals("Hard"))
		{
			Question hardQuestion = new HardQuestionDecorator(new HardQuestion());

			questionsFromFile = hardQuestion.generateQuestion();
			answersFromFile = hardQuestion.generateAnswers();
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
		if (player.getRoundsWon() >= 3)
		{
			SoundEffect.VICTORY.play();
			JOptionPane.showMessageDialog(null, "YOU HAVE WON!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You have won " + player.getRoundsWon() + "rounds. You need to win "
					+ (3 - player.getRoundsWon()) + "rounds more to win!");
		}
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

	public void checkLocation()
	{
		Point playerPoint = PaintableImpl.playerSprite.getPosition();
		Point computerPoint1 = new Point(1, 9);
		Point computerPoint2 = new Point(3, 1);
		Point computerPoint3 = new Point(8, 1);
		Point printer = new Point(9,9);

		if (playerPoint.getX() == computerPoint1.getX() && playerPoint.getY() == computerPoint1.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == computerPoint2.getX() && playerPoint.getY() == computerPoint2.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == computerPoint3.getX() && playerPoint.getY() == computerPoint3.getY())
		{
			askQuestion();
		}
		else if (playerPoint.getX() == printer.getX() && playerPoint.getY() == printer.getY() )
		{
			generateFanfare();
		}
		else
		{
			showMoreHelp();
		}
	}

	public void askAnotherQuestion()
	{

		if (player.getQuestionsAnswered() < 5)
		{
			askQuestion();
		}
		else if (player.getQuestionsAnswered() >= 5)
		{
			player.setQuestionsAnswered(0);
			player.setRoundsWon(player.getRoundsWon() + 1);
			JOptionPane.showMessageDialog(null, "You have won " + player.getRoundsWon() + " rounds. You need to win "
					+ (3 - player.getRoundsWon()) + " rounds more to win!");
		}
		

	}
	
	public void showHelp()
	{
		JOptionPane.showMessageDialog(null,
				"Use the arrow keys to move the player. \nMove Player: 'X' \nToggle View: 'Z'");
	}

	public void showMoreHelp()
	{
		JOptionPane.showMessageDialog(null, "You must be at a computer to ask questions. (Make sure you're standing on the tile)");
	}
}
