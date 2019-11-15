package com.example.NavalBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class FrameNavalBattle extends JFrame {

        public FrameNavalBattle(NavalBattle battle) {
            Container contentPanel = getContentPane();

            setLayout(new GridLayout(0, 2, 10, 10));
            setSize(400,300);
            setTitle("Морской бой");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelGrid gridLeft = new PanelGrid();
            PanelGrid gridRight = new PanelGrid();

            String[][] gameFieldPlayerString = battle.getFieldPlayerString();
            String[][] gameFieldEnemyString = battle.getFieldEnemyString();

            gridLeft.initPanelPlayer(gameFieldPlayerString);
            gridRight.initPanelEnemy(battle, gameFieldEnemyString);

            contentPanel.add(gridLeft);
            contentPanel.add(gridRight);
            pack();
        }
    }

class PanelGrid extends JPanel {

    private ArrayList<CellButton> listButtons;

    public PanelGrid() {
        listButtons = new ArrayList<>();
    }

    public void initPanelPlayer(String[][] field) {
        setLayout(new GridLayout(0, 11));
        add(new JLabel(" "));
        //Вставляем тайтлы сеток игрового поля
        for (int i = 0; i < 10; i++) {
            CustomLabel label = new CustomLabel(Integer.toString(i));
            label.removeBorder();
            add(label);
        }

        //Заполняем поле кнопками
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if(j == 0) {
                    CustomLabel label = new CustomLabel(Integer.toString(i));
                    label.removeBorder();
                    add(label);
                } else {
                    CustomLabel label = new CustomLabel("");
                    if(i == 0) {
                        label.setText(field[i][j-1]);
                    } else {
                        label.setText(field[i-1][j-1]);
                    }
                    add(label);
                }
            }
        }
    }

    public CellButton searchButton(int x, int y) {
        for (CellButton btn : listButtons) {
            if(btn.x == x && btn.y == y) {
                return btn;
            }
        }
        return null;
    }

    public void initPanelEnemy(NavalBattle battle, String[][] field) {
        setLayout(new GridLayout(0, 11));
        add(new JLabel(" "));
        //Вставляем тайтл сетки игрового поля
        for (int i = 0; i < 10; i++) {
            CustomLabel label = new CustomLabel(Integer.toString(i));
            add(label);
        }

        //Заполняем поле кнопками
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if(j == 0) {
                    CustomLabel label = new CustomLabel(Integer.toString(i));
                    add(label);
                } else {
                    CellButton btn = new CellButton(i, j-1);
                    add(btn);
                    this.listButtons.add(btn);
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int status = battle.shoot(btn.x, btn.y);
                            String[][] gameFieldString = battle.getFieldEnemyString();

                            System.out.printf("%d%d", btn.x, btn.y);

                            for (int k = 0; k < gameFieldString.length; k++) {
                                for (int l = 0; l < gameFieldString[k].length; l++) {
                                    CellButton changeBtn = searchButton(k,l);
                                    if (gameFieldString[k][l] == "X") {
                                        changeBtn.setText("X");
                                        changeBtn.setEnabled(false);
                                    } else if (gameFieldString[k][l] == "*") {
                                        changeBtn.setText("*");
                                        changeBtn.setEnabled(false);
                                    }

                                }
                            }
                            if(!battle.isContinue()) {
                               for (CellButton btn : listButtons) {
                                   btn.setEnabled(false);
                               }
                            }
                        }

//                            if (status == 2) {
//                               btn.setText("X");
//                           } else if (status == 3) {
//                               btn.setText("*");
//                           }
//                            btn.setEnabled(false);
//                        }
                    });
                }
            }
        }
    }
}


class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        setText(text);
        setPreferredSize(new Dimension(50, 50));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public void removeBorder() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
    }
}

class CellButton extends JButton {
    public int x;
    public int y;

    public CellButton(int x, int y) {
        this.x = x;
        this.y = y;

        setText("");
        setPreferredSize(new Dimension(50, 50));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
    }
}