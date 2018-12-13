package model;

public class FreeDays
{
   private Date startDate;
   private Date endDate;
   private String type;

   public FreeDays(Date start,Date end,String type) {
      this.startDate=start;
      this.endDate=end;
      this.type=type;
  }
   
   public FreeDays() {
      this.startDate=null;
      this.endDate=null;
      this.type=null;
  }
   
   public Date getStartDate()
   {
      return startDate;
   }

   public void setStartDate(Date startDate)
   {
      this.startDate = startDate;
   }

   public Date getEndDate()
   {
      return endDate;
   }

   public void setEndDate(Date endDate)
   {
      this.endDate = endDate;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }
   
   public boolean isFreeDate(Date date) {
      if(startDate.equals(endDate)){
         if(date.equals(startDate))
            return true;
      }else
         if(startDate.isBefore(date)&&date.isBefore(endDate))
            return true;
      return false;
   }
   
   public boolean isStartDate(Date date) {
      return date.equals(startDate);
   }
   
   public boolean isEndDate(Date date) {
      return date.equals(endDate);
   }
}
