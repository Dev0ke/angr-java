import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution146Tests {
    @Test
    public void example1() {
        Solution146.LRUCache lruCache = new Solution146.LRUCache(2);

        // 缓存是 {1=1}
        lruCache.put(1, 1);

        // 缓存是 {1=1, 2=2}
        lruCache.put(2, 2);

        // 返回 1
        Assertions.assertEquals(1, lruCache.get(1));

        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lruCache.put(3, 3);

        // 返回 -1 (未找到)
        Assertions.assertEquals(-1, lruCache.get(2));

        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lruCache.put(4, 4);

        // 返回 -1 (未找到)
        Assertions.assertEquals(-1, lruCache.get(1));

        // 返回 3
        Assertions.assertEquals(3, lruCache.get(3));

        // 返回 4
        Assertions.assertEquals(4, lruCache.get(4));
    }

    @Test
    public void example2() {
        Solution146.LRUCache2 lruCache = new Solution146.LRUCache2(2);

        // 缓存是 {1=1}
        lruCache.put(1, 1);

        // 缓存是 {1=1, 2=2}
        lruCache.put(2, 2);

        // 返回 1
        Assertions.assertEquals(1, lruCache.get(1));

        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lruCache.put(3, 3);

        // 返回 -1 (未找到)
        Assertions.assertEquals(-1, lruCache.get(2));

        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lruCache.put(4, 4);

        // 返回 -1 (未找到)
        Assertions.assertEquals(-1, lruCache.get(1));

        // 返回 3
        Assertions.assertEquals(3, lruCache.get(3));

        // 返回 4
        Assertions.assertEquals(4, lruCache.get(4));
    }
}
