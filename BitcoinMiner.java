/**
Name: Hanah Ahmed
Date: 11/1/2019 
Course/Section: IT 206.003
Assignemnt: Programming Assignment 10

Description: 

A subclass of Customer class. The class tracks the number and brand of GPUs.
**/

public class BitcoinMiner extends Customer {

   public final int MAX_GPUs = 8;   // maximum number of GPUs
   public final double VM_monthlyRate = 20;  // flat VM monthly rate 
   public final double GPUs_cost = 10; // standard GPUs cost 
   public final double NividiaGPUs_fee = 15; // Nividia fee
   public final double discount = 0.2; // 20% discount
   private double appliedDiscount;  // fees after applied discount
   private int numberOfGPUs;  // number of GPUs needed
   private String GPUs_brand; // GPUs brand
   private int numMonths;  // number of months VM is needed
   private double totalFees;  // total amount of fees
   private static int numBitcoin;   // number of Bitcoin VMs 
   private static int totalGPUs; // total GPUs
   
   // Specific constructor 
   public BitcoinMiner (String name, String phoneNumber, String email, String discountApplied) {
      super (name, phoneNumber, email, discountApplied);  
      ++numBitcoin;
      this.numberOfGPUs = totalGPUs;
      
   }
   
   // Number of GPUs accessor  
   public int getNumberOfGPUs() {
     return this.numberOfGPUs;
   }
   
   // GPUs brand accessor 
   public String getGPUs_brand() {
      return this.GPUs_brand;
   }
   
   // Number of months accessor 
   public int getNumMonths() {
      return this.numMonths;
   }
   
   // Number of Bitcoin VMs accessor
   public static int getNumBitcoin() {
      return numBitcoin;
   }
   
   // total GPUs accessor 
   public static int getTotalGPUs() {
      return totalGPUs;
   }

   // Number of GPUs mutator 
   public void setNumberOfGPUs(int numberOfGPUs) {
      if (numberOfGPUs < 0 || numberOfGPUs > MAX_GPUs) {
         throw new IllegalArgumentException("Number of GPUs must be greater than 0 and less than 8.");
         }
         
         this.numberOfGPUs = numberOfGPUs;
   }
   
   // GPUs brand mutator
   public void setGPUs_brand(String GPUs_brand) {
      if (GPUs_brand == null || GPUs_brand.equals("")) { // || !GPUs_brand.equalsIgnoreCase("AMD") || !GPUs_brand.equalsIgnoreCase("Nvidia")) {
         throw new IllegalArgumentException("Brand of GPUs is required");
         }
         
         this.GPUs_brand = GPUs_brand;
   }
   
   // Number of months mutator 
   public void setNumMonths (int numMonths) {
      if (numMonths < 0) {
         throw new IllegalArgumentException("Number of months cannot be less than 0.");
         }
   }
   
   // (overridden) Special pupose method, calculates total memory
   public double totalMemory() {
      return 0;
   }
   
   // (overridden) Special purpose method, calculates total disk space
   public int totalSpace() {
      return 0;
   }
   
   // (overridden) Special purpose method, calculates total fees
   public double calculateFees() {
      if (getGPUs_brand().equalsIgnoreCase("Nvidia")) {
         totalFees = (NividiaGPUs_fee * getNumMonths()) + VM_monthlyRate;
         }
         else {
            totalFees = (GPUs_cost * getNumMonths()) + VM_monthlyRate;
            }
      return totalFees;
   }
   
   // (overridden) Special purpose method, applies discount (if applicable)
   public double applyDiscount() {
      if (super.getDiscountApplied().equalsIgnoreCase("Yes")) {
          appliedDiscount = totalFees * discount;
          totalFees = totalFees - appliedDiscount;
          }
          return totalFees;
    }
   
   public String toString() {
      return super.toString() + "\nNumber of GPUs: " + getNumberOfGPUs() + "\nGPUs Brand: " + getGPUs_brand();
   }
      
}