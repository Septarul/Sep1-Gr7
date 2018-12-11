package model;

public interface FileManagerInterface
{
   public abstract WeekSchedule loadFromFile(String filename) throws Exception;
   public abstract void saveAllToFile(WeekSchedule plan, String filename) throws Exception;
   
}
