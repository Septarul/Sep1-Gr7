package model;

public class DaySchedule
{
   private MyDate date;
   private TaskList tasks;

   public DaySchedule(MyDate date, TaskList tasks)
   {
      this.date = date;
      this.tasks = tasks;
   }

   public MyDate getDate()
   {
      return date;
   }

   public void setDate(MyDate date)
   {
      this.date = date;
   }

   public TaskList getTasks()
   {
      return tasks;
   }
}
