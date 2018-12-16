package model;

import java.io.File;
import java.util.Scanner;

public class FileManager implements FileManagerInterface
{

   public TaskList loadTaskListFromFile(String filename) throws Exception
   {
      File file = new File(filename);
      Scanner in = new Scanner(file);
      TaskList list = new TaskList("GENERAL");
      while (in.hasNext())
      {
         String line = in.nextLine();
         Task task = new Task(line);
         list.addTask(task);
      }
      in.close();
      return list;
   }

   public EmployeeList loadEmployeeListFromFile(String filename, TaskList list) throws Exception
         
   {
      File file = new File(filename);
      Scanner in = new Scanner(file);
      EmployeeList list1 = new EmployeeList("ALLOFTHEM");
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

         list1.addEmployee(e);
      }
      in.close();
      return list1;
   }

   public WeekSchedule loadWeekFromFile(String filename, EmployeeList list1) throws Exception
         
   {

      File file = new File(filename);
      Scanner in = new Scanner(file);
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
               Name sal=new Name(names[0],names[1]);
               emps.addEmployee(
                    list1.getEmployeeByName(sal));
            }
            t1.setEmployees(emps);
            tasks.addTask(t1);
         }
         DaySchedule schedule = new DaySchedule(date, tasks);
         list3.addDay(schedule);
      }
      in.close();
      return list3;
   }
/*
   @Override
   public void saveTasksToFile(TaskList list, String filename) throws FileNotFoundException
   {
      String[] tasks = new String[list.size()];
      for (int i = 0; i < list.size(); i++)
      {
         tasks[i] = list.get(i).getName();
      }
      File file = new File(filename);
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < tasks.length; i++)
      {
         out.println(tasks[i]);
      }
      out.close();
   }

   public void saveEmployeesToFile(EmployeeList list1, String filename) throws FileNotFoundException
         
   {
      File file = new File(filename);
      PrintWriter out = new PrintWriter(file);
      String[] employ = new String[list1.size()];
      String[] free = new String[list1.size() * 3];
      String pref = "";
      String[] train = new String[list1.get(1).getTraining().size()];
      for (int i = 0; i < list1.size(); i++)
      {
         employ[i] = list1.get(i).getName().getFirstName() + ","
               + list1.get(i).getName().getLastName();
         if (!(list1.get(i).isFreeDaysNull()))
         {
            free[i] = list1.get(i).getFreeDays().getStartDate().getDay() + "/"
                  + list1.get(i).getFreeDays().getStartDate().getMonth() + "/"
                  + list1.get(i).getFreeDays().getStartDate().getYear() + ","
                  + list1.get(i).getFreeDays().getEndDate().getDay() + "/"
                  + list1.get(i).getFreeDays().getEndDate().getMonth() + "/"
                  + list1.get(i).getFreeDays().getEndDate().getYear() + ","
                  + list1.get(i).getFreeDays().getType();
         }
         else
         {
            free[i] = "n";
         }
         if (!(list1.get(i).isPrefNull()))
         {
            pref = list1.get(i).getPreferences();
         }
         else
         {
            pref = "m";
         }
         int m = 0;
         for (int j = 0; j < list1.get(i).getTraining().size(); j++)
         {
            train[j] = list1.get(i).getTraining().get(m).getStatus() + "";
            if (j < list1.get(i).getTraining().size() - 1)
            {
               train[j] += ",";
            }
            m++;
         }
         String trainings = "";
         for (int t = 0; t < train.length; t++)
         {
            trainings += train[t];
         }

         out.println(employ[i] + ";" + free[i] + ";" + pref + ";" + trainings);
      }
      out.close();
   }

   public void saveWeekToFile(WeekSchedule week, String filename) throws FileNotFoundException
         
   {
      File file = new File(filename);
      PrintWriter out = new PrintWriter(file);
      String[] date = new String[week.size()];
      String[] task = new String[week.size()];
      for (int i = 0; i < week.size(); i++)
      {
         date[i] = week.getDay(i).getDate().getDay() + ":"
               + week.getDay(i).getDate().getMonth() + ":"
               + week.getDay(i).getDate().getYear();
         for (int j = 0; j < week.getDay(i).getTasks().size(); j++)
         {
            //if (j < week.getDay(i).getTasks().size() - 1)
            //{
               for (int t = 0; t < week.getDay(i).getTasks().get(j)
                     .getEmployees().size(); t++)
               {
                  //if (t < week.getDay(i).getTasks().get(j).getEmployees().size()
                  //     - 1)
                  //{
                     task[i] += week.getDay(i).getTasks().get(j).getName() + ","
                           + week.getDay(i).getTasks().get(j).getEmployees()
                                 .get(t).getName().getFirstName()
                           + "/" + week.getDay(i).getTasks().get(j)
                                 .getEmployees().get(t).getName().getLastName()
                           + ",";
                  //}
               }
            }
            //else
            //{

            //}
         out.println(date[i]+";"+task[i]);
      }
      out.close();
   }
   */

   @Override
   public void saveTasksToFile(TaskList list, String filename) throws Exception
   {
      // TODO Auto-generated method stub
      
   }
}
