import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;

        Map<String, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String sender = senders[i];
            String message = messages[i];
            int words = message.split(" ").length;
            cntMap.put(sender, cntMap.getOrDefault(sender, 0) + words);
        }

        int max = 0;
        List<String> maxSenders = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxSenders.clear();
                maxSenders.add(entry.getKey());
            } else if (entry.getValue() == max) {
                maxSenders.add(entry.getKey());
            }
        }
        // 如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
        maxSenders.sort(Comparator.reverseOrder());
        return maxSenders.get(0);
    }
}
/*
2284. 最多单词数的发件人
https://leetcode.cn/problems/sender-with-largest-word-count/

第 79 场双周赛 T2。

给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
注意：
- 字典序里，大写字母小于小写字母。
- "Alice" 和 "alice" 是不同的名字。
提示：
n == messages.length == senders.length
1 <= n <= 10^4
1 <= messages[i].length <= 100
1 <= senders[i].length <= 10
messages[i] 包含大写字母、小写字母和 ' ' 。
messages[i] 中所有单词都由 单个空格 隔开。
messages[i] 不包含前导和后缀空格。
senders[i] 只包含大写英文字母和小写英文字母。

HashMap 统计单词数 + 贪心 + 排序
 */