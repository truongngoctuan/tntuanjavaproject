
public class ExcelFile {
	String strFileName;
	String strSheetName;
	int iRangeTop;
	int iRangeLeft;
	int iRangeBottom;
	int iRangeRight;
	
	public ExcelFile(String strFileName, 
			String strSheetName, 
			int iRangeTop, 
			int iRangeLeft,
			int iRangeBottom,
			int iRangeRight)
	{
		
	}
	public static DataTable ReadFromFile(ExcelFile FileIn)
	{
		return new DataTable();
	}
	public static void WriteToFile(ExcelFile FileIn, 
			DataTable DBSource)
	{
		
	}

}
