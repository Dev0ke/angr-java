import java.util.ArrayList;
import java.util.List;

public class Solution842 {
    private int n;
    private char[] s;
    private List<Integer> ans;

    public List<Integer> splitIntoFibonacci(String num) {
        n = num.length();
        s = num.toCharArray();
        ans = new ArrayList<>();
        dfs(0, 0, 0);
        return ans;
    }

    private boolean dfs(int i, int sum, int pre) {
        if (i == n) {
            return ans.size() >= 3;
        }
        long curLong = 0;
        for (int j = i; j < n; j++) {
            if (j > i && s[i] == '0') {
                break;
            }
            curLong = curLong * 10 + s[j] - '0';
            if (curLong > Integer.MAX_VALUE) {
                break;
            }
            int cur = (int) curLong;
            if (ans.size() >= 2) {
                if (cur < sum) {
                    continue;
                } else if (cur > sum) {
                    break;
                }
            }
            ans.add(cur);
            if (dfs(j + 1, pre + cur, cur)) {
                return true;
            } else {
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}
/*
842. 将数组拆分成斐波那契序列
https://leetcode.cn/problems/split-array-into-fibonacci-sequence/description/

给定一个数字字符串 num，比如 "123456579"，我们可以将它分成「斐波那契式」的序列 [123, 456, 579]。
形式上，斐波那契式 序列是一个非负整数列表 f，且满足：
- 0 <= f[i] < 2^31 ，（也就是说，每个整数都符合 32 位 有符号整数类型）
- f.length >= 3
- 对于所有的0 <= i < f.length - 2，都有 f[i] + f[i + 1] = f[i + 2]
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
返回从 num 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
提示：
1 <= num.length <= 200
num 中只含有数字

回溯。
前两个数确定了，整个序列就确定了。
时间复杂度 O(nlogC)。其中 C 最大不超过 2^31。
相似题目: 306. 累加数
https://leetcode.cn/problems/additive-number/description/
1849. 将字符串拆分为递减的连续值
https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/
 */