import org.junit.jupiter.api.Test;

public class Solution355Tests {
    @Test
    public void example1() {
        Solution355.Twitter twitter = new Solution355.Twitter();

        // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        twitter.postTweet(1, 5);

        // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.getNewsFeed(1);

        // 用户 1 关注了用户 2
        twitter.follow(1, 2);

        // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.postTweet(2, 6);

        // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.getNewsFeed(1);

        // 用户 1 取消关注了用户 2
        twitter.unfollow(1, 2);

        // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
        twitter.getNewsFeed(1);
    }
}
