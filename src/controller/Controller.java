package controller;

import java.util.ArrayList;
import model.Date;
import model.Model;
import model.WeekSchedule;
import view.GuiInterface;

/**
 * A class representing the controller.
 * @author Marian Claudiu Culea
 * @version 1.8 - 17/12/2018
 */
public class Controller
{
   
   private Model model;
   private GuiInterface view;
   /**
    * Two-Argument constructor.
    * @param model
    *       the model.
    *       
    * @param view
    *       the GuiInterface.
    */
   public Controller(Model model, GuiInterface view)
   {
      
      this.model = model;
      this.view = view;
   }
   
   /**
    * Calling the ModelManager for a WeekSchedule on a specific date.
    * @param date
    *         the date.
    * @return the dates of the week and their tasks in a ArrayList of Objects arrays.
    */
   public ArrayList<Object[]> executeWeekPlan(Date date)
   {
      
      Date monday=date.copy();
      ArrayList<Object[]> all = new ArrayList<>();
      String s="src/"+monday.weekNumber()+"-"+monday.getYear()+".txt";
      try {
      WeekSchedule week = model.getWeekPlan(s);
      for (int i = 0; i < 5; i++)
      {
         Object[] one = new Object[2];
         one[0] = week.getDay(i).getDate();
         one[1] = week.getDay(i).getTasks().getTasks();
         all.add(one);
      }
      }
      catch(Exception e) {
      
      WeekSchedule week= model.getNewWeekPlan(date);
      
      for (int i = 0; i < 5; i++)
      {
         Object[] one = new Object[2];
         one[0] = week.getDay(i).getDate();
         one[1] = week.getDay(i).getTasks().getTasks();
         all.add(one);
      }
      }
      return all;
   }
   /**
    * Calling the validateLogin method in the ModelManager. If the output is true changes scene to MainLogged scene, if not displaying error.
    * 
    * @param user
    *         the user name.
    * @param password
    *          the password.
    */
   public void executeLogin(String user, String password)
   {
      
      boolean result = model.validateLogin(user, password);
      if (result == false)
      {
         view.showError("Incorrect user or password.");
      }
      if(result==true) {
      view.setWindow("logged");
      }
   }

   
   public void executeTasks() {
      
   }
   
   public void executeEmployees() {
      
   }

   public void executeSearch() {
      
   }
   
   public void executeShowDay() {
      
   }

   public void executeAddAdmin()
   {
      
      
   }

}
