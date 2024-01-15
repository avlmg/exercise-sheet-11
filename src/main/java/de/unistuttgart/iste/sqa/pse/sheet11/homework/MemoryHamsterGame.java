package de.unistuttgart.iste.sqa.pse.sheet11.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

// @Amores Schneyinck

/**
 * Class to implement homework exercises 1, 2 and 3 of sheet 11.
 */
public class MemoryHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new MemoryHamsterGame.<br>
	 * Do not modify!
	 */
	public MemoryHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/order.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	@Override
	protected void run() {
		// Comment any operation call out, to run the others on their own.
		this.inOrder();
		this.reverseOrder();
		this.sort();

		// TODO Add code for homework exercise 3 (d) here
	}

	/**
	 * TODO add documentation here.
	 */
	private void reverseOrder() {
		// TODO implement homework exercise 1 (b)
		Location initialPoint = paule.getLocation();
		Direction initialDir = paule.getDirection();
		Queue<Location> cornsIndex = new LinkedList<>();
		
	}

	/**
	 * TODO add documentation here.
	 */
	private void inOrder() {
		// TODO implement homework exercise 2 (b)
	}

	/**
	 * TODO add documentation here.
	 */
	private void sort() {
		// TODO implement homework exercise 3 (b)
	}

	// TODO Add Operation for homework exercise 3 (c) here

	// TODO Add required helper operations here
}
