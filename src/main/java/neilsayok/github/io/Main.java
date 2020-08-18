package neilsayok.github.io;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    static String driverPath = "F:\\Java\\Projects\\QueueApp\\SeleniumTest1\\src\\chromedriver.exe";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://queueapp-64877.firebaseapp.com/business");

        WebElement bName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/input"));
        WebElement bAddress = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/input"));
        WebElement openTime = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/input"));
        WebElement closeTime = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/input"));

        bName.sendKeys("My Buiseness");
        bAddress.sendKeys("Some Address");
        openTime.sendKeys("value","02:20");
        //openTime.sendKeys("02:20");
        //AM PM not Setting

        closeTime.sendKeys("value","15:25");
        //driver.findElement(By.id("open")).setAttribute("value", "your value");




    }




}
