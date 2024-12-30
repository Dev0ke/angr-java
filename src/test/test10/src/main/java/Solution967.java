import java.util.ArrayList;
import java.util.List;

public class Solution967 {
    public int[] numsSameConsecDiff(int n, int k) {
        // 初始化
        // [[1], [2], [3], [4], [5], [6], [7], [8], [9]]
        List<List<Integer>> dpList = new ArrayList<>(List.of(List.of(1), List.of(2), List.of(3),
                List.of(4), List.of(5), List.of(6), List.of(7), List.of(8), List.of(9)));

        while (n > 1) {
            for (int i = 0; i < dpList.size(); i++) {
                // [1] => [10, 12]
                List<Integer> newList = new ArrayList<>();
                for (int num : dpList.get(i)) {
                    int lastNum = num % 10;
                    // k 为 0 时, 数值本身不会变化
                    if (k == 0) {
                        int newNum = num * 10 + lastNum;
                        newList.add(newNum);
                    } else {
                        int nextNum1 = lastNum - k;
                        if (nextNum1 >= 0) {
                            int newNum1 = num * 10 + nextNum1;
                            newList.add(newNum1);
                        }
                        int nextNum2 = lastNum + k;
                        if (nextNum2 <= 9) {
                            int newNum2 = num * 10 + nextNum2;
                            newList.add(newNum2);
                        }
                    }
                }
                dpList.set(i, newList);
            }
            n--;
        }

        // dpList => int[]
        List<Integer> ansList = new ArrayList<>();
        for (List<Integer> list : dpList) {
            ansList.addAll(list);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
/*
967. 连续差相同的数字
https://leetcode.cn/problems/numbers-with-same-consecutive-differences/

第 117 场周赛 T2。

返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
你可以按 任何顺序 返回答案。
提示：
2 <= n <= 9
0 <= k <= 9

动态规划。以 n = 2, k = 1 为例
首位必为 1 - 9，dp 数组可以初始化为：
[[1], [2], [3], [4], [5], [6], [7], [8], [9]]
第 1 轮迭代后，变为：
[[10, 12], [21, 23], [32, 34], [43, 45], [54, 56], [65, 67], [76, 78], [87, 89], [98]]
扩大 n 的取值，当 n = 3 时，下一轮迭代（第 2 轮迭代）为：
[[101, 121, 123], [210, 212, 232, 234], [321, 323, 343, 345], [432, 434, 454, 456], [543, 545, 565, 567], [654, 656, 676, 678], [765, 767, 787, 789], [876, 878, 898], [987, 989]]
 */