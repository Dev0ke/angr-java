import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1363 {
    private static final int INF = (int) 1e9;
    private int[] digits;
    private Map<Long, Integer> memo;
    private StringBuilder ans;

    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        Arrays.sort(digits);
        this.digits = digits;

        memo = new HashMap<>();
        int res = dfs(n - 1, 0);
        if (res == 0) return "";

        ans = new StringBuilder();
        make_ans(n - 1, 0);
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }

    private int dfs(int x, int s) {
        if (x < 0) return s != 0 ? -INF : 0;
        long key = (long) x << 31 | s;
        if (memo.containsKey(key)) return memo.get(key);
        int res1 = dfs(x - 1, s);
        int res2 = dfs(x - 1, (digits[x] + s) % 3) + 1;
        int res = Math.max(res1, res2);
        memo.put(key, res);
        return res;
    }

    private void make_ans(int x, int s) {
        if (x < 0) return;
        int res1 = dfs(x - 1, s);
        int res2 = dfs(x - 1, (digits[x] + s) % 3) + 1;
        if (res1 > res2) {
            make_ans(x - 1, s);
        } else {
            ans.append(digits[x]);
            make_ans(x - 1, (digits[x] + s) % 3);
        }
    }
}
/*
1363. 形成三的最大倍数
https://leetcode.cn/problems/largest-multiple-of-three/description/

给你一个整数数组 digits，你可以通过按 任意顺序 连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。如果无法得到答案，请返回一个空字符串。返回的结果不应包含不必要的前导零。
提示：
1 <= digits.length <= 10^4
0 <= digits[i] <= 9

时间复杂度 O(nlogn) ？
相似题目: 3149. 找出分数最低的排列
https://leetcode.cn/problems/find-the-minimum-cost-array-permutation/description/
 */