import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << 9; mask++) {
            if (Integer.bitCount(mask) != k) continue;
            int sum = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if ((mask >> i & 1) == 1) {
                    res.add(i + 1);
                    sum += i + 1;
                }
            }
            if (sum == n) ans.add(res);
        }
        return ans;
    }
}
/*
216. 组合总和 III
https://leetcode.cn/problems/combination-sum-iii/description/

找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
- 只使用数字1到9
- 每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
提示:
2 <= k <= 9
1 <= n <= 60

二进制枚举。
时间复杂度 O(m*2^m)。其中 m = 9。
 */