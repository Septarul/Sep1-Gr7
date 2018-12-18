
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import model.Administrator;
import model.Date;
import model.DaySchedule;
import model.Employee;
import model.EmployeeList;
import model.FreeDays;
import model.Model;
import model.ModelManager;
import model.Name;
import model.Task;
import model.TaskList;
import model.Training;
import model.WeekSchedule;
import view.GUI;
import view.GuiInterface;


public class Main
{
   public static void main(String[] args) throws Exception
   {
      Model model = new ModelManager();
      GuiInterface view = new GUI();
      Controller controller = new Controller(model, view);
      view.start(controller);
      
      
    /*
      File file = new File("src/task.txt");
      Scanner in = new Scanner(file);
      TaskList list = new TaskList("GENERAL");
      while (in.hasNext())
      {
         String line = in.nextLine();
         Task task = new Task(line);
         list.addTask(task);
      }
      in.close();

      File file1 = new File("src/employees.txt");
      in = new Scanner(file1);
      EmployeeList list2 = new EmployeeList("ALLOFTHEM");
      while (in.hasNext())
      {
         String line = in.nextLine();
         String[] token = line.split(";");
         String[] name = token[0].split(",");
         Name name1 = new Name(name[0], name[1]);
         Employee e = new Employee(name1);
         if (token[1].equals("n"))
         {
         }
         else
         {
            String[] freeday = token[1].split(",");
            String[] date1 = freeday[0].split("/");
            int a = Integer.parseInt(date1[0]);
            int b = Integer.parseInt(date1[1]);
            int c = Integer.parseInt(date1[2]);
            Date start = new Date(a, b, c);
            String[] date2 = freeday[1].split("/");
            a = Integer.parseInt(date2[0]);
            b = Integer.parseInt(date2[1]);
            c = Integer.parseInt(date2[2]);
            Date end = new Date(a, b, c);
            FreeDays freedays = new FreeDays(start, end, freeday[2]);
            e.setFreeDays(freedays);
         }
         if (token[2].equals("m"))
         {
            String pref = null;
            e.setPreferences(pref);
         }
         else
         {
            String pref = token[2];
            e.setPreferences(pref);
         }

         String[] training = token[3].split(",");
         for (int i = 0; i < list.size(); i++)
         {
            Training train = new Training(list.get(i).getName(),
                  Integer.parseInt(training[i]));
            e.setTraining(train);
         }

         list2.addEmployee(e);
      }
      in.close();

      file = new File("src/51-2018.txt");
      in = new Scanner(file);
      WeekSchedule list3 = new WeekSchedule();
      while (in.hasNext())
      {
         String line = in.nextLine();
         String[] token = line.split(";");
         String[] date1 = token[0].split(":");
         int a = Integer.parseInt(date1[0]);
         int b = Integer.parseInt(date1[1]);
         int c = Integer.parseInt(date1[2]);
         Date date = new Date(a, b, c);
         TaskList tasks = new TaskList();
         for (int i = 1; i < token.length; i++)
         {
            String[] day = token[i].split(",");
            Task t1 = new Task(day[0]);
            EmployeeList emps = new EmployeeList();
            for (int j = 1; j < day.length; j++)
            {
               String[] names = day[j].split("/");
               Name sal = new Name(names[0], names[1]);
               emps.addEmployee(list2.getEmployeeByName(sal));
            }
            t1.setEmployees(emps);
            tasks.addTask(t1);
         }
         DaySchedule schedule = new DaySchedule(date, tasks);
         list3.addDay(schedule);
      }
      in.close();
      System.out.println(list3.getDay(1).getTasks().get(0).getEmployees().get(1)
            .getName().getFullName());
            
      file = new File("src/admins.txt");
      in = new Scanner(file);
      ArrayList<Administrator> list9 = new ArrayList<>();
      while (in.hasNext())
      {
         String line = in.nextLine();
         String[] token = line.split(",");
         Administrator ad = new Administrator(token[0], token[1]);
         list.add(ad);
      }
      in.close();

      file = new File("src/admins2.txt");
      PrintWriter out = new PrintWriter(file);
      String user, pass;
      for (int i = 0; i < list9.size(); i++)
      {
         user = list9.get(i).getUser();
         pass = list9.get(i).getPassword();
         out.println(user + "," + pass);
      }
      out.close();

      ArrayList<Training> training = list3.getDay(0).getTasks().getList().get(0)
            .getEmployees().get(0).getCompletedTraining();
      String m = "";
      for (int i = 0; i < training.size(); i++)
      {
         m += training.get(i).getTask();
         if (i < training.size() - 1)
         {
            m += ", ";
         }
      }
      
      System.out
            .println("For the task "
                  + list3.getDay(0).getTasks().getList().get(0).getName() + ", "
                  + list3.getDay(0).getTasks().getList().get(0).getEmployees()
                        .get(0).getName().getFullName()
                  + " with the preference: "
                  + list3.getDay(0).getTasks().getList().get(0).getEmployees()
                        .get(0).getPreferences()
                  + ", trained in:" + m + " will be assigned "
                  + list3.getDay(0).getDayOfTheWeek() + " on the date: "
                  + list3.getDay(0).getDate().toString());
   */
   }
   
}

