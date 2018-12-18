package model;
/**
 * A class representing the interface for the model manager.
 * @author Sprite
 * @author Marian Claudiu Culea
 * @version 1.7 - 17/12/2018
 */

public interface Model
{
   public boolean validateLogin(String user, String password);
   public void addEmployee(Employee e);
   public void  addTask(Task t);
   public void addSchedule(DaySchedule s);
   public void removeEmployee(Employee e);
   public void removeTask(Task t);
   public void removeDay(DaySchedule s);
   public void addPreference(String pref , Name e);
   public void addFreeDay(FreeDays free,Name e);
   public Employee getEmployee(Name name);
   public int numberOfEmployees();
   public TaskList getTasks();
   public void addTraining(Training t, Name e);
   public Task getTask(String t);
   public WeekSchedule getWeekSchedule();
   public WeekSchedule getWeekPlan(String date) throws Exception;
   public WeekSchedule getNewWeekPlan(Date date);

}