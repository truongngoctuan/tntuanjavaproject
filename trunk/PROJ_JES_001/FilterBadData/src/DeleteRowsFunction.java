
public class DeleteRowsFunction extends Function {
	private int m_arriArgument[];

	public DeleteRowsFunction(String[] arrArgument) {
		super(arrArgument);
		// TODO Auto-generated constructor stub
		if (arrArgument.length == 1)
		{
			try
			{
				m_arriArgument = new int[1];
				m_arriArgument[0] = Integer.parseInt(arrArgument[0]);
			}
			catch (NumberFormatException err)
			{
				m_bIsLogic = false;
			}
			
		}
		if (arrArgument.length == 2)
		{
			try
			{
				m_arriArgument = new int[2];
				m_arriArgument[0] = Integer.parseInt(arrArgument[0]);
				m_arriArgument[1] = Integer.parseInt(arrArgument[1]);
			}
			catch (NumberFormatException err)
			{
				m_bIsLogic = false;
			}
		}
	}

	@Override
	//ham nay co 2 kieu
	//1 arg va 2 arg
	//1 arg la xoa 1 dong
	//2 arg la xoa n dong trong 1 pham vi
	public boolean CheckArgument(ExcelDataTable DB) {
		// TODO Auto-generated method stub
		if (m_arriArgument.length == 1)
		{
			if (m_arriArgument[0] >= 0 &&
					m_arriArgument[0] <= DB.nRows)
			{
				return true;
			}
			return false;
		}
		if (m_arriArgument.length == 2)
		{
			if (0 <= m_arriArgument[0] &&
					m_arriArgument[0] < m_arriArgument[1] &&
					m_arriArgument[1] <= DB.nRows)
			{
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean CheckConditionPerRow(int iIndexRow,
			ExcelDataTable DB) {
		// TODO Auto-generated method stub
		if (m_arriArgument.length == 1)
		{
		}
		if (m_arriArgument.length == 2)
		{
		}
		
		return false;
	}

	@Override
	public void DoFunction() {
		// TODO Auto-generated method stub
		
	}

}
