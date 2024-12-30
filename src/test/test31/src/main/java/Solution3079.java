public class Solution3079 {
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            int mx = 0;
            String s = String.valueOf(v);
            for (char c : s.toCharArray()) {
                mx = Math.max(mx, c - '0');
            }
            String enc = String.valueOf(mx).repeat(s.length());
            ans += Integer.parseInt(enc);
        }
        return ans;
    }
}
/*
3079. 求出加密整数的和
https://leetcode.cn/problems/find-the-sum-of-encrypted-integers/description/

第 126 场双周赛 T1。

给你一个整数数组 nums ，数组中的元素都是 正 整数。定义一个加密函数 encrypt ，encrypt(x) 将一个整数 x 中 每一个 数位都用 x 中的 最大 数位替换。比方说 encrypt(523) = 555 且 encrypt(213) = 333 。
请你返回数组中所有元素加密后的 和 。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 1000

模拟。
 */