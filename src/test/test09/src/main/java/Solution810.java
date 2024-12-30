public class Solution810 {
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int v : nums) {
            xor ^= v;
        }
        return xor == 0;
    }
}
/*
810. 黑板异或游戏
https://leetcode.cn/problems/chalkboard-xor-game/description/

黑板上写着一个非负整数数组 nums[i] 。
Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。
并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0 ，这个玩家获胜。
假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
提示：
1 <= nums.length <= 1000
0 <= nums[i] < 2^16

博弈 + 异或性质。
当数组的长度是偶数时，先手 Alice 总能找到一个数字，在擦掉这个数字之后剩余的所有数字异或结果不等于 0。
时间复杂度 O(n)
 */