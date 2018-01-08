package view;

import controller.TetrisController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class B10432018_Display extends TetrisDisplay {
	private static final long serialVersionUID = 1L;
	
	class BackGround extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image backGroundImage;
		public BackGround() throws IOException {
			backGroundImage = ImageIO.read(BackGround.class.getResource("/resources/B10432018.jpg"));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backGroundImage, 0, 0, this);
		}
	}
	
	private BackGround backGround;
	private Color colors[] = { 
			new Color(0, 0, 0), new Color(0, 127, 255),
            new Color(71, 163, 255), new Color(173, 214, 255),
            new Color(255, 245, 250), new Color(255, 194, 224),
            new Color(255, 168, 212), new Color(255, 122, 189)
    };
	
	public B10432018_Display(TetrisController controller) {
		super(controller);
		try {
			backGround = new BackGround();
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
		statusBar.setText("Press Start!");
		scoreDisplay.setText("0");
		startButton.setText("Start!");
		pauseButton.setText("Pause");
	}
	
	public void init() {
		setLayout(null);
		
		scoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		scoreDisplay.setFont(new Font("Font.MONOSPACED", Font.BOLD, 24));
		scoreDisplay.setForeground(Color.CYAN);
		scoreDisplay.setOpaque(true);
		scoreDisplay.setBackground(Color.BLACK);
		scoreDisplay.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		scoreDisplay.setBounds(425, 20, 80, 50);
		add(scoreDisplay);
		
		statusBar.setBounds(0, 800, 400, 22);
		statusBar.setHorizontalAlignment(SwingConstants.CENTER);
		statusBar.setForeground(Color.WHITE);
		statusBar.setOpaque(true);
		statusBar.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GRAY));
		statusBar.setBackground(Color.BLACK);
		add(statusBar);
		
		startButton.setBounds(415, 550, 100, 50);
		startButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		add(startButton);
		
		pauseButton.setBounds(415, 650, 100, 50);
		pauseButton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		add(pauseButton);
		
        view.setBounds(0, 0, 400, 800);
        view.setBackground(Color.BLACK);
        add(view);
        
        next.setBounds(423, 250, 80, 100);
        next.setBackground(Color.BLACK);
        next.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        add(next);
        
        backGround.setBounds(0, 0, 530, 850);
		backGround.setBackground(Color.DARK_GRAY);
		add(backGround);
        
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
