package com.example.NavalBattle;


import java.util.ArrayList;

public class GameField {
    public Cell[][] board;
    public ArrayList<Ship> ships;

    public GameField() {
        board = new Cell[10][10];
        ships = new ArrayList<Ship>();
        for (var i =0; i < 10; i++) {
            for (var j = 0; i < 10; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void addShip(int x1, int y1, int x2, int y2) { //Нужна проверка на выход из игрового поля!!
        ships.add(new Ship(x1,y1,x2,y2));
        for (var i = x1; i < x2; i++) {
            for (var j = y1; j < y2; j++) {
                board[i][j].status = 1;
            }
        }
    }
}
