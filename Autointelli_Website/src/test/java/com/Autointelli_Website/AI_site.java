package com.Autointelli_Website;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AI_site extends BaseClass{
	
public static void main(String[]arg) throws Throwable {
	browserSetup("chrome");
	urlLaunch("https://dev.autointelli.com/#/login");
	sleep(3000);
	FileInputStream fis = new FileInputStream("C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Autointelli login user and pass edited.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	int rowcount = sheet.getLastRowNum();
	int cellcount = sheet.getRow(1).getLastCellNum();
	System.out.println("rowcount :"+rowcount+"cellcount :"+cellcount);
	
	for(int i=1;i<=rowcount;i++){
		XSSFRow celldata=sheet.getRow(i);
		if (celldata != null) {
            //break;
        //}
		
		String username=celldata.getCell(0).getStringCellValue();
		String password=celldata.getCell(1).getStringCellValue();
		
		sleep(3000);
		findElement("//input[@id='txtusername']").clear();
		findElement("//input[@id='txtusername']").sendKeys(username);
		
		sleep(3000);
		findElement("//input[@id='txtpassword']").clear();
		findElement("//input[@id='txtpassword']").sendKeys(password);
		
		System.out.println(i+"."+username+" || "+password);
	
		findElement("//button[@id='btnlogin']").click();
	    }
	}

	workbook.close();
	
	sleep(3000);
	WebElement analytics = findElement("//a[@href='#/dashboard']");
	click(analytics);
	
	WebElement executivesummary = findElement("//a[@id='analytics-tab-1']");
	click(executivesummary);
	sleep(3000);
	screenShot("executivesummary", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\1.Analytics");
	
	WebElement eventanalytics = findElement("//a[@id='analytics-tab-2']");
	click(eventanalytics);
	sleep(3000);
	screenShot("eventanalytics", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\1.Analytics");
	
	WebElement eventmanagement = findElement("//a[text()='Event Management']");
	click(eventmanagement);
	sleep(3000);
	screenShot("Alerts", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\2.Event Management");
	
	WebElement events = findElement("//a[@id='Evm_tab_events']");
	click(events);
	sleep(3000);
	screenShot("Events", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\2.Event Management");
	
	WebElement filters = findElement("//a[@id='Evm_tab_filters']");
	click(filters);
	sleep(3000);
	screenShot("Filters", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\2.Event Management");
	
	WebElement sop = findElement("//a[@id='Evm_tab_sop']");
	click(sop);
	sleep(3000);
	screenShot("SOP", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\2.Event Management");
	
	WebElement automation = findElement("//a[text()='Automation']");
	click(automation);
	implicitlyWait(10);
	screenShot("Dashboard", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\3.Automation");
	
	WebElement catalog = findElement("//a[@id='deployment_tab_1']");
	click(catalog);
	sleep(3000);
	screenShot("Catalog", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\3.Automation");
	
	//WebElement designer = findElement("//a[@id='workflow_tab_1']");
	//click(designer);
	//sleep(3000);
	//screenShot("designer", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\3.Automation");
	
	WebElement review = findElement("//a[@id='review_tab_1']");
	click(review);
	sleep(3000);
	screenShot("Review", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\3.Automation");
	
	WebElement reports = findElement("//a[@id='reports_tab_1']");
	click(reports);
	implicitlyWait(10);
	WebElement startdate = findElement("//input[@id='txtarstartdate']");
	sendKeys(startdate, "2024-01-01");
	WebElement enddate = findElement("//input[@id='txtarendate']");
	sendKeys(enddate, "2024-03-31");
	WebElement get = findElement("//button[text()='Get']");
	click(get);
	
	sleep(3000);
	screenShot("Reports", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\3.Automation");
	
	WebElement hddm = findElement("//a[text()='HDDM']");
	click(hddm);
	sleep(3000);
	screenShot("CredStore", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\4.HDDM");
	
	WebElement discovery = findElement("//a[@id='hddm_discovery_tab']");
	click(discovery);
	sleep(3000);
	screenShot("Discovery", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\4.HDDM");
	
	WebElement machine = findElement("//a[@id='hddm_machine_tab']");
	click(machine);
	sleep(3000);
	screenShot("Machine", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\4.HDDM");
	
	WebElement group = findElement("//a[@id='hddm_group_tab']");
	click(group);
	sleep(3000);
	screenShot("Group", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\4.HDDM");
	
	WebElement admin = findElement("//a[text()='Admin']");
	click(admin);
	sleep(3000);
	screenShot("Admin", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	
	WebElement users = findElement("//i[@title='Users']");
	click(users);
	sleep(3000);
	screenShot("user", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	WebElement Roles = findElement("//i[@title='Roles']");
	click(Roles);
	sleep(3000);
	screenShot("Roles", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	//WebElement SMTP = findElement("//i[@title='SMTP']");
	//click(SMTP);
	//sleep(20000);
	//screenShot("SMTP", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	//WebElement LDAP = findElement("//i[@title='LDAP']");
	//click(LDAP);
	//sleep(20000);
	//screenShot("LDAP", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	//WebElement PolicyEngine = findElement("//i[@title='Policy Engine']");
	//click(PolicyEngine);
	//sleep(20000);
	//screenShot("Policy Engine", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	//WebElement PAM = findElement("//i[@title='ARCON']");
	//click(PAM);
	//sleep(10000);
	//screenShot("PAM", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	//WebElement Licence = findElement("//i[@title='Licence']");
	//click(Licence);
	//sleep(3000);
	//screenShot("Licence", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	WebElement EmailTemplate = findElement("//i[@title='Email Template']");
	click(EmailTemplate);
	sleep(3000);
	screenShot("Email Template", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	WebElement ServiceManager = findElement("//i[@title='Service Manager']");
	click(ServiceManager);
	sleep(3000);
	screenShot("Service Manager", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	WebElement Slack = findElement("//i[@title='Slack']");
	click(Slack);
	sleep(3000);
	screenShot("Slack", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	//WebElement Jira = findElement("//div[@title='Jira']");
	//click(Jira);
	//sleep(3000);
	//screenShot("Jira", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	//backtab();
	
	WebElement DayLight = findElement("//div[@title='Day Light']");
	click(DayLight);
	sleep(3000);
	screenShot("Day Light", "C:\\Users\\Autointelli\\eclipse-workspace2\\Autointelli_Website\\Screenshot\\5.Admin");
	backtab();
	
	WebElement LogoutOpt = findElement("//span[@class='ng-binding']");
	click(LogoutOpt);
	sleep(3000);
	WebElement Logout = findElement("//a[@href='#/logout']");
	click(Logout);
	
	sleep(5000);
	//driver.quit();
	System.out.println("Executed successfully");
}
}
