package Games.WhacAMole.src;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class WhacAMole {
    int boardwidth= 600; 
    int boardheight= 700;


    JFrame frame = new JFrame("Mario: Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    

    JButton[] board= new JButton[9];
    ImageIcon moleIcon;
    ImageIcon plantIcon;
    Color ButtonColor = new Color(207, 175, 163);

    JButton currMoleTile;
    JButton currPlantTile;


    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;
    int score=0;

    JPanel diffPanel = new JPanel();
    int moleTime=1000,plantTime=1000;
    JButton diff[] = new JButton[3];
    JPanel inPanel = new JPanel();
    JLabel diffLabel = new JLabel();
    Color c1 = new Color(227, 145, 2); 
    Color c2 = new Color(38, 199, 49); 
    Color c3 = new Color(185, 191, 120);


    public WhacAMole(){
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score: 0");
        textLabel.setBackground(new Color(172, 230, 215));
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        textPanel.setPreferredSize(new Dimension(600,50));
        frame.add(textPanel, BorderLayout.NORTH);

        diffPanel.setLayout(new GridLayout(1,4));
        diffPanel.add(diffLabel);
        JButton d1 = new JButton();
        JButton d2 = new JButton();
        JButton d3 = new JButton();
        diff[0]=d1;
        diff[1]=d2;
        diff[2]=d3;

        diff[0].setText("Easy");
        diff[0].setForeground(c2);
        diff[1].setText("Medium");
        diff[1].setForeground(c1);
        diff[2].setText("Hard");
        diff[2].setForeground(Color.red);
        

        for(int i=0;i<3;i++){
            diff[i].setPreferredSize(new Dimension(100,50));
            diff[i].setBackground(Color.white);

            diff[i].setFont(new Font("Arial", Font.PLAIN,24));
            diffPanel.add(diff[i]);
            diff[i].setFocusable(false);
        }
        diff[0].addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e){
                setMoleTimer.setDelay(1000);
                setPlantTimer.setDelay(1000);
                setMoleTimer.start();
                setPlantTimer.start();
                for(int i=0;i<9;i++){
                    board[i].setEnabled(true);
                }
                score = 0;
                textLabel.setText("Score: "+ Integer.toString(score));
                
            }
        });

        diff[1].addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e){
                setMoleTimer.setDelay(750);
                setPlantTimer.setDelay(750);
                setMoleTimer.start();
                setPlantTimer.start();
                for(int i=0;i<9;i++){
                    board[i].setEnabled(true);
                }
                score = 0;
                textLabel.setText("Score: "+ Integer.toString(score));
            }
        });

        diff[2].addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e){
                setMoleTimer.setDelay(500);
                setPlantTimer.setDelay(500);
                setMoleTimer.start();
                setPlantTimer.start();
                for(int i=0;i<9;i++){
                    board[i].setEnabled(true);
                }
                score = 0;
                textLabel.setText("Score: "+ Integer.toString(score));
            }
        });

        inPanel.setLayout(new BorderLayout());
        inPanel.add(diffPanel, BorderLayout.NORTH);

        diffLabel.setText("Difficulty: ");
        diffLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        diffLabel.setForeground(c3);

        
        boardPanel.setLayout(new GridLayout(3,3));
        inPanel.add(boardPanel, BorderLayout.CENTER);
        frame.add(inPanel);
        
        Image plantImg = new ImageIcon(getClass().getResource("./piranha.png")).getImage();
        plantIcon = new ImageIcon(plantImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image moleImg = new ImageIcon(getClass().getResource("./monty.png")).getImage();
        moleIcon = new ImageIcon(moleImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));


        for(int i =0; i<9;i++){
            JButton tile = new JButton();
            board[i]=tile;
            tile.setBackground(ButtonColor);
            boardPanel.add(tile);
            tile.setFocusable(false);
            tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton tile = (JButton)e.getSource();
                    if(tile==currMoleTile){
                        score+=10;
                        textLabel.setText("Score: "+ Integer.toString(score));
                    }
                    else if(tile==currPlantTile){
                        textLabel.setText("Game Over: "+ Integer.toString(score));
                        setMoleTimer.stop();
                        setPlantTimer.stop();
                        for(int i=0;i<9;i++){
                            board[i].setEnabled(false);
                        }
                    }
                }
            });
        }

        setMoleTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(currMoleTile != null){
                    currMoleTile.setIcon(null);
                    currMoleTile = null;
                }

                int num=random.nextInt(9);
                JButton tile= board[num];

                if(currPlantTile==tile) return;

                currMoleTile = tile;
                currMoleTile.setIcon(moleIcon);
            }
        });

        setPlantTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(currPlantTile != null){
                    currPlantTile.setIcon(null);
                    currPlantTile = null;
                }

                int num=random.nextInt(9);
                JButton tile= board[num];

                if(currMoleTile==tile) return;

                currPlantTile = tile;
                currPlantTile.setIcon(plantIcon);
            }
        });

        frame.setVisible(true);
    }
    public void thankyou(){
        System.out.println("Thank you for playing this game!");
    }
}