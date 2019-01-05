package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

public interface Question
{
	ArrayList<String> generateQuestion() throws IOException;
	ArrayList<String> generateAnswers() throws IOException;
}
