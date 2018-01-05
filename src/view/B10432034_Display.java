package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class B10432034_Display extends TetrisDisplay {
    private static final long serialVersionUID = 1L;
    
    private Color colors[] = { 
            new Color(0, 0, 0), new Color(255, 255, 255),
            new Color(255, 255, 255), new Color(255, 255, 255),
            new Color(255, 255, 255), new Color(255, 255, 255),
            new Color(255, 255, 255), new Color(255, 255, 255)
    };
    
    public B10432034_Display(TetrisController controller) {
        statusBar = new JLabel("Press R or S to Start!");
        //scoreLabel = new JLabel("Score");
        //nextLabel = new JLabel("Next");
        commandLabel = new JTextArea("Command"+ "\n" + "s\r: start" + "\n" + "p: pause" + "\n" + "r: restart");
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        scoreDisplay = new JLabel("0");
        next = new NextBlock(this, controller);
        view = new TetrisView(this, controller);
    }
    
    public void init() {
        setLayout(null);
        /*
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 24));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBounds(420, 60, 70, 40);
        add(scoreLabel);
        */
        scoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        scoreDisplay.setFont(new Font("Serif", Font.BOLD, 24));
        scoreDisplay.setForeground(Color.WHITE);
        scoreDisplay.setOpaque(true);
        scoreDisplay.setBackground(Color.BLACK);

        scoreDisplay.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        scoreDisplay.setBounds(35, 100, 70, 40);
        add(scoreDisplay);

        statusBar.setHorizontalAlignment(SwingConstants.CENTER);
        statusBar.setBounds(140, 10, 380, 20);
        statusBar.setFont(new Font("Serif", Font.BOLD, 20));
        statusBar.setForeground(Color.BLACK);
        add(statusBar);
        
        view.setBounds(140, 40, 380, 760);
        view.setBackground(Color.BLACK);
        view.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        add(view);
        /*
        nextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nextLabel.setFont(new Font("Serif", Font.BOLD, 24));
        nextLabel.setForeground(Color.BLACK);
        nextLabel.setOpaque(false);
        nextLabel.setBounds(420, 210, 70, 40);
        add(nextLabel);
        */
        next.setBounds(25, 250, 90, 120);
        next.setBackground(Color.BLACK);
        next.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        add(next);
        
        commandLabel.setFont(new Font("Serif", Font.BOLD, 20));
        commandLabel.setForeground(Color.BLACK);
        commandLabel.setBackground(SystemColor.control);
        commandLabel.setBounds(410, 400, 100, 300);
        add(commandLabel);
        
        //setSize(500, 800);
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
