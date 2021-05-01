package tp1.model;

import java.util.Random;

public class ObstacleList {
	private Obstacle obstacles[];
	private int nObstacles;

	public ObstacleList(Random rand) {
		obstacles = new Obstacle[Game.ROAD_LENGHT];

		nObstacles = 0;
		for (int i = 5; i < Game.ROAD_LENGHT; i++) {
			if (rand.nextFloat() > 0.3) {
				obstacles[nObstacles] = new Obstacle(rand.nextInt(Game.ROAD_WIDTH), i);
				nObstacles++;
			}

		}
	}

	public boolean isInPosition(int x, int y) {
		return this.getObstacleInPosition(x, y) != null;
	}

	public Obstacle getObstacleInPosition(int x, int y) {
		for (int i = 0; i < nObstacles; i++) {
			if (obstacles[i].isInPosition(x, y)) {
				return obstacles[i];
			}
		}
		return null;
	}

}
