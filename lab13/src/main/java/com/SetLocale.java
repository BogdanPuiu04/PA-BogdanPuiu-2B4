package com;

import java.util.Locale;

public class SetLocale {

    public static void setLocale(String locale){
        Locale newLocale=Locale.forLanguageTag(locale);
        Locale.setDefault(newLocale);
    }
}
