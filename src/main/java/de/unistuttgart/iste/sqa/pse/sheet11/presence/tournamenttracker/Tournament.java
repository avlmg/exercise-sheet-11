/**
 * 
 */
package de.unistuttgart.iste.sqa.pse.sheet11.presence.tournamenttracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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
	 * @param name
	 */
	public Tournament(String name) {
		this.name = name;
	}

	/**
	 * Register a new team with the given name in this tournament if a team with this name has not been registered before. 
	 * 
	 * @param name
	 * @return
	 */
	public Team registerTeam(String name) {
		Team newTeam = null;
		if (this.teams.containsKey(name)) {
			throw new IllegalArgumentException("Team with this name exists");
		}
		newTeam = new Team(name);
		teams.put(name, newTeam);
		return newTeam;
	}

	/**
	 * Create a new game between the given home team and visiting team. 
	 * 
	 * Note that multiple games between the same team are possible.
	 * 
	 * @param homeTeam
	 * @param vistingTeam
	 * @return
	 */
	public Game createGame(Team homeTeam, Team vistingTeam) {
		Game newGame = new Game(homeTeam, vistingTeam);
		this.games.add(newGame);
		return newGame;
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the list of registered games. Note that a new list is created on each call.
	 * 
	 * @return
	 */
	public List<Game> getGames() {
		return games;
	}
	
	/**
	 * Returns the registered teams.
	 * 
	 * @return
	 */
	public List<Team> getTeams() {
		return new ArrayList<Team>(this.teams.values());
	}
	
	// TODO add missing operations here. 
	
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tournament other = (Tournament) obj;
		if (games == null) {
			if (other.games != null)
				return false;
		} else if (!games.equals(other.games))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Tournament [name=" + name + ", teams=" + teams + ", games=" + games + "]";
	}
}