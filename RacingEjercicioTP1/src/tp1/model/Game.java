package tp1.model;

import java.util.Random;

import tp1.view.GamePrinter;

public class Game {

	public static final int ROAD_WIDTH = 3;
	public static final int ROAD_LENGHT = 20;
	public static final int ROAD_VISIBLE_LENGHT = 8;
	
	private GamePrinter printer;
	private Car car;
	private ObstacleList obstacles;
	private Random rand;

	public Game(long seed) {
		printer = new GamePrinter(this, ROAD_VISIBLE_LENGHT, ROAD_WIDTH);
		car = new Car(this, ROAD_WIDTH/2, 0);
		rand = new Random(seed);
		obstacles = new ObstacleList(rand);
	}

	public boolean isFinished() {
		return car.hasArrived() || car.hasCrashed();
	}

	public String toString() {
		return printer.toString();
	}

	public String getPositionToString(int x, int y) {
		int relativeY = car.getY() + y;
		
		if (car.isInPosition(x, relativeY)) return car.toString();
		if (obstacles.isInPosition(x, relativeY)) return obstacles.getObstacleInPosition(x, relativeY).toString();
		if (relativeY == ROAD_LENGHT - 1) return "$";
		
		return " ";
	}

	public void advance() {
		car.advance();
	}
	
	public String getInfo() {
		return "Distance to goal: " + car.getDistanceToGoal();	
	}

	public String getGameOverInfo() {
		if (car.hasArrived()) {
			return "You reached the goal";
		}
		else {
			return "Ohhh you crashed!";
		}
	}
	
	public boolean isObtacleInPosition(int x, int y) {
		return obstacles.isInPosition(x, y);
	}

	public void goUp() {
		car.goUp();
	}

	public void goDown() {
		car.goDown();
	}
}
