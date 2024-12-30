import java.util.ArrayList;
import java.util.List;

public class Solution3008 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] txt = s.toCharArray();
        char[] patA = a.toCharArray();
        char[] patB = b.toCharArray();
        List<Integer> idsA = getStartIds(txt, patA, prefix_function(patA));
        List<Integer> idsB = getStartIds(txt, patB, prefix_function(patB));

        List<Integer> ans = new ArrayList<>();
        for (Integer i : idsA) {
            int l = i - k, r = i + k;

            int j0 = lowerBound(idsB, l);
            int j1 = lowerBound(idsB, r + 1);
            if (j0 < j1) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    private List<Integer> getStartIds(char[] txt, char[] pat, int[] pi) {
        List<Integer> res = new ArrayList<>();
        int n = txt.length, m = pat.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == m) {
                res.add(i - j + 1);
                j = pi[j - 1];
            }
        }
        return res;
    }

    private int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
3008. 找出数组中的美丽下标 II
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/description/

第 380 场周赛 T4。

给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。
如果下标 i 满足以下条件，则认为它是一个 美丽下标 ：
- 0 <= i <= s.length - a.length
- s[i..(i + a.length - 1)] == a
- 存在下标 j 使得：
  - 0 <= j <= s.length - b.length
  - s[j..(j + b.length - 1)] == b
  - |j - i| <= k
以数组形式按 从小到大排序 返回美丽下标。
提示：
1 <= k <= s.length <= 5 * 10^5
1 <= a.length, b.length <= 5 * 10^5
s、a、和 b 只包含小写英文字母。

KMP + 二分。KMP 预处理出子串所有出现位置，再二分判定每个起点是否符合要求。
时间复杂度 O(nlogn)
 */