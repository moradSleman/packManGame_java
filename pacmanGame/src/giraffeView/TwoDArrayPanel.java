package giraffeView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import giraffeModel.AnswerGhost;
import giraffeModel.Constants;
import giraffeModel.MazeData;
import giraffeModel.PacMan;
import giraffeModel.Player;
import giraffeModel.Question;
import giraffeModel.RegularGhost;
import giraffeModel.Sugar;

public class TwoDArrayPanel extends JPanel{
private MazeData mazeData;
final static int CELL = 29;
final static int CELLY= 39;
public TwoDArrayPanel(Player player,Constants.difficulty difficulty,ArrayList<Question> quesToChooseFrom,String mapFile) {
	super();
	this.setBackground(Color.BLACK);
	this.mazeData =new MazeData(player,difficulty,quesToChooseFrom,mapFile);}




public MazeData getMazeData() {
	return mazeData;
}




public void setMazeData(MazeData mazeData) {
	this.mazeData = mazeData;
}




/**
 * Generic paint method Iterates through each cell/tile in the 2D array,
 * drawing each in the appropriate location on screen
 *
 * @param g Graphics object
 */
@Override
public void paintComponent(Graphics g) {
	
    super.paintComponent(g);
    g.setColor(Color.BLACK);
   
    g.fillRect(10, 0,Constants.mazewidth,Constants.mazeheight);
    // Outer loop loops through each row in the array
    for (int row = 0; row <Constants.mazeheight; row++) {

        // Inner loop loops through each column in the array
        for (int column = 0; column < Constants.mazewidth; column++) {
        	 if(mazeData.getMazeMatrix()[row][column] instanceof Sugar) {
            	if((((Sugar)mazeData.getMazeMatrix()[row][column])).getSugType().equals(Constants.SugarType.YellowSugar))
            		{
            		g.drawImage(((Sugar)mazeData.getMazeMatrix()[row][column]).getSugImg(), column* CELL,row * CELLY
            				,20,20,(ImageObserver)this);
            		}
            	else
            		g.drawImage(((Sugar)mazeData.getMazeMatrix()[row][column]).getSugImg(), column* CELL,row * CELLY
            				,30,30,(ImageObserver)this); 
               	 
        	 }
            else
            	 if(mazeData.getMazeMatrix()[row][column] instanceof String )
            	 {
            		 Toolkit kit = Toolkit.getDefaultToolkit();
            		 g.drawImage(kit.getImage("src/giraffeView/images/pics/wall.png"), column* CELL,row * CELLY
             				,25,30,(ImageObserver)this);
            	
            	 }
            else
            	if(mazeData.getMazeMatrix()[row][column] instanceof RegularGhost) {
            		g.drawImage(((RegularGhost)mazeData.getMazeMatrix()[row][column]).getGhostImg(), column* CELL,row * CELLY
            				,30,30,(ImageObserver)this);
            	}
            	else
            		if(mazeData.getMazeMatrix()[row][column] instanceof AnswerGhost) {
                		g.drawImage(((AnswerGhost)mazeData.getMazeMatrix()[row][column]).getGhostImg(), column* CELL,row * CELLY
                				,30,30,(ImageObserver)this);
                		System.out.println("ll");
                	}
            		else
            		if(mazeData.getMazeMatrix()[row][column] instanceof PacMan) {
                		g.drawImage(((PacMan)mazeData.getMazeMatrix()[row][column]).getPacManImg(),column * CELL,row * CELLY
                				,34,30,(ImageObserver)this);
                		
                	}
            		
        }
    }

  }


}
