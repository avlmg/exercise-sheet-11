package de.unistuttgart.iste.sqa.pse.sheet11.presence.tournamenttracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


/**
 * Represents a sports tournament with a set of teams and a list of games between the teams.
 *
 * @author andrevanhoorn
 *
 */
public class Tournament {
	private final String name;
	private final Map<String, Team> teams = new HashMap<>();
	private final List<Game> games = new ArrayList<>();

	/**
	 * Creates a new Tournament with the given name.
	 *
	 * @param name name of the tournament, must not be null or empty
	 * @throws IllegalArgumentException if name is null or empty
	 */
	public Tournament(final String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		this.name = name;
	}

	/**
	 * Register a new team with the given name in this tournament if a team with this name has not been registered before.
	 *
	 * @param name name of the team to be registered, must not be null or empty
	 * @return the newly registered team
	 * @throws IllegalArgumentException if name is null or empty or a team with this name has already been registered
	 */
	public Team registerTeam(final String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		if (this.teams.containsKey(name)) {
			throw new IllegalArgumentException("Team with this name exists");
		}
		final Team newTeam = new Team(name);
		teams.put(name, newTeam);
		return newTeam;
	}

	/**
	 * Create a new game between the given home team and visiting team.
	 *
	 * Note that multiple games between the same team are possible.
	 *
	 * @param homeTeam      the home team, must be a registered team in the tournament and not null
	 * @param vistingTeam  the visiting team, must be a registered team in the tournament and not null
	 * @return the game between the two teams
	 * @throws IllegalArgumentException if homeTeam or visitingTeam is null or not registered in the tournament,
	 *                                  or if both teams are the same, or if the maximum allowed number of games per team is reached
	 */
	public Game createGame(final Team homeTeam, final Team vistingTeam) {
		final Game newGame = new Game(homeTeam, vistingTeam);
		this.games.add(newGame);
		return newGame;
	}

	/**
	 * Get the name of the tournament.
	 *
	 * @return the tournament's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the list of registered games. Note that a new list is created on each call.
	 *
	 * @return the list of registered games
	 */
	public List<Game> getGames() {
		return List.copyOf(games);
	}

	/**
	 * Get the registered teams.
	 *
	 * @return the registered teams
	 */
	public List<Team> getTeams() {
		return new ArrayList<Team>(this.teams.values());
	}

	/**
	 * Automatically creates games for "Everyone against everyone" mode.
	 */
	public void createGamePlan() {
		List<Team> teamList = new ArrayList<>(this.teams.values());

		// Iterate over all unique pairs of teams to create games.
		for (int i = 0; i < teamList.size(); i++) {
			Team homeTeam = teamList.get(i);

			for (int j = i + 1; j < teamList.size(); j++) {
				Team visitingTeam = teamList.get(j);
				createGame(homeTeam, visitingTeam);
			}
		}
	}

	/**
	 * Generates random game results for all games in the tournament.
	 * Assumes the maximum number of goals per team is 5.
	 */
	public void generateGameResults() {
		Random random = new Random();

		for (Game game : games) {
			int scoreHome = random.nextInt(6); // Assuming scores range from 0 to 5.
			int scoreVisiting = random.nextInt(6);

			game.storeResult(scoreHome, scoreVisiting);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tournament other = (Tournament) obj;
		if (!Objects.equals(games, other.games)) {
			return false;
		}
		if (!Objects.equals(name, other.name)) {
			return false;
		}
		if (!Objects.equals(teams, other.teams)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Tournament [name=" + name + ", teams=" + teams + ", games=" + games + "]";
	}
}
