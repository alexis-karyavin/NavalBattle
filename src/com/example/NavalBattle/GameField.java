package com.example.NavalBattle;


import java.util.ArrayList;
import java.util.List;

public class GameField {
    private Cell[][] board;
    public ArrayList<Ship> ships;

    public GameField() {
        this.board = new Cell[10][];
        this.ships = new ArrayList<Ship>();
        for (var i = 0; i < this.board.length; i++) {
            this.board[i] = new Cell[10];
            for (var j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = new Cell(i, j);
            }
        }
    }

    public void addShip(int x1, int y1, int x2, int y2) { //Нужна проверка на выход из игрового поля!!
//        this.ships.add(new Ship(x1,y1,x2,y2));
        List<Cell> cellsShip = new ArrayList<>();

        //Корабль в строку
        if(x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                this.board[x1][i].setStatus(1);
                cellsShip.add(this.board[x1][i]);
            }
        }
        //Корабль в столбец
        else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                this.board[i][y1].setStatus(1);
                cellsShip.add(this.board[i][y1]);
            }
        }
        this.ships.add(new Ship(cellsShip));
    }

    public String[][] getGameField() {
        String[][] gameField;
        gameField = new String[this.board.length][];
        for (var i = 0; i < this.board.length; i++) {
            gameField[i] = new String[this.board[i].length];
            for (var j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j].getStatus() == 1) {
                    gameField[i][j] = "K";
                } else if (this.board[i][j].getStatus() == 2) {
                    gameField[i][j] = "X";
                } else if (this.board[i][j].getStatus() == 3) {
                    gameField[i][j] = "*";
                } else {
                    gameField[i][j] = " ";
                }
            }
        }
        return gameField;
    }

    public String[][] getHiddenGameField() {
        String[][] gameField;
        gameField = new String[this.board.length][];
        for (var i = 0; i < this.board.length; i++) {
            gameField[i] = new String[this.board[i].length];
            for (var j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j].getStatus() == 2) {
                    gameField[i][j] = "X";
                } else if (this.board[i][j].getStatus() == 3) {
                    gameField[i][j] = "*";
                } else {
                    gameField[i][j] = " ";
                }
            }
        }
        return gameField;
    }

    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }

    public void checkShips() {
        for (int i = 0; i < this.ships.size(); i++) {
            Ship ship = this.ships.get(i);
            if (ship.isDestroyed()) {
                this.ships.remove(i);
            }
        }
    }

//    private Ship getShip(int x, int y) {
//        for (int i = 0; i < this.ships.size(); i++) {
//
//        }
//    }
}
