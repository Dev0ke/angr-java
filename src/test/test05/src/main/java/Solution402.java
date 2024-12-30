import java.util.ArrayDeque;
import java.util.Deque;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && num.charAt(i) < st.peek()) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            st.pop();
        }

        // st => String
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        String ans = sb.reverse().toString().replaceAll("^0+", "");
        return ans.isEmpty() ? "0" : ans;
    }
}
/*
402. 移掉 K 位数字
https://leetcode.cn/problems/remove-k-digits/

给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
提示：
1 <= k <= num.length <= 10^5
num 仅由若干位数字（0 - 9）组成
除了 0 本身之外，num 不含任何前导零

单调栈。
 */