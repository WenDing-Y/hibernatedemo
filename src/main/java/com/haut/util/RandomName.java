package com.haut.util;

import java.util.Random;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
public class RandomName {
    public static String getRandomString(int length) {
        Random random = new Random();
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
