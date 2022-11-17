package com.java.haniel;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;


public class WriteCSVFile{
        
        static void writer() throws Exception {
                final String[] header = new String[] { "Customer Name", "Account Number", "Account Balance"};
                
        ICsvMapWriter mapWriter = null;
        try {
                mapWriter = new CsvMapWriter(new FileWriter("./BankingDetails.csv"),CsvPreference.STANDARD_PREFERENCE);
                
                final CellProcessor[] processors = getProcessors();
                
                mapWriter.writeHeader(header);

                // Iterator iterator = ;
                for (Customer customer: Bank.myCustomer.values()) {         
                        // System.out.println(Bank.myCustomer);
                        // Map.Entry entry = (java.util.Map.Entry) iterator.next();
                        // Customer customer = (Customer) entry.getValue();
                        System.out.println(customer); 
                        Map<String,Object> newMap = new HashMap<>();
                        newMap.put(header[0], customer.getName());
                        newMap.put(header[1], customer.getAccountNumber());
                        newMap.put(header[2], customer.getAccountBalance());
                        mapWriter.write(newMap, header, processors);
                }
        }
        finally {
                if( mapWriter != null ) {
                        mapWriter.close();
                }
        }
}

private static CellProcessor[] getProcessors()
	{
		final CellProcessor[] processors = new CellProcessor[] {
				new NotNull(), // Customer Name
				new NotNull(), // Account Number
				new NotNull( ), // Account Balance
		};
		return processors;
	}
}