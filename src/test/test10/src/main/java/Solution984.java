import java.util.Arrays;

public class Solution984 {
    public String strWithout3a3b(int a, int b) {
        if (a <= b) {
            return gen(a, b, "a", "b");
        }
        return gen(b, a, "b", "a");
    }

    // a 做隔板
    private String gen(int a, int b, String strA, String strB) {
        String[] ans = new String[a + 1];
        Arrays.fill(ans, "");
        for (int i = 0; i < Math.min(b, a + 1); i++) {
            ans[i] += strB;
        }
        b -= Math.min(b, a + 1);
        for (int i = 0; i < Math.min(b, a + 1); i++) {
            ans[i] += strB;
        }
        return String.join(strA, ans);
    }
}
/*
984. 不含 AAA 或 BBB 的字符串
https://leetcode.cn/problems/string-without-aaa-or-bbb/description/

给定两个整数 a 和 b ，返回 任意 字符串 s ，要求满足：
- s 的长度为 a + b，且正好包含 a 个 'a' 字母与 b 个 'b' 字母；
- 子串 'aaa' 没有出现在 s 中；
- 子串 'bbb' 没有出现在 s 中。
提示：
0 <= a, b <= 100
对于给定的 a 和 b，保证存在满足要求的 s

构造题，谁数量少 谁做隔板。
时间复杂度 O(max(a,b))
 */