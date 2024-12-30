import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution466 {
    // https://leetcode.cn/problems/count-the-repetitions/solutions/208874/tong-ji-zhong-fu-ge-shu-by-leetcode-solution/comments/2206124
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int n = s1.length(), m = s2.length();
        List<Integer> cnt = new ArrayList<>();
        int[] mp = new int[m];
        Arrays.fill(mp, -1);
        int k = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == s2.charAt(k % m)) {
                    k++;
                }
            }
            cnt.add(k);
            if (mp[k % m] == -1) {
                mp[k % m] = i;
                continue;
            }
            int v = mp[k % m];
            // a 为一个循环节中 s1 的数量，当前轮次 i 减去上一次 k%m 出现的轮次 mp[k%m]，就是一个循环节经历了多少轮，即 s1 的数量 i - mp[k%m]
            // b 为一个循环节中能够匹配 s2 的字符数（匹配完了又循环回 s2 的开头继续匹配，不断累加的总字符数），显然 cnt[mp[k%m]] 是循环出现时开头多出来的那一段，将其减去就是循环节匹配的字符数 k-cnt[mp[k%m]]
            int a = i - v, b = k - cnt.get(v);
            // 找到了循环节，后面就会出现若干段重复的模式。因为是第 i 轮出现循环，因此后面的轮数为 n1-1-i，
            // 它能出现的完整循环数为 \left \lfloor \frac{n1-1-i}{a} \right \rfloor
            // 每个循环匹配 b 个 s2 的字符，因此可以匹配 res = \left \lfloor \frac{n1-1-i}{a}  \right \rfloor \times b 个 s2 的字符。
            int res = (n1 - 1 - i) / a * b;
            // 最后还剩下 (n1 - 1 - i) % a 个轮次（不完整的循环节），仍然用双指针算法来进行匹配，继续更新 k。匹配完之后 res+=k 得到最终匹配 s2 的字符个数
            // 答案为 m = \left \lfloor \frac{res}{n2\times m} \right \rfloor
            for (int u = 0; u < (n1 - 1 - i) % a; u++) {
                for (int j = 0; j < n; j++) {
                    if (s1.charAt(j) == s2.charAt(k % m)) {
                        k++;
                    }
                }
            }
            res += k;
            return res / m / n2;
        }
        // 如果没有找到循环节，答案就是 \left \lfloor \frac{k}{n2\times m} \right \rfloor
        return k / m / n2;
    }
}
/*
466. 统计重复个数
https://leetcode.cn/problems/count-the-repetitions/description/

定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
- 例如，str == ["abc", 3] =="abcabcabc" 。
如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
- 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
提示：
1 <= s1.length, s2.length <= 100
s1 和 s2 由小写英文字母组成
1 <= n1, n2 <= 10^6

找循环节。
时间复杂度 O(n * m)
 */