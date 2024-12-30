import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution388Tests {
    private final Solution388 solution388 = new Solution388();

    @Test
    public void example1() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int expected = 20;
        Assertions.assertEquals(expected, solution388.lengthLongestPath(input));
    }

    @Test
    public void example2() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int expected = 32;
        Assertions.assertEquals(expected, solution388.lengthLongestPath(input));
    }

    @Test
    public void example3() {
        String input = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution388.lengthLongestPath(input));
    }

    @Test
    public void example4() {
        String input = "file1.txt\nfile2.txt\nlongfile.txt";
        int expected = 12;
        Assertions.assertEquals(expected, solution388.lengthLongestPath(input));
    }
}
