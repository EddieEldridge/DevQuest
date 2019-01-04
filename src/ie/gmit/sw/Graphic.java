package ie.gmit.sw;

import java.awt.image.BufferedImage;

abstract class Graphic
{
	// Variables
	 String name; // The name of the sprite
	 Point position; // The current x, y position
	 int index = 0; // The current image index.
	 
	 /**
	 * @return the name
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
	 * @return the position
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
	
	abstract BufferedImage getImage();
	
	

}
