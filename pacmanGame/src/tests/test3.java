/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import giraffeModel.Constants.difficulty;
import giraffeModel.MazeData;
import giraffeModel.PacMan;
import giraffeModel.Player;
import giraffeView.TwoDArrayPanel;
import resourcesFile.Constants;

/**
 * @author Hajar Amara
 *
 */
class test3 {

	@Test
	void testPacManPoistion() {
		PacMan pm=new PacMan(0, 0, 0, 3,null);
		int x=-1,y=-1;
		Player player=new Player("aaa@gmail.com");
		MazeData md=new MazeData(player,difficulty.Easy , new ArrayList<>(), "src/giraffeModel/2DArray.txt");
		boolean flag;
		for( Object t:md.getMazeMatrix()) {
			if(t instanceof PacMan) {
				x=((PacMan) t).getX();
				y=((PacMan) t).getY();
				break;
			}
		}
		assertEquals(false, x!=pm.getX() && y!=pm.getY());
	}

}
