package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class ObstacleList {
    private Obstacle obstacles[];
    private int nObstacles;
    private Game game;
    private Level level;
    private Random rand;

    public ObstacleList(Random rand, Game game, Level level) {
        this.game = game;
        this.level = level;
        obstacles = new Obstacle[game.getRoadLenght()];
        nObstacles = 0;

        // TODO, poner en otro lado
    }

    // public int getSize() {
    // return obstacles.length;
    // }

    public int getCounter() {
        return nObstacles;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles[nObstacles] = obstacle;
        nObstacles++;
    }

    // TODO cambiar por otra cosa, o el getObstacleInPosition vale tambien
    public int search(int x, int y) {
        boolean found = false;
        for (int i = 0; i < nObstacles && !found; i++) {
            if (obstacles[i].getX() == x && obstacles[i].getY() == y) {
                return i;
            }
        }
        return -1;
    }

    public Obstacle getObstacleInPosition(int x, int y) {
        for (int i = 0; i < nObstacles; i++) {
            if (obstacles[i].isInPosition(x, y)) {
                return obstacles[i];
            }
        }
        return null;
    }

    public boolean isInPosition(int x, int y) {
        return this.getObstacleInPosition(x, y) != null;
    }

    public String toString(int i) {
        return obstacles[i].toString();
    }
}
