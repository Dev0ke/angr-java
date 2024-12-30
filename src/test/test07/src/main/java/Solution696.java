import java.util.ArrayList;
import java.util.List;

public class Solution696 {
    public int countBinarySubstrings(String s) {
        // 预处理，01 分片，统计频次
        char pre = s.charAt(0);
        List<Integer> cntList = new ArrayList<>();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == pre) {
                cnt++;
            } else {
                cntList.add(cnt);
                cnt = 1;
                pre = ch;
            }
        }
        cntList.add(cnt);

        // 计数
        int res = 0;
        int sz = cntList.size();
        for (int i = 1; i < sz; i++) {
            res += Math.min(cntList.get(i - 1), cntList.get(i));
        }
        return res;
    }
}
/*
696. 计数二进制子串
https://leetcode.cn/problems/count-binary-substrings/

给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
重复出现（不同位置）的子串也要统计它们出现的次数。
提示：
1 <= s.length <= 10^5
s[i] 为 '0' 或 '1'

01 分片，统计频次，取相邻频次最小值累加
时间复杂度 O(n)
空间复杂度 O(1)
 */