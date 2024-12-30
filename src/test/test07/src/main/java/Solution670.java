public class Solution670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int max = num;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(chars, i, j);
                max = Math.max(max, Integer.parseInt(new String(chars)));
                swap(chars, i, j);
            }
        }
        return max;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
/*
670. 最大交换
https://leetcode.cn/problems/maximum-swap/

给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
注意:
给定数字的范围是 [0, 10^8]

暴力。
 */