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

public class MainView
{
   @FXML private DatePicker datePicker;
   @FXML private TableColumn<MainViewModel, String> dayColumn;
   @FXML private TableColumn<MainViewModel, String> taskColumn;
   @FXML private TableView<MainViewModel> dayTable;
   private LocalDate selectedDate;
   
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
         this.scene = new Scene(root, 700, 510);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
  
   public void initialize()
   {
      Date date=new Date();
      LocalDate date1=LocalDate.now();
      selectedDate = getDateOfMonday(date1);
      datePicker.setValue(selectedDate);
      dayColumn.setCellValueFactory(
            cellData -> cellData.getValue().getDayProperty());
      taskColumn.setCellValueFactory(
            cellData -> cellData.getValue().getTasksProperty());
      
      ArrayList<String[]> data = gui.getController()
            .executeWeekPlan(date);
      ObservableList<MainViewModel> tableData = FXCollections
           .observableArrayList();
      tableData.add(new MainViewModel("SAD","ASD"));
      //dayTable.setItems(tableData);
      for (int i = 0; i < 2; i++)
      {
         String day = data.get(i)[0] + ""; 
         String tasks =data.get(i)[1]; 
         tableData.add(new MainViewModel(day,tasks));
System.out.println(tableData.get(i).getTasks());
      }
      //dayTable.setItems(tableData);
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
     // gui.getController().executeShowDay();
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
  
   private LocalDate getDateOfMonday(LocalDate date)
   {
      return LocalDate.of(date.getYear(), date.getMonthValue(),
            date.getDayOfMonth() - (date.getDayOfWeek().getValue() - 1));
   }
   
   /*private Date localDatetoMy(LocalDate date) {
      String s=date.toString();
      String[] token=s.split("-");
      return new Date(Integer.parseInt(token[2]),Integer.parseInt(token[1]),Integer.parseInt(token[0]));
   } */
   
   public void showWeekPlan(Date when)
   {  
      Date date=when.copy();
      ArrayList<String[]> data = gui.getController().executeWeekPlan(date);
      ObservableList<MainViewModel> tableData = FXCollections
            .observableArrayList();
       for (int i = 0; i < 2; i++)
       {
          String day = data.get(i)[0] + ""; 
          String tasks =(String) data.get(i)[1]; 
          tableData.add(new MainViewModel(day,tasks));
       }
       dayTable.setItems(tableData);
   }
   
   
   public Date pickerToDate(String date) {
      String[] token=date.split("-");
      return new Date(Integer.parseInt(token[2]),Integer.parseInt(token[1]),Integer.parseInt(token[0]));
      
   }
   @FXML
   private void datapressed()
   {
      System.out.println("SELECTED:" + datePicker.getValue());

      if (!(selectedDate.equals(getDateOfMonday(datePicker.getValue()))))
      {
         selectedDate = getDateOfMonday(datePicker.getValue());
         showWeekPlan(pickerToDate(datePicker.getValue().toString()));
      }
   }
   
   
   public Object[] getInput(String type)
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
      
   
   
}
