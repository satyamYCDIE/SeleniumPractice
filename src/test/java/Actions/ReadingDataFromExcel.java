package Actions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream("testdata/testing1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
		int totalrows=sheet.getLastRowNum();
		int totalcell=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total number of rows:"+totalrows);
		System.out.println("Total number of cells:"+totalcell);
		
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);
			
			for(int c=0;c<totalcell;c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
