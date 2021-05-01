package chinosJuego.logic;

import java.util.Random;

public class Player {
	private static final int MAX_NUMBER_OF_COINS = 3;
	private int id;
	private int coins;
	private int prediction;
	private boolean inGame;
	Random rand;
	
	public Player(int id, Random rand) {
		this.id = id;
		this.coins = 0; //Entre 0 y 3
		this.prediction = 0; //Entre 0 y 3*JugadoresActivos
		this.rand = rand;
		this.inGame = true;
	}
	
	public void setNumberOfCoins() {
		coins = rand.nextInt(MAX_NUMBER_OF_COINS + 1);
	}
	
	public void makePrediction(int totalPlayers) {
		prediction = totalPlayers + rand.nextInt(totalPlayers);
	}
	
	public String toString() {
		return "Player " + this.id + " coins: " + this.coins + " prediction: " + this.prediction + " inGame: " + this.inGame;
	}

	public int getCoins() {
		return this.coins;
	}

	public void checkPrediction(int totalCoins) {
		if (this.prediction == totalCoins) {
			this.inGame = false;
		}
	}

	public boolean isInGame() {
		return inGame;
	}

	public int getId() {
		return id;
	}
}
