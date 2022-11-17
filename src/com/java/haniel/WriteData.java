// package com.java.haniel;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Iterator;
// import java.util.Map;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.util.Map.Entry;

// public class WriteData {

//     public static void FileWriter() throws IOException {
//         try {
//             File file = new File("./BankingDetails.csv");
//             FileWriter fw = new FileWriter(file);
//             BufferedWriter bw = new BufferedWriter(fw);
//             bw.write("Customer Name,Account Number,Account Balance");
//             bw.newLine();
//             Iterator iterator = Bank.myCustomer.entrySet().iterator();      //Total Entries KEYS
//             while (iterator.hasNext()) {                                    // next Key
//                 Map.Entry customer = (Entry) iterator.next();
//                 int i = 0;  
//                 bw.write(customer.getValue().toString().strip().toLowerCase());     //Corresponding data from KEYS and values by comma separated
//                 bw.newLine();
//                 i++;
//             }
//             bw.close();
//             fw.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
