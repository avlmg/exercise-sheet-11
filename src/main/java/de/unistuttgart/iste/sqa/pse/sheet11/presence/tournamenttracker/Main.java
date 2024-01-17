package de.unistuttgart.iste.sqa.pse.sheet11.presence.tournamenttracker;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// Step 1: Create a reference to the singleton instance of the TTServer class.
		TTServer tournamentServer = TTServer.getInstance();

		// Step 2: Create a new tournament named "MiniLänderCup" in the server instance.
		final Tournament miniLaenderCup = tournamentServer.createTournament("MiniLänderCup");

		// Step 3: Register the teams "Germany," "Netherlands," and "Spain" in the tournament.
		final Team germany = miniLaenderCup.registerTeam("Germany");
		final Team netherlands = miniLaenderCup.registerTeam("Netherlands");
		final Team spain = miniLaenderCup.registerTeam("Spain");

		// Step 4: Step by step (without control structures), create a list of games.
		// Each team plays exactly once against every other team (game mode: "Everyone against everyone without replay").
		final Game game1 = miniLaenderCup.createGame(germany, netherlands);
		final Game game2 = miniLaenderCup.createGame(germany, spain);
		final Game game3 = miniLaenderCup.createGame(netherlands, spain);

		// Step 5: Assign random results to all games.
		assignRandomResult(game1);
		assignRandomResult(game2);
		assignRandomResult(game3);

		// Print the results for demonstration purposes.
		System.out.println(game1);
		System.out.println(game2);
		System.out.println(game3);
	}

	// Helper method to assign random results to a game.
	private static void assignRandomResult(Game game) {
		// Use a random number generator to assign random scores.
		Random random = new Random();
		int scoreHome = random.nextInt(6); // Assuming scores range from 0 to 5.
		int scoreVisiting = random.nextInt(6);

		// Store the random result in the game.
		game.storeResult(scoreHome, scoreVisiting);
	}
}