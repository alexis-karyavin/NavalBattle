package com.example.NavalBattle;

import javax.security.auth.callback.NameCallback;
import java.util.Scanner;

public class NavalBattle {

    private Player pl;

    public NavalBattle( int[][] coordinatesShips ) {
        pl = new Player();
        pl.addShips(coordinatesShips, 1);
    }

    public int shoot(int x, int y) {
       return pl.shoot(x,y);
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


}
