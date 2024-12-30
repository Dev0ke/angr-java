public class Solution3133 {
    public long minEnd(int n, int x) {
        char[] base = ("0".repeat(32) + Integer.toBinaryString(x)).toCharArray();
        String add = Integer.toBinaryString(n - 1);
        int j = base.length - 1;
        for (int i = add.length() - 1; i >= 0; i--) {
            while (base[j] == '1') j--;
            base[j--] = add.charAt(i);
        }
        return Long.parseLong(new String(base), 2);
    }
}
/*
3133. 数组最后一个元素的最小值
https://leetcode.cn/problems/minimum-array-end/description/

第 395 场周赛 T3。

给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
返回 nums[n - 1] 可能的 最小 值。
提示：
1 <= n, x <= 10^8

按位 AND 运算性质，原本二进制为 1 的位不能动，那就在二进制非 1 的位加一。
时间复杂度 O(1)。
 */