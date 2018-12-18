package model;
/**
 * A class that defines the name into a first name and a last name
 * 
 * @author Ignas Bareikis
 * @version 1.1 - 05/12/2018
 */
public class Name
{
   
   private String firstName;
   private String lastName;
/**
 * Two-argument constructor that initialises all the instajnce variables.
 * 
 * @param firstName
 *          the first name
 * @param lastName
 *          the last name
 */
   public Name(String firstName, String lastName)
   {
      this.firstName = firstName;
      this.lastName = lastName;
   }
/**
 * A method that puts the first name and last name in a string
 * @return a string containing both names
 */
   public String getFullName()
   {
      return firstName + " " + lastName;
   }
/**
 * A method that puts the first and last name in a formal way
 * @return a string containing the last and first name
 */
   public String getFormalName()
   {
      return lastName + ", " + firstName;
   }
/**
 * equals method
 */
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
/**
 * toString that returns the full name
 */
   public String toString()
   {
      return getFullName();
   }
/**
 * getter method for the first name
 * @return the first name
 */
   public String getFirstName()
   {
      return firstName;
   }
/**
 * Setter method for the first name
 * @param firstName
 *          the first name
 */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
/**
 * getter method for the last name
 * @return the last name
 */
   public String getLastName()
   {
      return lastName;
   }
/**
 * setter method for the last name
 * @param lastName
 *          the last name
 */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

}
