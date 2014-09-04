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
	JPanel frameContent;
	JPanel history;
	JScrollPane scrollPane;
	JPanel inputPanel;
	JTextField input;
	
	public BotFrame()
	{
		super();
		this.setSize(1000, 1000);
		frameContent = new JPanel(null);
		frameContent.setSize(1000, 1000);
		this.add(frameContent);
		history = new JPanel();
		history.setLayout(new GridLayout(1000, 1));
		inputPanel = new JPanel(null);
		input = new JTextField();
		input.setBounds(0, 0, frameContent.getWidth(), 20);
		inputPanel.add(input);
		scrollPane = new JScrollPane(history);
		scrollPane.setPreferredSize(new Dimension(300, 250));
        scrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.black));
        frameContent.setLayout(new BorderLayout());
        frameContent.add(scrollPane, BorderLayout.NORTH);
		frameContent.add(inputPanel, BorderLayout.CENTER);
		for(int i = 0; i < 1000; i++)
		history.add(new JLabel("hi"));
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		initFrame();
		mainLoop();
	}
	
	private void initFrame()
	{
//		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.pack();
	}
	
	public void mainLoop()
	{
		while(true)
		{
			resize();
			this.validate();
		}
	}
	
	public void resize()
	{
		inputPanel.setSize(frameContent.getWidth(), 20);
//		inputPanel.setBounds(0, frameContent.getHeight() - 20, frameContent.getWidth(), 20);
//		scrollPane.setBounds(0, 0, frameContent.getWidth(), frameContent.getHeight() - 20);
		System.out.println(frameContent.getHeight() + ", " + frameContent.getWidth());
	}
}
