import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2193 {
    public int minMovesToMakePalindrome(String s) {
        int len = s.length();

        char[] chars = s.toCharArray();
        int ans = 0;

        // 双指针
        int left = 0;
        int right = len - 1;
        while (left < right) {
            boolean eq = false;
            for (int p = right; p > left; p--) {
                // 最接近右侧的跟左侧相同的字符
                if (chars[p] == chars[left]) {
                    eq = true;
                    while (p < right) {
                        // 模拟交换
                        swap(chars, p, p + 1);
                        p++;
                        ans++;
                    }
                    right--;
                    break;
                }
            }
            if (!eq) {
                ans += len / 2 - left;
            }
            left++;
        }
        return ans;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public int minMovesToMakePalindrome2(String s) {
        int len = s.length();

        // 统计频次
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        // 组间交换
        Map<Character, List<Integer>> leftMap = new HashMap<>();
        Map<Character, List<Integer>> rightMap = new HashMap<>();
        int lCnt = 0;
        int rCnt = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            List<Integer> leftList = leftMap.getOrDefault(ch, new ArrayList<>());
            if (leftList.size() + 1 <= cntArr[ch - 'a'] / 2) {
                lCnt++;
                leftList.add(lCnt);
                leftMap.put(ch, leftList);
                ans += (i - lCnt + 1);
            } else {
                rCnt++;
                List<Integer> rightList = rightMap.getOrDefault(ch, new ArrayList<>());
                rightList.add(rCnt);
                rightMap.put(ch, rightList);
            }
        }
        // 长度为奇数
        if (len % 2 == 1) {
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                if (cntArr[i] % 2 == 1) {
                    lCnt++;
                    List<Integer> leftList = leftMap.getOrDefault(ch, new ArrayList<>());
                    leftList.add(lCnt);
                    leftMap.put(ch, leftList);
                }
            }
        }

        // 得到排列
        int[] perm = new int[(len + 1) / 2];
        for (Map.Entry<Character, List<Integer>> entry : rightMap.entrySet()) {
            char ch = entry.getKey();
            List<Integer> rightList = entry.getValue();
            List<Integer> leftList = leftMap.getOrDefault(ch, new ArrayList<>());
            for (int i = 0; i < rightList.size(); i++) {
                perm[rightList.get(rightList.size() - i - 1) - 1] = leftList.get(i);
            }
        }

        // 组内交换（暴力法求逆序对数）
        int n = perm.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (perm[i] < perm[j]) {
                    cnt++;
                }
            }
        }

        return ans + cnt;
    }
}
/*
2193. 得到回文串的最少操作次数
https://leetcode.cn/problems/minimum-number-of-moves-to-make-palindrome/

第 73 场双周赛 T4。

给你一个只包含小写英文字母的字符串 s 。
每一次 操作 ，你可以选择 s 中两个 相邻 的字符，并将它们交换。
请你返回将 s 变成回文串的 最少操作次数 。
注意 ，输入数据会确保 s 一定能变成一个回文串。
提示：
1 <= s.length <= 2000
s 只包含小写英文字母。
s 可以通过有限次操作得到一个回文串。

原题？https://www.codechef.com/problems/ENCD12 时间复杂度 O(n^2)
如果数据范围拓展为 s.length <= 100000 应该如何解决？ https://www.luogu.com.cn/problem/P5041 时间复杂度 O(nlogn)
 */