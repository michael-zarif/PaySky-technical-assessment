package basics;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    private final XSSFWorkbook workbook;

    public ReadExcelFile(String excelFilePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath))) {
            workbook = new XSSFWorkbook(fileInputStream);
        }
    }

    public String getData(int sheetNumber, int rowNumber, int columnNumber) {
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);

        if (cell != null) { // Check if the cell is not null
            // Handle different cell types
            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return String.valueOf(cell.getNumericCellValue());
            } else {
                return ""; // Or handle other cell types as needed
            }
        } else {
            return ""; // Return an empty string or handle the null cell as needed
        }
    }

    public int getRowCount(int sheetNumber) {
        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        return sheet.getLastRowNum() + 1;
    }
}