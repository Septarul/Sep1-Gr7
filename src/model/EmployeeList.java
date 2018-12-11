package model;
import java.util.ArrayList;

public class EmployeeList
{
   private String name;
   private ArrayList<Employee> list;

   
   public EmployeeList()
   {
      this.list = new ArrayList<>();
      this.name = null;
   }
   
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

   public void addEmployee(Employee employee)
   {
      this.list.add(employee);
   }

   public void removeEmployee(int index)
   {
      this.list.remove(index);
   }
   public void removeEmployee(Name name)
   {
      for (int i = 0; i <list.size(); i++)
      {
         if(list.get(i).getName().equals(name))
         {
            list.remove(i);
         }
      }
   }

   public Employee get(int index)
   {
      return list.get(index);
   }

   public Employee getEmployeeByName(Name name)
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
   
   public ArrayList<Employee> getEmployeesWithPref(){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if (!(list.get(i).isPrefNull()))
         {
            list2.add(list.get(i));
         }
      }
      return list2;
   }
   
   public ArrayList<Employee> getEmployeesTrained(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).hasTraining(task).isEmpty())) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   
   public ArrayList<Employee> getEmployeesInTraining(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).inTraining(task).isEmpty())) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   
   public ArrayList<Employee> getEmployeesUntained(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).unTrained(task).isEmpty())) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   
   public ArrayList<Employee> getList()
   {
      return list;
   }
}
