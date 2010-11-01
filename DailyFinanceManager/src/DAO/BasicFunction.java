/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Administrator
 */
public class BasicFunction {
    protected int iRowCount;
    protected int iCellCount;

    ExcelTableModel m_exTbNew;

    public BasicFunction() {
        m_exTbNew = new ExcelTableModel();
    }

    public void DoFunction(ExcelTableModel tb)
    {
        PreDoFunction(tb);
        for (iRowCount = 0; iRowCount < tb.getRowCount(); iRowCount++) {
            if (CheckNeedsCellSuitWithCondition(tb))
            {
                DoFunctionPerRow(tb);
            }
        }
        PostDoFunction(tb);
    }

    protected void PreDoFunction(ExcelTableModel tb){}

    protected boolean CheckNeedsCellSuitWithCondition(ExcelTableModel tb)
    {
        return true;
    }
    protected void DoFunctionPerRow(ExcelTableModel tb){}

    protected void PostDoFunction(ExcelTableModel tb){}

    public ExcelTableModel GetResult()
    {
        return m_exTbNew;
    }

    //http://www.javadb.com/validate-if-string-is-a-number
    public static boolean checkIfNumber(String in) {

        try {

            Integer.parseInt(in);

        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
