package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class ProcessSalaryEmployeeData {

    private static final List<Map<String, Object>> employeeDataList = new ArrayList<>();
    public static String salaryMonth;
    private static List<String> headers = new ArrayList<>();

    // Load and save all data from Excel into memory (no salary generation)
    public static void loadFromExcel(File excelFile, File salaryFile) {
        employeeDataList.clear();
        try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) throw new IllegalStateException("Missing header row in Excel");

            int numCols = headerRow.getLastCellNum();
            headers = new ArrayList<>();
            for (int i = 0; i < numCols; i++) {
                headers.add(headerRow.getCell(i).getStringCellValue().trim());
            }

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                Map<String, Object> rowData = new LinkedHashMap<>();
                for (int colIndex = 0; colIndex < headers.size(); colIndex++) {
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Object value;
                    switch (cell.getCellType()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = cell.getNumericCellValue();
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
                    rowData.put(headers.get(colIndex), value);
                }
                // Add ROUTING CODE if DETAIL TYPE is KAMELPAY
                Object detailType = rowData.get("DETAIL TYPE");
                if (detailType != null && detailType.toString().equalsIgnoreCase("KAMELPAY")) {
                    rowData.put("ROUTING CODE", "643140101");
                }
                employeeDataList.add(rowData);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
    }

    // Write updated salary data back into the Excel file
    public static void writeUpdatedExcel(File originalFile, File outputFile) {
        try (FileInputStream fis = new FileInputStream(originalFile);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex <= employeeDataList.size(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;
                Map<String, Object> rowData = employeeDataList.get(rowIndex - 1);

                for (int colIndex = 0; colIndex < headers.size(); colIndex++) {
                    String header = headers.get(colIndex);
                    Object value = rowData.get(header);
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (value instanceof String)
                        cell.setCellValue((String) value);
                    else if (value instanceof Number)
                        cell.setCellValue(((Number) value).doubleValue());
                    else if (value instanceof Boolean)
                        cell.setCellValue((Boolean) value);
                    else
                        cell.setCellValue(value.toString());
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error writing updated Excel file: " + e.getMessage(), e);
        }
    }

    // Get all loaded employee rows
    public static List<Map<String, Object>> getAllData() {
        return new ArrayList<>(employeeDataList);
    }

    // Get row by index
    public static Map<String, Object> getRow(int index) {
        return employeeDataList.get(index);
    }

    // Clear all loaded data
    public static void clear() {
        employeeDataList.clear();
    }

    // Print all rows
    public static void printAll() {
        int i = 1;
        for (Map<String, Object> row : employeeDataList) {
            System.out.println("Employee Row " + (i++) + ": " + row);
        }
    }
}
