package model;

public class Training
{
   private int status;
   private String task;

   public Training(Task task, int status)
   {
      this.status = status;
      this.task = task;
   }

   
   public int getStatus()
   {
      return status;
   }

   public void setStatus(int status)
   {
      this.status = status;
   }

   public Task getTask()
   {
      return task;
   }

   public void setTask(Task task)
   {
      this.task = task;
   }
   

}
