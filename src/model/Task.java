package model;

public class Task
{
   private String name;
   private int numberOfPeople;
   private EmployeeList employees;

   public Task(String name, int numberOfPeople, int hoursPerDay)
   {
      this.name = name;
      this.numberOfPeople = numberOfPeople;
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

   public void setNumberOfPeople(int numberOfPeople)
   {
      this.numberOfPeople = numberOfPeople;
   }

   public int getNumberOfPeople()
   {
      return numberOfPeople;
   }

}
