/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Administrator
 */
public class CopyAllFileFunction extends BasicFunction{

    String[] _arrHeaderColumns = null;
    int[] _arrHeaderNeededCopy = null;

    public CopyAllFileFunction() {
    }

    public enum Attribute {
        HEADER_COLUMNS,
        COLUMNS_NEEDED_COPY,
    }
    public void SetAttribute(Attribute att, Object objValue)
    {
        switch (att)
        {
            case HEADER_COLUMNS:
            {
                _arrHeaderColumns = (String[])objValue;
                break;
            }

            case COLUMNS_NEEDED_COPY:
            {
                _arrHeaderNeededCopy = (int[])objValue;
                break;
            }
        }
    }

    //chi chay 1 lan duy nhat de tao headername cho file ket qua
    public void PreDoFunctionOneTime(ExcelTableModel tb) {
        //super.PreDoFunction(tb);
        m_exTbNew.AddRow(_arrHeaderColumns.length + 2);

        //them cot ten file vao
        m_exTbNew.setLastRowValueAt("Chi nhánh", 0);
        m_exTbNew.setLastRowValueAt("Ngày", 1);

        for (int i = 0; i < _arrHeaderColumns.length; i++) {
            m_exTbNew.setLastRowValueAt(_arrHeaderColumns[i], i + 2);
        }
    }

    @Override
    protected void DoFunctionPerRow(ExcelTableModel tb) {
        //add new
        m_exTbNew.AddRow(_arrHeaderNeededCopy.length + 2);

        m_exTbNew.setLastRowValueAt(m_strFileName.substring(0, m_strFileName.length() - 11), 0);
        m_exTbNew.setLastRowValueAt(m_strFileName.substring(m_strFileName.length() - 10, m_strFileName.length()), 1);

        for (int i = 0; i < _arrHeaderNeededCopy.length; i++) {
            m_exTbNew.setLastRowValueAt(tb.getValueAtString(iRowCount, _arrHeaderNeededCopy[i] - 1), i + 2);
        }
    }

    @Override
    protected boolean CheckNeedsCellSuitWithCondition(ExcelTableModel tb)
    {
        for (int i = 0; i < _arrHeaderNeededCopy.length; i++) {
            if (tb.getValueAt(iRowCount, _arrHeaderNeededCopy[i] - 1) == null) return false;
        }

        return true;
    }
}
