package model;

public interface FileManagerInterface
{
   public abstract TaskList loadTaskListFromFile(String filename) throws Exception;
   public abstract EmployeeList loadEmployeeListFromFile(String filename , TaskList list) throws Exception;
   public abstract void saveTasksToFile(TaskList list, String filename) throws Exception;
   public abstract WeekSchedule loadWeekFromFile(String filename,EmployeeList list1) throws Exception;
   
}
