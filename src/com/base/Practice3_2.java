package com.base;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-31 09:23
 */
public class Practice3_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while (caseNum-- > 0) {
            int dataLen = in.nextInt();
            int queryLen = in.nextInt();
            ArrayList<Integer> data = new ArrayList<>();
            ArrayList<Integer> query = new ArrayList<>();

            for (int i = 0; i < dataLen; i++) {
                data.add(in.nextInt());
            }
            for (int i = 0; i < queryLen; i++) {
                query.add(in.nextInt());
            }
            for (int i = 0; i < queryLen; i++) {
                int ans = 0;
                for (int j = 0; j < dataLen; j++) {
                    if (data.get(j) % query.get(i) == 0)
                        ans++;
                }
                if (i < queryLen - 1)
                    System.out.print(ans + " ");
                else
                    System.out.println(ans);
            }
        }
    }
}
