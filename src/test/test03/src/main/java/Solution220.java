import java.util.HashMap;
import java.util.Map;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketId(num, bucketSize);

            if (buckets.containsKey(id)
                    || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
                    || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
                return true;
            }
            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucketId(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketId(int num, int bucketSize) {
        if (num >= 0) {
            return num / bucketSize;
        }
        return (num + 1) / bucketSize - 1;
    }
}
/*
220. 存在重复元素 III
https://leetcode.cn/problems/contains-duplicate-iii/

给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
如果存在则返回 true，不存在返回 false。
提示：
0 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^4
0 <= t <= 2^31 - 1

难度增加，多了 t
桶。时间复杂度 O(n)
 */