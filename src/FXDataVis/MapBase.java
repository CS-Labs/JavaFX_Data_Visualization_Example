package FXDataVis;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
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
public class MapBase extends Application{
	StackPane stackPane = new StackPane();
    ScrollPane root;
	//@FXML Canvas canvas;
	SVGPaths SVG = new SVGPaths();
	//Get the map image. 
	BuildInteractiveRegions regionBuilder = new BuildInteractiveRegions(stackPane);
	Image mapImage = (new Image(getClass().getResourceAsStream("/FXDataVis/map.png")));
	ImageView map = new ImageView(mapImage);	

	/**
	 * You cannot have constructors inside of controller classes as
	 * the constructor is called prior to the FXML objects being 
	 * initialized. To fix this there is a method called initialize this
	 * gets called automatically if created and acts like a constructor
	 * but is called after the FXML objects are instantiated. This method
	 * initializes fields required for the map. 
	 */
	public void buildMap()
	{
		stackPane.getChildren().add(map);
		map.toBack(); 		
		regionBuilder.buildAfricaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildSouthAmericaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildMiddleAmericaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildCaliforniaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildHeartLandsPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildMiddleAmericaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildNorthernCrescentPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
		regionBuilder.buildNorthernPlanesPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildPNWAndMNTPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildSoutheastPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildSouthernPlanesDeltaStatesPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildMiddleEastPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildCentralAsiaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildSouthAsiaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildArcticAmericaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildRussiaCaucausPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildEuropePath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildEastAsiaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    regionBuilder.buildOceaniaPath(Color.CYAN, Color.CYAN, Color.rgb(0, 255, 255,0.5));
	    root.setContent(stackPane);    
	}
	
	
	public void setBinds()
	{

//		System.out.println(canvas);
//		canvas.widthProperty().bind(pane.widthProperty());
//		canvas.heightProperty().bind(pane.heightProperty());
	}
	
	
	
	/**
	 * If the icon button is clicked then invoke the other stage
	 * that displays the data visualization. This method is called via
	 * the FXML onAction command for the icon button.
	 * 
	 *  So a problem with making a transparent scene is it takes
	 *  away the ability to exit (fixed) and move the screen (TODO)
	 */
	public void invokeOtherStage()
	{
		try {
			Stage newStage = new Stage();
			//Make the stage transparent. 
			newStage.initStyle(StageStyle.TRANSPARENT);			
			Parent root = FXMLLoader.load(getClass().getResource("/GUIandDataVisTeamTestPackage/DataVis.fxml"));
			Scene scene = new Scene(root);
			//Again needed for making the window
			//transparent. 
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			newStage.setScene(scene);
			newStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		root = new ScrollPane();
		root.setPannable(true);
		root.setPrefHeight(902);
		root.setPrefWidth(1800);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		buildMap();
	}
	
	
	public static void main(String[] args) {
	launch(args);
}


}
