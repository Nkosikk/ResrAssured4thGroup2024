package Common;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String jobTime = faker.job().position();

    public static String stationName = faker.address().cityName() + " Test Station";


    public static String externalID = "_"  ;


    public static String latitude = faker.address().latitude();

    public static String longitude = faker.address().longitude();

    //public static String altitude = faker.address();



    //public static String externalID =


    @Test
    public void display(){
        System.out.println(stationName);
    }

}
