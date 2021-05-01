package tp1.model;

public class Car {
	private int posFila;
	private int posColumna;
	private Game game;

	public Car(Game game, int x, int y) {
		this.posFila = x;
		this.posColumna = y;
		this.game = game;
	}

	public boolean isInPosition(int x, int y) {
		return this.posFila == x && this.posColumna == y;
	}
	
	public String toString() {
		if(hasCrashed()) return "#";
		return ">";
	}

	public void advance() {
		this.posColumna += 1;
	}

	public int getY() {
		return this.posColumna;
	}

	public int getDistanceToGoal() {
		return Game.ROAD_LENGHT - this.getY();
	}

	public boolean hasArrived() {
		return this.getDistanceToGoal() == 0;
	}
	

	public boolean hasCrashed() {
		return game.isObtacleInPosition(this.posFila, this.posColumna); 
	}

	public void goUp() {
		if (this.posFila > 0) this.posFila -= 1;		
	}
	
	public void goDown() {
		if (this.posFila < Game.ROAD_WIDTH - 1) this.posFila += 1;
	}
}
