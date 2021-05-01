package tp1.control;

import java.util.Scanner;

import tp1.model.Game;

public class Controller {

	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" + 
			"[q] go up%n"+
			"[a] go down%n"+
			"[h]elp: show this help%n"+ 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n" + 
			"[n]one | []: advance%n");

	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

	private Game game;
	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
	}

	public void printGame() {
		System.out.println(game);
	}

	public void run() {
		while (!game.isFinished()) {
			printGame();
			System.out.print(prompt);
			String cmd = scanner.nextLine();
			switch (cmd) {
			case "h":
				System.out.println(helpMsg);
				break;
			case "n":
				game.advance();
				break;
			case "q":
				game.goUp();
				game.advance();
				break;
			case "a":
				game.goDown();
				game.advance();
			}
		}
		
		printGame();
		System.out.println("Game Over!");
		System.out.println(game.getGameOverInfo());
	}


}
