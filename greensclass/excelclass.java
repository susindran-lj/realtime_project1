package greensclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelclass {
	public void getcelldata(String sheetname,int rownum, int cellnum) throws IOException  {
	String res="";
	File file=new File(getprojectpath()+"\\excel\\excelsheet01.xlsx");
	FileInputStream fil=new FileInputStream(file);
	Workbook wb=new XSSFWorkbook(fil);
	Sheet sheet=wb.getSheet(sheetname);
	Row row=sheet.getRow(rownum);
	Cell cell=row.getCell(cellnum);
	System.out.println(cell);
	
	}
public String getprojectpath() {
	String path=System.getProperty("user.dir");
	return path;
}

public static void main(String[] args) throws IOException {
	excelclass ec=new excelclass();
	ec.getcelldata("login", 1, 0);

}
}