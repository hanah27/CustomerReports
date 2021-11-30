/**
Name: Hanah Ahmed
Date: 11/1/2019 
Course/Section: IT 206.003


Description: 

The class tracks the customer ID, customer’s name, phone number, email address, and if the customer has a corporate discount. 
**/

public abstract class Customer {

   public final double flatMonthlyRate = 20;   // flat monthly rate of $20 for each VM   
   public static final String ID_prefix = "usr";   // ID prefix, included in each customer ID
   private int ID_number;  // customer's ID number
   private String name;    // customer's name
   private String phoneNumber;   // customer's phone number
   private String email;   // customer's email
   private String discountApplied;  // whether or not discount is applied
   private static int numCustomers; // number of Customer objects created
   private static int lastNumberAssigned = 1000;   // last ID number assigned 
   
   // Specific constructor
   public Customer (String name, String phoneNumber, String email, String discountApplied) {

      if (name == null || name.equals("")) {
         throw new IllegalArgumentException("Customer's name must be provided.");
      }
      if (phoneNumber == null || phoneNumber.equals("") || phoneNumber.charAt(0) != '(' || phoneNumber.charAt(4) != ')') { // || phoneNumber.length() != 13 || phoneNumber.charAt(9) != '-') { //|| phoneNumber.charAt(5) != ' ' || phoneNumber.charAt(9) != '-' || phoneNumber.length() != 13) {
         throw new IllegalArgumentException("Invalid entry of phone number. Customer's phone number must be entered in the following format: (xxx) xxx-xxxx.");
      }
      if (email == null || email.equals("") | !email.contains("@") || !email.contains(".")) {
         throw new IllegalArgumentException("Invalid entry of email.");
      }
      if (discountApplied == null || discountApplied.equals("")) {
         throw new IllegalArgumentException("It must be indicated whether or not the customer recieves a discount.");
      }
      
      this.ID_number = lastNumberAssigned++;
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.discountApplied = discountApplied;
      ++numCustomers;
   }
      
   // ID number accessor
   public int getID_number() {
      return this.ID_number;
   }
   
   // ID number (with prefix) accessor
   public String getCustomerID() {
      return ID_prefix + getID_number();
   }
   
   // Customer name accessor
   public String getName() {
      return this.name;
   }
   
   // Customer phone number accessor 
   public String getPhoneNumber() {
      return this.phoneNumber;
   }
   
   // Customer email accessor 
   public String getEmail() {
      return this.email;
   }
   
   // Discount applied accessor 
   public String getDiscountApplied() {
      return this.discountApplied;
   }
   
   // Number of Customer objects created accessor 
   public static int getNumCustomers() {
      return numCustomers;
   }
   
   // Customer name mutator    
   public void setName (String name) {
      if (name == null || name.equals("")) {
         throw new IllegalArgumentException("Customer's name cannot be set to a null value.");
      }
   }
   
   // Customer phone number mutator 
   public void setPhoneNumber (String phoneNumber) {
      if (phoneNumber == null || phoneNumber.equals("") || phoneNumber.charAt(0) != '(' || phoneNumber.charAt(4) != ')') { // || phoneNumber.length() != 13 || phoneNumber.charAt(9) != '-') || phoneNumber.charAt(9) != '-' || phoneNumber.length() != 13) {
         throw new IllegalArgumentException("Customer's phone number cannot be set in an invaid format.");
      }  
   }
   
   // Customer email mutator 
   public void setEmail (String email) {
      if (email == null || email.equals("")) {
         throw new IllegalArgumentException("Customer's email cannot be set to a null value.");
      }
   }
   
   // Discount applied mutator
   public void setDiscountApplied (String discountApplied) {
      if (discountApplied == null || discountApplied.equals("")) {
         throw new IllegalArgumentException("Whether or not a discount is applied must be indicated.");
      }
   }
   
   // Abstract methods
   public abstract double totalMemory();
   public abstract int totalSpace();
   public abstract double calculateFees();
   public abstract double applyDiscount();
   
   // Special purpose equals() method
   public boolean equals(Object otherObject) {
      if (otherObject == null) {
         return false; 
         }
      if (getClass() != otherObject.getClass()) {
         return false;
         }
   
      Customer other = (Customer)otherObject;
         return this.getCustomerID().equals(other.getCustomerID()) && this.getName().equals(other.getName()) && this.getPhoneNumber().equals(other.getPhoneNumber()) && this.getEmail().equals(other.getEmail()) && this.getDiscountApplied().equals(other.getDiscountApplied());
         }
   
   public String toString() {
      return "Customer ID: " + getCustomerID() + "\nName: " + getName() + "\nPhone Number: " + getPhoneNumber() + "\nEmail " + getEmail() + "\nDiscount Applied? " + getDiscountApplied();
   }
}
