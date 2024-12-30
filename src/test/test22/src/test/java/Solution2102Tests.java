import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2102Tests {
    @Test
    public void example1() {
        // 初始化系统
        Solution2102.SORTracker tracker = new Solution2102.SORTracker();
        // 添加 name="bradford" 且 score=2 的景点。
        tracker.add("bradford", 2);
        // 添加 name="branford" 且 score=3 的景点。
        tracker.add("branford", 3);
        // 从好带坏的景点为：branford ，bradford 。
        Assertions.assertEquals("branford", tracker.get());
        // 注意到 branford 比 bradford 好，因为它的 评分更高 (3 > 2) 。
        // 这是第 1 次调用 get() ，所以返回最好的景点："branford" 。

        // 添加 name="alps" 且 score=2 的景点。
        tracker.add("alps", 2);
        // 从好到坏的景点为：branford, alps, bradford 。
        Assertions.assertEquals("alps", tracker.get());
        // 注意 alps 比 bradford 好，虽然它们评分相同，都为 2 。
        // 这是因为 "alps" 字典序 比 "bradford" 小。
        // 返回第 2 好的地点 "alps" ，因为当前为第 2 次调用 get() 。

        // 添加 name="orland" 且 score=2 的景点。
        tracker.add("orland", 2);
        // 从好到坏的景点为：branford, alps, bradford, orland 。
        Assertions.assertEquals("bradford", tracker.get());
        // 返回 "bradford" ，因为当前为第 3 次调用 get() 。

        // 添加 name="orlando" 且 score=3 的景点。
        tracker.add("orlando", 3);
        // 从好到坏的景点为：branford, orlando, alps, bradford, orland 。
        Assertions.assertEquals("bradford", tracker.get());
        // 返回 "bradford".

        // 添加 name="alpine" 且 score=2 的景点。
        tracker.add("alpine", 2);
        // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
        Assertions.assertEquals("bradford", tracker.get());
        // 返回 "bradford" 。

        // 从好到坏的景点为：branford, orlando, alpine, alps, bradford, orland 。
        Assertions.assertEquals("orland", tracker.get());
        // 返回 "orland" 。
    }
}
