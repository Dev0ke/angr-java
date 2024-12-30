public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;

        // maxLeft[i] 代表 [0, i] 区间最大值
        int[] maxLeft = new int[len];
        maxLeft[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        // minRight[i] 代表 [i, len) 区间最小值
        int[] minRight = new int[len];
        minRight[len - 1] = nums[len - 1];
        for (int i = len - 2; i > 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        // left 的长度要尽可能小
        for (int i = 1; i < len; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return 0;
    }
}
/*
915. 分割数组
https://leetcode.cn/problems/partition-array-into-disjoint-intervals/

第 104 场周赛 T2。

给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
- left 中的每个元素都小于或等于 right 中的每个元素。
- left 和 right 都是非空的。
- left 的长度要尽可能小。
在完成这样的分组后返回 left 的 长度 。
用例可以保证存在这样的划分方法。
提示：
2 <= nums.length <= 10^5
0 <= nums[i] <= 10^6
可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。

无需滑动窗口，极值比较即可。
时间复杂度 O(n)
 */