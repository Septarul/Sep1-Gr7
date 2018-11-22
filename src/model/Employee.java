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
      this.id=id;
      this.name = name;
      this.freeDays = null;
      this.pref = null;
      this.train= new ArrayList<>();
   }

   public name getName()
   {
      return name;
   }

   public void setName(name name)
   {
      this.name = name;
   }

   public Training getTraining()
   {
      return training;
   }

   public void setTraining(Training training)
   {
      this.training = training;
   }

   public FreeDays getFreeDays()
   {
      return freeDays;
   }

   public void setFreeDays(FreeDays freeDays)
   {
      this.freeDays = freeDays;
   }

   public String getPreferences()
   {
      return pref;
   }

   public void setPreferences(String preferences)
   {
      this.pref = preferences;
   }
}
