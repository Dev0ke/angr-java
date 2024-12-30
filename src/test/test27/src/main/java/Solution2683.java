public class Solution2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] ori = new int[n];
        // ori[0] = 0
        getOriginal(derived, ori);
        if ((ori[0] ^ ori[n - 1]) == derived[n - 1]) {
            return true;
        }
        // ori[0] = 1
        ori[0] = 1;
        getOriginal(derived, ori);
        return (ori[0] ^ ori[n - 1]) == derived[n - 1];
    }

    private void getOriginal(int[] derived, int[] ori) {
        int n = derived.length;
        for (int i = 1; i < n; i++) {
            ori[i] = ori[i - 1] ^ derived[i - 1];
        }
    }
}
/*
2683. 相邻值的按位异或
https://leetcode.cn/problems/neighboring-bitwise-xor/

第 345 场周赛 T2。

下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。
特别地，对于范围 [0, n - 1] 内的每个下标 i ：
- 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
- 否则 derived[i] = original[i] ⊕ original[i + 1]
给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。
如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。
二进制数组是仅由 0 和 1 组成的数组。

模拟。判断。
original[0] 要么为 0 要么为 1。各尝试一遍即可。
时间复杂度 O(n)
 */