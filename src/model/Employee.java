package model;

public class Employee
{
   private name name;
   private String training;
   private int freeDays;
   private String preferences;
   
   public Employee (name name, String training, int freeDays)
   {
      this.name = name;
      this.training = training;
      this.freeDays = freeDays;
      this.preferences = null;
   }

   public name getName()
   {
      return name;
   }

   public void setName(name name)
   {
      this.name = name;
   }

   public String getTraining()
   {
      return training;
   }

   public void setTraining(String training)
   {
      this.training = training;
   }

   public int getFreeDays()
   {
      return freeDays;
   }

   public void setFreeDays(int freeDays)
   {
      this.freeDays = freeDays;
   }

   public String getPreferences()
   {
      return preferences;
   }

   public void setPreferences(String preferences)
   {
      this.preferences = preferences;
   }
}   
      
   





