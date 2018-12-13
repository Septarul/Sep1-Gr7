package model;

public class Task
{
   private String name;
   private EmployeeList employees;
   

   public Task(String name)
   {
      this.name = name;
      this.employees = null;
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
   
   public void addEmmployees(Employee employee)
   {
      employees.addEmployee(employee);
   }
   
   public void removeEmmployee(Name employee)
   {
      employees.removeEmployee(employee);
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Task))
      {
         return false;
      }
      Task other = (Task)obj;
      return name.equals(other.name);
      
   }
}
