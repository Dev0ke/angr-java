public class Solution1523 {
    public int countOdds(int low, int high) {
        int diff = high - low;
        if (diff % 2 == 1) {
            // [奇, 偶] [偶, 奇]
            return (diff + 1) / 2;
        } else {
            // [奇, 奇] [偶, 偶]
            if (low % 2 == 1) {
                return diff / 2 + 1;
            }
            return diff / 2;
        }
    }
}
/*
1523. 在区间范围内统计奇数数目
https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/

给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
提示：
0 <= low <= high <= 10^9

分类讨论
case1: 奇数-偶数 => 差为奇数
case2: 奇数-奇数 => 差为偶数
case3: 偶数-偶数 => 差为偶数
case4: 偶数-奇数 => 差为奇数
 */