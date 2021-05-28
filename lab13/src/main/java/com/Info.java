package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Info {

    public static void getInfo(Locale locale) {
        try {
            System.out.println("Country:" + locale.getCountry());
            System.out.println("Language:" + locale.getLanguage());
            System.out.println("Currency:" + Currency.getInstance(locale));

            WeekFields wf = WeekFields.of(locale);
            DayOfWeek day = wf.getFirstDayOfWeek();
            System.out.print("Week days: ");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                System.out.print(day.getDisplayName(TextStyle.FULL, locale) + "  ");
                day = day.plus(1);
            }
            System.out.println();
            Month month = Month.of(1);
            System.out.print("Months: ");
            for (int i = 2; i < Month.values().length; i++) {
                System.out.print(month.getDisplayName(TextStyle.FULL, locale) + " ");
                month = month.plus(1);
            }
            System.out.println();
            Date today = new Date();
            System.out.println(SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, locale).format(today));
        }catch (Exception e){
            System.out.println("Invalid entry");
        }
    }
}
