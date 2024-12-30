import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1537 {
    public int maxSum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 分别求出 nums1、nums2 的前缀和 时间复杂度 O(n)
        long[] preSum1 = new long[len1 + 1];
        preSum1[0] = 0;
        for (int i = 0; i < len1; i++) {
            preSum1[i + 1] = preSum1[i] + nums1[i];
        }
        long[] preSum2 = new long[len2 + 1];
        preSum2[0] = 0;
        for (int i = 0; i < len2; i++) {
            preSum2[i + 1] = preSum2[i] + nums2[i];
        }

        // 二分搜索找出相等的元素下标 int[] node = {index1, index2} 时间复杂度 O(logn)
        List<int[]> nodeList = new ArrayList<>();
        for (int idx1 = 0; idx1 < len1; idx1++) {
            int curNum = nums1[idx1];
            int idx2 = Arrays.binarySearch(nums2, curNum);
            // nums2 中找得到
            if (idx2 >= 0) {
                nodeList.add(new int[]{idx1, idx2});
            }
        }

        // 统计最大值
        long cnt = 0;
        // 记录上一个相等的下标位置
        int lastIdx1 = 0;
        int lastIdx2 = 0;
        for (int[] node : nodeList) {
            int idx1 = node[0];
            int idx2 = node[1];
            long sum1 = preSum1[idx1] - preSum1[lastIdx1];
            long sum2 = preSum2[idx2] - preSum2[lastIdx2];
            cnt += Math.max(sum1, sum2);
            lastIdx1 = idx1;
            lastIdx2 = idx2;
        }
        // 最后一个节点
        long sum1 = preSum1[len1] - preSum1[lastIdx1];
        long sum2 = preSum2[len2] - preSum2[lastIdx2];
        cnt += Math.max(sum1, sum2);
        return (int) (cnt % 1000000007);
    }
}
/*
1537. 最大得分
https://leetcode.cn/problems/get-the-maximum-score/

第 200 场周赛 T4。

你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
一条 合法路径 定义如下：
- 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
- 从左到右遍历当前数组。
- 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
得分定义为合法路径中不同数字的和。
请你返回所有可能合法路径中的最大得分。
由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
提示：
1 <= nums1.length <= 10^5
1 <= nums2.length <= 10^5
1 <= nums1[i], nums2[i] <= 10^7
nums1 和 nums2 都是严格递增的数组。

@since 2020-08-20 怀念那段日子
很有意思的一道题，前缀和 + 二分搜索即可。
 */