import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2502Tests {
    @Test
    public void example1() {
        // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
        Solution2502.Allocator loc = new Solution2502.Allocator(10);

        // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
        Assertions.assertEquals(0, loc.allocate(1, 1));

        // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        Assertions.assertEquals(1, loc.allocate(1, 2));

        // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        Assertions.assertEquals(2, loc.allocate(1, 3));

        // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        Assertions.assertEquals(1, loc.free(2));

        // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        Assertions.assertEquals(3, loc.allocate(3, 4));

        // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        Assertions.assertEquals(1, loc.allocate(1, 1));

        // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        Assertions.assertEquals(6, loc.allocate(1, 1));

        // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        Assertions.assertEquals(3, loc.free(1));

        // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        Assertions.assertEquals(-1, loc.allocate(10, 2));

        // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
        Assertions.assertEquals(0, loc.free(7));
    }
}
