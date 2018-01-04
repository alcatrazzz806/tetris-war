package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class B10432018_Display extends TetrisDisplay {
	private static final long serialVersionUID = 1L;
	
	private Color colors[] = { 
			new Color(0, 0, 0), new Color(0, 127, 255),
            new Color(71, 163, 255), new Color(173, 214, 255),
            new Color(255, 245, 250), new Color(255, 194, 224),
            new Color(255, 168, 212), new Color(255, 122, 189)
    };
	
	public B10432018_Display(TetrisController controller) {
		statusBar = new JLabel("Press Start!");
		scoreDisplay = new JLabel("0");
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		view = new TetrisView(this, controller);
	}
	
	public void init() {
		setLayout(null);
		
		scoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		scoreDisplay.setFont(new Font("Serif", Font.ITALIC, 24));
		scoreDisplay.setForeground(Color.BLUE);
		scoreDisplay.setBounds(400, 20, 130, 100);
		add(scoreDisplay);
		
		statusBar.setBounds(10, 800, 490, 20);
		add(statusBar);
		
		startButton.setBounds(415, 550, 100, 50);
		add(startButton);
		
		pauseButton.setBounds(415, 650, 100, 50);
		add(pauseButton);
		
        view.setBounds(0, 0, 400, 800);
        view.setBackground(Color.BLACK);
        add(view);
        
        setSize(500, 800);
        setPreferredSize(new Dimension(530, 850));
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
	}
	
	public Color getBlockColor(int index) {
		return colors[index];
	}
	
}
