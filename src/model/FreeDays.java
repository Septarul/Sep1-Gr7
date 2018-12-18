package model;
/**
 * A class representing the free days for an employee
 * @author Ignas Bareikis
 * @version 5.2 - 16/12/2018
 */
public class FreeDays
{
   private Date startDate;
   private Date endDate;
   private String type;
/**
 * Three-argument constructor that initialises all the instance variables
 * @param start
 *          the start date
 * @param end
 *          the end date
 * @param type
 *          a string representing the type of the free day
 */
   public FreeDays(Date start,Date end,String type) {
      this.startDate=start;
      this.endDate=end;
      this.type=type;
  }
   /**
    * no argument constructor setting all the variables to null
    */
   public FreeDays() {
      this.startDate=null;
      this.endDate=null;
      this.type=null;
  }
   /**
    * getter method for the start date
    * @return
    */
   public Date getStartDate()
   {
      return startDate;
   }
/**
 * setter method for the start date
 * @param startDate
 *          the start date
 */
   public void setStartDate(Date startDate)
   {
      this.startDate = startDate;
   }
/**
 * getter method for the end date
 * @return the end date
 */
   public Date getEndDate()
   {
      return endDate;
   }
/**
 * setter method for the end date
 * @param endDate
 *          the end date
 */
   public void setEndDate(Date endDate)
   {
      this.endDate = endDate;
   }
/**
 * getter method for the type of the free day
 * @return a type
 */
   public String getType()
   {
      return type;
   }
/**
 * setter method for the type
 * @param type
 *          the type
 */
   public void setType(String type)
   {
      this.type = type;
   }
   /**
    * A method that checks if the specified date is valid
    * @param date
    *          the date to be checked
    * @return true/false depending on the answer
    */
   public boolean isFreeDate(Date date) {
      if(startDate.equals(endDate)){
         if(date.equals(startDate))
            return true;
      }
      else
         if(startDate.isBefore(date)&&date.isBefore(endDate))
            return true;
      return false;
   }
   /**
    * A method that checks is the date is the start date
    * @param date
    *          the date 
    * @return true/false depending on the answer
    */
   public boolean isStartDate(Date date) {
      return date.equals(startDate);
   }
   /**
    * A method that checks if the date is a end date
    * @param date
    *          the date
    * @return true/false depending on the answer
    */
   public boolean isEndDate(Date date) {
      return date.equals(endDate);
   }
}
