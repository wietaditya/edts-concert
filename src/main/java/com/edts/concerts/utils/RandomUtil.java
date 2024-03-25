package com.edts.concerts.utils;

import java.util.Random;

public class RandomUtil {

    public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String digits = "0123456789";
    public static final String alphanum = alphabet + digits;

    public static String generateRandomAlphanumeric(Integer length) {
        char[] symbols;

        symbols = alphanum.toCharArray();

        Random random = new Random();
        char[] buf;
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];


        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

}
