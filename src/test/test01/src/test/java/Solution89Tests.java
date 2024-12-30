import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution89Tests {
    private final Solution89 solution89 = new Solution89();

    @Test
    public void example1() {
        int n = 2;
        List<Integer> expected = Arrays.asList(0, 1, 3, 2);
        // [0,2,3,1] 也是一个有效的格雷码序列
        Assertions.assertEquals(expected, solution89.grayCode(n));
    }

    @Test
    public void example2() {
        int n = 1;
        List<Integer> expected = Arrays.asList(0, 1);
        Assertions.assertEquals(expected, solution89.grayCode(n));
    }
}
