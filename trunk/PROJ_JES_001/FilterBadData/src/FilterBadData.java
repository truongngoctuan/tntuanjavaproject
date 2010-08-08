import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;


public class FilterBadData {
	private ExcelFile m_FileIn; 
	private ExcelFile m_FileOut;
	private FunctionManager m_ListFunction; 
	private DataTable m_DBAllCell; 
	
	public void RunApplication() throws IOException
	{
		CreateDataTableAndData();
	}
	private void CreateDataTableAndData() throws IOException
	{
		InputStream inp = new FileInputStream("LDH.xls");
		Workbook wb = new HSSFWorkbook(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    Row row = sheet.getRow(2);
	    Cell cell = row.getCell(3);
	    if (cell == null)
	        cell = row.createCell(3);
	    cell.setCellType(Cell.CELL_TYPE_STRING);
	    cell.setCellValue("TNT");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("LDH.xls");
	    wb.write(fileOut);
	    fileOut.close();

	}
	private void RunFilter()
	{
		
	}
	private void WriteDataToFile()
	{
		
	}
	public void SetFileIn(ExcelFile FileIn)
	{
		
	}
	public void SetFileOut(ExcelFile FileOut)
	{
		
	}
	public void SetListFunction(Function[] arrFunction)
	{
		
	}
	public ExcelFile GetFileIn()
	{
		return new ExcelFile("", "", 0, 0, 0, 0);
	}
	public ExcelFile GetFileOut()
	{
		return new ExcelFile("", "", 0, 0, 0, 0);
	}
	public FunctionManager GetListFunction()
	{
		return new FunctionManager(null);
	}
}
