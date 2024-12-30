import java.util.Arrays;

public class SolutionP1151 {
    public int minSwaps(int[] data) {
        int n = data.length;
        int k = Arrays.stream(data).sum();

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += data[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum -= data[i - k];
            sum += data[i];
            maxSum = Math.max(maxSum, sum);
        }
        return k - maxSum;
    }
}
/*
$1151. 最少交换次数来组合所有的 1
https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together/

第 6 场双周赛 T2。

给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
提示：
1 <= data.length <= 10^5
0 <= data[i] <= 1

定长滑动窗口。
时间复杂度 O(n)
相似题目: 2134. 最少交换次数来组合所有的 1 II
https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/
 */