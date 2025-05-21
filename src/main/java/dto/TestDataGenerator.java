package dto;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;

public class TestDataGenerator {
    private static Faker faker = new Faker();
    private String name = faker.name().fullName();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password(10, 16, true, true, true);
    private String confirmPassword = faker.internet().password(10, 16, true, true, true);
    private LocalDate date = faker.date().birthday(18, 65).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    private int languageLvl = faker.number().numberBetween(1, 4);



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean randomTrue() {
        if (faker.random().nextBoolean()) {
            return true;
        }
            return false;
    }

    public int getLanguageLvl() {
        return languageLvl;
    }
}
