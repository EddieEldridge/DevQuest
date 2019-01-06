package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface for SpecialEventsImpl
 * @see SpecialEventsImpl
 * @author Eddie Eldridge
 * @version 1.0
 */
public interface SpecialEventsInterface
{
	public void showHelp();
	public String[] generateQuestion() throws IOException;
	public void generateFanfare();
	public void askQuestion();
	public void checkLocation();
}
