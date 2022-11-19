import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now(); //current date
        LocalDate someDate = LocalDate.of(2022, 11, 19); //a specific date
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now(); //current time
        LocalTime noon = LocalTime.NOON; //this is a constant
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now(); //current date time
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); //formats the date and time
        String formattedDate = localDateTime.format(dateTimeFormatter);
        System.out.println(formattedDate);
    }
}
