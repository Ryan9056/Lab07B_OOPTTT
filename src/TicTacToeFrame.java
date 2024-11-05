import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeFrame extends JFrame {
    JPanel mainPnl;
    JPanel TTTPnl;  // Top
    JPanel controlPnl; // Bottom

    JButton quitBtn;

    TicTacToeButton[][] board = new TicTacToeButton[3][3];
    TicTacToeGame game = new TicTacToeGame(board);


    public TicTacToeFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTicTacTie();
        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);
        add(TTTPnl, BorderLayout.NORTH);
        add(mainPnl);
        setSize(810, 575);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void createTicTacTie() {
        TTTPnl = new JPanel();
        TTTPnl.setPreferredSize(new Dimension(810, 500));
        TTTPnl.setLayout(new GridLayout(3,3));



        for( int row = 0; row < 3; row++)
            for(int col= 0; col < 3; col++)
            {
                board[row][col] = new TicTacToeButton(row, col);
                board[row][col].setText(" ");
                board[row][col].addActionListener(listener);
                TTTPnl.add(board[row][col]);
            }

    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof TicTacToeButton) {
                if (game.isValidMove(((TicTacToeButton) e.getSource()).getRow(),((TicTacToeButton) e.getSource()).getCol())) {
                    game.Game(((TicTacToeButton) e.getSource()).getRow(),((TicTacToeButton) e.getSource()).getCol());
                }
            }
        }
    };

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 1));

        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));


        controlPnl.add(quitBtn);

    }



}
