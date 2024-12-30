import java.util.ArrayList;
import java.util.List;

public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> list = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }
        // a/b < c/d
        // ad < bc
        list.sort((o1, o2) -> Integer.compare(o1[0] * o2[1], o1[1] * o2[0]));
        return list.get(k - 1);
    }
}
/*
786. 第 K 个最小的素数分数
https://leetcode.cn/problems/k-th-smallest-prime-fraction/

给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
提示：
2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 10^4
arr[0] == 1
arr[i] 是一个 素数 ，i > 0
arr 中的所有数字 互不相同 ，且按 严格递增 排序
1 <= k <= arr.length * (arr.length - 1) / 2

数据量 1e3，直接 时间复杂度 O(n^2) 暴力即可
 */