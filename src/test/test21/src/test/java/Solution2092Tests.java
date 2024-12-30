import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2092Tests {
    private final Solution2092 solution2092 = new Solution2092();

    @Test
    public void example1() {
        int n = 6;
        int[][] meetings = UtUtils.stringToInts2("[[1,2,5],[2,3,8],[1,5,10]]");
        int firstPerson = 1;
        List<Integer> expected = List.of(0, 1, 2, 3, 5);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] meetings = UtUtils.stringToInts2("[[3,1,3],[1,2,2],[0,3,3]]");
        int firstPerson = 3;
        List<Integer> expected = List.of(0, 1, 3);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] meetings = UtUtils.stringToInts2("[[3,4,2],[1,2,1],[2,3,1]]");
        int firstPerson = 1;
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    @Test
    public void example4() {
        int n = 6;
        int[][] meetings = {{0, 2, 1}, {1, 3, 1}, {4, 5, 1}};
        int firstPerson = 1;
        List<Integer> expected = List.of(0, 1, 2, 3);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/243033801/
        // 36 / 42 个通过测试用例
        String fileName = "solution2092-example5-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] meetings = UtUtils.loadingInts2(fileName, 1);
        int firstPerson = UtUtils.loadingInt(fileName, 2);
        List<Integer> expected = UtUtils.loadingIntegerList("solution2092-example5-output.txt", 0);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/243018808/
        // 38 / 42 个通过测试用例
        String fileName = "solution2092-example6-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] meetings = UtUtils.loadingInts2(fileName, 1);
        int firstPerson = UtUtils.loadingInt(fileName, 2);
        List<Integer> expected = UtUtils.loadingIntegerList("solution2092-example6-output.txt", 0);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }

    @Test
    public void example7() {
        // https://leetcode.cn/submissions/detail/243032958/
        // 39.40 / 42 个通过测试用例
        String fileName = "solution2092-example7-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] meetings = UtUtils.loadingInts2(fileName, 1);
        int firstPerson = UtUtils.loadingInt(fileName, 2);
        List<Integer> expected = UtUtils.loadingIntegerList("solution2092-example7-output.txt", 0);
        Assertions.assertEquals(expected, solution2092.findAllPeople(n, meetings, firstPerson));
    }
}
