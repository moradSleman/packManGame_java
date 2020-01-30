package giraffeModel;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import giraffeView.MazeFrm;
import giraffeView.MazeSecondPlayerFrm;
public class RegularGhost extends Thread {
	//**************************************
		//				Variables
		//**************************************
		// location of the Ghost in maze
		private int x;
		private int y;
		private Image ghostImg;
		private Object[][] mazeMatrix;
		private MazeFrm onMazeFrm;
		private MazeSecondPlayerFrm secondMaze;
		private boolean stopFlag=false;
		/* IMAGES */
		
		// ********** Full constructor *********
		public RegularGhost( int x, int y ) {
			setX(x);
			setY(y);
			setImage();
		}
		Object objMoveOnGhost=new Sugar(Constants.SugarType.YellowSugar);
		public void run() {
			ArrayList<Constants.Directions> dir=new ArrayList<Constants.Directions>(4);
			dir.add(Constants.Directions.right);
			dir.add(Constants.Directions.left);
			dir.add(Constants.Directions.up);
			dir.add(Constants.Directions.down);
			Random random=new Random();
			int randomMoveGH=random.nextInt(4);
			
			while(!stopFlag) {
				objMoveOnGhost=new Sugar(Constants.SugarType.YellowSugar);
				while(!(objMoveOnGhost instanceof String) && !stopFlag) {
				objMoveOnGhost=moveTheInputDir(objMoveOnGhost,dir.get(randomMoveGH));
				onMazeFrm.getTwoDArrayPanel().repaint();
				try {
					sleep(750);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(randomMoveGH<3) {
					randomMoveGH++;
				}
				else
					{
					randomMoveGH=0;
					}
			}
			onMazeFrm.getTwoDArrayPanel().getMazeData().getMazeMatrix()[getX()][getY()]=null;
			onMazeFrm.getTwoDArrayPanel().repaint();
		}
		
		//**************************************
		//				GETTERS
		//**************************************
		
		public int getX() {
			return x;
		}

		
		public void setGhostImg(Image ghostImg) {
			this.ghostImg = ghostImg;
		}

		public int getY() {
			return this.y;
		}
		public Image getGhostImg() {
			return this.ghostImg;
		}
		//**************************************
		//				SETTERS
		//**************************************
		public void setMazeFrm(MazeFrm mazeFrm) {
			this.onMazeFrm=mazeFrm;
		}
		public void setMazeSecondPlayerFrm(MazeSecondPlayerFrm mazeFrm) {
			this.secondMaze=mazeFrm;
		}
		public void setMazeMatrix(Object[][] mazeMatrix) {
			this.mazeMatrix=mazeMatrix;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		// set image to permanent ghosts
	    public void setImage() {
	    	Toolkit kit = Toolkit.getDefaultToolkit();

	    	ghostImg= kit.getImage("src/giraffeView/images/pics/ghost3.png");
	    	
	    }
		
	  
		
		// move object up step: check borders when use in maze
		public void moveUp() {
			this.setX( this.getX() - 1 );
		}

		// move object down step: check borders when use in maze
		public void moveDown() {
			this.setX( this.getX() + 1 );		
		}
		
		// move object right step: check borders when use in maze
		public void moveRight() {
			this.setY( this.getY() + 1 );	
		}

		// move object left step: check borders when use in maze
		public void moveLeft() {
			this.setY( this.getY() - 1 );	
		}
		
		public Object moveTheInputDir(Object objOnMaze,Constants.Directions dir) {
			if(dir.equals(Constants.Directions.up))
				return moveGhostUp(objOnMaze);
			else
				if(dir.equals(Constants.Directions.down))
					return moveGhostDown(objOnMaze);
				else
			if(dir.equals(Constants.Directions.left))
				return moveGhostLeft(objOnMaze);
			else
				return moveGhostRight(objOnMaze);
		}
		public Object moveGhostRight(Object objOnMaze) {
			Object objToReturn;
			if((this.getX()>0 && this.getX()<Constants.mazeheight) && (this.getY()>0 && this.getY()<Constants.mazewidth)) {
			if(mazeMatrix[this.getX()][this.getY()+1] instanceof Sugar || mazeMatrix[this.getX()][this.getY()+1]==null) {
					mazeMatrix[this.getX()][this.getY()]=objOnMaze;
					objToReturn=mazeMatrix[this.getX()][this.getY()+1];
					this.moveRight();
					mazeMatrix[this.getX()][this.getY()]=this;
					return objToReturn;
			   }
			}		return  new String("wall");
		}
		public Object moveGhostLeft(Object objOnMaze) {
			Object objToReturn;
			if((this.getX()>0 && this.getX()<Constants.mazeheight) && (this.getY()>0 && this.getY()<Constants.mazewidth)) {
			if(mazeMatrix[this.getX()][this.getY()-1] instanceof Sugar || mazeMatrix[this.getX()][this.getY()-1]==null) {
					mazeMatrix[this.getX()][this.getY()]=objOnMaze;
					objToReturn=mazeMatrix[this.getX()][this.getY()-1];
					this.moveLeft();
					mazeMatrix[this.getX()][this.getY()]=this;
					return objToReturn;
			 }
			}
					return  new String("wall");
			
		}
		
		public Object moveGhostUp(Object objOnMaze) {
			Object objToReturn;
			if((this.getX()>0 && this.getX()<Constants.mazeheight) && (this.getY()>0 && this.getY()<Constants.mazewidth)) {
				if(mazeMatrix[this.getX()-1][this.getY()] instanceof Sugar || mazeMatrix[this.getX()-1][this.getY()]==null) {
					mazeMatrix[this.getX()][this.getY()]=objOnMaze;
					objToReturn=mazeMatrix[this.getX()-1][this.getY()];
					this.moveUp();
					mazeMatrix[this.getX()][this.getY()]=this;
					return objToReturn;
			}
			}
				return  new String("wall");
			
		
		}
		
		public Object moveGhostDown(Object objOnMaze) {
			Object objToReturn;
			if((this.getX()>0 && this.getX()<Constants.mazeheight) && (this.getY()>0 && this.getY()<Constants.mazewidth)) {
			if(mazeMatrix[this.getX()+1][this.getY()] instanceof Sugar || mazeMatrix[this.getX()+1][this.getY()]==null) {
					mazeMatrix[this.getX()][this.getY()]=objOnMaze;
					objToReturn=mazeMatrix[this.getX()+1][this.getY()];
					this.moveDown();
					mazeMatrix[this.getX()][this.getY()]=this;
					return objToReturn;
			}
			}return  new String("wall");
			
		}

		public boolean isStopFlag() {
			return stopFlag;
		}

		public void setStopFlag(boolean stopFlag) {
			this.stopFlag = stopFlag;
		}
		
		
}
