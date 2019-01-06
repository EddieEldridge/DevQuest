package ie.gmit.sw;

/**
 * Part of the Graphic hierarchy
 * Used mainly to manipulate the player sprite
 * @see Graphic
 * @author Eddie Eldridge
 * @version 1.0
 */
import java.awt.image.*;

public class Sprite extends Graphic
{
	private BufferedImage[][] images = new BufferedImage[4][3]; // The images used in the animation
	private Direction direction = Direction.DOWN; // The current orientation of the sprite
	Point p = new Point(0, 0);

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

	/**
	 * Sets the direction of the Sprite
	 * @param d is the direction to set the Sprite
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
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

	/**
	 * Re-orientates the player sprite based on their direction
	 * @return The re-orientated image to use for the sprite
	 * @param The direction used to change the image
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
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

	/**
	 * Moves the sprite
	 * 
	 * @author Eddie Eldridge
	 * @version 1.0
	 */
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