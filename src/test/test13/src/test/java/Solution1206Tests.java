import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1206Tests {
    @Test
    public void example1() {
        Solution1206.Skiplist skiplist = new Solution1206.Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        // 返回 false
        Assertions.assertFalse(skiplist.search(0));
        skiplist.add(4);
        // 返回 true
        Assertions.assertTrue(skiplist.search(1));
        // 返回 false，0 不在跳表中
        Assertions.assertFalse(skiplist.erase(0));
        // 返回 true
        Assertions.assertTrue(skiplist.erase(1));
        // 返回 false，1 已被擦除
        Assertions.assertFalse(skiplist.search(1));
    }
}
