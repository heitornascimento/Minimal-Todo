package com.example.avjindersinghsekhon.minimaltodo.Utility;

public class DateUtils {

    public static String parseDate(final String s) {
        String[] array = s.split("T");
        return array[0];
    }
}
