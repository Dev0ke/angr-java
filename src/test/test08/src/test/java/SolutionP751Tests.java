import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionP751Tests {
    private final SolutionP751 solutionP751 = new SolutionP751();

    @Test
    public void example1() {
        String ip = "255.0.0.7";
        int n = 10;
        List<String> expected = Arrays.asList("255.0.0.7/32", "255.0.0.8/29", "255.0.0.16/32");
        Assertions.assertEquals(expected, solutionP751.ipToCIDR(ip, n));
    }

    @Test
    public void example2() {
        String ip = "117.145.102.62";
        int n = 8;
        List<String> expected = Arrays.asList("117.145.102.62/31", "117.145.102.64/30", "117.145.102.68/31");
        Assertions.assertEquals(expected, solutionP751.ipToCIDR(ip, n));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/398102758/
        // 官解 WA 的用例
        String ip = "0.0.0.0";
        int n = 2;
        List<String> expected = Arrays.asList("0.0.0.0/31");
        Assertions.assertEquals(expected, solutionP751.ipToCIDR(ip, n));
    }
}