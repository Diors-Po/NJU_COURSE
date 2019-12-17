package com.base;

import java.util.Scanner;

public class Searching_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while (caseNum-- > 0) {
            if (caseNum != 0)
                System.out.println(countNumbers(in.nextLong()));
            else
                System.out.print(countNumbers(in.nextLong()));
        }
    }

    static int countNumbers(long n) {
        int c = 0;

        int limit = (int) Math.sqrt(n);

        int prime[] = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            int p = prime[i];
            int q = prime[i / prime[i]];
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {
                if (Math.pow(i, 8) <= n) {
                    c += 1;
                }
            }
        }

        return c;
    }
}