public class Solution1286 {
    static class CombinationIterator {
        int[] pos;
        char[] s;
        boolean finished;

        public CombinationIterator(String characters, int combinationLength) {
            s = characters.toCharArray();
            pos = new int[combinationLength];
            for (int i = 0; i < combinationLength; i++) pos[i] = i;
            finished = false;
        }

        public String next() {
            StringBuilder ans = new StringBuilder();
            for (int p : pos) {
                ans.append(s[p]);
            }
            int i = -1;
            for (int k = pos.length - 1; k >= 0; --k) {
                if (pos[k] != s.length - pos.length + k) {
                    i = k;
                    break;
                }
            }
            if (i == -1) {
                finished = true;
            } else {
                ++pos[i];
                for (int j = i + 1; j < pos.length; ++j) {
                    pos[j] = pos[j - 1] + 1;
                }
            }
            return ans.toString();
        }

        public boolean hasNext() {
            return !finished;
        }
    }
}
/*
1286. 字母组合迭代器
https://leetcode.cn/problems/iterator-for-combination/description/

请你设计一个迭代器类 CombinationIterator ，包括以下内容：
- CombinationIterator(string characters, int combinationLength) 一个构造函数，输入参数包括：用一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
- 函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
- 函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 true
提示：
1 <= combinationLength <= characters.length <= 15
 characters 中每个字符都 不同
每组测试数据最多对 next 和 hasNext 调用 10^4次
题目保证每次调用函数 next 时都存在下一个字母组合。

生成法。
https://leetcode.cn/problems/iterator-for-combination/solutions/101723/zi-mu-zu-he-die-dai-qi-by-leetcode-solution/
时间复杂度: 单次 next() 是 O(k)。
由于长度最大只有 15。也可以在类构造时预处理出全部答案。
 */