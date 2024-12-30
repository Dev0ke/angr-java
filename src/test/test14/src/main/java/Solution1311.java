import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;

        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        boolean[] vis = new boolean[n];
        vis[id] = true;
        int k = 0;
        List<Integer> fri = new ArrayList<>();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int x = queue.remove();
                if (k == level) {
                    fri.add(x);
                }

                for (int y : friends[x]) {
                    if (!vis[y]) {
                        vis[y] = true;
                        queue.add(y);
                    }
                }
            }
            k++;
            if (k > level) break;
        }

        // 频次统计
        Map<String, Integer> cnt = new HashMap<>();
        for (Integer i : fri) {
            for (String s : watchedVideos.get(i)) {
                cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            }
        }

        // 自定义排序
        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        nodes.sort((o1, o2) -> {
            if (o1.freq == o2.freq) {
                return o1.video.compareTo(o2.video);
            }
            return Integer.compare(o1.freq, o2.freq);
        });
        return nodes.stream().map(o -> o.video).toList();
    }

    private static class Node {
        String video;
        int freq;

        public Node(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }
    }
}
/*
1311. 获取你好友已观看的视频
https://leetcode.cn/problems/get-watched-videos-by-your-friends/description/

有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。
提示：
n == watchedVideos.length == friends.length
2 <= n <= 100
1 <= watchedVideos[i].length <= 100
1 <= watchedVideos[i][j].length <= 8
0 <= friends[i].length < n
0 <= friends[i][j] < n
0 <= id < n
1 <= level < n
如果 friends[i] 包含 j ，那么 friends[j] 包含 i

BFS + 频次统计 + 自定义排序
时间复杂度 O(n + m + vlogv)。其中 n 是人数，m 是好友关系的总数，v 是电影的总数。
 */