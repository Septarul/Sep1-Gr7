package model;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Date
{
   private int day;
   private int month;
   private int year;

   public Date(int day, int month, int year)
   {
      set(day, month, year);
   }
   public Date() {
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH) + 1;
      this.year = now.get(Calendar.YEAR);

   }
   
   public int weekNumber()
   {
      LocalDate date = LocalDate.of(year, month, day);
      WeekFields wf = WeekFields.of(Locale.getDefault());
      TemporalField weekNum = wf.weekOfWeekBasedYear();
      int week = Integer.parseInt(String.format("%02d", date.get(weekNum)));
      return week;
   }

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

   public int getDay()
   {
      return day;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }

   public boolean isLeapYear()
   {
      return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
   }
   
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
   
   public void stepBackwardOneDay()
   {
      day--;
      if (day < 1)
      {
         month--;
         day = numberOfDaysInMonth();
         if (month < 1)
         {
            month = 12;
            year--;
         }
      }
   }
   
   public int daysBetween(Date other)
   {
      int count = 0;
      if (isBefore(other))
      {
         Date counterDate = this.copy();

         while (!counterDate.equals(other))
         {
            counterDate.stepForwardOneDay();
            count++;
         }
      }
      else
      {
         Date counterDate = other.copy();

         while (!counterDate.equals(this))
         {
            counterDate.stepForwardOneDay();
            count++;
         }
      }
      return count;
   }
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
   

   public int yearsBetween(Date other)
   {
      int years = Math.abs(this.year - other.year);

      if (isBefore(other))
      {
         if (this.month < other.month)
         {
            return years;
         }
         if (this.month > other.month)
         {
            return years - 1;
         }
         if (this.day <= other.day)
         {
            return years;
         }
         else
         {
            return years - 1;
         }
      }
      else
      {
         if (other.month < this.month)
         {
            return years;
         }
         if (other.month > this.month)
         {
            return years - 1;
         }
         if (other.day <= this.day)
         {
            return years;
         }
         else
         {
            return years - 1;
         }
      }
   }
   
   public String dayOfWeek() {
      int q = day;
      int m = month;
      int k = year%100;
      if(month<3)
      {
         year=year-1;
      }
      int j = year/100;
      int h = (q+(13*(m+1)/5)+k+k/4+j/4+5*j)%7;
      switch(h) {
         case 0: return "Saturday";
         case 1: return "Sunday";
         case 2: return "Monday";
         case 3: return "Tuesday";
         case 4: return "Wednesday";
         case 5: return "Thursday";
         case 6: return "Friday";
        default: return "Error";
      }
   } 
   
   public String toString()
   {
      String s = day + "/";
      s += month + "/";
      s += year;
      return s;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Date))
      {
         return false;
      }
      Date other = (Date)obj;
      return day==other.day && month==other.month&& year==other.year;   
   }
   
   public Date copy() {
      Date other = new Date(day, month, year);
      return other;
   }
   
}
