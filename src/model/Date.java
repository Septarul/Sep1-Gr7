package model;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * A class representing a date.
 * 
 * @author Marian Claudiu Culea
 * @version 1.3 - 16/12/2018
 */
public class Date
{
   private int day;
   private int month;
   private int year;

   /**
    * Three-Argument constructor that sets up the date.
    * 
    * @param day
    *           the day.
    * @param month
    *           the month.
    * @param year
    *           the year.
    */
   public Date(int day, int month, int year)
   {
      set(day, month, year);
   }

   /**
    * No Argument constructor that sets up the date as the present date.
    */
   public Date()
   {
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH) + 1;
      this.year = now.get(Calendar.YEAR);

   }
   /**
    * Finding out the week number of the date.
    * @return the integer representing the week number.
    */
   public int weekNumber()
   {
      LocalDate date = LocalDate.of(year, month, day);
      WeekFields wf = WeekFields.of(Locale.getDefault());
      TemporalField weekNum = wf.weekOfWeekBasedYear();
      int week = Integer.parseInt(String.format("%02d", date.get(weekNum)));
      return week;
   }
/**
 * Checking if the parameters are valid. And initializing the instance variables.
 * @param day
 *       the day.
 * @param month
 *          the month.
 * @param year
 *          the year.
 */
   public void set(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;

      if (this.year < 0)
      {
         this.year = -this.year;
      }
      if (this.month < 1)
      {
         this.month = 1;
      }
      else if (this.month > 12)
      {
         this.month = 12;
      }
      if (this.day < 1)
      {
         this.day = 1;
      }
      else if (this.day > numberOfDaysInMonth())
      {
         this.day = numberOfDaysInMonth();
      }
   }
/**
 * 
 * @return the day.
 */
   public int getDay()
   {
      return day;
   }
   /**
    * 
    * @return the month.
    */
   public int getMonth()
   {
      return month;
   }
   /**
    * 
    * @return the year.
    */
   public int getYear()
   {
      return year;
   }
/**
 * 
 * @return If the year is a leap year or not.
 */
   public boolean isLeapYear()
   {
      return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
   }
/**
 *  
 * @return an integer representing the number of days in the month.
 */
   public int numberOfDaysInMonth()
   {
      switch (month)
      {
         case 2:
            if (isLeapYear())
            {
               return 29;
            }
            else
            {
               return 28;
            }
         case 4:
         case 6:
         case 9:
         case 11:
            return 30;
         default:
            return 31;
      }
   }
/**
 * 
 * @return the name of the month.
 */
   public String getMonthName()
   {
      switch (month)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            return "Error in month";
      }
   }

   /**
    * Moving the date forward with one day.
    */
   public void stepForwardOneDay()
   {
      day++;
      if (day > numberOfDaysInMonth())
      {
         day = 1;
         month++;
         if (month > 12)
         {
            month = 1;
            year++;
         }
      }
   }

   /**
    * Checking if the date given as parameter is after this date.
    * @param other
    *          the date that gets checked.
    * @return a boolean variable representing if the param is befor the date or not.
    */
   public boolean isBefore(Date other)
   {
      if (this.year < other.year)
      {
         return true;
      }
      if (this.year > other.year)
      {
         return false;
      }
      if (this.month < other.month)
      {
         return true;
      }
      if (this.month > other.month)
      {
         return false;
      }
      if (this.day < other.day)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * Transforms a date to a string representing the name of the day.
    * @return a string representing the name of the day.
    */
   public String dayOfWeek()
   {
      int m = month;
      int y = year;
      if (month < 3)
      {
         y--;
         m += 12;
      }
      int h = (day + 13 * (m + 1) / 5 + (y % 100) + (y % 100) / 4
            + (y / 100) / 4 + 5 * (y / 100)) % 7;
      switch (h)
      {
         case 0:
            return "Saturday";
         case 1:
            return "Sunday";
         case 2:
            return "Monday";
         case 3:
            return "Tuesday";
         case 4:
            return "Wednesday";
         case 5:
            return "Thursday";
         case 6:
            return "Friday";
         default:
            return "Error";
      }
   }

   /**
    * Converting the date to a string.
    * @return a string with the date.
    */
   public String toString()
   {
      String s = day + "/";
      s += month + "/";
      s += year;
      return s;
   }

   /**
    * Checking if the object given as the parameter is the same as the date.
    * @return a boolean variable representing if the object is the same as the date.
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date))
      {
         return false;
      }
      Date other = (Date) obj;
      return day == other.day && month == other.month && year == other.year;
   }

   /**
    * Creating a copy for the date.
    * @return the copy.
    */
   public Date copy()
   {
      Date other = new Date(day, month, year);
      return other;
   }

}
