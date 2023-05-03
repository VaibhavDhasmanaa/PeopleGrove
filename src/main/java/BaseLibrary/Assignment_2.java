package BaseLibrary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment_2 
{
	    public static void main(String[] args) throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sarthak Dhasmana\\\\eclipse-workspace\\\\People_Grove\\\\chromedriver_win32\\\\chromedriver.exe");

	        WebDriver driver = new ChromeDriver();

	        // Login Page
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
	       
	        // Work on Career paths and click on three options
	        driver.findElement(By.linkText("Career")).click();
	        driver.findElement(By.linkText("Career Paths")).click();
	        List<WebElement> careers = driver.findElements(By.xpath("//h3[contains(text(), 'Inspiration from You')]/following-sibling::div//a"));
	        List<String> careerNames = new ArrayList<String>();
	        for (int i = 0; i < 3; i++) {
	            WebElement option = careers.get(i);
	            String name = option.getText();
	            option.click();
	            careerNames.add(name);
	        }

	        System.out.println("Career names: " + careerNames);
	        
	        
	        // Navigating to homepage 
	        driver.findElement(By.linkText("Home")).click();
	        driver.navigate().refresh();

	        // Recently viewed careers and reverse
	        List<WebElement> viewedCareers = driver.findElements(By.xpath("//div[contains(@class, 'recent-careers')]//a"));
	        List<String> viewedCareerNames = new ArrayList<String>();
	        for (WebElement career : viewedCareers) {
	            viewedCareerNames.add(career.getText());
	        }
	        Collections.reverse(viewedCareerNames);
	        System.out.println("Recently viewed careers: " + viewedCareerNames);
	    }
	}

}
