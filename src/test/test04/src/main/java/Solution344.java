public class Solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int left = 0; left < len / 2; left++) {
            int right = len - 1 - left;
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
/*
344. 反转字符串
https://leetcode.cn/problems/reverse-string/

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
提示：
1 <= s.length <= 10^5
s[i] 都是 ASCII 码表中的可打印字符

双指针。swap 交换函数，空间复杂度 O(1)
 */