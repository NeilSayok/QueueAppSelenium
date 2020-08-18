package neilsayok.github.io;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static final String driverPath = "F:\\Java\\Projects\\QueueApp\\SeleniumTest1\\src\\chromedriver.exe";

    public static void main(String[] args) {

        CreateBuiseness createBuiseness = new CreateBuiseness();

        for (int i = 0; i < 3;i++){
            try {
                new CreateBuiseness();

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}
