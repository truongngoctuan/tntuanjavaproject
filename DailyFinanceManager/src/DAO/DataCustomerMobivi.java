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
    String[] _arrKeyCityInState = null;
    String[] _arrValueCityInState = null;

    public DataCustomerMobivi() {
    }

    public enum Attribute {
        STATE,
        KEY_CITY,
        VALUE_CITY
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

            case KEY_CITY:
            {
                _arrKeyCityInState = (String[])objValue;
                break;
            }

            case VALUE_CITY:
            {
                _arrValueCityInState = (String[])objValue;
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

        for (int i = 0; i < _arrKeyCityInState.length; i++) {
            if (tb.getValueAtString(iRowCount, 1).equals(_arrState[i]))
            {
                if(tb.getValueAtString(iRowCount, 0).indexOf(_arrKeyCityInState[i]) >= 0)
                {
                    m_exTbNew.setLastRowValueAt(_arrValueCityInState[i], 2);
                    iCountAppear++;

                    if (_arrValueCityInState[i].equals("DISTRICT 10") ||
                            _arrValueCityInState[i].equals("DISTRICT 11") ||
                            _arrValueCityInState[i].equals("DISTRICT 12"))
                    {//day la truong hop dac biet vi khi do
                        //no luc nao cung tim dc q1 va q11 --> icount == 2
                        iCountAppear--;
                    }
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
