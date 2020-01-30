/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import giraffeController.ControllerLogic;
import giraffeController.SysData;
import giraffeModel.MazeData;
import giraffeModel.PacMan;
import giraffeModel.Player;
import giraffeModel.Question;
import giraffeModel.Sugar;
import giraffeModel.Constants.SugarType;
import giraffeModel.Constants.difficulty;
import giraffeView.TwoDArrayPanel;
import resourcesFile.Constants;

/**
 * @author Hajar Amara
 *
 */
class test1 {

	@SuppressWarnings("static-access")
	@Test
	void testTwoLists() {
		Sugar sg=new Sugar(SugarType.Flashing);
		int x=-1,y=-1;
		Player player=new Player("aaa@gmail.com");
		MazeData md=new MazeData(player,difficulty.Easy , null, "src/giraffeModel/2DArray.txt");
		boolean flag;
		for( Object t:md.getMazeMatrix()) {
			if(t instanceof Sugar) {
				x=((Sugar) t).getX();
				y=((Sugar) t).getY();
				break;
			}
		}
		if(x!=-1 && y!=-1)
		assertEquals(true, x!=sg.getX() && y!=sg.getY());
	}

}
