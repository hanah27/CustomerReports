/**
Name: Hanah Ahmed
Date: 11/1/2019 
Course/Section: IT 206.003
Assignemnt: Programming Assignment 10

Description: 

This program supports a cloud computing company that hosts virtual machines for customers and tracks the customers of their cloud and compute the customer
bills. The program can support up to a maximum of 1000 customers. 

A customer is given a 7-character application generated customer ID in the format of “usr” plus a 4-digit number, where the customer ID numbers 
start at “usr1000”. Additionally, the program tracks the customer’s name, phone number, email address, and if the customer has a corporate discount. If 
the customer has a corporate discount, they receive 20% of their total bill.

Each customer must select one single VM and they must customize thair VM based on their needs. The customer must pick from the following choices:
  
   - Web Server : Customer must choose the additional amount of memory they want at a monthly rate of $10 per 8 GB increments. They additionly choose 120 GB 
                     of memory.
                     
   - File Server: Customer must select between either block storage or object storage. They must also choose the type of storage media of SSD or 
                  magnetic storage. The maximum amount of storage is 1024 terabytes 
                  
   - Bitcoin Miner: Customer select the number and brand of GPUs. A VM can support up to 8 GPUs and they can either be the brand AMD or Nvidia. 
                      For Nvidia GPUs, there is a flat $15 monthly fee.

After all appropriate information is entered, the system will print the following:
   
   A report -  containing all customer details, the total amount of monthly fees incurred, and the total amount of monthly fees incurred with the 
   corporate discount, if applicable. 
   
   A customer statistics summery report - containing how many customers have VMs, total amount of all monthly fees collected, the average 
   monthly fee collected per customer, how much memory and disk space and GPUs are used, and the number of customers who are Bitcoin miners.
   
   A printable roster - a text file containing a list of all customers and the total number of customers. For each customer, two attributes are
   included: the customer’s name and their associated customer ID number.
   
The inputs will be:
   
   Customer information
      - name
      - phone #
      - email
      - is there a discount?
      
   Web Server information
      - additional Memory
      - number of months
      
   File Server information
      - # of terabytes
      - storage type
      - storage media type
      - number of months 
      
   Bitcoin Miner
      - # of GPUs
      - GPUs brand
      - number of months
      
The output will be all the customer reports.
**/

import java.io.*;
import javax.swing.JOptionPane;
public class CustomerReports {   
   public static void main (String[] args) {
   
      final int MAX_customers = 1000;  // maximum number of customers

      Customer customers[] = new Customer[MAX_customers];   // creates new customer object
      Customer oneCustomer;
      
      do {
         try {
            oneCustomer = getNewCustomer();  // adds customer to system
            getVM(oneCustomer);  // customer selects VM
            customers[Customer.getNumCustomers() - 1] = oneCustomer;
            } catch(IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "Customer could not be created." + e.getMessage());
               }
               } while (JOptionPane.showConfirmDialog(null, "Would you like to enter another customer?", "Create customer", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
               
               printCustomerDetails(customers, Customer.getNumCustomers());   // prints customer details
               printCustomerStats(customers, Customer.getNumCustomers());  // prints customer statistics 
               try {
               printRoster(customers, Customer.getNumCustomers());   // prints text file 
               }
               catch (FileNotFoundException e) {
                  JOptionPane.showMessageDialog(null, "Could not create file.");
                  }
   
   }
   
   // Add customer (Customer object)
   // Parameters: none
   // Return: Customer cus
   public static Customer getNewCustomer() {
      Customer cus;
      
      String name = JOptionPane.showInputDialog("Enter the customer's name: ");
      String phoneNumber = JOptionPane.showInputDialog("Enter " + name + "'s phone number: ");
      String email = JOptionPane.showInputDialog("Enter " + name + "'s email: ");
      String discountApplied = JOptionPane.showInputDialog("Will " + name + " recieve a corporate discount?");
      
      Object[] options = {"Web Server", "File Server", "Bitcoin Miner"};
      int VM_type = JOptionPane.showOptionDialog(null, "What type of VM do you need?", "Create VM", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      
      switch (VM_type) {
         case 0: 
            cus = new WebServer(name, phoneNumber, email, discountApplied);
            break;
            
         case 1:
            cus = new FileServer(name, phoneNumber, email, discountApplied);
            break;
            
         case 2:
            cus = new BitcoinMiner(name, phoneNumber, email, discountApplied);
            break;
            
         default: 
            cus = null;
            break;
      }
      
      return cus;

   }
   
   // Select VM
   // Paramters: Customer cus
   // Return: void 
   public static void getVM (Customer cus) {
      if (cus instanceof WebServer) {
         boolean additionalMemoSet = false;
            do {
               try {
                  ((WebServer)cus).setAdditionalMemory(Integer.parseInt(JOptionPane.showInputDialog("Enter the additional amount of memory needed at a monthly rate of $10 per 8 GB increments:")));
                  additionalMemoSet = true;
                  }
                  catch (IllegalArgumentException e) {
                     JOptionPane.showMessageDialog(null, "Invalid entry of additional GB.");
                     }
                     } while (!additionalMemoSet);
                     
        boolean numMonthsSet = false;
         do {
            try {
               ((WebServer)cus).setNumMonths(Double.parseDouble(JOptionPane.showInputDialog("Enter the number of months you need to use the Web Server VM: "))); 
               numMonthsSet = true;
               }
               catch (IllegalArgumentException e) {
                     JOptionPane.showMessageDialog(null, "Invalid entry of months.");
                     }
                     } while (!numMonthsSet);
     }
     
     if (cus instanceof FileServer) {
      boolean terabytesSet = false;
         do {
            try {
               ((FileServer)cus).setTerabytes(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of additional terabytes needed:")));
               terabytesSet = true;
               }
               catch (IllegalArgumentException e) {
                  JOptionPane.showMessageDialog(null, "Invalid entry of additional terabytes.");
                  }
                  } while (!terabytesSet);
     
      boolean storageTypeSet = false;
         do {
            try {
               ((FileServer)cus).setStorageType(JOptionPane.showInputDialog("Do you need block storage or object storage?"));
               storageTypeSet = true;
               }
               catch (IllegalArgumentException e) {
                  JOptionPane.showMessageDialog(null, "Invalid entry of storage type.");
                  }
                  } while (!storageTypeSet);
                  
      boolean storageMediaTypeSet = false;
         do { 
            try {
               ((FileServer)cus).setStorageMediaType(JOptionPane.showInputDialog("Do you need SSD storage or magnetic storage?"));
               storageMediaTypeSet = true;
               }
               catch (IllegalArgumentException e) {
                  JOptionPane.showMessageDialog(null, "Invalid entry of storage media type.");
                  }
                  } while (!storageMediaTypeSet);
                  
      boolean numMonthsSet = false;
         do {
            try {
               ((FileServer)cus).setNumMonths(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of months you need to use the File Server VM: "))); 
               numMonthsSet = true;
               }
               catch (IllegalArgumentException e) {
                     JOptionPane.showMessageDialog(null, "Invalid entry of months.");
                     }
                     } while (!numMonthsSet);        
    }
    
    if (cus instanceof BitcoinMiner) {
      boolean numOfGPUSet = false;
      do { 
         try {
            ((BitcoinMiner)cus).setNumberOfGPUs(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of GPUs:")));
            numOfGPUSet = true;
            }
            catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "Invalid entry of number of GPUs.");
               }
               } while (!numOfGPUSet);
               
      boolean GPUbrandSet = false;
      do {
         try {
            ((BitcoinMiner)cus).setGPUs_brand(JOptionPane.showInputDialog("Enter the type of brand of GPUs: AMD or Nvidia?"));
            GPUbrandSet = true;
            }
            catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, "Invalid entry of brand of GPUs.");
               }
               } while (!GPUbrandSet);
               
      boolean numMonthsSet = false;
         do {
            try {
               ((BitcoinMiner)cus).setNumMonths(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of months you need to use the Bitcoin Miner VM: "))); 
               numMonthsSet = true;
               }
               catch (IllegalArgumentException e) {
                     JOptionPane.showMessageDialog(null, "Invalid entry of months.");
                     }
                     } while (!numMonthsSet);  
    }
   }
   
   // Print customer details
   // Parameters: Customer[] cus, int numCustomers
   // Return: void 
   public static void printCustomerDetails(Customer[] cus, int numCustomers) {
       if (numCustomers > 0) {
         String details = "";
         
         double totalFees = 0;
         double discountFees = 0;
         for (int x = 0; x < numCustomers; x++) {
            totalFees += cus[x].calculateFees();
            discountFees += cus[x].applyDiscount();
            details += cus[x].getClass().getName() + "\n" + cus[x].toString() + "\n\n"; 
         }
         
         details += "Total Fees (without discount): " + String.format("$%.2f", totalFees) + "\nTotal Fees (with discount): " + String.format("$%.2f", discountFees);
            
         JOptionPane.showMessageDialog(null, details);
          
         }
         else {
            JOptionPane.showMessageDialog(null, "There are no customers!");
            }

   }
   
   // Print customer statitics 
   // Parameters: Customer[] cus, int numCustomers
   // Return: void 
   public static void printCustomerStats(Customer[] cus, int numCustomers) {
      if (numCustomers > 0) {
         String stats = "";
         
         double totalFees = 0;
         int totalMem = 0;
         int diskSpace = 0;
         for (int x = 0; x < numCustomers; x++) {
            totalFees += cus[x].calculateFees();
            totalMem += cus[x].totalMemory();
            diskSpace += cus[x].totalSpace();
            }
         double averageMonthlyFee = totalFees  / numCustomers;
         
         
         stats += "Number of customers who have VMs: " + numCustomers + "\nTotal fees collected: " + String.format("$%.2f", totalFees) + 
            "\nAverage monthly fee collected per customer: " + String.format("$%.2f", averageMonthlyFee) + "\nMemory Collected (GB): " + totalMem + "\n Total GPUs: " + BitcoinMiner.getTotalGPUs() + "\nDisk Space Collected (TB): " + diskSpace + "\nCustomers who are Bitcoin Miners: " + BitcoinMiner.getNumBitcoin();
         
         JOptionPane.showMessageDialog(null, stats);
         }
         else {
            JOptionPane.showMessageDialog(null, "There are no customers!");
            }
   }
   
   // Print roster
   // Parameters: Customer[] cus, int numCustomers
   // Return: void
   public static void printRoster(Customer[] cus, int numCustomers) throws FileNotFoundException {
      PrintWriter out = new PrintWriter(new FileOutputStream(new File("customer_roster.txt")));
      
      out.println("Total Customers: " + numCustomers + "\n");
      for (int x = 0; x < numCustomers; x++) {
         out.println("Name: " + cus[x].getName());
         out.println("ID Number: " + cus[x].getCustomerID() + "\n");
         }
         out.close();
   }
}