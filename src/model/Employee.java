package model;

import java.util.ArrayList;
/**
 * A class representing an employee with all his training and his preferences
 * @author Adrian Ionut Patrascu
 * @version 7.2 - 17/12/2018
 */
public class Employee
{
   private Name name;
   private FreeDays freeDays;
   private String pref;
   private ArrayList<Training> train;
/**
 * One-argument constructor that initialises the array list , sets the variable name to the parameter an the rest of the variables to null.
 * @param name
 *          the name of the employee
 */
   public Employee(Name name)
   {
      this.name = name;
      this.freeDays = null;
      this.pref = null;
      this.train = new ArrayList<>();
   }
/**
 * A method that searches all the tasks in which the employee has a training
 * @return an array list with all the corresponding training
 */
   public ArrayList<Training> getCompletedTraining()
   {
      ArrayList<Training> completed = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 3)
         {
            completed.add(train.get(i));
         }
      }
      return completed;
   }
/**
 * a method that searches for all the tasks in which the employee is in training at the moment
 * @return an array list with the corresponding training
 */
   public ArrayList<Training> getInTraining()
   {
      ArrayList<Training> training = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 2)
         {
            training.add(train.get(i));
         }
      }
      return training;
   }
/**
 * a method that searches all the tasks in which the employee is not trained yet
 * @return an array list with all the corresponding training
 */
   public ArrayList<Training> getNotTrained()
   {
      ArrayList<Training> nottrain = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 1)
         {
            nottrain.add(train.get(i));
         }
      }
      return nottrain;
   }
/**
 * a method that adds a trained task to the employee
 * @param t
 *       the training to be changed
 */
   public void setTraining(Training t)
   {
      train.add(t);
   }
/**
 * getter method for the training array list
 * @return all the training in an array list
 */
   public ArrayList<Training> getTraining()
   {
      return train;
   }
/**
 * a method searches if the employee is trained in a task
 * @param task
 *          the task
 * @return true or false depending on the answer
 */
   public boolean hasTraining(String task)
   {
      
      for (int i = 0; i < train.size(); i++)
      {
         if (task.equals(train.get(i).getTask())
               && train.get(i).getStatus() == 3)
            return true;
      }
      return false;
   }
/**
 * a method that searches if the employee is in training on a task
 * @param task
 *          the task
 * @return true or false depending on the answer
 */
   public boolean inTraining(String task)
   {
      
      for (int i = 0; i < train.size(); i++)
      {
         if (task.equals(train.get(i).getTask())
               && train.get(i).getStatus() == 2)
            return true;
      }
      return false;

   }
/**
 * a method that searches if the employee is untrained for a specified task
 * @param task
 *          the task
 * @return true/false depending on the answer
 */
   public boolean unTrained(String task)
   {
      
      for (int i = 0; i < train.size(); i++)
      {
         if (task.equals(train.get(i).getTask())
               && train.get(i).getStatus() == 1)
            return true;
      }
      return false;

   }
/**
 * getter method for the name
 * @return the name of the employee
 */
   public Name getName()
   {
      return name;
   }
/**
 * setter method for the employee name
 * @param name
 *          the name for the employee
 */
   public void setName(Name name)
   {
      this.name = name;
   }
/**
 * getter method for the free day
 * @return the free day
 */
   public FreeDays getFreeDays()
   {
      return freeDays;
   }
/**
 * setter method for the free day
 * @param freeDays
 *          the free day
 */
   public void setFreeDays(FreeDays freeDays)
   {
      this.freeDays = freeDays;
   }
/**
 * getter method for the preferences
 * @return preference as a srting
 */
   public String getPreferences()
   {
      return pref;
   }
/**
 * setter method for the preference
 * @param preference
 *          the preference as a string
 */
   public void setPreferences(String preference)
   {
      this.pref = preference;
   }
/**
 * A method that checks if the employee has a preference
 * @return true/false depending on the answer
 */
   public boolean isPrefNull()
   {
      if (pref==null)
         return true;
      return false;
   }
   /**
    * A method that checks if the employee has a free day
    * @return true/false depending on the answer
    */
   public boolean isFreeDaysNull()
   {
      if (freeDays==null)
         return true;
      return false;
   }
/**
 * A method that checks if a date is empty or if it has a free day on it
 * @param date
 *          the date to be checked
 * @return true or false depending on the answer
 */
   public boolean hasFreeDay(Date date)
   {
      return freeDays.isFreeDate(date);
   }
}
