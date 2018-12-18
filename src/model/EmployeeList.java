package model;
import java.util.ArrayList;
/**
 * A class that represents the list of employees that is assigned to tasks
 * @author Adrian Ionut Patrascu
 * @version 4.1 - 16/12/2018
 */
public class EmployeeList
{
   private String name;
   private ArrayList<Employee> list;
/**
 * no argument constructor that initialises the array list and sets the name to null
 */
   public EmployeeList()
   {
      this.list = new ArrayList<>();
      this.name = null;
   }
/**
 * one-argument constructor that initialises all the instance variables
 * @param name
 *          the name of the list
 */
   public EmployeeList(String name)
   {
      this.list = new ArrayList<>();
      this.name = name;
   }
/**
 * getter method for the name
 * @return a string  representing the name
 */
   public String getName()
   {
      return name;
   }
/**
 * a method that calculates the number of employees in the list
 * @return the size of the list
 */
   public int size()
   {
      return list.size();
   }
/**
 * A method that adds an employee to the list
 * @param employee
 *          the employee that will be added
 */
   public void addEmployee(Employee employee)
   {
      this.list.add(employee);
   }
/**
 * a method that removes an employee from the list with the specified name
 * @param name
 *          the name that will be searched in the list
 */
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
/**
 * a method that gets an employee from the list at a specified index
 * @param index
 *          the index of the employee
 * @return an employee
 */
   public Employee get(int index)
   {
      return list.get(index);
   }
/**
 * a method that searches in the list for an employee with the specified name
 * @param name
 *          the name that will be searched
 * @return an employee
 */
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
   /**
    * A method that searches all the employees that have a preference
    * 
    * @return an array with employees
    */
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
   /**
    * A method that gets all the employees trained in a specified task
    * @param task
    *          the task that they have to be trained in
    * @return an array list with all the corresponding employees
    */
   public ArrayList<Employee> getEmployeesTrained(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).hasTraining(task))) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   /**
    * A method that gets all the employees that are in training for a specified task
    * @param task
    *          the task at which that they are in  training
    * @return an array with all the corresponding employees
    */
   public ArrayList<Employee> getEmployeesInTraining(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).inTraining(task))) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   /**
    * A method that searches for all the untrained employees for a specified task
    * @param task
    *          the specified task
    * @return an array list with all the corresponding employees
    */
   public ArrayList<Employee> getEmployeesUntained(String task){
      ArrayList<Employee> list2=new ArrayList<>();
      for (int i = 0; i < list.size(); i++)
      {
         if(!(list.get(i).unTrained(task))) {
            list2.add(list.get(i));
      }
         }
      return list2;
   }
   /**
    * Getter method for the employee list
    * @return a list with all the employees
    */
   public ArrayList<Employee> getList()
   {
      return list;
   }
}
