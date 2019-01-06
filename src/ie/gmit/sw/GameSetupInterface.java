package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface of GameSetupImpl
 * @see GameSetupImpl
 * @author Eddie Eldridge
 * @version 1.0
 */
public interface GameSetupInterface
{
	public String setupPlayerName();
	public String setupPlayerDifficulty();
	public void showStartMessage();
}
