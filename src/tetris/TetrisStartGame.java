package tetris;

import tetris.views.TetrisFrame;

public class TetrisStartGame {
    public static void main(String[] args) {
        TetrisFrame game = new TetrisFrame();
        //game.setLocationRelativeTo(null);
        game.setLocation(700, 200);
        game.init();
    }
}
