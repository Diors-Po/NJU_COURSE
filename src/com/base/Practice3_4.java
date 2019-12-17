package com.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-31 09:56
 */
public class Practice3_4 {
    public static List<Integer> search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        List<Integer> ans = new ArrayList<>();
        /* A loop to slide pat one by one */
        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        in.nextLine();
        while (caseNum-- > 0) {
            String input = in.nextLine();
            String[] spl = input.split(",");
            String txt = spl[0];
            String pat = spl[1];
            List<Integer> ans = search(txt, pat);
            for (int i = 0; i < ans.size(); i++) {
                if (i == 0)
                    System.out.print(ans.get(i));
                else
                    System.out.print(" " + ans.get(i));
            }
            System.out.println();
        }

    }
}
