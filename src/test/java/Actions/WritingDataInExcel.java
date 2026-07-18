package Actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {

	public static void main(String[] args) throws IOException 
	{
		FileOutputStream file=new FileOutputStream("testdata/DynaminData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet =workbook.createSheet("Sheet1");

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the rows number:");
		int nrows=sc.nextInt();
		System.out.println("Enter the cell number:");
		int ncell=sc.nextInt();
		
		for(int r=0;r<=nrows;r++)
		{
			XSSFRow currentRow=sheet.createRow(r);
			
			for(int c=0;c<ncell;c++)
			{
				XSSFCell cell=currentRow.createCell(c);
				cell.setCellValue(sc.next());
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created:");
	}

}

