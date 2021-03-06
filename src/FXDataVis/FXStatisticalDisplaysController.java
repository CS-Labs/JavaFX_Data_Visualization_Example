package FXDataVis;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Christian Seely
 * 
 * Class to create, display and control the flow of statistical displays
 * for a selected region. Please note that all the statistics in this
 * program are made up as this is a demo. 
 *
 */
public class FXStatisticalDisplaysController
{

  private int chartNum = 1; // associated with which chart is being displayed
  // there are currently seven different charts.
  BuildInteractiveRegions regionBuilder;

  private ArrayList<Integer> past10YearsNetExports = new ArrayList<>();
  private ArrayList<Integer> past10YearsNetImports = new ArrayList<>();
  private ArrayList<Integer> past10YearsNetProduction = new ArrayList<>();
  private ArrayList<Integer> past10YearsNetDomesticConsumption = new ArrayList<>();
  private ArrayList<Integer> past10YearsBestCropProduction = new ArrayList<>();

  // References to FXML items.
  @FXML
  private Button exitButton;
  @FXML
  private PieChart pieChart;
  @FXML
  private Button button;
  @FXML
  private Label regionNameLabel;
  @FXML
  private Button leftButton;
  @FXML
  private Button rightButton;
  @FXML
  private Label currentYear;
  @FXML
  private AnchorPane anchorPane;
  @FXML
  CategoryAxis xAxis = new CategoryAxis();
  @FXML
  NumberAxis yAxis = new NumberAxis();
  // Stacked Bar Chart looks better visually than a
  // regular bar chart it has wider bars.
  @FXML
  StackedBarChart<String, Number> barChart = new StackedBarChart<String, Number>(
      xAxis, yAxis);

  //Hard coded values used for demo. 
  String bestCropName = "Citrus";
  private int presentYear = 2010;
  private int currentYearlyBestCropProduction = 7_035_514;
  private int currentYearlyNetExports = 15_545_825;
  private int currentYearlyNetImports = 10_945_483;
  private int currentYearlyNetProduction = 8_517_987;
  private int currentYearlyNetDomesticConsumption = 3_917_645;

  /**
   * "Constructor" for the class initialize components and first chart to be
   * displayed.
   * (The initialize method acts like a constructor for controller classes)
   */
  public void initialize()
  {
    initializeButtons();
    displayRegionalCropDistribution();
  }

  // Get resources.
  ImageView left = new ImageView(
      new Image(getClass().getResourceAsStream("/FXDataVis/Resources/left.png")));
  ImageView right = new ImageView(
      new Image(getClass().getResourceAsStream("/FXDataVis/Resources/right.png")));

  /**
   * Initialize the buttons.
   */
  private void initializeButtons()
  {
    // Makes it round.
    leftButton.setStyle("-fx-background-radius: 5em; " + "-fx-min-width: 3px; "
        + "-fx-min-height: 3px; " + "-fx-max-width: 3px; "
        + "-fx-max-height: 3px;");

    leftButton.setGraphic(left);
    // Makes it round.
    rightButton.setStyle("-fx-background-radius: 5em; " + "-fx-min-width: 3px; "
        + "-fx-min-height: 3px; " + "-fx-max-width: 3px; "
        + "-fx-max-height: 3px;");

    rightButton.setGraphic(right);
    
    //Set CSS style sheets. 
    barChart.getStylesheets().add(
        getClass().getResource("/FXDataVis/Resources/barChartCSS.css").toExternalForm());
    barChart.applyCss();

    pieChart.getStylesheets().add(
        getClass().getResource("/FXDataVis/Resources/pieChartCSS.css").toExternalForm());

    regionNameLabel.setTextFill(Color.web("#FFFFFF")); // White
    leftButton.setVisible(false); // Can't go left to start. 
  }

  /**
   * Change the viability of the buttons depending on which chart the user is
   * viewing.
   */
  public void updateButtonVisibility()
  {
    if (pieChart.isVisible()
        && pieChart.getTitle().equals("Regional Crop Distribution"))
    {
      leftButton.setVisible(false);
    } else
    {
      leftButton.setVisible(true);
    }
    if (barChart.isVisible() && barChart.getTitle()
        .equals("Net Regional Domestic Consumption from the Past 10 Years"))
    {
      rightButton.setVisible(false);
    } else
    {
      rightButton.setVisible(true);
    }
  }

  /**
   * 
   * There are two "Master events" that can occur a left or right arrow click.
   * The action of that arrow click depends on which chart the user is currently
   * viewing. Thus depending on the chart the user is viewing the appropriate
   * actions are taken to move to the next statistical display.
   */
  public void masterEventLeft(ActionEvent event)
  {
    // Decrement as user toggles left.
    if (chartNum > 1)
    {
      chartNum--;
      switch (chartNum)
      {
      case 1:
        displayRegionalCropDistribution();
        break;
      case 2:
        displayRegionalHDIComparison();
        break;
      case 3:
        displayBestCropChart();
        break;
      case 4:
        displayExportsChart();
        break;
      case 5:
        displayImportsChart();
        break;
      case 6:
        displayProductionChart();
        break;
      case 7:
        displayDomesticConsumptionChart();
        break;
      default:
        break;
      }
    }
    // Check if any of the buttons visibility should change.
    updateButtonVisibility();
  }

  /**
   * 
   * There are two "Master events" that can occur a left or right arrow click.
   * The action of that arrow click depends on which chart the user is currently
   * viewing. Thus depending on the chart the user is viewing the appropriate
   * actions are taken to move to the next statistical display.
   */
  public void masterEventRight(ActionEvent event)
  {

    if (chartNum < 7)
    {
      chartNum++;
      switch (chartNum)
      {
      case 1:
        displayRegionalCropDistribution();
        break;
      case 2:
        displayRegionalHDIComparison();
        break;
      case 3:
        displayBestCropChart();
        break;
      case 4:
        displayExportsChart();
        break;
      case 5:
        displayImportsChart();
        break;
      case 6:
        displayProductionChart();
        break;
      case 7:
        displayDomesticConsumptionChart();
        break;
      default:
        break;
      }
    }
    // Check if any of the buttons visibility should change.
    updateButtonVisibility();
  }

  /**
   * Set up the pie chart to display crop distribution for a region.
   */
  public void displayRegionalCropDistribution()
  {
    pieChart.setVisible(true);
    barChart.setVisible(false);
    currentYear.setVisible(false);
    pieChart.getData().clear();
    pieChart.setTitle("Regional Crop Distribution");
    ObservableList<Data> list = FXCollections.observableArrayList(
        new PieChart.Data("Citrus Fruits", 3),
        new PieChart.Data("Non-Citrus Fruits", 4), new PieChart.Data("Nuts", 3),
        new PieChart.Data("Grains", 13), new PieChart.Data("Oil Crops", 6),
        new PieChart.Data("Vegetables", 8),
        new PieChart.Data("Specialty Crops", 1),
        new PieChart.Data("Feed Crops", 20), new PieChart.Data("Fish", 7),
        new PieChart.Data("Meat Animals", 15),
        new PieChart.Data("Poultry and Eggs", 11),
        new PieChart.Data("Dairy Products", 9));

    pieChart.setData(list);
  }

  /**
   * Set up pie chart to display a regional comparison of HDI of each reigon.
   */
  public void displayRegionalHDIComparison()
  {
    pieChart.setVisible(true);
    barChart.setVisible(false);
    currentYear.setVisible(false);
    pieChart.getData().clear();
    pieChart.setTitle("Regional Human Development Index Comparison");
    ObservableList<Data> list = FXCollections.observableArrayList(
        new PieChart.Data("California", 7), new PieChart.Data("Heartland", 9),
        new PieChart.Data("Northern Plains", 15),
        new PieChart.Data("Southeast", 10),
        new PieChart.Data("Northern Crescent", 11),
        new PieChart.Data("SP & Delta States", 13),
        new PieChart.Data("PNW & MNT States", 35));
    pieChart.setData(list);

  }

  /**
   * Set up a stacked bar chart to display the production of the 'best' crop
   * from the past 10 years (not in including current one) the current ones
   * yearly to date information is displayed below the chart
   */
  public void displayBestCropChart()
  {
    // Toggle what's visible (they are overlaid)
    pieChart.setVisible(false);
    barChart.setVisible(true);
    // The Animation when displaying a bar chart for the first time must 
    // be turned off unfortunately due to bug see: 
    // https://bugs.openjdk.java.net/browse/JDK-8093151
    barChart.setAnimated(false);
    barChart.setLegendVisible(false); // Useless in our case.
    barChart.getData().clear(); // Clear old data
    barChart.setTitle(
        "Yearly Production of " + bestCropName + " Over Past 10 Years");
    setTestValues1();
    int index = 0;
    // Create the series (each series is bar in our case) with
    // the correct information.
    for (int i = (presentYear - 11); i < (presentYear - 1); i++)
    {
      XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
      series.getData()
          .add(new XYChart.Data<String, Number>((presentYear - 10 + index) + "",
              past10YearsBestCropProduction.get(index)));
      series.setName(presentYear - 1 - index + "");
      barChart.getData().add(series);
      ++index;
    }
    currentYear.setText("Current Yearly Production of " + bestCropName
        + " to date: " + currentYearlyBestCropProduction);
    currentYear.setTextFill(Color.web("#FFFFFF"));
    currentYear.setVisible(true);
    barChart.setVisible(true);
  }

  /**
   * Set up a stacked bar chart to display the regions net exports over the past
   * 10 years.
   */
  public void displayExportsChart()
  {
    pieChart.setVisible(false);
    barChart.setVisible(true);
    barChart.setLegendVisible(false);
    barChart.setAnimated(true);
    barChart.getData().clear();
    barChart.setTitle("Net Yearly Regional Exports from the Past 10 Years");
    setTestValues2();
    int index = 0;
    // Create the series (each series is bar in our case) with
    // the correct information.
    for (int i = (presentYear - 11); i < (presentYear - 1); i++)
    {
      XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
      series.getData().add(new XYChart.Data<String, Number>(
          (presentYear - 10 + index) + "", past10YearsNetExports.get(index)));
      series.setName(presentYear - 1 - index + "");
      barChart.getData().add(series);
      ++index;
    }
    currentYear.setText(
        "Current Yearly Net Exports thus far: " + currentYearlyNetExports);
    currentYear.setTextFill(Color.web("#FFFFFF"));
    currentYear.setVisible(true);
    barChart.setVisible(true);
  }

  /**
   * Set up a stacked bar chart to display the regions net imports over the past
   * 10 years.
   */
  public void displayImportsChart()
  {
    pieChart.setVisible(false);
    barChart.setVisible(true);
    barChart.setLegendVisible(false);
    barChart.setAnimated(true);
    barChart.getData().clear();
    barChart.setTitle("Net Yearly Regional Imports from the Past 10 Years");
    setTestValues3();
    int index = 0;
    // Create the series (each series is bar in our case) with
    // the correct information.
    for (int i = (presentYear - 11); i < (presentYear - 1); i++)
    {
      XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
      series.getData().add(new XYChart.Data<String, Number>(
          (presentYear - 10 + index) + "", past10YearsNetImports.get(index)));
      series.setName(presentYear - 1 - index + "");
      barChart.getData().add(series);
      ++index;
    }
    currentYear.setText(
        "Current Yearly Net Imports thus far: " + currentYearlyNetImports);
    currentYear.setTextFill(Color.web("#FFFFFF"));
    currentYear.setVisible(true);
    barChart.setVisible(true);
  }

  /**
   * Set up a stacked bar chart to display the regions net production over the
   * past 10 years.
   */
  public void displayProductionChart()
  {
    pieChart.setVisible(false);
    barChart.setVisible(true);
    barChart.setLegendVisible(false);
    barChart.setAnimated(true);
    barChart.getData().clear();
    barChart.setTitle("Net Yearly Regional Production from the Past 10 Years");
    setTestValues4();
    int index = 0;
    // Create the series (each series is bar in our case) with
    // the correct information.
    for (int i = (presentYear - 11); i < (presentYear - 1); i++)
    {
      XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
      series.getData()
          .add(new XYChart.Data<String, Number>((presentYear - 10 + index) + "",
              past10YearsNetProduction.get(index)));
      series.setName(presentYear - 1 - index + "");
      barChart.getData().add(series);
      ++index;
    }
    currentYear.setText("Current Yearly Net Production thus far: "
        + currentYearlyNetProduction);
    currentYear.setTextFill(Color.web("#FFFFFF"));
    currentYear.setVisible(true);
    barChart.setVisible(true);
  }

  /**
   * Set up a stacked bar chart to display the regions net domestic consumption
   * over the past 10 years.
   */
  public void displayDomesticConsumptionChart()
  {
    pieChart.setVisible(false);
    barChart.setVisible(true);
    barChart.setLegendVisible(false);
    barChart.setAnimated(true);
    barChart.getData().clear();
    barChart
        .setTitle("Net Regional Domestic Consumption from the Past 10 Years");
    setTestValues5();
    int index = 0;
    // Create the series (each series is bar in our case) with
    // the correct information.
    for (int i = (presentYear - 11); i < (presentYear - 1); i++)
    {
      XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
      series.getData()
          .add(new XYChart.Data<String, Number>((presentYear - 10 + index) + "",
              past10YearsNetDomesticConsumption.get(index)));
      series.setName(presentYear - 1 - index + "");
      barChart.getData().add(series);
      ++index;
    }
    currentYear.setText("Current Yearly Net Domestic Consumption thus far: "
        + currentYearlyNetDomesticConsumption);
    currentYear.setTextFill(Color.web("#FFFFFF"));
    currentYear.setVisible(true);
    barChart.setVisible(true);
  }

  /**
   * 
   * @param Exit the stage when exit button is clicked.
   */
  @FXML
  public void exit(ActionEvent event)
  {
    regionBuilder.unLightUpRegion(); //Unlight the region that is toggled on.
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
  }

  /**
   * Hard code statistical information for demo. 
   */
  public void setTestValues1()
  {
    past10YearsBestCropProduction.add(1_436_483);
    past10YearsBestCropProduction.add(2_426_786);
    past10YearsBestCropProduction.add(2_245_518);
    past10YearsBestCropProduction.add(3_551_454);
    past10YearsBestCropProduction.add(6_155_152);
    past10YearsBestCropProduction.add(4_255_458);
    past10YearsBestCropProduction.add(5_258_152);
    past10YearsBestCropProduction.add(7_155_241);
    past10YearsBestCropProduction.add(8_155_151);
    past10YearsBestCropProduction.add(9_123_152);

  }

  /**
   * Hard code statistical information for demo. 
   */
  public void setTestValues2()
  {
    past10YearsNetExports.add(1_436_483);
    past10YearsNetExports.add(2_426_786);
    past10YearsNetExports.add(3_245_568);
    past10YearsNetExports.add(5_541_424);
    past10YearsNetExports.add(8_155_172);
    past10YearsNetExports.add(4_255_158);
    past10YearsNetExports.add(5_258_152);
    past10YearsNetExports.add(13_165_741);
    past10YearsNetExports.add(15_125_151);
    past10YearsNetExports.add(17_123_152);

  }

  /**
   * Hard code statistical information for demo. 
   */
  public void setTestValues3()
  {
    past10YearsNetImports.add(14_436_483);
    past10YearsNetImports.add(13_426_786);
    past10YearsNetImports.add(12_245_518);
    past10YearsNetImports.add(6_551_454);
    past10YearsNetImports.add(14_155_152);
    past10YearsNetImports.add(5_255_458);
    past10YearsNetImports.add(6_258_152);
    past10YearsNetImports.add(3_155_241);
    past10YearsNetImports.add(3_155_151);
    past10YearsNetImports.add(2_123_152);

  }

  /**
   * Hard code statistical information for demo. 
   */
  public void setTestValues4()
  {
    past10YearsNetProduction.add(1_436_483);
    past10YearsNetProduction.add(2_426_786);
    past10YearsNetProduction.add(2_245_518);
    past10YearsNetProduction.add(3_551_454);
    past10YearsNetProduction.add(6_155_152);
    past10YearsNetProduction.add(4_255_458);
    past10YearsNetProduction.add(5_258_152);
    past10YearsNetProduction.add(7_155_241);
    past10YearsNetProduction.add(8_155_151);
    past10YearsNetProduction.add(9_123_152);

  }

  /**
   * Hard code statistical information for demo. 
   */
  public void setTestValues5()
  {

    past10YearsNetDomesticConsumption.add(2_436_483);
    past10YearsNetDomesticConsumption.add(3_426_786);
    past10YearsNetDomesticConsumption.add(4_245_568);
    past10YearsNetDomesticConsumption.add(6_541_424);
    past10YearsNetDomesticConsumption.add(9_155_172);
    past10YearsNetDomesticConsumption.add(5_255_158);
    past10YearsNetDomesticConsumption.add(6_258_152);
    past10YearsNetDomesticConsumption.add(14_165_741);
    past10YearsNetDomesticConsumption.add(16_125_151);
    past10YearsNetDomesticConsumption.add(18_123_152);

  }
  /**
   * 
   * @param regionBuilder Instance of the region builder, used to
   * unlight a region and to pass an instance of this class to the object.
   * 
   */
  public void setRegionBuilder(BuildInteractiveRegions regionBuilder)
  {
    this.regionBuilder = regionBuilder;
    regionBuilder.setStatController(this);
  }
  
  /**
   * 
   * @param regionName Name of region clicked. 
   */
  public void setRegionName(String regionName)
  {
    regionNameLabel.setContentDisplay(ContentDisplay.CENTER);
    regionNameLabel.setText(regionName);
  }

}