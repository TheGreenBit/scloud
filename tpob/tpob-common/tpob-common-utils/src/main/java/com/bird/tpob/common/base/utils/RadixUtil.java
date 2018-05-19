package com.bird.tpob.common.base.utils;

import it.unimi.dsi.fastutil.chars.Char2IntArrayMap;
import it.unimi.dsi.fastutil.chars.Char2IntMap;
import org.junit.Test;

import java.util.Arrays;

public class RadixUtil {
    private static final char[] MAX_RANDOM_RADIX =
            "1PqLaMzO2KwNsIxJ3BeUdHcV4YrGfCvT5FtRgDb6XEySZhWnA7uQjm8ik9ol0p".toCharArray();

    private static final char[] LOWER_RANDOM_RADIX =
            "z0vba9gtq8yhw7nms6xju5ikc4d3loe2r1fp".toCharArray();

    private static final char[] UPPER_RANDOM_RADIX =
            "Z0TYA9QMJ8WF7BGS6HNX5UIC4DKL3E2R1VOP".toCharArray();

    private static final Char2IntMap MAX_MAP = create(MAX_RANDOM_RADIX);
    private static final Char2IntMap LOWER_MAP = create(LOWER_RANDOM_RADIX);
    private static final Char2IntMap UPPER_MAP = create(UPPER_RANDOM_RADIX);


    public void duplicateCheck() {
        System.out.println(LOWER_RANDOM_RADIX.length);
        for (int i = 0; i < LOWER_RANDOM_RADIX.length - 1; i++) {
            for (int j = i + 1; j < LOWER_RANDOM_RADIX.length; j++) {
                if (LOWER_RANDOM_RADIX[j] == LOWER_RANDOM_RADIX[i]) {
                    System.out.println(LOWER_RANDOM_RADIX[i]);
                    break;
                }
            }
        }

        Arrays.sort(LOWER_RANDOM_RADIX);

        for (char c : LOWER_RANDOM_RADIX) {
            System.out.print(c);
        }
    }


    public static String radix(long i, char[] RADIX_CHARS) {
        int radix = RADIX_CHARS.length;
        StringBuilder builder = new StringBuilder();
        while (i > 0) {
            long mod = i % radix;
            builder.append(RADIX_CHARS[(int) mod]);
            i /= radix;
        }
        return builder.reverse().toString();
    }

    public static long reverseRadix(String str, char[] RADIX_CHARS) {
        return reverseRadix(str,create(RADIX_CHARS));
    }

    public static long reverseRadix(String str, Char2IntMap char2IntMap) {
        int radix = char2IntMap.size();
        char[] chars = str.toCharArray();
        long v = 0;
        for (char c : chars) {
            int i = char2IntMap.get(c);
            v = v * radix + i;
        }
        return v;
    }

    private static Char2IntMap create(char[] RADIX_CHARS) {
        Char2IntMap char2IntArrayMap = new Char2IntArrayMap();
        for (int i = 0; i < RADIX_CHARS.length; i++) {
            char2IntArrayMap.put(RADIX_CHARS[i], i);
        }
        if (char2IntArrayMap.size() != RADIX_CHARS.length) {
            throw new RuntimeException();
        }
        return char2IntArrayMap;
    }


}
