package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class representing the class that reads and saves to files.
 * 
 * @author Marian Claudiu Culea
 * @version 1.3 - 16/12/2018
 */
public class FileManager implements FileManagerInterface
{
   /**
    * Reading the administrator file and creating an array list with the data.
    * 
    * @param filename
    *           the name of the file.
    * @return the array list with all the administrator.
    * @throws Exception if file is not found.
    */
   public ArrayList<Administrator> loadAdmins(String filename) throws Exception
   {
      File file = new File(filename);
      Scanner in = new Scanner(file);
      ArrayList<Administrator> list = new ArrayList<>();
      while (in.hasNext())
      {
         String line = in.nextLine();
         String[] token = line.split(",");
         Administrator ad = new Administrator(token[0], token[1]);
         list.add(ad);
      }
      in.close();
      return list;
   }

   /**
    * Reading the tasks from the file and creating a task list with the data.
    * 
    * @param filename
    *           the name of the file.
    * @return the task list all the administrator.
    * @throws Exception if file is not found.
    */
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

   /**
    * Reading the file with all the employees. Assigning them the correct
    * training for each task in the task list.
    * 
    * @param filename
    *           the name of the file.
    * @param list
    *           the list with all the files.
    * @return the employee list.
    * @throws Exception if file is not found.
    */
   public EmployeeList loadEmployeeListFromFile(String filename, TaskList list)
         throws Exception

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

   /**
    * Reading the file with a week schedule. Assigning the employees already
    * created to the tasks in the week.
    * 
    * @param filename
    *           the name of the file.
    * @param list1
    *           the list with all the employees.
    * @return the week schedule.
    * @throws Exception if file is not found.
    */
   public WeekSchedule loadWeekFromFile(String filename, EmployeeList list1)
         throws Exception
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
               Name sal = new Name(names[0], names[1]);
               emps.addEmployee(list1.getEmployeeByName(sal));
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

   /**
    * Saving the admin info to a file.
    * 
    * @param filename
    *           the name of the file.
    * @param list
    *           the list with the administrator.
    * @throws Exception if file is not found.
    */
   public void saveAdmins(String filename, ArrayList<Administrator> list)
         throws Exception
   {

   }

   /**
    * Saving the week schedule info to a file.
    * 
    * @param filename
    *           the name of the file.
    * @param list3
    *           the week schedule object.
    * @throws FileNotFoundException if file is not found.
    */
   public void saveWeekToFile(String filename, WeekSchedule list3)
         throws FileNotFoundException
   {
      File file = new File(filename);
      PrintWriter out = new PrintWriter(file);
      String date = "";
      String task = "";
      for (int i = 0; i < list3.size(); i++)
      {
         date = list3.getDay(i).getDate().getDay() + ":"
               + list3.getDay(i).getDate().getMonth() + ":"
               + list3.getDay(i).getDate().getYear();
         for (int j = 0; j < list3.getDay(i).getTasks().size(); j++)
         {
            String empl = "";
            for (int t = 0; t < list3.getDay(i).getTasks().get(j).getEmployees()
                  .size(); t++)
            {
               System.out
                     .println(list3.getDay(i).getTasks().get(j).getEmployees());
               empl += list3.getDay(i).getTasks().get(j).getEmployees().get(t)
                     .getName().getFirstName() + "/"
                     + list3.getDay(i).getTasks().get(j).getEmployees().get(t)
                           .getName().getLastName()
                     + ",";
            }
            task = list3.getDay(i).getTasks().get(j).getName() + "," + empl;
         }
         out.println(date + ";" + task);
      }
      out.close();
   }

   /**
    * Saving the task list info to a file.
    * 
    * @param filename
    *           the name of the file.
    * @param list
    *           the list with all the tasks.
    * @throws FileNotFoundException if file is not found.
    */
   public void saveTasksToFile(TaskList list, String filename)
         throws FileNotFoundException
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

   /**
    * Saving the task list info to a file.
    * 
    * @param filename
    *           the name of the file.
    * @param list1
    *           the list with all the employees.
    * @throws FileNotFoundException if file is not found.
    */
   public void saveEmployeesToFile(EmployeeList list1, String filename)
         throws FileNotFoundException

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

}
