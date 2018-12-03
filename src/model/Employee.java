package model;

import java.util.ArrayList;

public class Employee
{
   private String id;
   private Name name;
   private FreeDays freeDays;
   private ArrayList<Preference> pref;
   private ArrayList<Training> train;

   public Employee(Name name, String id)
   {
      this.id = id;
      this.name = name;
      this.freeDays = null;
      this.pref = new ArrayList<>();
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

   public ArrayList<Training> getInTraining()
   {
      ArrayList<Training> training = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 2)
         {
            training.add(train.get(i));
         }
      }
      return training;
   }
   
   public ArrayList<Training> getNotTrained()
   {
      ArrayList<Training> nottrain = new ArrayList<>();
      for (int i = 0; i < train.size(); i++)
      {
         if (train.get(i).getStatus() == 1)
         {
            nottrain.add(train.get(i));
         }
      }
      return nottrain;
   }
   
   public ArrayList<Training> getTraining()
   {
      return train;
   }

   public Name getName()
   {
      return name;
   }

   public void setName(Name name)
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

   public ArrayList<Preference> getPreferences()
   {
      return pref;
   }

   public void setPreferences(Preference preferences)
   {
      pref.add(preferences);
   }

   public String getId()
   {
      return id;
   }

   public void setId(String id)
   {
      this.id = id;
   }
   
   public boolean hasFreeDay(Date date) {
      return freeDays.isFreeDate(date);
   }
}
