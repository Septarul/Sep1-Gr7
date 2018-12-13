package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager implements FileManagerInterface
{
   

   @Override 
   public WeekSchedule loadFromFile(String filename) throws Exception{ 
   return loadFromFile(filename);
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
   
   private WeekSchedule loadFromTextFile(String filename)throws FileNotFoundException{
      ArrayList<DaySchedule> schedule = new ArrayList<>();
      File file= new File(filename);
      Scanner in = new Scanner(file);
      while (in.hasNext()){
         String line = in.nextLine();
      String[] token = line.split(";");
      }
      in.close();

      WeekSchedule week = new WeekSchedule();
      /// for (int i = 0; i < grades.size(); i++){
      ///   list.addGrade(grades.get(i));
      ///   }
      ///return list;
         }

   }
      
   
   


