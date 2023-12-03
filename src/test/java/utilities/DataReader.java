package utilities;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader 
{
	
	public static HashMap<String, String> storeValues = new HashMap<String, String>();

	public static List<HashMap<String, String>> data(String filepath, String sheetName)
	   {
				List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
				try {
					FileInputStream fs = new FileInputStream(filepath);
					XSSFWorkbook workbook = new XSSFWorkbook(fs);
					XSSFSheet sheet = workbook.getSheet(sheetName);
					Row HeaderRow = sheet.getRow(0);
					int rows= sheet.getLastRowNum();
					String trows= Integer.toString(rows);
					String Rows = null;
					
					
					for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
						{
						Row currentRow = sheet.getRow(i);
						HashMap<String, String> currentHash = new HashMap<String, String>();
						for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
							{
							Cell currentCell = currentRow.getCell(j);
							switch (currentCell.getCellType()) 
								{
									case STRING:
									currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
									break;
								}
							}
						
						
						currentHash.put(Rows,trows);
				           mydata.add(currentHash);
				          System.out.println(mydata);
				          
				        }
			          fs.close();
			        } catch (Exception e)
				      {
			            e.printStackTrace();
		               }
		           return mydata;
	  }
}



