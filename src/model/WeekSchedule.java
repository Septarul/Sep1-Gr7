package model;
import java.util.ArrayList;

public class WeekSchedule
{
   private ArrayList<DaySchedule> days;
   private String weekType;

   public WeekSchedule(String weekType)
   {
      this.weekType = weekType;
      this.days = new ArrayList<>();
   }

   public String getWeekType()
   {
      return weekType;
   }

   public void setWeekType(String weekType)
   {
      this.weekType = weekType;
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

   public ArrayList<DaySchedule> sortByDate()
   {
      return null;
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
}
