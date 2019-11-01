package com.example.NavalBattle;

public class NavalBattle {

    public static void main(String[] args) {
        Player pl = new Player();

        int coordinatesShips[][] = {{0,0,2,0}, {5,0,5,2}};

        pl.addShips(coordinatesShips);

        pl.showGameField();
    }
}
