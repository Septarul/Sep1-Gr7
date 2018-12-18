package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Date;

/**
 * A class representing the values for a table.
 * 
 * @author Marian Claudiu Culea
 * @version 1.2 - 16/12/2018
 */
public class MainViewModel
{
   private StringProperty dayProperty;
   private StringProperty tasksProperty;
   private Date date;
   /**
    * Two-Argument constructor.Using the dayOfWeek method to initialize the
    * dayProperty.
    * @param day
    *          a string representing the date of the day
    * @param tasks
    *          a String representing the tasks for that day
    */
   public MainViewModel(Date day, String tasks)
   {
      
      this.date = day;
      dayProperty = new SimpleStringProperty(day.dayOfWeek());
      tasksProperty = new SimpleStringProperty(tasks);
   }
/**
 * getter for the date
 * @return the date
 */
   public Date getDate()
   {
      
      return date;
   }
/**
 * getter for the day
 * @return the day
 */
   public String getDay()
   {
      
      return dayProperty.getValue();
   }
/**
 * getter for the tasks in a day
 * @return the tasks
 */
   public String getTasks()
   {
      
      return tasksProperty.getValue();
   }
/**
 * getter for the dayProperty
 * @return the day property
 */
   public StringProperty getDayProperty()
   {
      return dayProperty;
   }
/**
 * getter for the tasks
 * @return the tasks property
 */
   public StringProperty getTasksProperty()
   {
      
      return tasksProperty;
   }

}
