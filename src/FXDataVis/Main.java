//package FXDataVis;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//
//
///**
// * 
// * @author Christian Seely
//*/
//	public class Main extends Application {
//		@Override
//		public void start(Stage primaryStage) {		
//			try {
//		    //The first screen will display the map. 
//				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXDataVis/Map.fxml"));
//
//			Parent root = fxmlLoader.load();
//			MapController mapController = (MapController) fxmlLoader.getController();
//
//			//root.getcon
////			String image = Main.class.getResource("/FXDataVis/map.png").toExternalForm();
////			root.setStyle("-fx-background-image: url('" + image + "'); " +
////			           "-fx-background-position: center center; " +
////			           "-fx-background-repeat: stretch;");
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.show();
//			mapController.setBinds();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		}
//		public static void main(String[] args) {
//			launch(args);
//		}
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
