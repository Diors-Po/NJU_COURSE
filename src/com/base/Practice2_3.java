package com.base;

import java.util.Scanner;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-17 09:56
 */
public class Practice2_3 {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int b[] = new int[n];
            for (int j = 0; j < n; j++)
                b[j] = sc.nextInt();
            findMax(b, n, k);
        }
    }

    static int sum(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    static void findMax(int arr[], int n, int k) {
        int dp[][] = new int[k + 1][n + 1];


        for (int i = 1; i <= n; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        for (int i = 2; i <= k; i++) { // 2 to n boards
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));
                dp[i][j] = best;
            }
        }
        System.out.println(dp[k][n]);
    }
}
