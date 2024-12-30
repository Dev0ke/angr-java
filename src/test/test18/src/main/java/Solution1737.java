import java.util.Arrays;

public class Solution1737 {
    // https://leetcode.cn/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/solutions/573959/czui-jian-qian-zhui-he-hou-zhui-he-jie-f-znoc/
    public int minCharacters(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for (char c : a.toCharArray()) cntA[c - 'a']++;
        for (char c : b.toCharArray()) cntB[c - 'a']++;

        int ans = Integer.MAX_VALUE;
        int sumA = 0, sumB = 0;
        for (int i = 0; i < 25; i++) {
            sumA += cntA[i];
            sumB += cntB[i];
            // 条件三、条件一、条件二
            ans = min(ans, n - cntA[i] + m - cntB[i], n - sumA + sumB, m - sumB + sumA);
        }
        // 条件一、条件二
        ans = Math.min(ans, n - cntA[25] + m - cntB[25]);
        return ans;
    }

    private int min(int... arr) {
        return Arrays.stream(arr).min().orElseThrow();
    }
}
/*
1737. 满足三条件之一需改变的最少字符数
https://leetcode.cn/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/description/

给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
操作的最终目标是满足下列三个条件 之一 ：
- a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
- b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
- a 和 b 都 由 同一个 字母组成。
返回达成目标所需的 最少 操作数。
提示：
1 <= a.length, b.length <= 10^5
a 和 b 只由小写字母组成

字符频次统计 + 枚举。
时间复杂度 O(n+m)。
 */