import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1993Tests {
    @Test
    public void example1() {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        Solution1993.LockingTree lockingTree = new Solution1993.LockingTree(parent);

        // 返回 true ，因为节点 2 未上锁。
        Assertions.assertTrue(lockingTree.lock(2, 2));

        // 节点 2 被用户 2 上锁。
        // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        Assertions.assertFalse(lockingTree.unlock(2, 3));

        // 返回 true ，因为节点 2 之前被用户 2 上锁。
        Assertions.assertTrue(lockingTree.unlock(2, 2));

        // 节点 2 现在变为未上锁状态。
        // 返回 true ，因为节点 4 未上锁。
        Assertions.assertTrue(lockingTree.lock(4, 5));

        // 节点 4 被用户 5 上锁。
        // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
        Assertions.assertTrue(lockingTree.upgrade(0, 1));

        // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
        // 返回 false ，因为节点 0 已经被上锁了。
        Assertions.assertFalse(lockingTree.lock(0, 1));
    }
}