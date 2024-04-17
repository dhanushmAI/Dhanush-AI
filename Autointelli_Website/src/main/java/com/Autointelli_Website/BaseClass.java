package com.Autointelli_Website;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Select select;
	public static Actions actions;
	public static Robot robot;
	public static Alert alert;
	public static JavascriptExecutor js;

	public static WebDriver browserSetup(String name) {
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		options.addArguments("--disable-save-password-bubble");		
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		options.setExperimentalOption("prefs", prefs);
		
		if(name.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		}else if(name.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(name.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		return driver;
	}
	public static void install() {
		WebDriverManager.chromedriver().setup();
	}
	
	public static void backtab() {
		driver.navigate().back();
	}
	
	public static void Forwardtab() {
		driver.navigate().forward();
	}

	public static WebDriver urlLaunch(String url) {
		driver.get(url);
		return driver;
	}
	
	public static WebElement findElement(String path) {
		   return driver.findElement(By.xpath(path));
	}
	
	public static void timeStamp(String path) throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString().replace(":", " ").replace(" ", "");
		File Checkout = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Checkout, new File (path+timestamp+".jpg"));
	}
	
	public static void screenShot(String filename,String saveLocation) throws Throwable {
		TakesScreenshot ts  = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			String destination = saveLocation+ File.separator + filename + ".png";
			FileUtils.copyFile(src, new File(destination));
		}catch(IOException e) {
			System.err.println("Failed to Capture Screenshot: " + e.getMessage());
		}
	}

	public static void sleep(long i) throws InterruptedException {
		Thread.sleep(i);
	}
	
	public static WebDriver implicitlyWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebElement explicitWait(WebElement element,Duration timeoutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
		return wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static WebDriver maxWindow() {
		driver.manage().window().maximize();
		return driver;
	}

	public static WebElement sendKeys(WebElement element, String input) {
		element.sendKeys(input);
		return element;
	}

	public static void click(WebElement click) {
		click.click();
	}

	public static WebElement visibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
		return element;
	}
	
	public static WebElement byIndex(WebElement element, int ref) {
		select = new Select(element);
		select.selectByIndex(ref);
		return element;
	}
	
	public static WebElement byValue(WebElement element, String text) {
		select = new Select(element);
		select.selectByValue(text);
		return element;
	}

	public static void textAtt(String type, WebElement getatt) {
		type = getatt.getAttribute("value");
	}

	public static WebDriver getTitle() {
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		return driver;
	}

	public static WebDriver currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("URL: " + currentUrl);
		return driver;
	}

	public static WebDriver quit() {
		driver.quit();
		return driver;
	}

	public static WebDriver CloseBrowser() {
		driver.close();
		return driver;
	}

	public static void moveToElement( WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public static void dragDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public static void downkey(String key) {
		actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	public static void upkey(String key2) {
		actions = new Actions(driver);
		actions.keyUp(key2).perform();
	}

	public static void doubleClick(WebElement target) {
		actions = new Actions(driver);
		actions.doubleClick(target).perform();
	}

	public static void rightclick(WebElement target) {
		actions = new Actions(driver);
		actions.contextClick(target).perform();
	}

	public static void Enter() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void copy() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);

	}

	public static void paste() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

	}

	public static void cut() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);

	}

	public static void down() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

	}

	public static void up() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);

	}

	public static void accept(WebDriver webref) {
		alert = webref.switchTo().alert();
		alert.accept();

	}

	public static void dismiss() {
		alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public static void ismultiple(WebElement webe) {
		select = new Select(webe);
		select.isMultiple();

	}

	public static void getoptions(WebElement element) {
		select = new Select(element);
		select.getOptions();

	}

	public static void firstselected(WebElement element) {
		select = new Select(element);
		select.getFirstSelectedOption();
		
	}

	public static void Allselected(WebElement element) {
		select = new Select(element);
		select.getAllSelectedOptions();

	}
	
	public static void deselectIndex(WebElement element,int ref) {
		select = new Select(element);
		select.deselectByIndex(ref);
		
	}
	
	public static void deselectvalue(WebElement element,String ref) {
		select = new Select(element);
		select.deselectByValue(ref);
		
	}
	
	public static void deselectVisibleText(WebElement element,String ref) {
		select=new Select(element);
		select.deselectByVisibleText(ref);
		
	}
	
	public static void deselectAll(WebElement element) {
		select=new Select(element);
		select.deselectAll();
		
	}
	
	public static void print(String text) {
		System.out.println(text);
	}
}

