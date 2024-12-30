import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1348Tests {
    @Test
    public void example1() {
        Solution1348.TweetCounts tweetCounts = new Solution1348.TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);

        // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
        tweetCounts.recordTweet("tweet3", 10);

        // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59));

        // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
        expected = List.of(2, 1);
        Assertions.assertEquals(expected, tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));

        // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
        tweetCounts.recordTweet("tweet3", 120);

        // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
        expected = List.of(4);
        Assertions.assertEquals(expected, tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));
    }
}