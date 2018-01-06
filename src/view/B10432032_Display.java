package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class B10432032_Display extends TetrisDisplay {
	private static final long serialVersionUID = 1L;
	
	private Color colors[] = { 	//	Empty, Z, S, I, T, O, L, J 
    		new Color(0, 0, 0), new Color(237, 28, 36),
            new Color(255, 130, 65), new Color(155, 220, 235),
            new Color(255, 200, 15), new Color(35, 180, 75),
            new Color(175, 160, 220), new Color(195, 195, 195)
    };
	
	public B10432032_Display() { }
	    
    public B10432032_Display(TetrisController controller) {
        statusBar = new JLabel("TETRIS");
        scoreLabel = new JLabel("SCORE");
        lineLabel = new JLabel("LINES");        
        nextLabel = new JLabel("NEXT");
        scoreDisplay = new JLabel("0");        
        lineDisplay = new JLabel("0");
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        view = new TetrisView(this, controller);
        next = new NextBlock(this, controller);
    }
	    
	    public void init() {
	        setLayout(null);
	        
	        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
	        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	        scoreLabel.setForeground(Color.GRAY.darker());
	        scoreLabel.setBounds(405, 240, 100, 100);
	        scoreLabel.setVisible(true);
			add(scoreLabel);
			
			scoreDisplay.setHorizontalAlignment(JLabel.CENTER);
			scoreDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			scoreDisplay.setForeground(Color.DARK_GRAY.darker());
			scoreDisplay.setBounds(405, 270, 100, 100);
			add(scoreDisplay);
			
			lineLabel.setHorizontalAlignment(JLabel.CENTER);
			lineLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			lineLabel.setForeground(Color.GRAY.darker());
			lineLabel.setBounds(405, 320, 100, 100);
			lineLabel.setVisible(true);
			add(lineLabel);
				
			lineDisplay.setHorizontalAlignment(JLabel.CENTER);
			lineDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			lineDisplay.setForeground(Color.DARK_GRAY.darker());
			lineDisplay.setBounds(405, 350, 100, 100);
			add(lineDisplay);
	        
			nextLabel.setHorizontalAlignment(JLabel.CENTER);
	        nextLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	        nextLabel.setForeground(Color.GRAY.darker());
	        nextLabel.setBounds(405, 60, 100, 100);
			add(nextLabel);
			
			statusBar.setHorizontalAlignment(JLabel.CENTER);
			statusBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
	        statusBar.setForeground(Color.BLACK);
	        statusBar.setBounds(50,10,350,50);
			add(statusBar);
			
	        startButton.setBounds(415, 550, 100, 50);
			add(startButton);
			
			pauseButton.setBounds(415, 650, 100, 50);
			add(pauseButton);
			
	        view.setBounds(25, 60, 350, 700);
	        view.setBackground(Color.BLACK);	// panel 
	       // view.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	        add(view);
	        
	        next.setBounds(405, 120, 100, 120);
	        next.setBackground(Color.WHITE);	// panel 
	        add(next);
	        	        
	        setSize(500, 800); // frame
	        setPreferredSize(new Dimension(550, 850));
	        setTitle("Tetris");
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // frame
	        pack();
	        setVisible(true); // frame
	        setResizable(false);
	        setLocationRelativeTo(null);
	        
	    }
	    
	    public Color getBlockColor(int index) {
	        return colors[index];
	    }
}
