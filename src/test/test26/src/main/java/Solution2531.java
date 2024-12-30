public class Solution2531 {
    public boolean isItPossible(String word1, String word2) {
        int[] cntArr1 = new int[26];
        int[] cntArr2 = new int[26];
        for (char ch : word1.toCharArray()) {
            cntArr1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            cntArr2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cntArr1[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (cntArr2[j] == 0) {
                    continue;
                }
                cntArr1[i]--;
                cntArr2[j]--;
                cntArr1[j]++;
                cntArr2[i]++;

                int cnt1 = 0;
                int cnt2 = 0;
                for (int k = 0; k < 26; k++) {
                    if (cntArr1[k] > 0) {
                        cnt1++;
                    }
                    if (cntArr2[k] > 0) {
                        cnt2++;
                    }
                }
                if (cnt1 == cnt2) {
                    return true;
                }

                cntArr1[i]++;
                cntArr2[j]++;
                cntArr1[j]--;
                cntArr2[i]--;
            }
        }
        return false;
    }
}
/*
2531. 使字符串总不同字符的数目相等
https://leetcode.cn/problems/make-number-of-distinct-characters-equal/

第 327 场周赛 T3。

给你两个下标从 0 开始的字符串 word1 和 word2 。
一次 移动 由以下两个步骤组成：
- 选中两个下标 i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ，
- 交换 word1[i] 和 word2[j] 。
如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。
提示：
1 <= word1.length, word2.length <= 10^5
word1 和 word2 仅由小写英文字母组成。

数据量可以允许三层 for 循环暴力模拟。拒绝花里胡哨。
时间复杂度 O(26^3)
注意只移动一次，因此也可优化至 O(26^2)
 */