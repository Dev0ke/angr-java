import java.util.Arrays;
import java.util.BitSet;

public class Solution268 {
    // 计数排序
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public int missingNumber(int[] nums) {
        int len = nums.length;
        BitSet bitSet = new BitSet(len + 1);
        for (int num : nums) {
            bitSet.set(num, true);
        }
        return bitSet.nextClearBit(0);
    }

    // 利用 位运算 异或性质
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int missingNumber2(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int x : nums) {
            xor ^= x;
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    // 数学 通项公式
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        return n * (n + 1) / 2 - Arrays.stream(nums).sum();
    }
}
/*
268. 丢失的数字
https://leetcode.cn/problems/missing-number/

给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
提示：
n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
nums 中的所有数字都 独一无二
进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

BitSet#nextClearBit() 返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。
 */