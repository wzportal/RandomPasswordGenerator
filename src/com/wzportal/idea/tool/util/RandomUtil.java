package com.wzportal.idea.tool.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RandomUtil {

    private static final char[] SPECIAL_CHAR = {'!', '@', '#', '$', '&', '%', '*'};

    public static String random(boolean upper, boolean lower, boolean num, boolean spec, int size) {
        if (!upper && !lower && !num && !spec) {
            return "";
        }
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
        random.nextInt();
        int i = 1;

        StringBuilder sb = new StringBuilder();
        if (upper) {
            sb.append((char) (random.nextInt(26) + 65));
            sb.append((char) (random.nextInt(26) + 65));
            i++;
            i++;
        }
        if (lower) {
            sb.append((char) (random.nextInt(26) + 97));
            i++;
        }
        if (num) {
            sb.append(random.nextInt(10));
            i++;
        }
        if (spec) {
            sb.append(SPECIAL_CHAR[random.nextInt(SPECIAL_CHAR.length)]);
            i++;
        }

        while (true) {
            if (i >= size) {
                break;
            }
            if (upper && random.nextBoolean()) {
                sb.append((char) (random.nextInt(26) + 65));
                i++;
            }
            if (i >= size) {
                break;
            }
            if (lower && random.nextBoolean()) {
                sb.append((char) (random.nextInt(26) + 97));
                i++;
            }
            if (i >= size) {
                break;
            }
            if (num && random.nextBoolean()) {
                sb.append(random.nextInt(10));
                i++;
            }
            if (i >= size) {
                break;
            }
            if (spec && random.nextBoolean()) {
                sb.append(SPECIAL_CHAR[random.nextInt(SPECIAL_CHAR.length)]);
                i++;
            }
        }
        return sb.toString();
    }
}
