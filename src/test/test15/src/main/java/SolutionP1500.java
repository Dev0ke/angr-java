import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SolutionP1500 {
    static class FileSharing {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        TreeSet<Integer>[] chunkID2userIDs;
        Map<Integer, List<Integer>> userID2ChunkID;

        public FileSharing(int m) {
            chunkID2userIDs = new TreeSet[m + 1];
            Arrays.setAll(chunkID2userIDs, e -> new TreeSet<>());
            for (int i = 1; i <= m; ++i) {
                q.add(i);
            }
            userID2ChunkID = new HashMap<>();
        }

        public int join(List<Integer> ownedChunks) {
            int userID = q.remove();
            for (int i : ownedChunks) {
                chunkID2userIDs[i].add(userID);
            }
            userID2ChunkID.put(userID, new ArrayList<>(ownedChunks));
            return userID;
        }

        public void leave(int userID) {
            q.add(userID);
            for (int i : userID2ChunkID.getOrDefault(userID, new ArrayList<>())) {
                chunkID2userIDs[i].remove(userID);
            }
        }

        public List<Integer> request(int userID, int chunkID) {
            List<Integer> res = new ArrayList<>(chunkID2userIDs[chunkID]);
            // 更新结果： 插入新的userID
            if (!res.isEmpty()) {
                chunkID2userIDs[chunkID].add(userID);
                userID2ChunkID.computeIfAbsent(userID, e -> new ArrayList<>()).add(chunkID);
            }
            return res;
        }
    }
}
/*
$1500. 设计文件分享系统
https://leetcode.cn/problems/design-a-file-sharing-system/description/

我们需要使用一套文件分享系统来分享一个非常大的文件，该文件由 m 个从 1 到 m 编号的 文件块 组成。
当用户加入系统时，系统应为其注册 一个独有 的 ID。这个独有的 ID 应当被相应的用户使用 一次，但是当用户离开系统时，其 ID 应可以被（后续新注册的用户）再次使用。
用户可以请求文件中的某个指定的文件块，系统应当返回拥有这个文件块的所有用户的 ID。如果用户收到 ID 的非空列表，就表示成功接收到请求的文件块。
实现 FileSharing 类：
- FileSharing(int m) 初始化该对象，文件有 m 个文件块。
- int join(int[] ownedChunks)：一个新用户加入系统，并拥有文件的一些文件块。系统应当为该用户注册一个 ID，该 ID 应是未被其他用户占用的最小正整数。返回注册的 ID。
- void leave(int userID)：ID 为 userID 的用户将离开系统，你不能再从该用户提取文件块了。
- int[] request(int userID, int chunkID)：ID 为 userID 的用户请求编号为 chunkID 的文件块。返回拥有这个文件块的所有用户的 ID 所构成的列表或数组，按升序排列。
提示:
1 <= m <= 10^5
0 <= ownedChunks.length <= min(100, m)
1 <= ownedChunks[i] <= m
ownedChunks 的值是互不相同的。
1 <= chunkID <= m
当你正确地注册用户 ID 时，题目保证 userID 是系统中的一个已注册用户。
join、 leave 和 request 最多被调用 10^4 次。
每次对 leave 的调用都有对应的对 join 的调用。
进阶：
当系统以用户的 IP 地址而不是独有 ID 来识别用户，且用户断开连接后以相同 IP 重新连接系统时，会发生什么？
当用户频繁加入并退出系统，且该用户不请求任何文件块时，你的解决方案仍然保持高效吗？
当所有用户同时加入系统，请求所有文件并离开时，你的解决方案仍然保持高效吗？
如果系统用于分享 n 个文件，其中第  i 个文件由 m[i] 组成，你需要如何修改？

模拟。
 */