# Date

````java
package uz.pdp.workingwithtime.legacyapi;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {

        /*Date currentDate = new Date(System.currentTimeMillis());
        // currentDate.setTime(2600000000000L); // the epoch // 1970-01-01 00:00
        // System.out.println(currentDate);
        Date blockedTill = new Date(System.currentTimeMillis() + 20 * 60 * 1000);
        System.out.println(currentDate);
        System.out.println(blockedTill);
        if ( blockedTill.after(currentDate) )
            System.out.println("You are block for 20 minutes");
        else
            System.out.println("Welcome");*/

        // ---------------------------------------------------
        // Date date = new Date(1_000_000_000L);
        Date date1 = new Date(0,0,1); // 1900
        System.out.println(date1);
    }
}
````
````java
package uz.pdp.workingwithtime.legacyapi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExample {
    public static void main(String[] args) {
        // Calendar calendar = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        System.out.println(time);
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));
        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        calendar.setLenient(false);
        // calendar.add(Calendar.DATE,25);
        calendar.set(Calendar.DATE, 5);
        // calendar.roll(Calendar.DATE, 45);
        System.out.println(calendar.getTime());

    }
}
````
````java
package uz.pdp.workingwithtime.legacyapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatExample {
    public static void main(String[] args) throws ParseException {
        // format();
        // parse();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
        String formattedDate = "23011995";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for ( int i = 0; i < 40; i++ ) {
            executorService.execute(() -> {
                try {
                    System.out.println(simpleDateFormat.parse(formattedDate));
                } catch (Exception e) {

                }
            });
        }
        executorService.shutdown();
    }

    private static void parse() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = "23011995";
        Date parse = simpleDateFormat.parse(formattedDate);
        System.out.println(parse);
    }

    private static void format() {
        Date date = new Date();
        System.out.println(date);
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'this is nth day of year' D HH:mm:ss:SS");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd D ''HH:mm:ss:SS''");
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate);
    }
}
````
# NEW Time API Classes

````java
package uz.pdp.workingwithtime.timeapi;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now); // Date
        System.out.println(now.getNano());
        System.out.println(now.get(ChronoField.MICRO_OF_SECOND));
        // now.isBefore()
        /*Date date = new Date();
        Instant instant = date.toInstant();*/
    }
}
````


````java
package uz.pdp.workingwithtime.timeapi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);
        System.out.println(now.isLeapYear());
        System.out.println(LocalDate.of(2024, 1, 1).isLeapYear());
        System.out.println(now.plus(1, ChronoUnit.YEARS).isLeapYear());
        System.out.println(now.plusYears(1).isLeapYear());
        System.out.println(now.get(ChronoField.DAY_OF_MONTH));
        System.out.println(LocalDate.of(1995, 10, 3).get(ChronoField.DAY_OF_YEAR));
        System.out.println(now.getDayOfMonth());
    }
}
````
````java
package uz.pdp.workingwithtime.timeapi;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
    }
}
````
````java
package uz.pdp.workingwithtime.timeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now(ZoneId.of("America/Los_Angeles")));
    }
}
````
````java
package uz.pdp.workingwithtime.timeapi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        // ZoneId.getAvailableZoneIds().forEach(System.out :: println);
    }
}

````
````java
package uz.pdp.workingwithtime.timeapi;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationExample {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(1995,1,23,6,30,10);
        LocalDateTime now = LocalDateTime.now();
        Duration between = Duration.between(time, now);
        System.out.println(between);
    }
}
````


````java
package uz.pdp.workingwithtime.timeapi;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate time = LocalDate.of(1995, 1, 23);
        LocalDate now = LocalDate.now();
        Period between = Period.between(time, now);
        System.out.println(between);
        Period period = Period.ofYears(40);
        System.out.println(period.toTotalMonths());
    }
}
````
````java
package uz.pdp.workingwithtime.timeapi;

import java.time.DayOfWeek;
import java.time.YearMonth;

public class AdditionalTypesExample {
    public static void main(String[] args) {
        for ( DayOfWeek value : DayOfWeek.values() ) {
            System.out.println(value);
        }
        YearMonth yearMonth = YearMonth.of(1995, 1);
        System.out.println(yearMonth);
    }
}
````