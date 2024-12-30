import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution3092 {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        Map<Integer, Long> cnt = new HashMap<>();
        TreeMap<Long, Integer> vk = new TreeMap<>();
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            // --vk[cnt[x]]
            if (cnt.containsKey(x) && vk.containsKey(cnt.get(x))) {
                if (vk.merge(cnt.get(x), -1, Integer::sum) == 0) {
                    vk.remove(cnt.get(x));
                }
            }
            long newCnt = cnt.merge(x, (long) freq[i], Long::sum);
            // ++vk[newCnt]
            vk.merge(newCnt, 1, Integer::sum);
            ans[i] = vk.lastKey();
        }
        return ans;
    }
}
/*
3092. 最高频率的 ID
https://leetcode.cn/problems/most-frequent-ids/description/

第 390 场周赛 T3。

你需要在一个集合里动态记录 ID 的出现频率。给你两个长度都为 n 的整数数组 nums 和 freq ，nums 中每一个元素表示一个 ID ，对应的 freq 中的元素表示这个 ID 在集合中此次操作后需要增加或者减少的数目。
- 增加 ID 的数目：如果 freq[i] 是正数，那么 freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会添加到集合中。
- 减少 ID 的数目：如果 freq[i] 是负数，那么 -freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会从集合中删除。
请你返回一个长度为 n 的数组 ans ，其中 ans[i] 表示第 i 步操作后出现频率最高的 ID 数目 ，如果在某次操作后集合为空，那么 ans[i] 为 0 。
提示：
1 <= nums.length == freq.length <= 10^5
1 <= nums[i] <= 10^5
-10^5 <= freq[i] <= 10^5
freq[i] != 0
输入保证任何操作后，集合中的元素出现次数不会为负数。

哈希表+平衡树 双射。
时间复杂度 O(nlogn)。
 */