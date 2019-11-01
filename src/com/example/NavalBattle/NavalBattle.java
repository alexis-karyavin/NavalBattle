package com.example.NavalBattle;

public class NavalBattle {

    public static void main(String[] args) {
        System.out.print("Hello");
        Player pl = new Player();

        int coordinatesShips[][] = {{0,0,2,0}, {5,0,5,2}};

        pl.addShips(coordinatesShips);
    }
}
