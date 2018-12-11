package model;

import java.util.ArrayList;

public class Employee
{
   private Name name;
   private FreeDays freeDays;
   private String pref;
   private ArrayList<Training> train;

   public Employee(Name name)
   {
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
   
   public void setTraining(Training t) {
      train.add(t);
   }
   
   public ArrayList<Training> getTraining()
   {
      return train;
   }
   
   public ArrayList<Training> hasTraining(String task)
   {  ArrayList<Training> train2= new ArrayList<>();
   for(int i = 0 ; i < train.size(); i++){
      if(task.equals(train.get(i).getTask()) && train.get(i).getStatus()==3)
         train2.add(train.get(i));
   }
   return train2;

   }
   
   public ArrayList<Training> inTraining(String task)
   {  ArrayList<Training> train2= new ArrayList<>();
   for(int i = 0 ; i < train.size(); i++){
      if(task.equals(train.get(i).getTask()) && train.get(i).getStatus()==2)
         train2.add(train.get(i));
   }
   return train2;

   }
   
   public ArrayList<Training> unTrained(String task)
   {  ArrayList<Training> train2= new ArrayList<>();
   for(int i = 0 ; i < train.size(); i++){
      if(task.equals(train.get(i).getTask()) && train.get(i).getStatus()==1)
         train2.add(train.get(i));
   }
   return train2;

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

   public String getPreferences()
   {
      return pref;
   }

   public void setPreferences(String preference) 
   {
         this.pref=preference;
   }
   
   public boolean isPrefNull() {
      if(pref.equals(null))
         return true;
      return false;
   }
   
   public boolean hasFreeDay(Date date) {
      return freeDays.isFreeDate(date);
   }
}
