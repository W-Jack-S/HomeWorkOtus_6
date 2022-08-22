package pagesObjects;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RandomGen {
    public static int day, year, mon;
    public static String smon, sday;
    public WebDriver driver;

    public RandomGen(WebDriver driver){
        this.driver = driver;
    }

    public String genBirth() {
        Random random = new Random();
        int minYear = 1980;
        int maxYear = 2005;
        int diffYear = maxYear - minYear;
        year = random.nextInt(diffYear + 1) + minYear;
        mon = random.nextInt(11) + 1;
        switch (mon) {
            case 2:
                day = random.nextInt(27) + 1;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = random.nextInt(30) + 1;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = random.nextInt(29) + 1;
                break;
        }
        if (mon < 10) smon = "0" + Integer.toString(mon);
        else smon = Integer.toString(mon);

        if (day < 10) sday = "0" + Integer.toString(day);
        else sday = Integer.toString(day);

        return sday + "." + smon + "." + year;
    }
}
