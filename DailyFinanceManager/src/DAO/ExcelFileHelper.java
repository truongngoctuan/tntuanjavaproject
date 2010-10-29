/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;

/**
 *
 * @author Administrator
 */
public class ExcelFileHelper {

    public static ExcelTableModel GetDataFromFile(String strFileName) throws FileNotFoundException, IOException
    {
        ExcelTableModel tb = new ExcelTableModel();

        InputStream inp = new FileInputStream(strFileName);
        Workbook wb = new HSSFWorkbook(inp);
        Sheet sheetOld = wb.getSheetAt(0);

        int nRow = sheetOld.getLastRowNum();
        int iCountnRowReal = 0;
        for (int iCountnRow = 0; iCountnRow <= nRow; iCountnRow++)
        {
            Row rowOld = sheetOld.getRow(iCountnRow);
            if (rowOld == null) continue;
            
            int nCell = rowOld.getLastCellNum();
            tb.AddRow(nCell);
            for (int iCountnCell = 0; iCountnCell <= nCell; iCountnCell++)
            {
                Cell cellOld = rowOld.getCell(iCountnCell);

                String strValue = "";
                if (cellOld == null)
                {
                    strValue = "";
                }
 else
                {
                    switch(cellOld.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                        {
                            //cellNew.setCellValue(cellOld.getRichStringCellValue().getString());
                            strValue = cellOld.getRichStringCellValue().getString();
                            break;
                        }
                        case Cell.CELL_TYPE_NUMERIC:
                        {
                            if(DateUtil.isCellDateFormatted(cellOld))
                            {
                                    //cellNew.setCellValue(cellOld.getDateCellValue());
                                strValue = cellOld.getDateCellValue().toString();
                            }
                            else {
                                    //cellNew.setCellValue(cellOld.getNumericCellValue());
                                strValue = String.valueOf((int)cellOld.getNumericCellValue());
                            }
                            break;
                        }
                        case Cell.CELL_TYPE_BOOLEAN:
                        {
                          //cellNew.setCellValue(cellOld.getBooleanCellValue());
                        break;
                        }
                        case Cell.CELL_TYPE_FORMULA:
                        {
                          //cellNew.setCellValue(cellOld.getCellFormula());
                        break;
                        }
                    }
                }

                tb.setValueAt(strValue, iCountnRowReal, iCountnCell);
            }
            iCountnRowReal++;
        }

        return tb;
    }
}
