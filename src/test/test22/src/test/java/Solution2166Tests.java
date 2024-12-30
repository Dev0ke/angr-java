import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2166Tests {
    @Test
    public void example1() {
        // bitset = "00000".
        Solution2166.Bitset bs = new Solution2166.Bitset(5);
        // 将 idx = 3 处的值更新为 1 ，此时 bitset = "00010" 。
        bs.fix(3);
        // 将 idx = 1 处的值更新为 1 ，此时 bitset = "01010" 。
        bs.fix(1);
        // 翻转每一位上的值，此时 bitset = "10101" 。
        bs.flip();
        // 返回 False ，bitset 中的值不全为 1 。
        Assertions.assertFalse(bs.all());
        // 将 idx = 0 处的值更新为 0 ，此时 bitset = "00101" 。
        bs.unfix(0);
        // 翻转每一位上的值，此时 bitset = "11010" 。
        bs.flip();
        // 返回 True ，至少存在一位的值为 1 。
        Assertions.assertTrue(bs.one());
        // 将 idx = 0 处的值更新为 0 ，此时 bitset = "01010" 。
        bs.unfix(0);
        // 返回 2 ，当前有 2 位的值为 1 。
        Assertions.assertEquals(2, bs.count());
        // 返回 "01010" ，即 bitset 的当前组成情况。
        Assertions.assertEquals("01010", bs.toString());
    }
}
