package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;

    public ExcelUtils(String excelFilePath) {
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(int column, int row) {
        Sheet sheet = workbook.getSheetAt(0);
        Row rowData = sheet.getRow(row);
        Cell cell = rowData.getCell(column);
        return cell.getStringCellValue();
    }

    public List<String[]> readSheetData(String sheetName) {
        List<String[]> data = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet != null) {
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String[] rowData = new String[row.getLastCellNum()];
                Iterator<Cell> cellIterator = row.cellIterator();
                int cellIndex = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    rowData[cellIndex++] = cell.getStringCellValue();
                }
                data.add(rowData);
            }
        }
        return data;
    }
}
