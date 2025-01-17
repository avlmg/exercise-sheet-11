package de.unistuttgart.iste.sqa.pse.sheet11.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;


// @AmoresSchneyinck

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
		//this.reverseOrder();
		//this.sort();

		// TODO Add code for homework exercise 3 (d) here
	}

	/**
	 * Paule moves forwards, collects grains on his way in a queue and places
	 * them in reverse order after he has hit a wall, finishing at the initial stand.
	 */
	private void reverseOrder() {
		//Location initialPoint = paule.getLocation();
		Direction initialDir = paule.getDirection();
		LinkedList<Integer> cornsIndex = new LinkedList<>();
		if (paule.getDirection() == initialDir) {
			while (paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsIndex.addLast(cornAmount);
				paule.move();
			}
			while (!paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsIndex.addLast(cornAmount);
				paule.turnLeft();
				paule.turnLeft();
			}
		}
		if (paule.getDirection() != initialDir) {
			for (int i = 0; i < cornsIndex.size(); i++) {
				if (cornsIndex.get(i) >0) {
					//int cornsToPut = cornsIndex.get(i);
					for (int cornsToPut = cornsIndex.get(i); cornsToPut>0; cornsToPut--) {
						paule.putGrain();
					}
					if (i!=cornsIndex.size()-1) {paule.move();}
				} else if (i!=cornsIndex.size()-1) {paule.move();}
			}
			paule.turnLeft();
			paule.turnLeft();
		}
	}
	/**
	 * TODO add documentation here.
	 */
	private void inOrder() {
		Direction initialDir = paule.getDirection();
		Stack<Integer> cornsStack = new Stack<>();
		// CHANGE TO STACK THE FOLLOWING
		if (paule.getDirection() == initialDir) {
			while (paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsStack.add(cornAmount);
				//cornsIndex.addLast(cornAmount);
				paule.move();
			}
			System.out.println((cornsStack));
			while (!paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsStack.add(cornAmount);
				//cornsIndex.addLast(cornAmount);
				paule.turnLeft();
				paule.turnLeft();
				System.out.println(cornsStack);
			}
		}
		if (paule.getDirection() != initialDir) {
			//for (int i = 0; i < cornsStack.size(); i++) {
			while (!cornsStack.isEmpty()) {
				if (cornsStack.lastElement() >0) {
					//int cornsToPut = cornsIndex.get(i);
					for (int cornsToPut = cornsStack.lastElement(); cornsToPut>0; cornsToPut--) {
						paule.putGrain();
					}
					cornsStack.pop();
					if (!cornsStack.isEmpty()) {paule.move();}

					System.out.println(cornsStack);
				} else if (cornsStack.lastElement() == 0) {
					cornsStack.pop();
					if (!cornsStack.isEmpty()) {paule.move();}
				}
				else if (!cornsStack.isEmpty()) {
					//paule.move();
					System.out.println(cornsStack);
				}
			}
			paule.turnLeft();
			paule.turnLeft();
		}
	}

	/**
	 * Sorts the grains collected by Paule in ascending order and deposits them while returning to the starting field.
	 * Paule moves forward, collects grains, and places them in a PriorityQueue to maintain ascending order.
	 * Upon reaching a wall, Paule deposits the grains in ascending order while returning to the initial stand.
	 */
	private void sort() {
		Direction initialDir = paule.getDirection();
		PriorityQueue<Integer> cornsQueue = new PriorityQueue<>();

		if (paule.getDirection() == initialDir) {
			while (paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsQueue.add(cornAmount);
				paule.move();
			}

			while (!paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsQueue.add(cornAmount);
				paule.turnLeft();
				paule.turnLeft();
			}
		}

		if (paule.getDirection() != initialDir) {
			while (!cornsQueue.isEmpty()) {
				int cornsToPut = cornsQueue.poll();
				for (int i = 0; i < cornsToPut; i++) {
					paule.putGrain();
				}
				if (!cornsQueue.isEmpty()) {
					paule.move();
				}
			}
			paule.turnLeft();
			paule.turnLeft();
		}
	}

	/**
	 * Sorts the grains collected by Paule in the specified order defined by the provided comparator and deposits them
	 * while returning to the starting field.
	 * Paule moves forward, collects grains, and places them in a PriorityQueue using the provided comparator.
	 * Upon reaching a wall, Paule deposits the grains in the specified order while returning to the initial stand.
	 *
	 * @param comparator The comparator defining the order in which Paule should sort the grains.
	 */
	private void sort(Comparator<Integer> comparator) {
		Direction initialDir = paule.getDirection();
		PriorityQueue<Integer> cornsQueue = new PriorityQueue<>(comparator);

		// Collect grains while moving forward
		if (paule.getDirection() == initialDir) {
			while (paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsQueue.add(cornAmount);
				paule.move();
			}

			// Turn around after hitting a wall
			while (!paule.frontIsClear()) {
				int cornAmount = 0;
				while (paule.grainAvailable()) {
					paule.pickGrain();
					cornAmount++;
				}
				cornsQueue.add(cornAmount);
				paule.turnLeft();
				paule.turnLeft();
			}
		}

		// Deposit grains in the specified order while returning
		if (paule.getDirection() != initialDir) {
			while (!cornsQueue.isEmpty()) {
				int cornsToPut = cornsQueue.poll();
				for (int i = 0; i < cornsToPut; i++) {
					paule.putGrain();
				}
				if (!cornsQueue.isEmpty()) {
					paule.move();
				}
			}
			paule.turnLeft();
			paule.turnLeft();
		}
	}

	// TODO Add required helper operations here
}
