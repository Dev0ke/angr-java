import java.util.ArrayList;
import java.util.List;

public class Solution1656 {
    static class OrderedStream {
        String[] stream;
        int ptr;

        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> ans = new ArrayList<>();
            while (ptr < stream.length && stream[ptr] != null) {
                ans.add(stream[ptr]);
                ptr++;
            }
            return ans;
        }
    }
}
/*
1656. 设计有序流
https://leetcode.cn/problems/design-an-ordered-stream/description/

有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
实现 OrderedStream 类：
- OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
- String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
  - 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
  - 否则，返回一个空列表。
提示：
1 <= n <= 1000
1 <= id <= n
value.length == 5
value 仅由小写字母组成
每次调用 insert 都会使用一个唯一的 id
恰好调用 n 次 insert

数组模拟。
 */