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
	    Sheet sheet = wb.getSheetAt(0);
	    //Row row = sheet.getRow(2);
	    //Cell cell = row.getCell(3);
	    //if (cell == null)
	    //    cell = row.createCell(3);
	    //cell.setCellType(Cell.CELL_TYPE_STRING);
	    //cell.setCellValue("TNT");
	    
	    int iCountNew = 0;
	    int iCountOld = 0;
	    Sheet sheet2 = wb.createSheet("aaa");
		for (Row rowi : sheet) {
			if (iCountOld == 5)
			{
				
			}
			else
			{				
				sheet2.createRow(iCountNew);

				Row rowtemp = sheet2.getRow(iCountNew);
				int iCountRow = 0;
				for (Cell celli : rowi) {
					// Do something here
					if (celli != null)
					{
						Cell cellTemp = rowtemp.createCell(iCountRow);
						cellTemp.setCellType(celli.getCellType());
						//cellTemp.setCellValue("111");
						switch(celli.getCellType()) {
					      case Cell.CELL_TYPE_STRING:
					    	  cellTemp.setCellValue(celli.getRichStringCellValue().getString());
					        break;
					      case Cell.CELL_TYPE_NUMERIC:
					        if(DateUtil.isCellDateFormatted(celli)) {
					        	cellTemp.setCellValue(celli.getDateCellValue());
					        } else {
					        	cellTemp.setCellValue(celli.getNumericCellValue());
					        }

					        break;
					      case Cell.CELL_TYPE_BOOLEAN:
					    	  cellTemp.setCellValue(celli.getBooleanCellValue());
					        break;
					      case Cell.CELL_TYPE_FORMULA:
					    	  cellTemp.setCellValue(celli.getCellFormula());
					        break;
						}
					iCountRow++;
				}

				//rowtemp = rowi;
				iCountNew++;
			}
			}	
			iCountOld++;
		

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
