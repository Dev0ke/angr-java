import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2165 {
    public long smallestNumber(long num) {
        String str = String.valueOf(num);
        int len = str.length();

        if (num == 0L) {
            return num;
        } else if (num < 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < len; i++) {
                list.add(str.charAt(i) - '0');
            }
            // 负数 数字大放前面，降序排列
            list.sort(Comparator.reverseOrder());
            StringBuilder stringBuilder = new StringBuilder("-");
            for (int digit : list) {
                stringBuilder.append(digit);
            }
            return Long.parseLong(stringBuilder.toString());
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(str.charAt(i) - '0');
            }
            // 正数 数字小放前面，保证非 0
            Collections.sort(list);
            StringBuilder stringBuilder = new StringBuilder();
            int firstIdx = 0;
            for (int i = 0; i < len; i++) {
                if (list.get(i) != 0) {
                    stringBuilder.append(list.get(i));
                    firstIdx = i;
                    break;
                }
            }
            for (int i = 0; i < len; i++) {
                if (i != firstIdx) {
                    stringBuilder.append(list.get(i));
                }
            }
            return Long.parseLong(stringBuilder.toString());
        }
    }
}
/*
2165. 重排数字的最小值
https://leetcode.cn/problems/smallest-value-of-the-rearranged-number/

第 279 场周赛 T2。

给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
返回不含前导零且值最小的重排数字。
注意，重排各位数字后，num 的符号不会改变。
提示：
-10^15 <= num <= 10^15

数值范围不大，最多 16 个字符。贪心模拟。
 */