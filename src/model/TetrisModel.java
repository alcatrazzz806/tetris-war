package model;

import view.TetrisView;
import model.Block.Tetris_block;
import view.NextBlock;

public class TetrisModel {
	private TetrisView view;
	private NextBlock next;
	
	private Block currentBlock;
	private Block nextBlock;
	private Block.Tetris_block[] board;
	private Block.Tetris_block[] nextboard;
	
	private int boardWidth = 10;
	private int boardHeight = 20;
	private int nextboardWidth = 4;
	private int nextboardHeight = 5;
	private boolean fallingFinished = false;
	private boolean started = false;
	private boolean paused = false;
	
	private int score = 0;
	private int currentX = 0;
	private int currentY = 0;
	
	public TetrisModel(TetrisView tetrisView, NextBlock nextblock) {
		this.view = tetrisView;
		this.next = nextblock;
		currentBlock = new Block();
		nextBlock = new Block();
		board = new Block.Tetris_block[boardWidth * boardHeight];
		nextboard = new Block.Tetris_block[nextboardWidth * nextboardHeight];
		
		clearBoard();
	}
		
	public boolean isStarted() {
		return started;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public boolean isFallingFinished() {
		return fallingFinished;
	}
	
	public void setStarted(boolean in) {
		started = in;
	}
	
	public void setPaused(boolean in) {
		paused = in;
	}
	
	public void setFallingFinished(boolean in) {
		fallingFinished = in;
	}
	
	public void setScore(int in) {
		score = in;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean isCurrentBlockEmpty() {
		return currentBlock.getBlockShape() == Block.Tetris_block.Empty;
	}
	
	public void clearBoard() {
		for (int i = 0; i < boardWidth * boardHeight; i++) {
			board[i] = Block.Tetris_block.Empty;
		}
	}
	
	public void clearNextBoard() {
		for (int i = 0; i < nextboardWidth * nextboardHeight; i++) {
			nextboard[i] = Block.Tetris_block.Empty;
		}
	}
	
	public Block.Tetris_block shapeAt(int x, int y) {
        return board[(y * boardWidth) + x];
    }
	
	public void initialBlock()
    {
		currentBlock.setBlockShape(Tetris_block.Empty);
        nextBlock.setRandomShape();
    }
	
	public void newBlock()
    {
        currentBlock.setBlockShape(nextBlock.getBlockShape());
        nextBlock.setRandomShape();
        next.repaint();
        currentX = boardWidth / 2 + 1;
        currentY = boardHeight - 1 + currentBlock.yMin();

        if (!tryMove(0, 0)) {
            currentBlock.setBlockShape(Block.Tetris_block.Empty);
            started = false;
            fallingFinished = true;
            view.setStatusText("Game Over");
        }
    }
	
	public boolean tryMove(int newX, int newY)
    {
		Block newBlock = new Block();
		newBlock = currentBlock;
        for (int i = 0; i < 4; ++i) {
            int x = newX + currentX + newBlock.x(i);
            int y = newY + currentY - newBlock.y(i);
            if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight)
                return false;
            if (shapeAt(x, y) != Block.Tetris_block.Empty)
                return false;
        }

        currentBlock = newBlock;
        currentX = currentX + newX;
        currentY = currentY + newY;
        view.repaint();
        return true;
    }
	
	public void rotateRight() {
		Block newBlock = new Block();
		newBlock = currentBlock.rotateRight();
        for (int i = 0; i < 4; ++i) {
            int x = currentX + newBlock.x(i);
            int y = currentY - newBlock.y(i);
            if (x < 0 || x >= boardWidth || y < 0 || y >= boardHeight)
                return;
            if (shapeAt(x, y) != Block.Tetris_block.Empty)
                return;
        }

        currentBlock = newBlock;
        view.repaint();
        return;
	}
	
	private void removeFullLines()
    {
        int numFullLines = 0;

        for (int i = boardHeight - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < boardWidth; ++j) {
                if (shapeAt(j, i) == Block.Tetris_block.Empty) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < boardHeight - 1; ++k) {
                    for (int j = 0; j < boardWidth; ++j)
                        board[(k * boardWidth) + j] = shapeAt(j, k + 1);
                }
            }
        }

        if (numFullLines > 0) {
            switch (numFullLines) {
            case 1:
            	score += 100;
            	break;
            case 2:
            	score += 300;
            	break;
            case 3:
            	score += 500;
            	break;
            case 4:
            	score += 800;
            	break;
            }
            view.setScoreDisplay(String.valueOf(score));
            fallingFinished = true;
            currentBlock.setBlockShape(Block.Tetris_block.Empty);
            view.repaint();
        }
    }
	
	public void pieceDropped()
    {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentBlock.x(i);
            int y = currentY - currentBlock.y(i);
            board[(y * boardWidth) + x] = currentBlock.getBlockShape();
        }

        removeFullLines();

        if (!fallingFinished)
            newBlock();
    }
    
    public int getBoardWidth()
    {
        return this.boardWidth;
    }
    
    public int getBoardHeight()
    {
        return this.boardHeight;
    }
    
    public Block getCurrentBlock() {
        return currentBlock;
    }
    
    public int getNextBoardWidth()
    {
        return this.nextboardWidth;
    }
    
    public int getNextBoardHeight()
    {
        return this.nextboardHeight;
    }
    
    public Block getNextBlock() {
        return nextBlock;
    }
    
    public int getCurrentX()
    {
        return this.currentX;
    }
    
    public int getCurrentY()
    {
        return this.currentY;
    }
}
