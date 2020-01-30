/**
 * 
 */
package interfaces;

/**
 * @author Hajar Amara
 * IMoveObject interface to decide the moving function that the packman and the ghost will 
 * implement it 
 *
 */
public interface IMoveObject {
	
	
	


	
	/**
	 * to make the object to move above the location that it in.
	 */
	public void moveUp();
	
	/**
	 * to make the object to move bottom the location that it in.
	 */
	public void moveDown();
	
	/**
	 * to make the object to move right the location that it in.
	 */
	public void moveRight();
	
	/**
	 * to make the object to move left the location that it in.
	 */
	public void moveLeft();

}
