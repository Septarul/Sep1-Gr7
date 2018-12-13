package model;

import java.util.ArrayList;

public interface FileManagerInterface
{
   public abstract TaskList loadTaskListFromFile(String filename) throws Exception;
   public EmployeeList loadEmployeeListFromFile(String filename , TaskList list) throws Exception;
   public abstract void saveAllToFile(WeekSchedule plan, String filename) throws Exception;

   
}
