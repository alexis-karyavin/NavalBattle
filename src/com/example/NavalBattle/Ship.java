package com.example.NavalBattle;

/*
*
* Status:
* 1 - Корабль цел
* 2 - Корабль подбит
* 3 - Корабль уничтожен
*
* */

public class Ship {
    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public int status;

    public Ship(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.status = 1;
    }
}
