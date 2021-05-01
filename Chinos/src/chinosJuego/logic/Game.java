package chinosJuego.logic;

import java.util.Random;

public class Game {

	private static final int NUMBER_OF_PLAYERS = 10;
	private Player players[];

	public Game(Random rand) {
		players = new Player[NUMBER_OF_PLAYERS];

		for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			players[i] = new Player(i, rand);
		}

	}

	public void run() {

		int totalPlayers = countIngamePlayers();

		while (totalPlayers > 1) {
			updatePlayers(totalPlayers);
			int totalCoins = countCoins();
			makePredictions(totalCoins);
			printGameInformation(totalPlayers, totalCoins);
			printPlayerInformation();
			totalPlayers = countIngamePlayers();
		}
		
		if (totalPlayers == 1) {
			int id = getLoser();
			System.out.println("The loser is " + id);
		}
	}

	private int getLoser() {
		for (Player player : players) {
			if (player.isInGame()) {
				return player.getId();
			}
		}
		return -1;
	}

	private void printGameInformation(int totalPlayers, int totalCoins) {
		System.out.println("Total players: " + totalPlayers + " Total coins: " + totalCoins);
	}

	private void printPlayerInformation() {
		for (Player player : players) {
			if (player.isInGame()) {
				System.out.println(player);
			}
		}
		System.out.println("------------------");
	}

	private void makePredictions(int totalCoins) {
		for (Player player : players) {
			if (player.isInGame()) {
				player.checkPrediction(totalCoins);
			}

		}
	}

	private int countCoins() {
		int totalCoins = 0;
		for (Player player : players) {
			if (player.isInGame()) {
				totalCoins += player.getCoins();
			}
		}
		return totalCoins;
	}

	private void updatePlayers(int totalPlayers) {
		for (Player player : players) {
			if (player.isInGame()) {
				player.setNumberOfCoins();
				player.makePrediction(totalPlayers);
			}
		}
	}

	private int countIngamePlayers() {
		int totalPlayers = 0;
		for (Player player : players) {
			if (player.isInGame()) {
				totalPlayers++;
			}
		}
		return totalPlayers;
	}

}
