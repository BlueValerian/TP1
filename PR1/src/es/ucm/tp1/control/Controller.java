package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */

	private Game game;

	private Scanner scanner;
	
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);
	}

	public void printGame() {
		System.out.println(printer);
	}
	

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		while (!game.isFinished()) {
			printGame();
			System.out.print(PROMPT);
			String cmd = scanner.nextLine();
			switch (cmd) {
				case "h":
					for (int i = 0; i < HELP.length; i++) {
						System.out.println(HELP[i]);
					}
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
		//printGame();
		if(game.getPlayerHp() == 0){
			printGame();
			System.out.println("You died");
		}
		else {
			printGame();
			System.out.println("You won");
		}
	}

}
