import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1157Tests {
    @Test
    public void example1() {
        int[] arr = {1, 1, 2, 2, 1, 1};
        Solution1157.MajorityChecker majorityChecker = new Solution1157.MajorityChecker(arr);

        // 返回 1
        Assertions.assertEquals(1, majorityChecker.query(0, 5, 4));

        // 返回 -1
        Assertions.assertEquals(-1, majorityChecker.query(0, 3, 3));

        // 返回 2
        Assertions.assertEquals(2, majorityChecker.query(2, 3, 2));
    }
}