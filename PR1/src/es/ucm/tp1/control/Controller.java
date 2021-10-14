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
			"[i]nfo: prints gameobject info",
			"[n]one | []: update",
			"[q]: go up",	
			"[a]: go down",
			"[e]xit: exit game",
			"[r]eset: reset game",
			"[t]est: enables test mode", };
	
	private static final String[] INFO = new String[] {
		"[Car] the racing car",
		"[Coin] gives 1 coin to the player",
		"[Obstacle] hits car",
	};
	/* @formatter:on */

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
		boolean doExit = false;

		printGame();
		while (!doExit) {
			Boolean wrongCommand = false;
			Boolean none = false;
			Boolean help = false;
			Boolean info = false;
			Boolean test = false;
			Boolean reset = false;

			System.out.print(PROMPT);
			String cmd = scanner.nextLine();
			System.out.println("[DEBUG] Executing: " + cmd);
			cmd = cmd.toLowerCase();
			switch (cmd) {
				case "h":
				case "help":
					for (String i : HELP) {
						System.out.println(i);
					}
					help = true;
					break;
				case "q":
					game.goUp();
					break;
				case "a":
					game.goDown();
					break;
				case "":
				case "n":
				case "none":
					none = true;
					break;
				case "e":
				case "exit":
					doExit = true;
					break;
				case "i":
					info = true;
					for (String i : INFO) {
						System.out.println(i);
					}
				case "t":
					test = true;
					// TODO Como desactivar el timer?
					break;
				case "r":
				case "reset":
					game.reset();
					printGame();
					reset = true;
					break;
				default:
					wrongCommand = true;
					break;
			}
			if (!(info || help || doExit || wrongCommand || reset)) {
				game.update();
				doExit = (game.playerHasCrashed() || game.playerHasArrived());
				game.removeDeadCoins();
				game.setRecord(game.showTimeSeconds());
				printGame();
			}
			if (wrongCommand) {
				System.out.println(UNKNOWN_COMMAND_MSG);
			}
		}
		System.out.println(printer.endMessage());
	}
}
