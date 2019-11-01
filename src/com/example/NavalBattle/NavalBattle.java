package com.example.NavalBattle;

public class NavalBattle {

    public static void main(String[] args) {
        Player pl = new Player();

        int coordinatesShips[][] = {{0,0,2,0}, {5,0,5,2}};

        //Добавляем корабли
        pl.addShips(coordinatesShips, 1);

        //Доабвляем корабли сопернику
        pl.initGameFieldEnemy();

        System.out.println("Ваше игровое поле:");
        pl.showGameField(1);
    }
}
