import java.util.HashMap;
import java.util.Map;

public class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            int mod = (num % k + k) % k;
            mp.merge(mod, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int t = entry.getKey(), occ = entry.getValue();
            if (t > 0 && mp.getOrDefault(k - t, 0) != occ) {
                return false;
            }
        }
        return mp.getOrDefault(0, 0) % 2 == 0;
    }
}
/*
1497. 检查数组对是否可以被 k 整除
https://leetcode.cn/problems/check-if-array-pairs-are-divisible-by-k/description/

给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
如果存在这样的分法，请返回 True ；否则，返回 False 。
提示：
arr.length == n
1 <= n <= 10^5
n 为偶数
-10^9 <= arr[i] <= 10^9
1 <= k <= 10^5

余数 + 哈希表。
时间复杂度 O(n + k)。
 */