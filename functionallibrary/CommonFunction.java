package com.hcv.functionallibrary;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hcv.utilities.Filepath;

public class CommonFunction {
	
	public static WebDriver driver;
	
	public static String getproperty(String propertyname) throws IOException,FileNotFoundException 
	{
		FileInputStream fis = new FileInputStream(Filepath.configpath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(propertyname);
	}
	
	public static void openBrowser() throws FileNotFoundException, IOException {
		
		String appurl = getproperty("url");
		String browsername = getproperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Filepath.chromedriver);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appurl);
		}else if(browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", Filepath.iedriver);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appurl);
		}else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Filepath.geckodriver);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(appurl);
		}else {
			System.out.println("Plz enter correct browser name in config.properties");
		}
	}

	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void captureScreenshot(String filename) throws IOException {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(Filepath.screenshot + "//" + filename + ".jpg"));
	}
	// Actions oriented commands:
	
		//handle edit fields
		public static void type(WebElement element, String value) {
			element.sendKeys(value);
		}
		
		//clear any edit field
		public static void clear(WebElement element) {
			element.clear();
			
		}
		//button, checkox, radio, link, popup
		public static void click(WebElement element) {
				element.click();
			}
		//dropwon:
		public static void selectDropdown(WebElement element, String value) {
			new Select (element).selectByVisibleText(value);
			//new Select (element).selectByIndex(arg0);
			//new Select (element).selectByValue(arg0);
		}
		// popup :
		public static void acceptPopup() {
			Alert popup = driver.switchTo().alert();
			popup.accept();
		}
		public static void dismissPopup() {
			Alert popup = driver.switchTo().alert();
			popup.dismiss();
		}
		
		//Navigation commands:
		public static void navigateBack() {
			driver.navigate().back();
			//driver.navigate().forward();
			//driver.navigate().to("http://www.healthcarevolunteer.com");
			//driver.navigate().refresh();
		}
		
		//Implicit wait
		public static void implicitwait(int seconds) {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		}
		
		// Explicit wait:
		public static void waitUntilElementVisible(WebElement element, int seconds) {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public static void waitUntilElementClickable(WebElement element, int seconds) {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public static void pageloadTimeout(int seconds) {
			driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		}
		//Storage commands: return a value
		public static String gettitle() {
			return driver.getTitle();
		}
		public static String getURL() {
			return driver.getCurrentUrl();
		}
		// text or label or link
		public static String gettext(WebElement element) {
			return element.getText();
		}
		// button label, checkbox and radio value, entered data in edit field
		public static String getvalue(WebElement element) {
			return element.getAttribute("value");
		}
		//tooltip :
		public static String gettooltip(WebElement element) {
			return element.getAttribute("title");
		}
		// capture dropown options
		public static String getDropdownValue(WebElement element) {
			return new Select(element).getFirstSelectedOption().getText();
		}
		
		// all values in dropdown
		public static List<WebElement> getAllDropdownValue(WebElement element) {
			return new Select(element).getOptions();
		}
		
		// boolean statements:
		public static boolean isElementDisplayed(WebElement element) {
			try {
				element.isDisplayed();
				//element.isSelected(); // checkbox
				//element.isEnabled();  // input fields
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		
		//pop exist:
		public static boolean isAlertPresent() {
			try {
				Alert popup = driver.switchTo().alert();
				return true;
			}catch (Exception e) {
				return false;
			}
		}
		// Excel connection:
		
		public static String getdata(String sheet,int row, int col) {
			
			String result = null;
			//XLSX : XSSF
			// XLS : HSSF
			try {
				FileInputStream fis = new FileInputStream(Filepath.excelpath);
				XSSFWorkbook w = new XSSFWorkbook(fis);
				XSSFSheet s = w.getSheet(sheet);
				XSSFRow r = s.getRow(row);
				XSSFCell c = r.getCell(col);
				
				if (c!=null) {
					result = c.toString();
				}
			}catch (Exception e) {
				result = "";
			}
		return result;
			
		}
		
		public static int totalRows(String sheet) throws IOException {
			FileInputStream fis = new FileInputStream(Filepath.excelpath);
			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet(sheet);
			return s.getLastRowNum();
		}
		
		public static int totalCols(String sheet) throws IOException {
			FileInputStream fis = new FileInputStream(Filepath.excelpath);
			XSSFWorkbook w = new XSSFWorkbook(fis);
			XSSFSheet s = w.getSheet(sheet);
			XSSFRow r = s.getRow(0);
			return r.getLastCellNum();
		}
		// advance topics
		// mouse actions
		
		public static void mouseHover(WebElement element){
			Actions mouse = new Actions(driver);
			mouse.moveToElement(element).build().perform();
			// mouse click
			// mouse.click(element).build().perform();
			// double click
			//mouse.doubleClick(element).buil.perform();
			// right click
			// mouse.contextClick(element).build().perform();
			// drag and drop 
			// mouse.dragAndDrop(element,element2).build().perform();
		}
		
		// keyboard operations
		public static void keyStrokes(WebElement element, Keys key){
			element.sendKeys(key);
			// ex. keys.TAB, keys.ESCAPE
		}
		
		// switchwindow
		public static void switchWindow(){
			for(String childwindow:driver.getWindowHandles()){
				driver.switchTo().window(childwindow);
			}
		}
		
		// Iframe handling
		public static void switchToFrame(WebElement element){
			driver.switchTo().frame(element);
			//driver.switchTo().frame("name");
			//driver.switchTo().frame(1);
		}
		
		public static void comeOutOfFrame(){
			driver.switchTo().defaultContent();
		}
		
		public static void openBrowserGrid(String browsername) throws MalformedURLException
		{
		DesiredCapabilities capability = null;
		if(browsername.equalsIgnoreCase("chrome"))
			//DesiredCapabilities capability = null;capability
		{
			System.out.println("Chrome");
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.out.println("Firefox");
			capability=DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		}
		if(browsername.equalsIgnoreCase("Iexplorer"))
		{
			System.out.println("iexplorer");
			capability=DesiredCapabilities.internetExplorer();
			capability.setCapability("ignoreZoomSetting", true);
			capability.setBrowserName("iexplorer");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
		}
		driver= new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"),capability);
			driver.get("http://www.healthcarevolunteer.com");
		}
		}
		
	

