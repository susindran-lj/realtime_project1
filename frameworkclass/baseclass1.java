package frameworkclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class baseclass1 {
	WebDriver driver;
//enter  URL
	public void enterurl(String url) {
		driver.get(url);
	}
	//maximize window
	public void maximizewindow() {
		driver.manage().window().maximize();
	}
	//insert value in text box
	public void inserttext(WebElement element, String text) {
		element.sendKeys(text);
	}
	//click button
	public void clickbutton(WebElement element) {
		element.click();
	}
	//click on the OK alert
	public void alertok() {
	Alert alert=driver.switchTo().alert();
	alert.accept();
	}
	//click on the cancel alert
	public void alertcancel() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	
	}
	//prompt alert
	public void promptalert(String text) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();

	}
	//get the inserted value by attribute
	public String getinsertedvalue(WebElement element,String attributevalue) {
	String value=element.getAttribute(attributevalue);
	return value;
	}
	//get the text from web page
	public String getwebpagetext(WebElement element) {
		String text =element.getText();
		return text;
	}
	//get title
	public String gettitle() {
	String title=driver.getTitle();	
	return title;
	}
	//close all windows
	public void closeallwindows() {
		driver.quit();
	}
	//close current window
	public void closecurrentwindow() {
		driver.close();
	}
	//get the entered URL
	public String getenteredurl() {
		String text=driver.getCurrentUrl();
		return text;
	}
	//select drop down option by text
	public void dropdownbytext(WebElement element, String text ) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	//select drop down option by value
	public void dropdownbyvalue(WebElement element, String text ) {
	Select select =new Select(element);
	select.selectByValue(text);
	}
	//select drop down option by index
	public void dropdownbyindex(WebElement element, int val) {
		Select select=new Select(element);
		select.selectByIndex(val);
	}
	//Launch the Chrome browser
	public void launchchrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//Switch to child window
	public void switchtochildwindow() {
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		for(String handle:childwindow ) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
			}
		}
	}
	//switch to frame by index
	public void switchframebyindex(int val) {
		driver.switchTo().frame(val);
	}
	//switch to frame by frame id
	public void switchbyframeid(String id) {
		driver.switchTo().frame(id);
	}
	//Switch to frame by frame name
	public void switchframebyname(String name){
		driver.switchTo().frame(name);
	}
	//locator by id
	public WebElement findlocatorbyid(String id) {
		WebElement element=driver.findElement(By.id(id));
		return element;
	}
	//locator by name
	public WebElement findlocatorbyname(String name) {
			WebElement element=driver.findElement(By.id(name));
			return element;
		}
	//locator by class name
	public WebElement findlocatorbyclassname(String cname) {
			WebElement element=driver.findElement(By.id(cname));
			return element;
		}
	//locator by xpath
	public WebElement findlocatorbyxpath(String xpath) {
		WebElement element=driver.findElement(By.xpath(xpath));
		return element;
	}
	//get all the options from dropdown as text
	public void getalldropdowntext(WebElement element) {
		Select select=new Select(element);
		List<WebElement> text=select.getOptions();
		for(WebElement value : text) {
			String optionvalue=value.getText();
			System.out.println(optionvalue);
		}
		
	}
	//insert the value by using javaScript executor
	public void insertvaluejse(WebElement element, String data) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setattribute('value',''"+data+"'')", element);
		
	}
	//click button by using JSE
	public void buttonclickjse(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].click()",element);
	}
	//get the first selected option in dropdown
	public String selectfirstoption(WebElement element) {
	Select select=new Select(element);
	WebElement option=select.getFirstSelectedOption();
	String text=option.getText();
	return text;
	}
	//verify dropdown is multi-select option
	public boolean dropdownmultiselect(WebElement element) {
		Select select=new Select(element);
		boolean text=select.isMultiple();
		return text;
	}
	//implicitwait
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	//implicitywait
	public void implicitywait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		
	}
	//explicit wait for visiblity of
	public void visibilityofwait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//fluent wait
	public void fluentwait(String locatorvalue) {
		Wait wait=new FluentWait(driver).withTimeout(Duration.ofMillis(3000)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+locatorvalue+"")));
	
	}
	//verify is displayed
	public boolean isdisplayed(WebElement element) {
		boolean displayed=element.isDisplayed();
		return displayed;
	}
	//verify is selected
	public boolean isselected(WebElement element) {
		boolean selected=element.isSelected();
		return selected;
	}
	//verify is enabled
	public boolean isenabled(WebElement element) {
			boolean enabled=element.isEnabled();
			return enabled;
		}
	// deselect by index
	public void deselectbyindex(WebElement element, int sec) {
		Select select=new Select(element);
		select.deselectByIndex(sec);
	}
	//deselect by attribute
	public void deselectbyattribute(WebElement element, String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	//deselect by text
	public void deselectbytext(WebElement element, String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	//deselect all
	public void deselectall(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	//get the parent window
	public void switchparentwindow() {
	String parent=driver.getWindowHandle();
	driver.switchTo().window(parent);
	}
	//clear text box
	public void cleartextbox(WebElement element) {
		element.clear();
	}
	//get the all windows
	public Set<String> getallwindow() {
		Set<String> allwindow=driver.getWindowHandles();
		return getallwindow();
		
	}
	//get path to savefile
	public String getprojectpath() {
		String path=System.getProperty("user.dir");
		return path;
	
	}
	//takescreenshot
	public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File f=screenshot.getScreenshotAs(OutputType.FILE);
		File source=new File(getprojectpath()+"\\images\\"+name+".png");
		FileUtils.copyFile(f, source);
		
		
	
	}
	//take screenshot for particular element
	public void screenshotforelement(String name, WebElement element) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File s=element.getScreenshotAs(OutputType.FILE);
		File u=new File(getprojectpath()+"\\image\\"+name+".png");
		FileUtils.copyFile(s, u);
	}
	//mouse over action for single action
	public void mouseoveraction(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
	//drag and drop
	public void draganddrop(WebElement from,WebElement to ) {
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).perform();
	}
	//right click
	public void rightclick(WebElement target) {
		Actions act=new Actions(driver);
		act.contextClick(target);
	}
	//double click
	public void doubleclick(WebElement target) {
		Actions act=new Actions(driver);
		act.doubleClick(target);
	}
	//insert value and enter
	public void sendandenter(WebElement element, String text) {
		Actions act=new Actions(driver);
		element.sendKeys(text);
		act.sendKeys(Keys.ENTER);
	}
	//refresh page
	public void refreshpage() {
		driver.navigate().refresh();
	}
	//get cell data
	public String getcelldata(String sheetname,int rownum, int cellnum) throws IOException  {
		String res="";
		File file=new File(getprojectpath()+"\\excel\\excelsheet01.xlsx");
		FileInputStream fil=new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(fil);
		Sheet sheet=wb.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		CellType type=cell.getCellType();
		switch(type){
		case STRING :
			res=cell.getStringCellValue();
			break;
		case NUMERIC :
			if(DateUtil.isCellDateFormatted(cell)) {
				Date datecellvalue=cell.getDateCellValue();
				SimpleDateFormat dateformat=new SimpleDateFormat("dd-mm-yy");
				res=dateformat.format(datecellvalue);
			}else {
				double numbericcellvalue=cell.getNumericCellValue();
				long round=Math.round(numbericcellvalue);
				if(numbericcellvalue==round) {
					res=String.valueOf(round);
				}
				else {
					res=String.valueOf(numbericcellvalue);
				}
			}
			break;
			default:
				break;
		}
		return res;
		}
	// replace cell data
	public void replacecelldata(String sheetname,int rownum, int cellnum, String olddata, String newdata) throws IOException {
	File file=new File(getprojectpath()+"\\excel\\excelsheet01.xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		Workbook wb= new XSSFWorkbook();
		Sheet sheet=wb.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		String value=cell.getStringCellValue();
		if(value.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream outputstream=new FileOutputStream(file);
		wb.write(outputstream);
		
		
	}
	//insert cell data
	public void insertcelldata(String sheetname, int rownum, int cellnum, String celldata) throws IOException {
		File file=new File(getprojectpath()+"\\excel\\excelsheet01.xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		Workbook wb=new XSSFWorkbook();
		Sheet sheet=wb.getSheet(sheetname);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		cell.setCellValue(celldata);
		FileOutputStream outputstream=new FileOutputStream(file);
		wb.write(outputstream);
		
	}
	//sendkeys
	public void elementsendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	//get text
	public String gettext(WebElement element) {
		visibilityofwait(element);
		String text=element.getText();
		return text;
	}
	//print all search result
			
		
		

}









