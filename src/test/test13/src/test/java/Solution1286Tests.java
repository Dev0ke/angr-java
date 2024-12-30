import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1286Tests {
    @Test
    public void example1() {
        // 创建迭代器 iterator
        Solution1286.CombinationIterator iterator = new Solution1286.CombinationIterator("abc", 2);

        // 返回 "ab"
        Assertions.assertEquals("ab", iterator.next());

        // 返回 true
        Assertions.assertTrue(iterator.hasNext());

        // 返回 "ac"
        Assertions.assertEquals("ac", iterator.next());

        // 返回 true
        Assertions.assertTrue(iterator.hasNext());

        // 返回 "bc"
        Assertions.assertEquals("bc", iterator.next());

        // 返回 false
        Assertions.assertFalse(iterator.hasNext());
    }
}