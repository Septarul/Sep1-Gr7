package model;

import java.util.ArrayList;

public class Employee
{
   private String id;
   private name name;
   private FreeDays freeDays;
   private Preference pref;
   private ArrayList<Training> train;

   public Employee(name name, String id)
   {
      this.id = id;
      this.name = name;
      this.freeDays = null;
      this.pref = null;
      this.train = new ArrayList<>();
   }

   public ArrayList<Training> getCompletedTraining()
   {
      ArrayList<Training> completed = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 3)
         {
            completed.add(train.get(i));
         }
      }
      return completed;
   }

   public ArrayList<Training> getTraining()
   {
      return train;
   }

   public name getName()
   {
      return name;
   }

   public void setName(name name)
   {
      this.name = name;
   }

   public FreeDays getFreeDays()
   {
      return freeDays;
   }

   public void setFreeDays(FreeDays freeDays)
   {
      this.freeDays = freeDays;
   }

   public Preference getPreferences()
   {
      return pref;
   }

   public void setPreferences(Preference preferences)
   {
      this.pref = preferences;
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }
}
