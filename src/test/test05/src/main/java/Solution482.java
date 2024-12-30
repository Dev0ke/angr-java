import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                stack.push(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            cnt = (cnt + 1) % k;
            if (!stack.isEmpty() && cnt == 0) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.reverse().toString().toUpperCase(Locale.ROOT);
    }
}
/*
482. 密钥格式化
https://leetcode.cn/problems/license-key-formatting/

给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
返回 重新格式化的许可密钥 。
提示:
1 <= s.length <= 10^5
s 只包含字母、数字和破折号 '-'.
1 <= k <= 10^4

模拟。
 */