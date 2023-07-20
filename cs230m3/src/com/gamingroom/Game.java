package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	private List<Team> teams;

	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
		teams = new ArrayList<>();
	}

	public Team addTeam(String name) {
		Team t = new Team(teams.size(), name);
		teams.add(teams.size() - 1, t);
		return t;
	}

	@Override
	public String toString() {

		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}
