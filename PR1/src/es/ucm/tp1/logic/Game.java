package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

//	(x, y)
// 	width : 3
//	lenght : 10, 30, 100
// +----------------------------+
// | (0,0) (1,0) (2,0) (3,0) ...|
// | (0,1) (1,1) (2,1) (3,1) ...|
// | (0,2) (1,2) (2,2) (3,2) ...|
// +----------------------------+

public class Game {
	private Player player;
	private int meta;
	private Level level;
	private long seed;
	private Coin coin;
	// private Obstacle obstacle;
	private ObstacleList obstacles;
	private Random rand;

	public Game(long seed, Level level) {
		player = new Player(2, 2, this);
		coin = new Coin(3, 2);
		this.level = level;
		this.seed = seed;
		rand = new Random(seed);
		obstacles = new ObstacleList(rand, this, level);
		crearObstaculos();
		setMeta();
	}

	public void crearObstaculos() {
		for (int i = level.getVisibility() / 2; i < level.getRoadLenght(); i++) {

		}
	}

	public void tryToAddObstacle(Obstacle obstacle, int row, ,double obstacleFrequency) {
		if (rand.nextFloat() > level.getObstacleFrequency()) {
			Obstacle aux;
			aux = new Obstacle(row, rand.nextInt(getRandomLane()));
			obstacles.addObstacle(aux);
		}
	}

	public void tryToAddCoin(Coin coin, int row, double coinFrequency) {
		if (rand.nextFloat() > level.getCoinFrequency()) {
			Coin aux;
			aux = new Coin(row, rand.nextInt(getRandomLane()));
			// coins.addCoin(coin);
		}

	}

	public int getRandomLane() {
		return rand.nextInt(level.getRoadWidth());
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
		else if (obstacles.isInPosition(relativeX, y))
			return obstacles.getObstacleInPosition(relativeX, y).toString();
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
		return obstacles.isInPosition(x, y);
	}

	public int getPlayerHp() {
		return player.getHp();
	}
}
