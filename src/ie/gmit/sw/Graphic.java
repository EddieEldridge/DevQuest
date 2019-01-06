package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * Graphic is the parent class of subclasses such as Sprite, Tile and Object
 * 
 * @see Sprite
 * @see Tile
 * @see Object
 * @author Eddie Eldridge
 * @version 1.0
 */
abstract class Graphic
{
	// Variables
	String name; // The name of the sprite
	Point position; // The current x, y position
	int index = 0; // The current image index.\
	static final int DEFAULT_VIEW_SIZE = 1280;
	static final int TILE_WIDTH = 128;
	static final int TILE_HEIGHT = 64;

	/**
	 * @return the name of the Graphic
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the position of the Graphic
	 */
	public Point getPosition()
	{
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Point position)
	{
		this.position = position;
	}

	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index)
	{
		this.index = index;
	}

	/**
	 * @return gets the image of the graphic as a bufferedImage
	 */
	abstract BufferedImage getImage();

}
