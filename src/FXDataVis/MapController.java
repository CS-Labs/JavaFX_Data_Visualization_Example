package FXDataVis;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Christian Seely
 * 
 * Controller class associated with the Map.fxml 
 * Initializes and displays the map. 
 *
 */
public class MapController{
	@FXML AnchorPane pane;
	@FXML Button iconButton;
	//Get the map image. 
	ImageView map = new ImageView(new Image(getClass().getResourceAsStream("/FXDataVis/map.png")));	
		
	/**
	 * You cannot have constructors inside of controller classes as
	 * the constructor is called prior to the FXML objects being 
	 * initialized. To fix this there is a method called initialize this
	 * gets called automatically if created and acts like a constructor
	 * but is called after the FXML objects are instantiated. This method
	 * initializes fields required for the map. 
	 */
	public void initialize()
	{

 	
	}
	

	public void invokeOtherStage()
	{

		
	}
	
	


}
