import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDataTable {
	public int nRows;
	public int nColumns;
	
	private InputStream inp;
	private Workbook wb;
	private Sheet m_sh;
	
	public ExcelDataTable(String strFileName, String strSheetName) throws IOException
	{
		inp = new FileInputStream(strFileName);
		wb = new HSSFWorkbook(inp);
		
		m_sh = wb.getSheet(strSheetName);
	}
	
	public String GetData(int iRows, 
			int iColumn)
	{
		return "";
	}
	public void SetData(int iRows, 
			int iColumn, 
			String strValue)
	{
		
	}
	
	public Workbook getCurrentWorkbook()
	{
		return wb;
	}
}
