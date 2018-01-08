package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class B10432033_Display extends TetrisDisplay {
	private static final long serialVersionUID = 1L;
	
	private Color colors[] = {
    		new Color(0, 0, 0), new Color(129, 129, 192	),
            new Color(166, 166, 210), new Color(192, 122, 184),
            new Color(170, 170, 255), new Color(132, 193, 255),
            new Color(166, 255, 255), new Color(202, 142, 255)
    };
	
	public B10432033_Display() { }
	    
    public B10432033_Display(TetrisController controller) {
        statusBar = new JLabel("WAR OF TETRIS");
        scoreLabel = new JLabel("SCORE:");
        nextLabel = new JLabel("NEXT");
        scoreDisplay = new JLabel("0"); 
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        view = new TetrisView(this, controller);
        next = new NextBlock(this, controller);
    }
	    
	    public void init() {
	        setLayout(null);
	        
	        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
	        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	        scoreLabel.setForeground(Color.BLACK);
	        scoreLabel.setBounds(405, 20, 100, 100);
	        scoreLabel.setVisible(true);
			add(scoreLabel);
			
			scoreDisplay.setHorizontalAlignment(JLabel.CENTER);
			scoreDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
			scoreDisplay.setForeground(Color.BLACK);
			scoreDisplay.setBounds(405, 50, 100, 100);
			add(scoreDisplay);

			nextLabel.setHorizontalAlignment(JLabel.CENTER);
	        nextLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
	        nextLabel.setForeground(Color.BLACK);
	        nextLabel.setBounds(405, 130, 100, 100);
			add(nextLabel);
			
			statusBar.setHorizontalAlignment(JLabel.CENTER);
			statusBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
	        statusBar.setForeground(Color.BLACK);
	        statusBar.setBounds(30,10,350,50);
			add(statusBar);
			
	        startButton.setBounds(405, 550, 100, 50);
			add(startButton);
			
			pauseButton.setBounds(405, 650, 100, 50);
			add(pauseButton);
			
	        view.setBounds(25, 60, 350, 700);
	        view.setBackground(Color.WHITE);	// panel 
	        add(view);
	        
	        next.setBounds(405, 200, 100, 120);
	        next.setBackground(Color.WHITE);	// panel 
	        add(next);
	        	        
	        setSize(500, 800); // frame
	        setPreferredSize(new Dimension(550, 850));
	        setTitle("WAR OF TETRIS");
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
