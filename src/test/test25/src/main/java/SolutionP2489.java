import java.util.HashMap;
import java.util.Map;

public class SolutionP2489 {
    public long fixedRatio(String s, int num1, int num2) {
        long ans = 0, a = 0, b = 0;
        Map<Long, Long> mp = new HashMap<>();
        mp.put(0L, 1L);
        for (char c : s.toCharArray()) {
            if (c == '0') a++;
            else b++;
            long key = a * num2 - b * num1;
            ans += mp.getOrDefault(key, 0L);
            mp.merge(key, 1L, Long::sum);
        }
        return ans;
    }
}
/*
$2489. 固定比率的子字符串数
https://leetcode.cn/problems/number-of-substrings-with-fixed-ratio/description/

给定一个二进制字符串 s 和两个整数 num1 和 num2。num1 和 num2 为互质。
比率子串 是 s 的子串，其中子串中 0 的数量与 1 的数量之比正好是 num1 : num2。
- 例如，如果 num1 = 2 和 num2 = 3，那么 "01011" 和 "1110000111" 是比率子串，而 "11000" 不是。
返回 s 的 非空 比率子串的个数。
注意:
- 子串 是字符串中连续的字符序列。
- 如果 gcd(x, y) == 1，则 x 和 y 为 互质，其中 gcd(x, y) 为 x 和 y 的最大公约数。
提示:
1 <= s.length <= 10^5
1 <= num1, num2 <= s.length
num1 和 num2 互质。

https://leetcode.cn/problems/number-of-substrings-with-fixed-ratio/solutions/2021612/gongshihuajian-by-bellyache-93hk/
a 代表当前 0前缀数量，b 代表 1前缀数量
以每个位置结尾的可行子字符串数量就是之前 a∗num2−b∗num1 的数量
 */