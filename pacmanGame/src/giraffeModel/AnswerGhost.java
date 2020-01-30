package giraffeModel;

import java.awt.Image;
import java.awt.Toolkit;

public class AnswerGhost extends RegularGhost {

	private Constants.AnswerStatus AnswerStatus;
	private static final String[] ansGhosts = {
			"src/giraffeView/images/pics/ansGhostBlue.png", "src/giraffeView/images/pics/ansGhostOrange.png",
			"src/giraffeView/images/pics/ansGhostPink.png","src/giraffeView/images/pics/ansGhostRed.png"
		};

	private static Image[] g_images;
	public AnswerGhost(int x,int y,Constants.AnswerStatus AnswerStatus) {
		super(x,y);
		setAnswerStatus(AnswerStatus);
		setImages();
	}
	
	public Constants.AnswerStatus getAnswerStatus(){
		return this.AnswerStatus;
	}
	
	
	public void setAnswerStatus(Constants.AnswerStatus AnswerStatus) {
		this.AnswerStatus=AnswerStatus;
	}
	public void setImages() {
    	Toolkit kit = Toolkit.getDefaultToolkit();
    	g_images=new Image[ansGhosts.length];
   
    	for (int i = 0; i < g_images.length; i++) {
    		g_images[i] = kit.getImage(ansGhosts[i]);
    	}
    }
	  public void setAnswerGhostImg(int ghostNum) {
		  setGhostImg(g_images[ghostNum]);
	    }
	
}
