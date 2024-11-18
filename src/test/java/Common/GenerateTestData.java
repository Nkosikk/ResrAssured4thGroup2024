package Common;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String jobTime = faker.job().position();

}
