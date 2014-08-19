import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class CowFrame extends JFrame
{
	//Constructor creates frame, sets size, and paints it once
	public CowFrame()
	{
		super();
		setSize(500, 500);
		repaint();
	}
	
	public void paint(Graphics g)
	{
		//Paint sky
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 500, 500);
		//Paint ground
		g.setColor(Color.GREEN);
		g.fillRect(0, 350, 500, 150);
		//Paint body
		g.setColor(Color.WHITE);
		g.fillOval(300, 300, 100, 50);
		g.fillRect(130, 320, 200, 100);
		g.fillRect(130, 320, 30, 160);
		g.fillRect(300, 320, 30, 160);
		//Paint spots
		g.setColor(Color.BLACK);
		g.fillOval(150, 330, 50, 30);
		g.fillOval(180, 340, 50, 30);
		g.fillOval(250, 390, 50, 30);
		g.fillOval(275, 370, 50, 30);
		g.fillOval(190, 380, 50, 30);
	}
}
