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
import giraffeModel.RegularGhost;
import giraffeModel.Constants.difficulty;
import giraffeView.TwoDArrayPanel;

/**
 * @author Hajar Amara
 *
 */
class test4 {

	@Test
	void test() {		
		
		RegularGhost rg=new RegularGhost(3, 5);
		int x=-1,y=-1;		
		Player player=new Player("aaa@gmail.com");
		MazeData md=new MazeData(player,difficulty.Easy , new ArrayList<>(), "src/giraffeModel/2DArray.txt");
		for( Object t:md.getMazeMatrix()) {
			if(t instanceof RegularGhost) {
				x=((RegularGhost) t).getX();
				y=((RegularGhost) t).getY();
				break;
			}
		}
		assertEquals(true, x==rg.getX() && y==rg.getY());

	}

}
