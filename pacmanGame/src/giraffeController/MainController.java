package giraffeController;

import java.applet.Applet;
import java.applet.AudioClip;

public class MainController {

	public static void main(String[] args) {		
		
		SysData sysDataInstance=SysData.getInstance();
		ControllerLogic controler=new ControllerLogic(sysDataInstance);
		// start with contoller login page then after controller finish or after clicking (X)
		//on all windows write the data to the json file and exit program.	

	}
	


}
