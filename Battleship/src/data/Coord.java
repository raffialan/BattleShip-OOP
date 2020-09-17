/**
 * Name:			Raffi Alan Bezirjian (29538690)
 * COMP249
 * Assignment #:	1
 * Due Date:		September 21, 2018
 */
package data;

/**
 * Convenient data class used to store Battleship coordinates
 * in the form of (integer, character). These coordinates must
 * within the range of {@link COL_CHARACTERS} and 1-{@link ROW_MAX}
 * for the column and row respectively.
 * <br /><br />
 * If the object is initialized with invalid coordinate, then the
 * row and the column are set to {@link INVALID_ROW} and 
 * {@link INVALID_COL} respectively.
 * <br /><br />
 * <strong>Note: </strong> the implementation of this class should always
 * make sure the Coord is valid using the static method provided with this 
 * class {@link Coord#isValidCoord(Coord)}.
 * 
 * @author Raffi Alan Bezirjian
 *
 */
public final class Coord {
	
	public static final char[] COL_CHARACTERS = 
		{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	public static final int ROW_MAX = 8;
	
	public static final char INVALID_COL = 'Z';
	public static final int INVALID_ROW = -1;
	
	private final int mRow;
	private final char mCol;
	
	/**
	 * Default constructor which accepts any integer as a row and any 
	 * character as column but will set the row to {@link INVALID_ROW} 
	 * if it is not within the range 1 - {@link ROW_MAX} and set the 
	 * column to {@link INVALID_COL} if the column is not within the
	 * characters array {@link COL_CHARACTERS}.
	 * <br /><br />
	 * <strong>Note: </strong> will capitalize any character given as the
	 * 			column.
	 * 
	 * @param row An integer representing row.
	 * @param col A character representing a column.
	 */
	public Coord(int row, char col){
		
		//validates and sets row
		if(row <= ROW_MAX && row >= 1){
			mRow = row;
		}else{
			mRow = INVALID_ROW;
		}
		
		//validates and sets col
		col = Character.toUpperCase(col);
		if(this.isValidCol(col)){
			mCol = col;
		}else{
			mCol = INVALID_COL;
		}
	}
	
	/**
	 * Method for retrieving the row.
	 * 
	 * @return An integer representing a row.
	 */
	public int getRow(){
		return mRow;
	}
	
	/**
	 * Method for retrieving the column.
	 * 
	 * @return A character representing a column.
	 */
	public char getCol(){
		return mCol;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Coord)){
			return false;
		}
		
		Coord c = (Coord) obj;
		if(this.getRow() == c.getRow() &&
				this.getCol() == c.getCol()){
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return String.valueOf(mRow) + String.valueOf(mCol); 
	}
	
	/**
	 * Retruns whether the given string is valid or not, 
	 * meaning whether the given character is equal to one of 
	 * characters in {@link COL_CHARACTERS}. <strong>Note: </strong>
	 * this method brute forces through the look to check the equality.
	 * @param col The column to check.
	 * @return <strong>true</strong> if the character is valid.
	 * 			<strong>false</strong> if the character is not within 
	 * 				the allowed list of characters
	 */
	private boolean isValidCol(char col){
		for(char c : COL_CHARACTERS){
			if(c == col){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Convenience method which determines if the coordinate is valid or not,
	 * meaning whether the row or the column is {@link INVALID_ROW} or {@link INVALID_COL}
	 * respectively.
	 * @param c The coordinate to test.
	 * @return <strong> true </strong> if the coordinate is valid and <srong>false</strong> 
	 * 				if it is invalide.
	 */
	public static boolean isValidCoord(Coord c){
		if(c.getRow() == INVALID_ROW || c.getCol() == INVALID_COL){
			return false;
		}
		
		return true;
	}
}
