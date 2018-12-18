package model;

import java.util.ArrayList;
/**
 * A class representing the model manager of the system
 * 
 * @author Marian Claudiu Culea
 * @version 1.7 - 17/12/2018
 */
public class ModelManager implements Model 
{
   
   private FileManagerInterface file;
   private EmployeeList employees;
   private WeekSchedule schedule;
   private TaskList tasks;
   private ArrayList<Administrator> admins;
   
   /**
    * No argument constructor that assigns the the Task list, Employee list, Week schedule and admins from the files. 
    * @throws Exception if one of the files is not found.
    */
   public ModelManager() throws Exception
   {
     
      file = new FileManager();
      this.tasks=file.loadTaskListFromFile("src/task.txt");
      this.employees=file.loadEmployeeListFromFile("src/employees.txt",tasks);
      this.schedule=file.loadWeekFromFile("src/51-2018.txt", this.employees);
      this.admins=file.loadAdmins("src/admins.txt");
   }
   /**
    * getter for the week schedule
    * @return the week schedule.
    */
   public WeekSchedule getWeekSchedule() {
      
      return schedule;
   }
   /**
    * Checking if the arguments are compatible with the administrators in the system.
    * 
    * @param user
    *          a String with the user name
    * @param password
    *          a String with the password
    */
   public boolean validateLogin(String user, String password)
   {
      
      for(int i = 0 ; i < admins.size(); i++){
         if(user.equals(admins.get(i).getUser())) {
            if(password.equals(admins.get(i).getPassword())) {
               return true;
        }
       }
      }
      return false;
   }
   /**
    * Calling the load method from file manager.
    * @param date
    *        the name of the file.
    * @return the week schedule.
    * @throws Exception if file is not found.
    */
   public WeekSchedule getWeekPlan(String date) throws Exception {
      
      return file.loadWeekFromFile(date, this.employees);
   }
   /**
    * Creating an empty week schedule from monday to friday.
    * @param date
    *         the starting date.
    * @return the empty week schedule.
    */
   public WeekSchedule getNewWeekPlan(Date date)
   {
      Date date1=date.copy();
      WeekSchedule week=new WeekSchedule(date1.weekNumber(), date1.getYear());
      for (int i=0;i<5;i++) {
         TaskList tasks=new TaskList();
         DaySchedule day= new DaySchedule(date1.copy(), tasks);
         date1.stepForwardOneDay();
         
         week.addDay(day);
      }
      return week;
   }
   /**
    * Adding an employee to the General employee list.
    * @param e
    *        the employee.
    */
   public void addEmployee(Employee e) {
      
      employees.addEmployee(e);
   }
   /**
    * Adding a task to the General task list.
    * @param t 
    *        the task.
    */
   public void  addTask(Task t) {
      
      tasks.addTask(t);
   }
   /**
    * Adding a day to the weekschedule.
    * @param s
    *        the day.
    */
   public void addSchedule(DaySchedule s) {
      
      schedule.addDay(s);
   }
   /**
    * Removing an employee from the General employee list.
    * @param e
    *        the employee.
    */
   public void removeEmployee(Employee e) {
      
      employees.removeEmployee(e.getName());
   }
   /**
    * Removing a task from the General task list.
    * @param t
    *        the task.
    */
   public void removeTask(Task t) {
      
      tasks.removeTask(t.getName());
   }
   /**
    * Removing all the task for a day.
    * @param s
    *        the day.
    */
   public void removeDay(DaySchedule s) {
      
      schedule.getDayByDate(s.getDate()).removeTasks();
   }
   /**
    * Adding a preference to an employee.
    * @param pref
    *          a string with the preference.
    * @param e
    *         the name of the employee.
    */
   public void addPreference(String pref , Name e) {
      
      employees.getEmployeeByName(e).setPreferences(pref);
   }
   /**
    * Adding a freedays object to an employee.
    * @param free
    *       the freedays.
    * @param e
    *       the name of the employee.
    */
   public void addFreeDay(FreeDays free,Name e) {
      
      employees.getEmployeeByName(e).setFreeDays(free);;
   }
   /**
    * Adding a training to an employee.
    * @param t
    *        the training.
    * @param e
    *        the name of the employee.
    */
  public void addTraining(Training t, Name e) {
     
     employees.getEmployeeByName(e).setTraining(t);
   }
  /**
   * Returning an employee.
   * @param name 
   *        the name of the employee.
   * @return the employee.
   */
   public Employee getEmployee(Name name) {
      
   return employees.getEmployeeByName(name);  
   }
   /**
    * Returning a task.
    * @param t
    *        the name of the task.
    * @return the task.
    */
   public Task getTask(String t){
      
      return tasks.getTaskByName(t);
   }
   /**
    * Returning the size of the general list of employees. 
    */
   public int numberOfEmployees() {
      
      return employees.size();
   }
   /**
    * @return the general task list.
    */
   public TaskList getTasks()
   {
      
      return tasks;
   }

}
