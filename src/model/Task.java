package model;

public class Task
{
   private String name;
   private int recomendedSize;
   private EmployeeList employees;
   

   public Task(String name, int recomendedSize, int hoursPerDay)
   {
      this.name = name;
      this.recomendedSize = recomendedSize;
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

   public void setNumberOfRecomendedPeople(int recomendedSize)
   {
      this.recomendedSize = recomendedSize;
   }

   public int getNumberOfRecomendedPeople()
   {
      return recomendedSize;
   }
   public void addEmmployees(Employee employee)
   {
      employees.addEmployee(employee);
   }
   public void removeEmmployee(Name employee)
   {
      employees.removeEmployee(employee);
   }
}
