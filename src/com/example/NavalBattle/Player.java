package com.example.NavalBattle;

public class Player {
    public GameField field;
    public GameField enemyField;
    private boolean work = true;

    public Player() {
        field = new GameField();
        enemyField = new GameField();
        this.initGameFieldEnemy();
    }

    public void addShips(int[][] coordinates, int id) {
        for (var i = 0; i < coordinates.length; i++) {
            int x1, y1, x2, y2;

            x1 = coordinates[i][0];
            y1 = coordinates[i][1];
            x2 = coordinates[i][2];
            y2 = coordinates[i][3];

            if(id == 1) {
                field.addShip(x1, y1, x2, y2);
            } else if (id == 2) {
                enemyField.addShip(x1, y1, x2, y2);
            }
        }
    }

    public void showGameField(int id) {
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
        String[][] gameField = new String[0][0];
        if(id == 1) {
            gameField = this.field.getGameField();
        } else if (id == 2){
            gameField = this.enemyField.getGameField();
        }

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

    public void showHiddenEnemyGameField() {
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
        String[][] gameField = new String[0][0];
        gameField = this.enemyField.getHiddenGameField()                                        ;

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

    public void initGameFieldEnemy() {
        int coordinatesShips[][] = {{1,4,1,7}, {4,3,6,3}};
        this.addShips(coordinatesShips, 2);
    }

    public boolean isContinue() {
        return this.work;
    }

    public void shot(int x, int y) {
        Cell cell = this.enemyField.getCell(x, y);
        //Если попали, то подбита палуба
        if(cell.getStatus() == 1) {
            //Добавить проверку на уничтожение корабля
            cell.setStatus(2);
            this.enemyField.checkShips();
        }
        // Если пусто, то промах
        else if (cell.getStatus() == 0) {
            cell.setStatus(3);
        }
    }
}
