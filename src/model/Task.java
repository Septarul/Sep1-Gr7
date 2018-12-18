package model;
/**
 * A class representing a task that a the employees will be assigned to do
 * 
 * @author Catalin Albert Varban
 * @version 6.3 - 17/12/2018
 */
public class Task
{
   private String name;
   private EmployeeList employees;
   
/**
 * One-argument constructor that initialises all the instance variables.
 * @param name
 *          the name of the task
 */
   public Task(String name)
   {
      this.name = name;
      this.employees = new EmployeeList();
   }
/**
 * setter method for the employee list
 * @param employees
 *          the list of employees
 */
   public void setEmployees(EmployeeList employees)
   {
      this.employees = employees;
   }
/**
 * getter method for the list of employees
 * @return a list of employees
 */
   public EmployeeList getEmployees()
   {
      return employees;
   }
/**
 * setter method for the name
 * @param name
 *          the name of the list
 */
   public void setName(String name)
   {
      this.name = name;
   }
/**
 * getter method for the name 
 * @return the name of the list
 */
   public String getName()
   {
      return name;
   }
   /**
    * A method that adds an employee to the task
    * @param employee
    *          the employee to be added to the task
    */
   public void addEmployee(Employee employee)
   {
      employees.addEmployee(employee);
   }
   /**
    * A method that removes a employee from the task
    * @param employee
    *          the name of the employee to be removed
    */
   public void removeEmmployee(Name employee)
   {
      employees.removeEmployee(employee);
   }
/**
 * An overwrite for the toStrong method that returns th name of the task
 * @return the name of the task
 */
   public String toString() {
      return name;
   }
}
