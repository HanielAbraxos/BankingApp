package com.java.haniel;

import java.util.Iterator;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry; 
 
class Bank { 
    public static Map<String,Customer> myCustomer = new HashMap<>();
    BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in));
    // static Scanner sc = new Scanner(System.in);  

    boolean addNewCustomer(Customer customer) {
        if(Bank.myCustomer.get(customer.getAccountNumber()) == null){
            myCustomer.put(customer.getAccountNumber(),customer);
            return true;
        }
        return false;
    }

    private static boolean updateCustomer(Customer oldCustomer, Customer newCustomer) {
        Bank.myCustomer.remove(oldCustomer.getAccountNumber());
        Bank.myCustomer.put(newCustomer.getAccountNumber().toLowerCase(), newCustomer);
        System.out.println("All Done");
        return true;
    }

    private static boolean removeCustomer(Customer customer) {
        Bank.myCustomer.remove(customer.getAccountNumber().toLowerCase());
        System.out.println(customer.getAccountNumber() + ", was deleted.");
        return true;
    }

    public void printCustomer(){
        int i = 0;
        System.out.println("Customer List");
        Iterator iterator = Bank.myCustomer.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry customer =  (Entry) iterator.next();
            // System.out.println(customer);
            System.out.println((i+1) + " - " +
            customer.getValue().toString());                
            i++;
        }
    }

    public void addNewCustomerDetails() throws IOException {
        System.out.println("Enter new Customer Name: ");
        String name = br.readLine();
        System.out.println("Enter Account Number: ");
        String accountNumber = br.readLine();
        System.out.println("Enter Account Balance: ");
        BigDecimal accountBalance = new BigDecimal(br.readLine());
        Customer newCustomer = Customer.createCustomer(name.toLowerCase(), accountNumber, accountBalance);
        if(addNewCustomer(newCustomer)) {
            System.out.println("New Contact Added:\nName = " + name + ", Account Number : "+ accountNumber + " Balance : "+accountBalance);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    public void updateCustomerDetails() throws IOException {
        System.out.println("Enter existing Customer Account Number: ");
        String accountNumber = br.readLine();
        Customer existingCustomerRecord = Bank.myCustomer.get(accountNumber);
        if(existingCustomerRecord == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter new Customer name: ");
        String newName = br.readLine();
        System.out.print("Enter new Customer Account Number: ");
        String newNumber = br.readLine();
        System.out.print("Enter new Customer Account Balance: ");
        BigDecimal newBalance = new BigDecimal(br.readLine());
        Customer newCustomer = Customer.createCustomer(newName.toLowerCase(), newNumber, newBalance);
        if(updateCustomer(existingCustomerRecord, newCustomer)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    public void removeCustomerDetails() throws IOException {
        System.out.println("Enter existing Customer Number: ");
        String accountNumber = br.readLine();
        try{
            Customer existingCustomerRecord = Bank.myCustomer.get(accountNumber.toLowerCase());
        if(removeCustomer(existingCustomerRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }
    catch(NullPointerException e){
        System.out.println("Not Found");
    }
    }

    public void depositBalance() throws IOException{
        System.out.println("Enter existing customer Account Number: ");
        String accountNumber = br.readLine();
        System.out.println("Enter Money You want to Deposit: ");
        BigDecimal money = new BigDecimal(br.readLine());
        Customer existingCustomerRecord = Bank.myCustomer.get(accountNumber.toLowerCase());
        if (existingCustomerRecord == null) {
            System.out.println("Customer not found.");
            return;
        }
        BigDecimal newBalance = existingCustomerRecord.getAccountBalance(); 
        // int m = Integer.parseInt(money); 
        newBalance = newBalance.add(money);
        // String newBalanceString = String.valueOf(newBalance);
        Customer newCustomer = Customer.createBalance(existingCustomerRecord.getName(), accountNumber.toLowerCase(), newBalance);
        if(updateCustomer(existingCustomerRecord, newCustomer)) {
            System.out.println("Name: " + existingCustomerRecord.getName() + " with Account Number " + existingCustomerRecord.getAccountNumber() +
        "\n is having Balance : " + newBalance);
        } else {
            System.out.println("Error updating record.");
        }
    }

    public void withdrawalBalance() throws IOException{
        System.out.println("Enter existing customer Account Number: ");
        String accountNumber = br.readLine();
        System.out.println("Enter Money You want to Withdraw: ");
        BigDecimal money = new BigDecimal(br.readLine());
        Customer existingCustomerRecord = Bank.myCustomer.get(accountNumber.toLowerCase());
        if (existingCustomerRecord == null) {
            System.out.println("Customer not found.");
            return;
        }
        BigDecimal newBalance = existingCustomerRecord.getAccountBalance(); 
        // int m = Integer.parseInt(money); 
        if (newBalance.compareTo(money) >= -1) {  
            newBalance = newBalance.subtract(money);  
            System.out.println("Balance after withdrawal: " + newBalance);  
        } else {  
            System.out.println("Your Balance is less than " + money + "\tTransaction failed...!!" );  
        }  
        // String newBalanceString = String.valueOf(newBalance);
        Customer newCustomer = Customer.createBalance(existingCustomerRecord.getName(), accountNumber, newBalance);
        if(updateCustomer(existingCustomerRecord, newCustomer)) {
            System.out.println("Name: " + existingCustomerRecord.getName() + " with Account Number " + existingCustomerRecord.getAccountNumber() +
        "\n is having Balance : " + newBalance);
        } else {
            System.out.println("Error updating record.");
        }
    }

    public void queryCustomerDetails() throws IOException {
        System.out.println("Enter existing customer Account Number: ");
        String accountNumber = br.readLine();
        Customer existingCustomerRecord = Bank.myCustomer.get(accountNumber.toLowerCase());
        if (existingCustomerRecord == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Name: " + existingCustomerRecord.getName() + " with Account Number " + existingCustomerRecord.getAccountNumber() +
        "\nis having Balance " + existingCustomerRecord.getAccountBalance());
    }

    public enum myCustomer {
    }

}
