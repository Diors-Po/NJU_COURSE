package com.base;

import java.util.Scanner;

public class Practice2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while (caseNum-- > 0) {
            System.out.println(pow(in.nextLong(), in.nextLong(), in.nextLong()));
        }
    }

    public static long pow(long a, long b, long c) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a % c;
            result %= c;
        }
        return result;
    }
}
