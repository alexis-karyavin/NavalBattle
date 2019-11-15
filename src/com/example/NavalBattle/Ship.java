package com.example.NavalBattle;

/*
*
* Status:
* 1 - Корабль цел
* 2 - Корабль подбит
* 3 - Корабль уничтожен
*
*
* Type:
* 1 - Horizontal
* 2 - Vertical
* 3 - Single Deck
* */

import java.util.List;

public class Ship {
    private List<Cell> cells;
    private int type;

    public int status;

    public Ship(List<Cell> cells) {
        this.cells = cells;
        this.status = 1;
        this.setType();
    }

    private void setType() {
        if(this.cells.size() != 1) {
            if(this.cells.get(0).x == this.cells.get(1).x) {
                this.type = 1;
            } else if (this.cells.get(0).y == this.cells.get(1).y) {
                this.type = 2;
            }
        } else {
            this.type = 3;
        }
    }

    public int getType() {
        return this.type;
    }

    //Уничтожен ли корабль
    public boolean isDestroyed () {
        int hot = 0;
        for (int i = 0; i < this.cells.size(); i++) {
            Cell cell = this.cells.get(i);
            if (cell.getStatus() == 2) {
                hot++;
            }
        }
        if (hot == this.cells.size()) {
            this.status = 3;
            return true;
        }
        return false;
    }

    public List<Cell> getCells() {
        return this.cells;
    }
}
