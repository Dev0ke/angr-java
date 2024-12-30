import java.util.ArrayList;
import java.util.List;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            for (int j = i + 1; j <= 9; ++j) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        ans.sort(null);
        return ans;
    }
}
/*
1291. 顺次数
https://leetcode.cn/problems/sequential-digits/description/

我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
提示：
10 <= low <= high <= 10^9

枚举。
时间复杂度 O(1)。一共只有 36 个顺次数。
 */