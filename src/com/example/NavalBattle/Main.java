package com.example.NavalBattle;

public class Main {
    public static void main(String[] args) {
        int[][] coordinatesShips = {{0,0,2,0}, {5,0,5,2}};
        NavalBattle battle =  new NavalBattle(coordinatesShips);

        FrameNavalBattle fr = new FrameNavalBattle(battle);
        fr.setVisible(true);
    }
}
