package ie.gmit.sw;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Interfaces PaintableImpl
 * 
 * @see PaintableImpl
 * @author Eddie Eldridge
 * @version 1.0
 */
public interface PaintableInterface
{

	void paintObjects(Graphics2D g);

	void paintPlayer(Graphics2D g);

	void paintTiles(Graphics2D g);
	
	void paintAsIsometric();

}