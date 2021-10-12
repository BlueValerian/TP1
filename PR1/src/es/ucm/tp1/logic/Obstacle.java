package es.ucm.tp1.logic;

public class Obstacle {
    private int x;
    private int y;
    private Game game;
    private int hp;

    public Obstacle(Game game, int x, int y) {
        this.x = x;
        this.y = y;
        this.game = game;
        hp = 1;
    }

    boolean isInPosition(int x, int y) {
        return this.x == x && this.y == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "░";
    }
}
