/**
 * Name:			Raffi Alan Bezirjian (29538690)
 * COMP249
 * Assignment #:	1
 * Due Date:		September 21, 2018
 */
package data;

/**
 * Class representing a cell in the {@link BattleShipBoard}. <br />
 * A Cell can contain a one single object at a time, and such objects can 
 * only be described {@link Content}. <br />
 * Once a cell is set to a coordinate of the battlechip board, through its constructor, 
 * it cannot be changed.<br /><br />
 * <strong>Note:</strong> That the cell does not care what coords it contains,
 * 		it is up to the caller to make sure it is valid {@link Coord}.
 * 
 * @author Raffi Alan Bezirjian
 *
 */
class Cell {
	
	public static final String HIDE_CHARACTER = "_";
	public static final String GRENADE_CHARACTER = "g";
	public static final String SHIP_CHARACTER = "s";
	public static final String HIT_CHARACTER = "*";
	
	/**
	 * Content which a cell can hold. There are 3 possible states,
	 *  <ul>
	 *  	<li>NOTHING</li>
	 *  	<li>GRENADE</li>
	 *  	<li>SHIP</li>
	 *  </ul>
	 */
	public static enum Content {NOTHING, GRENADE, SHIP}
	
	private final Coord mCoords;
	
	private Content mContent;
	private String mOwner;
	private boolean mHide;		//used when displaying
	
	/**
	 * Default constructor, which takes only the absolute necessary
	 * information, the coordinates of the cell. The other fields are
	 * set to their defaults, content to {@link Content.NOTHING} and owner to null.
	 * 
	 * @param coords The coordinates of the cell.
	 */
	public Cell(Coord coords){
		mCoords = coords;
		mOwner = null;
		mContent = Content.NOTHING;
		mHide = true;
	}
	
	/**
	 * Constructor which initializes all the fields by calling the default constructor
	 * with the given coordinates, but also modifies the other fields based on what the
	 * user has entered in the parameters. Useful when the owner and content are already
	 * known.
	 * 
	 * @param coords The coordinates of the cell.
	 * @param content The content of the cell.
	 * @param owner The owner of the cell.
	 */
	public Cell(Coord coords, Content content, String owner) {
		this(coords);
		mContent = content;
		mOwner = owner;
	}
	
	/**
	 * Gets the coordinates of the cell.
	 */
	public Coord getCoords(){
		return mCoords;
	}
	
	/**
	 * Gets the content of the cell.
	 */
	public Content getContent(){
		return mContent;
	}
	
	/**
	 * Gets the Owner of the cell.
	 */
	public String getOwner(){
		return mOwner;
	}
	
	/**
	 * Sets whether the next call to {@link #toString()}
	 * will display this cell or "hide" it's content.
	 * @param b <strong>true</strong> if the content should be hidden and
	 * 				<strong>false</strong> if it is ton be displayed.
	 */
	public void setHide(boolean b){
		mHide = b;
	}
	
	/**
	 * Method used to set the content. The content must have an associated owner.
	 * If the owner of is <code>null</code> then the cell belongs to the board.
	 * 
	 * @param o The owner of this cell and it's content.
	 * @param c The content of this cell.
	 */
	public void setContent(String o, Content c){
		mOwner = o;
		mContent= c;
	}
	
	/**
	 * Returns whether on next call, the {@link #toString()} method will
	 * hide the content of this cell.
	 * @return <strong>true</strong> if this cell will be hidden and <strong>false</strong>
	 * 			if it is to b displayed.
	 */
	public boolean isHidden(){
		return mHide;
	}
	
	/**
	 * Returns whether there is content in this cell or not.
	 * @return <strong>true</strong> if there the content is not {@link Content.NOTHING}
	 * 				and <strong>false</strong> if there is anything inside the cell.
	 */
	public boolean isOccupied(){
		if(mContent.equals(Content.NOTHING)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returns the display of this cell. This method checks if the hide flag is on
	 * and if it is, returns the {@link HIDE_CHARACTER}, other wise it returns the content
	 * of the cell, represented by {@link SHIP_CHARACTER} and {@link GRENADE_CHARACTER} or the 
	 * {@link HIT_CHARACTER} if the cell is empty.
	 * <br /><br /><strong>Note:</strong> The output is not formatted based on owner, that is up
	 * to the called to implement if they wish.
	 */
	@Override
	public String toString(){
		if(mHide){
			return HIDE_CHARACTER;
		}else if(mContent.equals(Content.GRENADE)){
			return GRENADE_CHARACTER;
		}else if(mContent.equals(Content.SHIP)){
			return SHIP_CHARACTER;
		}else{							//Content.NOTHING or any other unforeseen possibility
			return HIT_CHARACTER;
		}
	}

}
