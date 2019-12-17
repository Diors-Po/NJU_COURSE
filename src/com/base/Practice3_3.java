package com.base;

import java.util.Scanner;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-31 09:51
 */
public class Practice3_3 {
    public static void main(String[] args) {
        final String PAT = "12345$54321";

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long pos = in.nextLong();
            if (pos == 0) {
                System.out.println("");
                continue;
            }

            while (pos > PAT.length()) {
                long[] iter = findIter(pos);
                long start = (iter[0] + iter[1]) / 2;
                pos -= start;
            }
            char res;
            if (pos <= 0) {
                res = '$';
            } else {
                res = PAT.charAt((int) pos - 1);
            }
            System.out.println(res);
        }
    }

    private static long[] findIter(long pos) {
        long len = 5;
        int it = 0;
        while (pos > len) {
            it++;
            len = 2 * len + it;
        }
        return new long[]{len, it};
    }
}
