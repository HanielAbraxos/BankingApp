// package com.java.haniel;

// import java.io.FileReader;
// import java.util.List;
// import com.opencsv.*;

// public class ReadCSVData {

// 	public static void readDataFromCustomSeparator(String file)
//     {
//         try {

//             FileReader filereader = new FileReader(file);

//             CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

//             CSVReader csvReader = new CSVReaderBuilder(filereader)
//                                       .withCSVParser(parser).withSkipLines(1)
//                                       .build();
//             List<String[]> allData = csvReader.readAll();
  
//             // print Data
//             for (String[] row : allData) {
//                 for (String cell : row) {
// 					Customer customer = new Customer();
// 					String[] Test = cell.split("\\,");
// 					customer.setName(Test[0]);
// 					customer.setAccountNumber(Test[1]);
// 					// customer.setAccountBalance(Test[2]);
// 					Bank.myCustomer.put(Test[1], customer);
//                 }
//             }
//         }
//         catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
