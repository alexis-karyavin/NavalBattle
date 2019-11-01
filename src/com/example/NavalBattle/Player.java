package com.example.NavalBattle;

public class Player {
    public GameField field;
    public GameField enemyField;

    public Player() {
        field = new GameField();
        enemyField = new GameField();
    }

    public void addShips(int[][] coordinates) {
        for (var i = 0; i < coordinates.length; i++) {
            int x1, y1, x2, y2;

            x1 = coordinates[i][0];
            y1 = coordinates[i][1];
            x2 = coordinates[i][2];
            y2 = coordinates[i][3];

            field.addShip(x1, y1, x2, y2);
        }
    }

    public void showGameField() {
        /**
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
        String[][] gameField = this.field.getGameField();
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
}
