package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	private Player player;
	private int meta;
	private Level level;
	private long seed;
	private Coin coin;
	private Obstacle obstacle;
	private ObstacleList obstacles;
	private Random rand;

	public Game(long seed, Level level) {
		player = new Player(0, 1, this);
		// obstacle = new Obstacle(1, 2);
		// coin = new Coin(2, 2);
		this.level = level;
		this.seed = seed;
		obstacles = new ObstacleList(rand, this, level);
		setMeta();
	}

	public void toggleTest() {
		// TODO
	}

	public int getVisibility() {
		return level.getVisibility();
	}

	public int getRoadWidth() {
		return level.getRoadWidth();
	}

	public int getRoadLenght() {
		return level.getRoadLenght();
	}

	public String getGameStatus() {
		return "";
	}

	// Meta
	public void setMeta() {
		meta = level.getRoadLenght();
	}

	public int getMeta() {
		return meta;
	}

	public String metaToString() {
		return "¦";
	}

	public String positionToString(int x, int y) {
		int relativeX = player.getX() + x;
		if (player.isInPosition(relativeX, y))
			return player.toString();
		else if (obstacle.isInPosition(relativeX, y))
			return obstacle.toString();
		else if (coin.isInPosition(relativeX, y))
			return coin.toString();
		else if (relativeX == level.getRoadLenght() - 1)
			return metaToString();

		return " ";
	}

	public void advance() {
		player.advance();
	}

	public void goUp() {
		player.goUp();
	}

	public void goDown() {
		player.goDown();
	}

	public boolean isFinished() {
		return player.hasCrashed() || player.hasArrived();
	}

	public boolean isObstacleInPosition(int x, int y) {
		return obstacle.isInPosition(x, y);
	}

	public int getPlayerHp() {
		return player.getHp();
	}

}
