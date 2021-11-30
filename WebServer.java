/**
Name: Hanah Ahmed
Date: 11/1/2019 
Course/Section: IT 206.003
Assignemnt: Programming Assignment 10

Description: 

A subclass of Customer class. The class tracks the additional amount of memory a customer wants at a monthly rate of $10 per 8 GB increments.
**/


public class WebServer extends Customer {

   public final int MAX_additionalMemory = 120; // maximum additional memory 
   public final double VM_monthlyRate = 20;  // flat VM monthly rate 
   public final double monthlyRate = 10;  // The monthly rate of $10 per 8 GB increments
   public final double GB_memory = 8;  // standard GB memory
   public final double discount = 0.2; // 20% discount 
   
   private double appliedDiscount; // fees after applied discount
   private int numMonths;  // number of months VM is needed
   private int additionalMemory; // additional GB of memory 
   private double totalFees;  // total amount of fees

   // Specific constructor 
   public WebServer (String name, String phoneNumber, String email, String discountApplied) {
      super (name, phoneNumber, email, discountApplied);  
   }
   
   // Additional memory accessor 
   public int getAdditionalMemory() {
      return this.additionalMemory;
   }
   
   // Number of months accessor 
   public double getNumMonths() {
      return this.numMonths;
   }
   
   // Additiional memory mutator 
   public void setAdditionalMemory(int additionalMemory) {
       if (additionalMemory < 0 || additionalMemory > MAX_additionalMemory) {
         throw new IllegalArgumentException("Additional GB of memory must be greater than 0 GB and less than 120 GB.");
         }
         
         this.additionalMemory = additionalMemory; 
   }
   
   // Number of months mutator 
   public void setNumMonths (double numMonths) {
      if (numMonths < 0) {
         throw new IllegalArgumentException("Number of months cannot be less than 0.");
         }
   }
   
   // (overridden) Special pupose method, calculates total memory
   public double totalMemory() {
      double totalMemory = GB_memory + getAdditionalMemory();
      return totalMemory;
   }
   
   // (overridden) Special purpose method, calculates total disk space
   public int totalSpace() {
      return 0;
   }
   
   // (overridden) Special purpose method, calculates total fees      
   public double calculateFees() {
      totalFees = (getNumMonths() * monthlyRate) * GB_memory + VM_monthlyRate;
      return totalFees;
   }
   
   // (overridden) Special purpose method, applies discount (if applicable)
   public double applyDiscount() {
      if (super.getDiscountApplied().equalsIgnoreCase("Yes")) {
          appliedDiscount = (totalFees * discount);
          totalFees = (totalFees - appliedDiscount);
          }
          return totalFees;
    }
   
   public String toString() {
      return super.toString() + "\nAdditional Memory: " + getAdditionalMemory() + "\nTotal Memory: " + totalMemory();
   }
}