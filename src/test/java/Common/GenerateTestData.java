package Common;

import com.github.javafaker.Faker;

public class GenerateTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String jobTime = faker.job().position();
    public static String cityName = faker.address().cityName();
    public static String stationName = cityName + " Test Station";
    public static String externalID = generateExternalID(cityName);
    private static final String latitudeStr = faker.address().latitude().replace(",", ".");
    //public static Float latitude = Float.parseFloat(latitudeStr);
    public static String latitude = latitudeStr;

    public static String address = faker.address().fullAddress();
    private static final String longitudeStr = faker.address().latitude().replace(",", ".");
   // public static float longitude = Float.parseFloat(longitudeStr);
    public static String longitude = longitudeStr;

    public static int altitude = generateRandomAltitude();



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

        return firstLetters.toString().toUpperCase() + "_TEST" + (generateRandomNumber());

    }
    private static int generateRandomAltitude() {

        return (faker.number().numberBetween(-500, 8001));
    }




}
