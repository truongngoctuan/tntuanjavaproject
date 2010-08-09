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
		InputStream inp = new FileInputStream("C:\\LDH.xls");
		Workbook wb = new HSSFWorkbook(inp);
	    Sheet sheetOld = wb.getSheetAt(0);
	    Sheet sheetNew = wb.createSheet("aaa");
	    
	    int nRow = sheetOld.getLastRowNum();
	    for (int iCountnRow = 0; iCountnRow <= nRow; iCountnRow++)
	    {
	    	Row rowOld = sheetOld.getRow(iCountnRow);
	    	Row rowNew = sheetNew.createRow(iCountnRow);
			
	    	int nCell = rowOld.getLastCellNum();
	    	for (int iCountnCell = 0; iCountnCell <= nCell; iCountnCell++)
	    	{
	    		Cell cellOld = rowOld.getCell(iCountnCell);
	    		if (cellOld == null)
	    		{
	    			continue;
	    		}
		    	Cell cellNew = rowNew.createCell(iCountnCell);
		    	cellNew.setCellType(cellOld.getCellType());
		    	
	    		switch(cellOld.getCellType()) {
			      case Cell.CELL_TYPE_STRING:
			    	  cellNew.setCellValue(cellOld.getRichStringCellValue().getString());
			        break;
			      case Cell.CELL_TYPE_NUMERIC:
			        if(DateUtil.isCellDateFormatted(cellOld)) {
			        	cellNew.setCellValue(cellOld.getDateCellValue());
			        } 
			        else {
			        	cellNew.setCellValue(cellOld.getNumericCellValue());
			        }

			        break;
			      case Cell.CELL_TYPE_BOOLEAN:
			    	  cellNew.setCellValue(cellOld.getBooleanCellValue());
			        break;
			      case Cell.CELL_TYPE_FORMULA:
			    	  cellNew.setCellValue(cellOld.getCellFormula());
			        break;
				}
	    	}
	    }
	    
	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("C:\\LDH.xls");
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
