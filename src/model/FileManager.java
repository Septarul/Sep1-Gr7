package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager
{
   
   public void loadEmployees() throws FileNotFoundException {
      File file=new File("test.txt");
      Scanner in=new Scanner(file);
      
      while(in.hasNext()) {
         String line=in.nextLine();
         String[] token=line.split(",");
         String nume=token[0].trim();
         String id=token[1].trim();
         String pref=token[2].trim();
         int x= Integer.parseInt(token[3].trim());
         int a=x+12;
         System.out.println(nume+"-"+id+"-"+pref+"-"+x+"-"+a);
      }
      in.close();
      System.out.println("end of reading file: "+ file.getAbsolutePath());
   }
   
   public void write() throws FileNotFoundException {
      File file = new File("test.txt");
      PrintWriter out = new PrintWriter(file);
<<<<<<< HEAD
      String[] text= {"ljhtftrd", "Nume2"+","+"id2"+","+"pref2",
=======
      String[] text= {"I dont know lols", "Nume2"+","+"id2"+","+"pref2",
>>>>>>> 5950662e623e62f3e1f215bd3f15ea98622a5ee5
                      "Nume3"+","+"id3"+","+"pref3", "Nume4"+","+"id4"+","+"pref4"
                     };
      for(int i = 0 ; i < text.length; i++){
         out.println(text[i]);
      }
      out.flush();
      
      out.close();
      }
   }

