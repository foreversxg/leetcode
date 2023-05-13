package com.sxg.number;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @author sxg
 * create in 2022/2/2
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while (aLen > 0 || bLen > 0) {
            add += aLen > 0 ? a.charAt(aLen - 1) - '0' : 0;
            add += bLen > 0 ? b.charAt(bLen - 1) - '0' : 0;
            sb.append(add % 2);
            add = add / 2;
            aLen--;
            bLen--;
        }
        if (add > 0) {
            sb.append(add);
        }
        return sb.reverse().toString();

    }
}
