package utils;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Locale;


public class DataUtils {

    public static String getLastName() {
        return new Faker(new Locale("ru")).name().lastName();
    }

    public static String getFirstName() {
        return new Faker(new Locale("ru")).name().firstName();
    }

    public static String getUserNumber() {
        return String.valueOf(new Faker(new Locale("ru")).phoneNumber());
    }

    public static String getEmail() {
        return new Faker(new Locale("ru")).internet().emailAddress();
    }

    public static String getDay() {
        return String.valueOf(new Faker().date().birthday().getDate());
    }
    public static String getMonth() {
        int month = new Faker().date().birthday().getMonth();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

    }
    public static String getYear() {
        return String.valueOf(new Faker().date().birthday().getYear() + 1900);
    }

    public static void main(String[] args) {
        System.out.println(getDay());
    }


//                .setGender("Male")
//                .setBirthDate("December", "9", "2003")
//                .setSubject("Chemistry")
//                .setSubject("Maths")
//                .setHobbies("Reading")
//                .setHobbies("Music")
//                .uploadFile("image.jpg")
//                .enterAddress("Beverly Hills, 90210")
//                .enterState("NCR")
//                .enterCity("Delhi")
}
