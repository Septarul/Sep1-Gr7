package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Date;
import model.Model;
import model.WeekSchedule;
import view.GuiInterface;

public class Controller
{
   
   private Model model;
   private GuiInterface view;

   public Controller(Model model, GuiInterface view)
   {
      this.model = model;
      this.view = view;
   }
   
   public ArrayList<Object[]> executeGetDayInfo()
   {
      ArrayList<Object[]> all = new ArrayList<>();
      WeekSchedule week= model.getDummyWeekPlan(new Date(12,12,2012));
      for (int i = 0; i < 5; i++)
      {
         Object[] one = new Object[2];
         one[0] = week.getDay(i).getDate().dayOfWeek();
         one[1] = model.getTasks();
         all.add(one);
      }
     /* for (int i = 0; i < 5; i++)
      {
         Object[] one = new Object[2];
         one[0] = model.getWeekSchedule().getDay(i).getDate().dayOfWeek();
         one[1] = model.getTasks();
        // all.add(one);
      } */
      return all;
   }
   
   public int executeGetWeekNumber(LocalDate date)
   {
      return model.weekNumber(date);
   }

   public ArrayList<String[]> executeWeekPlan(Date date) 
   {
      Date monday=date.copy();
      ArrayList<String[]> all = new ArrayList<>();
      String s=monday.weekNumber()+"/"+monday.getYear();
      try {
      WeekSchedule week = model.getWeekPlan(s);
      for (int i = 0; i < 5; i++)
      {
         String[] one = new String[2];
         one[0] = week.getDay(i).getDate().dayOfWeek();
         one[1] = week.getDay(i).getTasks().getTasks();
         all.add(one);
      }
      }
      catch(Exception e) {
      
      WeekSchedule week= model.getNewWeekPlan(date);
      
      for (int i = 0; i < 5; i++)
      {
         String[] one = new String[2];
         one[0] = week.getDay(i).getDate().dayOfWeek();
         one[1] = week.getDay(i).getTasks().getTasks();
         all.add(one);
      }
      }
      return all;
   }
   
   public void executeLogin() {
      
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
      // TODO Auto-generated method stub
      
   }
}
