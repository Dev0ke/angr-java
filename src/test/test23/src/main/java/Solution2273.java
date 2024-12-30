import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution2273 {
    public List<String> removeAnagrams(String[] words) {
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            if (stack.isEmpty()) {
                stack.push(word);
            } else {
                String top = stack.pop();
                char[] chars1 = top.toCharArray();
                char[] chars2 = word.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                if (Arrays.equals(chars1, chars2)) {
                    stack.push(top);
                } else {
                    stack.push(top);
                    stack.push(word);
                }
            }
        }

        // Deque<String> => List<String>
        List<String> resList = new ArrayList<>();
        while (!stack.isEmpty()) {
            resList.add(stack.removeLast());
        }
        return resList;
    }
}
/*
2273. 移除字母异位词后的结果数组
https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/

第 293 场周赛 T1。

给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。其中下标 i 需要同时满足下述两个条件：
1. 0 < i < words.length
2. words[i - 1] 和 words[i] 是 字母异位词 。
只要可以选出满足条件的下标，就一直执行这个操作。
在执行所有操作后，返回 words 。可以证明，按任意顺序为每步操作选择下标都会得到相同的结果。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 10
words[i] 由小写英文字母组成

Trick：放在 栈 顶模拟“打擂台”
 */