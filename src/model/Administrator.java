package model;

public class Administrator extends Employee
{
      private String user;
      private String password;
      
      public Administrator(Name name,String user,String password) {
         super(name);
         this.user=user;
         this.password=password;
      }

      public String getUser()
      {
         return user;
      }

      public void setUser(String user)
      {
         this.user = user;
      }

      public String getPassword()
      {
         return password;
      }

      public void setPassword(String password)
      {
         this.password = password;
      }
      
      
}
