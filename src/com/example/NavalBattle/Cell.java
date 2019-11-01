package com.example.NavalBattle;

/**
 * status:
 * 0 - пустая ячейка
 * 1 - ячейка занята кораблем
 * 2 - подбитый корабль
 * 3 - промах
 *
 */

public class Cell {
    public int x;
    public int y;
    public int status;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = 0;
    }

}
