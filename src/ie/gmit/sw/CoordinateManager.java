package ie.gmit.sw;
/**
 * Manages coordinates of the isometric tiles
 * @author Eddie Eldridge
 * @version 1.0
 */
public class CoordinateManager
{
	/*
	 * Get the X coordinates 
	 */
	public int getIsoX(int x, int y)
	{
		int rshift = (Graphic.DEFAULT_VIEW_SIZE / 2) - (Graphic.TILE_WIDTH / 2) + (x - y); // Pan camera to the right
		return (x - y) * (Graphic.TILE_WIDTH / 2) + rshift;
	}

	/*
	 * Get the Y coordinates 
	 */
	public int getIsoY(int x, int y)
	{
		return (x + y) * (Graphic.TILE_HEIGHT / 2);
	}

	/*
	 * Get the X and Y coordinates 
	 */
	public Point getIso(int x, int y)
	{
		return new Point(getIsoX(x, y), getIsoY(x, y));
	}

}
