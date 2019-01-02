package ie.gmit.sw;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Runner
{
	public static void main(String[] args) throws Exception
	{
		// Instance variables
		Scanner scanner = new Scanner(System.in);
		String playerName;
		
		// Prompt the user for their name
		JOptionPane playerNameWindow = new JOptionPane("Player name");
		playerName = JOptionPane.showInputDialog("First Name");
		
		JOptionPane.showMessageDialog(null, playerName);
	
		
		// Can read in necessary information here and process it before going any
		// further...

		// Never run a GUI in the same thread as the main method... This is
		// asynchronous:
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{ // Template method....
				try
				{
					/*
					 * ---------------------------------------- Control Keys
					 * ---------------------------------------- Use the arrow keys to move the
					 * player. Move Player: 'X' Toggle View: 'Z'
					 * ----------------------------------------
					 */
					new GameWindow(); // Could be done nicer?
				} catch (Exception e)
				{
					e.printStackTrace(); // Real lazy stuff here...
				}
			}
		});
	}
}