package rpg;

import java.awt.Graphics;

public class Screen {
	private Tile[][] grid;
	public Screen()
	{
		grid = new Tile[18][32];
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = new Tile();
			}
		}
	}
	public void setScreen(Tile[][] newGrid)
	{
		grid = newGrid;
	}
	public void showScreen(Graphics g)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				grid[i][j].drawTile(g, i * 50, j * 50, 50);
			}
		}
	}
}
