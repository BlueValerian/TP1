package tp1;

import java.util.Scanner;

import tp1.control.Controller;
import tp1.model.Game;

public class RacingGame {
	
	public static final String WelcomeMsg = String.format("Welcome to the racing game");
	
	public static void main(String[] args) {
		System.out.println(WelcomeMsg);
		Game game = new Game(0);
		Scanner scanner = new Scanner(System.in);
		
		Controller controller = new Controller(game, scanner);
		controller.run();
	}
}
