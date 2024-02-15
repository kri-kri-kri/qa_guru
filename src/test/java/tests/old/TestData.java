package tests.old;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String
            email = faker.internet().emailAddress(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = faker.options().option("Male", "Female", "Other"),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d",faker.number().numberBetween(1,28)),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1976,2015)),
            subject = faker.options().option("Math", "English", "Computer science", "Commerce"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().streetAddress(),
            picture = faker.options().option("image.jpg", "image2.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getCity(state);

    public String getCity(String state) {

        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}