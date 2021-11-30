/**
Name: Hanah Ahmed
Date: 11/1/2019 
Course/Section: IT 206.003
Assignemnt: Programming Assignment 10

Description: 

A subclass of Customer class. The class tracks the customer’s selection between either block storage or object storage. Also tracks the 
type of storage media of SSD or magnetic storage.
**/


public class FileServer extends Customer {

   public final int MAX_storageAmount = 1024;   // maximum amount of storage 
   public final double VM_monthlyRate = 20;  // flat VM monthly rate 
   public final int SSD_storage = 20;  // standard SSD storage 
   public final double SSD_storagCost = 5;   // SSD storage cost
   public final double magneticStorageCost = 2; // magnetic storage cost
   public final double discount = 0.2; // 20% discount
   private int totalSpace; // total disk space
   private double appliedDiscount; // fees after applied discount
   private int terabytes; // number of terabytes 
   private String storageType;   // storage type 
   private String storageMediaType; // storage media type
   private int numMonths;  // number of months VM is needed
   private double totalFees;  // total amount of fees
   
   // Specific constructor 
   public FileServer (String name, String phoneNumber, String email, String discountApplied) {
      super (name, phoneNumber, email, discountApplied);  
   }
   
   // Terabytes accessor     
   public int getTerabytes() {
      return this.terabytes;
   }
   
   // Storage type accessor 
   public String getStorageType() {
      return this.storageType;
   }

   // Storage media type accessor 
   public String getStorageMediaType() {
      return this.storageMediaType;
   }
   
   // Number of months accessor 
   public int getNumMonths() {
      return this.numMonths;
   }
   
   // Terabytes mutator 
   public void setTerabytes(int terabytes) {
     if (terabytes < 0 || terabytes > MAX_storageAmount) {
         throw new IllegalArgumentException("The number of terabytes must be greater than 0 and less than 1024.");
         }
         
         this.terabytes = terabytes;
   }
   
   // Storage type mutator
   public void setStorageType(String storageType) {
      if (storageType == null || storageType.equals("")) { // || !storageType.equalsIgnoreCase("Block") || !storageType.equalsIgnoreCase("Object")) {
         throw new IllegalArgumentException("Storage type selection is required.");
         } 
         
         this.storageType = storageType;  
   }
   
   // Storage media type mutator
   public void setStorageMediaType(String storageMediaType) {
      if (storageMediaType == null || storageMediaType.equals("")) { //|| !storageMediaType.equalsIgnoreCase("SDD") || !storageMediaType.equalsIgnoreCase("Magnetic")) {
         throw new IllegalArgumentException("Storage media type selection is required.");
         }
         
         this.storageMediaType = storageMediaType;
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
      if (getStorageMediaType().equalsIgnoreCase("SSD")) {
         totalSpace = getTerabytes() + SSD_storage;
         }
      return totalSpace;
   }
   
   // (overridden) Special purpose method, calculates total fees
   public double calculateFees() {
      if (getStorageMediaType().equalsIgnoreCase("SSD")) {
         totalFees = ((getTerabytes() * SSD_storagCost) * getNumMonths()) + VM_monthlyRate;
         } 
      if (getStorageMediaType().equalsIgnoreCase("Magnetic")) {
            totalFees = ((getTerabytes() * magneticStorageCost) * getNumMonths()) + VM_monthlyRate;
            }
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
      return super.toString() + "\nTerabytes: " + getTerabytes() + "\nStorage Type : " + getStorageType() + "\nStorage Media Type: " + getStorageMediaType();
   }
}