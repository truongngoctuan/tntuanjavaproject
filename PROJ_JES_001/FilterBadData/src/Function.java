
public abstract class Function {
	String m_arrArgument[];
	public Function(String arrArgument[])
	{
	}
	public abstract boolean CheckArgument();
	
	public abstract boolean CheckConditionPerRow();
	
	public abstract void DoFunction();
}
