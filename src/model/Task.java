package model;

public class Task
{
   private String name;
   private EmployeeList employees;
   

   public Task(String name)
   {
      this.name = name;
      this.employees = new EmployeeList();
   }

   public void setEmployees(EmployeeList employees)
   {
      this.employees = employees;
   }

   public EmployeeList getEmployees()
   {
      return employees;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }
   //
   public void addEmmployee(Employee employee)
   {
      employees.addEmployee(employee);
   }
   
   public void removeEmmployee(Name employee)
   {
      employees.removeEmployee(employee);
   }
     
   public String toString() {
      return name;
   }
}
