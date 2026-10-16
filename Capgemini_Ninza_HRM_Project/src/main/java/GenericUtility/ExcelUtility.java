package GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

    public String getData(String sheetName, int rowNum, int cellNum) throws Exception {

        FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Downloads\\TestDataOfHRM.xlsx");

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheet(sheetName);

        Row row = sheet.getRow(rowNum);
 
        String data = row.getCell(cellNum).toString();

        wb.close();
        fis.close();

        return data;
    }

}