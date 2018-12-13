package model;

import java.util.ArrayList;

public class ModelManager implements Model 
{
   
   private FileManagerInterface file;
   private EmployeeList employees;
   private WeekSchedule schedule;
   private TaskList tasks;
   
   
   public ModelManager() throws Exception
   {
      this.tasks= file.loadTaskListFromFile("src/tasks.txt");
      this.employees= file.loadEmployeeListFromFile("src/employees.txt",tasks);
      this.schedule=file.loadWeekFromFile("src/51.2018", this.employees);
   }
   

   public String validateLogin(String user, String password,Administrator[] list)
   {
      for(int i = 0 ; i < list.length; i++){
         if(!(user.equals(list[i].getUser()))&& !(password.equals(list[i].getPassword()))) {
            return "Incorrect passowrd or username";
         }
         //else if()
         {
            
         }
      }
      return null;
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
      tasks.removeTask(t);
   }
   
   public void removeDay(DaySchedule s) {
      schedule.getDayByDate(s.getDate()).removeTasks();
   }
   
   public void addPreference(String pref , Employee e) {
      e.setPreferences(pref);
   }
   
   public void addFreeDay(FreeDays free,Employee e) {
      e.setFreeDays(free);
   }
   
public void addTraining(Training t, Employee e) {
      //e.setTraining(t);
   }
   
   public Employee getEmployee(Name name) {
   return employees.getEmployeeByName(name);  
   }
   
   public ArrayList<Task> getTask(Task t){
      ArrayList<Task> list = new ArrayList<>();
      list.add(tasks.getTaskByName(t.getName()));
      return list;
   }
   
   public DaySchedule getDaySchedule(int i) {
     return schedule.getDay(i);
   }
   
   public int numberOfEmployees() {
      return employees.size();
   }
   
   public String getTasks() {
      return tasks.getTasks();
   }
}
