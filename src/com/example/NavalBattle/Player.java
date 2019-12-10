package com.example.NavalBattle;

public class Player {
    public GameField field;

    public Player() {
        field = new GameField();
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

    public boolean isLose() {
        return field.ships.size() == 0;
    }

//    public boolean isContinue() {
//        if (this.enemyField.ships.size() == 0 || this.field.ships.size() == 0 ) {
//            return false;
//        }
//        return true;
//    }

    public int shoot(int x, int y, Player player) {
        Cell cell = player.field.getCell(x, y);
        //Если попали, то подбита палуба
        if(cell.getStatus() == 1) {
            //Добавить проверку на уничтожение корабля
            cell.setStatus(2);
            player.field.checkShips();
        }
        // Если пусто, то промах
        else if (cell.getStatus() == 0) {
            cell.setStatus(3);
        }
        return cell.getStatus();
    }
}
