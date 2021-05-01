package tp1.model;

public class Obstacle {
	private int posFila;
	private int posColumna;

	public Obstacle(int x, int y) {
		this.posFila = x;
		this.posColumna = y;
	}

	public boolean isInPosition(int x, int y) {
		return this.posFila == x && this.posColumna == y;
	}
	
	public String toString() {
		return "*";
	}
	
	
}
