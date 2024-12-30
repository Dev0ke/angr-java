import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1146Tests {
    @Test
    public void example1() {
        // 初始化一个长度为 3 的快照数组
        Solution1146.SnapshotArray snapshotArr = new Solution1146.SnapshotArray(3);

        // 令 array[0] = 5
        snapshotArr.set(0, 5);

        // 获取快照，返回 snap_id = 0
        Assertions.assertEquals(0, snapshotArr.snap());

        snapshotArr.set(0, 6);

        // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
        Assertions.assertEquals(5, snapshotArr.get(0, 0));
    }
}
