package model;

public class Training
{
   private int status;
   private String task;

   public Training(String task, int status)
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

   public String getTask()
   {
      return task;
   }

   public void setTask(String task)
   {
      this.task = task;
   }
   

}
