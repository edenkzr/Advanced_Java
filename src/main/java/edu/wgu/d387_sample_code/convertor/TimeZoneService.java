package edu.wgu.d387_sample_code.convertor;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeZoneService {
    public ZoneId zEastern=ZoneId.of("America/New_York");
    public ZoneId zPacific=ZoneId.of("America/Denver");
    public ZoneId zUTC=ZoneId.of("UTC");
    ZoneId zoneDefault=ZoneId.systemDefault();

   public String parseTimeZone(int tz) {
       String timeZone;
       String format;
        if (tz == 1) {
            format = getTimeZoneService(zEastern);
            timeZone = "Eastern Time: " + format;
        } else if ( tz == 2 ) {
            format = getTimeZoneService(zPacific);
            timeZone = "Pacific time: " + format;
        } else {
            format = getTimeZoneService(zUTC);
            timeZone = "UTC time: " + format;
        }

        return timeZone;

    }

    public String getTimeZoneService(ZoneId zone){

        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneDefault);
        ZonedDateTime zonedDateTimeConvert=zonedDateTime.withZoneSameInstant(zone);
        LocalDateTime localDateTimeConverted=zonedDateTimeConvert.toLocalDateTime();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm a");
        String formattedTime = localDateTimeConverted.format(formatter);
        System.out.println(formattedTime);
        return formattedTime;

}
        /*LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("local time "+localDateTime.toString());
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        System.out.println("Eastern time "+localDateTimeEastern.toString());
        ZonedDateTime zonedDateTimePacific=zonedDateTime.withZoneSameInstant(zPacific);
        LocalDateTime localDateTimePacific=zonedDateTimePacific.toLocalDateTime();
        System.out.println("Pacific time "+localDateTimePacific.toString());
        ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeutc =zonedDateTimeUTC.toLocalDateTime();
        System.out.println("UTC time"+ localDateTimeutc.toString());*/

    /*if ( zoneId.equals(zEastern)) {
        timeZone= "Eastern Time: " + formattedTime;
    } else if ( zoneId.equals(zPacific) ) {
        timeZone= "Pacific Time: " + formattedTime;
    } else {
        timeZone= "UTC Time: " + formattedTime;
    }*/
}
