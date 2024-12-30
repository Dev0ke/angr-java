import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1152Tests {
    private final SolutionP1152 solutionP1152 = new SolutionP1152();

    @Test
    public void example1() {
        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        List<String> expected = List.of("home", "about", "career");
        Assertions.assertEquals(expected, solutionP1152.mostVisitedPattern(username, timestamp, website));
    }

    @Test
    public void example2() {
        String[] username = {"ua", "ua", "ua", "ub", "ub", "ub"};
        int[] timestamp = {1, 2, 3, 4, 5, 6};
        String[] website = {"a", "b", "a", "a", "b", "c"};
        List<String> expected = List.of("a", "b", "a");
        Assertions.assertEquals(expected, solutionP1152.mostVisitedPattern(username, timestamp, website));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/383857104/
        // 子序列 非 子数组
        String[] username = {"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"};
        int[] timestamp = {436363475, 710406388, 386655081, 797150921};
        String[] website = {"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"};
        List<String> expected = List.of("oz", "mryxsjc", "wlarkzzqht");
        Assertions.assertEquals(expected, solutionP1152.mostVisitedPattern(username, timestamp, website));
    }
}
