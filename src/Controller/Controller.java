package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Model;
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

      for (int i = 0; i < model.numberOfEmployees(); i++)
      {
         Object[] one = new Object[2];
         one[0] = model.getDaySchedule(i).getDate().dayOfWeek();
         one[1] = model.getTasks();
         all.add(one);
      }
      return all;
   }

}
