import java.util.List;

public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey)) {
                if (ruleValue.equals(item.get(0))) {
                    cnt++;
                }
            } else if ("color".equals(ruleKey)) {
                if (ruleValue.equals(item.get(1))) {
                    cnt++;
                }
            } else {
                if (ruleValue.equals(item.get(2))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1773. 统计匹配检索规则的物品数量
https://leetcode.cn/problems/count-items-matching-a-rule/

第 230 场周赛 T1。

给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
- ruleKey == "type" 且 ruleValue == typei 。
- ruleKey == "color" 且 ruleValue == colori 。
- ruleKey == "name" 且 ruleValue == namei 。
统计并返回 匹配检索规则的物品数量 。
提示：
1 <= items.length <= 10^4
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey 等于 "type"、"color" 或 "name"
所有字符串仅由小写字母组成

根据题意模拟即可。
 */