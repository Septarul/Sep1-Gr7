package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * A class representing the interface for the file manager.
 * @author Radu Candea
 * @version 1.3 - 16/12/2018
 */
public interface FileManagerInterface
{
   public abstract TaskList loadTaskListFromFile(String filename) throws Exception;
   public abstract EmployeeList loadEmployeeListFromFile(String filename , TaskList list) throws Exception;
   public abstract WeekSchedule loadWeekFromFile(String filename,EmployeeList list1 ) throws Exception;
   public abstract void saveTasksToFile(TaskList list, String filename) throws Exception;
   public ArrayList<Administrator> loadAdmins(String filename) throws Exception;
   public void saveAdmins(String filename, ArrayList<Administrator> list) throws Exception;
   public void saveWeekToFile(String filename,WeekSchedule list3) throws FileNotFoundException;
   public void saveEmployeesToFile(EmployeeList list1, String filename) throws FileNotFoundException;
}
