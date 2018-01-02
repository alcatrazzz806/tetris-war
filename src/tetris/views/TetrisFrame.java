package tetris.views;
import javax.swing.*;
import java.awt.*;

public class TetrisFrame extends JFrame {
    private JLabel statusBar;
    private TetrisBoard board;

    public TetrisFrame() {
        statusBar = new JLabel("0", SwingConstants.CENTER);
        board = new TetrisBoard(this);
    }

    public void init() {
        //setLayout(new BorderLayout(40, 0));
        setLayout(null);
        //add(statusBar, BorderLayout.SOUTH);
        //add(board, BorderLayout.CENTER);
        add(statusBar);
        add(board);
        board.setBounds(150, 0, 300, 600);
        statusBar.setBounds(30, 60, 90, 40);
        statusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        board.start();
        setSize(200, 400);
        setPreferredSize(new Dimension(455, 630));
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
    }

    JLabel getStatusBar() {
        return statusBar;
    }
}