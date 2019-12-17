import java.util.*;

public class Main {

    public static void main(String[] args) {
        //arrange
        Scanner in = new Scanner(System.in);
        int caseN = in.nextInt();
        while (caseN-- > 0) {
            int caseSize = in.nextInt();
            Map<Integer, Integer> data = new TreeMap<>();
            for (int i = 0; i < caseSize; i++) {
                int readInt = in.nextInt();
                if (data.containsKey(readInt))
                    data.put(readInt, data.get(readInt) + 1);
                else
                    data.put(readInt, 1);
            }
            List<Map.Entry<Integer, Integer>> temp = new ArrayList<>(data.entrySet());
            temp.sort((o1, o2) -> {
                if (o1.getValue() > o2.getValue())
                    return -1;
                else if (o1.getValue() < o2.getValue())
                    return 1;
                else
                    return Integer.compare(o1.getKey(), o2.getKey());
            });
            List<Integer> onlyOneElement = new ArrayList<>();
            int flag = 0;
            for (int i = 0; i < temp.size(); i++) {
                int key = temp.get(i).getKey();
                int val = temp.get(i).getValue();
                if (val == 1)
                    onlyOneElement.add(key);
                else {
                    while (val-- > 0) {
                        if (flag == 0) {
                            System.out.print(key);
                            flag = 1;
                        } else
                            System.out.print(" " + key);
                    }
                }
            }
            Collections.sort(onlyOneElement);
            for (int i : onlyOneElement) {
                if (flag == 0) {
                    System.out.print(i);
                    flag = 1;
                } else
                    System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    // public static void main(String[] args) {
    //     Main main = new Main();
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();
    //     for (int i = 0; i < n; i++) {
    //         int num = scanner.nextInt();
    //         int[] arr = new int[num];
    //         for (int j = 0; j < num; j++) {
    //             arr[j] = scanner.nextInt();
    //         }
    //         main.helper(arr);
    //       System.out.println();
    //     }
    // }

    // private void helper(int[] arr) {
    //     Map<Integer, Integer> map = new TreeMap<>();
    //     for (int i : arr) {
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
    //     ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
    //     list.sort((arg0, arg1) -> arg1.getValue() - arg0.getValue());
    //     for (int i = 0; i < list.size(); i++) {
    //         int key = list.get(i).getKey();
    //         int val = list.get(i).getValue();
    //         for (int j = 0; j < val; j++) {
    //             if (i == list.size() - 1 && j == val - 1) {
    //                 System.out.print(key);
    //             } else {
    //                 System.out.print(key + " ");
    //             }
    //         }
    //     }
    // }
}