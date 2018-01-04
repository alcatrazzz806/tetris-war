package controller;

import model.*;
import view.*;

import javax.swing.*;

public class TetrisController {
	private TetrisView view;
	private TetrisModel model;
	private TetrisDisplay display;
	
	private Timer timer;
	
	public TetrisController() {
		//display = new B10432018_Display(this);
		display = new B10432034_Display(this);
		//display = new TetrisDisplay(this);
		view = display.getTetrisView();
		model = new TetrisModel(view);
		view.knowModel(model);
		
		timer = new Timer(700, view);
	}
	
	public void start() {
        if (model.isPaused()) return;
        model.setStarted(true);
        model.setFallingFinished(false);
        model.setScore(0);
        model.clearBoard();
        model.newBlock();
        timer.start();
    }
	
	public void restart() {
		view.setStatusText("Playing");
		view.setScoreDisplay("0");
        model.setPaused(false);
        model.setStarted(true);
        model.setFallingFinished(false);
        model.setScore(0);
        model.clearBoard();
        model.newBlock();
        timer.start();
    }
	
	public void gameAction() {
        if (model.isFallingFinished()) {
            model.setFallingFinished(!model.isFallingFinished());
            model.newBlock();
        } else {
            dropOne();
        }
    }
	
	public void init() {
		display.init();
		pause();
	}
	
	public void pause() {
        if (!model.isStarted())
            return;

        model.setPaused(!model.isPaused());
        if (model.isPaused()) {
            timer.stop();
            view.setStatusText("Paused");
        } else {
            timer.start();
            view.setStatusText(String.valueOf("Playing"));
        }
        view.repaint();
    }
	
	public void dropOne()
    {
        if (!model.tryMove(0, -1))
            model.pieceDropped();
    }
	
	public void dropAll()
    {
        while (model.tryMove(0, -1));
        model.pieceDropped();
    }
	
	public void moveLeft() {
        model.tryMove(-1, 0);
    }
    public void moveRight() {
        model.tryMove(1, 0);
    }
    public void rotate() {
        model.rotateRight();
    }
    
    public static void main(String[] args) {
    	TetrisController game = new TetrisController();
    	game.init();
    }
}
