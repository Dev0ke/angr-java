public class Solution2748 {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int[][] cs = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(nums[i]);
            cs[i][0] = s.charAt(0) - '0';
            cs[i][1] = s.charAt(s.length() - 1) - '0';
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (getGCD(cs[i][0], cs[j][1]) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
2748. 美丽下标对的数目
https://leetcode.cn/problems/number-of-beautiful-pairs/

第 351 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
返回 nums 中 美丽下标对 的总数目。
对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 k 最大公因数 。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 9999
nums[i] % 10 != 0

模拟。
时间复杂度 O(n^2)
由于只有 10 各数字，可以预处理到 O(n*10)
 */