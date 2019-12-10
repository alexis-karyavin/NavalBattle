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

    public void initGameFieldEnemy() {
        int[][] coordinatesShips = {{1,4,1,7}, {4,3,6,3}, {5,7, 5,7}};
        this.addShips(coordinatesShips, 2);
    }

    public boolean isContinue() {
        if (this.enemyField.ships.size() == 0 || this.field.ships.size() == 0 ) {
            return false;
        }
        return true;
    }

    public int shoot(int x, int y) {
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
        return cell.getStatus();
    }
}
