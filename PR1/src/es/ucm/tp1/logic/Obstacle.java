package es.ucm.tp1.logic;

public class Obstacle {
    public int x;
    public int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    public String toString() {
        return "░";
    }
}
