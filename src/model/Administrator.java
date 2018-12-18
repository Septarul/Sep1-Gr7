package model;
/**
 * A class that representing the administrators
 * 
 * @author Radu Candea
 * @version 2.1 - 17/12/2018
 */
public class Administrator 
{
      
      private String user;
      private String password;
      /**
       * Two-argument constructor.
       * 
       * @param user
       *          the user name of the administrators
       * @param password
       *          the password for the administrators
       */
      public Administrator(String user,String password) {
         this.user=user;
         this.password=password;
      }
      /**
       * Getter method that gets the user
       * 
       * @return a String containing the user name.
       */
      public String getUser()
      {
         return user;
      }
      /**
       * Setter method that can set the user to any String
       * 
       * @param user
       *          a string containing the new user name
       */
      public void setUser(String user)
      {
         this.user = user;
      }
      /**
       * Getter method for the password
       * 
       * @return a String containing the password for the administrator
       */
      public String getPassword()
      {
         return password;
      }
      /**
       * Setter method for the password
       * 
       * @param password
       *             a String that contains the new password
       */
      public void setPassword(String password)
      {
         this.password = password;
      }
      
      
}
