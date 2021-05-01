package chinosJuego;

import java.util.Random;
import chinosJuego.logic.Game;

public class Chinos {

	public static final String WELCOME_MSG = "Welcome to the game!";
	public static final int NUMBER_OF_GAMES = 100;

	public static void main(String[] args) {
		System.out.println(WELCOME_MSG);
		Random rand = new Random();
		
		for (int i = 0; i < NUMBER_OF_GAMES; i++) {
			Game g = new Game(rand);
			g.run();
			System.out.println("***************************************************************");
		}

		// System.exit(0);
		//Para evitar el error "jdwp unable to get jni 1.2 environment"
	}

}
