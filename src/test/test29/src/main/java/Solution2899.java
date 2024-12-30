import java.util.ArrayList;
import java.util.List;

public class Solution2899 {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> a = new ArrayList<>();
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            if (!word.equals("prev")) {
                a.add(Integer.parseInt(word));
                k = 0;
            } else {
                k++;
                if (k > a.size()) ans.add(-1);
                else ans.add(a.get(a.size() - k));
            }
        }
        return ans;
    }
}
/*
2899. 上一个遍历的整数
https://leetcode.cn/problems/last-visited-integers/description/

第 115 场双周赛 T1。

给你一个下标从 0 开始的字符串数组 words ，其中 words[i] 要么是一个字符串形式的正整数，要么是字符串 "prev" 。
我们从数组的开头开始遍历，对于 words 中的每个 "prev" 字符串，找到 words 中的 上一个遍历的整数 ，定义如下：
- k 表示到当前位置为止的连续 "prev" 字符串数目（包含当前字符串），令下标从 0 开始的 整数 数组 nums 表示目前为止遍历过的所有整数，同时用 nums_reverse 表示 nums 反转得到的数组，那么当前 "prev" 对应的 上一个遍历的整数 是 nums_reverse 数组中下标为 (k - 1) 的整数。
- 如果 k 比目前为止遍历过的整数数目 更多 ，那么上一个遍历的整数为 -1 。
请你返回一个整数数组，包含所有上一个遍历的整数。
提示：
1 <= words.length <= 100
words[i] == "prev" 或 1 <= int(words[i]) <= 100

模拟
 */