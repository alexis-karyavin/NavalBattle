package com.example.NavalBattle;

import javax.security.auth.callback.NameCallback;
import java.util.Scanner;

public class NavalBattle {

    private Player pl;
    private int[][] coodinatesShip;

    public NavalBattle( int[][] coordinatesShips ) {
        pl = new Player();
        pl.addShips(coordinatesShips, 1);
    }

    public int shoot(int x, int y) {
       return pl.shot(x,y);
    }

    public String[][] getFieldPlayerString() {
        return pl.field.getGameField();
    }

    public String[][] getFieldEnemyString() {
        return pl.enemyField.getGameField();
    }

    public boolean isContinue() {
        return pl.isContinue();
    }

    //    public void checkButtons() {
//        pl.enemyField.getGameField()
//    }



//    public static void main(String[] args) {
//        Player pl = new Player();
//
//        int coordinatesShips[][] = {{0,0,2,0}, {5,0,5,2}};
//
//        //Добавляем корабли
//        pl.addShips(coordinatesShips, 1);
//
//        //Доабвляем корабли сопернику
////        pl.initGameFieldEnemy();
//
//        while (pl.isContinue()) {
//            System.out.println("Вы:");
//            pl.showGameField(1);
//
//            System.out.println("Соперник:");
//            pl.showHiddenEnemyGameField();
//
//            System.out.println("Куда шмальнуть братишка?");
//
//            Scanner inX = new Scanner(System.in);
//            System.out.print("x: ");
//            int x = inX.nextInt();
//            Scanner inY = new Scanner(System.in);
//            System.out.print("y: ");
//            int y = inY.nextInt();
//            pl.shot(x, y);
//        }
//
//    }

}
