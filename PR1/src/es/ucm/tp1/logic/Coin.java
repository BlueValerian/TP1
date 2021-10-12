package es.ucm.tp1.logic;

public class Coin {
    private int x;
    private int y;
    private Game game;

    public Coin(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
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
        return "¢";
    }
}
