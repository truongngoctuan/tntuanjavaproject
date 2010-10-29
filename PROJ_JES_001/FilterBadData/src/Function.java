
public abstract class Function {
	protected boolean m_bIsLogic = true;
	public Function(String arrArgument[])
	{
	}
	public abstract boolean CheckArgument(ExcelDataTable DB);
	
	public abstract boolean CheckConditionPerRow(int iIndexRow,
			ExcelDataTable DB);
	
	public abstract void DoFunction();
}
