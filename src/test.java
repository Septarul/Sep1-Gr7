import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test
{

   public static void main(String[] args) throws FileNotFoundException
   {
 

     
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
   }
