import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String orderStr = new String(chars);
            List<String> list = groupMap.getOrDefault(orderStr, new ArrayList<>());
            list.add(str);
            groupMap.put(orderStr, list);
        }
        return new ArrayList<>(groupMap.values());
    }
}
/*
49. 字母异位词分组
https://leetcode.cn/problems/group-anagrams/

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
提示：
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母

如果单词平均 k 个字母，排序需要 O(klogk)
如果有 n 个单词，空间复杂度 O(nklogk)
UT 写法比较复杂
 */