package es.ucm.tp1.logic;

public class Coin {
    private int x;
    private int y;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    public String toString() {
        return "¢";
    }
}
