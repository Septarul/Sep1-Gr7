package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelManager implements Model 
{
   
   private FileManagerInterface file;
   private EmployeeList employees;
   private WeekSchedule schedule;
   private TaskList tasks;
   
   
   public ModelManager() throws Exception
   {
      file = new FileManager();
      this.tasks=file.loadTaskListFromFile("src/task.txt");
      this.employees=file.loadEmployeeListFromFile("src/employees.txt",tasks);
      //Date date = new Date();
      //String s="src/";
      //s=date.weekNumber()+ "."+ date.getYear()+".txt";
      this.schedule=file.loadWeekFromFile("src/51.2018.txt", this.employees);
   }
   
   public WeekSchedule getWeekSchedule() {
      return schedule;
   }

   public String validateLogin(String user, String password,Administrator[] list)
   {
      for(int i = 0 ; i < list.length; i++){
         if(!(user.equals(list[i].getUser()))&& !(password.equals(list[i].getPassword()))) {
            return "Incorrect passowrd or username";
         }
      }
      return null;
   }
   
   public WeekSchedule getWeekPlan(String date) throws Exception {
      return file.loadWeekFromFile(date, this.employees);
   }
   
   public WeekSchedule getDummyWeekPlan(Date date) {
      WeekSchedule week=new WeekSchedule(date.weekNumber(), date.getYear());
      Date date1=date.copy();
      for (int i=0;i<5;i++) {
         TaskList tasks=new TaskList();
         tasks.addTask(new Task("Meelk"));
         DaySchedule day= new DaySchedule(date1, tasks);
         date1.stepForwardOneDay();
         week.addDay(day);
      }
      return week;
   }
   public WeekSchedule getNewWeekPlan(Date date)
   {
      WeekSchedule week=new WeekSchedule(date.weekNumber(), date.getYear());
      Date date1=date.copy();
      for (int i=0;i<5;i++) {
         TaskList tasks=new TaskList();
         DaySchedule day= new DaySchedule(date1, tasks);
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
   
   public int weekNumber(LocalDate date)
   {
      Date myDate = new Date(date.getDayOfMonth(), date.getMonthValue(),
            date.getYear());
      return myDate.weekNumber();
   }
   
}
