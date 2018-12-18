package model;
import java.util.ArrayList;

public class TaskList
{
   private String name;
   private ArrayList<Task> list;

   public TaskList()
   {
      this.list = new ArrayList<>();
      this.name = null;
   }
   
   public TaskList(String name)
   {
      this.list = new ArrayList<>();
      this.name = name;
   }

   public String getName()
   {
      return name;
   }

   public ArrayList<Task> getList()
   {
      return list;
   }

   public int size()
   {
      return list.size();
   }

   public void addTask(Task task)
   {
      this.list.add(task);
   }
   
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
   
   public void removeTask(String t) {
      for (int i=0; i<list.size();i++) {
         if(list.get(i).getName().equals(t))
            list.remove(i);
      }
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
}
