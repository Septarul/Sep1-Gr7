package model;
import java.util.ArrayList;

public class WeekSchedule
{
   private ArrayList<DaySchedule> days;
   private int week;
   private int year;

   public WeekSchedule()
   {
      this.year=0;
      this.week = 0;
      this.days = new ArrayList<>();
   }
   
   public WeekSchedule(int week,int year)
   {
      this.year=year;
      this.week = week;
      this.days = new ArrayList<>();
   }

   public int getYear() {
      return year;
   }
   
   public int size()
   {
      return days.size();
   }
   public int getWeekNumber()
   {
      return week;
   }

   public void setWeek(int number)
   {
      this.week = number;
   }
   public void setYear(int number)
   {
      this.year = number;
   }

   public DaySchedule getDay(int i) {
    return days.get(i);
   }
   public void addDay(DaySchedule day)
   {
      if (days.size() < 7)
      {
         this.days.add(day);
      }
   }

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

   public ArrayList<DaySchedule> getEmptyDays()
   {
      ArrayList<DaySchedule> empty=new ArrayList<>();
      for (int i = 0; i < days.size(); i++)
      {
         if(days.get(i).getTasks().equals(null))
         {
            empty.add(days.get(i));
         }
      }
      return empty;
   }
   public DaySchedule getDayByDate(int day,int month,int year)
   {
      for (int i = 0; i < days.size(); i++)
      {
         if(days.get(i).getDate().getDay()==day&&days.get(i).getDate().getMonth()==month&&days.get(i).getDate().getYear()==year)
         {
            return days.get(i);
         }
      }
      return null;
   }
   public DaySchedule getDayByDate(Date date)
   {
      for (int i = 0; i < days.size(); i++)
      {
         if(days.get(i).getDate().equals(date))
         {
            return days.get(i);
         }
      }
      return null;
   }
   
   public int getDayNumber()
   {
      return days.size();
   }

}
