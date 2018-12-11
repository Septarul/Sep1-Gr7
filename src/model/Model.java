package model;

import java.util.ArrayList;

public interface Model
{
   public String validateLogin(String user, String password, Administrator[] list);
   public void addEmployee(Employee e);
   public void  addTask(Task t);
   public void addSchedule(DaySchedule s);
   public void removeEmployee(Employee e);
   public void removeTask(Task t);
   public void removeDay(DaySchedule s);
   public void addPreference(String pref , Employee e);
   public void addFreeDay(FreeDays free,Employee e);
   public Employee getEmployee(Name name);
   public ArrayList<Task> getTask(Task t);
   
}