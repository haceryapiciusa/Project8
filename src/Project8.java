import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Project8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "/Users/haceryapici/Desktop/Selenyum/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Click on setup

        driver.findElement(By.xpath("//span[@class='nav-link-title ng-tns-c27-13 ng-star-inserted']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Click on parameters

        driver.findElement(By.xpath("//span[@class='nav-link-title ng-tns-c27-14 ng-star-inserted']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Click on Nationalities

        driver.findElement(By.xpath("//span[contains(text(),'Nationalities')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Click on plus icon

        driver.findElement(By.xpath("//button[@class='mat-mini-fab mat-button-base mat-accent']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Type the name of the Nationality

        WebElement nationality = driver.findElement(By.cssSelector("input#ms-text-field-1"));
        nationality.click();
        nationality.sendKeys("Hacer");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted']")).click();

        //Click on edit

        WebElement nation = driver.findElement(By.xpath("//*[contains(text(),'Hacer')]"));
        nation.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement edit=driver.findElement(By.xpath("//input[@ id='ms-text-field-2']"));
        edit.clear();
        edit.sendKeys("Hacer12");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted']")).click();
        Thread.sleep(5000);
        //Click on delete button
        driver.findElement(By.xpath("//*[contains(text(),'Hacer12')]")).findElement(By.xpath("//button[@class='mat-button mat-button-base mat-warn ng-star-inserted']")).click();

        //Click on yes
        driver.findElement(By.xpath("//button[@class='mat-button mat-raised-button mat-button-base mat-accent']")).click();
        Thread.sleep(5000);
        //========> Verify nationality is removed

        WebDriverWait wait = new WebDriverWait( driver, 15 );
        try {
            wait.until( ExpectedConditions.numberOfElementsToBe( By.xpath( "//tbody//tr" ), 0)  );
            System.out.println("Delete verified!");
        } catch (Exception e){
            System.out.println("Failure!");
        }

        driver.quit();


    }
}
