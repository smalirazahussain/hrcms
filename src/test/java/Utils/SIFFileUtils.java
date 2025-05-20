package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class SIFFileUtils {

    /**
     * Load employee data from a SIF payroll Excel file.
     * Normalizes header keys and ensures robust parsing.
     *
     * @param file the .xlsx SIF file
     * @return list of employee rows as maps of column name -> value
     */
    public static List<Map<String, Object>> loadSIFFile(File file) {
        List<Map<String, Object>> sifData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalStateException("❌ SIF file is missing a header row.");
            }

            int totalColumns = headerRow.getLastCellNum();
            List<String> headers = new ArrayList<>();

            // Normalize headers (trim + uppercase)
            for (int col = 0; col < totalColumns; col++) {
                Cell cell = headerRow.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String rawHeader = cell.getStringCellValue().trim();
                headers.add(rawHeader);
            }

            System.out.println("🧾 Headers found in SIF file: " + headers);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                Map<String, Object> employeeRow = new LinkedHashMap<>();
                for (int colIndex = 0; colIndex < totalColumns; colIndex++) {
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Object value;

                    switch (cell.getCellType()) {
                        case STRING:
                            value = cell.getStringCellValue().trim();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                value = cell.getDateCellValue();
                            } else {
                                value = cell.getNumericCellValue();
                            }
                            break;
                        case BOOLEAN:
                            value = cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            value = cell.getCellFormula();
                            break;
                        case BLANK:
                        default:
                            value = "";
                            break;
                    }

                    String headerKey = headers.get(colIndex);
                    employeeRow.put(headerKey, value);
                }

                // Debug row output
                System.out.println("📄 Row " + rowIndex + ": " + employeeRow);
                sifData.add(employeeRow);
            }

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to read SIF file: " + e.getMessage(), e);
        }

        return sifData;
    }
}
