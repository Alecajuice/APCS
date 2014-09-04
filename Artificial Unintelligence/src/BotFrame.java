import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class BotFrame extends JFrame
{

	JPanel history;
	JTextField input;
	
	public BotFrame()
	{
		JPanel frameContent = new JPanel();
		this.add(frameContent);
		history = new JPanel();
		history.setLayout(new GridLayout(1000, 1));
		JPanel inputPanel = new JPanel(null);
		input = new JTextField();
		input.setBounds(0, 0, 5000, 20);
		inputPanel.add(input);
		JScrollPane scrollPane = new JScrollPane(history);
		scrollPane.setPreferredSize(new Dimension(300, 250));
        scrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.black));
        frameContent.setLayout(new BoxLayout(frameContent, BoxLayout.Y_AXIS));
        frameContent.add(scrollPane);
		frameContent.add(inputPanel);
		for(int i = 0; i < 1000; i++)
		history.add(new JLabel("hi"));
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		initFrame();
	}
	
	private void initFrame()
	{
		this.setSize(500, 500);
//		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
}
