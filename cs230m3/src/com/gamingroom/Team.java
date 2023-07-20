package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	private List<Player> players;

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
		players = new ArrayList<>();
	}

	public Player addPlayer(String name) {
		long end = players.size() ;
		players.add(new Player(end, name));
		return players.get((int) end);
	}

	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
