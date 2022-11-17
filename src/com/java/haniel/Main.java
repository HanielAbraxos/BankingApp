package com.java.haniel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    BufferedReader bufferreader = new BufferedReader(
    new InputStreamReader(System.in));

    // private static Scanner scanner = new Scanner(System.in);
    private static Bank Bank = new Bank();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        // ReadCSVData.readDataFromCustomSeparator("./BankingDetails.csv");
        ReadCSVFile.reader();
        // CsvBeanReaderExample.reader();
        System.out.print("How many Customers do you want to Add? ");
        int n = Integer.parseInt(br.readLine());
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            System.out.println("Enter new Customer Name: ");
            String name = br.readLine();
            System.out.println("Enter Account Number: ");
            String accountNumber = br.readLine();
            System.out.println("Enter Account Balance: ");
            BigDecimal accountBalance = new BigDecimal(br.readLine());
            Customer newCustomer = Customer.createCustomer(name, accountNumber, accountBalance);
            if (Bank.addNewCustomer(newCustomer)) {
                System.out.println((i + 1) + " - New contact added:\nName : " + name + ", Account Number : "
                        + accountNumber + ", Balance is : " + accountBalance);
            } else {
                System.out.println("Cannot add, " + accountNumber + " already on file");
            }
            WriteCSVFile.writer();
        }
        int ch = 0;
        int modifychar = 0;

        do {
            printActions();
            if (sc.hasNextInt()) {
                ch = sc.nextInt();
                switch (ch) {

                    case 1:
                        Bank.printCustomer();
                        WriteCSVFile.writer();
                        break;
                    case 2:
                        Bank.queryCustomerDetails();
                        break;
                    case 3:
                        do {
                            printMiniActions();
                            if (sc.hasNextInt()){
                            modifychar = sc.nextInt();

                            switch (modifychar) {
                                case 1:
                                    Bank.addNewCustomerDetails();
                                    WriteCSVFile.writer();
                                    break;
                                case 2:
                                    Bank.updateCustomerDetails();
                                    WriteCSVFile.writer();
                                    break;
                                case 3:
                                    Bank.removeCustomerDetails();
                                    WriteCSVFile.writer();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("Please Re-Enter Digits from 1-4");
                            }
                        }else{
                            sc.next();
                        }
                        } while (modifychar != 4);
                        break;
                    case 4:
                        Bank.depositBalance();
                        WriteCSVFile.writer();
                        break;
                    case 5:
                        Bank.withdrawalBalance();
                        WriteCSVFile.writer();
                        break;
                    case 6:
                        System.out.println("See you soon...");
                        break;
                    default:
                        System.out.println("Please Re-Enter Digits from 1-6");
                }
            } else {
                sc.next();
            }

        } while (ch != 6);
        sc.close();
    }

    private static void printActions() {
        System.out.println("\n ***Banking System Application***");
        System.out.println("1 - Display all account details \n" +
                " 2 - Search by Account Name\n" +
                " 3 - Modify Customer Details \n" +
                " 4 - Deposit the amount \n" +
                " 5 - Withdraw the amount \n" +
                " 6 - Exit");
        System.out.println("Enter your choice: ");
    }

    private static void printMiniActions() {
        System.out.println("\n ***Modification***");
        System.out.println("1 - Add a New Customer \n" +
                            " 2 - Update a Customer\n" +
                            " 3 - Remove a Customer \n" +
                            " 4 - Go Back \n");
        System.out.println("Enter your choice: ");
    }

}