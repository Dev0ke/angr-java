import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution380Tests {
    @Test
    public void example1() {
        // 初始化一个空的集合。
        Solution380.RandomizedSet randomSet = new Solution380.RandomizedSet();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        Assertions.assertTrue(randomSet.insert(1));
        // 返回 false ，表示集合中不存在 2 。
        Assertions.assertFalse(randomSet.remove(2));
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        Assertions.assertTrue(randomSet.insert(2));
        // getRandom 应随机返回 1 或 2 。
        randomSet.getRandom();
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        Assertions.assertTrue(randomSet.remove(1));
        // 2 已在集合中，所以返回 false 。
        Assertions.assertFalse(randomSet.insert(2));
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        Assertions.assertEquals(2, randomSet.getRandom());
    }
}
