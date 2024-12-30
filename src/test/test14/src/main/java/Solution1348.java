import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1348 {
    static class TweetCounts {
        Map<String, TreeMap<Integer, Integer>> user;

        public TweetCounts() {
            user = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            user.computeIfAbsent(tweetName, e -> new TreeMap<>()).merge(time, 1, Integer::sum);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            endTime++;
            int length = freq2int(freq);
            int[] ans = new int[(endTime - startTime - 1) / length + 1];
            TreeMap<Integer, Integer> mp = user.get(tweetName);
            for (Map.Entry<Integer, Integer> entry : mp.subMap(startTime, endTime).entrySet()) {
                int t = entry.getKey(), cnt = entry.getValue();
                ans[(t - startTime) / length] += cnt;
            }
            return Arrays.stream(ans).boxed().toList();
        }

        private int freq2int(String freq) {
            if (freq.equals("minute")) return 60;
            else if (freq.equals("hour")) return 60 * 60;
            return 60 * 60 * 24;
        }
    }
}
/*
1348. 推文计数
https://leetcode.cn/problems/tweet-counts-per-frequency/description/

一家社交媒体公司正试图通过分析特定时间段内出现的推文数量来监控其网站上的活动。这些时间段可以根据特定的频率（ 每分钟 、每小时 或 每一天 ）划分为更小的 时间段 。
例如，周期 [10,10000] （以 秒 为单位）将被划分为以下频率的 时间块 :
- 每 分钟 (60秒 块)： [10,69], [70,129], [130,189], ..., [9970,10000]
- 每 小时 (3600秒 块)：[10,3609], [3610,7209], [7210,10000]
- 每 天 (86400秒 块)： [10,10000]
注意，最后一个块可能比指定频率的块大小更短，并且总是以时间段的结束时间结束(在上面的示例中为 10000 )。
设计和实现一个API来帮助公司进行分析。
实现 TweetCounts 类:
- TweetCounts() 初始化 TweetCounts 对象。
- 存储记录时间的 tweetName (以秒为单位)。
- List<integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) 返回一个整数列表，表示给定时间 [startTime, endTime] （单位秒）和频率频率中，每个 时间块 中带有 tweetName 的 tweet 的数量。
  - freq 是 “minute” 、 “hour” 或 “day” 中的一个，分别表示 每分钟 、 每小时 或 每一天 的频率。
提示：
0 <= time, startTime, endTime <= 10^9
0 <= endTime - startTime <= 10^4
recordTweet 和 getTweetCountsPerFrequency，最多有 10^4 次操作。

平衡二叉树。
recordTweet() n次 时间复杂度 O(nlogn)。
getTweetCountsPerFrequency() q次 时间复杂度 O(qlogn + tq)。
 */