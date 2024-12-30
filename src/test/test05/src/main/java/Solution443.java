public class Solution443 {
    public int compress(char[] chars) {
        int len = chars.length;
        int i = 0;
        int j = 0;
        while (i < len) {
            int idx = i;
            while (idx < len && chars[idx] == chars[i]) {
                idx++;
            }
            int cnt = idx - i;
            chars[j] = chars[i];
            j++;
            if (cnt > 1) {
                int start = j;
                int end = j;
                while (cnt != 0) {
                    chars[end] = (char) (cnt % 10 + '0');
                    end++;
                    cnt /= 10;
                }
                reverse(chars, start, end - 1);
                j = end;
            }
            i = idx;
        }
        return j;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
/*
443. 压缩字符串
https://leetcode.cn/problems/string-compression/

给你一个字符数组 chars ，请使用下述算法压缩：
从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
- 如果这一组长度为 1 ，则将字符追加到 s 中。
- 否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
请在 修改完输入数组后 ，返回该数组的新长度。
你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
提示：
1 <= chars.length <= 2000
chars[i] 可以是小写英文字母、大写英文字母、数字或符号

双指针原地算法
时间复杂度 O(n)
空间复杂度 O(1)
 */