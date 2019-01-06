package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface for Question decorator
 * @see QuestionDecorator
 * @author Eddie Eldridge
 * @version 1.0
 */
public interface Question
{
	ArrayList<String> generateQuestion() throws IOException;
	ArrayList<String> generateAnswers() throws IOException;
}
