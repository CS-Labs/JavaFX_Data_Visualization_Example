package FXDataVis;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Christian Seely
 * 
 * Class to control the flow of the program and the creation of
 * stages. 
 *
 */
public class MapBase extends Application
{
  StackPane stackPane = new StackPane();
  ScrollPane root;
  SVGPaths SVG = new SVGPaths();
  // Get the map image.
  BuildInteractiveRegions regionBuilder = new BuildInteractiveRegions(stackPane,
      this);
  Image mapImage = (new Image(
      getClass().getResourceAsStream("/FXDataVis/Resources/map.png")));
  ImageView map = new ImageView(mapImage);

  /**
   * Method to add the map and then build the maps interactive regions. 
   * For each specific region build call the meaning of the arguments
   * are as follows:
   * argument 1: Color of Regions boarder
   * argument 2: Color of Regions boarder glow
   * argument 3: Fill color of Region. 
   */
  public void buildMap()
  {
    stackPane.getChildren().add(map);
    map.toBack(); //Regions must be displayed in front of map. 
    regionBuilder.buildAfricaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildSouthAmericaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildMiddleAmericaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildCaliforniaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildHeartLandsPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildMiddleAmericaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildNorthernCrescentPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildNorthernPlanesPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildPNWAndMNTPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildSoutheastPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildSouthernPlanesDeltaStatesPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildMiddleEastPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildCentralAsiaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildSouthAsiaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildArcticAmericaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildRussiaCaucausPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildEuropePath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildEastAsiaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    regionBuilder.buildOceaniaPath(Color.CYAN, Color.CYAN,
        Color.rgb(0, 255, 255, 0.5));
    root.setContent(stackPane);
  }

  /**
   * Method to invoke a semi-transparent stage to appear over the map
   * which to display the regional statistics of the region clicked.
   * The stage is terminated once the user clicks the exit button.
   * Note this technically acts as a separate java application, and 
   * it is possible (and maybe better) to instead of creating a stage
   * overlay creating a pane overlay on the original stage. 
   */
  public void invokeOtherStage()
  {
    try
    {
      Stage newStage = new Stage();
      // Make the stage transparent.
      newStage.initStyle(StageStyle.TRANSPARENT);

      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource("/FXDataVis/DataVis.fxml"));
      Parent root = fxmlLoader.load();
      FXStatisticalDisplaysController statController = (FXStatisticalDisplaysController) fxmlLoader
          .getController();
      statController.setRegionBuilder(regionBuilder);
      Scene scene = new Scene(root);
      // Again needed for making the window
      // transparent.
      scene.setFill(Color.TRANSPARENT);
      newStage.setScene(scene);
      newStage.show();
    } catch (Exception e)
    {
      e.printStackTrace();
    }

  }
  /**
   * Create the initial Stage. 
   */
  @Override
  public void start(Stage primaryStage) throws Exception
  {
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
  
  /**
   * 
   * Fall through to invoke program if start is not called upon run. 
   */
  public static void main(String[] args)
  {
    launch(args);
  }

}
