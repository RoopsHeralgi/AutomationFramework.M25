package swagLabs.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class consists of generic methods related to Excel file
 * @author Chaitra M
 * */

public class ExcelFileUtility 
{
	/*
	 * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * */
	public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
		
	}

}
