public class Solution1823 {
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    // [0, n-1] 编号
    // k 较小 n 较大时。时间复杂度 O(klogn)
    private int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k == 1) {
            return n - 1;
        }
        if (k > n) {
            return (josephus(n - 1, k) + k) % n;  // 线性算法
        }
        int res = josephus(n - n / k, k);
        res -= n % k;
        if (res < 0) {
            res += n;  // mod n
        } else {
            res += res / (k - 1);  // 还原位置
        }
        return res;
    }
}
/*
1823. 找出游戏的获胜者
https://leetcode.cn/problems/find-the-winner-of-the-circular-game/

第 236 场周赛 T2。

共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。
确切地说，从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
游戏遵循如下规则：
1.从第 1 名小伙伴所在位置 开始 。
2.沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
3.你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
4.如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
5.否则，圈子中最后一名小伙伴赢得游戏。
给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
提示：
1 <= k <= n <= 500
进阶：你能否使用线性时间复杂度和常数空间复杂度解决此问题？

经典问题-约瑟夫环。
 */