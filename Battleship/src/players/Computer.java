/**
 * Name:			Raffi Alan Bezirjian (29538690)
 * COMP249
 * Assignment #:	1
 * Due Date:		September 21, 2018
 */
package players;

import data.BattleshipBoard;
import data.Coord;

/**
 * Represents a computer {@link Player} of the {@link BattleshipBoard}.
 * @author Raffi Alan Bezirjian
 *
 */
public class Computer extends PlayerAdapter {
	
	/**
	 * Default constructor which takes the id which is used
	 * to identify this player. This id cannot be changed.
	 * @param id
	 */
	public Computer(String id){
		super(id);
	}

	@Override
	public Coord fire() {
		Coord c = this.getCoord();
		System.out.println(this.getId() + " fired at: " + c.toString());
		return c;
	}

	@Override
	public Coord placeGrenade() {
		return this.getCoord();
	}

	@Override
	public Coord placeShip() {
		return this.getCoord();
	}

	@Override
	public void invalidPlacement(String errorMesage) {
		//doesn't need to do anything
	}
	
	/**
	 * Generates an implicitly valid coordinate (there is no validation check)
	 * @return A valid Coordinate.
	 */
	@Override
	protected Coord getCoord(){
		int row = (int)Math.round(Math.random() * (Coord.ROW_MAX - 1)+ 1);
		char col = Coord.COL_CHARACTERS[(int)Math.round(Math.random() * (Coord.COL_CHARACTERS.length-1))];
		
		return new Coord(row, col);
	}
}
