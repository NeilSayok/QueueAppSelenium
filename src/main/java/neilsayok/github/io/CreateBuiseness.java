package neilsayok.github.io;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static neilsayok.github.io.Main.driverPath;

public class CreateBuiseness {
    Faker faker;
    WebDriver driver;

    WebElement bName;
    WebElement bAddress;
    WebElement openTime;
    WebElement closeTime;
    Map<Integer, String> radioXpaths;
    DateTimeFormatter timeFormatter;
    DateTimeFormatter am_pmformatter;


    public CreateBuiseness() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        faker = new Faker();

        timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        am_pmformatter = DateTimeFormatter.ofPattern("a");


        setWebElement();
        init();
    }

    private void setWebElement() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://queueapp-64877.firebaseapp.com/business");

        bName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/input"));
        bAddress = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/input"));
        openTime = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]/input"));
        closeTime = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/input"));

        radioXpaths = new HashMap<>();

        radioXpaths.put(1, "/html/body/div[1]/div/div/div[4]/div/div[1]/input");
        radioXpaths.put(2, "/html/body/div[1]/div/div/div[4]/div/div[2]/input");
        radioXpaths.put(3, "/html/body/div[1]/div/div/div[4]/div/div[3]/input");
        radioXpaths.put(4, "/html/body/div[1]/div/div/div[4]/div/div[4]/input");
        radioXpaths.put(5, "/html/body/div[1]/div/div/div[4]/div/div[5]/input");
        radioXpaths.put(6, "/html/body/div[1]/div/div/div[4]/div/div[6]/input");

    }



    public void init() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        bAddress.sendKeys(faker.address().streetAddress());

        Random random = new Random();

        LocalDateTime time = LocalDateTime.of(LocalDate.now(),
                LocalTime.of(random.nextInt(24),
                        random.nextInt(60),
                        random.nextInt(60),
                        random.nextInt(999999999 + 1)
                )
        );
        LocalDateTime endTime = time.plusHours(ThreadLocalRandom.current().nextInt(2, 8 + 1));


        openTime.sendKeys("value", timeFormatter.format(time));
        openTime.sendKeys(String.valueOf(am_pmformatter.format(time).charAt(0)));

        closeTime.sendKeys("value", timeFormatter.format(endTime));
        closeTime.sendKeys(String.valueOf(am_pmformatter.format(endTime).charAt(0)));


        int selectedRadio = ThreadLocalRandom.current().nextInt(1, 6 + 1);


        driver.findElement(By.xpath(radioXpaths.get(selectedRadio))).click();

        int selectedSubRadio;
        Map<Integer, String> subRadioPaths;


        switch (selectedRadio) {
            case 1:
                bName.sendKeys(faker.name().firstName()+" Resturant");
                subRadioPaths = new HashMap<>();
                subRadioPaths.put(1, "/html/body/div[1]/div/div/div[4]/div/div[1]/div/input[1]");
                subRadioPaths.put(2, "/html/body/div[1]/div/div/div[4]/div/div[1]/div/input[2]");
                subRadioPaths.put(3, "/html/body/div[1]/div/div/div[4]/div/div[1]/div/input[3]");
                selectedSubRadio = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                driver.findElement(By.xpath(subRadioPaths.get(selectedSubRadio))).click();
                break;
            case 2:
                bName.sendKeys(faker.name().firstName()+" Bank");
                break;
            case 3:
                bName.sendKeys(faker.name().firstName()+" Grocery");
                break;
            case 4:
                bName.sendKeys(faker.name().firstName()+" Medical");

                subRadioPaths = new HashMap<>();
                subRadioPaths.put(1, "/html/body/div[1]/div/div/div[4]/div/div[4]/div/input[1]");
                subRadioPaths.put(2, "/html/body/div[1]/div/div/div[4]/div/div[4]/div/input[2]");
                subRadioPaths.put(3, "/html/body/div[1]/div/div/div[4]/div/div[4]/div/input[3]");
                subRadioPaths.put(4, "/html/body/div[1]/div/div/div[4]/div/div[4]/div/input[4]");
                selectedSubRadio = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                driver.findElement(By.xpath(subRadioPaths.get(selectedSubRadio))).click();
                break;
            case 5:
                bName.sendKeys(faker.name().firstName()+" Store");

                subRadioPaths = new HashMap<>();
                subRadioPaths.put(1, "/html/body/div[1]/div/div/div[4]/div/div[5]/div/input[1]");
                subRadioPaths.put(2, "/html/body/div[1]/div/div/div[4]/div/div[5]/div/input[2]");
                subRadioPaths.put(3, "/html/body/div[1]/div/div/div[4]/div/div[5]/div/input[3]");
                selectedSubRadio = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                driver.findElement(By.xpath(subRadioPaths.get(selectedSubRadio))).click();
                break;
            case 6:
                bName.sendKeys(faker.name().firstName()+" Shop");
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div[6]/div/textarea"))
                        .sendKeys("Some Shop Type");
                break;
        }

        driver.findElement(By.xpath("/html/body/div[1]/div/div/button")).click();
        driver.switchTo().alert().accept();
        driver.navigate().refresh();
    }




}
