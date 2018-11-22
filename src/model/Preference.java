package model;

public class Preference
{
   public String pref;
   public String task;
   
   public Preference(String pref) {
      this.pref=pref;
      this.task=null;
   }
   
   public Preference(String pref, String task) {
      this.pref=pref;
      this.task=task;
   }
   
   public Preference() {
      this.pref=null;
      this.task=null;
   }

   public String getPref()
   {
      return pref;
   }

   public void setPref(String pref)
   {
      this.pref = pref;
   }

   public String getTask()
   {
      return task;
   }

   public void setTask(String task)
   {
      this.task = task;
   }
   
   public boolean isTaskNull() {
      if(task==null) {
         return true;
      }
      return false;
   }
   
}
