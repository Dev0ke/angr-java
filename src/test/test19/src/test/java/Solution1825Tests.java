import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1825Tests {
    @Test
    public void example1() {
        Solution1825.MKAverage obj = new Solution1825.MKAverage(3, 1);

        // 当前元素为 [3]
        obj.addElement(3);

        // 当前元素为 [3,1]
        obj.addElement(1);

        // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        Assertions.assertEquals(-1, obj.calculateMKAverage());

        // 当前元素为 [3,1,10]
        obj.addElement(10);

        // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        Assertions.assertEquals(3, obj.calculateMKAverage());

        // 当前元素为 [3,1,10,5]
        obj.addElement(5);

        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);

        // 当前元素为 [3,1,10,5,5,5]
        obj.addElement(5);

        // 最后 3 个元素为 [5,5,5]
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5
        Assertions.assertEquals(5, obj.calculateMKAverage());
    }
}