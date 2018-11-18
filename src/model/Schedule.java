package model;
import java.util.ArrayList;
public class Schedule
{
   private ArrayList<WeekSchedule> list;
   private String days;
   

}
public Schedule(String days)
{
   this.days=days;
   this.list= new ArrayList<>();
   
}
public void setDays(String days)
{
   this.days=days;
}
public String getDays()
{
   return days;
}
public void addDay(String days)
{
   list.add;
}
public void removeDay(String days)
{
   list.remove;
}
public boolean checkDay(String free)
{
   for(int i=0;i<list.size; i++)
   {
      if(list.get(i).getDays().equals(free))
      {
         return true;
      }
      return false;
   }

}
