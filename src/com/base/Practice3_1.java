package com.base;

import java.util.Scanner;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-31 08:57
 */
public class Practice3_1 {
    static void longestlengthsubstring(String S) {
        int N = S.length();
        int max = 0;
        for (int i = 0; i <= N - 2; i++) {
            int l = i;
            int r = i + 1;
            int leftsum = 0;
            int rightsum = 0;
            while (r < N && l >= 0) {
                leftsum += Character.getNumericValue(S.charAt(l));
                rightsum += Character.getNumericValue(S.charAt(r));
                if (leftsum == rightsum) {
                    max = Math.max(max, r - l + 1);
                }
                l--;
                r++;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String S = sc.next();
            longestlengthsubstring(S);
        }
    }
}
