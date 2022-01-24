package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String Getdata(String path,String sheet,int r,int c) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		String v="";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
			wb.close();
		}
		catch(Exception e) {
			
		}
		return v;
		

		
	
}}
