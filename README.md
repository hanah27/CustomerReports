# CustomerReports
This program supports a cloud computing company that hosts virtual machines for customers, tracks their cloud customers, and computes the customer bills. The program can support up to a maximum of 1000 customers.

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
