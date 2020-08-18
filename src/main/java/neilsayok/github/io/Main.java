package neilsayok.github.io;

public class Main {

    static final String driverPath = "F:\\Java\\Projects\\QueueApp\\SeleniumTest1\\src\\chromedriver.exe";

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("Inserting business: " + (i + 1));
                new CreateBuiseness();
            } catch (Exception e) {
                System.out.println("Error Inserting business: " + (i + 1));
                e.printStackTrace();
            }
        }


    }


}
