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
    public void DoFunction(ExcelTableModel tb) {
        bIsFindedStaffName = false;

        for (iRowCount = 0; iRowCount < tb.getRowCount(); iRowCount++) {
            if (tb.getValueAt(iRowCount, 0).toString().startsWith("Nhaân vieân:"))
            {
                bIsFindedStaffName = true;
                strStaffName = tb.getValueAt(iRowCount, 0).toString();
                continue;
            }

            if (bIsFindedStaffName &&
                    tb.getValueAt(iRowCount, 7) != null)
            {
                strTotalMoney = tb.getValueAt(iRowCount, 7).toString();
                bIsFindedStaffName = false;

                m_exTbNew.AddRow(2);
                m_exTbNew.setValueAt(strStaffName, m_exTbNew.getRowCount() - 1, 0);
                m_exTbNew.setValueAt(strTotalMoney, m_exTbNew.getRowCount() - 1, 1);
            }
        }
    }
}
