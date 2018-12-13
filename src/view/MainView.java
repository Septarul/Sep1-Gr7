package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import model.Task;

public class MainView
{
   @FXML private TableView<MainViewModel> customerTable;
   @FXML private TableColumn<MainViewModel, String> dayColumn;
   @FXML private TableColumn<MainViewModel, Task> taskColumn;
   
   
   @FXML private Label errorLabel;

   private String title;
   private Scene scene;
   private GUI gui;
   
   public MainView(GUI gui)
   {
      try
      {
         this.gui = gui;
         this.title = "Table";
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(
               GUI.class.getResource("MainView.fxml"));
         loader.setController(this);
         Pane root = loader.load();
         this.scene = new Scene(root, 520, 300);
         scene.getStylesheets()
               .add(getClass().getResource("Layout.css").toExternalForm());
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
  
   public void initialize()
   {
      dayColumn.setCellValueFactory(
            cellData -> cellData.getValue().getDayProperty());
      taskColumn.setCellValueFactory(
            cellData -> cellData.getValue().getTasksProperty());

      ArrayList<Object[]> data = gui.getController()
            .executeGetDayInfo();
      ObservableList<ViewModelCustomer> tableData = FXCollections
            .observableArrayList();

      for (int i = 0; i < data.size(); i++)
      {
         String name = data.get(i)[0] + ""; 
         LocalDate date = (LocalDate) data.get(i)[1]; 
         tableData.add(new ViewModelCustomer(name, gender));
      }
      customerTable.setItems(tableData);

   }
   
   public Scene getScene()
   {
      return scene;
   }

   public String getTitle()
   {
      return title;
   }
   
   @FXML
   private void showpressed()
   {
      gui.getController().executeShowDay();
   }
   
   @FXML
   private void searchpressed()
   {
      gui.getController().executeSearch();
   }
   
   @FXML
   private void emplpressed()
   {
      gui.getController().executeEmployees();
   }
   
   @FXML
   private void taskpressed()
   {
      gui.getController().executeTasks();
   }
   
   @FXML
   private void loginpressed()
   {
      gui.getController().executeLogin();
   }
  /*??
   @FXML
   private void datapressed()
   {
      System.out.println("SELECTED: " + picker.getValue());

      if (comboBox.getSelectionModel().getSelectedItem() != null
            && !selectedDate.equals(getDateOfMonday(picker.getValue())))
      {
         showWeekPlan(comboBox.getSelectionModel().getSelectedItem(),
               datePicker.getValue());
      }
      setWeek(datePicker.getValue());
   }
   */
   
  // public getInput() {
      
   
   
}
