package ie.gmit.sw;
/**
 * Handles X,Y coordinates or Points whenever needed
 * @see CoordinateManager
 * @author Eddie Eldridge
 * @version 1.0
 */
public class Point
{
	private int x;
	private int y;

	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}