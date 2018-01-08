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
        testLabel = new JLabel("Press s to start");
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        view = new TetrisView(this, controller);
        next = new NextBlock(this, controller);
    }
	    
	    public void init() {
	        setLayout(null);
	        	        
	        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
	        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	        scoreLabel.setForeground(Color.GRAY.darker());
	        scoreLabel.setBounds(350, 230, 100, 100);
	        scoreLabel.setVisible(true);
			add(scoreLabel);
			
			scoreDisplay.setHorizontalAlignment(JLabel.CENTER);
			scoreDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			scoreDisplay.setForeground(Color.DARK_GRAY.darker());
			scoreDisplay.setBounds(350, 250, 100, 100);
			add(scoreDisplay);
			
			lineLabel.setHorizontalAlignment(JLabel.CENTER);
			lineLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			lineLabel.setForeground(Color.GRAY.darker());
			lineLabel.setBounds(350, 300, 100, 100);
			lineLabel.setVisible(true);
			add(lineLabel);
				
			lineDisplay.setHorizontalAlignment(JLabel.CENTER);
			lineDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			lineDisplay.setForeground(Color.DARK_GRAY.darker());
			lineDisplay.setBounds(350, 320, 100, 100);
			add(lineDisplay);
	        
			nextLabel.setHorizontalAlignment(JLabel.CENTER);
	        nextLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	        nextLabel.setForeground(Color.GRAY.darker());
	        nextLabel.setBounds(350, 40, 100, 100);
			add(nextLabel);
			
			statusBar.setHorizontalAlignment(JLabel.CENTER);
			statusBar.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
	        statusBar.setForeground(Color.BLACK);
	        statusBar.setBounds(55,0,350,50);
			//add(statusBar);
			
			testLabel.setHorizontalAlignment(JLabel.CENTER);
			testLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
			testLabel.setForeground(Color.WHITE.darker());
			testLabel.setBounds(25,35,280,560);
			add(testLabel);
			
	        startButton.setBounds(350, 400, 100, 50);
			//add(startButton);
			
			pauseButton.setBounds(350, 500, 100, 50);
			//add(pauseButton);
			
	        view.setBounds(25, 35, 280, 560);
	        view.setBackground(Color.BLACK);	// panel 
	        add(view);
	        
	        next.setBounds(350, 100, 100, 120);
	        next.setBackground(Color.WHITE);	// panel 
	        add(next);
	        	        
	        //setSize(500, 600); // frame
	        setPreferredSize(new Dimension(500, 650));
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
