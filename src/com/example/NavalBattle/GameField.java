package com.example.NavalBattle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Cell getCell(int x, int y) {
        return this.board[x][y];
    }

    public void checkShips() {
        for (int i = 0; i < this.ships.size(); i++) {
            Ship ship = this.ships.get(i);
            if (ship.isDestroyed()) {
                //В поля, которые вокруг корабля, вставляем промахи
                ArrayList<ArrayList<Integer>> arrMisses = initArrMisses(ship);
                for (ArrayList<Integer> list : arrMisses) {
                    // 0: x, 1: y
                    int x = list.get(0);
                    int y = list.get(1);
                    this.board[x][y].setStatus(3);
                }
                //Удаляем корабля из листа
                this.ships.remove(i);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> initArrMisses(Ship ship) {
        ArrayList<ArrayList<Integer>> arrMisses = new  ArrayList<ArrayList<Integer>>();
        List<Cell> cells = ship.getCells();
        if(ship.getType() == 1) {
            addPointsToList(arrMisses, cells.get(0).x, cells.get(0).y - 1);
            addPointsToList(arrMisses, cells.get(0).x, cells.get(cells.size() - 1).y + 1);

            for (int i = 0; i < cells.size(); i++) {
                addPointsToList(arrMisses, cells.get(i).x - 1, cells.get(i).y);
                addPointsToList(arrMisses, cells.get(i).x + 1, cells.get(i).y);
            }
        } else if (ship.getType() == 2) {
            addPointsToList(arrMisses, cells.get(0).x - 1, cells.get(0).y);
            addPointsToList(arrMisses, cells.get(cells.size() - 1).x + 1, cells.get(0).y);

            for (int i = 0; i < cells.size(); i++) {
                addPointsToList(arrMisses, cells.get(i).x, cells.get(i).y - 1);
                addPointsToList(arrMisses, cells.get(i).x, cells.get(i).y + 1);
            }
        } else if (ship.getType() == 3) {
            addPointsToList(arrMisses, cells.get(0).x + 1, cells.get(0).y);
            addPointsToList(arrMisses, cells.get(0).x - 1, cells.get(0).y);
            addPointsToList(arrMisses, cells.get(0).x, cells.get(0).y + 1);
            addPointsToList(arrMisses, cells.get(0).x, cells.get(0).y - 1);
        }

        return arrMisses;
    }

    private void addPointsToList( ArrayList<ArrayList<Integer>> list, int x, int y) {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.add(y);
        list.add(tmp);
    }
}
