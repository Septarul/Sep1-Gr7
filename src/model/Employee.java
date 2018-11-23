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

   public ArrayList<Training> getTraining()
   {
      return train;
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
