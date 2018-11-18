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

   public void removeDay(DaySchedule day)
   {
      for (int i = 0; i < days.size(); i++)
      {
         if (days.get(i).equals(day))
         {
            days.remove(i);
         }
      }
   }

   public ArrayList<DaySchedule> sortByDate()
   {
      for (int i = 0; i < days.size(); i++)
      {
         
      }
   }
}
