package model;
import java.util.ArrayList;
/**
 * A class representing a list with all the tasks 
 * 
 * @author Catalin Albert Varban
 * @version 3.5 - 17/12/2018
 */
public class TaskList
{
   private String name;
   private ArrayList<Task> list;
/**
 * No argument constructor that initialises the ArrayList and sets the name to null.
 */
   public TaskList()
   {
      this.list = new ArrayList<>();
      this.name = null;
   }
   /**
    * one-argument constructor that initialises all the instance variables.
    * @param name
    *          the name of the list that will be created
    */
   public TaskList(String name)
   {
      this.list = new ArrayList<>();
      this.name = name;
   }
/**
 * getter method for the name
 * @return the name
 */
   public String getName()
   {
      return name;
   }
/**
 * getter method for the list of tasks
 * @return the array with all the tasks
 */
   public ArrayList<Task> getList()
   {
      return list;
   }
/**
 * a method that calculates the number of elements in the array
 * @return a int with the size
 */
   public int size()
   {
      return list.size();
   }
/**
 * a method that adds a task to the array list.
 * @param task
 *          the task to be added
 */
   public void addTask(Task task)
   {
      this.list.add(task);
   }
   /**
    * A methos that gets all the tasks and transforms them in a string.
    * @return a String containing all the tasks
    */
   public String getTasks() {
      String s="";
      for(int i = 0 ; i < list.size(); i++){
         s+=list.get(i).getName();
         if(i<list.size()-1) {
            s+=", ";
         }
      }
      return s;
   }
   /**
    * a method that removes the task corresponding to the parameter in the array
    * @param t
    *        the name of the that will be removed
    */
   public void removeTask(String t) {
      for (int i=0; i<list.size();i++) {
         if(list.get(i).getName().equals(t))
            list.remove(i);
      }
   }
   /**
    * A method that gets the task at a specified index
    * @param index
    *          the index of the task to be returned
    * @return a task
    */
   public Task get(int index)
   {
      return list.get(index);
   }
/**
 * A method that searches in the array list for a task corresponding the parameter
 * @param name
 *          the name of the day
 * @return the searched day
 */
   public Task getTaskByName(String name)
   {
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getName().equals(name))
         {
            return list.get(i);
         }
      }
      return null;
   }
}
