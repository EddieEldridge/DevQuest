package ie.gmit.sw;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface PaintableInterface
{

	void paintObjects(Graphics2D g);

	void paintPlayer(Graphics2D g);

	void paintTiles(Graphics2D g);

}