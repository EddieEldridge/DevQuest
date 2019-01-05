package ie.gmit.sw;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */

import java.awt.image.*;

public class Sprite extends Graphic
{
	
	private BufferedImage[][] images = new BufferedImage[4][3]; // The images used in the animation
	private Direction direction = Direction.DOWN; // The current orientation of the sprite
	Point p = new Point(0,0);
	
	public Sprite(BufferedImage[] img)
	{
		setName("Sprite");
		setPosition(p);
		
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++)
		{
			images[row][col] = img[i];
			if (col == images[row].length - 1)
			{
				row++;
				col = 0;
			}
			else
			{
				col++;
			}
		}
	}

	

	public Sprite()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public Point getPosition()
	{
		return position;
	}

	@Override
	public BufferedImage getImage()
	{
		return images[direction.getOrientation()][index];
	}

	public void setDirection(Direction d)
	{
		direction = d;
		System.out.println("=============");
		System.out.println("Y: " + position.getY());
		System.out.println("X: " + position.getX());
		System.out.println("Direction : " + direction);
	}

	public Direction getDirection()
	{
		return this.direction;
	}

	
	// Functionality
	public BufferedImage step(Direction d)
	{
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1)
		{
			index++;
		}
		else
		{
			index = 0;
		}
		return images[d.getOrientation()][index];
	}

	
	public void move()
	{ 
		step(direction);
		
		switch (direction.getOrientation())
		{
			// UP
			case 1:
				if (position.getY() + 1 < 10)
				{
					position.setY(position.getY() + 1);
					break;
				}
	
			// DOWN
			case 2:
				if (position.getX() - 1 > -1)
				{
					position.setX(position.getX() - 1);
					break;
				}
	
			// LEFT
			case 3:
				if (position.getX() + 1 < 10)
				{
					position.setX(position.getX() + 1);
					break;
				}
	
			// RIGHT
			default:
				if (position.getY() - 1 > -1)
				{
					position.setY(position.getY() - 1);
					break;
				}
		}
		
	}

}