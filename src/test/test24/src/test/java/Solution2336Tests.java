import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2336Tests {
    @Test
    public void example1() {
        Solution2336.SmallestInfiniteSet smallestInfiniteSet = new Solution2336.SmallestInfiniteSet();

        // 2 已经在集合中，所以不做任何变更。
        smallestInfiniteSet.addBack(2);

        // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        Assertions.assertEquals(1, smallestInfiniteSet.popSmallest());

        // 返回 2 ，并将其从集合中移除。
        Assertions.assertEquals(2, smallestInfiniteSet.popSmallest());

        // 返回 3 ，并将其从集合中移除。
        Assertions.assertEquals(3, smallestInfiniteSet.popSmallest());

        // 将 1 添加到该集合中。
        smallestInfiniteSet.addBack(1);

        // 返回 1 ，因为 1 在上一步中被添加到集合中，
        // 且 1 是最小的整数，并将其从集合中移除。
        Assertions.assertEquals(1, smallestInfiniteSet.popSmallest());

        // 返回 4 ，并将其从集合中移除。
        Assertions.assertEquals(4, smallestInfiniteSet.popSmallest());

        // 返回 5 ，并将其从集合中移除。
        Assertions.assertEquals(5, smallestInfiniteSet.popSmallest());
    }
}
