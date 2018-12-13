package model;

import java.util.ArrayList;

public interface FileManagerInterface
{
   public abstract WeekSchedule loadFromFile(String filename) throws Exception;
   public abstract void saveAllToFile(WeekSchedule plan, String filename) throws Exception;
   public abstract String validateLogin(String user, String password,Administrator[] list);
   public abstract void addEmployee(Employee e);
   public abstract void addTask(Task t);
   public abstract void addSchedule(DaySchedule s);
   public abstract void removeEmployee(Employee e);
   public abstract void removeTask(Task t);
   public abstract void removeDay(DaySchedule s);
   public abstract void addPreference(String pref , Employee e);
   public abstract void addFreeDay(FreeDays free,Employee e);
   public abstract void addTraining(Training t, Employee e);
   public abstract Employee getEmployee(Name name);
   public abstract ArrayList<Task> getTask(Task t);
   
}
