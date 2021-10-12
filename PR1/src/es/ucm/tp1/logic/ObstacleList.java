package es.ucm.tp1.logic;

public class ObstacleList {
    private Obstacle[] obstacles;
    private int nObstacles;
    private Game game;

    public ObstacleList(Game game) {
        this.game = game;
        obstacles = new Obstacle[game.getRoadLenght()];
        nObstacles = 0;
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

    public int getNumberOfObstacles() {
        return nObstacles;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles[nObstacles] = obstacle;
        nObstacles++;
    }
}
