package model;

public class FreeDays
{
   private MyDate startDate;
   private MyDate endDate;
   private String type;

   public FreeDays(MyDate start,MyDate end,String type) {
      if(end.isBefore(start)){
      this.startDate=start;
      this.endDate=end;
      this.type=".,--!";
      }
      else {
      this.startDate=start;
      this.endDate=end;
      this.type=type;
      }
  }

   public MyDate getStartDate()
   {
      return startDate;
   }

   public void setStartDate(MyDate startDate)
   {
      this.startDate = startDate;
   }

   public MyDate getEndDate()
   {
      return endDate;
   }

   public void setEndDate(MyDate endDate)
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
   
   public boolean isFreeDate(MyDate date) {
      if(startDate.equals(endDate)){
         if(date.equals(startDate))
            return true;
      }else
         if(startDate.isBefore(date)&&date.isBefore(endDate))
            return true;
      return false;
   }
   
   public boolean isStartDate(MyDate date) {
      return date.equals(startDate);
   }
   
   public boolean isEndDate(MyDate date) {
      return date.equals(endDate);
   }
   
   
   
   
   
}
