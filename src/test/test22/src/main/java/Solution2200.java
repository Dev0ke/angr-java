import java.util.ArrayList;
import java.util.List;

public class Solution2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int len = nums.length;

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int start = Math.max(0, i - k);
            int end = Math.min(len - 1, i + k);
            for (int j = start; j <= end; j++) {
                if (nums[j] == key) {
                    resList.add(i);
                    break;
                }
            }
        }
        return resList;
    }
}
/*
2200. 找出数组中的所有 K 近邻下标
https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array/

第 284 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
key 是数组 nums 中的一个整数
1 <= k <= nums.length

模拟。
时间复杂度 O(nk)
 */
