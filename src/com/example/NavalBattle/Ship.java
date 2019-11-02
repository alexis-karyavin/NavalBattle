package com.example.NavalBattle;

/*
*
* Status:
* 1 - Корабль цел
* 2 - Корабль подбит
* 3 - Корабль уничтожен
*
* */

import java.util.List;

public class Ship {
    private List<Cell> cells;
//    public int x1;
//    public int x2;
//    public int y1;
//    public int y2;

    public int status;

    public Ship(List<Cell> cells) {
        this.cells = cells;
        this.status = 1;
    }

    //Уничтожен ли корабль
    public boolean isDestroyed () {
        int hot = 0;
        for (int i = 0; i < this.cells.size(); i++) {
            Cell cell = this.cells.get(i);
            if (cell.getStatus() == 2) {
                hot++;
            }
        }
        if (hot == this.cells.size()) {
            this.status = 3;
            return true;
        }
        return false;
    }

//    public Ship(int x1, int y1, int x2, int y2) {
//        this.x1 = x1;
//        this.x2 = x2;
//        this.y1 = y1;
//        this.y2 = y2;
//        this.status = 1;
//    }
}
