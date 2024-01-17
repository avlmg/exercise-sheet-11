package de.unistuttgart.iste.sqa.pse.sheet11.presence.tournamenttracker;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides a Tournament Server with the functionality to create sports tournaments.
 *
 * @author andarevanhoorn
 *
 */
public class TTServer {
	private static final TTServer instance = new TTServer();

	private final Map<String, Tournament> tournaments = new HashMap<String, Tournament>();

	/**
	 * Private constructor to prevent instantiation.
	 */
	private TTServer() {}

	/**
	 * Creates and registers a new tournament with the given name.
	 *
	 * @param name name of the tournament, must not be null or empty
	 * @return the new tournament
	 * @throws IllegalArgumentException if name is null or empty or a tournament with this name has already been registered
	 */
	public Tournament createTournament(final String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		if (this.tournaments.containsKey(name)) {
			throw new IllegalArgumentException("Tournament with the name exists");
		}
		final Tournament newTournament = new Tournament(name);
		this.tournaments.put(name, newTournament);
		return newTournament;
	}

	/**
	 * Returns the singleton instance of the Tournament Server.
	 *
	 * @return the singleton instance of the Tournament Server.
	 */
	public static TTServer getInstance() {
		return TTServer.instance;
	}
}
