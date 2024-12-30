public class Solution1860 {
    public int[] memLeak(int memory1, int memory2) {
        int crashTime;
        for (crashTime = 1; crashTime <= Math.max(memory1, memory2); crashTime++) {
            if (memory1 >= memory2) memory1 -= crashTime;
            else memory2 -= crashTime;
        }
        return new int[]{crashTime, memory1, memory2};
    }
}
/*
1860. 增长的内存泄露
https://leetcode.cn/problems/incremental-memory-leak/description/

给你两个整数 memory1 和 memory2 分别表示两个内存条剩余可用内存的位数。现在有一个程序每秒递增的速度消耗着内存。
在第 i 秒（秒数从 1 开始），有 i 位内存被分配到 剩余内存较多 的内存条（如果两者一样多，则分配到第一个内存条）。如果两者剩余内存都不足 i 位，那么程序将 意外退出 。
请你返回一个数组，包含 [crashTime, memory1crash, memory2crash] ，其中 crashTime是程序意外退出的时间（单位为秒）， memory1crash 和 memory2crash 分别是两个内存条最后剩余内存的位数。
提示：
0 <= memory1, memory2 <= 2^31 - 1

模拟。
时间复杂度 O(sqrt(memory1 + memory2))。
还有数学解法。
 */