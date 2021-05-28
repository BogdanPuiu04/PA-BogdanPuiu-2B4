package com;

import java.util.Locale;

public class DisplayLocals {

    public static void display(){
        for(Locale locale : Locale.getAvailableLocales()){
            System.out.println(locale);
        }
    }
}
