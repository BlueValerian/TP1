package es.ucm.tp1.logic;

public class Player {
	private int x;
	private int y;
	private Game game;
	private int hp;

	public Player(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		hp = 1;
		this.game = game;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHp() {
		return hp;
	}

	public Boolean isAlive() {
		return this.hp > 0;
	}

	public String toString() {
		if (isAlive())
			return ">";
		return "@";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public void advance() {
		x++;
	}

	public void goUp() {
		if (y > 0) {
			y--;
		}
	}

	public void goDown() {
		if (y < game.getRoadWidth() - 1)
			y++;
	}

	public boolean hasCrashed() {
		if (game.isObstacleInPosition(x, y)) {
			hp--;
			return true;
		}
		return false;
	}

	public boolean hasArrived() {
		return (game.getRoadLenght() - getX() == 0);
	}

}
