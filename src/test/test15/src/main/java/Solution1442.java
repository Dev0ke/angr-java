import java.util.HashMap;
import java.util.Map;

public class Solution1442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<>(); // Sk 的出现次数
        Map<Integer, Integer> tot = new HashMap<>(); // Sk 的下标之和
        int ans = 0, xor_sum = 0;
        for (int k = 0; k < n; k++) {
            int val = arr[k];
            if (cnt.containsKey(xor_sum ^ val)) {
                ans += cnt.get(xor_sum ^ val) * k - tot.get(xor_sum ^ val);
            }
            cnt.merge(xor_sum, 1, Integer::sum);
            tot.merge(xor_sum, k, Integer::sum);
            xor_sum ^= val;
        }
        return ans;
    }
}
/*
1442. 形成两个异或相等数组的三元组数目
https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/

给你一个整数数组 arr 。
现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
a 和 b 定义如下：
- a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
- b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
注意：^ 表示 按位异或 操作。
请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
提示：
1 <= arr.length <= 300
1 <= arr[i] <= 10^8

哈希表 + 异或前缀和 + 贡献法。
时间复杂度 O(n)。
 */