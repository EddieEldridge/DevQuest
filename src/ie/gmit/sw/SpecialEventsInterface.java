package ie.gmit.sw;

import java.io.IOException;

public interface SpecialEventsInterface
{
	public void showHelp();
	public Boolean generateQuestion() throws IOException;
	public void generateFanfare();
}
