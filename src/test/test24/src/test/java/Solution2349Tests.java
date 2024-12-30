import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2349Tests {
    @Test
    public void example1() {
        Solution2349.NumberContainers nc = new Solution2349.NumberContainers();
        // 没有数字 10 ，所以返回 -1 。
        Assertions.assertEquals(-1, nc.find(10));

        // 容器中下标为 2 处填入数字 10 。
        nc.change(2, 10);

        // 容器中下标为 1 处填入数字 10 。
        nc.change(1, 10);

        // 容器中下标为 3 处填入数字 10 。
        nc.change(3, 10);

        // 容器中下标为 5 处填入数字 10 。
        nc.change(5, 10);

        // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
        Assertions.assertEquals(1, nc.find(10));

        // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
        nc.change(1, 20);

        // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
        Assertions.assertEquals(2, nc.find(10));
    }
}
