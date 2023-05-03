package BaseLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_1 
{

	String excel_loc="C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\People_Grove\\Test Sheet\\ExcelSheet.xlsx";
	String path="C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\People_Grove\\chromedriver_win32\\chromedriver.exe";
	
	static public WebDriver driver;
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\People_Grove\\chromedriver_win32\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver=new ChromeDriver();
		driver.get("https://basecopy5.staging.pg-test.com/auth/sign-in");
		driver.manage().window().maximize();
		
		//Entered Login Details
		WebElement EF = driver.findElement(By.name("email"));
		EF.sendKeys("test+7@peoplegrove.com");
        WebElement pswrd = driver.findElement(By.xpath("//*[@placeholder=\"Enter your password\"]"));
        pswrd.sendKeys("Testing@123");
        WebElement SB = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        SB.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        
        //Proceeding Further
        
        WebElement career = driver.findElement(By.xpath("//*[@aria-label=\"Career\"]"));
        career.click();
        WebElement job = driver.findElement(By.xpath("//a[contains(@href, 'jobs')]"));
        job.click();
        WebElement jobs = driver.findElement(By.xpath("//div[@class='job-card__details']//a"));
        jobs.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
        //No option was visible to send text message so I directly went for inbox i.e. next step
        
        WebElement inbox = driver.findElement(By.xpath("//*[@aria-label=\"Inbox\"]"));
        inbox.click();
        WebElement type = driver.findElement(By.xpath("//*[@aria-label=\"Write a message\"]"));
        type.click();
        type.sendKeys("Vaibhav Dhasmana 02-05-2023\r\n"
        		+ "\r\n"
        		+ "Total Year of Experience:- 4.2 Yrs.");
        WebElement inboxsubmit= driver.findElement(By.xpath("//*[@class=\"ant-btn ant-btn-primary ant-btn-lg\"]"));
        inboxsubmit.click();
        
        //Checking further steps
        
        WebElement user2= driver.findElement(By.xpath("//*[@class=\"ant-btn btn-link\"]"));
        user2.click();
        WebElement Bob= driver.findElement(By.xpath("//*[@aria-label=\"Bob Beier\"]"));
        Bob.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement Adminswitch= driver.findElement(By.xpath("//*[@id=\"topHeader\"]/div/div/div[1]/div/div/span"));
        adminswitch.click();
        
        //Switching to another user(BOB)
        WebElement loginAs= driver.findElement(By.xpath("//*[@id=\"topHeader\"]/div/div/div[3]/button"));
        loginAs.click();
        
        String expectedText = "Yvonne sent you a new message today.";
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Yvonne sent you a new message today.\"]")));

        // We verify text is visible
        String visibletext = textElement.getText();
        if (visibletext.equals(expectedText)) 
        {
            System.out.println("Text is visible.");
        } 
        else
        {
            System.out.println("Text is not visible.");
        }
        
        WebElement viewmessage= driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div/div[3]/button"));
        viewmessage.click();
        
	}
}
