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

   public MainViewModel(Date day, String tasks)
   {
      /**
       * Two-Argument constructor.Using the dayOfWeek method to initialize the
       * dayProperty.
       */
      this.date = day;
      dayProperty = new SimpleStringProperty(day.dayOfWeek());
      tasksProperty = new SimpleStringProperty(tasks);
   }

   public Date getDate()
   {
      /**
       * Returning the date.
       */
      return date;
   }

   public String getDay()
   {
      /**
       * Returning the value of dayProperty.
       */
      return dayProperty.getValue();
   }

   public String getTasks()
   {
      /**
       * Returning the value of tasksProperty.
       */
      return tasksProperty.getValue();
   }

   public StringProperty getDayProperty()
   {
      /**
       * Returning the dayPropery.
       */
      return dayProperty;
   }

   public StringProperty getTasksProperty()
   {
      /**
       * Returning the tasksProperty.
       */
      return tasksProperty;
   }

}
