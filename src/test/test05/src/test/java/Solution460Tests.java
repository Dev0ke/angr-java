import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution460Tests {
    @Test
    public void example1() {
        // cnt(x) = 键 x 的使用计数
        // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        Solution460.LFUCache lfu = new Solution460.LFUCache(2);

        // cache=[1,_], cnt(1)=1
        lfu.put(1, 1);

        // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.put(2, 2);

        // 返回 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        Assertions.assertEquals(1, lfu.get(1));

        // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.put(3, 3);

        // 返回 -1（未找到）
        Assertions.assertEquals(-1, lfu.get(2));

        // 返回 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        Assertions.assertEquals(3, lfu.get(3));

        // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.put(4, 4);

        // 返回 -1（未找到）
        Assertions.assertEquals(-1, lfu.get(1));

        // 返回 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        Assertions.assertEquals(3, lfu.get(3));

        // 返回 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
        Assertions.assertEquals(4, lfu.get(4));
    }

    @Test
    public void example2() {
        Solution460.LFUCache lfu = new Solution460.LFUCache(0);
        lfu.put(0, 0);
        Assertions.assertEquals(-1, lfu.get(0));
    }
}
