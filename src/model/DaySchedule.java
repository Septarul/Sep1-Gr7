package model;
/**
 * A class representing the day with the tasks that have to be made in that day.
 * 
 * @author Radu Candea
 * @version 2.1 - 15/12/2018
 */
public class DaySchedule
{
   private Date date;
   private TaskList tasks;
/**
 * A two-argument constructor that initialises the instance variables.
 * @param date
 *          the date of the day
 * @param tasks
 *          the task list for that day
 */
   public DaySchedule(Date date, TaskList tasks)
   {
      this.date = date;
      this.tasks = tasks;
   }
/**
 * getter method for the date
 * @return the date
 */
   public Date getDate()
   {
      return date;
   }
/**
 * setter method for the date
 * @param date
 *          the new date of the day
 */
   public void setDate(Date date)
   {
      this.date = date;
   }
/**
 * getter method for tasks
 * @return the task list for this day
 */
   public TaskList getTasks()
   {
      return tasks;
   }
/**
 * A method that removes all the tasks in this day.
 * 
 */
   public void removeTasks()
   {
      this.tasks = null;
   }
   /**
    * A method that adds a list of tasks to the day
    * @param tasks
    *          the tasks that will be made this day
    */
   public void addTaskList(TaskList tasks)
   {
      this.tasks = tasks;
   }
/**
 * A method that finds the name of the day by it's date
 * @return a String with the day of the week
 */
   public String getDayOfTheWeek()
   {
      return date.dayOfWeek();
   }
}
