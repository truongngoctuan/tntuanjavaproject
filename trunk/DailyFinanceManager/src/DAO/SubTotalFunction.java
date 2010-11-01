/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Administrator
 */
public class SubTotalFunction extends BasicFunction{
//cong cot dau, giu nguyen cot 1, cong don cot 10
    @Override
    protected void DoFunctionPerRow(ExcelTableModel tb) {
        //super.DoFunctionPerRow(tb);
        //kiem tra co trong tbnew chua,
            //neu co, cong don
            //neu chua add cai moi
        int iSamePos = checkInTableModelNewIfHave(tb.getValueAt(iRowCount, 0).toString(),
                0);
        if (iSamePos >= 0)
        {
            //cong don
            int iSum = Integer.parseInt(m_exTbNew.getValueAt(iSamePos, 2).toString()) +
                    Integer.parseInt(tb.getValueAt(iRowCount, 10).toString());
            m_exTbNew.setValueAt(String.valueOf(iSum), iSamePos, 2);
        }
else
        {
            //add new
            m_exTbNew.AddRow(3);
//            m_exTbNew.setValueAt(tb.getValueAt(iRowCount, 0).toString(), m_exTbNew.getRowCount() - 1, 0);
//            m_exTbNew.setValueAt(tb.getValueAt(iRowCount, 1).toString(), m_exTbNew.getRowCount() - 1, 1);
//            m_exTbNew.setValueAt(tb.getValueAt(iRowCount, 10).toString(), m_exTbNew.getRowCount() - 1, 2);

            m_exTbNew.setLastRowValueAt(tb.getValueAtString(iRowCount, 0), 0);
            m_exTbNew.setLastRowValueAt(tb.getValueAt(iRowCount, 1), 1);
            m_exTbNew.setLastRowValueAt(tb.getValueAt(iRowCount, 10), 2);
        }
    }



    @Override
    protected boolean CheckNeedsCellSuitWithCondition(ExcelTableModel tb)
    {
        if (tb.getValueAt(iRowCount, 0) == null) return false;
        if (tb.getValueAt(iRowCount, 1) == null) return false;
        if (tb.getValueAt(iRowCount, 10) == null) return false;

        if (!checkIfNumber(tb.getValueAt(iRowCount, 0).toString())) return false;
        if (Integer.parseInt(tb.getValueAt(iRowCount, 0).toString()) <= 0) return false;

        if (!checkIfNumber(tb.getValueAt(iRowCount, 10).toString())) return false;

        return true;
    }

    private int checkInTableModelNewIfHave(String strIn,
            int iIndexColumn)
    {
        for (int i = 0; i < m_exTbNew.getRowCount(); i++) {
            if (m_exTbNew.getValueAtString(i, iIndexColumn).equals(strIn))
            {
                return i;
            }
        }

       return -1;
    }
}