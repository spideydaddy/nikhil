import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateDifferenceDemo {

    public static long getDaysDifference(
            LocalDate date1,
            LocalDate date2
    ) {

        return ChronoUnit.DAYS.between(date1, date2);
    }

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2024, 1, 1);

        LocalDate date2 = LocalDate.of(2024, 1, 10);

        long days = getDaysDifference(date1, date2);

        System.out.println("Difference in days: " + days);

        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("LocalDateTime: " + dateTime);

        Instant timestamp = Instant.now();

        System.out.println("Timestamp: " + timestamp);
    }
}