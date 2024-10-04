package RahulShettyAcademy.test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcasName) throws IOException {

		// TODO Auto-generated method stub

		ArrayList <String> a =new ArrayList<String>();
		// Identify the test case column by scanning the entire 1st row 
		//once column is identified then scan entire test cases column to identify purchase testcase row
		//after you grab purchase test case row pull all the data and feed it into testcases
		//File input stream argument ""
		FileInputStream file=new FileInputStream("C:\\Users\\laxma\\DataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheetCount=	workbook.getNumberOfSheets();
		for(int i=0; i<sheetCount;i++) 
		{
			String sheetName = workbook.getSheetName(i);

			if(sheetName.trim().equalsIgnoreCase("Test")) 
			{


				XSSFSheet reqSheet=workbook.getSheetAt(i);

				// Identify the test cases column by scanning the entire 1st row
				Iterator<Row> rows=reqSheet.iterator();//each row scan
				Row firstrow=rows.next();//first column pointing



				Iterator<Cell>cell=firstrow.cellIterator();//each cell scanning

				int k=0;
				int column=0;
				while (cell.hasNext())
				{
					Cell cellValue=	cell.next();

					if(cellValue.getStringCellValue().equalsIgnoreCase("Testcases")) 
					{
						column=k;

					}
					k++;
				}
				System.out.println(column);
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasName)) 

					{
						Iterator<Cell> cv=r.iterator();
						while(cv.hasNext()) 
						{
							Cell c=cv.next();
							if (c.getCellType() == Cell.CELL_TYPE_STRING) 
							{
								a.add(c.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							

						}

					}


				}
			}
		}
		return a;
	}

	

}
