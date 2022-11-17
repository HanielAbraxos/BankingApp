package com.java.haniel;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

public class ReadCSVFile {

	static final String CSV_FILENAME = "./BankingDetails.csv";

	public static void reader() throws IOException
	{
		Map<String,Object> newFileMap;
		try(ICsvMapReader listReader = new CsvMapReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
		{
			final String[] headers = listReader.getHeader(true);
			final String[] names = new String[] {"Customer Name","Account Number","Account Balance"};
			// final String[] headers = new String[]{"Customer Name","Account Number","Account Balance"};
			final CellProcessor[] processors = getProcessors();
			Customer customer=null;

			while ((newFileMap = listReader.read(headers,processors)) != null) {
				for(int i=0 ; i<3 ; i++){

			//**** Array Writer  ****/

					// Object[] a = newFileMap.values().toArray();
					// String name = (String) a[0];
					// String accountNumber = (String) a[1];
					// BigDecimal accountBalance = (BigDecimal) a[2];
					// customer = Customer.createCustomer(name, accountNumber, accountBalance);

			// **** List Writer  ****/		Change Map<1,2> -> List<2> and read(processors)

					// String nameList = (String) newFileMap.get(0);
					// String accountNumberList = (String) newFileMap.get(1);
					// BigDecimal accountBalanceList = (BigDecimal) newFileMap.get(2);
					// customer = Customer.createCustomer(nameList, accountNumberList, accountBalanceList);

			//**** Map Writer  ****/

					String nameMap = (String) newFileMap.get(names[0]);
					String accountNumberMap = (String) newFileMap.get(names[1]);
					BigDecimal accountBalanceMap =  (BigDecimal) newFileMap.get(names[2]);
					customer = Customer.createCustomer(nameMap, accountNumberMap, accountBalanceMap);

				}
				// System.out.println(customer);
				Bank.myCustomer.put(customer.getAccountNumber(), customer);
			}

		}
	}

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] {
				new NotNull(), //Name 
				new NotNull(), // Account Number
				new NotNull(new ParseBigDecimal()), // Account Balance
		};
		return processors;
	}
}