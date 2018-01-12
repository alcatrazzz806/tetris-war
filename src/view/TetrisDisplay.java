package view;

import controller.TetrisController;

import javax.swing.*;
import java.awt.*;

public class TetrisDisplay extends JFrame {
    private static final long serialVersionUID = 1L;
    protected static JLabel statusBar;
    protected static JLabel scoreDisplay;
    protected static JLabel scoreLabel;
    protected static JLabel nextLabel;
    protected static JLabel lineLabel;
    protected static JLabel lineDisplay;
    protected static JLabel testLabel;
    protected static JTextArea commandLabel;
    protected static JButton startButton;
    protected static JButton pauseButton;
    protected static TetrisView view;
    protected static NextBlock next;
    
    private Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
    };
    
    public TetrisDisplay() { }
    
    public TetrisDisplay(TetrisController controller) {
        statusBar = new JLabel("Press Start!");
        scoreDisplay = new JLabel("0");
        scoreLabel = new JLabel();
        nextLabel = new JLabel();
        lineLabel = new JLabel();
        lineDisplay = new JLabel();
        testLabel = new JLabel();
        commandLabel = new JTextArea();
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        view = new TetrisView(this, controller);
        next = new NextBlock(this);
    }
    
    public void init() {
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
        add(view, BorderLayout.CENTER);
        setSize(200, 400);
        setPreferredSize(new Dimension(200, 400));
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
    }
    
    public TetrisView getTetrisView() {
        return view;
    }
    
    public NextBlock getNextBlock() {
        return next;
    }
    
    public JLabel getStatusBar() {
        return statusBar;
    }
    
    public JLabel getScoreDisplay() {
        return scoreDisplay;
    }

    public JLabel getLineDisplay() {
        return lineDisplay;
    }
    
    public JLabel getTestLabel() {
		return testLabel;
	}
	
    public JButton getStartButton() {
        return startButton;
    }
    
    public JButton getPauseButton() {
        return pauseButton;
    }
    
    public Color getBlockColor(int index) {
        return colors[index];
    }
}
