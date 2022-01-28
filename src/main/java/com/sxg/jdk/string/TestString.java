package com.sxg.jdk.string;

import java.io.UnsupportedEncodingException;

/**
 * 字符串编解码
 *
 * @author sxg
 * create in 2022/1/25
 */
public class TestString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = "123hahah".getBytes("utf-8");
        decode_utf_8(bytes);
        decode_utf_16(bytes);
        char[] array = "123河南".toCharArray();
        // 汉字utf8编码占3个或者4个字节
        byte[] byte2 = "123河南".getBytes("utf-8");
        System.out.println(new String(array));
    }

    public static void decode_utf_8(byte[] bytes) throws UnsupportedEncodingException {
        System.out.println(new String(bytes, "utf-8"));
    }

    public static void decode_utf_16(byte[] bytes) throws UnsupportedEncodingException {
        System.out.println(new String(bytes, "utf-16"));
    }
}
