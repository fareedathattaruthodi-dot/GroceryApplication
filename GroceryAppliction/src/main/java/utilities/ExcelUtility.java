package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;//file details fetching class 
	static XSSFWorkbook wb; //get deatils from the workbook 
	static XSSFSheet   sh; // get deatails from the sheet
	
	public static String readStringData(int row,int col,String sheet) throws IOException//to read string data
	{

		f=new FileInputStream(Constant.TESTDATA);
		wb=new XSSFWorkbook(f);//object created for workbook
		sh=wb.getSheet(sheet);//reading that particular sheet data
		XSSFRow r=sh.getRow(row);//to get data from particular row
		XSSFCell c=r.getCell(col);//to get data from particular column
		return c.getStringCellValue();//to get string data value from excel
	}
	public static String getIntegerData(int a, int b,String sheet) throws IOException 
	{
		f= new FileInputStream(Constant.TESTDATA);
		wb= new XSSFWorkbook(f); 
		sh=wb.getSheet(sheet);
		XSSFRow r=sh.getRow(a);
		XSSFCell c= r.getCell(b);
		int x=(int) c.getNumericCellValue();// double values converting to int(type casting)
		return String.valueOf(x);
		
	}


}
