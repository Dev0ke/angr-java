import java.util.ArrayList;
import java.util.List;

public class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> resList = new ArrayList<>();
        for (String query : queries) {
            boolean flag = true;
            int j = 0;
            for (int i = 0; i < query.length(); i++) {
                char ch = query.charAt(i);
                if (j < pattern.length() && pattern.charAt(j) == ch) {
                    j++;
                } else if (Character.isUpperCase(ch)) {
                    flag = false;
                    break;
                }
            }
            if (j < pattern.length()) {
                flag = false;
            }
            resList.add(flag);
        }
        return resList;
    }
}
/*
1023. 驼峰式匹配
https://leetcode.cn/problems/camelcase-matching/

如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
提示：
1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
所有字符串都仅由大写和小写英文字母组成。

双指针
时间复杂度 O(nm)
时间复杂度 O(1)
 */