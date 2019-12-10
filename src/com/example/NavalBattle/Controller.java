package com.example.NavalBattle;

import java.util.Scanner;

public class Controller {
    public Player pl;
    public Player plEnemy;

    public Controller(int[][] coordinatesShips) {
        pl = new Player();
        plEnemy = new Player();
        pl.addShips(coordinatesShips);
        int[][] shipsEnemy = {{1, 4, 1, 7}};
        plEnemy.addShips(shipsEnemy);
    }

    public void initConsole() {
        while (onIsContinue()) {
            System.out.println("Вы:");
            showGameFieldPlayer();

            System.out.println("Соперник:");
            showHiddenEnemyGameField();

            System.out.println("Куда шмальнуть братишка?");

            Scanner inX = new Scanner(System.in);
            System.out.print("x: ");
            int x = inX.nextInt();
            Scanner inY = new Scanner(System.in);
            System.out.print("y: ");
            int y = inY.nextInt();
            onShoot(x, y);
        }
    }

    private void showGameFieldPlayer() {
        /**
         *
         * id: Номер игрового поля
         * 1 - Наше игровое поле
         * 2 - Соперник
         *
         * return
         *   0123456789
         *  #----------#
         *  0|          |
         *  1|          |
         *  2|          |
         *  3|          |
         *      .....
         *  #----------#
         */
        String[][] gameField = onGetFieldPlayerString();

        System.out.println("  0123456789  ");
        System.out.println(" #----------# ");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println(" #----------# ");


    }

    private void showGameFieldPlayerEnemy() {
        /**
         *
         * id: Номер игрового поля
         * 1 - Наше игровое поле
         * 2 - Соперник
         *
         * return
         *   0123456789
         *  #----------#
         *  0|          |
         *  1|          |
         *  2|          |
         *  3|          |
         *      .....
         *  #----------#
         */
        String[][] gameField = onGetFieldEnemyString();

        System.out.println("  0123456789  ");
        System.out.println(" #----------# ");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println(" #----------# ");


    }

    private void showHiddenEnemyGameField() {
        /**
         *
         * id: Номер игрового поля
         * 1 - Наше игровое поле
         * 2 - Соперник
         *
         * return
         *   0123456789
         *  #----------#
         *  0|          |
         *  1|          |
         *  2|          |
         *  3|          |
         *      .....
         *  #----------#
         */
        String[][] gameField = onGetHiddenGameField();

        System.out.println("  0123456789  ");
        System.out.println(" #----------# ");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.print("|\n");
        }
        System.out.println(" #----------# ");
    }

    public boolean onIsContinue() {
        return !(pl.isLose() || plEnemy.isLose());
    }

    public int onShoot(int x, int y) {
        return pl.shoot(x, y, plEnemy);
    }

    public String[][] onGetFieldPlayerString() {
        return pl.field.getGameField();
    }

    public String[][] onGetFieldEnemyString() {
        return plEnemy.field.getGameField();
    }

    private String[][] onGetHiddenGameField() {
        return plEnemy.field.getHiddenGameField();
    }
}
