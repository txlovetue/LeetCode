package com.ittx.leetcode;

import java.util.Scanner;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 */
public class LeetCode1071 {
    public static boolean check(String x, String s){
        int len =  s.length() / x.length();
        String base = "";
        for (int j = 1; j <= len; j++){
            base += x;
        }
        return base.equals(s);
    }

    public static String gcdOfStrings(String str1, String str2){
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i){
            if (len1 % i == 0 && len2 % i == 0){
                String substring = str1.substring(0, i);
                System.out.println(check(substring, str1));
                System.out.println(check(substring, str2));
                if (check(substring, str1) && check(substring, str2)){
                    return substring;
                }
            }
        }
        return "没有公约因子";
    }

    public static void main(String[] args) {
        System.out.println("请输入第一个字符串");
        Scanner scanner1 = new Scanner(System.in);
        String str1 = scanner1.next();
        System.out.println("请输入第二个字符串");
        Scanner scanner2 = new Scanner(System.in);
        String str2 = scanner2.next();
        System.out.println(gcdOfStrings(str1, str2));
    }
}
