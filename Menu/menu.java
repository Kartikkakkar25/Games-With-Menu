import Games.TicTacToe.src.*;
import Games.FlappyBird.src.*;
import Games.Snake.src.*;
import Games.SpaceInvaders.src.SpaceInvaders;
import Games.WhacAMole.src.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class menu{
    public static void main (String[] args) {
        int width = 200;
        int height = 310;
        JFrame frame = new JFrame("Menu");
        JLabel textlabel = new JLabel();
        JPanel textpanel = new JPanel();
        JButton SButton = new JButton();
        JButton WButton = new JButton();
        JButton TButton = new JButton();
        JButton FButton = new JButton();
        JButton SIButton = new JButton();
        Color c1 = new Color(167, 195, 204);
        Color c2 = new Color(201, 204, 175);
        textlabel.setText("Game Menu!");
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textpanel.add(textlabel);
        textpanel.setBackground(c1);
        frame.setResizable(false);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        textpanel.setBounds(0, 0, 200, 40);
    

        SButton.setText("Snake Game");
        SButton.setBounds(25, 50, 140, 30);
        SButton.setBackground(c2);
        WButton.setText("Whac A Mole");
        WButton.setBounds(25, 95, 140, 30);
        WButton.setBackground(c2);
        TButton.setText("Tic Tac Toe");
        TButton.setBounds(25, 140, 140, 30);
        TButton.setBackground(c2);
        FButton.setText("Flappy Bird");
        FButton.setBounds(25, 185, 140, 30);
        FButton.setBackground(c2);
        SIButton.setText("Space Invaders");
        SIButton.setBounds(25, 230, 140, 30);
        SIButton.setBackground(c2);

        SButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int boardWidth=600;
                int boardHeight=boardWidth;

                JFrame frame = new JFrame("Snake Game");


                frame.setVisible(true);
                frame.setSize(boardWidth,boardHeight);   
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
                frame.add(snakeGame);
                frame.pack();
                snakeGame.requestFocus();

            }
        });
        WButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                WhacAMole WhacAMole = new WhacAMole();
                WhacAMole.thankyou();
            }
        });
        TButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                TicTacToe ticTacToe = new TicTacToe();
                ticTacToe.thankyou();
            }
        });
        FButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int boardWidth=360;
                int boardHeight=640;

                JFrame frame1 = new JFrame("Flappy Bird");
                frame1.setSize(boardWidth,boardHeight);
                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                flappyBird flappyBird = new flappyBird();
                frame1.add(flappyBird);
                frame1.pack();
                flappyBird.requestFocus();
                frame1.setVisible(true);
                }
            });
        SIButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int tileSize = 32;
                int rows = 16;
                int columns = 16;
                int boardWidth = tileSize * columns;
                int boardHeight = tileSize * rows;

                JFrame frame1 = new JFrame("Space Invaders");
                frame1.setSize(boardWidth,boardHeight);
                frame1.setLocationRelativeTo(null);
                frame1.setResizable(false);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SpaceInvaders spaceinvaders = new SpaceInvaders();
                frame1.add(spaceinvaders);
                frame1.pack();
                spaceinvaders.requestFocus();
                frame1.setVisible(true);
                    }
            });
            frame.add(textpanel);
            frame.add(SButton);
            frame.add(WButton);
            frame.add(TButton);
            frame.add(FButton);
            frame.add(SIButton);
            frame.setVisible(true);
    }
}