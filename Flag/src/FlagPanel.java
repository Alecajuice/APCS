import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FlagPanel extends JPanel
{
	//height of flag
	public int height;
	
	//Constant ratios for flag dimensions
	private final double HEIGHT_WIDTH_RATIO = 1.9;
	private final double UNION_WIDTH_RATIO = 0.76;
	private final double UNION_HEIGHT_RATIO = 0.5385;
	private final double STAR_HORIZONTAL_SPACING_RATIO = 0.063;
	private final double STAR_VERTICAL_SPACING_RATIO = 0.054;
	private final double STAR_DIAMETER_RATIO = 0.0616;
	private final double STAR_INNER_RADIUS_RATIO = 0.39;
	private final double STRIPE_WIDTH_RATIO = 0.0769;
	
	//Constructor for JPanel
	public FlagPanel()
	{
		super();
//		this.setSize(1900, 1000);
//		this.setBackground(Color.WHITE);
		repaint();
	}
	
	//Set height so that flag is resized with the window
	public void setFlagHeight()
	{
		if(this.getHeight() * HEIGHT_WIDTH_RATIO <= this.getWidth())
		{
			height = this.getHeight();
		}
		else
		{
			height = (int)Math.round(this.getWidth() / HEIGHT_WIDTH_RATIO);
		}
	}
	
	@Override
	//Sets height then paints flag on JPanel
	public void paint(Graphics g)
	{
		setFlagHeight();
		drawStripes(g);
		drawUnion(g);
	}
	
	//Draw stripes
	public void drawStripes(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Old Glory Red
		g.setColor(new Color(224, 22, 43));
		//draw stripes
		for(int i = 0; i < 13; i+=2)
		{
			if(i < 8)
			{
				//shorter stripes
				g.fillRect((int) Math.round(height * UNION_WIDTH_RATIO), i * (int) Math.round(height * STRIPE_WIDTH_RATIO), (int) Math.round(height * (HEIGHT_WIDTH_RATIO - UNION_WIDTH_RATIO)), (int) Math.round(height * STRIPE_WIDTH_RATIO));
			}
			else
			{
				//longer stripes
				g.fillRect(0, i * (int) Math.round(height * STRIPE_WIDTH_RATIO), (int) Math.round(height * HEIGHT_WIDTH_RATIO), (int) Math.round(height * STRIPE_WIDTH_RATIO));
			}
		}
	}
	
	//Draw the Union
	public void drawUnion(Graphics g)
	{
		//Old Glory Blue
		g.setColor(new Color(0, 38, 100));	
		//draw blue background
		g.fillRect(0, 0, (int) Math.round(height * UNION_WIDTH_RATIO), (int) Math.round(height * UNION_HEIGHT_RATIO));
		//draw stars
		for (int i = 1; i <= 11; i++)
		{
			for (int j = 1; j <= 9; j++)
			{
				//Stole this equation from Nihar
				if(i%2 == j%2)
				{
					//only draw the star every other loop
					drawSter(g, i * height * STAR_HORIZONTAL_SPACING_RATIO, j * height * STAR_VERTICAL_SPACING_RATIO);
				}
			}
		}
	}
	
	//Draw sters
	public void drawSter(Graphics g, double x, double y)
	{
		//Took Nihar's code and tweaked it
		g.setColor(Color.WHITE);
		//Point arrays for drawing stars
		int[] polyX = new int[10];
		int[] polyY = new int[10];
		//72 degrees in radians
		double starAngle = Math.PI/5;
		//radius of star
		double radius = height * STAR_DIAMETER_RATIO * 0.5;
		//find the points of the star
		for(int i = 0; i < 10; i++)
		{
			if (i % 2 == 0)
			{
				//Multiply radius by 0.39 to get inner points
				polyX[i] = (int) (x + Math.round(radius*STAR_INNER_RADIUS_RATIO * Math.sin(i * starAngle)));
				polyY[i] = (int) (y + Math.round(radius*STAR_INNER_RADIUS_RATIO * Math.cos(i * starAngle)));
			}
			else
			{
				polyX[i] = (int) (x + Math.round(radius * Math.sin(i * starAngle)));
				polyY[i] = (int) (y + Math.round(radius * Math.cos(i * starAngle)));
			}
		}
		//Draw the star
		g.fillPolygon(polyX, polyY, 10);
	}
}

