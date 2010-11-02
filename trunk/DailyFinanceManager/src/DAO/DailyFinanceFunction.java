/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import javax.print.DocFlavor.STRING;

/**
 *
 * @author Administrator
 */
public class DailyFinanceFunction extends BasicFunction{
    String strStaffName;
    String strTotalMoney;
    boolean bIsFindedStaffName;//neu tim dc ten nhan vien ma chua lay dc tien
    //thi co gia tri la true
    //neu lay dc tien thi co gia tri la false, va add rows vao csdl
    @Override
    protected void DoFunctionPerRow(ExcelTableModel tb) {
        if (tb.getValueAt(iRowCount, 0).toString().startsWith("Nhaân vieân:"))
        {
            bIsFindedStaffName = true;
            strStaffName = tb.getValueAt(iRowCount, 0).toString();
            return;
        }

        if (bIsFindedStaffName &&
                tb.getValueAt(iRowCount, 7) != null)
        {
            strTotalMoney = tb.getValueAt(iRowCount, 7).toString();
            bIsFindedStaffName = false;

            m_exTbNew.AddRow(4);
            //chi nhanh
            m_exTbNew.setValueAt(m_strFileName.substring(17, m_strFileName.length() - 10 - 1), m_exTbNew.getRowCount() - 1, 0);
            m_exTbNew.setValueAt(m_strFileName.substring(m_strFileName.length() - 10, m_strFileName.length()), m_exTbNew.getRowCount() - 1, 1);
            //ngay
            m_exTbNew.setValueAt(strStaffName, m_exTbNew.getRowCount() - 1, 2);
            m_exTbNew.setValueAt(strTotalMoney, m_exTbNew.getRowCount() - 1, 3);
        }
    }
}
