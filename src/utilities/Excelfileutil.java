package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfileutil {
	Workbook wb;
	
	public  Excelfileutil () throws Exception {
	FileInputStream fi=new FileInputStream("D:\\New folder (2)\\tanya\\SADatadrivenframework\\TestInput\\supplier.xlsx");
	wb=new XSSFWorkbook(fi);
	}
	public int rowcount(String sheetname){
	return wb.getSheet(sheetname).getLastRowNum();	
		
	}
	
	public int columncount(String sheetname){
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
		}
	
	public String getdata(String sheetname,int row,int column){
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC){
			int celldata=	(int )wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();	
			data=String.valueOf(celldata);
		}else{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
	
	public void setdata(String sheetname,int row,int column,String status) throws Exception{
		Cell cell=wb.getSheet(sheetname).getRow(row).getCell(column);
		cell.setCellValue(status);
		if(status.equalsIgnoreCase("Pass")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);
		}else if (status.equalsIgnoreCase("Fail")) {
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);	
		}else if(status.equalsIgnoreCase("Not Executed")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			cell.setCellStyle(style);	
		}
		FileOutputStream fos=new FileOutputStream("D:\\New folder (2)\\tanya\\SADatadrivenframework\\Testoutput\\supplieroutput.xlsx");	
		wb.write(fos);
		fos.close();
	}
	
}
