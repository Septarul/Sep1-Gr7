package model;
<<<<<<< HEAD
import java.util.ArrayList;

public class TaskList
{
   private String name;
   private ArrayList<TaskList> list;

   public TaskList(String name)
   {
      this.list = new ArrayList<>();
      this.name = name;
   }

   public String getName()
   {
      return name;
   }

   public ArrayList<EmployeeList> getList()
   {
      return list;
   }

   public int size()
   {
      return list.size();
   }

   public void addTask(String task)
   {
      this.list.add(task);
   }

   public void removeTask(int index)
   {
      this.list.remove(index);
   }

   public Task get(int index)
   {
      return list.get(index);
   }

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
=======

public class TaskList
{
>>>>>>> 5950662e623e62f3e1f215bd3f15ea98622a5ee5

}
