/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

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

    public static void SaveDataToFile(String strFileName,
            String strSheetName,
            ExcelTableModel tb) throws IOException
    {
        //http://poi.apache.org/spreadsheet/quick-guide.html#CreateCells
        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet(strSheetName);

        //------------------------------------
        //add row and cell
        Cell cell;
        for (int i = 0; i < tb.getRowCount(); i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < tb.getColumnCount(); j++)
            {
                cell = row.createCell(j, Cell.CELL_TYPE_STRING);
                try {
                cell.setCellValue(tb.getValueAt(i, j).toString());
                }
                catch(Exception ex)
                {
                    System.out.println("");
                }
            }
        }
        //------------------------------------
//        // Create a row and put some cells in it. Rows are 0 based.
//        Row row = sheet.createRow((short)0);
//        // Create a cell and put a value in it.
//        Cell cell = row.createCell(0);
//        cell.setCellValue(1);
//
//        // Or do it on one line.
//        row.createCell(1).setCellValue(1.2);
//        row.createCell(2).setCellValue(
//             createHelper.createRichTextString("This is a string"));
//        row.createCell(3).setCellValue(true);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(strFileName);
        wb.write(fileOut);
        fileOut.close();
    }

}
