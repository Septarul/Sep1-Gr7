package model;

public class Name
{
private String firstName;
private String lastName;

public Name(String firstName, String lastName)
{
   this.firstName=firstName;
   this.lastName=lastName;
}
public String getFullName()
{
   return firstName + " " + lastName;
}
public String getFormalName()
{
   return lastName+", " +firstName;
}
public String toString()
{
   return getFullName();
}
}
