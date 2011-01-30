/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author Administrator
 */
public class DataCustomerMobivi extends BasicFunction {

    String[] _arrState = null;
    String[] _arrCityInState = null;

    public DataCustomerMobivi() {
    }

    public enum Attribute {
        STATE,
        CITY
    }
    public void SetAttribute(Attribute att, Object objValue)
    {
        switch (att)
        {
            case STATE:
            {
                _arrState = (String[])objValue;
                break;
            }

            case CITY:
            {
                _arrCityInState = (String[])objValue;
                break;
            }
        }
    }

    @Override
    protected void DoFunctionPerRow(ExcelTableModel tb) {
        //add new
        m_exTbNew.AddRow(4);

        m_exTbNew.setLastRowValueAt(tb.getValueAtString(iRowCount, 0), 0);
        m_exTbNew.setLastRowValueAt(tb.getValueAtString(iRowCount, 1), 1);
        m_exTbNew.setLastRowValueAt("", 2);

        int iCountAppear = 0;

        for (int i = 0; i < _arrCityInState.length; i++) {
            if (tb.getValueAtString(iRowCount, 1).equals(_arrState[i]))
            {
                if(tb.getValueAtString(iRowCount, 0).indexOf(_arrCityInState[i]) >= 0)
                {
                    m_exTbNew.setLastRowValueAt(_arrCityInState[i], 2);
                    iCountAppear++;
                //break;
                }
            }
        }

        m_exTbNew.setLastRowValueAt(String.valueOf(iCountAppear), 3);
    }

    @Override
    protected boolean CheckNeedsCellSuitWithCondition(ExcelTableModel tb)
    {
        return true;
    }

}
