package model;

import java.util.ArrayList;
/**
 * 
 * @author Marian Claudiu Culea
 *
 */
public class ModelManager implements Model 
{
   
   private FileManagerInterface file;
   private EmployeeList employees;
   private WeekSchedule schedule;
   private TaskList tasks;
   private ArrayList<Administrator> admins;
   
   
   public ModelManager() throws Exception
   {
      file = new FileManager();
      this.tasks=file.loadTaskListFromFile("src/task.txt");
      this.employees=file.loadEmployeeListFromFile("src/employees.txt",tasks);
      //Date date = new Date();
      //String s="src/";
      //s=date.weekNumber()+ "."+ date.getYear()+".txt";
      this.schedule=file.loadWeekFromFile("src/51-2018.txt", this.employees);
      this.admins=file.loadAdmins("src/admins.txt");
   }
   
   public WeekSchedule getWeekSchedule() {
      return schedule;
   }

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
   
   public WeekSchedule getWeekPlan(String date) throws Exception {
      return file.loadWeekFromFile(date, this.employees);
   }
   
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
   
   public void addEmployee(Employee e) {
      employees.addEmployee(e);
   }
   
   public void  addTask(Task t) {
      tasks.addTask(t);
   }
   
   public void addSchedule(DaySchedule s) {
      schedule.addDay(s);
   }
  
   public void removeEmployee(Employee e) {
      employees.removeEmployee(e.getName());
   }
   
   public void removeTask(Task t) {
      tasks.removeTask(t.getName());
   }
   
   public void removeDay(DaySchedule s) {
      schedule.getDayByDate(s.getDate()).removeTasks();
   }
   
   public void addPreference(String pref , Name e) {
      employees.getEmployeeByName(e).setPreferences(pref);
   }
   
   public void addFreeDay(FreeDays free,Name e) {
      employees.getEmployeeByName(e).setFreeDays(free);;
   }
   
  public void addTraining(Training t, Name e) {
     employees.getEmployeeByName(e).setTraining(t);
   }
   
   public Employee getEmployee(Name name) {
   return employees.getEmployeeByName(name);  
   }
   
   public Task getTask(String t){
      return tasks.getTaskByName(t);
   }

   public int numberOfEmployees() {
      return employees.size();
   }

   public TaskList getTasks()
   {
      return tasks;
   }

}
