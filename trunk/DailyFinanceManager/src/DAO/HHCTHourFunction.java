/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Buffet Cali
 */
public class HHCTHourFunction extends BasicFunction{

     @Override
    public void DoFunction(ExcelTableModel tb) {
        //super.DoFunction(tb);

        for (iRowCount = 0; iRowCount < tb.getRowCount(); iRowCount++) {
            //kiem tra
            if (CheckNeedsCellSuitWithCondition(tb))
            {
                m_exTbNew.AddRow(3);

                String strHour = tb.getValueAt(iRowCount, 0).toString() +
                        tb.getValueAt(iRowCount, 1).toString();

                m_exTbNew.setValueAt(m_strDate, m_exTbNew.getRowCount() - 1, 0);
                m_exTbNew.setValueAt(strHour, m_exTbNew.getRowCount() - 1, 1);
                m_exTbNew.setValueAt(tb.getValueAt(iRowCount, 10).toString(), m_exTbNew.getRowCount() - 1, 2);
            }
        }
    }

     private boolean CheckNeedsCellSuitWithCondition(ExcelTableModel tb)
    {
         if (tb.getValueAt(iRowCount, 0) == null) return false;
         if (tb.getValueAt(iRowCount, 1) == null) return false;
         if (tb.getValueAt(iRowCount, 10) == null) return false;

         if (!tb.getValueAt(iRowCount, 0).toString().startsWith("Giôø:")) return false;

         if (!checkIfNumber(tb.getValueAt(iRowCount, 10).toString())) return false;

         return true;
    }

     private String m_strDate;

     public void SetDate(String strDate)
    {
         m_strDate = strDate;
    }
}
