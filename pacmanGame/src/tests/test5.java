/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import giraffeController.SysData;
import giraffeModel.MazeData;
import giraffeModel.PacMan;
import giraffeModel.Player;
import giraffeModel.Question;
import giraffeModel.Constants.difficulty;

/**
 * @author Hajar Amara
 *
 */
class test5 {

	@Test
	void test() {
		PacMan pm=new PacMan(20,8, 0, 3,null);
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
		assertEquals(true, x==pm.getX() && y==pm.getY());
	}

}
