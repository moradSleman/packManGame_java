/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import giraffeModel.Constants.difficulty;
import giraffeModel.MazeData;
import giraffeModel.Player;
import giraffeModel.Question;
import giraffeView.TwoDArrayPanel;
import resourcesFile.Constants;

/**
 * @author Hajar Amara
 *
 */
class test2 {
	
	int row=-1;
	Player player=new Player("aaa@gmail.com");
	MazeData md=new MazeData(player,difficulty.Easy , new ArrayList<>(), "src/giraffeModel/2DArray.txt" );
	@Test
	public void testIsRow()
	{
	    boolean flag= md.getMazeMatrix()!= null && row >= 0 && md.getMazeMatrix()[row] != null;
		assertEquals(false,flag);

	}

}
