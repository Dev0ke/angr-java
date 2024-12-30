import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP157Tests {
    @Test
    public void example1() {
        String file = "abc";
        int n = 4;
        int expected = 3;

        SolutionP157.Solution solution = new SolutionP157.Solution(file);
        char[] buf = new char[expected];
        int actual = solution.read(buf, n);
        Assertions.assertEquals(expected, actual);
        char[] expectedBuf = file.substring(0, expected).toCharArray();
        Assertions.assertArrayEquals(expectedBuf, buf);
    }

    @Test
    public void example2() {
        String file = "abcde";
        int n = 5;
        int expected = 5;

        SolutionP157.Solution solution = new SolutionP157.Solution(file);
        char[] buf = new char[expected];
        int actual = solution.read(buf, n);
        Assertions.assertEquals(expected, actual);
        char[] expectedBuf = file.substring(0, expected).toCharArray();
        Assertions.assertArrayEquals(expectedBuf, buf);
    }

    @Test
    public void example3() {
        String file = "abcdABCD1234";
        int n = 12;
        int expected = 12;

        SolutionP157.Solution solution = new SolutionP157.Solution(file);
        char[] buf = new char[expected];
        int actual = solution.read(buf, n);
        Assertions.assertEquals(expected, actual);
        char[] expectedBuf = file.substring(0, expected).toCharArray();
        Assertions.assertArrayEquals(expectedBuf, buf);
    }

    @Test
    public void example4() {
        String file = "leetcode";
        int n = 5;
        int expected = 5;

        SolutionP157.Solution solution = new SolutionP157.Solution(file);
        char[] buf = new char[expected];
        int actual = solution.read(buf, n);
        Assertions.assertEquals(expected, actual);
        char[] expectedBuf = file.substring(0, expected).toCharArray();
        Assertions.assertArrayEquals(expectedBuf, buf);
    }
}
