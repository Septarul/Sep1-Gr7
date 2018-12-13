package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager implements FileManagerInterface
{
   

   public TaskList loadTaskListFromFile(String filename) throws Exception{ 
      File file=new File(filename);
      Scanner in=new Scanner(file);
      TaskList list=new TaskList("GENERAL");
      while(in.hasNext()) {
         String line=in.nextLine();
         Task task= new Task(line);
         list.addTask(task);
      }
      in.close();
      return list;
   }
   
   public EmployeeList loadEmployeeListFromFile(String filename , TaskList list) throws Exception {
      File file=new File(filename);
      Scanner in=new Scanner(file);
      EmployeeList list1=new EmployeeList("ALLOFTHEM");
      while(in.hasNext()) {
         String line=in.nextLine();
         String[] token=line.split(";");
         String[] name=token[0].split(",");
         Name name1=new Name(name[0],name[1]);
         Employee e=new Employee(name1);
         if(token[1].equals("n")) {
            FreeDays freedays= new FreeDays();
            e.setFreeDays(freedays);
            }
         else {
         String[] freeday=token[1].split(",");
         String[] date1=freeday[0].split("/");
         int a = Integer.parseInt(date1[0]);
         int b = Integer.parseInt(date1[1]);
         int c = Integer.parseInt(date1[2]);
         Date start= new Date(a,b,c);
         String[] date2=freeday[1].split("/");
         a = Integer.parseInt(date2[0]);
         b = Integer.parseInt(date2[1]);
         c = Integer.parseInt(date2[2]);
         Date end= new Date(a,b,c);
         FreeDays freedays= new FreeDays(start,end,freeday[2]);
         e.setFreeDays(freedays);
         }
         if(token[2].equals("m")) {
            String pref = null;
            e.setPreferences(pref);
            }
         else {
            String pref = token[2];
            e.setPreferences(pref);
         }
            
            String[] training= token[3].split(",");
            for(int i=0; i<list.size();i++) {
               Training train= new Training(list.get(i).getName(),Integer.parseInt(training[i]));
               e.setTraining(train);
               }

            list1.addEmployee(e);
      }
      in.close();
      return list1;
   }
   

   @Override 
   public void saveAllToFile(WeekSchedule plan, String filename) throws Exception{
         saveAllToTextFile(plan, filename);
   }

   private void saveAllToTextFile(WeekSchedule list, String filename) throws FileNotFoundException{
      File file= new File(filename);
      PrintWriter out = new PrintWriter(file);
      /*for (int i = 0; i < list.size(); i++){
         int grade = list.getGrade(i).getGrade();
         String course = list.getGrade(i).getCourse();
         out.println(course + "; " + grade);
         }*/
         out.close(); 
         }

   }
      
   
   


