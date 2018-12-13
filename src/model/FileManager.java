package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager implements FileManagerInterface
{
   

   @Override 
   public WeekSchedule loadFromFile(String filename) throws Exception{ 
   return loadFromFile(filename);
   }
   

   @Override 
   public void saveAllToFile(WeekSchedule sch, String filename) throws Exception{
         saveAllToTextFile(sch, filename);
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
   
   private WeekSchedule loadFromTextFile(String filename) throws FileNotFoundException{
      ///ArrayList<Grade> grades = new ArrayList<>();
      File file= new File(filename);
      Scanner in = new Scanner(file);
      while (in.hasNext()){
         String line = in.nextLine();
      // Read a line
      String[] token = line.split(";");
      // Split the line
      String course = token[0].trim();
      int grade = Integer.parseInt(token[1].trim());
      ///grades.add(new Grade(grade, course));
      }
      in.close();
      // Close the file
      ///GradeList list = new GradeList(grades.size());
      /// for (int i = 0; i < grades.size(); i++){
      ///   list.addGrade(grades.get(i));
      ///   }
      ///return list;
         }
   }
      
   
   


