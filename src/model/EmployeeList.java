package model;
import java.util.ArrayList;

public class EmployeeList
{
   private String name;

   private ArrayList<EmployeeList> list;

   public EmployeeList(String name)
   {
      this.list = new ArrayList<>();
      this.name = name;
   }

   public String getName()
   {
      return name;
   }

   public int size()
   {
      return list.size();
   }

   public void addEmployee(String employee)
   {
      this.list.add(employee);
   }

   public void removeEmployee(int index)
   {
      this.list.remove(index);
   }

   public Employee get(int index)
   {
      return list.get(index);
   }

   public Employee getEmployeeByName(String name)
   {
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getName().equals(name))
         {
            return list.get(i);
         }
      }
      return null;
   }

   public ArrayList<EmployeeList> getList()
   {
      return list;
   }

   public Employee getEmployeeByID(int id)
   {
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getID() == id)
         {
            return list.get(i);
         }
      }
      return null;
   }

}
