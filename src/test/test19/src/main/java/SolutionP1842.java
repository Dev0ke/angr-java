public class SolutionP1842 {
    public String nextPalindrome(String num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] a = s.substring(0, n / 2).toCharArray();
        if (!nextPermutation(a)) return "";
        String pre = new String(a), suf = new StringBuilder(pre).reverse().toString();
        return pre + (n % 2 == 1 ? s.charAt(n / 2) : "") + suf;
    }

    private boolean nextPermutation(char[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (j >= 0 && a[i] >= a[j]) j--;
        swap(a, i, j);
        reverse(a, i + 1);
        return true;
    }

    private void swap(char[] a, int l, int r) {
        char tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    private void reverse(char[] a, int st) {
        for (int l = st, r = a.length - 1; l < r; l++, r--) {
            swap(a, l, r);
        }
    }
}
/*
$1842. 下个由相同数字构成的回文串
https://leetcode.cn/problems/next-palindrome-using-same-digits/description/

给你一个很长的数字回文串 num ，返回 大于 num、由相同数字重新组合而成的最小 回文串。
如果不存在这样的回文串，则返回空串 ""。
回文串 是正读和反读都一样的字符串。
提示：
1 <= num.length <= 10^5
num 是回文串。

相似题目: 31. 下一个排列
https://leetcode.cn/problems/next-permutation/
 */