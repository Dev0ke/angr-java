public class SolutionP3167 {
    public String betterCompression(String compressed) {
        int n = compressed.length();
        int[] cnt = new int[26];
        int i = 0;
        while (i < n) {
            char ch = compressed.charAt(i);
            i++;
            // 分组循环
            int st = i;
            for (i++; i < n && Character.isDigit(compressed.charAt(i)); i++) {
            }
            int c = Integer.parseInt(compressed.substring(st, i));
            cnt[ch - 'a'] += c;
        }

        StringBuilder ans = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (cnt[ch - 'a'] > 0) {
                ans.append(ch).append(cnt[ch - 'a']);
            }
        }
        return ans.toString();
    }
}
/*
$3167. 字符串的更好压缩
https://leetcode.cn/problems/better-compression-of-string/description/

给定一个字符串 compressed 表示一个字符串的压缩版本。格式是一个字符后面加上其出现频率。例如 "a3b1a1c2" 是字符串 "aaabacc" 的一个压缩版本。
我们在以下条件下寻求 更好的压缩：
1.每个字符在压缩版本中只应出现 一次。
2.字符应按 字母顺序 排列。
返回 compressed 的更好压缩版本。
注意：在更好的压缩版本中，字母的顺序可能会改变，这是可以接受的。
提示：
1 <= compressed.length <= 6 * 10^4
compressed 仅由大写英文字母和数字组成。
compressed 是有效的压缩，即，每个字符后面都有其出现频率。
出现频率在 [1, 10^4] 之间并且没有前导 0。

分组循环 模拟。
时间复杂度 O(n + 26)。
 */