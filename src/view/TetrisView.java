package view;

import controller.TetrisController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel statusBar;
	private JLabel scoreDisplay;
	private JLabel lineDisplay;
	private JLabel testLabel;
	private JButton startButton;
	private JButton pauseButton;
	
	private TetrisController controller;
	private TetrisModel model;
	private TetrisDisplay display;
	
	public TetrisView(TetrisDisplay display, TetrisController TC) {
		this.display = display;
		setFocusable(true);
		controller = TC;
		statusBar = display.getStatusBar();
		scoreDisplay = display.getScoreDisplay();
		lineDisplay = display.getLineDisplay();
		startButton = display.getStartButton();
		testLabel = display.getTestLabel();
		startButton.addActionListener(this);
		pauseButton = display.getPauseButton();
		pauseButton.addActionListener(this);
		addKeyListener(new KeyInput());
	}
	
	public void knowModel(TetrisModel newModel) {
		model = newModel;
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        
        double width = getSize().getWidth();
        double height = getSize().getHeight();
        
        int boardWidth = model.getBoardWidth();
        int boardHeight = model.getBoardHeight();
        
        int squareWidth = (int) width / boardWidth;
        int squareHeight = (int) height / boardHeight;
        int boardTop = (int) height - boardHeight * squareHeight;


        for (int i = 0; i < boardHeight; ++i) {
            for (int j = 0; j < boardWidth; ++j) {
                Block.Tetris_block block = model.shapeAt(j, boardHeight - i - 1);
                if (block != Block.Tetris_block.Empty)
                    this.drawSquare(g, j * squareWidth,
                            		boardTop + i * squareHeight, block);
            }
        }

        if (model.getCurrentBlock().getBlockShape() != Block.Tetris_block.Empty) {
            for (int i = 0; i < 4; ++i) {
                int x = model.getCurrentX() + model.getCurrentBlock().x(i);
                int y = model.getCurrentY() - model.getCurrentBlock().y(i);
                this.drawSquare(g, x * squareWidth,
                				boardTop + (boardHeight - y - 1) * squareHeight,
               					model.getCurrentBlock().getBlockShape());
            }
        }
    }
	
	public void setStatusText(String text) {
        statusBar.setText(text);
    }
	
	public void setScoreDisplay(String score) {
		scoreDisplay.setText(score);
	}
	
	public void setLineDisplay(String line) {
		lineDisplay.setText(line);
	}
	
	public void setTestLabel(String line) {
		testLabel.setText(line);
	}
	
	public void switchTestLabelOn() {
		testLabel.setForeground(Color.WHITE);
		testLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
	}
	
	public void switchTestLabelOff() {
		testLabel.setForeground(Color.BLACK);
		testLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
	}
	
	void start() {
        controller.start();
    }
	
    private int squareWidth() { return (int) getSize().getWidth() / model.getBoardWidth(); }
    private int squareHeight() { return (int) getSize().getHeight() / model.getBoardHeight(); }
    
    public void drawSquare(Graphics g, int x, int y, Block.Tetris_block block)
    {   
        Color color = display.getBlockColor(block.ordinal());

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == startButton) {
    		startButton.setText("Restart");
    		controller.restart();
    		this.grabFocus();
    	}
    	else if(e.getSource() == pauseButton) {
    		controller.pause();
    		if(model.isPaused()) {
    			pauseButton.setText("Resume");
    			testLabel.setText("PAUSE");
    			switchTestLabelOn();
    		}
    		else {
    			pauseButton.setText("Pause");
    			testLabel.setText("PAUSE");
    			switchTestLabelOff();
    		}
    		this.grabFocus();
    	}
    	else
        controller.gameAction();
    }
    
	private class KeyInput extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();
            
            if (keycode == 'r' || keycode == 'R' || keycode == 's' || keycode == 'S') {
                controller.restart();
                startButton.setText("Restart");
                return;
            }
            
            if (!model.isStarted() || model.isCurrentBlockEmpty()) {
                return;
            }

            if (keycode == 'p' || keycode == 'P') {
                controller.pause();
                if(model.isPaused()) {
        			pauseButton.setText("Resume");
        			testLabel.setText("PAUSE");
        			switchTestLabelOn();
        		}
        		else {
        			pauseButton.setText("Pause");
        			testLabel.setText("PAUSE");
        			switchTestLabelOff();
        		}
                return;
            }
            if (model.isPaused())
                return;

            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    controller.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.moveRight();
                    break;
                case KeyEvent.VK_UP:
                    controller.rotate();
                    break;
                case KeyEvent.VK_SPACE:
                    controller.dropAll();
                    break;
                case KeyEvent.VK_DOWN:
                    controller.dropOne();
                    break;
            }

        }
    }
}
