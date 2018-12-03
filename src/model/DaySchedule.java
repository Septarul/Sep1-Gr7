package model;

public class DaySchedule
{
   private Date date;
   private TaskList tasks;

   public DaySchedule(Date date, TaskList tasks)
   {
      this.date = date;
      this.tasks = tasks;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public TaskList getTasks()
   {
      return tasks;
   }
   public void removeTasks()
   {
      this.tasks=null;
   }
}
