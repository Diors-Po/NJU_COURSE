import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RelativeSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        while (caseNum-- > 0) {
            //arrange
            List<Integer> A1 = new ArrayList<>();
            Map<Integer, Integer> A2 = new LinkedHashMap<>();
            int sizeOfA1 = in.nextInt();
            int sizeOfA2 = in.nextInt();

            //input A1,A2
            while (sizeOfA1-- > 0)
                A1.add(in.nextInt());
            while (sizeOfA2-- > 0)
                A2.put(in.nextInt(), 0);

            List<Integer> extra = new ArrayList<>();//The part in A1, but not in A2

            for (int item : A1) {
                if (A2.containsKey(item))
                    A2.put(item, A2.get(item) + 1);
                else
                    extra.add(item);
            }
            Collections.sort(extra);
            int flag = 0;
            for (int item : A2.keySet()) {
                for (int i = 0; i < A2.get(item); i++) {
                    if (flag == 0)
                        System.out.print(item);
                    else
                        System.out.print(" " + item);
                    flag++;
                }
            }
            for (int item : extra)
                System.out.print(" " + item);

            System.out.println();
        }
    }
}