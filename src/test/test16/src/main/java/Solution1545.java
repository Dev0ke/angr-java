import java.util.HashMap;
import java.util.Map;

public class Solution1545 {
    private static final Map<Integer, String> memo = new HashMap<>();

    public char findKthBit(int n, int k) {
        return getSn(n).charAt(k - 1);
    }

    private String getSn(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1) {
            return "0";
        }
        String snSub1 = getSn(n - 1);
        // Si = Si-1 + "1" + reverse(invert(Si-1))
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : snSub1.toCharArray()) {
            stringBuilder.append((ch == '1') ? '0' : '1');
        }
        String sn = snSub1 + "1" + stringBuilder.reverse();
        memo.put(n, sn);
        return sn;
    }
}
/*
1545. 找出第 N 个二进制字符串中的第 K 位
https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/

给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
- S1 = "0"
- 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
例如，符合上述描述的序列的前 4 个字符串依次是：
- S1 = "0"
- S2 = "011"
- S3 = "0111001"
- S4 = "011100110110001"
请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
提示：
1 <= n <= 20
1 <= k <= 2^n - 1

记忆化搜索
 */