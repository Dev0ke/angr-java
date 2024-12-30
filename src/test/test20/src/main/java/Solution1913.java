import java.util.Arrays;

public class Solution1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
    }
}
/*
1913. 两个数对之间的最大乘积差
https://leetcode.cn/problems/maximum-product-difference-between-two-pairs/

第 247 场周赛 T1。

两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。
- 例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。
返回以这种方式取得的乘积差中的 最大值 。
提示：
4 <= nums.length <= 10^4
1 <= nums[i] <= 10^4

数组排序后，最大两个数乘积减去最小两个数乘积即可。
梦开始的地方：2021-06-27 首次参加周赛。
 */
