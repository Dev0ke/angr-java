public class SolutionP651 {
    public int maxA(int n) {
        // f[k] 是按键 k 次得到 'A' 的最多数量。
        int[] f = new int[n + 1];
        for (int k = 1; k <= n; k++) {
            f[k] = f[k - 1] + 1;
            for (int x = 0; x < k - 1; x++) {
                f[k] = Math.max(f[k], f[x] * (k - x - 1));
            }
        }
        return f[n];
    }
}
/*
$651. 4键键盘
https://leetcode.cn/problems/4-keys-keyboard/

假设你有一个特殊的键盘包含下面的按键：
- A：在屏幕上打印一个 'A'。
- Ctrl-A：选中整个屏幕。
- Ctrl-C：复制选中区域到缓冲区。
- Ctrl-V：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
现在，你可以 最多 按键 n 次（使用上述四种按键），返回屏幕上最多可以显示 'A' 的个数 。
提示:
1 <= n <= 50

动态规划
时间复杂度 O(n^2)
空间复杂度 O(n)
 */