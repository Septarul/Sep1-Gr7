package model;

public interface FileManagerInterface
{
   public abstract Schedule loadFromFile(String filename) throws Exception;
   public abstract void saveAllToFile(Schedule plan, String filename) throws Exception;
   
}
