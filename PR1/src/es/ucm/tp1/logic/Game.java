package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

public class Game {
	private Player player;
	private Obstacle obstacle;
	private Level level;
	private ObstacleList obstacles;
	private CoinList coins;
	private Random rand;
	private int nCycles;
	// Timer
	private double startTime;
	private double elapsedTime;
	private double elapsedSeconds;
	private double secondsDisplay;
	// Record
	private double record;
	// Test
	private boolean testValue;

	public Game(long seed, Level level) {
		startTimer();
		this.rand = new Random(seed);
		this.level = level;
		inicialice();
	}

	private void inicialice() {
		nCycles = 0;
		player = new Player(this, 0, (getRoadWidth() / 2));
		obstacles = new ObstacleList(this);
		coins = new CoinList(this);
		testValue = true;
		setRecord(0);
		tryToGenerate();
	}

	// TODO hacer que sea en primera ejecucion 0,00 segundos y no 0,02 segundos
	// PREGUNTAR AL PROFESOR
	public void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public void setTestValue(boolean testValue) {
		this.testValue = testValue;
	}

	public double showTimeSeconds() {
		elapsedTime = System.currentTimeMillis() - startTime;
		elapsedSeconds = elapsedTime / 1000;
		secondsDisplay = elapsedSeconds % 60;
		return secondsDisplay;
	}

	public void toggleTest() {
		setTestValue(false);
	}

	public boolean getTestValue() {
		return this.testValue;
	}

	public int getVisibility() {
		return level.getVisibility();
	}

	public int getRoadWidth() {
		return level.getWidth();
	}

	public int getRoadLenght() {
		return level.getLength();
	}

	public double getObstacleFrequency() {
		return level.getObstacleFrequency();
	}

	public double getCoinFrequency() {
		return level.getCoinFrequency();
	}

	// TODO PREGUNTAR AL PROFESOR
	// Que va aqui?
	public String getGameStatus() {
		return "";
	}

	public String positionToString(int x, int y) {
		int relativeX = player.getX() + x;
		if (player.isInPosition(relativeX, y)) {
			return player.toString();
		} else if (obstacles.isInPosition(relativeX, y)) {
			return obstacles.getObstacleInPosition(relativeX, y).toString();
		} else if (coins.isInPosition(relativeX, y)) {
			return coins.getCoinInPosition(relativeX, y).toString();
		} else if (relativeX == getRoadLenght() - 1)
			return "¦";
		return "";
	}

	public void goUp() {
		player.goUp();
	}

	public void goDown() {
		player.goDown();
	}

	public void update() {
		// TODO comprobar que el coche no se salga de la carretera, se mueve en diagonal
		// Pero eso ya lo hace en el propio player, no?
		player.advance();
		nCycles++;

	}

	public boolean playerHasCrashed() {
		return player.hasCrashed();
	}

	public boolean playerHasArrived() {
		return player.hasArrived();
	}

	public int getPlayerX() {
		return player.getX();
	}

	public int getPlayerY() {
		return player.getY();
	}

	public int getActualDistanceToGoal() {
		return getRoadLenght() - getPlayerX();
	}

	public boolean isObstacleInPosition(int x, int y) {
		return obstacles.isInPosition(x, y);
	}

	public boolean isCoinInPosition(int x, int y) {
		return coins.isInPosition(x, y);
	}

	public int getRandomLane() {
		return (int) (getrandomNumber() * getRoadWidth());
	}

	private double getrandomNumber() {
		return rand.nextDouble();
	}

	public void tryToAddObstacle(Obstacle obstacle, double obstacleFrequency) {
		if (rand.nextDouble() < obstacleFrequency && !coins.isInPosition(obstacle.getX(), obstacle.getY())) {
			obstacles.addObstacle(obstacle);
		}
	}

	public void tryToAddCoin(Coin coin, double coinFrequency) {
		if (rand.nextDouble() < coinFrequency && !obstacles.isInPosition(coin.getX(), coin.getY())) {
			coins.addCoin(coin);
		}
	}

	public void tryToGenerate() {
		for (int x = getVisibility() / 2; x < getRoadLenght(); x++) {
			tryToAddObstacle(new Obstacle(this, x, getRandomLane()), getObstacleFrequency());
			tryToAddCoin(new Coin(this, x, getRandomLane()), getCoinFrequency());
		}
	}

	public void removeDeadCoins() {
		coins.removeDeadCoins();
	}

	public String levelName() {
		return level.toString();
	}

	public int getCoinsCounter() {
		return coins.getDeadCoinsCounter();
	}

	public int getTotalCoins() {
		return coins.getCoinsCounter() + coins.getDeadCoinsCounter();
	}

	public int getNumberCycles() {
		return nCycles;
	}

	public int getTotalObstacles() {
		return obstacles.getNumberOfObstacles();
	}

	public void reset() {
		// TODO usar de nuevo el constructor
		inicialice();
	}

	public void setRecord(double record) {
		this.record = record;
	}

	public double getRecord() {
		return record;
	}
}
