package model;

public class ModelManager implements Model
{
   public ModelManager()
   {
   }

   public String validateLogin(String user, String password,Administrator[] list)
   {
      for(int i = 0 ; i < list.length; i++){
         if(!(user.equals(list[i].getUser()))&& !(password.equals(list[i].getPassword()))) {
            return "Incorrect passowrd or username";
         }
      }
      return null;
   }
   
   
}
