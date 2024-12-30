import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution355 {
    static class Twitter {
        private final List<Node> tweetIdList;
        private final Map<Integer, Set<Integer>> adj;

        public Twitter() {
            tweetIdList = new ArrayList<>();
            adj = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetIdList.add(new Node(userId, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followSet = adj.getOrDefault(userId, new HashSet<>());
            int sz = 0;
            List<Integer> resList = new ArrayList<>();
            for (int i = tweetIdList.size() - 1; i >= 0 && sz < 10; i--) {
                Node node = tweetIdList.get(i);
                if (followSet.contains(node.userId) || node.userId == userId) {
                    resList.add(node.tweetId);
                    sz++;
                }
            }
            return resList;
        }

        public void follow(int followerId, int followeeId) {
            adj.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            adj.computeIfAbsent(followerId, key -> new HashSet<>()).remove(followeeId);
        }

        private static class Node {
            int userId;
            int tweetId;

            public Node(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
            }
        }
    }

}
/*
355. 设计推特
https://leetcode.cn/problems/design-twitter/

设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
实现 Twitter 类：
- Twitter() 初始化简易版推特对象
- void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
- List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。
新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
- void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
- void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
提示：
1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 10^4
所有推特的 ID 都互不相同
postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 10^4 次

关注/取消关注 本质为 有向图
时间复杂度 postTweet()、follow()、unfollow() O(1); getNewsFeed() O(n)
空间复杂度 postTweet()、follow()、unfollow() O(1); getNewsFeed() O(n) 本题上界为 10^4
 */