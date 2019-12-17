package com.base;
import java.util.*;

public class Practice4_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while(caseNum-- > 0 ){
            int arrLen = in.nextInt();
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<arrLen; i++){
                arr.add(in.nextInt());
            }
            int currMax = arr.get(0);
            int maxSoFar = arr.get(0);
            int[] fw = new int[arrLen];
            int[] bw = new int[arrLen];
            for(int i=1; i<arrLen; i++){
                currMax = Math.max(arr.get(i), currMax+arr.get(i));
                maxSoFar = Math.max(maxSoFar, currMax);
                fw[i] = currMax;
            }
            currMax = maxSoFar = bw[arrLen-1] = arr.get(arrLen-1);
            int i = arrLen - 2;
            while(i>=0){
                currMax = Math.max(arr.get(i), currMax + arr.get(i));
                maxSoFar = Math.max(maxSoFar, currMax);
                bw[i] = currMax;
                i-=1;
            }
            int ans = maxSoFar;
            for(int m = 1; m < arrLen-1; m++)
                ans = Math.max(Math.max(ans, fw[m-1]), bw[m+1]);
            System.out.println(ans);

        }
    }
}
