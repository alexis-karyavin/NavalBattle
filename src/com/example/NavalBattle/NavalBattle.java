package com.example.NavalBattle;

import java.util.Scanner;

public class NavalBattle {

    public static void main(String[] args) {
        Player pl = new Player();

        int coordinatesShips[][] = {{0,0,2,0}, {5,0,5,2}};

        //Добавляем корабли
        pl.addShips(coordinatesShips, 1);

        //Доабвляем корабли сопернику
//        pl.initGameFieldEnemy();

        while (pl.isContinue()) {
            System.out.println("Вы:");
            pl.showGameField(1);

            System.out.println("Соперник:");
            pl.showHiddenEnemyGameField();

            System.out.println("Куда шмальнуть братишка?");

            Scanner inX = new Scanner(System.in);
            System.out.print("x: ");
            int x = inX.nextInt();
            Scanner inY = new Scanner(System.in);
            System.out.print("y: ");
            int y = inY.nextInt();
            pl.shot(x, y);
        }

    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
