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

   public void train()
   {
      this.status = 2;
   }

   public void completeTraining()
   {
      this.status = 3;
   }
   public int getStatus()
   {
      return status;
   }
   public String getStatusString()
   {
      if (status == 1)
      {
         return "Untrained";
      }
      else if (status == 2)
      {
         return "In training";
      }
      else
      {
         return "Trained";
      }
   }

   public void setUntrained()
   {
      this.status = 1;
   }

   public String getTask()
   {
      return task;
   }
}
