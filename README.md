
# SalesTaxApplication
Application to calculate Sales Tax

This is the application to calculate Sales Tax

# Pre - requisites
Maven Latest version
Java Runtime Environment (JRE) v1.8.0+ - Java SE Development Kit (JDK) v1.8.0+


# Steps to run the application

Using Main method
1. Checkout application from repository https://github.com/mahantesh21/SalesTaxApplication
2. Run as Java application using Main method in SalesTaxCalculator/src/main/java/uk/co/salestax/application/main/SalesApp.java

Using Command prompt and mvn
1. Checkout application from repository https://github.com/mahantesh21/SalesTaxApplication
2. Open command prompt; cd to ../SalesTaxCalculator 
3. mvn clean package exec:java@salestaxapp


# Problem description

Sales Taxes 
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions. 
When I purchase items, I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax. 
Write an application that prints out the receipt details for these shopping baskets.

INPUT: 
Input 1: 
1 book at 12.49 
1 music CD at 14.99 
1 chocolate bar at 0.85 

Input 2: 
1 imported box of chocolates at 10.00 
1 imported bottle of perfume at 47.50 

Input 3: 
1 imported bottle of perfume at 27.99 
1 bottle of perfume at 18.99 
1 packet of headache pills at 9.75 
1 box of imported chocolates at 11.25 

OUTPUT 
Output 1: 
1 book: 12.49 
1 music CD: 16.49 
1 chocolate bar: 0.85 
Sales Taxes: 1.50 Total: 29.83

Output 2: 
1 imported box of chocolates: 10.50 
1 imported bottle of perfume: 54.65 
Sales Taxes: 7.65 Total: 65.15

Output 3: 
1 imported bottle of perfume: 32.19 
1 bottle of perfume: 20.89 
1 packet of headache pills: 9.75 
1 imported box of chocolates: 11.85 
Sales Taxes: 6.70 Total: 74.68



# Sample Output

cd /SalesTaxCalculator
mvn clean package exec:java@salestaxapp

============
Hello, This is the application to calculate Sales Tax

 ============
 Summary for Order SA01
 ============
 1 book : 12.49
 1 music CD : 16.49
 1 chocolate bar : 0.85
 
 Sales Taxes: 1.5 
 Total: 29.83
 

 ============
 Summary for Order SA02
 ============
 1 imported box of chocolate : 10.5
 1 imported bottle of perfume : 54.65
 
 Sales Taxes: 7.65 
 Total: 65.15
 

 =================================================
 Summary for Order SA03
 =================================================
 1 imported bottle of perfume : 32.19
 1 bottle of perfume : 20.89
 1 packet of headache pills : 9.75
 1 box of imported chocolates : 11.85
 
 Sales Taxes: 6.7 
 Total: 74.68


# Please note

1.SalesApptest.java - Written Basic Junit tests due to lack of time, we can expand this to have more cases similarly
2. Purposefully did not complicate the Item object to keep design simple, we can have Basic Parent Item class and then expand to child class variants as Local or Imported Item, but this is overkill in given case
3. Purchase order class is just a placeholder to print output, Ideally One shopping Cart should have reciept associated, added PurchaseOrder.java class to hold all scenario in one go and print desired output
4. Custom Exception created, this can be expanded for any custom behaviour for application, this can be useful in webapps


# Thanks for the exercise, it was interesting !!
# Yours
# Mahantayya Hiremath
#
