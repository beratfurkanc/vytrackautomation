package com.vytrack.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MethodUtils {
    public static String getNextDate(String currentDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        LocalDate date1 = LocalDate.parse(currentDate,formatter);
        date1= date1.plusDays(1);
        return date1.format(DateTimeFormatter.ofPattern("MMM d, YYYY"));
    }
}
