package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class ObstacleList {
    private Obstacle obstacles[];
    private int nObstacles;
    private Game game;
    private Level level;

    public ObstacleList(Random rand) {
        obstacles = new Obstacle[game.getRoadLenght()];
        nObstacles = 0;

        // TODO, poner en otro lado
        for (int i = 0; i < obstacles.length; i++) {
            if (rand.nextFloat() > level.getObstacleFrequency()) {
                addObstacle(new Obstacle(rand.nextInt(game.getRoadWidth()), i));
            }
        }
    }

    public int getSize() {
        return obstacles.length;
    }

    public int getCounter() {
        return nObstacles;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles[nObstacles] = obstacle;
        nObstacles++;
    }

    public int search(int x, int y) {
        boolean found = false;
        for (int i = 0; i < nObstacles && !found; i++) {
            if (obstacles[i].getX() == x && obstacles[i].getY() == y) {
                return i;
            }
        }
        return -1;
    }

    public Boolean hasCrashed() {
        return false;
    }

    public String toString(int i) {
        return obstacles[i].toString();
    }
}
