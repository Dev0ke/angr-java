import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP170Tests {
    @Test
    public void example1() {
        SolutionP170.TwoSum twoSum = new SolutionP170.TwoSum();
        // [] --> [1]
        twoSum.add(1);
        // [1] --> [1,3]
        twoSum.add(3);
        // [1,3] --> [1,3,5]
        twoSum.add(5);
        // 1 + 3 = 4，返回 true
        Assertions.assertTrue(twoSum.find(4));
        // 没有两个整数加起来等于 7 ，返回 false
        Assertions.assertFalse(twoSum.find(7));
    }
}
