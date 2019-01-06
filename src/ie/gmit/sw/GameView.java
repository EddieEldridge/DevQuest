package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

/**
 * Initiates painting of the graphics through the PaintableInterface
 * @see JPanel
 * @see ActionListener
 * @see PaintableInterface
 * @author Eddie Eldridge
 * @version 1.0
 */
public class GameView extends JPanel implements ActionListener
{
	// Instance variables
	PaintableInterface paintInterface = new PaintableImpl();
	private static final long serialVersionUID = 777L;
	private Timer timer; 

	/**
	 * GameView constructor
	 * Set's up basic game settings and starts a timer for how often to repaint the canvas
	 * @throws Exception
	 */
	public GameView() throws Exception
	{
		// Set the background color to white
		setBackground(Color.WHITE);
		
		// Each image is buffered twice to avoid tearing / stutter
		setDoubleBuffered(true); 
		
		// Start the timer
		// calls the actionPerformed() method every 100ms
		timer = new Timer(100, this); 
		timer.start(); 
	}

	/**
	 * This method performs the repainting when the timer counts down
	 */
	public void actionPerformed(ActionEvent e)
	{
		this.repaint();
	}

	/**
	 * This method iniates painting of the tiles, objects and player 
	 * using the paintComponent of JComponent
	 * @see paintComponent
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		paintInterface.paintTiles(g2);
		paintInterface.paintObjects(g2);
		paintInterface.paintPlayer(g2);
	}
	
}