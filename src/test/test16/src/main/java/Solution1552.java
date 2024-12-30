import java.util.Arrays;

public class Solution1552 {
    public int maxDistance(int[] position, int m) {
        int len = position.length;
        Arrays.sort(position);

        int left = 0;
        int right = position[len - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(position, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 能否满足 最小磁力为 mid TTTFFF
    private boolean checkMid(int[] position, int m, int mid) {
        int len = position.length;
        int cnt = 1;
        int pre = 0;
        for (int i = 1; i < len; i++) {
            if (position[i] - position[pre] >= mid) {
                pre = i;
                cnt++;
                if (cnt >= m) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
1552. 两球之间的磁力
https://leetcode.cn/problems/magnetic-force-between-two-balls/

在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，
第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
提示：
n == position.length
2 <= n <= 10^5
1 <= position[i] <= 10^9
所有 position 中的整数 互不相同 。
2 <= m <= position.length

二分
 */