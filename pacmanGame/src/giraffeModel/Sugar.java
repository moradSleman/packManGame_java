package giraffeModel;

import java.awt.Image;
import java.awt.Toolkit;

public class Sugar {
	    //**************************************
		//				Variables
		//**************************************
		// location of the sugar in maze
	  	private int x;
	  	private int y;
	    private Constants.SugarType sugarType;
	    private Image sugarImg;
		/* IMAGES */
		private static final String[] sugPathImg = {
			"src/giraffeView/images/pics/sugarMoney.jpg", "src/giraffeView/images/pics/sugarPoison.png",
			"src/giraffeView/images/pics/sugarQuestion.png","src/giraffeView/images/pics/RegularSugar.png"
		};
		// ********** Full constructor *********
	  	public Sugar(int x, int y,Constants.SugarType sugarType) {
	    	setSugarType(sugarType);
	    	setX(x);
	    	setY(y);
	    	setImage(sugarType);
	    	
	  	}
	  	public Sugar(Constants.SugarType sugarType) {
	  		setSugarType(sugarType);
	  		setImage(sugarType);
	    	
	  	}

		//**************************************
		//				GETTERS
		//**************************************
	  	public Image getSugImg() {
	  		return sugarImg;
	  	}
	  	public Constants.SugarType getSugType() {
			return this.sugarType;
		}
	  	public int getX() {
	  		return this.x;
	  	}
	  	public int getY() {
	  		return this.y;
	  	}
		//**************************************
		//				SETTERS
		//**************************************
	  	public void setSugarType(Constants.SugarType sugarType) {
			this.sugarType = sugarType;
		}
	  	public void setX( int x ) {
	  		this.x = x;
	  	}
	  	public void setY( int y ) {
	  		this.y = y;
	  	}
	  	
	  	 public void setImage(Constants.SugarType sugarType) {
	  		Toolkit kit = Toolkit.getDefaultToolkit();
		    if(sugarType.equals(Constants.SugarType.BadSugar)) {
		    	sugarImg= kit.getImage(sugPathImg[1]);
		    	}
		    else
		    	if(sugarType.equals(Constants.SugarType.QuestionSugar)) {
			    	sugarImg= kit.getImage(sugPathImg[2]);
			    	}
		    	else
		    		if(sugarType.equals(Constants.SugarType.MoneySugar)) {
				    	sugarImg= kit.getImage(sugPathImg[0]);
				    	}
		    		else
		    			sugarImg= kit.getImage(sugPathImg[3]);
		    }
			
	  	
	  	
}
