package view;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import model.Date;
/**
 * A class representing the first window you see when you start the program.
 * @author Marian Claudiu Culea
 * @version 1.5 - 17/12/2018
 *
 */
public class MainView
{
   @FXML private DatePicker picker;
   @FXML private TableColumn<MainViewModel, String> dayColumn;
   @FXML private TableColumn<MainViewModel, String> taskColumn;
   @FXML private Label errorLabel;
   @FXML private TableView<MainViewModel> table;
   private LocalDate selectedDate;
   private String title;
   private Scene scene;
   private GUI gui;
   /**
    * One-argument constructor. Setting up the scene and title.
    * 
    * @param gui 
    *       The gui.
    * 
    */
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
         this.scene = new Scene(root, 710, 510);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   /**
    * Initialising the columns for the table and the date on the date picker.
    * @throws Exception
    *               if the file is not found
    */
   public void initialize() throws Exception
   {
      
      
      LocalDate date1=LocalDate.now();
      Date date =localToDate(date1);
      selectedDate = getDateOfMonday(date1);
      picker.setValue(selectedDate);
      dayColumn.setCellValueFactory(
            cellData -> cellData.getValue().getDayProperty());
      taskColumn.setCellValueFactory(
            cellData -> cellData.getValue().getTasksProperty());
      
      ArrayList<Object[]> data = gui.getController()
            .executeWeekPlan(date);
      ObservableList<MainViewModel> tableData = FXCollections
           .observableArrayList();

      for (int i = 0; i < 5; i++)
      {
         Date day =(Date) data.get(i)[0];
         String tasks =(String)data.get(i)[1]; 
         tableData.add(new MainViewModel(day,tasks));
      }
      table.setItems(tableData);
   }
   /**
    * getter for the scene
    * @return the scene.
    */
   public Scene getScene()
   {
      
      return scene;
   }
   /**
    * getter for the title
    * @return the title.
    */
   public String getTitle()
   {
      
      return title;
   }
   /**
    * Changes the stage to the DayView stage.
    */
   @FXML
   private void showpressed()
   {
     
    MainViewModel selected=table.getSelectionModel().getSelectedItem();
    //gui.setWindow("show");
    
   }
   /**
    * Changes the stage to the SearchView stage. 
    */
   @FXML
   private void searchpressed()
   {
      
      gui.setWindow("search");
   }
   /**
    * Changes the stage to the EmployeesList stage.
    */
   @FXML
   private void emplpressed()
   {
      
      gui.setWindow("employees");
   }
   /**
    * Changes the stage to the TaskList stage.
    */
   @FXML
   private void taskpressed()
   {
      
      gui.setWindow("tasks");
   }
   /**
    * Changes the stage to the LoginView stage.
    */
   @FXML
   private void loginpressed()
   {
      
      gui.setWindow("login");
   }
   /**
    * Getting the date of the Monday from the week of the parameter.
    * 
    * @param date
    *       the date.
    *       
    * @return the date of Monday from the week of the date.
    */
   private LocalDate getDateOfMonday(LocalDate date)
   {
      
      return LocalDate.of(date.getYear(), date.getMonthValue(),
            date.getDayOfMonth() - (date.getDayOfWeek().getValue() - 1));
   } 
   /**
    * Shows the days and the tasks for them in the table. Getting all the information from the controller and converting it in arguments for the MainViewModel.
    * 
    * @param when
    *        the date of Monday for the week that will be shown
    * @throws Exception
    *        if the data is not found
    */
   public void showWeekPlan(LocalDate when) throws Exception
   {  
      
      Date date=localToDate(when);
      ArrayList<Object[]> data = gui.getController().executeWeekPlan(date);
      ObservableList<MainViewModel> tableData = FXCollections
            .observableArrayList();
       for (int i = 0; i < 5; i++)
       {
          Date day = (Date)data.get(i)[0]; 
          String tasks =(String)data.get(i)[1]; 
          tableData.add(new MainViewModel(day,tasks));
       }
       table.setItems(tableData);
   }
   
   /**
    * Converting a LocalDate to a Date object.
    * 
    * @param date
    *          the LocalDate.
    * @return the Date object.
    */
   public Date localToDate(LocalDate date) {
      
      String date1=date.toString();
      String[] token=date1.split("-");
      return new Date(Integer.parseInt(token[2]),Integer.parseInt(token[1]),Integer.parseInt(token[0]));  
   }
   /**
    * Checking if the selected date from the data picker is in the same week as the one shown at the moment. If it's different calls the method showWeekPlan to display the week selected.
    * @throws Exception
    */
   @FXML
   private void datapressed() throws Exception
   {
      

      if (!(selectedDate.equals(getDateOfMonday(picker.getValue()))))
      {
         selectedDate = getDateOfMonday(picker.getValue());
         showWeekPlan(selectedDate);
         picker.setValue(selectedDate);
      }
   }
   
   /**
    * Moving the table data to a String array.
    * @param type
    *          a String representing the type
    * @return the days for a week
    */
   public String[] getInput(String type)
   {
      
      if (type.equals("days"))
      {
         String[] days = new String[5];
         for (int i = 0; i < 5; i++)
         {
            days[i] = (String) dayColumn
                  .getCellData(i);
         }
         return days;
      }
      else
      {
         String[] indices = new String[5];
         for (int i = 0; i < 5; i++)
         {
            indices[i] = taskColumn.getCellData(i);
         }
         return indices;
      }
   }
   /**
    * Displays an error on the screen.
    * 
    * @param error
    *          the error that is displaying.
    */
   public void showError(String error)
   {
      
      errorLabel.setText(error);
   }
   
}
