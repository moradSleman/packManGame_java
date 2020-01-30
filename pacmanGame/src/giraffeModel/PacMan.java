package giraffeModel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class PacMan {
	// first location of the pacman in maze
	private int x;
	private int y;
	// total points value pacman collect
	private Integer totalPoints=0;
	// number of lives pacman had
	private Integer lives=3;
	private Image pacManImg;
	
	
	
	int imgIndex = 0;
    // direction of pacman move(L,R,U,D), x means don't move until told
    private char direction = 'x';

    // images of pacman path
	    static final String IMAGE_SOURCE = "src/giraffeView/images/pics/";
	    // pacman images when moving Left
	    static String[] pacmanSequencesL = { IMAGE_SOURCE + "pac32_left.png", IMAGE_SOURCE + "pac32_left_wide.png",
	            IMAGE_SOURCE + "pac32_left_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
	    // pacman images when moving Right
	    static String[] pacmanSequencesR = { IMAGE_SOURCE + "pac32_right.png", IMAGE_SOURCE + "pac32_right_wide.png",
	            IMAGE_SOURCE + "pac32_right_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
	    // pacman images when moving Up
	    static String[] pacmanSequencesU = { IMAGE_SOURCE + "pac32_up.png", IMAGE_SOURCE + "pac32_up_wide.png",
	            IMAGE_SOURCE + "pac32_up_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
	    // pacman images when moving Down
	    static String[] pacmanSequencesD = { IMAGE_SOURCE + "pac32_down.png", IMAGE_SOURCE + "pac32_down_wide.png",
	            IMAGE_SOURCE + "pac32_down_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
	    // image array to enable control of images viewing
	    static Image[] pictureLeft = new Image[pacmanSequencesL.length];
	    static Image[] pictureRight = new Image[pacmanSequencesR.length];
	    static Image[] pictureUp = new Image[pacmanSequencesU.length];
	    static Image[] pictureDown = new Image[pacmanSequencesD.length];
	
	// ********** Full constructor *********
	public PacMan(int x,int y,int totalPoints,int Lives,
			Constants.Directions dir) {
		setX(x);
		setY(y);
		setTotalPoints(totalPoints);
		setLives(lives);
		setImages();
		setPacManImg(dir);
	}
	

	//**************************************
	//				GETTERS
	//**************************************
	public int getX() {	
		return this.x;	
	}
	public int getY() {
		return this.y;
	}
	public Integer getTotalPoints() {
		return this.totalPoints;
	}
	public Integer getLives() {
		return this.lives;
	}
	//**************************************
	//				SETTERS
	//**************************************
	public void setX( int x ) {
		this.x = x;
	}
	public void setY( int y ) {
		this.y = y;
	}
	public void setTotalPoints( int totalPoints ) {
		this.totalPoints = totalPoints;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public Image getPacManImg() {
		return pacManImg;
	}
	
	public void setImages() {
		
		//-------------------------------------------
			Toolkit kit = Toolkit.getDefaultToolkit();
		    for (int i = 0; i < pacmanSequencesL.length; i++) {
	            pictureLeft[i] = kit.getImage(pacmanSequencesL[i]);
	        }
		    for (int i = 0; i < pacmanSequencesR.length; i++) {
		    	pictureRight[i] = kit.getImage(pacmanSequencesR[i]);
		    }
		    for (int i = 0; i < pacmanSequencesU.length; i++) {
		    	pictureUp[i] = kit.getImage(pacmanSequencesU[i]);
		    }
		    for (int i = 0; i < pacmanSequencesD.length; i++) {
		    	pictureDown[i] = kit.getImage(pacmanSequencesD[i]);
		    }
	}
	//TODO
	public void setPacManImg(Constants.Directions dir) {
		
		if(dir==Constants.Directions.left) {
			int lastImgIndx=-1;
			if(pacManImg!=null)
			for(int i=0;i<pictureLeft.length;i++)
			{
				if(pacManImg==pictureLeft[i]) {
					lastImgIndx=i;
					break;
				}
			}
			if(lastImgIndx==pictureLeft.length-1)
			pacManImg=pictureLeft[0];
		else
			pacManImg=pictureLeft[lastImgIndx+1];
		}
		else
			if(dir==Constants.Directions.right ) {
				int lastImgIndx=-1;
				if(pacManImg!=null)
				for(int i=0;i<pictureRight.length;i++)
				{
					if(pacManImg==pictureRight[i]) {
						lastImgIndx=i;
						break;
					}
				}
				if(lastImgIndx==pictureRight.length-1)
				pacManImg=pictureRight[0];
			else
				pacManImg=pictureRight[lastImgIndx+1];
			}
			else
				if(dir==Constants.Directions.up ) {
					int lastImgIndx=-1;
					if(pacManImg!=null) {
					for(int i=0;i<pictureUp.length;i++)
					{
						if(pacManImg==pictureUp[i]) {
							lastImgIndx=i;
							break;
						}
					}
					}
					if(lastImgIndx==pictureUp.length-1)
					pacManImg=pictureUp[0];
					
				else
					pacManImg=pictureUp[lastImgIndx+1];
				}
				else
					if(dir==Constants.Directions.down ) {
						int lastImgIndx=-1;
						if(pacManImg!=null)
						for(int i=0;i<pictureDown.length;i++)
						{
							if(pacManImg==pictureDown[i]) {
								lastImgIndx=i;
								break;
							}
						}
						if(lastImgIndx==pictureDown.length-1)
						pacManImg=pictureDown[0];
					else
						pacManImg=pictureDown[lastImgIndx+1];
					}
	}
					
	
	public void addPoints(int points) {
		this.totalPoints+=points;
	}
	// when pacman lose life
	public void loseLife() {
		setLives(this.lives - 1);
	}
	
	// clear pacman points
	public void clearPoints() {
		setTotalPoints(0);
	}
		  	
	// move object up step: check borders when use in maze
	public void moveRight() {
		this.setY( this.getY() + 1 );
	}

	// move object down step: check borders when use in maze
	public void moveLeft() {
		this.setY( this.getY() - 1 );		
	}

	// move object right step: check borders when use in maze
	public void moveDown() {
		this.setX( this.getX() + 1 );	
	}

	// move object left step: check borders when use in maze
	public void moveUp() {
		this.setX( this.getX() - 1 );	
	}
	
	public void takeLife() {
		this.lives-=1;
	}
}
