package RahulShettyAcademy.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

    public static void main(String[] args) throws IOException {
        // Variables
        String fruitName = "Apple";
        String updatedValue = "603";
        String fileName = "C:/Users/laxma/Downloads/download.xlsx";

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        // Download the file
        driver.findElement(By.cssSelector("#downloadButton")).click();

        // Edit Excel: Get the column number of 'Price' and row number of 'Apple', then update the Excel file
        int col = getColumnNumber(fileName, "price");
        int row = getRowNumber(fileName, "Apple");
        Assert.assertTrue(updateCell(fileName, row, col, updatedValue));

        // Upload the edited file
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("C:/Users/laxma/Downloads/download.xlsx");

        // Wait for the success message to appear and then disappear
        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

        // Verify the toast message
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println(toastText);
        Assert.assertEquals("Updated Excel Data Successfully.", toastText);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

        // Verify the updated Excel data in the web table
        String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName + "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();
        System.out.println(actualPrice);
        Assert.assertEquals(updatedValue, actualPrice);
    }

    // Method to update a cell in the Excel file
    private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
        // Open the file input stream
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Update the cell value
        Row rowField = sheet.getRow(row - 1);
        Cell cellField = rowField.getCell(col - 1);
        cellField.setCellValue(updatedValue);

        // Write the updated workbook back to the file
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);

        // Close resources
        workbook.close();
        fis.close();
        fos.close();

        return true;
    }

    // Method to get the row number for a given text
    private static int getRowNumber(String fileName, String text) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Iterate through the rows to find the matching text
        Iterator<Row> rows = sheet.iterator();
        int rowIndex = -1;
        int k = 1;

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();

            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)) {
                    rowIndex = k;
                }
            }
            k++;
        }

        // Close resources
        workbook.close();
        fis.close();

        return rowIndex;
    }

    // Method to get the column number for a given column name
    private static int getColumnNumber(String fileName, String colName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Iterate through the cells in the first row to find the matching column name
        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
        Iterator<Cell> ce = firstRow.cellIterator();
        int colIndex = 0;
        int k = 1;

        while (ce.hasNext()) {
            Cell value = ce.next();
            if (value.getStringCellValue().equalsIgnoreCase(colName)) {
                colIndex = k;
            }
            k++;
        }

        // Close resources
        workbook.close();
        fis.close();

        return colIndex;
    }
}