import java.util.HashMap;
import java.util.Map;

public class Solution1394 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : arr) {
            cnt.merge(v, 1, Integer::sum);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if (k == v && k > ans) {
                ans = k;
            }
        }
        return ans;
    }
}
/*
1394. 找出数组中的幸运数
https://leetcode.cn/problems/find-lucky-integer-in-an-array/description/

在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
给你一个整数数组 arr，请你从中找出并返回一个幸运数。
- 如果数组中存在多个幸运数，只需返回 最大 的那个。
- 如果数组中不含幸运数，则返回 -1 。
提示：
1 <= arr.length <= 500
1 <= arr[i] <= 500

哈希表 模拟。
时间复杂度 O(n)。
 */