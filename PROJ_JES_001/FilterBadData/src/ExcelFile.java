import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelFile {
	String strFileName;
	String strSheetName;
	int iRangeTop;
	int iRangeLeft;
	int iRangeBottom;
	int iRangeRight;
	
	public ExcelFile(String strFileNameA, 
			String strSheetNameA, 
			int iRangeTopA, 
			int iRangeLeftA,
			int iRangeBottomA,
			int iRangeRightA)
	{
		strFileName = strFileNameA;
		strSheetName = strSheetNameA;
		iRangeTop = iRangeTopA;
		iRangeLeft = iRangeLeftA;
		iRangeBottom = iRangeBottomA;
		iRangeRight = iRangeRightA;
	}
	public static ExcelDataTable ReadFromFile(ExcelFile FileIn) throws IOException
	{
		return new ExcelDataTable(FileIn.strFileName, 
				FileIn.strSheetName);
	}
	public static void WriteToFile(ExcelFile EFileOut, 
			ExcelDataTable DBSource) throws IOException
	{
		FileOutputStream fileOut = new FileOutputStream(EFileOut.strFileName);
	    Workbook wb = DBSource.getCurrentWorkbook();
	    wb.write(fileOut);
	    fileOut.close();
	}

}
