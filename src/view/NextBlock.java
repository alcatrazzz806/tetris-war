package view;

import controller.TetrisController;
import model.*;

import javax.swing.*;
import java.awt.*;

public class NextBlock extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private TetrisController controller;
	private TetrisModel model;
	private TetrisDisplay display;
	
	public NextBlock(TetrisDisplay display, TetrisController TC) {
		this.display = display;
		controller = TC;
	}
	
	public void knowModel(TetrisModel newModel) {
		model = newModel;
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        
        double width = getSize().getWidth();
        double height = getSize().getHeight();
        
        int boardWidth = model.getNextBoardWidth();
        int boardHeight = model.getNextBoardHeight();
        
        int squareWidth = (int) width / boardWidth;
        int squareHeight = (int) height / boardHeight;
        int boardTop = (int) height - boardHeight * squareHeight;
        
        if (model.getNextBlock().getBlockShape() == Block.Tetris_block.O ||
        		model.getNextBlock().getBlockShape() == Block.Tetris_block.S ||
        		model.getNextBlock().getBlockShape() == Block.Tetris_block.J) {
            for (int i = 0; i < 4; ++i) {
                int x = 1 + model.getNextBlock().x(i);
                int y = 2 - model.getNextBlock().y(i);
                this.drawSquare(g, x * squareWidth,
                				boardTop + (boardHeight - y - 1) * squareHeight,
               					model.getNextBlock().getBlockShape());
            }
        }
        
        else if (model.getNextBlock().getBlockShape() != Block.Tetris_block.Empty) {
            for (int i = 0; i < 4; ++i) {
                int x = 2 + model.getNextBlock().x(i);
                int y = 2 - model.getNextBlock().y(i);
                this.drawSquare(g, x * squareWidth,
                				boardTop + (boardHeight - y - 1) * squareHeight,
               					model.getNextBlock().getBlockShape());
            }
        }
    }
	
	void start() {
        controller.start();
    }
	
    private int squareWidth() { return (int) getSize().getWidth() / model.getNextBoardWidth(); }
    private int squareHeight() { return (int) getSize().getHeight() / model.getNextBoardHeight(); }
    
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
       
}
