package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    public LocalDate getFormatDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

