import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class FlagFrame extends JFrame
{
	FlagPanel panel = new FlagPanel();
	public FlagFrame()
	{
		//Initialize frame
		this.add(panel);
		this.setSize(1900, 1000);
		this.setBackground(Color.WHITE);
		this.repaint();
		panel.repaint();
	}
}
