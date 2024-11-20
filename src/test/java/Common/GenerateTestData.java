package Common;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {
    static Faker faker = new Faker();
    private static int increment = 1;

    public static String firstName = faker.name().firstName();
    public static String jobTime = faker.job().position();
    public static String cityName = faker.address().cityName();
    public static String stationName = cityName + " Test Station";
    public static String externalID = generateExternalID(cityName);
    public static String latitude = faker.address().latitude();
    public static String longitude = faker.address().longitude();
    public static int stationNumber = generateRandomNumber();

    public static String altitude = generateRandomAltitude();


    public static int generateRandomNumber() {

        return faker.number().numberBetween(111, 999);

    }

    private static String generateExternalID(String cityName) {
        String[] words = cityName.split(" ");
        StringBuilder firstLetters = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                firstLetters.append(word.charAt(0));
            }
        }

        return firstLetters.toString().toUpperCase() + "_TEST" + String.valueOf(generateRandomNumber());

    }
    private static String generateRandomAltitude() {

        int randomAltitude = faker.number().numberBetween(-500, 8001);
        return String.valueOf(randomAltitude);
    }




}
