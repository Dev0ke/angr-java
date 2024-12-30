public class Solution1556 {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (n != 0) {
            int x = n % 10;
            n /= 10;
            // 右到左
            sb.append(x);
            cnt++;
            if (cnt % 3 == 0) {
                sb.append(".");
            }
        }
        // 第一位不能是 '.'
        if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }
}
/*
1556. 千位分隔数
https://leetcode.cn/problems/thousand-separator/description/

给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
提示：
0 <= n < 2^31

模拟。注意边界条件。
时间复杂度 O(logn)。
 */