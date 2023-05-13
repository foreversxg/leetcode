package com.sxg.string;

/**
 * @author sxg
 * create in 2022/2/1
 */
public class Str {


    public static void main(String[] args) {
        String a = "12345".substring(2, 4);
        new Str().strStr("aaaaa", "bbb");
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            // substring S小写
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
