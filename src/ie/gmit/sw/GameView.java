package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class GameView extends JPanel implements ActionListener
{
	// Instance variables
	PaintableInterface paintInterface = new PaintableImpl();
	
	private static final long serialVersionUID = 777L;
	public static final int DEFAULT_VIEW_SIZE = 1280;
	static final int TILE_WIDTH = 128;
	static final int TILE_HEIGHT = 64;

	private Timer timer; // Controls the repaint interval.

	public GameView() throws Exception
	{
		setBackground(Color.WHITE);
		
		// Each image is buffered twice to avoid tearing / stutter
		setDoubleBuffered(true); 
		
		// Start the timer
		// calls the actionPerformed() method every 100ms
		timer = new Timer(100, this); 
		timer.start(); 
	}

	public void actionPerformed(ActionEvent e)
	{
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		paintInterface.paintTiles(g2);
		paintInterface.paintObjects(g2);
		paintInterface.paintPlayer(g2);
	}
	
}