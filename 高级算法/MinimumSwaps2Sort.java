import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps2Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            //读入数据
            int N = in.nextInt();
            List<Integer> datas = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                datas.add(in.nextInt());
            }
            System.out.println(minSwaps(datas, N));
        }
    }

    public static int minSwaps(List<Integer> datas, int N) {
        //排序
        List<Integer> sortedDatas = new ArrayList<>(datas);
        Collections.sort(sortedDatas);
        Map<Integer, Integer> valPos = new HashMap<>();
        for (int i = 0; i < N; i++) {
            valPos.put(sortedDatas.get(i), i);
        }

        int ans = 0;
        int[] flags = new int[N];
        for (int i = 0; i < N; i++) {
            //在正确的位置上 或 
            if (datas.get(i) == sortedDatas.get(i) || flags[i] == 1)
                continue;
            int currentVal = datas.get(i);
            int rightPos = valPos.get(currentVal);
            datas.set(i, datas.get(rightPos));
            datas.set(rightPos, currentVal);
            flags[rightPos] = 1;
            ans++;
            i--;
        }
        return ans;
    }


}