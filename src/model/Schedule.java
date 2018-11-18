package model;

import java.util.ArrayList;

public class Schedule
{
   private ArrayList<WeekSchedule> list;
   private String days;

   public Schedule(String days)
   {
      this.days = days;
      this.list = new ArrayList<>();

   }

   public void setDays(String days)
   {
      this.days = days;
   }

   public String getDays()
   {
      return days;
   }

   public void addDay(WeekSchedule week)
   {
      list.add(week);
   }
}
