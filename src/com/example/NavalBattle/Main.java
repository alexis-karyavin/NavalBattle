package com.example.NavalBattle;

public class Main {
    public static void main(String[] args) {
        int[][] coordinatesShips = {{0,0,2,0}, {5,0,5,2}};
        Controller controller =  new Controller(coordinatesShips);
//        controller.initConsole();
        FrameNavalBattle fr = new FrameNavalBattle(controller);
        fr.setVisible(true);
    }
}
