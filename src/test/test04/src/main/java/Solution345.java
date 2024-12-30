public class Solution345 {
    public String reverseVowels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();

        // 双指针
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < len && !isVowel(arr[left])) {
                left++;
            }
            while (right >= 0 && !isVowel(arr[right])) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
/*
345. 反转字符串中的元音字母
https://leetcode.cn/problems/reverse-vowels-of-a-string/

给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
提示：
1 <= s.length <= 3 * 10^5
s 由 可打印的 ASCII 字符组成

双指针反转
 */