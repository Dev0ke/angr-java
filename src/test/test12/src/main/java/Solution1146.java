import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution1146 {
    static class SnapshotArray {
        private final Map<Integer, TreeMap<Integer, Integer>> map;
        private int size;

        public SnapshotArray(int length) {
            map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                map.computeIfAbsent(i, key -> new TreeMap<>()).put(0, 0);
            }
            size = 0;
        }

        public void set(int index, int val) {
            map.get(index).put(size, val);
        }

        public int snap() {
            return size++;
        }

        public int get(int index, int snap_id) {
            return map.get(index).floorEntry(snap_id).getValue();
        }
    }
}
/*
1146. 快照数组
https://leetcode.cn/problems/snapshot-array/

实现支持下列接口的「快照数组」- SnapshotArray：
- SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
- void set(index, val) - 会将指定索引 index 处的元素设置为 val。
- int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
- int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
提示：
1 <= length <= 50000
题目最多进行50000 次set，snap，和 get的调用 。
0 <= index < length
0 <= snap_id < 我们调用 snap() 的总次数
0 <= val <= 10^9

模拟
 */