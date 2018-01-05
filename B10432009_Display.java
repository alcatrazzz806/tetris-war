package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class B10432009_Display extends TetrisDisplay {
	private static final long serialVersionUID = 1L;
	
	private Color colors[] = { 
			new Color(0, 0, 0), new Color(220, 20, 60),
            new Color(50, 205, 50), new Color(0, 191, 255),
            new Color(153, 50, 204), new Color(255, 215, 0),
            new Color(255, 45, 0), new Color(0, 0, 205)
    };
	
	public B10432009_Display(TetrisController controller) {
		statusBar = new JLabel("Press R to Start!");
		score = new JLabel("Score");
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		scoreDisplay = new JLabel("0");
		
		view = new TetrisView(this, controller);
	}
	
	public void init() {
		setLayout(null);
		
		scoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		scoreDisplay.setFont(new Font("Serif", Font.BOLD, 24));
		view.setBorder(BorderFactory.createLineBorder(Color.red));
		scoreDisplay.setForeground(Color.BLUE);
		scoreDisplay.setBounds(400, 20, 130, 100);
		add(scoreDisplay);
		
		statusBar.setBounds(10, 800, 490, 20);
		add(statusBar);
		
		view.setBounds(10, 10, 400, 800);
		view.setBackground(Color.WHITE);
		view.setBorder(BorderFactory.createLineBorder(Color.black, 3));
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
