package model;
/**
 * 
 * @author Radu Candea
 * @version 2.0 - 16/12/2018
 */
public class Training
{
   private int status;
   private String task;
/**
 * two-argument constructor that initialises all the instance variables
 * @param task
 * @param status
 */
   public Training(String task, int status)
   {
      this.status = status;
      this.task = task;
   }
/**
 * a method that sets a task to in trained
 */
   public void train()
   {
      this.status = 2;
   }
/**
 * a method that sets a task to trained
 */
   public void completeTraining()
   {
      this.status = 3;
   }
   /**
    * getter method for the status
    * @return the status
    */
   public int getStatus()
   {
      return status;
   }
   /**
    * A method that transforms the int status to a string representing that int in the system.
    * @return a string representing the status
    */
   public String getStatusString()
   {
      if (status == 1)
      {
         return "Untrained";
      }
      else if (status == 2)
      {
         return "In training";
      }
      else
      {
         return "Trained";
      }
   }
/**
 * a method that sets the task to untrained
 */
   public void setUntrained()
   {
      this.status = 1;
   }
/**
 * getter method for the task
 * @return a string representing the task
 */
   public String getTask()
   {
      return task;
   }
}
