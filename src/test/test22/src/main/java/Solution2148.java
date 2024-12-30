import java.util.Arrays;

public class Solution2148 {
    public int countElements(int[] nums) {
        int min = Arrays.stream(nums).min().orElseThrow();
        int max = Arrays.stream(nums).max().orElseThrow();
        int cnt = 0;
        for (int num : nums) {
            if (num > min && num < max) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2148. 元素计数
https://leetcode.cn/problems/count-elements-with-strictly-smaller-and-greater-elements/

第 277 场周赛 T1。

给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。
提示：
1 <= nums.length <= 100
-105 <= nums[i] <= 10^5

先找出最大最小值，然后逐个判断每个数是否 严格小于 最大值 或 严格大于 最小值。
时间复杂度 O(n)
由于数据范围非常小，比赛时直接写成排序 时间复杂度 O(nlogn)
 */