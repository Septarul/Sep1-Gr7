package view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Task;

public class MainViewModel
{
   private StringProperty dayProperty;
   private ObjectProperty<Task> tasksProperty;
   
   
   public MainViewModel(String day, Task tasks)
   {
      dayProperty = new SimpleStringProperty(day);
      tasksProperty = new SimpleObjectProperty<>(tasks);
   }
   
   public String getDay()
   {
      return dayProperty.getValue();
   }
   
   public Task getTasks()
   {
      return tasksProperty.getValue();
   }
   
   public StringProperty getDayProperty()
   {
      return dayProperty;
   }
   
   public ObjectProperty<Task> getTasksProperty()
   {
      return tasksProperty;
   }
   
}
