import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // 预处理
        Set<Integer> hashSet1 = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();
        for (int i : nums1) {
            hashSet1.add(i);
        }
        for (int i : nums2) {
            hashSet2.add(i);
        }

        List<Integer> answer0 = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>();
        for (int i : hashSet1) {
            if (!hashSet2.contains(i)) {
                answer0.add(i);
            }
        }
        for (int i : hashSet2) {
            if (!hashSet1.contains(i)) {
                answer1.add(i);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(answer0);
        resList.add(answer1);
        return resList;
    }
}
/*
2215. 找出两数组的不同
https://leetcode.cn/problems/find-the-difference-of-two-arrays/

第 286 场周赛 T1。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
- answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
- answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
注意：列表中的整数可以按 任意 顺序返回。
提示：
1 <= nums1.length, nums2.length <= 1000
-1000 <= nums1[i], nums2[i] <= 1000

HashSet 优化每次判断到 O(1)
时间复杂度 o(n)
 */