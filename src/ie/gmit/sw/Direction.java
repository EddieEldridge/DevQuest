package ie.gmit.sw;
/**
 * This class is responsible for managing direction of graphic objects
 * @author Eddie Eldridge
 * @version 1.0
 */
public enum Direction
{
	UP(0), DOWN(1), LEFT(2), RIGHT(3);

	private final int orientation;

	private Direction(int orientation)
	{
		this.orientation = orientation;
	}

	/*
	 * Get the current orientation (UP, DOWN, LEFT, RIGHT)
	 */
	public int getOrientation()
	{
		return this.orientation;
	}
}