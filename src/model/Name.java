package model;

public class Name
{
   private String firstName;
   private String lastName;

   public Name(String firstName, String lastName)
   {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFullName()
   {
      return firstName + " " + lastName;
   }

   public String getFormalName()
   {
      return lastName + ", " + firstName;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Name))
      {
         return false;
      }
      Name other = (Name) obj;
      return firstName.equals(other.firstName)
            && lastName.equals(other.lastName);
   }

   public String toString()
   {
      return getFullName();
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

}
