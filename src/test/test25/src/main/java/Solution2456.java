import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;

        // 视频创作者的 流行度
        Map<String, Long> creatorView = new HashMap<>();
        Map<String, Map<String, Long>> creatorIdView = new HashMap<>();
        long maxCreatorView = 0L;

        for (int i = 0; i < n; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            creatorView.put(creator, creatorView.getOrDefault(creator, 0L) + view);
            maxCreatorView = Math.max(maxCreatorView, creatorView.get(creator));

//            Map<String, Long> idView = creatorIdView.getOrDefault(creator, new HashMap<>());
//            idView.put(id, Math.max(idView.getOrDefault(id, 0L), view));
//            creatorIdView.put(creator, idView);
            creatorIdView.computeIfAbsent(creator, key -> new HashMap<>()).merge(id, (long) view, Math::max);
        }

        List<List<String>> resList = new ArrayList<>();
        for (Map.Entry<String, Long> entry : creatorView.entrySet()) {
            if (entry.getValue() == maxCreatorView) {
                long maxView = 0L;
                List<String> idList = new ArrayList<>();
                for (Map.Entry<String, Long> longEntry : creatorIdView.get(entry.getKey()).entrySet()) {
                    if (longEntry.getValue() > maxView) {
                        maxView = longEntry.getValue();
                        idList.clear();
                        idList.add(longEntry.getKey());
                    } else if (longEntry.getValue() == maxView) {
                        idList.add(longEntry.getKey());
                    }
                }
                // 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id
                Collections.sort(idList);
                resList.add(List.of(entry.getKey(), idList.get(0)));
            }
        }
        return resList;
    }
}
/*
2456. 最流行的视频创作者
https://leetcode.cn/problems/most-popular-video-creator/

第 317 场周赛 T2。

给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。
平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
- 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
- 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
提示：
n == creators.length == ids.length == views.length
1 <= n <= 10^5
1 <= creators[i].length, ids[i].length <= 5
creators[i] 和 ids[i] 仅由小写英文字母组成
0 <= views[i] <= 10^5

吐槽：比赛时WA在81/82(Hidden for this testcase during contest.) 相同id的视频居然不合并播放量~有视频网站这么统计么。。
学习一下 Map#merge() 的用法
 */