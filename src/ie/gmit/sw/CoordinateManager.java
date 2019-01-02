package ie.gmit.sw;

public class CoordinateManager
{
	public int getIsoX(int x, int y)
	{
		int rshift = (GameView.DEFAULT_VIEW_SIZE / 2) - (GameView.TILE_WIDTH / 2) + (x - y); // Pan camera to the right
		return (x - y) * (GameView.TILE_WIDTH / 2) + rshift;
	}

	public int getIsoY(int x, int y)
	{
		return (x + y) * (GameView.TILE_HEIGHT / 2);
	}

	public Point getIso(int x, int y)
	{
		return new Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient...
	}

}
