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
//    private boolean isDestroyed () {
//        for (int i = 0; i < this.cells.length; i++) {
//            if (this.cells[i].getStatus() == 2
//        }
//    }

//    public Ship(int x1, int y1, int x2, int y2) {
//        this.x1 = x1;
//        this.x2 = x2;
//        this.y1 = y1;
//        this.y2 = y2;
//        this.status = 1;
//    }
}
