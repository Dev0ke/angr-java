import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP379Tests {
    @Test
    public void example1() {
        // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
        SolutionP379.PhoneDirectory directory = new SolutionP379.PhoneDirectory(3);

        // 可以返回任意未分配的号码，这里我们假设它返回 0。
        Assertions.assertEquals(0, directory.get());

        // 假设，函数返回 1。
        Assertions.assertEquals(1, directory.get());

        // 号码 2 未分配，所以返回为 true。
        Assertions.assertTrue(directory.check(2));

        // 返回 2，分配后，只剩一个号码未被分配。
        Assertions.assertEquals(2, directory.get());

        // 此时，号码 2 已经被分配，所以返回 false。
        Assertions.assertFalse(directory.check(2));

        // 释放号码 2，将该号码变回未分配状态。
        directory.release(2);

        // 号码 2 现在是未分配状态，所以返回 true。
        Assertions.assertTrue(directory.check(2));
    }
}
