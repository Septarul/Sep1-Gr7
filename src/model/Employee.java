package model;

import java.util.ArrayList;

public class Employee
{
   private String id;
   private name name;
   private FreeDays freeDays;
   private String preferences;
   private ArrayList<Training> train;

   public Employee(name name, String id)
   {
      this.id=id;
      this.name = name;
      this.freeDays = null;
      this.preferences = null;
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
      return preferences;
   }

   public void setPreferences(String preferences)
   {
      this.preferences = preferences;
   }
}
