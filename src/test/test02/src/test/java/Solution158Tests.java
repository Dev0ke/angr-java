import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution158Tests {
    @Test
    public void example1() {
        String file = "abc";
        int[] queries = {1, 2, 1};
        int[] expected = {1, 2, 0};

        SolutionP158.Solution solution = new SolutionP158.Solution(file);
        for (int i = 0; i < queries.length; i++) {
            char[] buf = new char[expected[i]];
            int actual = solution.read(buf, queries[i]);
            Assertions.assertEquals(expected[i], actual);
            char[] expectedBuf = file.substring(0, expected[i]).toCharArray();
            Assertions.assertArrayEquals(expectedBuf, buf);
            file = file.substring(expected[i]);
        }
    }

    @Test
    public void example2() {
        String file = "abc";
        int[] queries = {4, 1};
        int[] expected = {3, 0};

        SolutionP158.Solution solution = new SolutionP158.Solution(file);
        for (int i = 0; i < queries.length; i++) {
            char[] buf = new char[expected[i]];
            int actual = solution.read(buf, queries[i]);
            Assertions.assertEquals(expected[i], actual);
            char[] expectedBuf = file.substring(0, expected[i]).toCharArray();
            Assertions.assertArrayEquals(expectedBuf, buf);
            file = file.substring(expected[i]);
        }
    }
}
