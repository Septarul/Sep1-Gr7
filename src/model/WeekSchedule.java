package model;

import java.util.ArrayList;
/**
 * A class representing the week plans with the days and the tasks in them.
 * 
 * @author Radu Candea
 * @version 4.0 - 17/12/2018
 *
 */
public class WeekSchedule
{
   private ArrayList<DaySchedule> days;
   private int week;
   private int year;
/**
 * No argument constructor that sets the variables to 0 and initialises the ArrayList.
 */
   public WeekSchedule()
   {
      this.year = 0;
      this.week = 0;
      this.days = new ArrayList<>();
   }
/**
 * Two-argument constructor that initialises the ArrayList and sets the year and week to the corresponding parameters.
 * @param week
 *          an int representing the week number in the calendar
 * @param year
 *          an int representing the year that includes that week
 */
   public WeekSchedule(int week, int year)
   {
      this.year = year;
      this.week = week;
      this.days = new ArrayList<>();
   }
/**
 * getter for the year.
 * @return the year
 */
   public int getYear()
   {
      return year;
   }
/**
 * A method that calculates the size of the ArrayList
 * @return the size of the array
 */
   public int size()
   {
      return days.size();
   }
/**
 * getter method for the week number variable
 * @return week number
 */
   public int getWeekNumber()
   {
      return week;
   }
/**
 * setter method for the week number
 * @param number
 *          the new number for the week
 */
   public void setWeek(int number)
   {
      this.week = number;
   }
/**
 * setter method for the year
 * @param number
 *          the new year for the variable
 */
   public void setYear(int number)
   {
      this.year = number;
   }
/**
 * a get method that returns a day at a specified index in the array
 * @param i
 *          the index of the day
 * @return the day at the specified index
 */
   public DaySchedule getDay(int i)
   {
      return days.get(i);
   }
/**
 * A method that adds a day to the array.
 * @param day
 *          the day to be added
 */
   public void addDay(DaySchedule day)
   {
      this.days.add(day);
   }
/**
 * a method searches and removes a day from the array list
 * @param day
 *          the day to be searched and removed
 */
   public void removeTasksFromDay(DaySchedule day)
   {
      for (int i = 0; i < days.size(); i++)
      {
         if (days.get(i).equals(day))
         {
            days.get(i).removeTasks();
         }
      }
   }
/**
 * a method that searches for days with no tasks assigned to them.
 * @return an ArrayList with the empty days
 */
   public ArrayList<DaySchedule> getEmptyDays()
   {
      ArrayList<DaySchedule> empty = new ArrayList<>();
      for (int i = 0; i < days.size(); i++)
      {
         if (days.get(i).getTasks().equals(null))
         {
            empty.add(days.get(i));
         }
      }
      return empty;
   }
/**
 * a method that searches in the array for a day with the specified date
 * @param date
 *          the date corresponding to the day
 * @return the day resulted from the search
 */
   public DaySchedule getDayByDate(Date date)
   {
      for (int i = 0; i < days.size(); i++)
      {
         if (days.get(i).getDate().equals(date))
         {
            return days.get(i);
         }
      }
      return null;
   }

}
