package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainViewModel
{
   private StringProperty dayProperty;
   private StringProperty tasksProperty;
   
   
   public MainViewModel(String day, String tasks)
   {
      dayProperty = new SimpleStringProperty("dayasd");
      tasksProperty = new SimpleStringProperty("tasksddd");
   }
   
   public String getDay()
   {
      return dayProperty.getValue();
   }
   
   public String getTasks()
   {
      return tasksProperty.getValue();
   }
   
   public StringProperty getDayProperty()
   {
      return dayProperty;
   }
   
   public StringProperty getTasksProperty()
   {
      return tasksProperty;
   }
   
}
