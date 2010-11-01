/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Vector;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator
 */
public class ExcelTableModel implements TableModel{
    Vector<String[]> m_arrData;
    int m_nColumns;
    int m_nRows;
    public ExcelTableModel() {
        m_arrData = new Vector<String[]>();
    }


    public void AddRow(int nCellsInRow)
    {
        m_arrData.add(new String[nCellsInRow]);
        
        m_nRows = m_arrData.size();
        if (m_nColumns < nCellsInRow)
        {
            m_nColumns = nCellsInRow;
        }
    }

    public int getRowCount() {
        return m_nRows;
    }

    public int getColumnCount() {
        return m_nColumns;
    }

    //@Override
    public String getColumnName(int columnIndex) {
        //http://www.java2s.com/Code/Java/Language-Basics/Convertinttostring.htm
        return String.valueOf((char)(columnIndex + 65));
    }

//    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return getValueAt(0, 0).getClass();
    }

    //@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (m_arrData.size() > rowIndex && m_arrData.get(rowIndex).length > columnIndex)
        {
            return m_arrData.get(rowIndex)[columnIndex];
        }
        return null;
    }

    public String getValueAtString(int rowIndex, int columnIndex) {
        return getValueAt(rowIndex, columnIndex).toString();
    }

    //@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (m_arrData.size() > rowIndex && m_arrData.get(rowIndex).length > columnIndex)
        {
            m_arrData.get(rowIndex)[columnIndex] = aValue.toString();
        }
    }

    public void setLastRowValueAt(Object aValue, int columnIndex) {
        setValueAt(aValue, getRowCount() - 1, columnIndex);
    }



    //@Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
