package FunctionalTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FunctionalTestCase {
	
	WebDriver driver = new ChromeDriver();
	
  @Test
  public void f() throws InterruptedException, IOException {
	  driver.get("https://demo.dealsdray.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@id='mui-1']")).sendKeys("prexo.mis@dealsdray.com");
	  driver.findElement(By.xpath("//input[@id='mui-2']")).sendKeys("prexo.mis@dealsdray.com");
	  driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	  
	  driver.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem css-46up3a']")).click();
	  driver.findElement(By.xpath("//a[@href='/mis/orders']//button[@name='child']")).click();
	  driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']")).click();
	  
	  driver.findElement(By.xpath("//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-uodm64']//input")).sendKeys(System.getProperty("user.dir")+"\\test data\\demo-data.xlsx");
	  driver.findElement(By.xpath("//button[normalize-space()='Import']")).click();
	  driver.findElement(By.xpath("//button[normalize-space()='Validate Data']")).click();
	  Thread.sleep(3000);
	  
	  Alert myAlert = driver.switchTo().alert();
	  myAlert.accept();
	  
	  driver.findElement(By.xpath("//span[@class='material-icons notranslate MuiIcon-root MuiIcon-fontSizeMedium css-1jgtvd5']")).click();
	  
	  File loca = new File(System.getProperty("user.dir")+"\\screenshots\\imagesFunctionalTest\\img.png");
	  Screenshot fullpage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
	  ImageIO.write(fullpage.getImage(), "png", loca);
	  Thread.sleep(2000);
	  
	  driver.quit();
	  
  }
}
