package rpg;

import java.awt.Graphics;

public class Screen {
	Tile[][] grid;
	public Screen()
	{
		grid = new Tile[27][48];
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
				grid[i][j].drawTile(g, i * 30, j * 30);
			}
		}
	}
}
