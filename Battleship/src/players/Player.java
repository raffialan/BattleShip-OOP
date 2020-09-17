/**
 * Name:			Raffi Alan Bezirjian (29538690)
 * COMP249
 * Assignment #:	1
 * Due Date:		September 21, 2018
 */
package players;

import data.Coord;

/**
 * Interface for a player of the battleship game.
 * 
 * @author Raffi Alan Bezirjian
 */
public interface Player {
	
	/**
	 * Gets then player identifier, usually the name of the player. 
	 * @return Returns a string identifier.
	 */
	public String getId();
	
	/**
	 * A way to keep track of the scores between players.
	 * @return The amount of points this player has accumulated.
	 */
	public int getPoints();
	
	/**
	 * Provides a way to add a point to this player's score.
	 */
	public void addPoint();
	
	/**
	 * Method which dictates if a player's turn should be skipped
	 * @return <strong>true</strong> if the player should skip its next turn.
	 */
	public boolean isSkipped();
	
	/**
	 * Method which sets skip turn flag to given parameter.
	 * @param skipped whether then next turn should be skipped.
	 */
	public void setSkipped(boolean skipped);
	
	/**
	 * Method which is used to ask the player to return a coordinate
	 * which the board will consider a "fire" event.
	 * @return A coordinate on the board.
	 */
	public Coord fire();
	
	/**
	 * Method which is used to ask the player to return a coordinate
	 * which the board will use as to place a grenade. 
	 * @return A coordinate on the board.
	 */
	public Coord placeGrenade();
	
	/**
	 * Method which is used to ask the player to return a coordinate
	 * which the board will se to place a ship.
	 * @return A coordinate on the board.
	 */
	public Coord placeShip();
	
	/**
	 * Method used to indicate that a placement choice made by this player
	 * is not valid for a reason indicate by the string parameter. 
	 * @param errorMesage A brief description of the problem with the chosen
	 * 				placement
	 */
	public void invalidPlacement(String errorMesage);
}
